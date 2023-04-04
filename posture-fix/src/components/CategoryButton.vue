<template class="category-button">
  <div>
    <div :class="text">{{ text }}</div>
    <img :src="src" />
  </div>
</template>

<script>
import "../assets/css/style.css";
export default {
  name: "CategoryButton",
  props: {
    text: String,
    src: String,
  },
};
</script>

<style scoped>
.category-button {
  display: flex;
  border-radius: 8px;
  font-family: "Arial";
  font-style: normal;
  font-weight: 600;
  font-size: 15px;
  background-color: #1e232c;
  color: #ffffff;
  box-shadow: 0 4px 8px 0 rgba(0, 0, 0, 0.2);
  transition: 0.3s;
}
</style>
