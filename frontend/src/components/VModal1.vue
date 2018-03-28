<template>

  <div class="wrapper-modal">
<!--    <h1>This is created inline</h1>-->
    <div class="image" v-if="image == 'show'" :style="styleObj">
<!--      <img :src="text.img" height="520px">-->
    </div>
    <div id="selection">
      <button class="close" @click="$emit('close')">
        ❌
      </button>
      <h4>Выберите дни:</h4>
<!--      <p>{{ text }}</p>-->
      <div class="btn-group" role="group">
        <button v-for="day in selectDay" class="btn" :class="{ 'btn-dark' : day.value, 'btn-outline-dark' : !day.value }" :title="day.title" @click="onDay(day)">{{day.shotTitle}}</button>
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
      <input type="date" required :min="minDate" :max="maxDate" :value="startDate" @input="startDate = $event.target.value" class="form-control" id="inputDate">
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
    <transition name="fade" mode="out-in">
      <div class="invalid">
        <span v-if="invalid" v-for="mes in invalidMessage">{{ mes }}! </span>
      </div>
    </transition>

      <footer>
        <button type="button" class="btn btn-success" @click="validate">ЗАКАЗАТЬ!</button>
      </footer>
    </div>

  </div>
</template>

<script>
  export default {
    data() {
      return {
        image: 'show',
        customerName: '',
        address: '',
        phoneNumber: '',
        comment: '',
        minDate: '',
        maxDate: '',
        numMinDate: '',
        numMaxDate: '',
        startDate: '',
        numStartDate: [],

        formationDate: {
          date: '',
          currDate: '',
          currMonth: '',
          currYear: '',
          maxYear: '',
        },


        invalid: false,
        invalidMessage: [],
        weeks: 1,

        selectDay: {
          monday: {value: false, title: 'Понедельник', shotTitle: 'Пн'},
          tuesday: {value: false, title: 'Вторник', shotTitle: 'Вт'},
          wednesday: {value: false, title: 'Среда', shotTitle: 'Ср'},
          thursday: {value: false, title: 'Четверг', shotTitle: 'Чт'},
          friday: {value: false, title: 'Пятница', shotTitle: 'Пт'},
          saturday: {value: false, title: 'Суббота', shotTitle: 'Сб'},
          sunday: {value: false, title: 'Воскресенье', shotTitle: 'Вс'}
        }
      }
    },

    props: ['text', 'w'],
    computed: {
      styleObj(){
        let urlString = "../src/assets" + this.text.img;
        return {
          backgroundImage: "url('"+urlString+"')"
        }
      },
    },

    methods: {
      parseStartDate(val){
        this.numStartDate = [];
        for (let i=0; i<val.length; i++){
          if (val[i] != "-"){
            this.numStartDate = this.numStartDate + val[i];
          }
        }
      },
      onDay(val){
        val.value = !val.value;
        if (val.value) {
          this.invalidMessage.splice(this.invalidMessage.indexOf('Выберите хотя бы один день'), 1)
        }
      },
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
          for (let val in this.selectDay[day]){
            if (val == "value") {
              if (this.selectDay[day][val]) cost=cost+this.text.cost*this.weeks;
            }
          }
        }
        return cost;
      },
//      toggleFlirt() {
//        this.select.flirt.value = !this.select.flirt.value;
//        if (this.select.flirt.value) {
//          this.select.flirt.message = 'Убрать';
//        } else this.select.flirt.message = 'Выбрать!';
//      },
//      toggleRomantic() {
//        this.select.romantic.value =!this.select.romantic.value;
//        if (this.select.romantic.value) {
//          this.select.romantic.message = 'Убрать';
//        } else this.select.romantic.message = 'Выбрать!';
//      },
//      toggleLove() {
//        this.select.love.value =!this.select.love.value;
//        if (this.select.love.value) {
//          this.select.love.message = 'Убрать';
//        } else this.select.love.message = 'Выбрать!';
//      },
//      toggleInsane() {
//        this.select.insane.value =!this.select.insane.value;
//        if (this.select.insane.value) {
//          this.select.insane.message = 'Убрать';
//        } else this.select.insane.message = 'Выбрать!';
//      },
      validate() {
        this.invalidMessage = [];
        this.invalid = false;
        let count = 0;
        for (let day in this.selectDay){
          for (let val in this.selectDay[day]){
            if (val == "value") {
              if (this.selectDay[day][val]) count++;
            }
          }
        }
        if (count == 0) {
          this.invalidMessage.push('Выберите хотя бы один день');
          this.invalid = true;
        }
        if (this.weeks < 1 || this.weeks > 10) {
          this.invalidMessage.push('Количество недель не корректно');
          this.invalid = true;
        }
        if (!this.customerName) {
          this.invalidMessage.push('Введите имя');
          this.invalid = true;
        }
        this.parseStartDate(this.startDate);
        if (this.numStartDate < this.numMinDate || this.numStartDate > this.numMaxDate) {
          this.invalidMessage.push('Дата не корректна');
          this.invalid = true;
        }
        if (!this.address) {
          this.invalidMessage.push('Введите адрес');
          this.invalid = true;
        }
        if (this.phoneNumber.length<10) {
          this.invalidMessage.push('Введите телефон');
          this.invalid = true;
        } else {
          if (isNaN(+this.phoneNumber)){
            this.invalidMessage.push('Телефон не корректен');
            this.invalid = true;
          }
        }
        if (this.invalid == false) {
          this.sendData();
        }

      },
      sendData(){
        console.log('kek');



        this.$emit('close');
      }
    },
    mounted: function() {
      if (this.w == '100%') {
        this.image = 'hide';
        var elem = document.getElementById("selection");
        elem.style.width = 100 + "%";
//        elem.style.height = 100 + "%";
  //      console.log(elem);
      }
      this.formationDate.date = new Date();
      this.formationDate.currDate = this.formationDate.date.getDate();
      this.formationDate.currMonth = this.formationDate.date.getMonth();
      this.formationDate.currYear = this.formationDate.date.getFullYear();
      this.formationDate.maxYear = this.formationDate.currYear+2;
      this.formationDate.currMonth++;
      if (this.formationDate.currMonth<10){
        this.formationDate.currMonth = '0' + this.formationDate.currMonth;
      }
      if (this.formationDate.currDate<10){
        this.formationDate.currDate = '0' + this.formationDate.currDate;
      }
      this.minDate = this.formationDate.currYear + "-" + this.formationDate.currMonth + "-" + this.formationDate.currDate;
      this.maxDate = this.formationDate.maxYear + "-" + this.formationDate.currMonth + "-" + this.formationDate.currDate;
      this.startDate = this.minDate;
      this.numMinDate = Number(this.formationDate.currYear + '' + this.formationDate.currMonth + '' + this.formationDate.currDate);

      this.numMaxDate = Number(this.formationDate.maxYear + '' + this.formationDate.currMonth + '' + this.formationDate.currDate);
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
  height: 540px;
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
  height: 540px;
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
/*
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
*/

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
    height: 80px;
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
  .invalid{
    color: red;
    display: inline;
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
.fade-enter-active, .fade-leave-active {
  transition: opacity 0.3s;
}
.fade-enter, .fade-leave-to {
  opacity: 0;
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
