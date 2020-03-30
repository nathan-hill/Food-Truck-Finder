import React from "react";
import Container from "@material-ui/core/Container";
import { makeStyles } from "@material-ui/core/styles";
import TextField from "@material-ui/core/TextField";
import Button from "@material-ui/core/Button";
import axios from "axios";

class SendNotificationForm extends React.Component {
    constructor(props) {
        super(props);
        this.state = {
            truck: "",
            message: "",
        };

        this.onChange = this.onChange.bind(this);
        this.onSubmit = this.onSubmit.bind(this);
    }

    onChange(e) {
        this.setState({[e.target.name]: e.target.value});
    }

    onSubmit(e) {
        e.preventDefault();

        let data = {
            truck: this.state.truck,
            message: this.state.message,
        }
        data.headers = {
            "Access-Control-Allow-Origin": "*",
            "content-type": "application/json",
            Accept: "application/json"
        };

        axios.put("http://localhost:8080/v/sendNotification",data).then(res => {
            console.log(res);
        })
    }


    render() {
        const { truck, message } = this.state;
        const classes = makeStyles();

        let submitButton;
        if(true) {
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


        return (
            <Container component="main" maxWidth="xs">
                <div className={classes.paper}>
                    <form className={classes.form} noValidate onSubmit={this.onSubmit}>
                        <TextField
                            variant="outlined"
                            margin="normal"
                            required
                            fullWidth
                            id="truck"
                            label="Food Truck"
                            name="truck"
                            onChange={this.onChange}
                            value={truck}
                            autoFocus
                        />

                        <TextField
                            variant="outlined"
                            margin="normal"
                            required
                            fullWidth
                            id="message"
                            label="Message"
                            name="message"
                            onChange={this.onChange}
                            value={message}
                            autoFocus
                        />  
                        {submitButton}
                   </form>
                </div>
            </Container>
        );
    }
}

export default SendNotificationForm;
