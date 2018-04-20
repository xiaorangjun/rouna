<template>
        <Row :gutter="10">
            <Col span="12" style="margin-bottom: 10px;">
                <Card style="text-align: center">
                    <p slot="title">
                        <Icon type="ios-film-outline"></Icon>
                        成绩录入
                    </p>
                    <Row :gutter="10">
                        <Col span="12" style="margin-bottom: 10px">
                            <Select v-model="defaultStudent" placeholder="请选择学员" filterable clearable>
                                <Option v-for="student in students" :value="student.id" :key="student.id">{{ student.name }}</Option>
                            </Select>
                        </Col>
                        <Col span="12" style="margin-bottom: 10px">
                            <Select v-model="defaultTest" placeholder="请选择考试">
                                <Option v-for="test in tests" :value="test.id" :key="test.id">{{ test.name }}</Option>
                            </Select>
                        </Col>
                    </Row>

                    <Row :gutter="10" style="margin-bottom: 10px">
                        <Col span="8">
                            <Input  v-model="value" placeholder="语文" ></Input>
                        </Col>
                        <Col span="8">
                            <Input  v-model="value" placeholder="数学" ></Input>
                        </Col>
                        <Col span="8">
                            <Input  v-model="value" placeholder="英语" ></Input>
                        </Col>
                    </Row>
                    <Row :gutter="10" style="margin-bottom: 10px">
                        <Col span="8">
                        <Input  v-model="value" placeholder="物理" ></Input>
                        </Col>
                        <Col span="8">
                        <Input  v-model="value" placeholder="化学" ></Input>
                        </Col>
                        <Col span="8">
                        <Input  v-model="value" placeholder="生物" ></Input>
                        </Col>
                    </Row>
                    <Row :gutter="10" style="margin-bottom: 10px">
                        <Col span="8">
                        <Input  v-model="value" placeholder="政治" ></Input>
                        </Col>
                        <Col span="8">
                        <Input  v-model="value" placeholder="历史" ></Input>
                        </Col>
                        <Col span="8">
                        <Input  v-model="value" placeholder="地理" ></Input>
                        </Col>
                    </Row>

                    <Row :gutter="10" style="margin-bottom: 10px">
                        <Col span="24" style="text-align: right">
                            <Button type="primary">保存</Button>
                        </Col>
                    </Row>
                </Card>
            </Col>
        </Row>
</template>
<script>
    export default{
        data(){
            return {
                defaultStudent:"001",
                students:[
                    {"id":"001","name":"王茂婷"},
                    {"id":"002","name":"张三"},
                    {"id":"003","name":"李四"}
                ],
                defaultTest:"003",
                tests:[
                    {"id":"001","name":"10月月考"},
                    {"id":"002","name":"11月月考"},
                    {"id":"003","name":"12月月考"}
                ]
            }
        },
        created(){
            this.fetchData();
        },
        watch: {
            // 如果路由有变化，会再次执行该方法
            '$route': 'fetchData'
        },
        methods:{
            fetchData() {
                console.info("route changed");
            }
        }
    }



</script>