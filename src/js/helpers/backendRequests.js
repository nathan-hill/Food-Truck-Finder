import axios from "axios";

const backend_url = "http://localhost:8080/v/";
//const backend_url = "https://wheels-with-meals-backend.herokuapp.com/v/"

const request_headers = {
      "Access-Control-Allow-Origin": "*",
      "content-type": "application/json",
      Accept: "application/json"
}

export function getAllUsers() {
  return axios({
    method: "GET",
    url: backend_url + "users/",
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
    url: backend_url + "api/auth/signup",
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
    url: backend_url + "users/update/",
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
    url: backend_url + "trucks/add/",
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
    url: backend_url + "trucks/",
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