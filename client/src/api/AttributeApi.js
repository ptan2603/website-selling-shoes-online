import Axios from '../services/Axios.js'

export const getAttribute = (id, size) =>{
    const url = `/api/attribute/get-by-product?id=${id}&size=${size}`;
    return Axios.get(url);
}

export const getAttributeById = (id) =>{
    const url = `/api/attribute/get-by-id/${id}`;
    return Axios.get(url);
}

export const cacheAttribute = (data) =>{
    const url = `api/cache-attribute`;
    return Axios.post(url, data);
}

export const backAttribute = (data) =>{
    const url = `api/back-attribute`;
    return Axios.post(url, data);
}