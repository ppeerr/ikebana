<template>
  <div class="items">
    <div v-for="bouquet in bouquets" class="card" @click="$emit('toModal', bouquet)">
    <img class="card-img-top" :src="bouquet.img">
      <div class="card-body">
        <h5 class="card-title">{{ bouquet.flowers }}</h5>
        <p class="card-text">{{ bouquet.description }}</p>

        <button class="btn btn-primary" :bouquet="obj">Заказать букет</button>
      </div>
    </div>
  </div>
</template>


<script>
export default {
  data() {
    return {
    obj: {}

    }
  },
  props: ['bouquets']
}
</script>


<style scoped>
  .items {
    max-width: 960px;
    margin: 20px auto;
    display: -webkit-box;
    display: -ms-flexbox;
    display: flex;
    -ms-flex-wrap: wrap;
        flex-wrap: wrap;
    -webkit-box-pack: justify;
        -ms-flex-pack: justify;
            justify-content: space-between;
  }
  .card {
    min-width: 150px;
    width: calc(100% / 4 - 20px);
    margin: 10px;
    -webkit-box-shadow: 0 0 5px rgba(0,0,0,0.5);
            box-shadow: 0 0 5px rgba(0,0,0,0.5);
    cursor: pointer;
  }
  .card:hover {
    -webkit-box-shadow: 0 0 10px rgba(0, 105, 217, 0.75);
            box-shadow: 0 0 10px rgba(0, 105, 217, 0.75);
    -webkit-transition: -webkit-box-shadow 0.2s;
    transition: -webkit-box-shadow 0.2s;
    -o-transition: box-shadow 0.2s;
    transition: box-shadow 0.2s;
    transition: box-shadow 0.2s, -webkit-box-shadow 0.2s;
  }
  .card-title {
    text-align: center;
  }
  .card-body {
    display: -webkit-box;
    display: -ms-flexbox;
    display: flex;
    -webkit-box-orient: vertical;
    -webkit-box-direction: normal;
        -ms-flex-direction: column;
            flex-direction: column;
  }
  .card-text {
    position: relative;
    display: block;
/*    margin: 10px;*/
  }
  .btn {
    display: block;
    position: relative;
    bottom: 0;
/*    margin: 10px;*/
    margin-top: auto;

  }
  button {
    padding-left: 0;
    padding-right: 0;
  }

  @media screen and (max-width: 720px) {
    .card {
      width: calc(100% / 3 - 20px);
    }
  }
  @media screen and (max-width: 540px) {
    .card {
      width: calc(100% / 2 - 20px);
    }
  }
  @media all and (max-width: 420px) {
    .card {
      width: calc(100%/1 - 10px);
    }
  }
</style>
