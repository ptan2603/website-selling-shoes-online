import Axios from '../services/Axios.js'

export const getAllProducts = (page, size, active) =>{
    const url = `/api/product/get-all?page=${page}&size=${size}&active=${active}`;
    return Axios.get(url);
}

export const filterProducts = (data) =>{
    const url = `/api/product/filter`;
    return Axios.post(url, data);
}

export const getProductById = (id) =>{
    const url = `/api/product/detail/${id}`;
    return Axios.get(url);
}

export const getTotalPage = () =>{
    const url = `/api/product/total-page`;
    return Axios.get(url);
}

export const relateProduct = (id, brand) =>{
    const url = `/api/product/relate?relate=${brand}&id=${id}`;
    return Axios.get(url);
}

export const searchByKeyword = (page, size, keyword) =>{
    const url = `/api/products/search?page=${page}&size=${size}&keyword=${keyword}`;
    return Axios.get(url);
}