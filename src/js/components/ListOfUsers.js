import React, { Component } from "react";
import * as Request from "./../helpers/backendRequests";

export class ListOfUsers extends Component {
  constructor(props) {
    super(props);

    this.state = {
      trucks: []
    };
  }

  componentWillReceiveProps(props) {
    const { refresh } = this.props;
    if (props.refresh !== refresh) {
      Request.getAllTrucks().then(function(r) {
        this.setState({ trucks: r.data });
      });
    }
  }

     async componentDidMount() {
         console.log("Mounted")
       var users = await Request.getAllUsers();

       this.setState({ users: users });
     }

  render() {
    return (
      <div>
        <table style={{ width: "50%",border: "1px solid black", textAlign: "left", borderCollapse: "collapse" }}>
          <tr>
            <th>Truck Name</th>
            <th>Schedule</th>
          </tr>
          {this.props.trucks.map(t => (
            <li>
              <td>{t.name}</td>
              <td>{t.schedule}</td>
            </li>
          ))}
        </table>
      </div>
    );
  }
}

export default ListOfUsers;
