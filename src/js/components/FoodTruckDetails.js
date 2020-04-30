import React from "react";
import { connect } from "react-redux";
import * as Request from "../helpers/backendRequests";
import FormComponent from "./rateAndReview";
import Box from "@material-ui/core/Box";
import Typography from "@material-ui/core/Typography";
import Rating from "@material-ui/lab/Rating";
import { Share } from "./Share";
import "./../styles/truckDetails.css";
import LinearProgress from "@material-ui/core/LinearProgress";
import { Button } from "@material-ui/core";
import LoginPage from "../components/LoginPage";
class FoodTruckDetails extends React.Component {
  constructor(props) {
    super(props);
    this.state = {
      loading: false,
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

  componentDidMount() {
    this.setState({ loading: true });
    console.log("callback printing this.state: ");
    console.log(this.state);

    let reviews = [];
    console.log("Getting reviews for truck ID: " + this.state.id);
    Request.getAllReviews().then((result) => {
      console.log("ALL REVIEWS:");
      console.log(result);
      let review;
      for (review of result) {
        if (review.truckid === this.state.id) {
          reviews.push(review);
        }
      }

      let revComponents = [];
      if (reviews.length > 0) {
        revComponents = reviews.map((review) => {
          return (
            <div
              style={{
                display: "flex",
                justifyContent: "center",
                alignItems: "center",
              }}
            >
              <Box mb={3} border={1}>
                <Typography component="legend">
                  {" "}
                  User {review.userID} rates:{" "}
                </Typography>
                <Rating name="pristine" value={review.rating} readOnly={true} />
                <Typography component="legend">
                  {" "}
                  {review.description}{" "}
                </Typography>
              </Box>
            </div>
          );
        });
      }

      this.setState({
        revComponents: revComponents,
        reviews: reviews,
        loading: false,
      });
    });
  }

  render() {
    let isLoggedIn = this.props.auth.isAuthenticated;
    let reviewPanel;
    if (isLoggedIn) {
      reviewPanel = (
        <FormComponent callback={this.updateReviewsCallback.bind(this)} />
      );
    } else {
      reviewPanel = (
        <center>
          <Button
            onClick={() => {
              this.props.changeDrawer(
                <LoginPage
                  callback={this.props.loginCallback}
                  changeDrawer={this.props.changeDrawer}
                ></LoginPage>
              );
            }}
            type="submit"
            fullWidth
            variant="contained"
            color="primary"
          >
            Sign in to leave a review
          </Button>
        </center>
      );
    }

    return (
      <Box
        mb={3}
        component="div"
        style={{
          paddingTop: "20px",
          width: "100%",
          paddingLeft: "50px",
          paddingRight: "50px",
        }}
      >
        <Typography styles={{ paddingTop: "10px" }} variant="h4" align="center">
          {this.state.name}
        </Typography>
        <Typography align="center">{this.state.description}</Typography>
        <center padding-top="10px">
          <Share name={this.state.name} />
          {this.state.loading ? <LinearProgress variant="query" /> : <div />}
        </center>
        <h4>
          {this.state.revComponents === [] ? (
            <Typography variant="h5" align="center">
              No reviews
            </Typography>
          ) : (
            this.state.revComponents
          )}
        </h4>

        {reviewPanel}
      </Box>
    );
  }
}

const mapStateToProps = (state) => ({
  auth: state.auth,
});

export default connect(mapStateToProps, null)(FoodTruckDetails);
