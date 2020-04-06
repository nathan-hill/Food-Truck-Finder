import React, { Component } from "react";
import LocalShippingIcon from "@material-ui/icons/LocalShipping";
import GoogleMap from "google-map-react";
import { geolocated } from "react-geolocated";
import MapIcon from "./MapIcon";
import BeenhereIcon from "@material-ui/icons/Beenhere";

export class InteractiveMap extends Component {
  constructor(props) {
    super(props);
    this.state = {
      location: {
        lat: 0,
        lng: 0,
      },
    };

    this.onClick = this.onClick.bind(this);
  }

  onClick(e) {
    console.log(e);
    this.setState({ location: { lat: e.lat, lng: e.lng } });
    // this.props.onClick(e);
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
          defaultCenter={[this.state.location.lat, this.state.location.lng]}
          defaultZoom={1}
          onClick={this.onClick}
        >
          <LocalShippingIcon
            color="secondary"
            lat={this.state.location.lat}
            lng={this.state.location.lng}
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
    enableHighAccuracy: true,
  },
  userDecisionTimeout: 5000,
})(InteractiveMap);
