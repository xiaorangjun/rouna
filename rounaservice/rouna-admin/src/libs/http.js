import axios from 'axios';
import store from '../store';

axios.defaults.timeout = 5000;
axios.defaults.baseURL ='/apis';
axios.defaults.withCredentials=false;
axios.defaults.headers = {
    'X-Requested-With': 'XMLHttpRequest'
}

// 添加请求拦截器
axios.interceptors.request.use(
    config=>{
        // 在发送请求之前做些什么
        let token = store.state.user.token;
        console.info(token);
        if (token) {  // 判断是否存在token，如果存在的话，则每个http header都加上token
            config.headers.XAuthorization = token;
        }
        return config;
    }, 
    error=> {
        // 对请求错误做些什么
        return Promise.reject(error);
    }
);

// 添加响应拦截器
axios.interceptors.response.use(
    response=> {
        // 对响应数据做点什么
        return response.data;
    }, 
    error=> {
        // 对响应错误做点什么
        return Promise.reject(error);
    }
);
var CancelToken = axios.CancelToken;
var cancel;
export default {
    //get请求
    get (url,param) {
        return new Promise((resolve,reject) => {
          axios({
            method: 'get',
            url,
            params: param,
            cancelToken: new CancelToken(c => {
              cancel = c
            })
          }).then(res => {
            resolve(res)
          }).catch(res =>{
              reject(res);
          })
        })
    },
    //post请求
    post (url,param) {
        return new Promise((resolve,reject) => {
          axios({
            method: 'post',
            url,
            data: param,
            cancelToken: new CancelToken(c => {
              cancel = c
            })
          }).then(res => {
            resolve(res)
          }).catch(res=>{
              reject(res);
          })
        })
    },
    put (url,param) {
        return new Promise((resolve,reject) => {
          axios({
            method: 'put',
            url,
            data: param,
            cancelToken: new CancelToken(c => {
              cancel = c
            })
          }).then(res => {
            resolve(res)
          }).catch(res=>{
              reject(res);
          })
        })
    },
    delete (url,param) {
        return new Promise((resolve,reject) => {
          axios({
            method: 'delete',
            url,
            data: param,
            cancelToken: new CancelToken(c => {
              cancel = c
            })
          }).then(res => {
            resolve(res)
          }).catch(res=>{
              reject(res);
          })
        })
    }
}