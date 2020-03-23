import React from 'react';
import { makeStyles, withStyles } from '@material-ui/core/styles';
import InputBase from '@material-ui/core/InputBase';
import Button from '@material-ui/core/Button';
import Dialog from '@material-ui/core/Dialog';
import DialogActions from '@material-ui/core/DialogActions';
import DialogContent from '@material-ui/core/DialogContent';
import DialogTitle from '@material-ui/core/DialogTitle';
import InputLabel from '@material-ui/core/InputLabel';
import Input from '@material-ui/core/Input';
import MenuItem from '@material-ui/core/MenuItem';
import FormControl from '@material-ui/core/FormControl';
import Select from '@material-ui/core/Select';

const BootstrapInput = withStyles(theme => ({
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

const useStyles = makeStyles(theme => ({
  container: {
    display: 'flex',
    flexWrap: 'wrap',
  },
  formControl: {
    margin: theme.spacing(1),
    minWidth: 120,
  },
  margin: {
    margin: theme.spacing(1),
  },
}));

export default function DialogSelect() {
  const classes = useStyles();
  const [open, setOpen] = React.useState(false);
  const [food, setFood] = React.useState('');
  const [price, setPrice] = React.useState('');

  const handleChange = event => {
    setFood(event.target.value || '');
    setPrice(Number(event.target.value) || '');
  };
  

  const handleClickOpen = () => {
    setOpen(true);
  };

  const handleClose = () => {
    setOpen(false);
  };

  return (
    <div>
      <Button onClick={handleClickOpen}>Open Preferences</Button>
      <Dialog disableBackdropClick disableEscapeKeyDown open={open} onClose={handleClose}>
        <DialogTitle>Fill Your Preferences</DialogTitle>
        <DialogContent>
          <form className={classes.container}>
          <FormControl className={classes.margin}>
            <InputLabel htmlFor="proximity-textbox">Proximity</InputLabel>
            <BootstrapInput id="proximity-textbox" />
          </FormControl>

            <FormControl className={classes.formControl}>
              <InputLabel htmlFor="price-native">Price</InputLabel>
              <Select
                native
                priceValue={price}
                onChange={handleChange}
                input={<Input id="price-native" />}
              >
                <option aria-label="None" priceValue="" />
                <option priceValue={1}>$</option>
                <option priceValue={2}>$$</option>
                <option priceValue={3}>$$$</option>
                <option priceValue={4}>$$$$</option>
              </Select>
            </FormControl>

            <FormControl className={classes.formControl}>
              <InputLabel htmlFor="foodtype-native">Food Type</InputLabel>
              <Select
                native
                foodValue={food}
                onChange={handleChange}
                input={<Input id="foodtype-native" />}
              >
                <option aria-label="None" foodValue="" />
                <option foodValue={"Italian"}>Italian</option>
                <option foodValue={"Mexican"}>Mexican</option>
                <option foodValue={"Greek"}>Greek</option>
              </Select>
            </FormControl>

            
          </form>
        </DialogContent>
        <DialogActions>
          <Button onClick={handleClose} color="primary">
            Cancel
          </Button>
          <Button onClick={handleClose} color="primary">
            Ok
          </Button>
        </DialogActions>
      </Dialog>
    </div>
  );
}