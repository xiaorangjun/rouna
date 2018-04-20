<template>
<div>
  <Button @click="handleGet">GET</Button>
  <Button @click="handlePost">POST</Button>
  <Button @click="handlePut">PUT</Button>
  <Button @click="handleDelete">DELETE</Button>
</div>
</template>
<script>
export default {
  data(){
      return {

      }
  },
  methods:{
      handlePost(){
          console.info("post")
          this.$post("/api/v1/user/list",{}).then(data=>{
              console.info(data);
          }).catch(data=>{

          })
      },
      handleGet(){
          this.$get("/api/v1/user/info").then(data=>{
              console.info(data);
          }).catch(data=>{

          })
      },
      handlePut(){
          console.info("put")
      },
      handleDelete(){
          console.info("delete")
      }
  }
}
</script>

