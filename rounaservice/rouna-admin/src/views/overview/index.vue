<style>
    @import "index.less";
</style>
<template>
    <div id="overview">
        <Row :gutter="10">

            <Col span="6" style="margin-bottom: 10px;">
            <Card style="text-align: center">
                <h1><a href="#" @click="goto('{{classManage.path}}')">{{classManage.title}}</a></h1>
            </Card>
            </Col>
            <Col span="6" style="margin-bottom: 10px;">
            <Card style="text-align: center">
                <h1><a href="#" @click="goto('{{studentManage.path}}')">{{studentManage.title}}</a></h1>
            </Card>
            </Col>
            <Col span="6" style="margin-bottom: 10px;">
            <Card style="text-align: center">
                <h1><a href="#" @click="goto('{{test.path}}')" >{{test.title}}</a></h1>
            </Card>
            </Col>
            <Col span="6" style="margin-bottom: 10px;">
            <Card style="text-align: center">
                <h1><a href="#" @click="goto(markAnalysis.path)"><Icon type="podium" /></icon> {{markAnalysis.title}}</a></h1>
            </Card>
            </Col>
        </Row>
    </div>

</template>
<script>
    export default{
        data(){
            return {
                classManage:{
                    title:"班级管理",
                    path:"overview_index"
                },
                studentManage:{
                    title:"学员管理",
                    path:"student"
                },
                test:{
                    title:"模拟考试",
                    path:"modetest"
                },
                markAnalysis:{
                    title:"成绩分析",
                    path:"mark"
                }
            }
        },
        methods:{
            goto:function (name) {
                this.$router.push(name)
            }
        }
    }
</script>