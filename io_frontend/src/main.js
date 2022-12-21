import { createApp } from 'vue'
import App from './App.vue'
import 'bootstrap/dist/css/bootstrap.min.css'
import router from './router/router'
import VueResource from "vue-resource"
import '@/assets/css/main.css'


let app = createApp(App)

app.use(router)
    .mount('#app')
    .use(router)
    .use(VueResource)
