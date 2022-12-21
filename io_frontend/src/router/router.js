import { createRouter, createWebHistory} from 'vue-router'
import Mainview from '../components/Main-view.vue'


const routes = [
    {
        path: '/',
        redirect: '/main-view'
    },
    {
        path: '/main-view',
        name: 'Mainview',
        component: Mainview
    }
]


const router = createRouter({
    history: createWebHistory(process.env.BASE_URL),
    routes
})



export default router