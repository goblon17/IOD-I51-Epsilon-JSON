<template>
  <div class="vue-template">
    <!-- Navigation -->
    <nav class="navbar shadow bg-white rounded justify-content-between flex-nowrap flex-row fixed-top">
      <div class="container">
        <ul class="nav navbar-nav flex-row float-left">
          <li class="nav-item">
          </li>
        </ul>
        <ul class="nav navbar-nav flex-row float-right">
          <li class="nav-item">
          </li>
        </ul>
      </div>
    </nav>
    <!-- Main -->
    <div class="App">
      <div class="vertical-center">
        <div class="inner-block">
          <router-view />
        </div>
      </div>
    </div>
  </div>
</template>


<style>

#app {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #62478a;
}
a, li {
  list-style-type: none;
}
.vertical-center {
position: absolute;
top: 50%;
left: 50%;
transform: translate(-75%, -50%);
}

.box {
  display: flex;
  justify-content: space-between;
}

</style>