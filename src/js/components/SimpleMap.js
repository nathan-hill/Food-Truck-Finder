import React, { Component } from "react";

import GoogleMapReact from "google-map-react";
import { geolocated } from "react-geolocated";
import LocalShippingIcon from '@material-ui/icons/LocalShipping';

export class SimpleMap extends Component {
  render() {
    return !this.props.isGeolocationAvailable ? (
      <div>Your browser does not support Geolocation</div>
    ) : !this.props.isGeolocationEnabled ? (
      <div>Geolocation is not enabled</div>
    ) : this.props.coords ? (
      // Important! Always set the container height explicitly
      <div style={{ height: "100vh", width: "100%", overflowX:"hidden"}}>
        <GoogleMapReact
          defaultCenter={[
            this.props.coords.latitude,
            this.props.coords.longitude
          ]}
          defaultZoom={15}
        >
          {this.props.children}
          <LocalShippingIcon lat={this.props.coords.latitude} lng={this.props.coords.longitude}
          text="My Marker" />
        </GoogleMapReact>
      </div>
    ) : (
      <div>Getting the location data&hellip; </div>
    );
  }
}

export default geolocated({
  positionOptions: {
    enableHighAccuracy: false
  },
  userDecisionTimeout: 5000
})(SimpleMap);
