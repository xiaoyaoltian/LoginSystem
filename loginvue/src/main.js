// The Vue build version to load with the `import` command
// (runtime-only or standalone) has been set in webpack.base.conf with an alias.
import Vue from 'vue'
import App from './App'
import router from './router'

import ElementUI from 'element-ui';
import 'element-ui/lib/theme-chalk/index.css';
import axios from 'axios'
import VueAxios from 'vue-axios'

Vue.use(ElementUI);
Vue.use(VueAxios, axios)

/*设置全局*/
Vue.prototype.$axios = axios
// 前端请求默认发送到 http://localhost:8848
axios.defaults.baseURL = 'http://127.0.0.1:8080'
Vue.config.productionTip = false

new Vue({
  render: h => h(App),
  router,
}).$mount('#app')


