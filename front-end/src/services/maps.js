import axios from 'axios';
import * as user from './login'

/**
 * api 키 가져오기
 */
export function getApiKey() {
    const auth = user.getAuthData();    
    return axios.get('/api/v1/apiKey', {
        auth,
        "headers": {
            "WWW-Authenticate": "Basic",
            "Content-Type": "application / json",
        },
    });
}
/**
 * 장소검색
 * @param {*} param0 
 */
export function getLocalKeyword({ query, size, page }) {
    const auth = user.getAuthData();
    return axios.get('/api/v1/local/search/keyword', {
            params: {
                query,
            size, page,
            }
        }, {
        auth,
        "headers": { 
            "WWW-Authenticate": "Basic",
            "Content-Type": "application / json",
         },
    });
}

/**
 * 인기 키워드 목록
 */
export function getHotKeyword() {
    const auth = user.getAuthData();
    return axios.get('/api/v1/hotkeyword', {
        auth,
        "headers": {
            "WWW-Authenticate": "Basic",
            "Content-Type": "application / json",
        },
    });
}