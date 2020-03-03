
import React from "react";
import Container from "@material-ui/core/Container";
import { makeStyles } from "@material-ui/core/styles";
import TextField from "@material-ui/core/TextField";
import Button from "@material-ui/core/Button";

class FoodTruckDetails extends React.Component {
    constructor(props) {
        super(props);
        this.state = {
            id: 26,
            foodTruckName: "",
            currentSchedule: "",
            description: "",
            currentMenu: "",
            isDisabled: true,
        };

        this.onChange = this.onChange.bind(this);
        this.onSubmit = this.onSubmit.bind(this);
        this.onEditSubmit = this.onEditSubmit.bind(this);
    }

    onChange(e) {
        this.setState({[e.target.name]: e.target.value});
    }

    onSubmit(e) {
        e.preventDefault();
    }

    onEditSubmit(e) {
        e.preventDefault();
        this.setState({isDisabled: !this.state.isDisabled})
    }

    render() {
        const { foodTruckName, currentSchedule, description, currentMenu, isDisabled } = this.state;
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
                            id="foodTruckName"
                            label="Food Truck Name"
                            name="foodTruckName"
                            onChange={this.onChange}
                            value={foodTruckName}
                            disabled={isDisabled}
                            autoFocus
                        />

                        <TextField
                            variant="outlined"
                            margin="normal"
                            required
                            fullWidth
                            id="currentSchedule"
                            label="Current Schedule"
                            name="currentSchedule"
                            onChange={this.onChange}
                            value={currentSchedule}
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
                            id="currentMenu"
                            label="Current Menu"
                            name="currentMenu"
                            onChange={this.onChange}
                            value={currentMenu}
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