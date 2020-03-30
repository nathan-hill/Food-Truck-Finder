import axios from "axios";
var constants = require("./../helpers/constants");

const request_headers = {
  "Access-Control-Allow-Origin": "*",
  "content-type": "application/json",
  Accept: "application/json"
};

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

export function getUserByID(i) {
  return axios({
    method: "GET",
    url: constants.backend_url + "users/getUserByID",
    params: { id: i },
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
      return response.data;
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
  };
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

export async function getAllTrucks() {
  return await axios({
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

export async function getUserPreferences(id) {
  return await axios({
    method: "GET",
    url: constants.backend_url + "upref/getUPreferencesByID",
    params: { id: id }
  })
    .then(function(res) {
      console.log(res.data);
      return res.data;
    })
    .catch(function(e) {
      console.log(e);
      return e;
    });
}

export async function getUserSettings(id){
  return await axios({
    method: "GET",
    url: constants.backend_url + "users/getUserByID",
    params: { id: id }
  })
    .then(function(res) {
      console.log(res.data);
      return res.data;
    })
    .catch(function(e) {
      console.log(e);
      return e;
    });

}

export function getPreferredTrucks(id, lon, lat) {
  console.log("making request for preferred trucks");
  console.log(id + " " + lon + " " + lat);
  return axios({
    method: "GET",
    url: constants.backend_url + "upref/getPreferred",
    params: {
      id: id,
      lon: lon,
      lat: lat
    },
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
