
import React from "react";
import {connect} from "react-redux";
import axios from "axios";
import {Container} from "@material-ui/core";
import * as Request from "../helpers/backendRequests";
import ReactSearchBox from "react-search-box";
import FormComponent from "./rateAndReview";

class FoodTruckDetails extends React.Component {
    constructor(props) {
        super(props);
        this.state = {
            id: 1,
            name: "",
            schedule: "",
            description: "",
            menu: "",
            isDisabled: true,
        };

        let truck = JSON.parse(localStorage.getItem("clickedTruck"));
        this.state = truck;
    }

    render() {
        let reviews;
        Request.findReviewsByTruckID(this.state.id).then(result => {
            console.log(result);
            reviews = result;
        });

        let isLoggedIn = this.props.auth.isAuthenticated;
        let reviewPanel;
        if(isLoggedIn) {
            reviewPanel = <FormComponent/>
        }

        return(
          <Container component="main" maxWidth="xs">
              <h2>
                  {this.state.name}
              </h2>
              <h3>
                  {this.state.description}
              </h3>
              <h4>
                  {reviews}
              </h4>

              {reviewPanel}
          </Container>
        );
    }
}

const mapStateToProps = state => ({
    auth: state.auth
});

export default connect(mapStateToProps, null)(FoodTruckDetails);