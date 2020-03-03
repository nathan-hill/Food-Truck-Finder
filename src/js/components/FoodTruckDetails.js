
import React from "react";
import Container from "@material-ui/core/Container";
import { makeStyles } from "@material-ui/core/styles";
import TextField from "@material-ui/core/TextField";
import Button from "@material-ui/core/Button";
import axios from "axios";

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

        this.onChange = this.onChange.bind(this);
        this.onSubmit = this.onSubmit.bind(this);
        this.onEditSubmit = this.onEditSubmit.bind(this);

        console.log("TRYING TO DO A GET NOW!!!")
        axios.get("http://localhost:8080/v/trucks/findTruckByID", {
            params: {
                integer: this.state.id
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
            schedule: this.state.schedule,
            description: this.state.description,
            menu: this.state.menu,
            ownerid: this.state.ownerid,
        }
        data.headers = {
            "Access-Control-Allow-Origin": "*",
            "content-type": "application/json",
            Accept: "application/json"
        };

        axios.put("http://localhost:8080/v/trucks/updateByTruck",data).then(res => {
            console.log(res);
        })
    }

    onEditSubmit(e) {
        e.preventDefault();
        this.setState({isDisabled: !this.state.isDisabled})
    }

    render() {
        const { name, schedule, description, menu, isDisabled } = this.state;
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
                            label="Food Truck Name"
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
                            id="schedule"
                            label="Current Schedule"
                            name="schedule"
                            onChange={this.onChange}
                            value={schedule}
                            disabled={isDisabled}
                            autoFocus
                        />

                        <TextField
                            variant="outlined"
                            margin="normal"
                            required
                            fullWidth
                            id="description"
                            label="Description"
                            name="description"
                            onChange={this.onChange}
                            value={description}
                            disabled={isDisabled}
                            autoFocus
                        />

                        <TextField
                            variant="outlined"
                            margin="normal"
                            required
                            fullWidth
                            id="menu"
                            label="Current Menu"
                            name="menu"
                            onChange={this.onChange}
                            value={menu}
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

export default FoodTruckDetails;