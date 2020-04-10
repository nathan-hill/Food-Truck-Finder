import React, { Component } from "react";
import userSettings from "./UserSettings";

export default class DrawerDecider extends Component {
  constructor(props){
    super(props)
  }
  render() {
    const customerSettings = userSettings;
    return (
      <div>
        {this.props.state}
      </div>
    );
  }
}
