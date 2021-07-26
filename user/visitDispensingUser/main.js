import Vue from 'vue'
import App from './App'
import uView from "uview-ui";
import cuCustom from './colorui/components/cu-custom.vue'
import card from './components/card.vue'
import medicineCard from './components/medicineCard.vue'
import doctorCard from './components/doctorCard.vue'
Vue.component('card',card)
Vue.component('medicineCard',medicineCard)
Vue.component('doctorCard',doctorCard)
Vue.component('cu-custom',cuCustom)
Vue.use(uView);
Vue.config.productionTip = false

App.mpType = 'app'

const app = new Vue({
    ...App
})
app.$mount()
