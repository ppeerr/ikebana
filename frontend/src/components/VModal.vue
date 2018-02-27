<template>
  <div class="wrapper-modal">
<!--    <h1>This is created inline</h1>-->
    <div class="image">
      <img :src="text.img" height="480px">
    </div>
    <div class="selection">
      <h4>Выберите вариант подписки:</h4>
<!--      <p>{{ text }}</p>-->
    <h5>"Flirt"</h5>
    <div class="flirt">
      <p>Один букет {{ text.flowers }} в неделю.</p>
      <button class="btn" :class="{ 'btn-dark' : select.flirt.value, 'btn-outline-dark' : !select.flirt.value }" @click="toggleFlirt">{{ select.flirt.message }}</button>
    </div>
    <hr>
    <h5>"Romantic"</h5>
    <div class="romantic">
      <p>Два букета {{ text.flowers }} в неделю.</p>
      <button class="btn" :class="{ 'btn-dark' : select.romantic.value, 'btn-outline-dark' : !select.romantic.value }" @click="toggleRomantic">{{ select.romantic.message }}</button>
    </div>
    <hr>
    <h5>"Love"</h5>
    <div class="love">
      <p>Четыре букета {{ text.flowers }} в неделю.</p>
      <button class="btn" :class="{ 'btn-dark' : select.love.value, 'btn-outline-dark' : !select.love.value }" @click="toggleLove">{{ select.love.message }}</button>
    </div>
    <hr>
    <h5>"Insane"</h5>
    <div class="insane">
      <p>Каждый день букет {{ text.flowers }}!</p>
      <button class="btn" :class="{ 'btn-dark' : select.insane.value, 'btn-outline-dark' : !select.insane.value }" @click="toggleInsane">{{ select.insane.message }}</button>
    </div>
    <hr>
    <div class="phone">
      <p>Ваш телефон:</p>
      <input type="text" placeholder="8005553535" id="inputPhone">
    </div>
      <footer>
        <button type="button" class="btn btn-success">ЗАКАЗАТЬ!</button>
      </footer>
    </div>

  </div>
</template>

<script>
  export default {
    data() {
      return {
        select: {
          flirt: {
            value: false,
            message: 'Выбрать!'
          },
          romantic: {
            value: false,
            message: 'Выбрать!'
          },
          love: {
            value: false,
            message: 'Выбрать!'
          },
          insane: {
            value: false,
            message: 'Выбрать!'
          }
        }
      }
    },

    props: ['text'],
    methods: {
      toggleFlirt() {
        this.select.flirt.value = !this.select.flirt.value;
        if (this.select.flirt.value) {
          this.select.flirt.message = 'Убрать';
        } else this.select.flirt.message = 'Выбрать!';
      },
      toggleRomantic() {
        this.select.romantic.value =!this.select.romantic.value;
        if (this.select.romantic.value) {
          this.select.romantic.message = 'Убрать';
        } else this.select.romantic.message = 'Выбрать!';
      },
      toggleLove() {
        this.select.love.value =!this.select.love.value;
        if (this.select.love.value) {
          this.select.love.message = 'Убрать';
        } else this.select.love.message = 'Выбрать!';
      },
      toggleInsane() {
        this.select.insane.value =!this.select.insane.value;
        if (this.select.insane.value) {
          this.select.insane.message = 'Убрать';
        } else this.select.insane.message = 'Выбрать!';
      }
    }

  }
</script>


<style scoped>
  h1{
    color: blue
  }
.wrapper-modal {
  display: flex;
  flex-wrap: wrap;
  justify-content: space-between;
}
.image {
  width: 50%;
  overflow: hidden;
}
/*
.image img:hover {
  width: 110%;

}
*/
.selection {
  width: 50%;
  padding: 10px;
}
  .btn{
    padding-left: 0;
    padding-right: 0;
  }
  .flirt {
    position: relative;
    height: 40px;
  }
  .flirt p{
    position: absolute;
    margin-left: 10px;
  }
  .flirt .btn{
    position: absolute;
    margin-right: 10px;
    width: 100px;
    right: 0;
    top: -5px;
  }
  .romantic{
    position: relative;
    height: 40px;
  }
  .romantic p{
    position: absolute;
    margin-left: 10px;
  }
  .romantic .btn{
    position: absolute;
    margin-right: 10px;
    width: 100px;
    right: 0;
    top: -5px;
  }
  .love{
    position: relative;
    height: 40px;
  }
  .love p{
    position: absolute;
    margin-left: 10px;
  }
  .love .btn{
    position: absolute;
    margin-right: 10px;
    width: 100px;
    right: 0;
    top: -5px;
  }
  .insane{
    position: relative;
    height: 40px;
  }
  .insane p{
    position: absolute;
    margin-left: 10px;
  }
  .insane .btn{
    position: absolute;
    margin-right: 10px;
    width: 100px;
    right: 0;
    top: -5px;
  }
  .phone{
    position: relative;
    margin-top: 10px;
    height: 40px;
  }
  .phone p{
    position: absolute;
    margin-left: 40px;
    font-weight: 600;
    top: 3px;
  }
  #inputPhone{
    position: absolute;
    margin-right: 30px;
    right: 0;
/*    top: -5px;      */
  }
  footer{
    width: 100%;
    position: relative;
  }
  footer .btn{
    width: 300px;
    position: absolute;
    left: 0;
    right: 0;
    margin: auto;
  }
  hr {
    margin: 0;
    margin-bottom: 5px;
  }
  h4{
    padding-bottom: 10px;
  }
  h4, h5{
    text-align: center;
  }
  h5{

  }
</style>

