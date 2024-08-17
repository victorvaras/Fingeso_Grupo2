import SubirPropiedad from "@/views/subirPropiedad.vue";
import { createRouter, createWebHistory } from "vue-router";

const router = createRouter({
    history: createWebHistory(import.meta.env.BASE_URL),
    routes: [
        {
            path: '/',
            name: 'home',
            component: () => import('../views/homeViews.vue'),
            alias: '/inicio'
        },
        {
            path: '/user',
            name: 'user',
            component: () => import('../views/userSolicitation.vue'),
        },
        {
            path: '/SubirPropiedad',
            name: 'SubirPropiedad',
            component: ()=> import('../views/subirPropiedad.vue')

        }
    ]
});

export default router;