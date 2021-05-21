import Vue from 'vue';
import Vuex from 'vuex';
Vue.use(Vuex);
const store = new Vuex.Store({
  state: {
    joinRoom:[],
    leaveRoom:{},

    //定义显示或隐藏组件的全局变量
    show:'',
    username:'',
    status:'',
    // 存储token
    Authorization: localStorage.getItem('Authorization') ? localStorage.getItem('Authorization') : ''
  },
  mutations: {
    // 修改token，并将token存入localStorage
    changeLogin (state, user) {
      state.Authorization = user.Authorization;
      localStorage.setItem('Authorization', user.Authorization);
    },

    setJoinRoom(state,payload){
      state.joinRoom.push(payload)
    },
    setLeaveRoom(state,payload){
      state.leaveRoom.username = payload.username
    }
  },
  actions: {
  },
  modules: {
  }
});

export default store;
