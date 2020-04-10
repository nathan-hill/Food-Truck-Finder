import React from "react";
import * as Requests from "../helpers/backendRequests";
import { connect } from "react-redux";
import CreateTable from "./CreateTable";
import { Typography } from "@material-ui/core";

class FoodTruckPreferences extends React.Component {
  constructor(props) {
    super(props);
    this.state = {
      data: [],
      rows: [],
      columns: [],
      currentLocation: { lat: 0, lng: 0 },
    };
  }

  async componentDidMount() {
    const cost = ["$", "$$", "$$$", "$$$$"];
    const { lat, lng } = await this.getcurrentLocation();
    this.setState((prev) => ({
      ...prev.fields,
      location: {
        lat,
        lng,
      },
    }));

    // console.log(this.state);

    let preferred = await Requests.getPreferredTrucks(
      this.props.auth.user.sub,
      this.state.location.lat,
      this.state.location.lng
    );

    this.setState({ data: preferred });

    let edited = preferred;

    for (let i = 0; i < preferred.length; i++) {
      edited[i].distance = preferred[i].distance.toFixed(2);
      edited[i].cost = cost[preferred[i].cost];
      edited[i].type =
        preferred[i].type.toLowerCase().charAt(0).toUpperCase() +
        preferred[i].type.toLowerCase().substring(1);

      delete edited[i].id;
      delete edited[i].schedule;
      delete edited[i].score;
      
    }

    // console.log("preferred trucks");
    // console.log(edited);
    this.setState({
      generalData: edited,
      generalCols: Object.keys(edited[0]),
    });
  }

  getcurrentLocation() {
    if (navigator && navigator.geolocation) {
      return new Promise((resolve, reject) => {
        navigator.geolocation.getCurrentPosition((pos) => {
          const coords = pos.coords;
          resolve({
            lat: coords.latitude,
            lng: coords.longitude,
          });
        });
      });
    }
    return {
      lat: 0,
      lng: 0,
    };
  }

  render() {
    return (
      <div id="container" className="container">
        <Typography>Recommended Food Trucks</Typography>
        <CreateTable
          rows={this.state.generalData}
          cols={this.state.generalCols}
        />
      </div>
    );
  }
}

const mapStateToProps = (state) => ({
  auth: state.auth,
});

export default connect(mapStateToProps, null)(FoodTruckPreferences);
