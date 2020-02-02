import React from "react";
import { Link } from "react-router-dom";
import {LoginData} from './LoginData'
import {Page1Data} from './Page1Data'
import {Page2Data} from './Page2Data'

export class Home extends React.Component {
  render() {
    return (
      <div className="container padded">
        This is the home page.
        <ul>
          <li>
            <Link to="/Page1">Page1</Link>
          </li>
          <li>
            <Link to="/Page2">Page2</Link>
          </li>
          <li>
              <Link to="/Login">Login</Link>
          </li>
        </ul>
      </div>
    );
  }
}

export class Login extends React.Component {
  render() {
    return (
      <div>
        <LoginData />
      </div>
    );
  }
}

export class Page1 extends React.Component {
  render() {
    return (
      <div>
        <Page1Data />
      </div>
    );
  }
}

export class Page2 extends React.Component {
  render() {
    return (
      <div>
        <Page2Data />
      </div>
    );
  }
}
