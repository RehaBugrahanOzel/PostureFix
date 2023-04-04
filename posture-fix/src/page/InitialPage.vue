<template>
  <div>
    <div class="initial">
      <div class="title-section">
        <img src="../assets/img/logo.svg" alt="logo" class="logo" />
        <div class="title">PostureFix</div>
      </div>
      <div class="first-cart">
        <CommonButton
          text="Login"
          class="button"
          wrapper="dark"
          @click="login"
        />
      </div>
      <div class="second-cart">
        <CommonButton text="Register" class="button" wrapper="light" />
      </div>
    </div>
    <LoginTab
      class="login-tab"
      v-if="isLoginActive"
      :isLoginActive="isLoginActive"
      @loginClosed="loginClosed"
    />
  </div>
</template>

<script>
import CommonButton from "../components/CommonButton.vue";
import LoginTab from "../tabs/LoginTab.vue";
import "../assets/css/style.css";
export default {
  name: "InitialPage",
  components: {
    CommonButton,
    LoginTab,
  },
  data() {
    return {
      isLoginActive: false,
    };
  },
  methods: {
    login() {
      this.isLoginActive = true;
    },
    loginClosed(state) {
      this.isLoginActive = state;
    },
  },
};
</script>

<style scoped>
.login-tab {
  background-color: #ffffff;
  position: absolute;
  top: 44px;
  right: 0px;
  bottom: 0px;
  left: 0px;
  border-radius: 32px 32px 0 0;
}
.initial {
  background: #cfe2fa;
  position: absolute;
  top: 0px;
  right: 0px;
  bottom: 0px;
  left: 0px;
}
.title-section {
  position: absolute;
  left: 50%;
  transform: translate(-50%, 0);
  margin-top: 20%;
  display: flex;
  flex-direction: column;
  justify-content: center;
  align-items: center;
}
.logo {
  width: 157px;
  height: 182px;
  margin: 16px;
}
.title {
  font-weight: bolder;
  font-size: 48px;
  line-height: 58px;
  line-height: 100%;
  font-family: "Arial Black";
}
.first-cart {
  position: absolute;
  left: 50%;
  transform: translate(-50%, 0);
  transform: translate(-50%, 0);
  height: 46%;
  max-height: 406px;
  width: 100%;
  bottom: 0;
  background-color: #ffffff;
  display: flex;
  justify-content: center;
  border-radius: 32px 32px 0 0;
}
.first-cart .button {
  width: 80%;
  max-width: 330px;
  height: 56px;
  margin-top: 7%;
}
.second-cart {
  position: absolute;
  left: 50%;
  transform: translate(-50%, 0);
  height: 30%;
  max-height: 287px;
  width: 100%;
  bottom: 0;
  background-color: #000000;
  border-radius: 32px 32px 0 0;
  display: flex;
  justify-content: center;
}
.second-cart .button {
  width: 80%;
  max-width: 330px;
  height: 56px;
  margin: 7%;
}
</style>
