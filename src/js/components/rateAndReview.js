import React from 'react'
import Rating from '@material-ui/lab/Rating';
import Typography from '@material-ui/core/Typography';
import Box from '@material-ui/core/Box';
import { makeStyles } from '@material-ui/core/styles';
import ReviewForm from './ReviewForm'
import SubscribeButton from './SubscribeButton';
import axios from "axios";
import {connect} from "react-redux";
import * as Request from './../helpers/backendRequests'

var constants = require("./../helpers/constants");



const useStyles = makeStyles((theme) => ({
    root: {
      '& > *': {
        margin: theme.spacing(1),
        width: '25ch',
      },
    },
  }));

function FormComponent() {
    const classes = useStyles();
    const [textValue, setTextValue] = React.useState('Write a Review');
    const [starValue, setStarValue] = React.useState(1);

    const handleChange = (event) => {
        setStarValue(event.target.value);
    };
    
    // get truck from Database
    const [role] = React.useState(
        // typeof localStorage.getItem("role") === undefined || localStorage.getItem("role") === "undefined" || localStorage.getItem("role") === "null"
        //   ? "Guest"
        //   : localStorage.getItem("role")
    );

    return (
        <div style={{
            display: "flex",
            justifyContent: "center",
            alignItems: "center"
        }}>
            <Box component="fieldset" mb={3} borderColor="transparent">
                <Typography component="legend">Review This Food Truck</Typography>
                <Rating name="pristine" value={starValue} onChange={(event, newValue) => {
                    setStarValue(newValue);
                }} />
                <ReviewForm/>
                <br/>
                <SubscribeButton/>
            </Box>
            
        </div>
        
        
    );
}

const mapStateToProps = state => ({
    auth: state.auth,
});

export default connect(mapStateToProps, null)(FormComponent);
