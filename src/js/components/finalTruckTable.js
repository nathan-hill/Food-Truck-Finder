import React from "react";
import { makeStyles, withStyles } from '@material-ui/core/styles';
import InputLabel from '@material-ui/core/InputLabel';
import FormControl from '@material-ui/core/FormControl';
import NativeSelect from '@material-ui/core/NativeSelect';
import InputBase from '@material-ui/core/InputBase';


const BootstrapInput = withStyles((theme) => ({
  root: {
    'label + &': {
      marginTop: theme.spacing(3),
    },
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
        schedule: "425",
        cost: "1",
        foodType: "american",
        menu: "yeet"
      },
      {
        foodTruckName: "othertest",
        schedule: "123",
        cost: "4",
        foodType: "chinese",
        menu: "yote"
      }
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
      schedule: "",
      cost: ""
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
      
        <div className="container">
          <div className="row clearfix">
            <div className="col-md-12 column">
              <table
                className="table table-bordered table-hover"
                id="tab_logic"
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
                    <tr id="addr0" key={idx}>
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
                        <input
                          type="text"
                          name="mobile"
                          value={this.state.rows[idx].schedule}
                          onChange={this.handleChange(idx)}
                          className="form-control"
                        />
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
              <button onClick={this.handleAddRow} className="btn btn-primary">
                Add Row
              </button>
              <button
                onClick={this.handleRemoveRow}
                className="btn btn-danger float-right"
              >
                Delete Last Row
              </button>
            </div>
          </div>
        </div>
      
    );
  }
}

export default finalTruckTable;