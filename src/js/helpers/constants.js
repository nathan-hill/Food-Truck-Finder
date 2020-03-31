if (
  !window.location.href.includes("localhost") &&
  !window.location.href.includes("https") &&
  window.location.href.includes("http")
) {
  window.open("https://wheels-with-meals-frontend.herokuapp.com", "_self");
}

let backend_url = "";
let frontend_url = "";
if (window.location.hostname === "localhost") {
  backend_url = "http://localhost:8080/v/";
  frontend_url = "http://localhost:3000";
} else {
  //we aren't running locally
  backend_url = "https://wheels-with-meals-backend.herokuapp.com/v/";
  frontend_url = "https://wheels-with-meals-frontend.herokuapp.com/";
}

exports.backend_url = backend_url;
