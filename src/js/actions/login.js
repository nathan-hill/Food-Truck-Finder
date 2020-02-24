import axios from 'axios'
import setAuthorizationToken from "../helpers/setAuthorizationToken";
import jwtDecode from "jwt-decode";
import {SET_CURRENT_USER} from "./types";

export function setCurrentUser(user) {
    return {
        type: SET_CURRENT_USER,
        user
    }
}

export function logout() {
    return dispatch => {
        localStorage.removeItem("jwtToken");
        setAuthorizationToken(false);
        dispatch(setCurrentUser({}));
    }
}

export function login(data) {
    data.headers = {
        "Access-Control-Allow-Origin": "*",
        "content-type": "application/json",
        Accept: "application/json"
    };

    data.data = {
        "usernameOrEmail" : data.username,
        "password" : data.password
    };

    console.log(data);

    return dispatch => {
        return axios.post("http://localhost:8080/api/auth/signin",data).then(res => {
           const token = res.data.accessToken;
           localStorage.setItem("jwtToken",token);
           setAuthorizationToken(token);
           dispatch(setCurrentUser(jwtDecode(token)));
        });
    }
}