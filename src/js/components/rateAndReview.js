import React from 'react'
import Rating from '@material-ui/lab/Rating';
import Typography from '@material-ui/core/Typography';
import Box from '@material-ui/core/Box';
import { makeStyles } from '@material-ui/core/styles';
import TextField from '@material-ui/core/TextField';

const useStyles = makeStyles((theme) => ({
    root: {
      '& > *': {
        margin: theme.spacing(1),
        width: '25ch',
      },
    },
  }));

export default function FormComponent() {
    const classes = useStyles();
    const [value, setValue] = React.useState('Write a Review');

    const handleChange = (event) => {
        setValue(event.target.value);
    };

    return (
        <div>
            <Box component="fieldset" mb={3} borderColor="transparent">
                <Typography component="legend">Review This Food Truck</Typography>
                <Rating name="pristine" value={value} onChange={(event, newValue) => {
                    setValue(newValue);
                }} />
                <form className={classes.root} noValidate autoComplete="off">
                <TextField
                    id="outlined-multiline-flexible"
                    label="Review"
                    multiline
                    rowsMax="4"
                    value={value}
                    onChange={handleChange}
                    variant="outlined"
                />
                </form>
            </Box>
        </div>
    );
}
