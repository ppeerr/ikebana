<template>

  <div class="wrapper-modal">
<!--    <h1>This is created inline</h1>-->
    <div class="image" v-if="image == 'show'" :style="styleObj">
<!--      <img :src="text.img" height="520px">-->
    </div>
    <div id="selection">
      <h4>Выберите дни:</h4>
<!--      <p>{{ text }}</p>-->
      <div class="btn-group" role="group">
        <button class="btn" :class="{ 'btn-dark' : selectDay.monday, 'btn-outline-dark' : !selectDay.monday }" :title="'Понедельник'" @click="selectDay.monday=!selectDay.monday; if (selectDay.monday) invalid = false">Пн</button>
        <button class="btn" :class="{ 'btn-dark' : selectDay.tuesday, 'btn-outline-dark' : !selectDay.tuesday }" :title="'Вторник'" @click="selectDay.tuesday=!selectDay.tuesday; if (selectDay.tuesday) invalid = false">Вт</button>
        <button class="btn" :class="{ 'btn-dark' : selectDay.wednesday, 'btn-outline-dark' : !selectDay.wednesday }" :title="'Среда'" @click="selectDay.wednesday=!selectDay.wednesday; if (selectDay.wednesday) invalid = false">Ср</button>
        <button class="btn" :class="{ 'btn-dark' : selectDay.thursday, 'btn-outline-dark' : !selectDay.thursday }" :title="'Четверг'" @click="selectDay.thursday=!selectDay.thursday; if (selectDay.thursday) invalid = false">Чт</button>
        <button class="btn" :class="{ 'btn-dark' : selectDay.friday, 'btn-outline-dark' : !selectDay.friday }" :title="'Пятница'" @click="selectDay.friday=!selectDay.friday; if (selectDay.friday) invalid = false">Пт</button>
        <button class="btn" :class="{ 'btn-dark' : selectDay.saturday, 'btn-outline-dark' : !selectDay.saturday }" :title="'Суббота'" @click="selectDay.saturday=!selectDay.saturday; if (selectDay.saturday) invalid = false">Сб</button>
        <button class="btn" :class="{ 'btn-dark' : selectDay.sunday, 'btn-outline-dark' : !selectDay.sunday }" :title="'Воскресенье'" @click="selectDay.sunday=!selectDay.sunday; if (selectDay.sunday) invalid = false">Вс</button>
      </div>
      <div class="price">
        <div> <span :title="'Количество недель в которые будет действителен заказ'">Кол-во недель:</span>
          <input type="number" required min=1 max=10 maxlength=2 @input="trim($event.target.value)" :value="weeks" id="inputWeek" class="form-control">
          <span class="validity"></span>
        </div>
        <h5>Цена: {{ price() }}</h5>
      </div>
    <div class="date">
      <p>С какой даты начать?</p>
      <input type="date" required min="2018-03-13" max="2020-03-13" :value="startDate" class="form-control" id="inputDate">
      <span class="validity"></span>
    </div>
    <hr>
    <div class="name">
      <p>Ваше имя:</p>
      <input type="text" v-model="customerName" id="inputName" class="form-control">
    </div>
    <div class="address">
      <p>Адрес доставки:</p>
      <input type="text" placeholder="Улица дом, квартира" v-model="address" id="inputAddress" class="form-control">
    </div>
    <div class="phone">
      <p>Ваш телефон:</p>
      <input type="text" placeholder="8005553535" v-model="phoneNumber" id="inputPhone" class="form-control">
    </div>
    <div class="comment">
      <p>Комментарий:</p>
      <textarea rows="3" id="inputComment" class="form-control" v-model="comment" placeholder="Напишите предпочитаемое время доставки, нюансы заказа..."></textarea>
    </div>
<!--    <transition name="fade" mode="out-in">-->
      <p class="invalid" v-if="invalid">{{ invalidMessage }}</p>
<!--    </transition>-->
      <footer>
        <button type="button" class="btn btn-success" @click="validateAndSend">ЗАКАЗАТЬ!</button>
      </footer>
    </div>

  </div>
</template>

<!--$emit('close')-->

<script>
  export default {
    data() {
      return {
        image: 'show',
//        styleObj: {
//          backgroundImage: "url('../src/assets/roses.jpg')"
//        },
        customerName: '',
        address: '',
        phoneNumber: '',
        comment: '',
        startDate: '2018-03-13',

        invalid: false,
        invalidMessage: '',
        weeks: 1,

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
        },
        selectDay: {
          monday: false,
          tuesday: false,
          wednesday: false,
          thursday: false,
          friday: false,
          saturday: false,
          sunday: false
        }
      }
    },

    props: ['text', 'w'],
    computed: {
      styleObj(){
        let urlString = "../src/assets" + this.text.img;
//        urlString = urlString.slice(0, -33);
        console.log(urlString);
        return {
          backgroundImage: "url('"+urlString+"')"
//          background: "red"
        }
      },
      getDate(){
        let date = new Date();
        let currDate = date.getDate();
        let currMonth = date.getMonth();
        let currYear = date.getYear();
        return {
//          this.startDate = 'currYear + "-" + currMonth + "-" + currDate'
        }
      }
    },

    methods: {
      trim(val){
        this.weeks = val;
        if (typeof this.weeks == "string" && this.weeks != ""){
          this.weeks = +this.weeks;
          if (this.weeks > 10) this.weeks = 10;
          if (this.weeks < 0) this.weeks = 1;
          console.log(this.weeks);
          console.log(this.text);
        }
      },
      price() {
        let cost = 0;
        for (let day in this.selectDay){
          if (this.selectDay[day]) {
            cost = (cost + this.weeks*this.text.cost);
          }
        }
        return cost;
      },
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
      },
      validateAndSend() {
        let count = 0;
        for (let day in this.selectDay){
          if (this.selectDay[day]) {
            count++;
          }
        }
        if (count == 0) {
          this.invalidMessage = 'Выберите хотя бы один день';
          this.invalid = true;
        } else {
          this.invalid = false;
        }
        if (!this.customerName) {
          if (this.invalid) this.invalidMessage = this.invalidMessage + ', введите имя';
          if (!this.invalid) {
            this.invalid = true;
            this.invalidMessage = 'Введите имя';
          }
        }

      }
    },
    mounted: function() {
      console.log(this.w);
      if (this.w == '100%') {
        this.image = 'hide';
        var elem = document.getElementById("selection");
        elem.style.width = 100 + "%";
//        elem.style.height = 100 + "%";
  //      console.log(elem);
      }
    },

  }
</script>


<style scoped>
  h1{
    color: blue
  }
  .form-control{
    padding: 0.2em;
  }
.btn-outline-dark:hover {
  background-color: rgb(153, 156, 159);
}
.wrapper-modal {
  display: flex;
  flex-wrap: wrap;
  justify-content: space-between;
}
.image {
  width: 50%;
  overflow: hidden;
  height: 520px;
/*  background-image: url('../assets/bgVer1.jpg');*/
  background-repeat: no-repeat;
  background-position: center center;
  background-size: cover;
}
.image img{
/*  width: 110%;*/
  position: relative;

}
#selection {
  width: 50%;
  height: 520px;
  padding: 10px;
  position: relative;
}
.btn-group{
  display: flex;
  justify-content: center;
}
.btn-group .btn{
  width: 100px;
}
/*
.btn-group .btn:hover{
  background-color: #aaa;
}
*/
.price{
  position: relative;
  margin-top: 10px;
  height: 40px;
}
.price div{
  position: relative;
  margin-left: 0px;
  width: 60%;
  font-weight: 600;
  top: 3px;
}
.price h5{
  position: absolute;
  margin-left: 0px;
  font-weight: 600;
  top: 3px;
  left: 65%;
}
#inputWeek {
  position: absolute;
  width: 50px;
  right: 22px;
  top: 0;
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

  .name, .date{
    position: relative;
    margin-top: 10px;
    height: 40px;
    font-weight: 600;

  }
  .name p, .date p{
    position: absolute;
    margin-left: 0px;
    font-weight: 600;
    top: 3px;
  }
  #inputName{
    position: absolute;
    margin-right: 0px;
    right: 0;
    width: 60%;
  }
  #inputDate{
    position: absolute;
    margin-right: 0px;
    right: 22px;
    width: 40%;
  }
  .phone{
    position: relative;
    margin-top: 10px;
    height: 40px;
  }
  .phone p{
    position: absolute;
    margin-left: 0px;
    font-weight: 600;
    top: 3px;
  }
  #inputPhone{
    position: absolute;
    margin-right: 0px;
    right: 0;
    width: 60%;
  /*    top: -5px;      */
  }

  .address{
    position: relative;
    margin-top: 10px;
    height: 40px;
  }
  .address p{
    position: absolute;
    margin-left: 0px;
    font-weight: 600;
    top: 3px;
  }
  #inputAddress{
    position: absolute;
    margin-right: 0px;
    right: 0;
    width: 60%;
/*    top: -5px;      */
  }
   .comment{
    position: relative;
    margin-top: 10px;
    height: 100px;
  }
  .comment p{
    position: absolute;
    margin-left: 0px;
    font-weight: 600;
    top: 3px;
  }
  #inputComment{
    position: absolute;
    margin-right: 0px;
    right: 0;
    width: 60%;
    resize: none;
  }
  footer{
    width: 100%;
    position: absolute;
    bottom: 0;
  }
  footer .btn{
    width: calc(100% - 20px);
    position: absolute;
    bottom: 10px;
/*
    left: 0;
    right: 0;
*/
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
input:invalid+span:after {
  position: absolute;
  right: 0px;
  top: 2px;
  content: '✖';
  padding-left: 5px;
}

input:valid+span:after {
  position: absolute;
  right: 0px;
  top: 2px;
  content: '✓';
  padding-left: 5px;
}
</style>
