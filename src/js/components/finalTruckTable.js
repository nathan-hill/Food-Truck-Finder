import React from "react";
import { makeStyles, withStyles } from '@material-ui/core/styles';
import InputLabel from '@material-ui/core/InputLabel';
import FormControl from '@material-ui/core/FormControl';
import NativeSelect from '@material-ui/core/NativeSelect';
import OutlinedInput from "@material-ui/core/OutlinedInput";
import InputAdornment from "@material-ui/core/InputAdornment";
import axios from "axios";
import {connect} from "react-redux";

import InputBase from '@material-ui/core/InputBase';
import TextField from '@material-ui/core/TextField';

const BootstrapInput = withStyles((theme) => ({
  root: {
    'label + &': {
      marginTop: theme.spacing(3),
    },
  },
  textField: {
    marginLeft: theme.spacing(1),
    marginRight: theme.spacing(1),
    width: 200,
  },
  margin: {
    margin: theme.spacing(1)
  },
  input: {
    borderRadius: 4,
    position: 'relative',
    backgroundColor: theme.palette.background.paper,
    border: '1px solid #ced4da',
    fontSize: 16,
    padding: '10px 26px 10px 12px',
    transition: theme.transitions.create(['border-color', 'box-shadow']),
    // Use the system font instead of the default Roboto font.
    fontFamily: [
      '-apple-system',
      'BlinkMacSystemFont',
      '"Segoe UI"',
      'Roboto',
      '"Helvetica Neue"',
      'Arial',
      'sans-serif',
      '"Apple Color Emoji"',
      '"Segoe UI Emoji"',
      '"Segoe UI Symbol"',
    ].join(','),
    '&:focus': {
      borderRadius: 4,
      borderColor: '#80bdff',
      boxShadow: '0 0 0 0.2rem rgba(0,123,255,.25)',
    },
  },
}))(InputBase);

var constants = require("./../helpers/constants");

class finalTruckTable extends React.Component {
  constructor(props){
    super(props)
    this.state = {
      id: props.auth.user.sub,
      data: [
        {
        truckID: "",
        foodTruckName: "",
        cost: "",
        foodType: "",
        menu: ""
  
        },
      ],
      schedule:[
        {
          monOpenClosed: "",
          monStartTime: "",
          monEndTime: "",
          monLat: "",
          monLon: "",
    
          tueOpenClosed: "",
          tueStartTime: "",
          tueEndTime: "",
          tueLat: "",
          tueLon: "",
    
          wedOpenClosed: "",
          wedStartTime: "",
          wedEndTime: "",
          wedLat: "",
          wedLon: "",
    
          thuOpenClosed: "",
          thuStartTime: "",
          thuEndTime: "",
          thuLat: "",
          thuLon: "",
    
          friOpenClosed: "",
          friStartTime: "",
          friEndTime: "",
          friLat: "",
          friLon: "",
    
          satOpenClosed: "",
          satStartTime: "",
          satEndTime: "",
          satLat: "",
          satLon: "",
    
          sunOpenClosed: "",
          sunStartTime: "",
          sunEndTime: "",
          sunLat: "",
          sunLon: "",
        },
      ]
    };
  }
  

  componentDidMount = () => {
    // console.log("ID: ", this.props.auth.user.sub);
    // axios.get(constants.backend_url + "trucks/findTrucksByownerID", {
    //     params: {
    //       l: this.props.auth.user.sub
    //     }
    // }).then(res => {
    //     this.setState({data: res.data})
    //     console.log(this.state.data)
    // });

    // axios.get(constants.backend_url + "schedule/getScheduleByID", {
    //   params: {
    //       l: this.props.user.sub
    //   }
    // }).then(res => {
    //     this.setState({schedule: res.data})
    //     console.log(this.state.schedule)
    // });
  }


  handleTruckChange = idx => e => {
    
    const { name, value } = e.target;
    const data = [...this.state.data];
    
    data[idx] = {
      [name]: value
    };
    this.setState({
      data
    });
  };

  handleScheduleChange = idx => e => {
    
    const { name, value } = e.target;
    const schedule = [...this.state.schedule];
    
    schedule[idx] = {
      [name]: value
    };
    this.setState({
      schedule
    });
  };


  handleAddRow = () => {
    const truckItem = {
      truckID: "",
      foodTruckName: "",
      cost: "",
      foodType: "",
      menu: ""

    };

    const truckSchedule = {
      monOpenClosed: "",
      monStartTime: "",
      monEndTime: "",
      monLat: "",
      monLon: "",

      tueOpenClosed: "",
      tueStartTime: "",
      tueEndTime: "",
      tueLat: "",
      tueLon: "",

      wedOpenClosed: "",
      wedStartTime: "",
      wedEndTime: "",
      wedLat: "",
      wedLon: "",

      thuOpenClosed: "",
      thuStartTime: "",
      thuEndTime: "",
      thuLat: "",
      thuLon: "",

      friOpenClosed: "",
      friStartTime: "",
      friEndTime: "",
      friLat: "",
      friLon: "",

      satOpenClosed: "",
      satStartTime: "",
      satEndTime: "",
      satLat: "",
      satLon: "",

      sunOpenClosed: "",
      sunStartTime: "",
      sunEndTime: "",
      sunLat: "",
      sunLon: "",
    };

    this.setState({
      data: [...this.state.data, truckItem],
      schedule: [...this.state.schedule, truckSchedule]
    });
  };


  handleRemoveSpecificRow = idx => () => {
    const data = [...this.state.data];
    const schedule = [...this.state.schedule];
    data.splice(idx, 1);
    schedule.splice(idx, 1);
    this.setState({ data });
    this.setState({ schedule });
  };

  onSubmit(e) {
    e.preventDefault();

    console.log("Submit form");
    this.setState({ isDisabled: true });
    console.log(this.state);

    let udata = {
      id: this.state.id,

    };

    let uschedule =  {

    };
    
    let data = { truck: udata, schedule: uschedule };
    data.headers = {
      "Access-Control-Allow-Origin": "*",
      "content-type": "application/json",
      Accept: "application/json"
    };

    console.log("Printing the body of form update");
    console.log(data);

    axios.put(constants.backend_url + "truck/update", data).then(res => {
      console.log(res);
    });
    this.setState({ isDisabled: true });
  }

  render() {
    const classes = makeStyles();
    
    return (
      
        <div className="container" style={{
          display: "flex",
          justifyContent: "center",
          alignItems: "center"
      }}>
          <div className="row clearfix">
            <div className="col-md-12 column">
              <table table-bordered table-hover
                id="foodTruckTable"
                bordercolor="green"
              >
                <thead>
                  <tr>
                    <th className="text-center"> ID </th>
                    <th className="text-center"> Food Truck Name </th>
                    <th className="text-center"> Schedule </th>
                    <th className="text-center"> Cost </th>
                    <th className="text-center"> Food Type </th>
                    <th className="text-center"> Menu </th>
                    <th />
                  </tr>
                </thead>
                <tbody>
                  {this.state.data.map((item, idx) => (
                    <tr id="addr0" key={idx} >
                      <td>{idx}</td>
                      <td>
                        <input
                          type="text"
                          name="name"
                          value={this.state.data[idx].foodTruckName}
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
                                    value={this.state.schedule[idx].monOpenClosed}
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
                                  <FormControl fullWidth className={classes.margin} variant="outlined">
                                    <InputLabel htmlFor="outlined-adornment-amount">Latitude</InputLabel>
                                    <OutlinedInput
                                      id="outlined-adornment-amount"
                                      value={this.state.schedule[idx].monLat}
                                      onChange={this.handleScheduleChange(idx)}
                                      startAdornment={<InputAdornment position="start">lat:</InputAdornment>}
                                      labelWidth={30}
                                    />
                                  </FormControl>
                                  </td>
                                  <td>
                                  <FormControl fullWidth className={classes.margin} variant="outlined">
                                    <InputLabel htmlFor="outlined-adornment-amount">Longitude</InputLabel>
                                    <OutlinedInput
                                      id="outlined-adornment-amount"
                                      value={this.state.schedule[idx].monLon}
                                      onChange={this.handleScheduleChange(idx)}
                                      startAdornment={<InputAdornment position="start">Lon:</InputAdornment>}
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
                                    value={this.state.schedule[idx].tueOpenClosed}
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
                                  <FormControl fullWidth className={classes.margin} variant="outlined">
                                    <InputLabel htmlFor="outlined-adornment-amount">Latitude</InputLabel>
                                    <OutlinedInput
                                      id="outlined-adornment-amount"
                                      value={this.state.schedule[idx].tueLat}
                                      onChange={this.handleScheduleChange(idx)}
                                      startAdornment={<InputAdornment position="start">lat:</InputAdornment>}
                                      labelWidth={30}
                                    />
                                  </FormControl>
                                  </td>
                                  <td>
                                  <FormControl fullWidth className={classes.margin} variant="outlined">
                                    <InputLabel htmlFor="outlined-adornment-amount">Longitude</InputLabel>
                                    <OutlinedInput
                                      id="outlined-adornment-amount"
                                      value={this.state.schedule[idx].tueLon}
                                      onChange={this.handleScheduleChange(idx)}
                                      startAdornment={<InputAdornment position="start">Lon:</InputAdornment>}
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
                                    value={this.state.schedule[idx].wedOpenClosed}
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
                                  <FormControl fullWidth className={classes.margin} variant="outlined">
                                    <InputLabel htmlFor="outlined-adornment-amount">Latitude</InputLabel>
                                    <OutlinedInput
                                      id="outlined-adornment-amount"
                                      value={this.state.schedule[idx].wedLat}
                                      onChange={this.handleScheduleChange(idx)}
                                      startAdornment={<InputAdornment position="start">lat:</InputAdornment>}
                                      labelWidth={30}
                                    />
                                  </FormControl>
                                  </td>
                                  <td>
                                  <FormControl fullWidth className={classes.margin} variant="outlined">
                                    <InputLabel htmlFor="outlined-adornment-amount">Longitude</InputLabel>
                                    <OutlinedInput
                                      id="outlined-adornment-amount"
                                      value={this.state.schedule[idx].wedLon}
                                      onChange={this.handleScheduleChange(idx)}
                                      startAdornment={<InputAdornment position="start">Lon:</InputAdornment>}
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
                                    value={this.state.schedule[idx].thuOpenClosed}
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
                                  <FormControl fullWidth className={classes.margin} variant="outlined">
                                    <InputLabel htmlFor="outlined-adornment-amount">Latitude</InputLabel>
                                    <OutlinedInput
                                      id="outlined-adornment-amount"
                                      value={this.state.schedule[idx].thuLat}
                                      onChange={this.handleScheduleChange(idx)}
                                      startAdornment={<InputAdornment position="start">lat:</InputAdornment>}
                                      labelWidth={30}
                                    />
                                  </FormControl>
                                  </td>
                                  <td>
                                  <FormControl fullWidth className={classes.margin} variant="outlined">
                                    <InputLabel htmlFor="outlined-adornment-amount">Longitude</InputLabel>
                                    <OutlinedInput
                                      id="outlined-adornment-amount"
                                      value={this.state.schedule[idx].thuLon}
                                      onChange={this.handleScheduleChange(idx)}
                                      startAdornment={<InputAdornment position="start">Lon:</InputAdornment>}
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
                                    value={this.state.schedule[idx].friOpenClosed}
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
                                  <FormControl fullWidth className={classes.margin} variant="outlined">
                                    <InputLabel htmlFor="outlined-adornment-amount">Latitude</InputLabel>
                                    <OutlinedInput
                                      id="outlined-adornment-amount"
                                      value={this.state.schedule[idx].friLat}
                                      onChange={this.handleScheduleChange(idx)}
                                      startAdornment={<InputAdornment position="start">lat:</InputAdornment>}
                                      labelWidth={30}
                                    />
                                  </FormControl>
                                  </td>
                                  <td>
                                  <FormControl fullWidth className={classes.margin} variant="outlined">
                                    <InputLabel htmlFor="outlined-adornment-amount">Longitude</InputLabel>
                                    <OutlinedInput
                                      id="outlined-adornment-amount"
                                      value={this.state.schedule[idx].friLon}
                                      onChange={this.handleScheduleChange(idx)}
                                      startAdornment={<InputAdornment position="start">Lon:</InputAdornment>}
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
                                    value={this.state.schedule[idx].satOpenClosed}
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
                                  <FormControl fullWidth className={classes.margin} variant="outlined">
                                    <InputLabel htmlFor="outlined-adornment-amount">Latitude</InputLabel>
                                    <OutlinedInput
                                      id="outlined-adornment-amount"
                                      value={this.state.schedule[idx].satLat}
                                      onChange={this.handleScheduleChange(idx)}
                                      startAdornment={<InputAdornment position="start">lat:</InputAdornment>}
                                      labelWidth={30}
                                    />
                                  </FormControl>
                                  </td>
                                  <td>
                                  <FormControl fullWidth className={classes.margin} variant="outlined">
                                    <InputLabel htmlFor="outlined-adornment-amount">Longitude</InputLabel>
                                    <OutlinedInput
                                      id="outlined-adornment-amount"
                                      value={this.state.schedule[idx].satLon}
                                      onChange={this.handleScheduleChange(idx)}
                                      startAdornment={<InputAdornment position="start">Lon:</InputAdornment>}
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
                                    value={this.state.schedule[idx].sunOpenClosed}
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
                                  <FormControl fullWidth className={classes.margin} variant="outlined">
                                    <InputLabel htmlFor="outlined-adornment-amount">Latitude</InputLabel>
                                    <OutlinedInput
                                      id="outlined-adornment-amount"
                                      value={this.state.schedule[idx].sunLon}
                                      onChange={this.handleScheduleChange(idx)}
                                      startAdornment={<InputAdornment position="start">lat:</InputAdornment>}
                                      labelWidth={30}
                                    />
                                  </FormControl>
                                  </td>
                                  <td>
                                  <FormControl fullWidth className={classes.margin} variant="outlined">
                                    <InputLabel htmlFor="outlined-adornment-amount">Longitude</InputLabel>
                                    <OutlinedInput
                                      id="outlined-adornment-amount"
                                      value={this.state.schedule[idx].sunLon}
                                      onChange={this.handleScheduleChange(idx)}
                                      startAdornment={<InputAdornment position="start">Lon:</InputAdornment>}
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
                          <option value={"1"}>$</option>
                          <option value={"2"}>$$</option>
                          <option value={"3"}>$$$</option>
                          <option value={"4"}>$$$$</option>
                        </NativeSelect>
                      </FormControl>
                      </td>
                      <td>
                      <FormControl className={classes.margin}>
                        <InputLabel htmlFor="Food-Type">select food type</InputLabel>
                        <NativeSelect
                          id="foodTypeSelect"
                          value={this.state.data[idx].foodType}
                          onChange={this.handleTruckChange(idx)}
                          input={<BootstrapInput />}
                        >
                          <option aria-label="None" value="" />
                          <option value={"american"}>American</option>
                          <option value={"chinese"}>Chinese</option>
                          <option value={"vietnamese"}>Vietnamese</option>
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
                    </tr>
                  ))}
                </tbody>
              </table>
              <br/>
              <button onClick={this.handleAddRow} className="btn btn-primary" >
                Add Row
              </button>
              
            </div>
            <br/>
            <button onClick={this.onSubmit} className="btn btn-primary">
                Submit 
              </button>
          </div>
        </div>
      
    );
  }
}
const mapStateToProps = state => ({
  auth: state.auth,
});

export default connect(mapStateToProps, null)(finalTruckTable);