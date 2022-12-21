<template>
  <div class="containerDisplay" @submit.prevent="login">
    <h3> JSON minifier and beautifier </h3>
    <div class="infoTab">
      <div v-if="invalidJsonStatus" class="invalid-json-error">
        <label>
          Input jest nieprawidłowy
        </label>
      </div>
    </div>
    <div class="reset-button" @click="resetValues">
        Reset
      </div>
    <form class>
      <div class="tab-selection">
        <div class="json-tab" @click="changeTab('first')">
          JSON content
          <div class="display-underline" v-if="selectedTab"></div>
          <div class="display-fake-underline" v-if="!selectedTab"></div>
        </div>
        <div class="exception-tab" @click="changeTab('second')">
          Word exceptions
          <div class="display-underline" v-if="!selectedTab"></div>
          <div class="display-fake-underline" v-if="selectedTab"></div>
        </div>
      </div> 
      <div class="content">
        <div class="json-content" v-if="selectedTab">
          <textarea type="text" class="form-control form-control-lg" @keydown="enableTab(event)" v-model="userString" placeholder="JSON" rows="10" cols="150" required />
          <div class="button-panel">
        <button type="submit" v-if="!addingStatus" @click="sendData('beautifier')" class="my-btn left-button">Beatufier</button>
        <button type="submit" v-if="addingStatus" class="my-btn">Beautifying...</button>
        <button type="submit" v-if="!addingStatus" @click="sendData('minifier')" class="my-btn right-button">Minifier</button>
        <button type="submit" v-if="addingStatus" class="my-btn">Minifying...</button>
      </div>
        </div>
        
        <div class="exception-content" v-if="!selectedTab">
          <textarea type="text" class="form-control form-control-lg" @keydown="enableTab(event)" v-model="exceptionString" placeholder="json,keys,seperated,by,comma" rows="10" cols="150"  />
          <br>
          <label>Choose function</label>
        <br>
        <select v-model="exceptionType" @change="sendDataWithExceptions(exceptionType)">
          <option disabled value="">Choose function</option>
          <option>included</option>
          <option>excluded</option>
        </select> 
        </div>
      </div>
      <div class="form-group" v-if="createResponseOutput">
        <textarea type="text" class="form-control form-control-lg" v-model="receivedJson" rows="10" cols="150" />
      </div> 
    </form>

</div>

</template>


<script>
  
  /* eslint-disable */

  export default {
  data () {
    return {
      userString: "",
      addingStatus: false,
      invalidJsonStatus: false,
      createResponseOutput: false,
      receivedJson: "",
      selectedTab: true,
      firstTabActive: true,
      secondTabActive: false,
      exceptionType: 'null',
      exceptionString: "",
      URL: ""
    }
  },
  methods: {
    changeTab(whichTab) {
      if (whichTab === 'first' && this.secondTabActive === true) {
        this.selectedTab = !this.selectedTab
        this.firstTabActive = true
        this.secondTabActive = false
        this.receivedJson = ""
        this.exceptionType = ""
        }

        if (whichTab === 'second' && this.firstTabActive == true) {
          this.selectedTab = !this.selectedTab
          this.secondTabActive = true
          this.firstTabActive = false
          this.receivedJson = ""
        }
    },
    enableTab() {

      if (event.keyCode === 9) {

        var val = this.userString,
            start = this.selectionStart,
            end = this.selectionEnd;

        this.userString = val.substring(start) + '\t'

        this.selectionStart = this.selectionEnd = start + 1;

        event.preventDefault()
    }
  },
  resetValues() {
    this.userString = ""
    this.receivedJson = ""
    this.exceptionType = ""
  },
  async sendDataWithExceptions(exceptionTyped) {

    const rawString = this.userString
    const body = new FormData()
    body.append('rawString', rawString)

    if (exceptionTyped === 'included') {

      try {
          var response = await fetch("https://iod-app-i51.herokuapp.com/api/v1/onlyselected?keys=" + this.exceptionString, {
          method: "POST",
          headers: {
            "Content-Type": "application/json",
            "Access-Control-Allow-Origin": "*",
            "Access-Control-Allow-Methods": "*",
            "Access-Control-Allow-Headers": "*"
          },
          body: this.userString,
          }).then(response => response.json())
          

          this.invalidJsonStatus = false
          this.createResponseOutput = true
          this.receivedJson = JSON.stringify(response, null, "   ")
          
        }
        catch (error) {
          console.error('There was an error!', error)
          this.addingStatus = false
          this.invalidJsonStatus = true
          }
        }

        if (exceptionTyped === 'excluded') {
          try {
          var response = await fetch("https://iod-app-i51.herokuapp.com/api/v1/withoutselected?keys=" + this.exceptionString, {
          method: "POST",
          headers: {
            "Content-Type": "application/json",
            "Access-Control-Allow-Origin": "*",
            "Access-Control-Allow-Methods": "*",
            "Access-Control-Allow-Headers": "*"
          },
          body: this.userString,
          }).then(response => response.json())
          
            this.invalidJsonStatus = false
            this.createResponseOutput = true
            this.receivedJson = JSON.stringify(response, null, "   ")
          
        }
        catch (error) {
          console.error('There was an error!', error)
          this.addingStatus = false
          this.invalidJsonStatus = true
          }
        }
    },
    async sendData(typeOfAction) {

      if (!this.exceptionType) {
        this.sendDataWithExceptions(this.exceptionType)
        return
      }
      const rawString = this.userString
      const body = new FormData()
      body.append('rawString', rawString)


        try {
            var response = await fetch("https://iod-app-i51.herokuapp.com/api/v1/" + typeOfAction, {
            method: "POST",
            headers: {
              "Content-Type": "application/json",
              "Access-Control-Allow-Origin": "*",
              "Access-Control-Allow-Methods": "*",
              "Access-Control-Allow-Headers": "*"
            },
            body: this.userString,
            }).then(response => response.json())
            
          
            if (typeOfAction === "minifier")
              var receivedResponse = JSON.stringify(response)
              this.invalidJsonStatus = false
              this.createResponseOutput = true
              this.receivedJson = receivedResponse
            
              if (typeOfAction === "beautifier") {  
                this.receivedJson = JSON.stringify(response, null, "   ")
              }
            
          }
          catch (error) {
            console.error('There was an error!', error)
            this.addingStatus = false
            this.invalidJsonStatus = true
          }
    }
  }
}
  

  
  
</script>

<style>


.infoTab {
  padding-bottom: 1%;
}

.containerDisplay {
    text-align: center;
    align-items: center;
    justify-content: center;
    display: inline-block;
    float: none;
  }
  .infoTab {
    text-align: center;
  }

  .form-control-lg {
    display: block;
    width: 50%;
    height: calc(1.5em + 0.75rem + 2px);
    padding: 0.375rem 0.75rem;
    font-size: 1rem;
    font-weight: 400;
    line-height: 1.5;
    color: #495057;
    background-color: #fff;
    background-clip: padding-box;
    border: 1px solid #ced4da;
    border-radius: 0.25rem;
    display: inline-block;
    transition: border-color .15s ease-in-out,box-shadow .15s ease-in-out;
}
  .my-btn{
    padding: 0.5rem 1rem;
    font-size: 1.25rem;
    line-height: 1.5;
    border-radius: 0.3rem;
    color: #fff;
    width: 20%;
    background-color: #343a40;
    border-color: #343a40;
    border: 1px solid transparent;
    transition: color .15s ease-in-out,background-color .15s ease-in-out,border-color .15s ease-in-out,box-shadow .15s ease-in-out;
    margin-bottom: 2%;
  }
  .my-btn:hover {
    background-color: #465059;
    transition: color .15s ease-in-out,background-color .15s ease-in-out,border-color .15s ease-in-out,box-shadow .15s ease-in-out;
  }

  #app {
    font-family: Avenir, Helvetica, Arial, sans-serif;
    -webkit-font-smoothing: antialiased;
    -moz-osx-font-smoothing: grayscale;
    text-align: center;
    color: black;
  }

  .left-button {
    margin-right: 2%
  }
  .right-button {
    margin-left: 2%
  }
  .invalid-json-error {
    color: red;
  }
  .reset-button {
    color: green;
    margin-bottom: 2%;
  }
  .reset-button:hover {
    text-decoration: underline;
    cursor: pointer;
  }
  .tab-selection  {
  display: flex;
  font-size: 15px;
  justify-content: space-between;
  cursor: pointer;
  width: 20%;
  padding-bottom: 1%;
  padding-top: 2%;
  margin: auto;
  border-bottom: 2px solid rgb(220,220,220,1);
/* additional code */
}

.display-underline { 
  padding-top: 15%;
  border-bottom:3px solid rgb(0,0,0,1);
}
.display-fake-underline { 
  padding-top: 15%;
  border-bottom:3px solid rgb(255,255,255,1);
}
.exception-tab {
  margin-left: 5%;
}
.json-tab {
  margin-right: 2%;
}
select {
  margin-bottom: 2%;
}
.exception-tab:hover {
  color: #808080;
}
.json-tab:hover {
  color: #808080;

}
</style>

