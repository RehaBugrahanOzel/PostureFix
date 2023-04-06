<template class="button">
  <div :class="wrapper">
    <div :class="text">{{ text }}</div>
  </div>
</template>

<script>
import "../assets/css/style.css";
export default {
  name: "CommonButton",
  props: {
    text: String,
    wrapper: String,
  },
  // created() {
  //   if(wrapper === "light") {

  //   }
  // },
};
</script>

<style scoped>
.button {
  text-align: center;
  display: flex;
  justify-content: center;
  align-items: center;
  border-radius: 8px;
  font-family: "Arial";
  font-style: normal;
  font-weight: 600;
  font-size: 15px;
  line-height: 56px;
}
.light {
  background-color: #ffffff;
  color: #1e232c;
}
.dark {
  background-color: #1e232c;
  color: #ffffff;
}
.grey {
  background-color: #cdcdcd;
  color: #000000;
}
</style>
