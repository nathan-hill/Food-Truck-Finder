import axios from "axios";
var constants = require("./../helpers/constants")

const request_headers = {
      "Access-Control-Allow-Origin": "*",
      "content-type": "application/json",
      Accept: "application/json"
}

export function getAllUsers() {
  return axios({
    method: "GET",
    url: constants.backend_url + "users/",
    headers: request_headers
  })
    .then(function(response) {
      console.log(response.data);
      return response.data;
    })
    .catch(function(error) {
      console.log(error);
    });
}

export function getUserByID(i){
  return axios({
    method: "GET",
    url: constants.backend_url + "users/getUserByID",
    params: {id: i},
    headers: request_headers
  })
    .then(function(response) {
      console.log(response.data);
      return response.data;
    })
    .catch(function(error) {
      console.log(error);
    });
}

export function postNewUser(u) {
  const request = {
    method: "POST",
    url: constants.backend_url + "api/auth/signup",
    data: u,
    headers: request_headers
  };

  console.log(request);

  return axios(request)
    .then(function(response) {
      console.log(response.data);
      return response.data
    })
    .catch(function(error) {
      console.log(error);
    });
}

export function UpdateUser(u) {
  const request = {
    method: "POST",
    url: constants.backend_url + "users/update/",
    data: u,
    headers: {
      "Access-Control-Allow-Origin": "*",
      "content-type": "application/json",
      Accept: "application/json"
    }
  }
}

export function postNewTruck(t) {
  const request = {
    method: "POST",
    url: constants.backend_url + "trucks/add/",
    data: t,
    headers: request_headers
  };

  console.log(request);

  axios(request)
    .then(function(response) {
      console.log(response.data);
    })
    .catch(function(error) {
      console.log(error);
    });
}

export function getAllTrucks() {
  return axios({
    method: "GET",
    url: constants.backend_url + "trucks/",
    headers: request_headers
  })
    .then(function(response) {
      console.log(response.data);
      return response.data;
    })
    .catch(function(error) {
      console.log(error);
    });
}

export async function sendNotification(data){
  return await axios({
    method: "POST",
    url: constants.backend_url + "sendNotification/",
    params:{data:data},
    headers: request_headers
  })
    .then(function(response) {
      console.log(response.data);
      return response.data;
    })
    .catch(function(error) {
      console.log(error);
    });
}