import Axios from '../services/Axios.js'

export const signIn = (data) =>{
    const url = '/api/login';
    return Axios.post(url, data);
}
export const createAccount = (data) =>{
    const url = `/api/account/create`;
    return Axios.post(url, data);
}

export const registerAccount = (data) =>{
    const url = `/api/account/register`;
    return Axios.post(url, data);
}

export const forgotPassword = (data) =>{
    const url = '/api/forgot-password';
    return Axios.post(url, data);
}