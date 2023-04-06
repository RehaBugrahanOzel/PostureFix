import HomePage from "../page/HomePage.vue";
import InitialPage from "../page/InitialPage.vue";
import VideoExercisePage from "@/page/VideoExercisePage.vue";
import ForgotPassword from "@/page/ForgotPassword.vue";

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

  {
    path: "/exercise",
    component: VideoExercisePage,
    name: "video-exercise-page",
  },

  {
    path: "/forgotPassword",
    component: ForgotPassword,
    name: "forgot-password-page",
  },
];

const router = createRouter({
  history: createWebHistory(),
  routes: routers,
});

export default router;
