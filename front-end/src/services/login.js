import axios from 'axios';

/**
 * 회원정보 확인
 * @param {*} auth 
 */
export function getUserInfo(auth) {
    return axios.get('/api/v1/user/info',{
        auth,
        "headers": {"WWW-Authenticate": "Basic"},
    });
}

/**
 * 회원가입
 * @param {*} param0 
 */
export function userJoin({ userId, userName, userPassword }) {  
     
    return axios.post('/api/v1/user/join', null, {
        params: {
            userId, userName, userPassword
        }
    });
}

/**
 * 저장된 회원정보 확인
 */
export function loginCheck(){
    const auth = getAuthData();
    return auth !== null && typeof auth !== 'undefined';
}

/**
 * 저장된 회원정보 출력
 */
export function getAuthData(){
    try {
        const auth = localStorage.getItem('auth');
        return JSON.parse(auth);
    } catch (error) {
        //console.log(error);
       return undefined; 
    }
    
}

/**
 * 과거에 검색한 데이터 가져오기
 */
export function getUserInfoKeyword() {
    const auth = getAuthData();
    return axios.get('/api/v1/user/info/keyword', {
        auth,
        "headers": { "WWW-Authenticate": "Basic" },
    });
}