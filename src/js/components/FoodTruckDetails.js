import React from "react";
import {connect} from "react-redux";
import {Container} from "@material-ui/core";
import * as Request from "../helpers/backendRequests";
import FormComponent from "./rateAndReview";
import Box from "@material-ui/core/Box";
import Typography from "@material-ui/core/Typography";

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
                console.log("ALL REVIEWS:");
                console.log(result);
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
            <Box mb={3}>

              <Typography>
                  {this.state.name}
              </Typography>
              <Typography>
                  {this.state.description}
              </Typography>
              <h4>
                  {this.state.reviews ? this.state.reviews.map(review => {
                      return (
                        <div style={{
                            display: "flex",
                            justifyContent: "center",
                            alignItems: "center"}}
                        >
                            <Box mb={3}>
                                <Typography component="legend"> {JSON.stringify(review)}  </Typography>
                            </Box>
                        </div>
                      );
                  }) : null}
              </h4>

              {reviewPanel}
            </Box>
        );
    }
}

const mapStateToProps = state => ({
    auth: state.auth
});

export default connect(mapStateToProps, null)(FoodTruckDetails);