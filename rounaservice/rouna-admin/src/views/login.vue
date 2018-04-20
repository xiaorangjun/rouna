<template>
<div class="login" @keydown.enter="handleSubmit">
    <div class="login-con">
    <Card :bordered="false">
        <p slot="title"><Icon type="log-in"></Icon>欢迎登录</p>
        <div class="form-con">
            <Form ref="loginForm" :model="form" :rules="rules">
                <FormItem prop="loginId">
                    <Input v-model="form.loginId" placeholder="请输入用户名"><span slot="prepend"><Icon :size="16" type="person"></Icon></span></Input>
                    </FormItem>
                        <FormItem prop="passWd">
                            <Input type="password" v-model="form.passWd" placeholder="请输入密码"><span slot="prepend"><icon :size="14" type="locked"></icon></span></Input></FormItem>
                        <FormItem><Button @click="handleSubmit" type="primary" long>登录</Button></FormItem>
                    </Form>
                </div>
            </Card>
        </div>
    </div>
</template>
<style lang="less">
@import "./login.less";
</style>

<script>
export default {
  data() {
    return {
      form: {
        loginId: "",
        passWd: ""
      },
      rules: {
        loginId: [
          { required: true, message: "账号不能为空", trigger: "blur" }
        ],
        passWd: [
          { required: true, message: "密码不能为空 ", trigger: "blur" }
        ]
      }
    };
  },
  methods: {
    handleSubmit() {
      this.$refs.loginForm.validate(valid => {
        if (valid) {
          this.$post("/api/v1/user/login",{loginId:this.form.loginId,passWd:this.form.passWd})
            .then(data => {
              if(data.code=="200"){
                this.$store.dispatch("setUser",this.form.loginId);
                this.$store.dispatch('setToken',data.result)
                this.$router.push({
                  name: "home_index"
                });
              }else{
                this.$Message.error({
                    content: data.message,
                    duration: 2.5
                });
              }
            }).catch(data => {
              console.info(data)
                this.$Message.error({
                    content: data.message,
                    duration: 2.5
                });
            });
        }
      });
    }
  }
};
</script>

<style>

</style>
