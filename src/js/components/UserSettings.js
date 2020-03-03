import React from "react";
import Container from "@material-ui/core/Container";
import { makeStyles } from "@material-ui/core/styles";
import TextField from "@material-ui/core/TextField";
import Button from "@material-ui/core/Button";
import axios from "axios";
import {UserProfile} from "../pages/pages";
import { connect } from "react-redux";

const backend_url = "http://localhost:8080/v/";
//const backend_url = "https://wheels-with-meals-backend.herokuapp.com/v/"

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
        };

        this.onChange = this.onChange.bind(this);
        this.onSubmit = this.onSubmit.bind(this);
        this.onEditSubmit = this.onEditSubmit.bind(this);

        console.log("getting user data:");
        axios.get(backend_url + "users/getUserByID", {
            params: {
                id: this.props.auth.user.sub
            }
        }).then(res => {
            console.log(res);
            this.setState(res.data);
        });
    }

    onChange(e) {
        this.setState({[e.target.name]: e.target.value});
    }

    onSubmit(e) {
        e.preventDefault();

        let data = {
            id: this.state.id,
            name: this.state.name,
            username: this.state.username,
            email: this.state.email,
            password: this.state.password,
            type: this.state.type,
        }
        data.headers = {
            "Access-Control-Allow-Origin": "*",
            "content-type": "application/json",
            Accept: "application/json"
        };

        axios.put(backend_url + "users/updateByUser",data).then(res => {
            console.log(res);
        })
    }

    onEditSubmit(e) {
        e.preventDefault();
        this.setState({isDisabled: !this.state.isDisabled})
    }

    render() {
        const { name, username, email, isDisabled } = this.state;
        const classes = makeStyles();

        let submitButton;
        if(!isDisabled) {
            submitButton = <Button
                type="submit"
                fullWidth
                variant="contained"
                color="primary"
                className={classes.submit}
            >
                Submit
            </Button>
        }

        let editCancelButton;
        if(true) { //temp until client side verifies that this is the Owner account
            editCancelButton= <Button
                type="submit"
                fullWidth
                variant="contained"
                color="primary"
                className={classes.submit}
            >
                {isDisabled ? "Edit" : "Cancel"}
            </Button>
        }

        return (
            <Container component="main" maxWidth="xs">
                <div className={classes.paper}>
                    <form className={classes.form} noValidate onSubmit={this.onEditSubmit}>
                        {editCancelButton}
                    </form>

                    <form className={classes.form} noValidate onSubmit={this.onSubmit}>
                        <TextField
                            variant="outlined"
                            margin="normal"
                            required
                            fullWidth
                            id="name"
                            label="Name"
                            name="name"
                            onChange={this.onChange}
                            value={name}
                            disabled={isDisabled}
                            autoFocus
                        />

                        <TextField
                            variant="outlined"
                            margin="normal"
                            required
                            fullWidth
                            id="username"
                            label="Username"
                            name="username"
                            onChange={this.onChange}
                            value={username} //username not defined error when I try to change it
                            disabled={isDisabled}
                            autoFocus
                        />  

                        <TextField
                            variant="outlined"
                            margin="normal"
                            required
                            fullWidth
                            id="email"
                            label="Email"
                            name="email"
                            onChange={this.onChange}
                            value={email} //email not defined error as well
                            disabled={isDisabled}
                            autoFocus
                        />

                        {submitButton}
                   </form>
                </div>
            </Container>
        );
    }
}

const mapStateToProps = state => ({
    auth : state.auth,
});

export default connect(mapStateToProps,null)(customerSettings);
