import React from 'react'
import Rating from '@material-ui/lab/Rating';
import Typography from '@material-ui/core/Typography';
import Box from '@material-ui/core/Box';
import axios from "axios";
import {connect} from "react-redux";
import * as Request from './../helpers/backendRequests'

var constants = require("./../helpers/constants");


function FormComponent(props) {
    //const [truck, setTruck] = React.useState();
    const [textValue, setTextValue] = React.useState("");
    const [starValue, setStarValue] = React.useState(1);
    const [subscribeValue, setSubscribeValue] = React.useState(true);

    let truck = JSON.parse(localStorage.getItem("clickedTruck"));
    

    const handleChange = (event) => {
        setStarValue(event.target.value);
        
    };

    const handleTextChange = (event) => {
        alert(event.target.value);
        setTextValue(event.target.value);
    }

    const handleClick = () => {
        setSubscribeValue(!subscribeValue);
    };

    const handleSubmit = () => {
        console.log("Submit Review");
        console.log(truck);


        //load data
        let data = {
            truckid: truck.id,
            userID: props.auth.user.sub,
            description: textValue,
            rating: starValue
        };
        console.log("Printing the body of form update");
        console.log(data);
        alert(textValue);
        axios.post(constants.backend_url + "review/add", data).then(res => {
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
                        <textarea value={textValue} onChange={event => setTextValue(event.target.value)}
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
                <form>
                    <button onClick={handleSubmit}>
                        Submit
                    </button>
                </form>

            </Box>
            
        </div>
        
        
    );
}

const mapStateToProps = state => ({
    auth: state.auth,
});

export default connect(mapStateToProps, null)(FormComponent);
