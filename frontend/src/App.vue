<template>
  <div id="app" v-if="mainScreen == 'main'">
    <div class="menu">
      <div class="menu-wrapper">
        <ul class="items-menu">
          <li class="item-menu" v-for="(item, index) in menuItems" @click='onScroll(index)'><p><span v-html="item"></span></p></li>
        </ul>
      </div>
    </div>
    <div class="wrapper">
      <div @click='onScroll("hr2")' class="to-scroll">
        <h2>Выбрать букеты</h2>
        <img src="./assets/white-down-arrow-png-2.png" alt="">
      </div>
    </div>
    <hr id="hr">
    <hr id="hr1">
    <div class="message"><h3>{{ message }}</h3></div>

    <hr id="hr2">
    <app-items :bouquets="bouquets"
               @toModal="onOpenModal"></app-items>
      <app-modal v-if="state == 'modal'"
                 @closeModal="onCloseModal"
                 :current="currentBouquet"></app-modal>
      <modals-container name="modal"/>
  </div>

</template>

<script>
  import MyComponent from './components/VModal.vue'

  export default {
    name: 'app',
    data() {
      return {
        w: 760,
        h: 480,
        state: '',
        stateModal: '',
        mainScreen: 'main',
        scrollTagId: '',
        currentBouquet: '',
        scrollSpeed: 30,
        //      scrolled: '1',
        scrolledAfter: '',
        message: 'Тян тянучка цветы тянучке подарите, ей приятно будет, может даст, но не факт, скорей всего нет. Цветы пахучие тянучке. На выбор, разные варианты подписки, завалите ее цветами. Курьер приедет и подарит ей букет, тянучка обнимет его, но не вас.',
        menuItems: {
          menuItem1: 'Товары',
          menuItem2: 'Как работаем?',
          menuItem3: 'О нас',
          menuPhone: '<i class="fa fa-mobile" aria-hidden="true"></i> 88005553535'
        },
        bouquets: [
          {
            id: '001',
            flowers: 'roses',
            cost: 1000,
            description: 'Lorem ipsum dolor sit amet, consectetur adipisicing elit. Provident, placeat.',
            pieces: 5,
            img: require("./assets/roses.jpg")
          },
          {
            id: '002',
            flowers: 'tulips',
            cost: 999,
            description: 'Lorem ipsum dolor sit amet, consectetur adipisicing elit. Maxime magnam doloremque molestias?',
            pieces: 9,
            img: require("./assets/roses.jpg")
          },
          {
            id: '003',
            flowers: 'petunia',
            cost: 200,
            description: 'Lorem ipsum dolor sit amet, consectetur adipisicing.',
            pieces: 1,
            img: require("./assets/roses.jpg")
          },
          {
            id: '004',
            flowers: 'violets',
            cost: 699,
            description: 'Lorem ipsum dolor sit amet, consectetur adipisicing.',
            pieces: 10,
            img: require("./assets/roses.jpg")
          },
          {
            id: '005',
            flowers: 'cactus',
            cost: 300,
            description: 'Lorem ipsum dolor sit amet, consectetur.',
            pieces: 1,
            img: require("./assets/roses.jpg")
          },
          {
            id: '006',
            flowers: 'orchids',
            cost: 600,
            description: 'Lorem ipsum dolor sit amet, consectetur adipisicing elit. Quod porro illum amet omnis. Inventore.',
            pieces: 3,
            img: require("./assets/roses.jpg")
          },
          {
            id: '007',
            flowers: 'random',
            cost: 150,
            description: 'Lorem ipsum dolor sit amet, consectetur adipisicing elit.',
            pieces: 1,
            img: require("./assets/roses.jpg")
          },
          {
            id: '008',
            flowers: 'kek',
            cost: 1000,
            description: 'Lorem ipsum dolor sit amet, consectetur adipisicing.',
            pieces: 5,
            img: require("./assets/roses.jpg")
          }
        ]
      }
    },

    computed: {},
    methods: {

      onOpenModal(val) {
        console.log(this.w);
        console.log(this.h);
        // this.currentBouquet = val;
        // this.state = 'modal';
//console.log(navigator.userAgent.match(/iPhone/i));
        this.$modal.show(MyComponent, {
          text: val
        }, {
          transition: "modal",
          draggable: false,
          width: this.w,
          height: this.h,
          adaptive: true

        })

      },
      onCloseModal() {
        this.state = '';
      },
      onScroll(id) {
        if ((typeof id) === 'string') {
          if (id === "menuItem1") {
            id = "hr2";
          } else if (id === "menuItem2") {
            id = "hr1";
          }
          this.scrollTagId = id;
        }

        var scrolled = 0;

        if (this.hrY(this.scrollTagId) > 0) {
          scrolled = window.pageYOffset; //записали положение
//        console.log(scrolled);
//        console.log(this.scrolledAfter);
          if (scrolled == this.scrolledAfter || this.scrolledAfter == '') {
            window.scrollBy(0, this.scrollSpeed);
            this.scrolledAfter = window.pageYOffset; //записали положение после
            if (this.scrolledAfter > scrolled) {
              requestAnimationFrame(this.onScroll)

            } else {
              this.scrolledAfter = '';
              return
            }
            ;
          } else {
            this.scrolledAfter = '';
            return
          }
        } else {
          this.scrolledAfter = '';
        }
      },
      hrY(par) {
        let hr1 = document.getElementById(par);
        return hr1.getBoundingClientRect().y
      }

    },
    beforeMount: function detectmob() {
     if( navigator.userAgent.match(/Android/i)
      || navigator.userAgent.match(/webOS/i)
      || navigator.userAgent.match(/iPhone/i)
      || navigator.userAgent.match(/iPad/i)
      || navigator.userAgent.match(/iPod/i)
      || navigator.userAgent.match(/BlackBerry/i)
      || navigator.userAgent.match(/Windows Phone/i)
     ){
       this.w="100%";
       this.h="100%";
      }
       else {
       this.w="760px";
       this.h="480px";
      }
    }
  }
</script>

<style>
  #app {

  }
  .fa{
    font-size: 1.4em;
    vertical-align: -3px;
  }
  .menu {
    position: absolute;
    top: 0;
    left: 0;
    width: 100%;
/*    height: auto;*/
    padding: 0;
    margin: 0;
    background-color: rgba(0, 0, 0, 0.5);
    z-index: 2;
    box-shadow: 0 0 10px rgba(0, 0, 0, 0.5);
  }

  .menu-wrapper {
    max-width: 960px;
    margin: 0px auto;
    height: 100%;
    padding: 0;
  }

  .items-menu {
    padding: 0;
    margin: 0;
    height: 100%;
    width: 100%;
    display: -webkit-box;
    display: -ms-flexbox;
    display: flex;
    -ms-flex-wrap: wrap;
    flex-wrap: wrap;
    justify-content: space-between;
    flex-direction: row;
  }

  .item-menu p {
    cursor: pointer;
    height: 100%;
    text-align: center;
    line-height: 50px;
    font-size: 20px;
    display: block;
    color: #fff;
    padding: 0;
    margin: 0;
    transition: background-color 0.25s;

  }
.item-menu p:hover {
  background-color: rgba(0, 0, 0, 0.35);
  text-decoration: none;
  transition: background-color 0.25s;
}

  .item-menu {
    display: inline;
    margin: 0;
    padding: 0;
    list-style-type: none;
    min-width: 150px;
    width: calc(100%/4 - 2%);
  }
  @media screen and (max-width: 720px) {
    .item-menu {
      width: calc(100% / 2 - 20px);
    }
  }

  .wrapper {
    height: 100vh;
    position: relative;
    background-image: url('./assets/bgVer1.jpg');
    background-repeat: no-repeat;
    background-position: center center;
    background-size: cover;
  }

  .to-scroll {
    width: 250px;
    height: 150px;
    margin: 0 auto;
    /*  background: #ccc;*/
    position: absolute;
    /*  top: 0;*/
    left: 0;
    right: 0;
    bottom: 10%;
    cursor: pointer;
    -webkit-transition: -webkit-transform 0.25s;
    transition: -webkit-transform 0.25s;
    -o-transition: transform 0.25s;
    transition: transform 0.25s;
    transition: transform 0.25s, -webkit-transform 0.25s;

  }

  .to-scroll:hover {
    -webkit-transform: scale(1.05);
    -ms-transform: scale(1.05);
    transform: scale(1.05);
    -webkit-transition: -webkit-transform 0.25s;
    transition: -webkit-transform 0.25s;
    -o-transition: transform 0.25s;
    transition: transform 0.25s;
    transition: transform 0.25s, -webkit-transform 0.25s;

  }

  .to-scroll h2 {
    text-align: center;
    color: rgb(255, 255, 255);
  }

  .to-scroll img {

    width: 100px;

    padding-top: 20px;
    display: block;
    margin: 0 auto;
    -webkit-transform: scaleX(1.5);
    -ms-transform: scaleX(1.5);
    transform: scaleX(1.5);

  }

  #hr {
    height: 12px;
    border: 0;
    -webkit-box-shadow: inset 0 15px 12px -11px rgba(0, 0, 0, 0.5);
    box-shadow: inset 0 15px 12px -11px rgba(0, 0, 0, 0.5);
    margin: 0px;
  }

  #hr1, #hr2 {
    border: 0;
    height: 1px;
    background-image: -webkit-linear-gradient(0deg, rgba(0, 0, 0, 0), rgba(0, 0, 0, 0.75), rgba(0, 0, 0, 0));
    background-image: -moz-linear-gradient(0deg, rbga(0, 0, 0, 0), rgba(0, 0, 0, 0.75), rgba(0, 0, 0, 0));
    background-image: -ms-linear-gradient(0deg, rbga(0, 0, 0, 0), rgba(0, 0, 0, 0.75), rgba(0, 0, 0, 0));
    background-image: -o-linear-gradient(0deg, rbga(0, 0, 0, 0), rgba(0, 0, 0, 0.75), rgba(0, 0, 0, 0));
  }

  .message {
    max-width: 800px;
    margin: 20px auto;
    text-align: center;
    font-style: italic;

  }

  .message h3 {
    line-height: 160%;
  }

  .modal-enter-active {
    -webkit-animation: fadeIn 0.3s ease;
    animation: fadeIn 0.3s ease;

  }

  .modal-leave-active {
    -webkit-animation: fadeOut 0.3s ease;
    animation: fadeOut 0.3s ease;

  }

  @-webkit-keyframes fadeIn {
    from {
      -webkit-transform: scale(1.1);
      transform: scale(1.1);
      opacity: 0;
    }
    to {
      -webkit-transform: scale(1);
      transform: scale(1);
      opacity: 1
    }
  }

  @keyframes fadeIn {
    from {
      -webkit-transform: scale(1.1);
      transform: scale(1.1);
      opacity: 0;
    }
    to {
      -webkit-transform: scale(1);
      transform: scale(1);
      opacity: 1
    }
  }

  @-webkit-keyframes fadeOut {
    from {
      -webkit-transform: scale(1);
      transform: scale(1);
      opacity: 1;
    }
    to {
      -webkit-transform: scale(1.1);
      transform: scale(1.1);
      opacity: 0;
    }
  }

  @keyframes fadeOut {
    from {
      -webkit-transform: scale(1);
      transform: scale(1);
      opacity: 1;
    }
    to {
      -webkit-transform: scale(1.1);
      transform: scale(1.1);
      opacity: 0;
    }
  }

</style>

