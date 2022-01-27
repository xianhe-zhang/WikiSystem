import { createApp } from 'vue'
import App from './App.vue'
import router from './router'
import store from './store'
import Antd from 'ant-design-vue';
import 'ant-design-vue/dist/antd.css';

// import组件，基本就是在这个main.js配置就好了



createApp(App).use(store).use(router).use(Antd).mount('#app');
