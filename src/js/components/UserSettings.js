import React from "react";
import Container from "@material-ui/core/Container";
import { makeStyles } from "@material-ui/core/styles";
import TextField from "@material-ui/core/TextField";
import axios from "axios";
import { UserProfile } from "../pages/pages";
import { connect } from "react-redux";
import Button from "@material-ui/core/Button";
import PreferenceDialog from "./PreferenceDialog";
import InputBase from "@material-ui/core/InputBase";
import InputLabel from "@material-ui/core/InputLabel";
import Input from "@material-ui/core/Input";
import Select from "@material-ui/core/Select";
import Slider from "@material-ui/core/Slider";
import Grid from "@material-ui/core/Grid";
import Paper from "@material-ui/core/Paper";
import { Typography } from "@material-ui/core";
import CheckBoxList from "./CheckBoxList";
import createSpacing from "@material-ui/core/styles/createSpacing";
import * as Request from "./../helpers/backendRequests";
var constants = require("./../helpers/constants");

class customerSettings extends React.Component {
  constructor(props) {
    super(props);
    this.state = {
      id: props.auth.user.sub,
      name: "",
      username: "",
      email: "",
      password: "",
      type: "",
      isDisabled: true,
      proximity: -1,
      price: 1,
      likes: []
    };
    this.priceArray = ["$", "$$", "$$$", "$$$$"];

    this.onChange = this.onChange.bind(this);
    this.onSliderChange = this.onSliderChange.bind(this);
    this.onSelectChange = this.onSelectChange.bind(this);
    this.onSubmit = this.onSubmit.bind(this);
    this.onEditSubmit = this.onEditSubmit.bind(this);
    this.onCheckBoxChange = this.onCheckBoxChange.bind(this);
    this.valuetext = this.valuetext.bind(this);
  }

  async componentDidMount() {
    let userData = await Request.getUserByID(this.state.id);
    let preferences = await Request.getUPById(this.state.id);


    console.log("Gey user Data");
    console.log(userData);

    this.setState({
      name: userData.name,
      username: userData.username,
      email: userData.email
    });
    this.setState({proximity: preferences.proximity, price: preferences.price, likes: preferences.likes})
  }

  onChange(e) {
    console.log(e);
    this.setState({ [e.target.name]: e.target.value });
    console.log(this.state);
  }

  onSelectChange(e) {
    console.log(e.target.value.length);
    this.setState({ price: Number(e.target.value.length) });
  }

  onSliderChange(e, val) {
    console.log(val);
    this.setState({ proximity: Number(val) });
  }

  onCheckBoxChange(vals) {
    console.log(vals);
    for (let i = 0; i < vals.length; i++) {
      vals[i] = vals[i].toUpperCase();
    }
    console.log(vals);
    this.setState({ likes: vals });
  }

  onSubmit(e) {
    e.preventDefault();

    console.log("Submit form");
    this.setState({isDisabled: true})
    console.log(this.state);

    let udata = {
      id: this.state.id,
      name: this.state.name,
      username: this.state.username,
      email: this.state.email,
      password: this.state.password,
      type: this.state.type
    };
    let upref = {
      id: this.state.id,
      proximity: this.state.proximity,
      price: this.state.price,
      likes: this.state.likes
    };
    let data = { user: udata, preferences: upref };
    data.headers = {
      "Access-Control-Allow-Origin": "*",
      "content-type": "application/json",
      Accept: "application/json"
    };

    console.log("Printing the body of form update");
    console.log(data);

    axios.put(constants.backend_url + "users/updateByUser", data).then(res => {
      console.log(res);
    });
  }

  valuetext(value) {
    return `${value} miles`;
  }

  onEditSubmit(e) {
    e.preventDefault();
    this.setState({ isDisabled: !this.state.isDisabled });
  }

  render() {
    console.log(this.state);

    let submitButton;
    if (!this.state.isDisabled) {
      submitButton = (
        <Button
          type="submit"
          fullWidth
          variant="contained"
          color="primary"
          onClick={this.onSubmit}
          //   className={classes.submit}
        >
          Save Changes
        </Button>
      );
    }

    let editCancelButton;
    if (true) {
      //temp until client side verifies that this is the Owner account
      editCancelButton = (
        <Button
          type="submit"
          fullWidth
          variant="contained"
          color="primary"
          onClick={this.onEditSubmit}
          //   className={classes.submit}
        >
          {this.state.isDisabled ? "Edit" : "Cancel"}
        </Button>
      );
    }

    return (
      //   <Container component="main" maxWidth="xs">
      <Grid container styles={{ flexGrow: 1 }}>
        <Grid item xs={12}>
          {/* <div className={classes.paper} > */}
          {/* <form
          // className={classes.form}
          noValidate
          onSubmit={this.onEditSubmit}
        > */}
          {editCancelButton}
          {/* </form> */}
        </Grid>

        {/* <form
          //   className={classes.form}
          noValidate
          onSubmit={this.onSubmit}
        > */}
        <Grid item xs={12}>
          <TextField
            variant="outlined"
            margin="normal"
            required
            fullWidth
            id="name"
            label="Name"
            name="name"
            onChange={this.onChange}
            value={this.state.name}
            disabled={this.state.isDisabled}
            autoFocus
          />
        </Grid>

        <Grid item xs={12}>
          <TextField
            variant="outlined"
            margin="normal"
            required
            fullWidth
            id="username"
            label="Username"
            name="username"
            onChange={this.onChange}
            value={this.state.username} //username not defined error when I try to change it
            disabled={this.state.isDisabled}
            autoFocus
          />
        </Grid>

        <Grid item xs={12}>
          <TextField
            variant="outlined"
            margin="normal"
            required
            fullWidth
            id="email"
            label="Email"
            name="email"
            onChange={this.onChange}
            value={this.state.email} //email not defined error as well
            disabled={this.state.isDisabled}
            autoFocus
          />
        </Grid>
        {/* <PreferenceDialog onChange={this.onChange} disabled={isDisabled} /> */}
        {/* <formdd
              //   className={classes.container}
              > */}
        <Grid item xs={12}>
          <Paper
          //   className={classes.paper}
          >
            <Typography gutterBottom>Maximum distance (mi)</Typography>
            <Slider
              defaultValue={30}
              value={this.state.proximity}
              getAriaValueText={this.valuetext}
              aria-labelledby="discrete-slider"
              valueLabelDisplay="auto"
              step={1}
              marks
              min={1}
              max={30}
              disabled={this.state.isDisabled}
              onChange={this.onSliderChange}
            />
          </Paper>
        </Grid>

        <Grid item xs={12} alignContent={"center"}>
          <Paper styles={{ textAlign: "center", color: "gray" }}>
            <InputLabel htmlFor="price-native">Price</InputLabel>
            <Select
              native
              // defaultValue={label}
              onChange={this.onSelectChange}
              input={<Input id="price-native" />}
              disabled={this.state.isDisabled}
              defaultValue={this.priceArray[this.state.price]}
            >

              <option aria-label="None" priceValue="" />
              {this.priceArray.map((val, i) => <option value={i+1} key={i}>{val}</option>)}

            </Select>
          </Paper>
        </Grid>
        <Grid item xs>
          <Paper
          //   className={classes.paper}
          >
            <InputLabel htmlFor="foodtype-native">Food Type</InputLabel>
            <CheckBoxList
              foodList={[
                "Mexican",
                "American",
                "Italian",
                "Chinese",
                "Vietnamese"
              ]}
              likes={this.state.likes}
              disabled={this.state.isDisabled}
              onChange={this.onCheckBoxChange}
            />
          </Paper>
        </Grid>
        {submitButton}
        {/* </form> */}
      </Grid>
    );
  }
}

const mapStateToProps = state => ({
  auth: state.auth
});

export default connect(mapStateToProps, null)(customerSettings);
