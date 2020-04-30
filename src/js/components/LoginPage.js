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
import LinearProgress from "@material-ui/core/LinearProgress";
import SignUp from "./SignUp";
import { login } from "./../actions/login";
import { connect } from "react-redux";
import PropTypes from "prop-types";

class LoginPage extends React.Component {
  constructor(props) {
    super(props);
    this.state = {
      username: "",
      password: "",
      errors: {},
      isLoading: false,
      failed: false,
    };

    this.onSubmit = this.onSubmit.bind(this);
    this.onChange = this.onChange.bind(this);
    this.handleLoadingBar = this.handleLoadingBar.bind(this);
  }

  async onSubmit(e) {
    e.preventDefault();

    this.setState({ isLoading: true });

    let retState = await this.props.login(this.state, this.handleLoadingBar);
    console.log("retState", retState) 
    if (retState === null) {
      this.props.callback(false);
    } else {
      this.props.callback(retState);
    }
  }

  handleLoadingBar(b, d) {
    // console.log("the bar is being handled " + b);
    this.setState({ isLoading: b, failed: d });
  }

  onChange(e) {
    // console.log(e.target.name, e.target.value);
    this.setState({ [e.target.name]: e.target.value });
  }

  render() {
    const { errors, username, password, isLoading } = this.state;
    const classes = useStyles;

    let loadBar;
    if (this.state.isLoading) {
      loadBar = (
        <LinearProgress disabled={this.state.isLoading} variant="query" />
      );
    }

    let failMessage = this.state.failed ? (
      <Typography color="error">Invalid UserName or Password</Typography>
    ) : (
      <React.Fragment />
    );

    console.log("login props:");
    console.log(this.props);

    return (
      
      <Container component="main" maxWidth="xs">
        <br/>
        <CssBaseline />
        <div className={classes.paper}>
          <Avatar className={classes.avatar}>
            <LockOutlinedIcon />
          </Avatar>
          <Typography component="h1" variant="h5">
            Sign in
          </Typography>
          <form className={classes.form} onSubmit={this.onSubmit} noValidate>
            <TextField
              variant="outlined"
              margin="normal"
              required
              fullWidth
              id="username"
              label="Username"
              name="username"
              autoComplete="username"
              value={username}
              onChange={this.onChange}
              error={errors.username}
              autoFocus
            />
            
            <TextField
              variant="outlined"
              margin="normal"
              required
              fullWidth
              name="password"
              label="Password"
              type="password"
              value={password}
              onChange={this.onChange}
              error={errors.password}
              id="password"
              autoComplete="current-password"
            />
            <Button
              type="submit"
              fullWidth
              variant="contained"
              color="primary"
              className={classes.submit}
              disabled={isLoading}
            >
              Sign In
            </Button>
            {loadBar}
            {failMessage}
            <Grid container>
              <Grid item>
                <Link
                  onClick={() => {
                    this.props.changeDrawer(
                      <SignUp
                        onSuccess={() =>
                          this.props.changeDrawer(
                            <LoginPage
                              callback={this.props.callback}
                              changeDrawer={this.props.changeDrawer}
                            />
                          )
                        }
                      />
                    );
                  }}
                >
                  <br/>
                  {"Don't have an account? Sign Up"}
                </Link>
              </Grid>
            </Grid>
          </form>
        </div>
      </Container>
    );
  }
}

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
    marginTop: theme.spacing(1),
  },
  submit: {
    margin: theme.spacing(3, 0, 2),
  },
}));

LoginPage.propTypes = {
  login: PropTypes.func.isRequired,
  history: PropTypes.object.isRequired,
};

export default connect(null, {login})(LoginPage);
