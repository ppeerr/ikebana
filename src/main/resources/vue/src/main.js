import Vue from 'vue'
import App from './App.vue'

import AppItems from './components/Items.vue';
import AppModal from './components/Modal.vue';

Vue.component('AppItems', AppItems);
Vue.component('AppModal', AppModal);

new Vue({
  el: '#app',
  render: h => h(App)
})
