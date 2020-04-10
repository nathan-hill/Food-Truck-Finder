import React from "react";
import Container from "@material-ui/core/Container";
import { makeStyles } from "@material-ui/core/styles";
import TextField from "@material-ui/core/TextField";
import Button from "@material-ui/core/Button";
import { connect } from "react-redux";
import * as Request from "./../helpers/backendRequests";
import List from "@material-ui/core/List";
import ListItem from "@material-ui/core/ListItem";
import ListItemIcon from "@material-ui/core/ListItemIcon";
import ListItemText from "@material-ui/core/ListItemText";
import Checkbox from "@material-ui/core/Checkbox";

//var constants = require("./../helpers/constants");
class SendNotificationForm extends React.Component {
  constructor(props) {
    super(props);
    this.state = {
      name: "",
      trucks: [],
      selectedTrucks: [],
      checked: [],
      message: ""
    };

    this.onChange = this.onChange.bind(this);
    this.onSubmit = this.onSubmit.bind(this);
    this.onCheckBoxChange = this.onCheckBoxChange.bind(this);
    this.handleToggle = this.handleToggle.bind(this);
  }

  handleToggle(value) {
    // console.log("value sent from CB");
    // console.log(value);
    let currentIndex = -1;
    for (let i = 0; i < this.state.checked.length; i++) {
      if (this.state.checked[i].id === value.id) {
        currentIndex = i;
      }
    }
    const newChecked = [...this.state.checked];

    // console.log(newChecked);

    if (currentIndex === -1) {
      newChecked.push(value);
    } else {
      newChecked.splice(currentIndex, 1);
    }

    // console.log("after adding");
    // console.log(newChecked);

    this.setState({ checked: newChecked });
  }

  onCheckBoxChange(vals) {
    // console.log(vals);
    this.setState({ selectedTrucks: vals });
  }

  onChange(e) {
    e.preventDefault();
    this.setState({ message: e.target.value });
  }

  onSubmit(e) {
    e.preventDefault();
    // console.log("sending message");

    let data = {
      to: this.state.checked.map(e => {
        return e.id;
      }),
      message: this.state.message
    };

    Request.sendNotification(data);
  }

  async componentDidMount() {
    let data = await Request.getAllTrucks(this.state.id);

    // console.log("Get user Data");
    // console.log(data);

    /******************************
     * This was the problem
     ****************************/

    this.setState({ trucks: data });
  }

  render() {
    const classes = makeStyles();

    return (
      <Container component="main" maxWidth="xs">
        <div className={classes.paper}>
          <List className={classes.root}>
            {this.state.trucks.map((value, i) => {
              return (
                <ListItem
                  key={value.name}
                  role={undefined}
                  dense
                  button
                  onClick={() => this.handleToggle(value)}
                >
                  <ListItemIcon>
                    <Checkbox
                      edge="start"
                      tabIndex={-1}
                      disableRipple
                      checked={
                        this.state.checked
                          .map(e => {
                            return e.id;
                          })
                          .indexOf(value.id) !== -1
                      }
                    />
                  </ListItemIcon>
                  <ListItemText id={value.id} primary={value.name} />
                </ListItem>
              );
            })}
          </List>
          <TextField
            variant="outlined"
            margin="normal"
            required
            fullWidth
            id="message"
            label="Message"
            name="message"
            onChange={this.onChange}
            value={this.message}
            autoFocus
          />
          <Button
            type="submit"
            fullWidth
            variant="contained"
            color="primary"
            className={classes.submit}
            onClick={this.onSubmit}
          >
            Submit
          </Button>
        </div>
      </Container>
    );
  }
}

const mapStateToProps = state => ({
  auth: state.auth
});
export default connect(mapStateToProps, null)(SendNotificationForm);
