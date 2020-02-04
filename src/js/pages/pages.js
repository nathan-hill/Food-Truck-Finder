import React from "react";
import { Link } from "react-router-dom";
import { Page1Data } from "./Page1Data";
import { Page2Data } from "./Page2Data";
import { TwoFieldForm } from "../components/TwoFieldForm";
import axios from "axios";

export class Home extends React.Component {
  render() {
    return (
      <div className="container padded">
        This is not the home page.
        <ul>
          <li>
            <Link to="/Page1">Page1</Link>
          </li>
          <li>
            <Link to="/Page2">Page2</Link>
          </li>
          <li>
            <Link to="/Request">Request from DB</Link>
          </li>
        </ul>
      </div>
    );
  }
}

function generateUserList() {
  var requestData = []
  axios({
    method: "get",
    url: "http://localhost:8080/demo/all",
    headers: {
      "content-type": "application/json",
      Accept: "application/json"
    }
  })
    .then(function(response) {
      console.log(response.data);
      requestData = response.data;
    })
    .catch(function(error) {
      console.log(error);
    });

    return requestData;
}

export class DatabaseListing extends React.Component {
  constructor(props) {
    super(props);

    var userList = generateUserList();
    console.log("here")
    console.log(userList);

    if (userList !== "undefined") {
      userList = [];
    }

    var method = function(){
      console.log(this.userList);
    }

    this.state = {
      users: userList, things: ["a", "b"],
    };
  }

  addUser(e) {
    e.preventDefault();

    const user = {
      name: e.target.elements.name.value,
      email: e.target.elements.email.value
    };

    axios({
      method: "post",
      url: "http://localhost:8080/demo/add",
      data: user,
      headers: {
        "content-type": "application/json",
        Accept: "application/json"
      }
    })
      .then(function(response) {
        //console.log(response);
        var newUsers = generateUserList();
        console.log(generateUserList());
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

export class Page1 extends React.Component {
  render() {
    return (
      <div>
        <Link to="/">Back</Link>
        <Page1Data />
      </div>
    );
  }
}

export class Page2 extends React.Component {
  render() {
    return (
      <div>
        <Link to="/">Back</Link>
        <Page2Data />
      </div>
    );
  }
}
