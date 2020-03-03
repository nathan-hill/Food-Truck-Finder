import React from "react";
import ListItem from "@material-ui/core/ListItem";
import ListItemIcon from "@material-ui/core/ListItemIcon";
import ListItemText from "@material-ui/core/ListItemText";
import ListSubheader from "@material-ui/core/ListSubheader";
import DashboardIcon from "@material-ui/icons/Dashboard";
import ShoppingCartIcon from "@material-ui/icons/ShoppingCart";
import PeopleIcon from "@material-ui/icons/People";
import BarChartIcon from "@material-ui/icons/BarChart";
import LayersIcon from "@material-ui/icons/Layers";
import AssignmentIcon from "@material-ui/icons/Assignment";
import { Link } from "react-router-dom"

export const GuestListItems = (
  <div>
    <ListItem button>
      <ListItemIcon>
        <DashboardIcon />
      </ListItemIcon>
      <ListItemText primary="Dashboard" />
    </ListItem>
    <ListItem button>
      <ListItemIcon>
        <ShoppingCartIcon />
      </ListItemIcon>
      <ListItemText primary="Food Trucks" />
    </ListItem>
    <ListItem button>
      <ListItemIcon>
        <PeopleIcon />
      </ListItemIcon>
      <ListItemText primary="Subscriptions" />
    </ListItem>
    <ListItem button>
      <ListItemIcon>
        <BarChartIcon />
      </ListItemIcon>
      <ListItemText primary="Ratings/Reviews" />
    </ListItem>
    <ListItem button>
      <ListItemIcon>
        <LayersIcon />
      </ListItemIcon>
      <ListItemText primary="Settings" />
    </ListItem>
  </div>
);

export const CustomerListItems = (
  <div>
    <ListItem button>
      <ListItemIcon>
        <DashboardIcon />
      </ListItemIcon>
      <ListItemText primary="Dashboard" />
    </ListItem>
    <ListItem button>
      <ListItemIcon>
        <ShoppingCartIcon />
      </ListItemIcon>
      <ListItemText primary="Food Trucks" />
    </ListItem>
    <ListItem button>
      <ListItemIcon>
        <PeopleIcon />
      </ListItemIcon>
      <ListItemText primary="Subscriptions" />
    </ListItem>
    <ListItem button>
      <ListItemIcon>
        <BarChartIcon />
      </ListItemIcon>
      <ListItemText primary="Ratings/Reviews" />
    </ListItem>
    <ListItem button>
      <ListItemIcon>
        <LayersIcon />
      </ListItemIcon>
      <ListItemText primary="Customer Settings" />
    </ListItem>
  </div>
);

export const OwnerListItems = (
  <div>
    <ListItem button>
      <ListItemIcon>
        <DashboardIcon />
      </ListItemIcon>
      <ListItemText primary="Dashboard" />
    </ListItem>
    <ListItem button>
      <ListItemIcon>
        <ShoppingCartIcon />
      </ListItemIcon>
      <ListItemText primary="My Food Trucks" />
    </ListItem>
    <ListItem button>
      <ListItemIcon>
        <PeopleIcon />
      </ListItemIcon>
      <ListItemText primary="Send Notifications" />
    </ListItem>
    <ListItem button>
      <ListItemIcon>
        <BarChartIcon />
      </ListItemIcon>
      <ListItemText primary="View Ratings/Reviews" />
    </ListItem>
    <ListItem button>
      <ListItemIcon>
        <LayersIcon />
      </ListItemIcon>
      <ListItemText primary="Owner Settings" />
    </ListItem>
  </div>
);

export const secondaryListItems = (
  <div>
    <ListSubheader inset>Raw Components</ListSubheader>
    <ListItem button to="/" component={Link}>>
      <ListItemIcon> 
        <AssignmentIcon />
      </ListItemIcon>
      <ListItemText primary="/" />
    </ListItem>
    <ListItem button to="/Request" component={Link}>>
      <ListItemIcon> 
        <AssignmentIcon />
      </ListItemIcon>
      <ListItemText primary="/Request" />
    </ListItem>
    <ListItem button to="/loginpage" component={Link}>>
      <ListItemIcon> 
        <AssignmentIcon />
      </ListItemIcon>
      <ListItemText primary="/loginpage" />
    </ListItem>
    <ListItem button to="/TestRouting" component={Link}>>
      <ListItemIcon> 
        <AssignmentIcon />
      </ListItemIcon>
      <ListItemText primary="/TestRouting" />
    </ListItem>
    <ListItem button to="/Table" component={Link}>>
      <ListItemIcon> 
        <AssignmentIcon />
      </ListItemIcon>
      <ListItemText primary="/Table" />
    </ListItem>
  </div>
);
