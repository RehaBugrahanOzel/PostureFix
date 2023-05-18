<template>
  <div class="video-exercise">
    <div class="header">
      <img
        src="../assets/img/back-button.svg"
        alt="back-button"
        class="back-button"
        @click="goBack"
      />
      <img
        src="../assets/img/logo-mini.svg"
        alt="logo-mini"
        class="logo-mini"
      />
    </div>
    <div class="text">Leg Extention</div>
    <video-player
      class="video-player"
      :src="videoEx"
      controls
      :loop="true"
      :volume="0.6"
      :autoplay="true"
    />
    <div class="info">
      Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod
      tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim
      veniam, quis .
    </div>
    <CommonButton text="Start" class="button" wrapper="dark" @click="start" />
  </div>
</template>

<script>
import VideoEx from "../assets/videos/Rick Astley - Never Gonna Give You Up (Official Music Video).mp4";
import CommonButton from "../components/CommonButton.vue";
import { VideoPlayer } from "@videojs-player/vue";
import "video.js/dist/video-js.css";
export default {
  name: "VideoExerciseTab",
  props: {
    videoExerciseInfo: Object,
    videoExerciseActive: Boolean,
  },
  components: {
    CommonButton,
    VideoPlayer,
  },
  methods: {
    goBack() {
      this.$emit("videoExerciseClosed", false);
    },
    start() {
      androidApp.startCamera("Openning...");
    },
  },
  data() {
    return {
      videoEx: VideoEx,
    };
  },
};
</script>

<style scoped>
.info {
  width: 80%;
  max-width: 330px;
  height: 200px;
  margin-top: 7%;
  font-size: 15px;
  font-family: "Arial";
  border: hidden;
  border-radius: 8px;
  background-color: #cdcdcd;
  padding: 27px;
}
.video-exercise {
  display: flex;
  flex-direction: column;
  align-items: center;
  padding-top: 7px;
  font-family: "Arial";
}
.video-player {
  width: 90%;
  border: hidden;
  border-radius: 8px;
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
  margin: 35px 42px;
}

.button {
  width: 80%;
  max-width: 330px;
  height: 56px;
  margin: 7%;
}
</style>
