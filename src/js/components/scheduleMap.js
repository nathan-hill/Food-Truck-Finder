import React, { Component } from "react";

import GoogleMap from "google-map-react";
import { geolocated } from "react-geolocated";
import BeenhereIcon from "@material-ui/icons/Beenhere";
import LocalShippingIcon from "@material-ui/icons/LocalShipping";

export class ScheduleMap extends Component {
  constructor(props) {
    super(props);
    this.state = {
      location: { lat: 0, lng: 0 },
    };

    this.moveTruck = this.moveTruck.bind(this);
  }

  moveTruck(e) {
    console.log(e);
    this.setState({ location: { lat: e.lat, lng: e.lng } });
    this.props.onClick(this.props.idx, this.state.location);
  }

  render() {
    return !this.props.isGeolocationAvailable ? (
      <div>Your browser does not support Geolocation</div>
    ) : !this.props.isGeolocationEnabled ? (
      <div>Geolocation is not enabled</div>
    ) : this.props.coords ? (
      // Important! Always set the container height explicitly
      <div style={{ height: "100vh", width: "100%", overflowX: "hidden" }}>
        <GoogleMap
          defaultCenter={[
            this.props.coords.latitude,
            this.props.coords.longitude,
          ]}
          defaultZoom={15}
          onClick={this.moveTruck}
        >
          <LocalShippingIcon
            color="primary"
            lat={this.state.location.lat}
            lng={this.state.location.lng}
          />

          <BeenhereIcon
            color="secondary"
            lat={this.props.coords.latitude}
            lng={this.props.coords.longitude}
          />
        </GoogleMap>
      </div>
    ) : (
      <div>Getting the location data&hellip; </div>
    );
  }
}

export default geolocated({
  positionOptions: {
    enableHighAccuracy: false,
  },
  userDecisionTimeout: 5000,
})(ScheduleMap);
