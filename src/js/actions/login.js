import axios from "axios";
import setAuthorizationToken from "../helpers/setAuthorizationToken";
import { SET_CURRENT_USER } from "./types";
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
  callback(true, false);
  data.headers = {
    "Access-Control-Allow-Origin": "*",
    "content-type": "application/json",
    Accept: "application/json",
  };

  data.usernameOrEmail = data.username;

  return axios
    .post(constants.backend_url + "api/auth/signin", data)
    .then(async (res) => {
      console.error("got signed in", res);
      const token = res.data.jwt.accessToken;
      // let decodedToken = jwtDecode(token);
      localStorage.setItem("jwtToken", token);
      setAuthorizationToken(token);
      dispatch(setCurrentUser(res.data.u));

      localStorage.setItem("role", res.data.u.type);
      callback(false, false);
      return res.data.u;
    })
    .catch((e) => {
      console.error("failed to login", e);
      callback(false, true);
      return null;
    });
}
