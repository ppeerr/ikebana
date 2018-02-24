<template>
<div class="modal-mask">
    <div class="modal-wrapper">
      <div class="modal-container">
        <div class="header">
          <div class="chooose">
          {{ current }}
          </div>
        <br>
        </div>
        <hr>
        <div class="body">

        </div>

        <div class="footer">

          <button class="btn btn-success" @click="$emit('closeModal')">
            OK
          </button>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
export default{
  props: ['current']
}
</script>

<style scoped>
.modal-mask {
  position: fixed;
  z-index: 9998;
  top: 0;
  left: 0;
  width: 100%;
  height: 100%;
  background-color: rgba(0, 0, 0, .5);
  display: table;
}

.modal-wrapper {
  display: table-cell;
  vertical-align: middle;
}

.modal-container {
  width: 600px;
  margin: 0px auto;
  padding: 0px 0px;
  background-color: #fff;
  border-radius: 3px;
  box-shadow: 0 2px 8px rgba(0, 0, 0, .33);
  font-family: Helvetica, Arial, sans-serif;
  overflow: hidden;
}

.header {
  margin: 0px;
  padding: 0px;
  height: 100px;


}
.body {
  margin: 20px 20px 0px;

  position: relative;
}
</style>
