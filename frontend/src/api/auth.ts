import Cookies from "js-cookie";
import axios from 'axios';

const api = axios.create({
    baseURL: 'http://localhost:8082/broker',
    withCredentials: true,

});

api.interceptors.request.use(
    config => {
        const token = Cookies.get('token');
        if (token) {
            config.headers['Authorization'] = `Bearer ${token}`;
        }
        return config;
    },
    error => {
        return Promise.reject(error);
    }
);

export default api;

