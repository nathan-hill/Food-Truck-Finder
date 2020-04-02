import React, { useState } from 'react'
import { makeStyles } from '@material-ui/core/styles';

import AddIcon from '@material-ui/icons/Add'
import Button from '@material-ui/core/Button'
import Dialog from '@material-ui/core/Dialog'
import DialogActions from '@material-ui/core/DialogActions'
import DialogContent from '@material-ui/core/DialogContent'
import DialogContentText from '@material-ui/core/DialogContentText'
import DialogTitle from '@material-ui/core/DialogTitle'
import IconButton from '@material-ui/core/IconButton'
import PropTypes from 'prop-types'
import Switch from '@material-ui/core/Switch'
import TextField from '@material-ui/core/TextField'
import Tooltip from '@material-ui/core/Tooltip'
import InputLabel from '@material-ui/core/InputLabel';
import FormHelperText from '@material-ui/core/FormHelperText';
import FormControl from '@material-ui/core/FormControl';
//import Select from '@material-ui/core/Select';
import NativeSelect from '@material-ui/core/NativeSelect';

const initialTruck = {
  foodTruckName: '',
  schedule: '',
  cost: 0,
  foodType: 0,
  Menu: 'single',
  subRows: undefined,
}

const useStyles = makeStyles(theme => ({
  formControl: {
    margin: theme.spacing(1),
    minWidth: 120,
  },
  selectEmpty: {
    marginTop: theme.spacing(2),
  },
}));


const AddTruckDialog = (props) => {
  const classes = useStyles();
  const [truck, setTruck] = useState(initialTruck)
  const { addUserHandler } = props
  const [open, setOpen] = React.useState(false)

  const [switchState, setSwitchState] = React.useState({
    addMultiple: false,
  })

  const handleSwitchChange = name => event => {
    setSwitchState({ ...switchState, [name]: event.target.checked })
  }

  const resetSwitch = () => {
    setSwitchState({ addMultiple: false })
  }

  const handleClickOpen = () => {
    setOpen(true)
  }

  const handleClose = () => {
    setOpen(false)
    resetSwitch()
  }

  const handleAdd = event => {
    addUserHandler(truck)
    setTruck(initialTruck)
    switchState.addMultiple ? setOpen(true) : setOpen(false)
  }

  const handleChange = name => ({ target: { value } }) => {
    setTruck({ ...truck, [name]: value })
  }

  return (
    <div>
      <Tooltip title="Add">
        <IconButton aria-label="add" onClick={handleClickOpen}>
          <AddIcon />
        </IconButton>
      </Tooltip>
      <Dialog
        open={open}
        onClose={handleClose}
        aria-labelledby="form-dialog-title"
      >
        <DialogTitle id="form-dialog-title">Add Truck</DialogTitle>
        <DialogContent>
          <DialogContentText>Fill In Truck Details.</DialogContentText>
          <TextField
            autoFocus
            margin="dense"
            label="Food Truck Name"
            type="text"
            fullWidth
            value={truck.foodTruckName}
            onChange={handleChange('foodTruckName')}
          />
          <TextField
            margin="dense"
            label="Schedule"
            type="text"
            fullWidth
            value={truck.schedule}
            onChange={handleChange('schedule')}
          />
          <FormControl className={classes.formControl}>
          <InputLabel htmlFor="age-native-helper">Cost</InputLabel>
          <NativeSelect
              costValue={truck.cost}
              onChange={handleChange}
              inputProps={{
                name: 'cost',
                id: 'cost',
              }}
            >
              <option aria-label="None" value="" />
              <option costValue={1}>$</option>
              <option costValue={2}>$$</option>
              <option costValue={3}>$$$</option>
              <option costValue={4}>$$$$</option>
            </NativeSelect>
            <FormHelperText>Rate How Expensive Your Truck Is</FormHelperText>
          </FormControl>
          <FormControl className={classes.formControl}>
          <InputLabel htmlFor="age-native-helper">Food Type</InputLabel>
          <NativeSelect
              foodValue={truck.foodType}
              onChange={handleChange}
              inputProps={{
                name: 'foodType',
                id: 'foodType',
              }}
            >
              <option aria-label="None" value="" />
              <option foodValue={'Mexican'}>Mexican</option>
              <option foodValue={'American'}>American</option>
              <option foodValue={'Italian'}>Italian</option>
              <option foodValue={'Chinese'}>Chinese</option>
              <option foodValue={'Vietnamese'}>Vietnamese</option>
            </NativeSelect>
            <FormHelperText>What Type of Food is Served</FormHelperText>
          </FormControl>
          <TextField
            margin="dense"
            label="Menu"
            type="text"
            fullWidth
            value={truck.menu}
            onChange={handleChange('menu')}
          />
          
        </DialogContent>
        <DialogActions>
          <Tooltip title="Add multiple">
            <Switch
              checked={switchState.addMultiple}
              onChange={handleSwitchChange('addMultiple')}
              value="addMultiple"
              inputProps={{ 'aria-label': 'secondary checkbox' }}
            />
          </Tooltip>
          <Button onClick={handleClose} color="primary">
            Cancel
          </Button>
          <Button onClick={handleAdd} color="primary">
            Add
          </Button>
        </DialogActions>
      </Dialog>
    </div>
  )
}

AddTruckDialog.propTypes = {
  addTruckHandler: PropTypes.func.isRequired,
}

export default AddTruckDialog
