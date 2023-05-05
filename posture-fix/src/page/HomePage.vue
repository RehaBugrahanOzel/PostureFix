<template>
  <div class="initial">
    <div v-if="!videoExerciseActive">
      <div class="burger-button">
        <!--<img src="../assets/img/hamburger-icon.svg" class="element" />-->
        <BurgerMenu></BurgerMenu>
      </div>
      <div class="page" v-if="!isExerciseActive">
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
              @click="exerciseSelected(item.txt)"
            ></CategoryButton>
          </div>
        </div>
      </div>
    </div>
    <ExerciseTab
      class="exercise-tab"
      v-if="isExerciseActive"
      :categoryName="selectedExercise"
      :isExerciseActive="isExerciseActive"
      @exerciseClosed="exerciseClosed"
      @exerciseChoosed="exerciseChoosed"
    >
    </ExerciseTab>
    <VideoExerciseTab
      class="video-exercise-tab"
      v-if="videoExerciseActive"
      :videoExerciseInfo="videoExerciseInfo"
      :videoExerciseActive="videoExerciseActive"
      @videoExerciseClosed="videoExerciseClosed"
    ></VideoExerciseTab>
  </div>
</template>

<script>
import BurgerMenu from "@/components/BurgerMenu.vue";
import CategoryButton from "../components/CategoryButton.vue";
import ExerciseTab from "@/tabs/ExerciseTab.vue";
import VideoExerciseTab from "@/tabs/VideoExerciseTab.vue";
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
    ExerciseTab,
    BurgerMenu,
    VideoExerciseTab,
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

      isExerciseActive: false,
      selectedExercise: "",
      videoExerciseActive: false,
      videoExerciseInfo: {},
    };
  },

  methods: {
    exerciseSelected(item) {
      this.isExerciseActive = true;
      this.selectedExercise = item;
    },

    exerciseClosed(state) {
      this.isExerciseActive = state;
    },
    exerciseChoosed(state, item) {
      this.videoExerciseActive = state;
      this.videoExerciseInfo = item;
      this.isExerciseActive = false;
    },
    videoExerciseClosed(state) {
      this.videoExerciseActive = state;
      this.isExerciseActive = true;
    },
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
  margin-top: 50px;
  margin-left: 2px;
  margin-bottom: 10px;
  width: 40%;
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
  width: 158px;
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

.exercise-tab {
  background-color: #000000;
  position: fixed;
  overflow: scroll;
  top: 60px;
  right: 0px;
  bottom: 0px;
  left: 0px;
  border-radius: 32px 32px 0 0;
  height: -webkit-fill-available;
}
.video-exercise-tab {
  background-color: #ffffff;
  position: absolute;
  top: 44px;
  right: 0px;
  bottom: 0px;
  left: 0px;
  border-radius: 32px 32px 0 0;
}
/* .burger-button.toggle > input {
  display: none;
}

.burger-button > a,
.burger-button.toggle > label {
  border-radius: 2px;
  box-shadow: 0 6px 5px -5px rgba(0, 0, 0, 0.3);
}

.burger-button > a::after,
.burger-button.toggle > label::after {
  content: "";
  float: right;
  margin: 15px 15px 0 0;
  width: 0;
  height: 0;
  border-left: 5px solid transparent;
  border-right: 5px solid transparent;
  border-top: 10px solid #ccc;
}

.burger-button ul {
  list-style-type: none;
  display: block;
  margin: 0;
  padding: 0;
  position: absolute;
  width: 100%;
  box-shadow: 0 6px 5px -5px rgba(0, 0, 0, 0.3);
  overflow: hidden;
}
.burger-button a,
.burger-button.toggle > label {
  display: block;
  padding: 0 0 0 10px;
  text-decoration: none;
  line-height: 40px;
  font-size: 13px;
  text-transform: uppercase;
  font-weight: bold;
  color: #999;
  background-color: #fff;
}
.burger-button li {
  height: 0;
  overflow: hidden;
  transition: all 500ms;
} */
</style>
