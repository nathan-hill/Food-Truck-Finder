import React from 'react'
import Rating from '@material-ui/lab/Rating';
import Typography from '@material-ui/core/Typography';
import Box from '@material-ui/core/Box';
import axios from "axios";
import {connect} from "react-redux";
import * as Request from './../helpers/backendRequests'

var constants = require("./../helpers/constants");

async function getInitialSubValue(props,truck) {
    let userid = props.auth.user.sub;

    let subscriptionsData = await Request.getSubscriptionsByUserID(userid);
    console.log("SUBS DATA!");
    console.log(subscriptionsData);
    console.log(truck);

        for(let subscription in subscriptionsData) {
            if(subscription.uid === props.auth.user.sub && subscription.truckid === truck.id) {
                console.log("TRUCK FOUND!");
                return  true;
            } else {
                console.log("SUBSCRIPTION: ");
                console.log(subscription);
            }
        }

    return false;
}

function FormComponent(props) {
    //const [truck, setTruck] = React.useState();
    const [textValue, setTextValue] = React.useState("");
    const [starValue, setStarValue] = React.useState(1);
    let truck = JSON.parse(localStorage.getItem("clickedTruck"));

    let initSub = null;
    getInitialSubValue(props,truck).then(result => {
       initSub = result;
    });

    const [subscribeValue, setSubscribeValue] = React.useState(initSub);


    const handleChange = (event) => {
        setStarValue(event.target.value);
        
    };

    const handleTextChange = (event) => {
        alert(event.target.value);
        setTextValue(event.target.value);
    }

    async function handleClick()  {
        if(subscribeValue) {
            //unsubscribe
            let userid = props.auth.user.sub;

            let subscriptionsData = await Request.getSubscriptionsByUserID(userid);

            if(subscriptionsData) {
                for(let subscription in subscriptionsData) {
                    if(subscription.uid === props.auth.user.sub && subscription.truckid === truck.id) {
                        Request.unsubscribe(subscription.id).then(result => {
                            setSubscribeValue(false);
                        }).catch(error => {

                        });

                        break;
                    }
                }
            }
        } else {
            //subscribe
            let data = {
                uid: props.auth.user.sub,
                truckId: truck.id
            };

            Request.addSubscription(data).then(response => {
                setSubscribeValue(true);
            });
        }
    }

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
                        {!subscribeValue ? 'Subscribe To This Truck' : 'Subscribed'}
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
