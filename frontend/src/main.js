import Vue from 'vue'
import VModal from 'vue-js-modal'

import App from './App.vue'

import AppItems from './components/Items.vue';
import AppModal from './components/Modal.vue';
//import MyComponent from './components/VModal.vue'


Vue.component('AppItems', AppItems);
Vue.component('AppModal', AppModal);
Vue.use(VModal, {
  dynamic: true
});

new Vue({
  el: '#app',
  render: h => h(App)
})
