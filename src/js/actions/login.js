import axios from "axios";
import setAuthorizationToken from "../helpers/setAuthorizationToken";
import jwtDecode from "jwt-decode";
import { SET_CURRENT_USER } from "./types";
import * as Request from "./../helpers/backendRequests";
var constants = require("./../helpers/constants");

export function setCurrentUser(user) {
  return {
    type: SET_CURRENT_USER,
    user
  };
}

export function logout() {
  return dispatch => {
    localStorage.removeItem("jwtToken");
    setAuthorizationToken(false);
    dispatch(setCurrentUser({}));
  };
}

export function login(data) {
  data.headers = {
    "Access-Control-Allow-Origin": "*",
    "content-type": "application/json",
    Accept: "application/json"
  };

  data.usernameOrEmail = data.username;

  console.log(data);

  return dispatch => {
    return axios
      .post(constants.backend_url + "api/auth/signin", data)
      .then(async res => {
        const token = res.data.accessToken;
        let decodedToken = jwtDecode(token);
        localStorage.setItem("jwtToken", token);
        setAuthorizationToken(token);

        console.log(decodedToken);

        let userRole = "";
        userRole = await Request.getUserByID(decodedToken.sub)
        .then(function(r) {
          return r.type;
        });

        console.log(userRole);

        localStorage.setItem("role", userRole);
        dispatch(setCurrentUser(jwtDecode(token)));
      });
  };
}
