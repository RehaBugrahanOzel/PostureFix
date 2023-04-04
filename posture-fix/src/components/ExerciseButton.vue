<template class="exercise-button">
  <div>
    <div :class="text">{{ text }}</div>
    <img :src="src" />
  </div>
</template>

<script>
import "../assets/css/style.css";
export default {
  name: "ExerciseButton",
  props: {
    text: String,
    src: String,
  },
};
</script>

<style scoped>
.exercise-button {
  display: flex;
  border-radius: 8px;
  font-family: "Arial";
  font-style: normal;
  font-weight: 600;
  font-size: 15px;
  background-color: #ffffff;
  color: black;
  box-shadow: 0 4px 8px 0 rgba(0, 0, 0, 0.2);
  transition: 0.3s;
}
</style>
