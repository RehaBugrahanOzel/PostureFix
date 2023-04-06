<template>
  <div class="wrapper">
    <input
      :type="inputTypeData"
      :placeholder="text"
      :class="
        inputType === 'password' ? 'input-text-password' : 'input-text-txt'
      "
    />
    <div v-if="inputType === 'password'">
      <img
        src="../assets/img/password_hide.png"
        alt="show-password"
        class="show-password"
        @click="showPassword"
        v-if="!src"
      />
      <img
        :src="src"
        alt="show-password"
        class="show-password"
        @click="showPassword"
        v-else
      />
    </div>
  </div>
</template>

<script>
import PasswordHide from "../assets/img/password_hide.png";
import PasswordShow from "../assets/img/password_view.png";
export default {
  props: {
    inputType: String,
    text: String,
  },
  data() {
    return {
      inputTypeData: this.inputType,
      passwordShow: PasswordShow,
      passwordHide: PasswordHide,
      src: this.passwordHide,
    };
  },
  methods: {
    showPassword() {
      if (this.inputTypeData === "password") {
        this.inputTypeData = "text";
        this.src = this.passwordShow;
      } else {
        this.inputTypeData = "password";
        this.src = this.passwordHide;
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
  background-color: #ffffff;
  border-width: 1px 1px 1px 0;
  border-radius: 0 8px 8px 0;
  border-color: #cccccc;
  border-style: solid;
  padding: 16px;
  width: 22px;
  height: 22px;
}
</style>
