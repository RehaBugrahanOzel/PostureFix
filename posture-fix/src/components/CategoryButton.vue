<template class="category-button">
  <div>
    <div>{{ text }}</div>
    <img :src="src" class="img" />
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
  font-size: 36px;
  background-color: #1e232c;
  color: #ffffff;
  box-shadow: 0 4px 8px 0 rgba(0, 0, 0, 0.2);
  transition: 0.3s;
  flex-wrap: wrap;
  flex-direction: row;
  align-items: center;
  justify-content: space-between;
  align-content: center;
  padding: 5px;
}
</style>
