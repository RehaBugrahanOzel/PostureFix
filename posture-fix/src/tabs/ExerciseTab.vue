<template>
  <div class="exercise">
    <div class="header">
      <img
        src="../assets/img/back-button.svg"
        alt="back-button"
        class="back-button"
        @click="goBack"
      />
    </div>

    <div class="text">{{ categoryName }} Exercises</div>

    <div class="container-wrapper">
      <div class="flex-container" v-for="item in exercisesList" :key="item">
        <ExerciseButton
          class="button"
          :text="item.txt"
          :src="item.img"
          @click="enterExercise(item)"
        ></ExerciseButton>
      </div>
    </div>
  </div>
</template>

<script>
import Core from "../assets/img/body-parts/core.svg";
import Arm from "../assets/img/body-parts/arm.svg";
import Back from "../assets/img/body-parts/back.svg";
import Chest from "../assets/img/body-parts/chest.svg";

import "../assets/css/style.css";

import ExerciseButton from "../components/ExerciseButton.vue";
//import router from "@/router/router";
export default {
  name: "ExerciseTab",
  props: {
    isExerciseActive: String,
    categoryName: String,
  },

  components: {
    ExerciseButton,
  },

  methods: {
    goBack() {
      this.$emit("exerciseClosed", false);
    },
    enterExercise(state, item) {
      this.$emit("exerciseChoosed", state, item);
      //router.push("/exercise");
    },
  },
  data() {
    return {
      exercisesList: [
        { txt: "Leg Extension", img: Core },
        { txt: "Plank Leg Swing", img: Arm },
        { txt: "Side Leg Lift", img: Back },
        { txt: "Single Leg Bridge", img: Chest },
      ],
    };
  },
};
</script>

<style scoped>
.exercise {
  display: flex;
  flex-direction: column;
  align-items: center;
  padding-top: 7px;
  font-family: "Arial";
}

.header {
  display: flex;
  flex-direction: row;
  align-items: center;
  flex-wrap: wrap;
  justify-content: space-evenly;
}

.back-button {
  width: 41px;
  height: 41px;
  position: absolute;
  left: 0;
  margin: 54px 0 0 12px;
}

.text {
  font-weight: normal;
  color: white;
  font-size: 36px;
  line-height: 100%;
  font-family: "Arial Black";
  margin: 62px 0 33px 0;
}

.button {
  width: 90%;
  max-width: 660px;
  height: 150px;
  margin-top: 7%;
  font-size: 24px;
}

.flex-container {
  display: flex;
  flex-wrap: wrap;
  justify-content: center;
  align-items: flex-start;
  align-content: flex-start;
  /* width: 90%;
  height: 80vh; */
  /* overflow: auto;
  flex-direction: row; */
}

.container-wrapper {
  display: flex;
}
</style>
