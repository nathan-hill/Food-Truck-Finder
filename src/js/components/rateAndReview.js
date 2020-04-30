import React from 'react'
import Rating from '@material-ui/lab/Rating';
import Typography from '@material-ui/core/Typography';
import Box from '@material-ui/core/Box';
import {connect} from "react-redux";
import * as Request from './../helpers/backendRequests'

async function getInitialSubValue(props,truck) {
    let userid = props.auth.user.id;

    let subscriptionsData = await Request.getSubscriptionsByUserID(userid);
    console.log("SUBS DATA!");
    console.log(subscriptionsData);
    console.log(truck);

        for(let subscription of subscriptionsData) {
            if(subscription.uid === props.auth.user.id && subscription.truckid === truck.id) {
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
       setSubscribeValue(initSub);
    });

    const [subscribeValue, setSubscribeValue] = React.useState(initSub);

    let isLoggedIn = props.auth.user.id;
    if(isLoggedIn) {
        console.log("LOGGED IN!!!!!!");
    }

    /*
    const handleChange = (event) => {
        setStarValue(event.target.value);
    };

    const handleTextChange = (event) => {
        setTextValue(event.target.value);
    }
     */


    async function handleClick(e)  {
        e.preventDefault();

        if(subscribeValue) {
            //unsubscribe
            let userid = props.auth.user.id;

            let subscriptionsData = await Request.getSubscriptionsByUserID(userid);

            console.log("attempting unsubscribe");

            if(subscriptionsData) {
                console.log("iterating through subscriptions");

                for(let subscription of subscriptionsData) {
                    console.log(subscription);
                    if(subscription.uid === props.auth.user.id && subscription.truckid === truck.id) {
                        console.log("sending unsubscribe request!");
                        console.log(subscription);

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
                uid: props.auth.user.id,
                truckId: truck.id
            };

            console.log("Sending a subscribe request:");
            console.log(data);

            Request.addSubscription(props.auth.user.id, truck.id).then(response => {
                setSubscribeValue(true);
            });
        }
    }

    const handleSubmit = (e) => {
        e.preventDefault();

        console.log("Submit Review");
        console.log(truck);
        console.log(props);

        Request.addReview(props.auth.user.id,starValue,textValue,truck.id,truck.name).then(res => {
            console.log(res);
            props.callback();
        })

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
