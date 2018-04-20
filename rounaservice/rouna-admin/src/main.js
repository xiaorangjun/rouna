import Vue from 'vue';
import iView from 'iview';
import {router} from './router/index';
import store from './store';
import App from './app.vue';
import 'iview/dist/styles/iview.css';
import http from './libs/http';
Vue.use(iView);

Vue.prototype.$get = http.get;
Vue.prototype.$post = http.post;
Vue.prototype.$put = http.put;
Vue.prototype.$delete = http.delete;

new Vue({
    el: '#app',
    router: router,
    store: store,
    render: h => h(App),
    mounted () {
        this.$store.commit('updateMenulist');
    }
});
