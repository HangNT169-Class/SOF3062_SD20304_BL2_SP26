// chua logic FE
// convert json ve dinh dang tuong ung
// hien thi => json => list
// B1: Tach duong dan chung
const API = 'http://localhost:8080/api/category-management'

// xu ly lan luot cac API
// function a(){
// }
// const a = ()=>{}
// muon noi khac goi duoc => export
// KHI LAM VIEC VS API => BAT DONG BO: async .. await
// GET => Hien thi du lieu
export const getListCategory = async () => {
  const res = await fetch(API)
  // check list k ton tai
  if (!res.ok) {
    throw new Error('Load du lieu that bai')
  }
  return await res.json()
}
// GET => Detail
export const detailCategory = async (id) => {
  const res = await fetch(`${API}/detail/${id}`)
  // check list k ton tai
  if (!res.ok) {
    throw new Error('Load du lieu that bai')
  }
  return await res.json()
}
// Delete => DELETE
export const deleteCategory = async (id) => {
  const res = await fetch(`${API}/remove/${id}`, {
    method: 'DELETE',
  })
  // check list k ton tai
  if (!res.ok) {
    throw new Error('Xoa du lieu that bai')
  }
}

// POST => ADD
export const addCategory = async (data) => {
  const res = await fetch(`${API}/add`, {
    method: 'POST',
    headers: {
      'Content-Type': 'application/json',
    },
    body: JSON.stringify(data), // Chi doi vs tham so @ResponseBody
  })
  // check list k ton tai
  if (!res.ok) {
    throw new Error('Add du lieu that bai')
  }
}
// PUT => UPDATE
export const updateCategory = async (data, id) => {
  const res = await fetch(`${API}/update/${id}`, {
    method: 'PUT',
    headers: {
      'Content-Type': 'application/json',
    },
    body: JSON.stringify(data), // Chi doi vs tham so @ResponseBody
  })
  // check list k ton tai
  if (!res.ok) {
    throw new Error('Update du lieu that bai')
  }
}
