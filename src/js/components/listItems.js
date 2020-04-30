import React from "react";
import ListItem from "@material-ui/core/ListItem";
import ListItemIcon from "@material-ui/core/ListItemIcon";
import ListItemText from "@material-ui/core/ListItemText";
import BarChartIcon from "@material-ui/icons/BarChart";
import UserSettings from "./UserSettings";
import ReviewTable from "./ReviewsDisplay";
import ReviewByCustomer from "./ReviewByCustomer";
import ReviewsByOwner from "./ReviewsByOwner";
import SearchIcon from "@material-ui/icons/Search";
import SettingsIcon from "@material-ui/icons/Settings";
import StarIcon from '@material-ui/icons/Star';
import RateReviewIcon from "@material-ui/icons/RateReview";
import ThumbUpIcon from "@material-ui/icons/ThumbUp";
import FoodTruckPreferences from "./FoodTruckPreferences";
import LocalShippongIcon from '@material-ui/icons/LocalShipping'
import SendIcon from '@material-ui/icons/Send';
import SendNotifications from './SendNotifications'
import FinalTruckTable from './finalTruckTable'

export const GuestListItems = (setDrawerComponent) => {
  return (
    <div>
      <ListItem
        button
        onClick={() => {
          return setDrawerComponent(<ReviewTable />);
        }}
      >
        <ListItemIcon>
          <StarIcon />
        </ListItemIcon>
        <ListItemText primary="Truck Reviews" />
      </ListItem>
    </div>
  );
};

export const CustomerListItems = (setDrawerComponent) => {
  return (
    <div>
      <ListItem
        button
        onClick={() => {
          return setDrawerComponent(<UserSettings />);
        }}
      >
        <ListItemIcon>
          <SettingsIcon />
        </ListItemIcon>
        <ListItemText primary="User Settings" />
      </ListItem>
      <ListItem
        button
        onClick={() => {
          return setDrawerComponent(<ReviewByCustomer />);
        }}
      >
        <ListItemIcon>
          <RateReviewIcon />
        </ListItemIcon>
        <ListItemText primary="My Reviews" />
      </ListItem>
      <ListItem
        button
        onClick={() => {
          return setDrawerComponent(<FoodTruckPreferences />);
        }}
      >
        <ListItemIcon>
          <ThumbUpIcon />
        </ListItemIcon>
        <ListItemText primary="Suggested" />
      </ListItem>
      <ListItem
        button
        onClick={() => {
          return setDrawerComponent(<ReviewTable />);
        }}
      >
        <ListItemIcon>
          <StarIcon />
        </ListItemIcon>
        <ListItemText primary="All Reviews" />
      </ListItem>
    </div>
  );
};

export const OwnerListItems = (setDrawerComponent) => (
  <div>
    <ListItem button onClick={() => {return setDrawerComponent(<FinalTruckTable/>)}}>
      <ListItemIcon>
        <LocalShippongIcon/>
      </ListItemIcon>
      <ListItemText primary="My Food Trucks" />
    </ListItem>
    <ListItem button onClick={() => {return setDrawerComponent(<SendNotifications/>)}}>
      <ListItemIcon>
        <SendIcon/>
      </ListItemIcon>
      <ListItemText primary="Send Notifications" />
    </ListItem>
    <ListItem 
      button
      onClick={() => {
        return setDrawerComponent(<ReviewsByOwner />);
      }}>
      <ListItemIcon>
        <BarChartIcon />
      </ListItemIcon>
      <ListItemText primary="My Reviews" />
    </ListItem>
    <ListItem
        button
        onClick={() => {
          return setDrawerComponent(<ReviewTable />);
        }}
      >
        <ListItemIcon>
          <StarIcon />
        </ListItemIcon>
        <ListItemText primary="All Reviews" />
      </ListItem>
  </div>
);