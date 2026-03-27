<!-- // FormCompoennt => form chua dung cho chuc nang: Add/Update/Detail 
  -->
<!-- SFC: template, script, style   -->
<!-- vbase 3:setup -->
<template>
  <h1>Quan ly the loai</h1>
  <FormCategoryComponent />
  <table border="1" cellpadding="10" cellspacing="1">
    <thead>
      <tr>
        <th>STT</th>
        <th>Category code</th>
        <th>Category name</th>
      </tr>
    </thead>
    <tbody>
      <!-- <v-for >
        // tu lam 
      </v-for> -->
    </tbody>
  </table>
</template>

<script setup>
import FormCategoryComponent from '@/component/FormCategoryComponent.vue'
import { getListCategory } from '@/service/CategoryService'
import { onMounted, ref } from 'vue'
const list = ref([])
const fetchData = async () => {
  list.value = await getListCategory()
}
// onMounted: Lay gia tri tu API gan vao dom
onMounted(fetchData)
</script>

<style lang="css" scoped>
h1 {
  text-align: center;
}
</style>
