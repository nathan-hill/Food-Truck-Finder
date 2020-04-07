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

export function markMessageRead(i) {
  const request = {
    method: "POST",
    url: constants.backend_url + "message/markMessageAsRead",
    params: { id: i },
    headers: request_headers
  };
  console.log(request);

  return axios(request)
    .then(function(response){
      console.log(response.data);
      return response.data;
    })
    .catch(function(error){
      console.log(error);
    });
  
}

export function deleteMessage(i) {
  const request = {
    method: "POST",
    url: constants.backend_url + "message/deleteMessage",
    params: { id: i },
    headers: request_headers
  };
  console.log(request);

  return axios(request)
    .then(function(response){
      console.log(response.data);
      return response.data;
    })
    .catch(function(error){
      console.log(error);
    });
  
}

export function getUnreadNotifications(i) {
  //return 1    //for testing
  return(axios({
    method: "GET",
    url: constants.backend_url + "message/getUnreadMessagesByUserS",
    params: { id : i },
    headers: request_headers
  })
    .then(response => {
      console.log(response.data);
      this.responseData = response.data;
      return response.data;
    })
    .catch(function(error){
      console.log(error);
    })).length;
  
}


export async function getUserByID(i) {
  return await axios({
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

export async function postNewUser(u) {
  const request = {
    method: "POST",
    url: constants.backend_url + "api/auth/signup",
    data: u,
    headers: request_headers
  };

  console.log(request);

  return await axios(request)
    .then(function(response) {
      console.log(response.data);
      return response.data;
    })
    .catch(function(error) {
      console.log(error);
    });
}

export async function postNewTruck(t) {
  const request = {
    method: "POST",
    url: constants.backend_url + "trucks/add/",
    data: t,
    headers: request_headers
  };

  console.log(request);

  return await axios(request)
    .then(function(response) {
      console.log(response.data);
      return response;
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

<<<<<<< HEAD
<<<<<<< HEAD
export async function getUserPreferences(id) {
  return await axios({
=======
export function getTrucksForToday() {
  return axios({
>>>>>>> ddc2ca05c3b941224bdd412fda1aca72b699f4f9
    method: "GET",
    url: constants.backend_url + "schedule/getTrucksForToday",
    headers: request_headers
  })
    .then(function(response) {
      console.log(response.data);
      return response.data;
    })
    .catch(function(error) {
      console.log(error);
      return error;
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

export async function getPreferredTrucks(id, lon, lat) {
  console.log("making request for preferred trucks")
  console.log(id + " " + lon + " " + lat);
  return await axios({
    method: "GET",
    url: constants.backend_url + "upref/getPreferred",
    params: {
      id: id,
      lon: lon,
      lat: lat
    },
<<<<<<< HEAD
=======
export async function sendNotification(data){
  return await axios({
    method: "POST",
    url: constants.backend_url + "sendNotification/",
    params:{data:data},
>>>>>>> 1e77dfbb109633ba20bf8ab54489518a192161f6
=======
>>>>>>> ddc2ca05c3b941224bdd412fda1aca72b699f4f9
    headers: request_headers
  })
    .then(function(response) {
      console.log(response.data);
      return response.data;
    })
    .catch(function(error) {
      console.log(error);
    });
<<<<<<< HEAD
<<<<<<< HEAD
=======
}

export async function sendNotification(data){
  return await axios({
    method: "POST",
    url: constants.backend_url + "message/sendToAllByTruckId",
    data: data,
    headers: request_headers
  })
    .then(function(response) {
      console.log(response.data);
      return response.data;
    })
    .catch(function(error) {
      console.log(error);
    });
>>>>>>> ddc2ca05c3b941224bdd412fda1aca72b699f4f9
}


export async function getUPById(id) {
  return await axios({
    method: "GET",
    url: constants.backend_url + "upref/getUPreferencesByID",
    params: {id},
    headers: request_headers
  })
    .then(function(response) {
      console.log(response.data);
      return response.data;
    })
    .catch(function(error) {
      console.log(error);
      return error;
    });
}
<<<<<<< HEAD
=======
}
>>>>>>> 1e77dfbb109633ba20bf8ab54489518a192161f6
=======
>>>>>>> ddc2ca05c3b941224bdd412fda1aca72b699f4f9
