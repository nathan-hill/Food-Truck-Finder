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
    data: { email: u.email, password: u.password },
    url: backend_url + "login/",
    headers: { "content-type": "application/json" }
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

export function postNewUser(u) {
  axios({
    method: "POST",
    url: backend_url + "users/add/",
    data: {
      email: u.email,
      password: u.password
    },
    headers: { "content-type": "application/json", Accept: "application/json" }
  })
    .then(function(response) {
      console.log(response.data);
    })
    .catch(function(error) {
      console.log(error);
    });
}
