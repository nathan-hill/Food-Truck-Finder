import React, { Component } from "react";
import * as Request from "./../helpers/backendRequests";

export class ListOfUsers extends Component {
  constructor(props) {
    super(props);

    this.state = {
      users: []
    };
  }

  async onComponentDidMount() {
    var users = await Request.getAllUsers();

    this.setState({ users: users });
  }

  render() {
    return (
      <div>
        {this.state.users.map(u => (
          <p>u</p>
        ))}
      </div>
    );
  }
}

export default ListOfUsers;
