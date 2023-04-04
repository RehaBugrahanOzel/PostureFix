<template class="icon-button">
  <img :src="src" />
</template>

<script>
export default {
  name: "CommonIconButton",
  props: {
    src: String,
  },
};
</script>

<style scoped>
.icon-button {
  text-align: center;
  display: flex;
  justify-content: center;
  align-items: center;
  border-radius: 8px;
  background-color: #ffffff;
}
</style>
