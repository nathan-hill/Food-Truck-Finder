import React from "react";
import Select from 'react-select';
import Container from "@material-ui/core/Container";
import { makeStyles } from "@material-ui/core/styles";
import TextField from "@material-ui/core/TextField";
import Button from "@material-ui/core/Button";
import axios from "axios";
import * as Request from './../helpers/backendRequests';
import {connect} from "react-redux";

class SendNotificationForm extends React.Component {
    constructor(props) {
        super(props);
        this.state = {
            name: "",
            id: "",
            message: "",
            selectedOption: null,
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
            truck: this.state.id,
            message: this.state.message,
        }
        data.headers = {
            "Access-Control-Allow-Origin": "*",
            "content-type": "application/json",
            Accept: "application/json"
        };

        Request.sendNotification(data);
    }

    async componentDidMount() {
        let data = await Request.getAllTrucks(this.state.id);
    
    
        console.log("Gey user Data");
        console.log(data);
    
        this.setState({
          name: data.name,
          id: data.id,
        });
    }

    handleChange = (selectedOption) => {
        this.setState({ selectedOption });
    }


    render() {
        const { selectedOption, message } = this.state;
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

        const options = [
            { value : this.state.id, label: this.state.name }
        ]

        //for testing
        //const options = [
            //{ value : 'Truck1', label: 'truck1'},
            //{ value : 'Truck2', label: 'truck2'}
        //]


        return (
            <Container component="main" maxWidth="xs">
                <div className={classes.paper}>
                    <form className={classes.form} noValidate onSubmit={this.onSubmit}>
                        <Select options = { options } />

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
