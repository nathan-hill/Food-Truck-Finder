import React from "react";
import { Link } from "react-router-dom";

import { TwoFieldForm } from "../components/TwoFieldForm";
import LoginPage from "./LoginPage";
import axios from "axios";
import SimpleMap from "./GoogleTest";
import * as Request from "../helpers/backendRequests";

export class Home extends React.Component {
  render() {
    return (
      <div className="container padded">
        This is not the home page.
        <ul>
          <li>
            <Link to="/Request">Request from DB</Link>
          </li>
          <li>
            <Link to="/loginpage"> Log In </Link>
          </li>
          <li>
            <Link to="/GoogleTest">GoogleTest</Link>
          </li>
        </ul>
      </div>
    );
  }
}

const sendFormDataPostNewUser = function(e) {
  e.preventDefault();
  const user = {
    email: e.target.elements.email.value,
    password: e.target.elements.password.value
  };

  console.log(user);

  return Request.postNewUser(user);
};

export class DatabaseListing extends React.Component {
  render() {
    return (
      <div>
        <Link to="/loginpage/">Back</Link>
        <TwoFieldForm
          action={sendFormDataPostNewUser}
          fieldOne={"email:"}
          fieldTwo={"password:"}
          buttonLabel={"Submit"}
        />
      </div>
    );
  }
}

const sendFormDataLoginUser = function(e) {
  e.preventDefault();

  const user = {
    email: e.target.elements.email.value,
    password: e.target.elements.password.value
  };

  console.log(user);

  var requestData = Request.logInUser(user);

  console.log(requestData);

};

export class Login extends React.Component {
  constructor(props) {
    super(props);


    this.state = {
      redirect: "",
    };

    this.sendFormDataLoginUser = sendFormDataLoginUser.bind(this);
  }

  render() {
    return (
      <div>
        <Link to="/">Back</Link>
        <LoginPage action={sendFormDataLoginUser} redirect={this.state.redirect}/>
      </div>
    );
  }
}

export class GoogleTest extends React.Component {
  render() {
    return (
      <div>
        <SimpleMap />
      </div>
    );
  }
}
