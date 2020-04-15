import React from "react";
import {connect} from "react-redux";
import {Container} from "@material-ui/core";
import * as Request from "../helpers/backendRequests";
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
        if(!this.state.reviews) {
            let reviews = [];
            console.log("Getting reviews for truck ID: " + this.state.id);
            Request.getAllReviews().then(result => {
                let review;
                for (review of result) {
                    if (review.truckid === this.state.id) {
                        reviews.push(review);
                    }
                }

                this.setState((state) => {
                    return {reviews: reviews}
                });
            });
        } else {
            console.log("REVIEWS IN STATE: ");
            console.log(this.state.reviews);
        }

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
                  {this.state.reviews ? JSON.stringify(this.state.reviews) : null}
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