import HomePage from "../page/HomePage.vue";
import InitialPage from "../page/InitialPage.vue";
import { createRouter, createWebHistory } from "vue-router";

const routers = [
  {
    path: "/",
    component: InitialPage,
    name: "initial-page",
  },
  {
    path: "/home",
    component: HomePage,
    name: "home-page",
  },
];

const router = createRouter({
  history: createWebHistory(),
  routes: routers,
});

export default router;
