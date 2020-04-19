import React from "react";
import { makeStyles, withStyles } from "@material-ui/core/styles";
import InputLabel from "@material-ui/core/InputLabel";
import FormControl from "@material-ui/core/FormControl";
import NativeSelect from "@material-ui/core/NativeSelect";
import OutlinedInput from "@material-ui/core/OutlinedInput";
import InputAdornment from "@material-ui/core/InputAdornment";

import { connect } from "react-redux";
import * as Request from "./../helpers/backendRequests";
import ExpandMoreIcon from '@material-ui/icons/ExpandMore';
import InputBase from "@material-ui/core/InputBase";
import TextField from "@material-ui/core/TextField";
import { ExpansionPanel, ExpansionPanelDetails, ExpansionPanelSummary, Typography } from "@material-ui/core";

const BootstrapInput = withStyles((theme) => ({
  root: {
    "label + &": {
      marginTop: theme.spacing(3),
    },
  },
  textField: {
    marginLeft: theme.spacing(1),
    marginRight: theme.spacing(1),
    width: 200,
  },
  margin: {
    margin: theme.spacing(1),
  },
  input: {
    borderRadius: 4,
    position: "relative",
    backgroundColor: theme.palette.background.paper,
    border: "1px solid #ced4da",
    fontSize: 16,
    padding: "10px 26px 10px 12px",
    transition: theme.transitions.create(["border-color", "box-shadow"]),
    // Use the system font instead of the default Roboto font.
    fontFamily: [
      "-apple-system",
      "BlinkMacSystemFont",
      '"Segoe UI"',
      "Roboto",
      '"Helvetica Neue"',
      "Arial",
      "sans-serif",
      '"Apple Color Emoji"',
      '"Segoe UI Emoji"',
      '"Segoe UI Symbol"',
    ].join(","),
    "&:focus": {
      borderRadius: 4,
      borderColor: "#80bdff",
      boxShadow: "0 0 0 0.2rem rgba(0,123,255,.25)",
    },
  },
}))(InputBase);

class FinalTruckTable extends React.Component {
  constructor(props) {
    super(props);
    this.state = {
      ownerTruckID: props.auth.user.sub,
      data: [],
      schedule: [],
    };
    this.onSubmit = this.onSaveRow.bind(this);
  }

  async componentDidMount() {
    // get the array of trucks
    let userData = await Request.findTrucksByOwnerID(this.state.ownerTruckID);
  
    const requests = userData.map(truck => Request.getScheduleDTOByID(truck.id));
  
    const listOfScheduleData = await Promise.all(requests);
  
    this.setState({
      // depends on if you want to keep original `this.state.schedule`
  
      // if you do:
      schedule: [...this.state.schedule, ...listOfScheduleData],
      data: userData
      
    });
  }

  handleTruckChange = (idx) => (e) => {
    const { name, value } = e.target;
    const data = [...this.state.data];

    data[idx] = {
      [name]: value,
    };
    this.setState({
      data,
    });
  };

  handleScheduleChange = (idx) => (e) => {
    const { name, value } = e.target;
    const schedule = [...this.state.schedule];

    schedule[idx] = {
      [name]: value,
    };
    this.setState({
      schedule,
    });
  };

  handleAddRow = () => {
    const truckItem = {
      ownerID: this.state.ownerTruckID,
      id: "",
      name: "",
      cost: "",
      type: "",
      menu: "",
    };

    const truckSchedule = {
      ownerID: this.state.ownerTruckID,
      id: "",
      monOpen: "",
      monStartTime: "",
      monEndTime: "",
      monLatitude: "",
      monLongitude: "",

      tueOpen: "",
      tueStartTime: "",
      tueEndTime: "",
      tueLatitude: "",
      tueLongitude: "",

      wedOpen: "",
      wedStartTime: "",
      wedEndTime: "",
      wedLatitude: "",
      wedLongitude: "",

      thuOpen: "",
      thuStartTime: "",
      thuEndTime: "",
      thuLatitude: "",
      thuLongitude: "",

      friOpen: "",
      friStartTime: "",
      friEndTime: "",
      friLatitude: "",
      friLongitude: "",

      satOpen: "",
      satStartTime: "",
      satEndTime: "",
      satLatitude: "",
      satLongitude: "",

      sunOpen: "",
      sunStartTime: "",
      sunEndTime: "",
      sunLatitude: "",
      sunLongitude: "",
    };

    this.setState({
      data: [...this.state.data, truckItem],
      schedule: [...this.state.schedule, truckSchedule],
    });

    // add new truck into database
    Request.postNewTruck(truckItem);
    Request.postNewSchedule(truckSchedule);
  };

  handleRemoveSpecificRow = (idx) => () => {
    //remove the foodtruck from the database
    Request.deleteTruck(this.state.data[idx].id)
    Request.deleteSchedule();
    console.log()
    
    // prepare data to be modified
    const data = [...this.state.data];

    // prepare schedule to be modified
    const schedule = [...this.state.schedule];

    // remove the specific truck and schedule from the table
    data.splice(idx, 1);
    schedule.splice(idx, 1);

    // set the data to this new state
    this.setState({ data });
    this.setState({ schedule });
  };

  onSaveRow(idx) {
    console.log("Submit form");
    // set data to schedule of truck at index idx
    let sdata = {schedule: this.state.schedule[idx] };
    
    // print data for testing purposes
    console.log("Printing the body of Schedule update");
    console.log(sdata);

    // update the schedule in the data base
    Request.updateSchedule(sdata);
    
    // set tdata to the existing food truck at index idx
    let tdata = {data: this.state.data[idx]};
    
    // print data for testing purposes
    console.log("Printing the body of Truck update");
    console.log(tdata);

    // update the truck in the database
    Request.updateTruckByID(tdata); 
  }

  

  render() {
    const classes = makeStyles();
    
    return (
      <div
        className="container"
        style={{
          display: "flex",
          justifyContent: "center",
          alignItems: "center",
        }}
      >
        <div className="row clearfix">
          <div className="col-md-12 column">
            {this.state.data.map((item, idx) =>(
                <ExpansionPanel style={{overflowX: "scroll", width: "100%"}}>
                <ExpansionPanelSummary expandIcon={<ExpandMoreIcon/>}
                  aria-controls="panella content">
                    <Typography>
                        {this.state.data[idx].name}
                    </Typography>
                
                </ExpansionPanelSummary>
                <ExpansionPanelDetails>
                <table
                    table-bordered
                    table-hover
                    id="foodTruckTable"
                    bordercolor="green"
                  >
                    <thead>
                      <tr>
                        <th className="text-center"> Food Truck Name </th>
                        <th className="text-center"> Schedule </th>
                        <th className="text-center"> Cost </th>
                        <th className="text-center"> Food Type </th>
                        <th className="text-center"> Menu </th>
                        <th />
                      </tr>
                    </thead>
                    <tbody>
                        <tr id="addr0" key={idx}>
                          <td>
                            <input
                              type="text"
                              name="name"
                              value={this.state.data[idx].name}
                              onChange={this.handleTruckChange(idx)}
                              className="form-control"
                            />
                          </td>
                          <td>
                            <table>
                              <tbody>
                                <tr>
                                  <td>Monday</td>
                                  <td>
                                    <FormControl className={classes.margin}>
                                      <InputLabel htmlFor="Food-Type">O/C</InputLabel>
                                      <NativeSelect
                                        id="costSelect"
                                        value={this.state.schedule[idx].monOpen}
                                        onChange={this.handleScheduleChange(idx)}
                                        input={<BootstrapInput />}
                                      >
                                        <option aria-label="None" value="" />
                                        <option value={"0"}>Open</option>
                                        <option value={"1"}>Closed</option>
                                      </NativeSelect>
                                    </FormControl>
                                  </td>
                                  <td>
                                    <TextField
                                      id="time"
                                      label="Start Time"
                                      type="time"
                                      value={this.state.schedule[idx].monStartTime}
                                      onChange={this.handleScheduleChange(idx)}
                                      className={classes.textField}
                                      InputLabelProps={{
                                        shrink: true,
                                      }}
                                    />
                                  </td>
                                  <td>
                                    <TextField
                                      id="time"
                                      label="End Time"
                                      type="time"
                                      value={this.state.schedule[idx].monEndTime}
                                      onChange={this.handleScheduleChange(idx)}
                                      className={classes.textField}
                                      InputLabelProps={{
                                        shrink: true,
                                      }}
                                    />
                                  </td>
                                  <td>
                                    Location
                                    <td>
                                      <FormControl
                                        fullWidth
                                        className={classes.margin}
                                        variant="outlined"
                                      >
                                        <InputLabel htmlFor="outlined-adornment-amount">
                                          Latitude
                                        </InputLabel>
                                        <OutlinedInput
                                          id="outlined-adornment-amount"
                                          value={this.state.schedule[idx].monLatitude}
                                          onChange={this.handleScheduleChange(idx)}
                                          startAdornment={
                                            <InputAdornment position="start">
                                              lat:
                                            </InputAdornment>
                                          }
                                          labelWidth={30}
                                        />
                                      </FormControl>
                                    </td>
                                    <td>
                                      <FormControl
                                        fullWidth
                                        className={classes.margin}
                                        variant="outlined"
                                      >
                                        <InputLabel htmlFor="outlined-adornment-amount">
                                          Longitude
                                        </InputLabel>
                                        <OutlinedInput
                                          id="outlined-adornment-amount"
                                          value={
                                            this.state.schedule[idx].monLongitude
                                          }
                                          onChange={this.handleScheduleChange(idx)}
                                          startAdornment={
                                            <InputAdornment position="start">
                                              Lon:
                                            </InputAdornment>
                                          }
                                          labelWidth={30}
                                        />
                                      </FormControl>
                                    </td>
                                  </td>
                                </tr>
                                <tr>
                                  <td>Tuesday</td>
                                  <td>
                                    <FormControl className={classes.margin}>
                                      <InputLabel htmlFor="Food-Type">O/C</InputLabel>
                                      <NativeSelect
                                        id="costSelect"
                                        value={this.state.schedule[idx].tueOpen}
                                        onChange={this.handleScheduleChange(idx)}
                                        input={<BootstrapInput />}
                                      >
                                        <option aria-label="None" value="" />
                                        <option value={"0"}>Open</option>
                                        <option value={"1"}>Closed</option>
                                      </NativeSelect>
                                    </FormControl>
                                  </td>
                                  <td>
                                    <TextField
                                      id="time"
                                      label="Start Time"
                                      type="time"
                                      value={this.state.schedule[idx].tueStartTime}
                                      onChange={this.handleScheduleChange(idx)}
                                      className={classes.textField}
                                      InputLabelProps={{
                                        shrink: true,
                                      }}
                                    />
                                  </td>
                                  <td>
                                    <TextField
                                      id="time"
                                      label="End Time"
                                      type="time"
                                      value={this.state.schedule[idx].tueEndTime}
                                      onChange={this.handleScheduleChange(idx)}
                                      className={classes.textField}
                                      InputLabelProps={{
                                        shrink: true,
                                      }}
                                    />
                                  </td>
                                  <td>
                                    Location
                                    <td>
                                      <FormControl
                                        fullWidth
                                        className={classes.margin}
                                        variant="outlined"
                                      >
                                        <InputLabel htmlFor="outlined-adornment-amount">
                                          Latitude
                                        </InputLabel>
                                        <OutlinedInput
                                          id="outlined-adornment-amount"
                                          value={this.state.schedule[idx].tueLatitude}
                                          onChange={this.handleScheduleChange(idx)}
                                          startAdornment={
                                            <InputAdornment position="start">
                                              lat:
                                            </InputAdornment>
                                          }
                                          labelWidth={30}
                                        />
                                      </FormControl>
                                    </td>
                                    <td>
                                      <FormControl
                                        fullWidth
                                        className={classes.margin}
                                        variant="outlined"
                                      >
                                        <InputLabel htmlFor="outlined-adornment-amount">
                                          Longitude
                                        </InputLabel>
                                        <OutlinedInput
                                          id="outlined-adornment-amount"
                                          value={
                                            this.state.schedule[idx].tueLongitude
                                          }
                                          onChange={this.handleScheduleChange(idx)}
                                          startAdornment={
                                            <InputAdornment position="start">
                                              Lon:
                                            </InputAdornment>
                                          }
                                          labelWidth={30}
                                        />
                                      </FormControl>
                                    </td>
                                  </td>
                                </tr>
                                <tr>
                                  <td>Wednesday</td>
                                  <td>
                                    <FormControl className={classes.margin}>
                                      <InputLabel htmlFor="Food-Type">O/C</InputLabel>
                                      <NativeSelect
                                        id="costSelect"
                                        value={this.state.schedule[idx].wedOpen}
                                        onChange={this.handleScheduleChange(idx)}
                                        input={<BootstrapInput />}
                                      >
                                        <option aria-label="None" value="" />
                                        <option value={"0"}>Open</option>
                                        <option value={"1"}>Closed</option>
                                      </NativeSelect>
                                    </FormControl>
                                  </td>
                                  <td>
                                    <TextField
                                      id="time"
                                      label="Start Time"
                                      type="time"
                                      value={this.state.schedule[idx].wedStartTime}
                                      onChange={this.handleScheduleChange(idx)}
                                      className={classes.textField}
                                      InputLabelProps={{
                                        shrink: true,
                                      }}
                                    />
                                  </td>
                                  <td>
                                    <TextField
                                      id="time"
                                      label="End Time"
                                      type="time"
                                      value={this.state.schedule[idx].wedEndTime}
                                      onChange={this.handleScheduleChange(idx)}
                                      className={classes.textField}
                                      InputLabelProps={{
                                        shrink: true,
                                      }}
                                    />
                                  </td>
                                  <td>
                                    Location
                                    <td>
                                      <FormControl
                                        fullWidth
                                        className={classes.margin}
                                        variant="outlined"
                                      >
                                        <InputLabel htmlFor="outlined-adornment-amount">
                                          Latitude
                                        </InputLabel>
                                        <OutlinedInput
                                          id="outlined-adornment-amount"
                                          value={this.state.schedule[idx].wedLatitude}
                                          onChange={this.handleScheduleChange(idx)}
                                          startAdornment={
                                            <InputAdornment position="start">
                                              lat:
                                            </InputAdornment>
                                          }
                                          labelWidth={30}
                                        />
                                      </FormControl>
                                    </td>
                                    <td>
                                      <FormControl
                                        fullWidth
                                        className={classes.margin}
                                        variant="outlined"
                                      >
                                        <InputLabel htmlFor="outlined-adornment-amount">
                                          Longitude
                                        </InputLabel>
                                        <OutlinedInput
                                          id="outlined-adornment-amount"
                                          value={
                                            this.state.schedule[idx].wedLongitude
                                          }
                                          onChange={this.handleScheduleChange(idx)}
                                          startAdornment={
                                            <InputAdornment position="start">
                                              Lon:
                                            </InputAdornment>
                                          }
                                          labelWidth={30}
                                        />
                                      </FormControl>
                                    </td>
                                  </td>
                                </tr>
                                <tr>
                                  <td>Thursday</td>
                                  <td>
                                    <FormControl className={classes.margin}>
                                      <InputLabel htmlFor="Food-Type">O/C</InputLabel>
                                      <NativeSelect
                                        id="costSelect"
                                        value={this.state.schedule[idx].thuOpen}
                                        onChange={this.handleScheduleChange(idx)}
                                        input={<BootstrapInput />}
                                      >
                                        <option aria-label="None" value="" />
                                        <option value={"0"}>Open</option>
                                        <option value={"1"}>Closed</option>
                                      </NativeSelect>
                                    </FormControl>
                                  </td>
                                  <td>
                                    <TextField
                                      id="time"
                                      label="Start Time"
                                      type="time"
                                      value={this.state.schedule[idx].thuStartTime}
                                      onChange={this.handleScheduleChange(idx)}
                                      className={classes.textField}
                                      InputLabelProps={{
                                        shrink: true,
                                      }}
                                    />
                                  </td>
                                  <td>
                                    <TextField
                                      id="time"
                                      label="End Time"
                                      type="time"
                                      value={this.state.schedule[idx].thuEndTime}
                                      onChange={this.handleScheduleChange(idx)}
                                      className={classes.textField}
                                      InputLabelProps={{
                                        shrink: true,
                                      }}
                                    />
                                  </td>
                                  <td>
                                    Location
                                    <td>
                                      <FormControl
                                        fullWidth
                                        className={classes.margin}
                                        variant="outlined"
                                      >
                                        <InputLabel htmlFor="outlined-adornment-amount">
                                          Latitude
                                        </InputLabel>
                                        <OutlinedInput
                                          id="outlined-adornment-amount"
                                          value={this.state.schedule[idx].thuLatitude}
                                          onChange={this.handleScheduleChange(idx)}
                                          startAdornment={
                                            <InputAdornment position="start">
                                              lat:
                                            </InputAdornment>
                                          }
                                          labelWidth={30}
                                        />
                                      </FormControl>
                                    </td>
                                    <td>
                                      <FormControl
                                        fullWidth
                                        className={classes.margin}
                                        variant="outlined"
                                      >
                                        <InputLabel htmlFor="outlined-adornment-amount">
                                          Longitude
                                        </InputLabel>
                                        <OutlinedInput
                                          id="outlined-adornment-amount"
                                          value={
                                            this.state.schedule[idx].thuLongitude
                                          }
                                          onChange={this.handleScheduleChange(idx)}
                                          startAdornment={
                                            <InputAdornment position="start">
                                              Lon:
                                            </InputAdornment>
                                          }
                                          labelWidth={30}
                                        />
                                      </FormControl>
                                    </td>
                                  </td>
                                </tr>
                                <tr>
                                  <td>Friday</td>
                                  <td>
                                    <FormControl className={classes.margin}>
                                      <InputLabel htmlFor="Food-Type">O/C</InputLabel>
                                      <NativeSelect
                                        id="costSelect"
                                        value={this.state.schedule[idx].friOpen}
                                        onChange={this.handleScheduleChange(idx)}
                                        input={<BootstrapInput />}
                                      >
                                        <option aria-label="None" value="" />
                                        <option value={"0"}>Open</option>
                                        <option value={"1"}>Closed</option>
                                      </NativeSelect>
                                    </FormControl>
                                  </td>
                                  <td>
                                    <TextField
                                      id="time"
                                      label="Start Time"
                                      type="time"
                                      value={this.state.schedule[idx].friStartTime}
                                      onChange={this.handleScheduleChange(idx)}
                                      className={classes.textField}
                                      InputLabelProps={{
                                        shrink: true,
                                      }}
                                    />
                                  </td>
                                  <td>
                                    <TextField
                                      id="time"
                                      label="End Time"
                                      type="time"
                                      value={this.state.schedule[idx].friEndTime}
                                      onChange={this.handleScheduleChange(idx)}
                                      className={classes.textField}
                                      InputLabelProps={{
                                        shrink: true,
                                      }}
                                    />
                                  </td>
                                  <td>
                                    Location
                                    <td>
                                      <FormControl
                                        fullWidth
                                        className={classes.margin}
                                        variant="outlined"
                                      >
                                        <InputLabel htmlFor="outlined-adornment-amount">
                                          Latitude
                                        </InputLabel>
                                        <OutlinedInput
                                          id="outlined-adornment-amount"
                                          value={this.state.schedule[idx].friLatitude}
                                          onChange={this.handleScheduleChange(idx)}
                                          startAdornment={
                                            <InputAdornment position="start">
                                              lat:
                                            </InputAdornment>
                                          }
                                          labelWidth={30}
                                        />
                                      </FormControl>
                                    </td>
                                    <td>
                                      <FormControl
                                        fullWidth
                                        className={classes.margin}
                                        variant="outlined"
                                      >
                                        <InputLabel htmlFor="outlined-adornment-amount">
                                          Longitude
                                        </InputLabel>
                                        <OutlinedInput
                                          id="outlined-adornment-amount"
                                          value={
                                            this.state.schedule[idx].friLongitude
                                          }
                                          onChange={this.handleScheduleChange(idx)}
                                          startAdornment={
                                            <InputAdornment position="start">
                                              Lon:
                                            </InputAdornment>
                                          }
                                          labelWidth={30}
                                        />
                                      </FormControl>
                                    </td>
                                  </td>
                                </tr>
                                <tr>
                                  <td>Saturday</td>
                                  <td>
                                    <FormControl className={classes.margin}>
                                      <InputLabel htmlFor="Food-Type">O/C</InputLabel>
                                      <NativeSelect
                                        id="costSelect"
                                        value={this.state.schedule[idx].satOpen}
                                        onChange={this.handleScheduleChange(idx)}
                                        input={<BootstrapInput />}
                                      >
                                        <option aria-label="None" value="" />
                                        <option value={"0"}>Open</option>
                                        <option value={"1"}>Closed</option>
                                      </NativeSelect>
                                    </FormControl>
                                  </td>
                                  <td>
                                    <TextField
                                      id="time"
                                      label="Start Time"
                                      type="time"
                                      value={this.state.schedule[idx].satStartTime}
                                      onChange={this.handleScheduleChange(idx)}
                                      className={classes.textField}
                                      InputLabelProps={{
                                        shrink: true,
                                      }}
                                    />
                                  </td>
                                  <td>
                                    <TextField
                                      id="time"
                                      label="End Time"
                                      type="time"
                                      value={this.state.schedule[idx].satEndTime}
                                      onChange={this.handleScheduleChange(idx)}
                                      className={classes.textField}
                                      InputLabelProps={{
                                        shrink: true,
                                      }}
                                    />
                                  </td>
                                  <td>
                                    Location
                                    <td>
                                      <FormControl
                                        fullWidth
                                        className={classes.margin}
                                        variant="outlined"
                                      >
                                        <InputLabel htmlFor="outlined-adornment-amount">
                                          Latitude
                                        </InputLabel>
                                        <OutlinedInput
                                          id="outlined-adornment-amount"
                                          value={this.state.schedule[idx].satLatitude}
                                          onChange={() => {
                                            this.handleScheduleChange(idx);
                                          }}
                                          startAdornment={
                                            <InputAdornment position="start">
                                              lat:
                                            </InputAdornment>
                                          }
                                          labelWidth={30}
                                        />
                                      </FormControl>
                                    </td>
                                    <td>
                                      <FormControl
                                        fullWidth
                                        className={classes.margin}
                                        variant="outlined"
                                      >
                                        <InputLabel htmlFor="outlined-adornment-amount">
                                          Longitude
                                        </InputLabel>
                                        <OutlinedInput
                                          id="outlined-adornment-amount"
                                          value={
                                            this.state.schedule[idx].satLongitude
                                          }
                                          onChange={this.handleScheduleChange(idx)}
                                          startAdornment={
                                            <InputAdornment position="start">
                                              Lon:
                                            </InputAdornment>
                                          }
                                          labelWidth={30}
                                        />
                                      </FormControl>
                                    </td>
                                  </td>
                                </tr>
                                <tr>
                                  <td>Sunday</td>
                                  <td>
                                    <FormControl className={classes.margin}>
                                      <InputLabel htmlFor="Food-Type">O/C</InputLabel>
                                      <NativeSelect
                                        id="costSelect"
                                        value={this.state.schedule[idx].sunOpen}
                                        onChange={this.handleScheduleChange(idx)}
                                        input={<BootstrapInput />}
                                      >
                                        <option aria-label="None" value="" />
                                        <option value={"0"}>Open</option>
                                        <option value={"1"}>Closed</option>
                                      </NativeSelect>
                                    </FormControl>
                                  </td>
                                  <td>
                                    <TextField
                                      id="time"
                                      label="Start Time"
                                      type="time"
                                      value={this.state.schedule[idx].sunStartTime}
                                      onChange={this.handleScheduleChange(idx)}
                                      className={classes.textField}
                                      InputLabelProps={{
                                        shrink: true,
                                      }}
                                    />
                                  </td>
                                  <td>
                                    <TextField
                                      id="time"
                                      label="End Time"
                                      type="time"
                                      value={this.state.schedule[idx].sunEndTime}
                                      onChange={this.handleScheduleChange(idx)}
                                      className={classes.textField}
                                      InputLabelProps={{
                                        shrink: true,
                                      }}
                                    />
                                  </td>
                                  <td>
                                    Location
                                    <td>
                                      <FormControl
                                        fullWidth
                                        className={classes.margin}
                                        variant="outlined"
                                      >
                                        <InputLabel htmlFor="outlined-adornment-amount">
                                          Latitude
                                        </InputLabel>
                                        <OutlinedInput
                                          id="outlined-adornment-amount"
                                          value={this.state.schedule[idx].sunLatitude}
                                          onChange={this.handleScheduleChange(idx)}
                                          startAdornment={
                                            <InputAdornment position="start">
                                              lat:
                                            </InputAdornment>
                                          }
                                          labelWidth={30}
                                        />
                                      </FormControl>
                                    </td>
                                    <td>
                                      <FormControl
                                        fullWidth
                                        className={classes.margin}
                                        variant="outlined"
                                      >
                                        <InputLabel htmlFor="outlined-adornment-amount">
                                          Longitude
                                        </InputLabel>
                                        <OutlinedInput
                                          id="outlined-adornment-amount"
                                          value={
                                            this.state.schedule[idx].sunLongitude
                                          }
                                          onChange={this.handleScheduleChange(idx)}
                                          startAdornment={
                                            <InputAdornment position="start">
                                              Lon:
                                            </InputAdornment>
                                          }
                                          labelWidth={30}
                                        />
                                      </FormControl>
                                    </td>
                                  </td>
                                </tr>
                              </tbody>
                            </table>
                          </td>
                          <td>
                            <FormControl className={classes.margin}>
                              <InputLabel htmlFor="Food-Type">select Cost</InputLabel>
                              <NativeSelect
                                id="costSelect"
                                value={this.state.data[idx].cost}
                                onChange={this.handleTruckChange(idx)}
                                input={<BootstrapInput />}
                              >
                                <option aria-label="None" value="" />
                                <option value={"0"}>$</option>
                                <option value={"1"}>$$</option>
                                <option value={"2"}>$$$</option>
                                <option value={"3"}>$$$$</option>
                              </NativeSelect>
                            </FormControl>
                          </td>
                          <td>
                            <FormControl className={classes.margin}>
                              <InputLabel htmlFor="Food-Type">
                                select food type
                              </InputLabel>
                              <NativeSelect
                                id="foodTypeSelect"
                                value={this.state.data[idx].type}
                                onChange={this.handleTruckChange(idx)}
                                input={<BootstrapInput />}
                              >
                                <option aria-label="None" value="" />
                                <option value={"AMERICAN"}>American</option>
                                <option value={"CHINESE"}>Chinese</option>
                                <option value={"VIETNAMESE"}>Vietnamese</option>
                                <option value={"ITALIAN"}>Italian</option>
                                <option value={"AFRICAN"}>African</option>
                                <option value={"RUSSIAN"}>Russian</option>
                                <option value={"MEXICAN"}>Mexican</option>
                              </NativeSelect>
                            </FormControl>
                          </td>
                          <td>
                            <input
                              type="text"
                              name="mobile"
                              value={this.state.data[idx].menu}
                              onChange={this.handleTruckChange(idx)}
                              className="form-control"
                            />
                          </td>
                          <td>
                            <button
                              className="btn btn-outline-danger btn-sm"
                              onClick={this.handleRemoveSpecificRow(idx)}
                            >
                              Remove
                            </button>
                          </td>
                          <td>
                          <button onClick={() => this.onSaveRow(idx)} className="btn btn-primary">
                              Save Row
                          </button>
                          </td>
                        </tr>
                      
                    </tbody>
                  </table>
                </ExpansionPanelDetails>
              </ExpansionPanel>
            ))}
          
            
            <br />
            <button onClick={this.handleAddRow} className="btn btn-primary">
              Add Truck
            </button>
          </div>
          <br />
          
        </div>
      </div>
    );
    
  }
}
const mapStateToProps = (state) => ({
  auth: state.auth,
});

export default connect(mapStateToProps, null)(FinalTruckTable);
