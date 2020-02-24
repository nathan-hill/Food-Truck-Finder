import React, { Component } from "react";
import * as Request from "./../helpers/backendRequests";

export class ListOfUsers extends Component {
  constructor(props) {
      console.log("Hello")
    super(props);

    this.state = {
      users: []
    };
  }

  componentWillReceiveProps(props) {
  const { refresh } = this.props;
  if (props.refresh !== refresh) {
    Request.getAllUsers()
      .then(function(r){
          this.setState({users: r.data})
      })
  }
}

//   async componentDidMount() {
//       console.log("Mounted")
//     var users = await Request.getAllUsers();

//     this.setState({ users: users });
//   }

  render() {
    return (
      <div>
        {this.props.users.map(u => (
          <p>{u.email} {u.password}</p>
        ))}
      </div>
    );
  }
}

export default ListOfUsers;
