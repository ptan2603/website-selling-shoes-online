import Axios from '../services/Axios.js'

//trả về thông tin chi tiết của tài khoản có mã id
export const getAccountDetailByAccountId = (id) =>{
    const url = `/api/account/detail?id=${id}`;
    return Axios.get(url);
}

export const getMe = (token) =>{
    const url = `/api/me?token=${token}`;
    return Axios.get(url);
}
// //để cập nhật thông tin của tài khoản người dùng 
// export const updatepProfile = (data) =>{
//     const url = `/api/account/detail/update`;
//     return Axios.post(url, data);
// }

export const getByUsername = (username) =>{
    const url = `/api/account/find-by-username?username=${username}`;
    return Axios.get(url);
}