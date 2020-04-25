import React from "react";
import { makeStyles, withStyles } from "@material-ui/core/styles";
import InputLabel from "@material-ui/core/InputLabel";
import FormControl from "@material-ui/core/FormControl";
import NativeSelect from "@material-ui/core/NativeSelect";
import OutlinedInput from "@material-ui/core/OutlinedInput";
import InputAdornment from "@material-ui/core/InputAdornment";
import ScheduleMap from './scheduleMap'
import { connect } from "react-redux";
import * as Request from "./../helpers/backendRequests";
import ExpandMoreIcon from '@material-ui/icons/ExpandMore';
import InputBase from "@material-ui/core/InputBase";
import TextField from "@material-ui/core/TextField";
import Button from '@material-ui/core/Button';
import Dialog from '@material-ui/core/Dialog';
import DialogActions from '@material-ui/core/DialogActions';
import DialogContent from '@material-ui/core/DialogContent';
import DialogTitle from '@material-ui/core/DialogTitle';
import DialogContentText from '@material-ui/core/DialogContentText';
import { ExpansionPanel, ExpansionPanelDetails, ExpansionPanelSummary, Typography } from "@material-ui/core";

const BootstrapInput = withStyles((theme) => ({
  textField: {
    marginLeft: theme.spacing(1),
    marginRight: theme.spacing(1),
    width: 200,
  },
  margin: {
    margin: theme.spacing(1),
  },
 
  container: {
    display: 'flex',
    flexWrap: 'wrap',
  },
}))(InputBase);

class FinalTruckTable extends React.Component {
  constructor(props) {
    super(props);
    this.state = {
      open: false,
      addOpen: false,
      addText: "",
      ownerTruckID: props.auth.user.sub,
      data: [],
      schedule: [],
    };
    this.onSubmit = this.onSaveRow.bind(this);
    this.handleClickOpen = this.handleClickOpen.bind(this);
    this.handleClose = this.handleClose.bind(this);
  }

  async componentDidMount() {
    // get the array of trucks
    let userData = await Request.findTrucksByOwnerID(this.state.ownerTruckID);
  
    const requests = userData.map(truck => Request.getScheduleDTOByID(truck.id));
  
    const listOfScheduleData = await Promise.all(requests);
  
    this.setState({
      // depends on if you want to keep original `this.state.schedule`
  
      // if you do:
      schedule: listOfScheduleData,
      data: userData
      
    });
  }

  handleTruckNameChange = (idx) => (e) => {
    const newTrucks = this.state.data.map((truck, sidx) => {
      if (idx !== sidx) return truck;
      return { ...truck, name: e.target.value };
    });
    
    this.setState({ data: newTrucks });
  }

  handleTruckCostChange = (idx) => (e) => {
    const newTrucks = this.state.data.map((truck, sidx) => {
      if (idx !== sidx) return truck;
      return { ...truck, cost: e.target.value };
    });
    
    this.setState({ data: newTrucks });
  }

  handleTruckTypeChange = (idx) => (e) => {
    const newTrucks = this.state.data.map((truck, sidx) => {
      if (idx !== sidx) return truck;
      return { ...truck, type: e.target.value };
    });
    
    this.setState({ data: newTrucks });
  }

  handleTruckMenuChange = (idx) => (e) => {
    const newTrucks = this.state.data.map((truck, sidx) => {
      if (idx !== sidx) return truck;
      return { ...truck, type: e.target.value };
    });
    
    this.setState({ data: newTrucks });
  }


  handleScheduleChange = (idx) => (e) => {
    const target = e.target;
    const value = target.value;
    const name = target.name;

    this.setState({
      schedule: this.state.schedule.map((item, itemIndex) => {
        if (itemIndex === idx) {
          return {
            ...item,
            [name]: value
          }
        }
        return item;
      })
    });
   console.log(this.state.schedule[idx]);
  };

  
  handleAddRow = (idx) => (e) => {
    const truckItem = {
      ownerID: this.state.ownerTruckID,
      id: "",
      name: this.state.addText,
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

    
    // add new truck into database
    Request.postNewTruck(truckItem)
    .then(response => {
      console.log("truck");
      console.log(response);
      console.log(response.data);
      this.setState({
        data: [...this.state.data, response.data]
      });
    });
    
    // add new truck schedule to database
    Request.postNewSchedule(truckSchedule)
    .then(response => {
      // print the object
      console.log(response);
      console.log(response.data);
      // set the id returned 
      truckSchedule.id = response.data[0].id;
      this.setState({
        schedule: [...this.state.schedule, truckSchedule],
      });

      
    });
    console.log(this.state.schedule);
    console.log(this.state.data);

    // requiered to close the text field for setting food truck name
    this.setState({
      addOpen: false,
      addText: "",
    });
  };

  handleRemoveSpecificRow = (idx) => () => {
    //remove the foodtruck from the database
    Request.deleteSchedule(this.state.data[idx].id);
    Request.deleteTruck(this.state.data[idx].id)
    
    
    
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
    let sdata = this.state.schedule[idx];
    
    // print data for testing purposes
    console.log("Printing the body of Schedule update");
    console.log(sdata);

    // update the schedule in the data base
    Request.updateSchedule(sdata);
    
    // set tdata to the existing food truck at index idx
    let tdata = this.state.data[idx];
    
    // print data for testing purposes
    console.log("Printing the body of Truck update");
    console.log(tdata);

    // update the truck in the database
    Request.updateTruckByID(tdata); 
  }

  handleClickOpen = () => {
    this.setState({open: true});
  };

  handleClose = () => {
    this.setState({open: false});
  };
  

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
                              onChange={this.handleTruckNameChange(idx)}
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
                                      <InputLabel htmlFor="openClosed">O/C</InputLabel>
                                      <NativeSelect
                                        id="openClosed"
                                        name="monOpen"
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
                                      name="monStartTime"
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
                                      name="monEndTime"
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
                                  <Button onClick={this.handleClickOpen}>Set Truck Location</Button>
                                    <Dialog disableBackdropClick disableEscapeKeyDown open={this.state.open} onClose={this.handleClose}
                                    maxWidth={"lg"}
                                    fullWidth="true">
                                      <DialogTitle>Drop a Pin Where Your Truck Is</DialogTitle>
                                      <DialogContent fullWidth="true">
                                        <form className={BootstrapInput.container}>
                                          
                                            <ScheduleMap />
                                          
                                          
                                        </form>
                                      </DialogContent>
                                      <DialogActions>
                                        <Button onClick={this.handleClose} color="primary">
                                          Cancel
                                        </Button>
                                        <Button onClick={this.handleClose} color="primary">
                                          Ok
                                        </Button>
                                      </DialogActions>
                                    </Dialog>
                                  </td>
                                </tr>
                                <tr>
                                  <td>Tuesday</td>
                                  <td>
                                    <FormControl className={classes.margin}>
                                      <InputLabel htmlFor="Food-Type">O/C</InputLabel>
                                      <NativeSelect
                                        id="costSelect"
                                        name="tueOpen"
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
                                      name="tueStartTime"
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
                                      name="tueEndTime"
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
                                          name="tueLatitude"
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
                                          name="tueLongitude"
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
                                        name="wedOpen"
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
                                      name="wedStartTime"
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
                                      name="wedEndTime"
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
                                          name="wedLatitude"
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
                                          name="wedLongitude"
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
                                        name="thuOpen"
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
                                      name="thuStartTime"
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
                                      name="thuEndTime"
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
                                          name="thuLatitude"
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
                                          name="thuLongitude"
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
                                        name="friOpen"
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
                                      name="friStartTime"
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
                                      name="friEndTime"
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
                                          name="friLatitude"
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
                                          name="friLongitude"
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
                                        name="satOpen"
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
                                      name="satStartTime"
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
                                      name="satEndTime"
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
                                          name="satLatitude"
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
                                          name="satLongitude"
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
                                        name="sunOpen"
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
                                      name="sunStartTime"
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
                                      name="sunEndTime"
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
                                          name="sunLatitude"
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
                                          name="sunLongitude"
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
                                onChange={this.handleTruckCostChange(idx)}
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
                                onChange={this.handleTruckTypeChange(idx)}
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
                              onChange={this.handleTruckMenuChange(idx)}
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
            <Button variant="outlined" color="primary" onClick={() => this.setState({addOpen: true})}>
              Add Truck
            </Button>
            <Dialog
              open={this.state.addOpen}
              onClose={() => this.setState({addOpen: false})}
            >
              <DialogTitle>
                Enter the Name of Your New Food Truck
              </DialogTitle>
              <DialogContent>
                <DialogContentText />
                <TextField value={this.state.addText} onChange={(e) => this.setState({addText: e.target.value})}
                  autoFocus
                  margin="dense"
                  label="Food Truck Name"
                  type="email"
                  fullWidth
                />
              </DialogContent>
              <DialogActions>
                <Button onClick={() => this.setState({addOpen: false})} color="primary">
                  Cancel
                </Button>
                <Button onClick={this.handleAddRow()} color="primary">
                  Add Truck
                </Button>
              </DialogActions>
            </Dialog>
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
