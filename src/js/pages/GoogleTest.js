import React, { Component } from 'react';
import GoogleMapReact from 'google-map-react';
import { geolocated } from "react-geolocated";
 
const AnyReactComponent = ({ text }) => <div>{text}</div>;
 
class SimpleMap extends Component {
 
  render() {
    return !this.props.isGeolocationAvailable ? (
      <div>Your browser does not support Geolocation</div>
  ) : !this.props.isGeolocationEnabled ? (
      <div>Geolocation is not enabled</div>
  ) : this.props.coords ? (
      // Important! Always set the container height explicitly
      <div style={{ height: '100vh', width: '100%' }}>
        <GoogleMapReact
          //bootstrapURLKeys={{ key: /* YOUR KEY HERE */ }}
          defaultCenter={[this.props.coords.latitude, 
          this.props.coords.longitude]}
          defaultZoom={11}
        >
          <AnyReactComponent
            
          />
        </GoogleMapReact>
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
})(SimpleMap);