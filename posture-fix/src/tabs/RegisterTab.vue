<template>
  <div class="register">
    <div class="header">
      <img
        src="../assets/img/back-button.svg"
        alt="back-button"
        class="back-button"
        @click="goBack"
      />
      <img
        src="../assets/img/logo-mini-light.svg"
        alt="logo-mini"
        class="logo-mini"
      />
    </div>
    <div class="text">Welcome to PostureFix! Register to start moving!</div>
    <div class="input-section">
      <CommonInput class="element" text="Username" inputType="text" />
      <CommonInput class="element" text="Enter your email" inputType="text" />
      <CommonInput class="element" text="Password" inputType="password" />
      <CommonInput
        class="element"
        text="Confirm password"
        inputType="password"
      />
    </div>
    <CommonButton
      text="Agree and Register"
      class="button"
      wrapper="grey"
      @click="register"
    />
    <div class="login-options-txt">Or Register With</div>
    <div class="login-options">
      <CommonIconButton :src="facebookIconSrc" class="element" />
      <CommonIconButton :src="googleIconSrc" class="element" />
      <CommonIconButton :src="appleIconSrc" class="element" />
    </div>
  </div>
</template>

<script>
import CommonInput from "@/components/CommonInput.vue";
import CommonButton from "../components/CommonButton.vue";
import CommonIconButton from "../components/CommonIconButton.vue";
import FacebookIcon from "../assets/img/facebook-icon.svg";
import GoogleIcon from "../assets/img/google-icon-light.svg";
import AppleIcon from "../assets/img/apple-icon-light.svg";
import router from "@/router/router";
export default {
  name: "RegisterTab",
  props: {
    isRegisterActive: String,
  },
  components: {
    CommonInput,
    CommonButton,
    CommonIconButton,
  },
  methods: {
    goBack() {
      this.$emit("registerClosed", false);
    },
    register() {
      router.push("/home");
    },
  },
  data() {
    return {
      facebookIconSrc: FacebookIcon,
      googleIconSrc: GoogleIcon,
      appleIconSrc: AppleIcon,
    };
  },
};
</script>

<style scoped>
.register {
  display: flex;
  flex-direction: column;
  align-items: center;
  padding-top: 7px;
  font-family: "Arial";
  overflow: auto;
  flex-direction: column;
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
  color: #ffffff;
  font-weight: normal;
  font-size: 30px;
  line-height: 39px;
  line-height: 100%;
  font-family: "Arial";
  margin: 35px 74px 42px 21px;
}

.button {
  width: 80%;
  max-width: 330px;
  height: 56px;
  margin-top: 7%;
}
.login-options-txt {
  color: #ffffff;
  font-size: 14px;
  margin-top: 30px;
  position: relative;
  max-width: 500px;
}
.login-options-txt:before {
  content: " ";
  display: block;
  height: 1px;
  width: 95px;
  position: absolute;
  top: 50%;
  background: #e8ecf4;
  right: 110px;
}
.login-options-txt:after {
  content: " ";
  height: 1px;
  width: 95px;
  background: #e8ecf4;
  display: block;
  position: absolute;
  top: 50%;
  left: 110px;
}
.login-options {
  margin: 22px 0;
  display: flex;
  flex-direction: row;
  justify-content: space-evenly;
  align-items: center;
}
.login-options .element {
  padding: 15px 40px;
  border-width: 1px;
  border-color: #cccccc;
  border-style: solid;
  width: 26px;
  height: 26px;
  border-radius: 8px;
  margin: 0 4px;
}
</style>
