<template>
  <div class="initial">
    <div class="page">
      <div class="burger-button">
        <img src="../assets/img/hamburger-icon.svg" class="element" />
      </div>

      <div class="page-image">
        <ExerciseButton
          class="exercise-button"
          :src="exerciseOfTheDayImg"
          :text="exerciseOfTheDayTxt"
        ></ExerciseButton>
      </div>
      <div class="container-wrapper">
        <div class="flex-container" v-for="item in exercisesList" :key="item">
          <CategoryButton
            class="category-button"
            :text="item.txt"
            :src="item.img"
          ></CategoryButton>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
import CategoryButton from "../components/CategoryButton.vue";
import ExerciseButton from "@/components/ExerciseButton.vue";
import ExerciseOfTheDay from "../assets/img/exercise-of-the-day.svg";
import Core from "../assets/img/body-parts/core.svg";
import Arm from "../assets/img/body-parts/arm.svg";
import Back from "../assets/img/body-parts/back.svg";
import Chest from "../assets/img/body-parts/chest.svg";
import FullBody from "../assets/img/body-parts/full-body.svg";
import Leg from "../assets/img/body-parts/leg.svg";
import "../assets/css/style.css";

export default {
  name: "HomePage",
  components: {
    CategoryButton,
    ExerciseButton,
  },
  data() {
    return {
      exerciseOfTheDayImg: ExerciseOfTheDay,
      exerciseOfTheDayTxt: "Exercise of the day",
      exercisesList: [
        { txt: "Core", img: Core },
        { txt: "Arm", img: Arm },
        { txt: "Back", img: Back },
        { txt: "Chest", img: Chest },
        { txt: "Full Body", img: FullBody },
        { txt: "Leg", img: Leg },
      ],
    };
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
  background: linear-gradient(
    0deg,
    rgba(255, 255, 255, 1) 0%,
    rgba(223, 236, 252, 1) 33%,
    rgba(207, 226, 250, 1) 50%,
    rgba(207, 226, 250, 1) 68%
  );
  position: absolute;
  top: 0px;
  right: 0px;
  bottom: 0px;
  left: 0px;
}

.burger-button {
  margin-top: 37px;
  margin-left: 0px;
  margin-bottom: 10px;
  width: 90%;
  display: flex;
  justify-content: flex-start;
  align-items: center;
}

.page-image {
  max-width: 360px;
  max-height: 162px;
  margin-bottom: 49px;
}

.flex-container {
  display: flex;
  flex-wrap: wrap;
  justify-content: space-between;
  align-items: flex-start;
  align-content: flex-start;
  /* width: 90%;
  height: 80vh; */
  overflow: auto;
  flex-direction: row;
}

.container-wrapper {
  display: flex;
  flex-wrap: wrap;
  justify-content: space-evenly;
}

.category-button {
  width: 169px;
  height: 150px;
  margin: 5px;
}

.exercise-button {
  width: 300x;
  height: 162px;
}

.page {
  display: flex;
  flex-direction: column;
  align-items: center;
}
</style>
