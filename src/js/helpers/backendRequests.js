import axios from "axios";

const backend_url = "http://localhost:8080/v/";

export function getAllUsers() {
  axios({
    method: "GET",
    url: backend_url + "users/all",
    headers: { "content-type": "application/json", Accept: "application/json" }
  })
    .then(function(response) {
      console.log(response.data);
    })
    .catch(function(error) {
      console.log(error);
    });
}

export function logInUser(u) {
  const request = {
    method: "GET",
    url: backend_url + "login/",
    data: u, 
    headers: { "content-type": "application/json", Accept: "application/json" }
  }

  console.log(request);

  axios(request)
    .then(function(response) {
      console.log(response.data);
    })
    .catch(function(error) {
      console.log(error);
    });
}

export function postNewUser(u) {
  const request = {
    method: "POST",
    url: backend_url + "users/add/",
    data: u,
    headers: { "content-type": "application/json", Accept: "application/json" }
  }

  console.log(request);

  axios(request)
    .then(function(response) {
      console.log(response.data);
    })
    .catch(function(error) {
      console.log(error);
    });
}
