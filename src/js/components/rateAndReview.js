import React from 'react'
import Rating from '@material-ui/lab/Rating';
import Typography from '@material-ui/core/Typography';
import Box from '@material-ui/core/Box';
import axios from "axios";
import {connect} from "react-redux";
import * as Request from './../helpers/backendRequests'

var constants = require("./../helpers/constants");


function FormComponent() {
    const [truck, setTruck] = React.useState();
    const [textValue, setTextValue] = React.useState('Write a Review');
    const [starValue, setStarValue] = React.useState(1);
    const [subscribeValue, setSubscribeValue] = React.useState(true);
    
    //mark get the truckID somehow

    React.useEffect(() => {
        //Request.findByTruckID().then((x) => {setTruck(x)}); // <-- this is an async function to an axios request
    },[]);
    

    const handleChange = (event) => {
        setStarValue(event.target.value);
        setTextValue(event.target.value);
    };
    const handleClick = () => {
        setSubscribeValue(!subscribeValue);
    };

    const handleSubmit = (event) => {
        
        event.preventDefault();
        
        console.log("Submit Review");

        //load data
        let data = {
            // TODO: truckid:
            userID: props.auth.user.sub,
            description: textValue,
            rating: starValue
        };
        console.log("Printing the body of form update");
        //console.log(data);
        axios.put(constants.backend_url + "review/add", data).then(res => {
             console.log(res);
        });
        
    };
    
    
    

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
                <form  style={{ width: "50%"}}>
                    <label>
                        <textarea value={textValue} onChange={(event, newValue) => {
                    setTextValue(newValue);
                    
                }}
                style={{ width: "300px", height: "200px"}}/>
                    </label>
                </form>
                <br/>
                <form>
                    <button onClick={handleClick}>
                        {subscribeValue ? 'Subscribe To This Truck' : 'Subscribed'}
                    </button>
                </form>
                <br/>
                <input type="submit" value="Submit" onSubmit={handleSubmit}/>
            </Box>
            
        </div>
        
        
    );
}

const mapStateToProps = state => ({
    auth: state.auth,
});

export default connect(mapStateToProps, null)(FormComponent);
