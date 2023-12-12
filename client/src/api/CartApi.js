import Axios from '../services/Axios.js'

export const getCartItemByAccountId = (id) =>{
    const url = `/api/cart/get-by-account-id/${id}`;
    return Axios.get(url);
}

// export const getCartItems = () =>{
//     const url = `/api/cart/get-all`;
//     return Axios.get(url);
// }

export const modifyCartItem = (data) =>{
    const url = `/api/cart/modify`;
    return Axios.post(url, data);
}

export const removeCartItem = (data) =>{
    const url = `/api/cart/remove`;
    return Axios.post(url, data);
}
export const clearCartItem = (id) =>{
    const url = `/api/cart/clear`;
    return Axios.post(url, id);
}
export const isEnoughCartItem = (id, quantity) =>{
    const url = `/api/cart/is-enough?id=${id}&quantity=${quantity}`;
    return Axios.get(url);
}