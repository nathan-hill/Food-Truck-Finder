import React from "react";
import Avatar from "@material-ui/core/Avatar";
import Button from "@material-ui/core/Button";
import CssBaseline from "@material-ui/core/CssBaseline";
import TextField from "@material-ui/core/TextField";
import { Link } from "react-router-dom";
import Grid from "@material-ui/core/Grid";
import LockOutlinedIcon from "@material-ui/icons/LockOutlined";
import Typography from "@material-ui/core/Typography";
import { makeStyles } from "@material-ui/core/styles";
import Container from "@material-ui/core/Container";
import RadioButtons from "./../components/CreateRadioButtons";
import * as Request from "./../helpers/backendRequests";
import LinearProgress from "@material-ui/core/LinearProgress";
import { login } from "../actions/login";

const useStyles = makeStyles((theme) => ({
  paper: {
    marginTop: theme.spacing(8),
    display: "flex",
    flexDirection: "column",
    alignItems: "center",
  },
  avatar: {
    margin: theme.spacing(1),
    backgroundColor: theme.palette.secondary.main,
  },
  form: {
    width: "100%", // Fix IE 11 issue.
    marginTop: theme.spacing(3),
  },
  submit: {
    margin: theme.spacing(3, 0, 2),
  },
}));

export default class SignUp extends React.Component {
  constructor(props) {
    super(props);

    this.state = {
      rbstate: true,
      loading: false,
      failed: false,
      message: "",
    };
    this.onSubmitUser = this.onSubmitUser.bind(this);
    this.onSuccess = this.onSuccess.bind(this);
    this.onFail = this.onFail.bind(this);
  }

  onSuccess = (status) => {
    this.setState({ loading: false, failed: false });
    console.log("the registration did not failed");
    this.setState({ status: status.message });
    this.props.onSuccess();
  };

  onFail = (error) => {
    let message = "failed";
    if (error.response.status == 400) {
      console.log(error.response.status);
      message = "Username Already Taken!";
    } else if (error.response.status == 409) {
      message = "Email already taken!";
    }
    this.setState({
      loading: false,
      failed: true,
      message: message,
    });
  };

  onSubmitUser = async (e) => {
    e.preventDefault();
    this.setState({loading: true})
    const user = {
      email: e.target.elements.email.value,
      password: e.target.elements.password.value,
      name:
        e.target.elements.firstName.value +
        " " +
        e.target.elements.lastName.value,
      username: e.target.elements.username.value,
      type: e.target.elements.type.value,
    };

    Request.postNewUser(user, this.onFail, this.onSuccess);
  };

  changeRBState = (e) => {
    this.setState({ rbstate: false });
  };

  render() {
    let failMessage = this.state.failed ? (
      <Typography color="error">{this.state.message}</Typography>
    ) : (
      <div></div>
    );

    let loadingBar = this.state.loading ? (
      <LinearProgress variant="query" />
    ) : (
      <React.Fragment />
    );

    const classes = useStyles;
    return (
      <Container component="main" maxWidth="xs">
        <CssBaseline />
        <div className={classes.paper}>
          <Avatar className={classes.avatar}>
            <LockOutlinedIcon />
          </Avatar>
          <Typography component="h1" variant="h5">
            Sign up
          </Typography>
          <form
            className={classes.form}
            onSubmit={this.onSubmitUser}
            noValidate
          >
            <Grid container spacing={2}>
              <Grid item xs={12} sm={6}>
                <TextField
                  autoComplete="fname"
                  name="firstName"
                  variant="outlined"
                  required
                  fullWidth
                  id="firstName"
                  label="First Name"
                  autoFocus
                />
              </Grid>
              <Grid item xs={12} sm={6}>
                <TextField
                  variant="outlined"
                  required
                  fullWidth
                  id="lastName"
                  label="Last Name"
                  name="lastName"
                  autoComplete="lname"
                />
              </Grid>
              <Grid item xs={12}>
                <TextField
                  variant="outlined"
                  required
                  fullWidth
                  id="email"
                  label="Email Address"
                  name="email"
                  autoComplete="email"
                />
              </Grid>
              <Grid item xs={12}>
                <TextField
                  variant="outlined"
                  required
                  fullWidth
                  id="username"
                  label="Username"
                  name="username"
                  autoComplete="username"
                />
              </Grid>
              <Grid item xs={12}>
                <TextField
                  variant="outlined"
                  required
                  fullWidth
                  name="password"
                  label="Password"
                  type="password"
                  id="password"
                  autoComplete="current-password"
                />
                <Grid item xs={12} style={{ paddingTop: "35px" }}>
                  <RadioButtons action={this.changeRBState} />
                </Grid>
                {failMessage}
                <br />
              </Grid>
            </Grid>
            <Button
              type="submit"
              fullWidth
              variant="contained"
              color="primary"
              className={classes.submit}
              disabled={this.state.rbstate}
            >
              Sign Up
            </Button>
            {loadingBar}
            <Grid container justify="flex-end">
            </Grid>
          </form>
        </div>
      </Container>
    );
  }
}
