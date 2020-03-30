import React from "react";
import * as Requests from "../helpers/backendRequests";
import { connect } from "react-redux";
import CreateTable from "./CreateTable";

var data = {
  columns: ["Proximity", "Price", "Food Type"],
  rows: [
    ["Proximity Placeholder", "Price placeholder", "Food Type Placeholder"]
  ]
};

class FoodTruckPreferences extends React.Component {
  constructor(props) {
    super(props);
    this.state = {
      rows: [],
      columns: [],
      currentLocation: { lat: 0, lng: 0 }
    };
  }
  async componentDidMount() {
    const { lat, lng } = await this.getcurrentLocation();
    this.setState(prev => ({
      ...prev.fields,
      location: {
        lat,
        lng
      }
    }));

    console.log(this.state);

    let preferred = await Requests.getPreferredTrucks(
      this.props.auth.user.sub,
      this.state.location.lat,
      this.state.location.lng
    );
    console.log("preferred trucks")
    console.log(preferred);
    this.setState({generalData: preferred, generalCols: Object.keys(preferred[0])})
  }

  getcurrentLocation() {
    if (navigator && navigator.geolocation) {
      return new Promise((resolve, reject) => {
        navigator.geolocation.getCurrentPosition(pos => {
          const coords = pos.coords;
          resolve({
            lat: coords.latitude,
            lng: coords.longitude
          });
        });
      });
    }
    return {
      lat: 0,
      lng: 0
    };
  }

  render() {
    return (
      <div id="container" className="container">
        <h1>Recommended Food Trucks</h1>
        <CreateTable rows={this.state.generalData} cols={this.state.generalCols}/>
      </div>
    );
  }
}

const mapStateToProps = state => ({
  auth: state.auth
});

export default connect(mapStateToProps, null)(FoodTruckPreferences);
