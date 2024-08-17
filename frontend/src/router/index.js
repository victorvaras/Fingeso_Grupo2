import { createRouter, createWebHistory } from "vue-router";
import HomeView from '../views/homeViews.vue';
import UserSolicitation from '../views/userSolicitation.vue';
import PropertyView from '../views/propertyView.vue';

const router = createRouter({
    history: createWebHistory(import.meta.env.BASE_URL),
    routes: [
        {
            path: '/',
            name: 'home',
            component: HomeView,
            alias: '/inicio',
        },
        {
            path: '/user',
            name: 'user',
            component: UserSolicitation,
        },
        {
            path: '/property/:id',
            name: 'propiedad',
            component: PropertyView,
            props: true,
        }
    ]
});

export default router;