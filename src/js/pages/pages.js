import React from "react";
import { Link } from "react-router-dom";
import { TwoFieldForm } from "../components/TwoFieldForm";
import  LoginPage  from "./LoginPage";
import axios from "axios";

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
        </ul>
      </div>
    );
  }
}

export class DatabaseListing extends React.Component {
  constructor(props) {
    super(props);
    console.log("here");
    console.log(this.userList);

    if (this.userList !== "undefined") {
      this.userList = [];
    }

    var method = function() {
      console.log(this.userList);
    };

    this.state = {
      users: this.userList,
      things: ["a", "b"]
    };

    this.addUser = this.addUser.bind(this);
    this.generateUserList = this.generateUserList.bind(this);
  }

  generateUserList() {
    var requestData = [];
    axios({
      method: "get",
      url: "https://wheels-with-meals-backend.herokuapp.com/demo/all",
      headers: {
        "content-type": "application/json",
        Accept: "application/json"
      }
    })
      .then(function(response) {
        console.log(response.data);
        requestData = response.data;
        return requestData;
      })
      .catch(function(error) {
        console.log(error);
      });
  }

  addUser(e) {
    e.preventDefault();

    const user = {
      name: e.target.elements.name.value,
      email: e.target.elements.email.value
    };

    axios({
      method: "post",
      url: "https://wheels-with-meals-backend.herokuapp.com/demo/add",
      data: user,
      headers: {
        "content-type": "application/json",
        Accept: "application/json"
      }
    })
      .then(function(response) {
        //console.log(response);
        var newUsers = this.generateUserList();
        console.log(newUsers);
        this.setState({ users: newUsers });
      })
      .catch(function(error) {
        console.log(error);
      });
  }

  render() {
    return (
      <div>
        <Link to="/">Back</Link>
        <TwoFieldForm
          action={this.addUser}
          fieldOne={"Name:"}
          fieldTwo={"Email:"}
          buttonLabel={"Submit"}
        />
        <br />
        Users Currently Registered
        <ul>
          {this.state.users.map(useritem => (
            <li>{useritem.name}</li>
          ))}
        </ul>
      </div>
    );
  }
}

export class Login extends React.Component {
  render() {
    return (
      <div>
        <Link to="/">Back</Link>
        <LoginPage />
      </div>
    );
  }
}
