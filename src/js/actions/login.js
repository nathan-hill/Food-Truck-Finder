import axios from "axios";
import setAuthorizationToken from "../helpers/setAuthorizationToken";
import jwtDecode from "jwt-decode";
import { SET_CURRENT_USER } from "./types";
import * as Request from "./../helpers/backendRequests";
var constants = require("./../helpers/constants");

export function setCurrentUser(user) {
  return {
    type: SET_CURRENT_USER,
    user,
  };
}

export function logout() {
  return (dispatch) => {
    localStorage.removeItem("jwtToken");
    setAuthorizationToken(false);
    dispatch(setCurrentUser({}));
    localStorage.removeItem("role");
  };
}

export function login(data, callback) {
  callback(true);
  data.headers = {
    "Access-Control-Allow-Origin": "*",
    "content-type": "application/json",
    Accept: "application/json",
  };

  data.usernameOrEmail = data.username;

  return (dispatch) => {
    return axios
      .post(constants.backend_url + "api/auth/signin", data)
      .then(async (res) => {
        const token = res.data.accessToken;
        let decodedToken = jwtDecode(token);
        localStorage.setItem("jwtToken", token);
        setAuthorizationToken(token);

        let user = "";
        user = await Request.getUserByID(decodedToken.sub)
          .then(function (r) {
            return r;
          })
          .catch((e) => {
            callback(false);
          });

        localStorage.setItem("role", user.type);
        dispatch(setCurrentUser(jwtDecode(token)));
        return user
      })
      .catch((e) => {
        callback(false);
        return null;
      });
  };
}

let initJwtToken = localStorage.getItem("jwtToken")
if(initJwtToken) {
    setAuthorizationToken(initJwtToken)
    setCurrentUser(jwtDecode(initJwtToken));
}