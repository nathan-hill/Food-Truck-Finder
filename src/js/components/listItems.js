import React from "react";
import ListItem from "@material-ui/core/ListItem";
import ListItemIcon from "@material-ui/core/ListItemIcon";
import ListItemText from "@material-ui/core/ListItemText";
import BarChartIcon from "@material-ui/icons/BarChart";
import UserSettings from "./UserSettings";
import CustomerTable from "./ReviewsByCustomer";
import SearchIcon from "@material-ui/icons/Search";
import GroupIcon from '@material-ui/icons/Group';
import SettingsIcon from "@material-ui/icons/Settings";
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
          console.log("Looking for search component guest");
        }}
      >
        <ListItemIcon>
          <SearchIcon />
        </ListItemIcon>
        <ListItemText primary="Search" />
      </ListItem>
      <ListItem
        button
        onClick={() => {
          return setDrawerComponent(<CustomerTable />);
        }}
      >
        <ListItemIcon>
          <GroupIcon />
        </ListItemIcon>
        <ListItemText primary="Customers" />
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
          console.log("Looking for search component customer");
        }}
      >
        <ListItemIcon>
          <SearchIcon />
        </ListItemIcon>
        <ListItemText primary="Search" />
      </ListItem>
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
          console.log("looking for review component");
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
          return setDrawerComponent(<CustomerTable />);
        }}
      >
        <ListItemIcon>
          <GroupIcon />
        </ListItemIcon>
        <ListItemText primary="Customers" />
      </ListItem>
    </div>
  );
};

export const OwnerListItems = (setDrawerComponent) => (
  <div>
    <ListItem
      button
      onClick={() => {
        console.log("Looking for search component customer");
      }}
    >
      <ListItemIcon>
        <SearchIcon />
      </ListItemIcon>
      <ListItemText primary="Search" />
    </ListItem>
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
    <ListItem button>
      <ListItemIcon>
        <BarChartIcon />
      </ListItemIcon>
      <ListItemText primary="View Reviews" />
    </ListItem>
    <ListItem
        button
        onClick={() => {
          return setDrawerComponent(<CustomerTable />);
        }}
      >
        <ListItemIcon>
          <GroupIcon />
        </ListItemIcon>
        <ListItemText primary="Customers" />
      </ListItem>
  </div>
);