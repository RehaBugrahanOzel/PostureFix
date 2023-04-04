<template>
  <div class="wrapper">
    <input
      :type="inputTypeData"
      :placeholder="text"
      :class="
        inputType === 'password' ? 'input-text-password' : 'input-text-txt'
      "
    />
    <img
      src="../assets/img/show-password.svg"
      alt="show-password"
      class="show-password"
      v-if="inputType === 'password'"
      @click="showPassword"
    />
  </div>
</template>

<script>
export default {
  props: {
    inputType: String,
    text: String,
  },
  data() {
    return {
      inputTypeData: this.inputType,
    };
  },
  methods: {
    showPassword() {
      if (this.inputTypeData === "password") {
        this.inputTypeData = "text";
      } else {
        this.inputTypeData = "password";

        console.log("tiklandi", this.inputTypeData);
      }
    },
  },
};
</script>

<style scoped>
.wrapper {
  width: 80%;
  max-width: 330px;
  height: 56px;
  display: flex;
}
.input-text-password {
  width: 100%;
  padding: 18px;
  font-size: 15px;
  border-width: 1px 0 1px 1px;
  border-color: #cccccc;
  background-color: #ffffff;
  color: #000000;
  border-style: solid;
  border-radius: 8px 0 0 8px;
  box-shadow: 0px 0px 5px rgba(66, 66, 66, 0);
  text-shadow: 0px 0px 5px rgba(66, 66, 66, 0);
}
.input-text-txt {
  width: 100%;
  padding: 18px;
  font-size: 15px;
  border-width: 1px;
  border-color: #cccccc;
  background-color: #ffffff;
  color: #000000;
  border-style: solid;
  border-radius: 8px;
  box-shadow: 0px 0px 5px rgba(66, 66, 66, 0);
  text-shadow: 0px 0px 5px rgba(66, 66, 66, 0);
}
.show-password {
  border-width: 1px 1px 1px 0;
  border-radius: 0 8px 8px 0;
  border-color: #cccccc;
  border-style: solid;
  padding: 18px;
}
</style>
