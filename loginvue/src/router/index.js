import Vue from 'vue'
//安装vue-router后导入进来
import VueRouter from 'vue-router'

//导入组件
import Main from '../components/Main'
import Login from '../components/Login'

//安装路由
Vue.use(VueRouter);

//配置导出路由
export default new VueRouter({
  mode: 'history',
  routes: [
    { path: '/', redirect: '/login' },
    {
      //路由路径
      path: '/main',
      name: 'Main',
      //跳转的组件
      component: Main
    },
    {
      path: '/login',
      name: 'Login',
      component: Login
    }
  ]
});
