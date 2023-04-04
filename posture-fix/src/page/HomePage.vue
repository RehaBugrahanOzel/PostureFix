<template>
  <div class="initial">
    <div class="page">
      <div class="burger-button">
        <!--hamburger button-->
      </div>

      <div class="page-image">
        <ExerciseButton class="exercise-button"></ExerciseButton>
      </div>

      <div class="flex-container">
        <CategoryButton class="category-button"></CategoryButton>
        <CategoryButton class="category-button"></CategoryButton>
        <CategoryButton class="category-button"></CategoryButton>
        <CategoryButton class="category-button"></CategoryButton>
        <CategoryButton class="category-button"></CategoryButton>
        <CategoryButton class="category-button"></CategoryButton>
      </div>
    </div>
  </div>
</template>

<script>
import CategoryButton from "../components/CategoryButton.vue";
import ExerciseButton from "@/components/ExerciseButton.vue";
import "../assets/css/style.css";

export default {
  name: "HomePage",
  components: {
    CategoryButton,
    ExerciseButton,
  },
};
</script>

<style>
/* .exercises-tab {
  background-color: ;
  position: absolute;
  top: 44px;
  right: 0px;
  bottom: 0px;
  left: 0px;
  border-radius: 32px 32px 0 0;
} */

.initial {
  background: #cfe2fa;
  position: absolute;
  top: 0px;
  right: 0px;
  bottom: 0px;
  left: 0px;
}

.burger-button {
  margin-left: 0px;
  margin-bottom: 10px;
}

.page-image {
  /* align-items: center; */
}

.flex-container {
  display: flex;
  flex-wrap: wrap;
  justify-content: flex-start;
  align-items: flex-start;
  align-content: flex-start;
  width: 90%;
  height: 80vh;
  overflow: auto;
  flex-direction: row;
}

.category-button {
  width: 169px;
  height: 150px;
}

.exercise-button {
  width: 360x;
  height: 162px;
}

.page {
  display: flex;
  flex-direction: column;
}
</style>
