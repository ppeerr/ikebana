<template>
  <div>
    <h1>This is created inline</h1>

    <p>{{ text }}</p>
  </div>
</template>

<script>
  export default {
    props: ['text']
  }
</script>


<style scoped>
  h1{
    color: blue
  }
  div{

  }
</style>

