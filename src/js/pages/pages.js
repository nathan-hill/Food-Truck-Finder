import React from "react";
import { Link } from "react-router-dom";
import Dashboard from "./../components/Dashboard";
import SignUp from "../components/SignUp";
import { TwoFieldForm } from "../components/TwoFieldForm";
import LoginPage from "../components/LoginPage";
import * as Request from "../helpers/backendRequests";
import ListOfUsers from "./../components/ListOfUsers";
import FoodTruckDetails from "./../components/FoodTruckDetails";
import FoodTruckTable from "./../components/FoodTruckTable";
import CustomerSettings from "./../components/UserSettings";
import NotificationTable from "./../components/Notifications";
import SendNotificationForm from "./../components/SendNotifications";
import Button from "@material-ui/core/Button";
import FoodTruckPreferences from "../components/FoodTruckPreferences";

export class TestRouting extends React.Component {
  render() {
    return (
      <div className="container padded">
        This is not the home page.
        <ul>
          <li>
            <Link to="/Request">Request from DB</Link>
          </li>
          <li>
            <Link to="/Dashboard">Dashboard</Link>
          </li>
          <li>
            <Link to="/FoodTruckTable">FoodTruckTable</Link>
          </li>
          <li>
            <Link to="/Profile">User Profile</Link>
          </li>
          <li>
            <Link to="/create_account">Create Account</Link>
          </li>
          <li>
            <Link to="/SendNotifications">send Notification</Link>
          </li>
          <li>
            <Link to="/UserProfile">UserProfile</Link>
          </li>
          <li>
            <Link to="/FoodTruckPreference">Recommended Food Trucks</Link>
          </li>

        </ul>
      </div>
    );
  }
}

export class CreateAccount extends React.Component {
  constructor(props) {
    super(props);

    this.state = {
      status: ""
    };

    this.sendFormDataPostNewUser = this.sendFormDataPostNewUser.bind(this);
  }

  sendFormDataPostNewUser = async function(e) {
    e.preventDefault();
    const user = {
      email: e.target.elements.email.value,
      password: e.target.elements.password.value,
      name:
        e.target.elements.firstName.value + ' ' + e.target.elements.lastName.value,
      username: e.target.elements.username.value,
      type: e.target.elements.type.value
    };

    console.log(user);

    var status = await Request.postNewUser(user);

    console.log("The status is");
    console.log(status.message)

    this.setState({ status: status.message });
  };

  render() {
    console.log("redering the page as " + this.state.status);
    return (
      <div>
        <SignUp
          status={this.state.status}
          action={this.sendFormDataPostNewUser}
        />
      </div>
    );
  }
}

export class DatabaseListing extends React.Component {
  constructor(props) {
    super(props);

    this.state = {
      trucks: []
    };

    this.sendFormDataPostNewUser = this.sendFormDataPostNewTruck.bind(this);
  }

  async componentDidMount() {
    console.log("Mounted");
    var users = await Request.getAllTrucks();

    this.setState({ trucks: users });
  }

  sendFormDataPostNewTruck = function(e) {
    e.preventDefault();
    const truck = {
      name: e.target.elements.name.value,
      schedule: e.target.elements.schedule.value
    };

    //this.setState({users: this.state.users.push()});

    console.log(truck);

    return Request.postNewTruck(truck);
  };

  render() {
    return (
      <div>
        <Link to="/loginpage/">Back</Link>
        <TwoFieldForm
          action={this.sendFormDataPostNewTruck}
          fieldOne={"Food Truck Name"}
          fieldTwo={"Food Truck hours:"}
          buttonLabel={"Submit"}
        />
        <h3>List Of Owned Food Trucks</h3>
        <ListOfUsers trucks={this.state.trucks} />
      </div>
    );
  }
}



export class Login extends React.Component {
  constructor(props) {
    super(props);

    this.state = {
      redirect: ""
    };

  }

  render() {
    return (
      <div>
        <Link to="/">Back</Link>
        <LoginPage
          redirect={this.state.redirect}
        />
      </div>
    );
  }
}

export class Table extends React.Component {
  constructor(props) {
    super(props);

    this.state = {
      redirect: ""
    };
  }

  render() {
    return (
      <div>
        <Link to="/">Back</Link>
        <FoodTruckTable />
        <Button href="#/SendNotifications">
          Send Notification
        </Button>
      </div>
    );
  }
}

export class TruckDetails extends React.Component {
  render() {
      return(
        <div>
          <FoodTruckDetails/>
        </div>
      );
  }
}
export class UserProfile extends React.Component {
  constructor(props) {
    super(props);

    this.state = {
      redirect: ""
    };
  }

  render() {
    return (
      <div>
        <Link to="/">Back</Link>
        <CustomerSettings />
      </div>
    );
  }

}

export class Notifications extends React.Component {
  constructor(props) {
    super(props);

    this.state = {
      redirect: ""
    };
  }

  render() {
    return (
      <div>
        <Link to="/">Back</Link>
        <NotificationTable />
      </div>
    );
  }
}

export class SendNotification extends React.Component {
  constructor(props) {
    super(props);

    this.state = {
      redirect: ""
    };
  }

  render() {
    return (
      <div>
        <Link to="/">Dashboard</Link>
        <SendNotificationForm />
      </div>
    );
  }
}

export class OwnerProfile extends React.Component {
  constructor(props) {
    super(props);

    this.state = {
      redirect: ""
    };
  }

  render() {
    return (
      <div>
        <Link to="/">Back</Link>
        <CustomerSettings />
        <FoodTruckTable />
      </div>
    );
  }
}

export class CustPreferences extends React.Component {
  constructor(props) {
    super(props);

    this.state = {
      redirect: ""
    };
  }

  render() {
    return (
      <div>
        <Link to="/">Back</Link>
        <FoodTruckPreferences/>
      </div>
    );
  }

}



export class Home extends React.Component {
  render() {
    return (
      <div>
        <Dashboard />
      </div>
    );
  }
}
