import React from "react";
import { makeStyles, withStyles } from '@material-ui/core/styles';
import InputLabel from '@material-ui/core/InputLabel';
import FormControl from '@material-ui/core/FormControl';
import NativeSelect from '@material-ui/core/NativeSelect';
import OutlinedInput from "@material-ui/core/OutlinedInput";
import InputAdornment from "@material-ui/core/InputAdornment";

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



class finalTruckTable extends React.Component {
  state = {
    rows: [
      {
        foodTruckName: "test",

        monOpenClosed: "0",
        monStartTime: "09:00",
        monEndTime: "11:00",
        monLat: "5",
        monLon: "5",

        tueOpenClosed: "0",
        tueStartTime: "09:00",
        tueEndTime: "11:00",
        tueLat: "5",
        tueLon: "5",

        wedOpenClosed: "0",
        wedStartTime: "09:00",
        wedEndTime: "11:00",
        wedLat: "5",
        wedLon: "5",

        thuOpenClosed: "0",
        thuStartTime: "09:00",
        thuEndTime: "11:00",
        thuLat: "5",
        thuLon: "5",

        friOpenClosed: "0",
        friStartTime: "09:00",
        friEndTime: "11:00",
        friLat: "5",
        friLon: "5",

        satOpenClosed: "0",
        satStartTime: "09:00",
        satEndTime: "11:00",
        satLat: "5",
        satLon: "5",

        sunOpenClosed: "0",
        sunStartTime: "09:00",
        sunEndTime: "11:00",
        sunLat: "5",
        sunLon: "5",
        
        cost: "1",
        foodType: "american",
        menu: "yeet"
      },
    ]
  };

  handleChange = idx => e => {
    
    const { name, value } = e.target;
    const rows = [...this.state.rows];
    
    rows[idx] = {
      [name]: value
    };
    this.setState({
      rows
    });
  };


  handleAddRow = () => {
    const item = {
      foodTruckName: "",

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
        
        cost: "",
        foodType: "",
        menu: ""

    };
    this.setState({
      rows: [...this.state.rows, item]
    });
  };

  handleRemoveRow = () => {
    this.setState({
      rows: this.state.rows.slice(0, -1)
    });
  };
  handleRemoveSpecificRow = idx => () => {
    const rows = [...this.state.rows];
    rows.splice(idx, 1);
    this.setState({ rows });
  };

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
              <table
                className="table table-bordered table-hover"
                id="tab_logic"
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
                  {this.state.rows.map((item, idx) => (
                    <tr id="addr0" key={idx} >
                      <td>{idx}</td>
                      <td>
                        <input
                          type="text"
                          name="name"
                          value={this.state.rows[idx].foodTruckName}
                          onChange={this.handleChange(idx)}
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
                                    value={this.state.rows[idx].monOpenClosed}
                                    onChange={this.handleChange(idx)}
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
                                  value={this.state.rows[idx].monStartTime}
                                  onChange={this.handleChange(idx)}
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
                                  value={this.state.rows[idx].monEndTime}
                                  onChange={this.handleChange(idx)}
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
                                      value={this.state.rows[idx].monLat}
                                      onChange={this.handleChange(idx)}
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
                                      value={this.state.rows[idx].monLon}
                                      onChange={this.handleChange(idx)}
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
                                    value={this.state.rows[idx].tueOpenClosed}
                                    onChange={this.handleChange(idx)}
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
                                  value={this.state.rows[idx].tueStartTime}
                                  onChange={this.handleChange(idx)}
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
                                  value={this.state.rows[idx].tueEndTime}
                                  onChange={this.handleChange(idx)}
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
                                      value={this.state.rows[idx].tueLat}
                                      onChange={this.handleChange(idx)}
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
                                      value={this.state.rows[idx].tueLon}
                                      onChange={this.handleChange(idx)}
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
                                    value={this.state.rows[idx].wedOpenClosed}
                                    onChange={this.handleChange(idx)}
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
                                  value={this.state.rows[idx].wedStartTime}
                                  onChange={this.handleChange(idx)}
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
                                  value={this.state.rows[idx].wedEndTime}
                                  onChange={this.handleChange(idx)}
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
                                      value={this.state.rows[idx].wedLat}
                                      onChange={this.handleChange(idx)}
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
                                      value={this.state.rows[idx].wedLon}
                                      onChange={this.handleChange(idx)}
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
                                    value={this.state.rows[idx].thuOpenClosed}
                                    onChange={this.handleChange(idx)}
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
                                  value={this.state.rows[idx].thuStartTime}
                                  onChange={this.handleChange(idx)}
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
                                  value={this.state.rows[idx].thuEndTime}
                                  onChange={this.handleChange(idx)}
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
                                      value={this.state.rows[idx].thuLat}
                                      onChange={this.handleChange(idx)}
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
                                      value={this.state.rows[idx].thuLon}
                                      onChange={this.handleChange(idx)}
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
                                    value={this.state.rows[idx].friOpenClosed}
                                    onChange={this.handleChange(idx)}
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
                                  value={this.state.rows[idx].friStartTime}
                                  onChange={this.handleChange(idx)}
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
                                  value={this.state.rows[idx].friEndTime}
                                  onChange={this.handleChange(idx)}
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
                                      value={this.state.rows[idx].friLat}
                                      onChange={this.handleChange(idx)}
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
                                      value={this.state.rows[idx].friLon}
                                      onChange={this.handleChange(idx)}
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
                                    value={this.state.rows[idx].satOpenClosed}
                                    onChange={this.handleChange(idx)}
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
                                  value={this.state.rows[idx].satStartTime}
                                  onChange={this.handleChange(idx)}
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
                                  value={this.state.rows[idx].satEndTime}
                                  onChange={this.handleChange(idx)}
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
                                      value={this.state.rows[idx].satLat}
                                      onChange={this.handleChange(idx)}
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
                                      value={this.state.rows[idx].satLon}
                                      onChange={this.handleChange(idx)}
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
                                    value={this.state.rows[idx].sunOpenClosed}
                                    onChange={this.handleChange(idx)}
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
                                  value={this.state.rows[idx].sunStartTime}
                                  onChange={this.handleChange(idx)}
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
                                  value={this.state.rows[idx].sunEndTime}
                                  onChange={this.handleChange(idx)}
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
                                      value={this.state.rows[idx].sunLon}
                                      onChange={this.handleChange(idx)}
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
                                      value={this.state.rows[idx].sunLon}
                                      onChange={this.handleChange(idx)}
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
                          value={this.state.rows[idx].cost}
                          onChange={this.handleChange(idx)}
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
                          value={this.state.rows[idx].foodType}
                          onChange={this.handleChange(idx)}
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
                          value={this.state.rows[idx].menu}
                          onChange={this.handleChange(idx)}
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
              <button onClick={this.handleAddRow} className="btn btn-primary" >
                Add Row
              </button>
              
            </div>
            <button onClick={this.submitTable} className="btn btn-primary">
                Submit 
              </button>
          </div>
        </div>
      
    );
  }
}

export default finalTruckTable;