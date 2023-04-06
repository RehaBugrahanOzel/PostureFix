<template>
  <div class="burger">
    <section class="p-menu1">
      <nav id="navbar" class="navigation" role="navigation">
        <input id="toggle1" type="checkbox" />
        <label class="hamburger1" for="toggle1">
          <div class="top"></div>
          <div class="meat"></div>
          <div class="bottom"></div>
        </label>

        <nav class="menu1">
          <a class="link1" href="">Our Models</a>
          <a class="link1" href="">Specialties</a>
          <a class="link1" href="">About</a>
          <a class="link1" href="">Blog</a>
          <a class="link1 kbutton-nav" href="">Contact</a>
        </nav>
      </nav>
    </section>
  </div>
</template>

<script>
export default {};
</script>

<style scoped>
/* General */
/* html {
  overflow: hidden;
  -webkit-overflow-scrolling: touch;
  height: 100%;
} */

/* body {
  margin: 20px 0;
  overflow: auto;
 
  color: #fff;
} */

.burger {
  position: fixed;
  z-index: 1;
  top: 5px;
}

a {
  color: black;
  text-decoration: none;
}

.p-menu1 {
  height: 100%;
}

/* Hamburger */
.hamburger1 {
  margin: 10px;
  display: -ms-grid;
  display: grid;
  grid-template-rows: repeat(3, 1fr);
  justify-items: center;
  z-index: 120;
}

.hamburger1 div {
  background-color: black;
  position: relative;
  width: 27px;
  height: 5px;
  margin-top: 2px;
  -webkit-transition: all 0.2s ease-in-out;
  transition: all 0.2s ease-in-out;
  border-radius: 2px;
}

#toggle1 {
  display: none;
}

#toggle1:checked + .hamburger1 .top {
  -webkit-transform: rotate(-45deg);
  transform: rotate(-45deg);
  margin-top: 22.5px;
  border-radius: 2px;
}

#toggle1:checked + .hamburger1 .meat {
  -webkit-transform: rotate(45deg);
  transform: rotate(45deg);
  margin-top: -5px;
  border-radius: 2px;
}

#toggle1:checked + .hamburger1 .bottom {
  -webkit-transform: scale(0);
  transform: scale(0);
  border-radius: 2px;
}

#toggle1:checked ~ .menu1 {
  height: 340px;
}

/* Menu */
.menu1 {
  width: 100%;
  background-color: #cdcdcd;
  margin: 0;
  display: -ms-grid;
  display: grid;
  grid-template-rows: 1fr repeat(4, 0.5fr);
  grid-row-gap: 25px;
  padding: 0;
  list-style: none;
  clear: both;
  width: auto;
  text-align: center;
  height: 0px;
  overflow: hidden;
  transition: height 0.4s ease;
  z-index: 120;
  -webkit-transition: all 0.3s ease;
  transition: all 0.3s ease;
}

.menu1 a:first-child {
  margin-top: 20px;
}

.menu1 a:last-child {
  margin-bottom: 40px;
}

.link1 {
  width: 100%;
  margin: 0;
  padding: 10px 0;
  font: 700 20px "Arial", sans-serif;
}

.link1:hover {
  background-color: #fff;
  color: rgb(61, 61, 61);
  -webkit-transition: all 0.3s ease;
  transition: all 0.3s ease;
}
</style>
