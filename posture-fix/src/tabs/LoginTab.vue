<template>
  <div class="login">
    <div class="header">
      <img
        src="../assets/back-button.svg"
        alt="back-button"
        class="back-button"
        @click="goBack"
      />
      <img src="../assets/logo-mini.svg" alt="logo-mini" class="logo-mini" />
    </div>
    <div class="text">Welcome back! Glad to see you, Again!</div>
    <div class="input-section">
      <CommonInput class="element" text="Enter your email" inputType="text" />
      <CommonInput
        class="element"
        text="Enter your password"
        inputType="password"
      />
      <div class="forgot-password">
        <div>Forgot Password?</div>
      </div>
    </div>
  </div>
</template>

<script>
import CommonInput from "@/components/CommonInput.vue";
export default {
  name: "LoginTab",
  props: {
    isLoginActive: String,
  },
  components: {
    CommonInput,
  },
  methods: {
    goBack() {
      this.$emit("loginClosed", false);
    },
  },
};
</script>

<style scoped>
.login {
  display: flex;
  flex-direction: column;
  align-items: center;
  padding-top: 7px;
}

.input-section {
  display: flex;
  align-items: center;
  justify-content: center;
  width: 100%;
  flex-direction: column;
}
.input-section .element {
  margin-top: 15px;
}

.header {
  display: flex;
  flex-direction: row;
  align-items: center;
  justify-content: center;
}

.back-button {
  width: 41px;
  height: 41px;
  position: absolute;
  left: 0;
  margin: 9px 0 0 23px;
}

.logo-mini {
  width: 51px;
  height: 59px;
}
.text {
  font-weight: normal;
  font-size: 30px;
  line-height: 39px;
  line-height: 100%;
  font-family: "Arial";
  margin: 35px 74px 42px 21px;
}
.forgot-password {
}
</style>
