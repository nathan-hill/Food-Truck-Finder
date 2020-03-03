import React from "react";
import Avatar from '@material-ui/core/Avatar';
import Button from "@material-ui/core/Button";
import CssBaseline from "@material-ui/core/CssBaseline";
import TextField from "@material-ui/core/TextField";
import FormControlLabel from "@material-ui/core/FormControlLabel";
import Checkbox from "@material-ui/core/Checkbox";
import { Link } from "react-router-dom";
import Grid from "@material-ui/core/Grid";
import LockOutlinedIcon from "@material-ui/icons/LockOutlined";
import Typography from "@material-ui/core/Typography";
import { makeStyles } from "@material-ui/core/styles";
import Container from "@material-ui/core/Container";
import { connect } from "react-redux";
import { login } from "../actions/login";
import PropTypes from "prop-types";
import { withRouter } from "react-router";



class LoginPage extends React.Component {
  constructor(props) {
    super(props);
    this.state = {
      username: '',
      password: '',
      errors: {},
      isLoading: false
    }

    this.onSubmit = this.onSubmit.bind(this);
    this.onChange = this.onChange.bind(this);
  }

  onSubmit(e) {

    e.preventDefault();

    this.setState({isLoading: true})
    this.props.login(this.state).then(
        (res) => this.props.history.push("/"),
        (err) => this.setState({errors: {}, isLoading: false})
    );
  }

  onChange(e) {
    this.setState({[e.target.name]: e.target.value});
  }

  render() {
    const { errors, username, password, isLoading } = this.state;
    const classes = makeStyles();
    return (
      <Container component="main" maxWidth="xs">
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
            <FormControlLabel
              control={<Checkbox value="remember" color="primary" />}
              label="Remember me"
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
            <Grid container>
              <Grid item xs>
                <Link to="/">
                  Forgot password?
                </Link>
              </Grid>
              <Grid item>
                <Link to="/create_account">
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

// const useStyles = makeStyles(theme => ({
//   paper: {
//     marginTop: theme.spacing(8),
//     display: "flex",
//     flexDirection: "column",
//     alignItems: "center"
//   },
//   avatar: {
//     margin: theme.spacing(1),
//     backgroundColor: theme.palette.secondary.main
//   },
//   form: {
//     width: "100%", // Fix IE 11 issue.
//     marginTop: theme.spacing(1)
//   },
//   submit: {
//     margin: theme.spacing(3, 0, 2)
//   }
// }));

LoginPage.propTypes = {
    login: PropTypes.func.isRequired,
    history: PropTypes.object.isRequired
};

export default connect(null, { login })(withRouter(LoginPage));
