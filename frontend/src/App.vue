<template>
  <div id="app">
    <div class="wrapper">
      <div @click="onScroll('hr')" class="to-scroll">
        <h2>Выбрать букеты</h2>
        <img src="./assets/white-down-arrow-png-2.png" alt="">
      </div>
    </div>
    <hr id="hr">
    <app-items :bouquets="bouquets"
               @toModal="onOpenModal"/>
    <transition name="modal">
      <app-modal v-if="state === 'modal'"
                 @closeModal="onCloseModal"
                 :current="currentBouquet"/>
    </transition>
  </div>
</template>

<script>
  export default {
    name: 'app',
    data() {
      return {
        scrollTag: '',
        state: '',
        currentBouquet: '',
        scrollSpeed: 30,
//      scrolled: '1',
        scrolledAfter: '',
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
      onOpenModal() {
        this.currentBouquet = val;
        this.state = 'modal';

      },
      onCloseModal() {
        this.state = '';
      },
      onScroll(id) {
        if ((typeof id) === 'string') {
          this.scrollTag = id;
        }

        let scrolled = 0;

        if (this.hrY(this.scrollTag) > 0) {
          scrolled = window.pageYOffset; //записали положение
          console.log(scrolled);
          console.log(this.scrolledAfter);
          if (scrolled === this.scrolledAfter || this.scrolledAfter === '') {
            window.scrollBy(0, this.scrollSpeed);
            this.scrolledAfter = window.pageYOffset; //записали положение после
            if (this.scrolledAfter > scrolled) {
              requestAnimationFrame(this.onScroll);

            } else {
              this.scrolledAfter = '';
              this.scrollTag = '';
            }
          } else {
            this.scrolledAfter = '';
            this.scrollTag = '';
          }
        } else {
          this.scrolledAfter = '';
          this.scrollTag = '';
        }
      },
      hrY(id) {
        let hr = document.getElementById(id);
        return hr.getBoundingClientRect().y
      }

    }
  }
</script>

<style scoped>
  #app {

  }

  .wrapper {
    height: 100vh;
    position: relative;
    background: url('./assets/bgVer1.jpg') no-repeat center center;
    background-size: cover;
  }

  /*
  .ratio-inner {
    position: relative;
    height: 0;
    border: none;
  }
  */
  /*
  .ratio-content {
    position: absolute;
    top: 0;
    right: 0;
    bottom: 0;
    left: 0;
    display: flex;
    justify-content: space-around;
    background-image: url('./assets/bgVer1.jpg');
    background-size: cover;
    overflow: hidden;
  }
  */
  /*
  .ratio-16-9 {
    padding-top: 56.25%;  100% ширины делим на 16 и умножаем на 9
  }
  */
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
    transition: transform 0.25s, -webkit-transform 0.25s;

  }

  .to-scroll:hover {
    -webkit-transform: scale(1.05);
    -ms-transform: scale(1.05);
    transform: scale(1.05);
    -webkit-transition: -webkit-transform 0.25s;
    transition: -webkit-transform 0.25s;
    -o-transition: transform 0.25s;
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

  hr {
    height: 12px;
    border: 0;
    -webkit-box-shadow: inset 0 15px 12px -11px rgba(0, 0, 0, 0.5);
    box-shadow: inset 0 15px 12px -11px rgba(0, 0, 0, 0.5);
    margin: 0;
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
