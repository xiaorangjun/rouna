import Cookies from 'js-cookie';

const user = {
    state: {
        user:"",
        token:Cookies.get("token")
    },
    mutations: {
        setUser(state,user){
            Cookies.set("user",user);
            state.user = user;
        },
        clearUser(state){
            Cookies.remove("user");
            state.user = null;
        },
        setToken(state,token){
            Cookies.set("token",token);
            state.token = token;
        },
        clearToken(state){
            Cookies.remove("token");
            state.token = "";
        },
        clearLocalStorate () {
            localStorage.clear();
        }
    },
    actions:{
        logout(context){
            context.commit("clearUser");
            context.commit("clearToken");
            context.commit("clearLocalStorate");
        },
        setToken(context,token){
            context.commit("setToken",token)
        },
        setUser(context,user){
            context.commit("setUser",user)
        }
    }
};

export default user;
