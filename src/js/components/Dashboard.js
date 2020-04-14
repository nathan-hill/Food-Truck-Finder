import React from "react";
import clsx from "clsx";
import { makeStyles } from "@material-ui/core/styles";
import CssBaseline from "@material-ui/core/CssBaseline";
import Drawer from "@material-ui/core/Drawer";

import AppBar from "@material-ui/core/AppBar";
import Toolbar from "@material-ui/core/Toolbar";
import List from "@material-ui/core/List";
import Typography from "@material-ui/core/Typography";
import Divider from "@material-ui/core/Divider";
import IconButton from "@material-ui/core/IconButton";
import Badge from "@material-ui/core/Badge";

import ReactSearchBox from "react-search-box";

import MenuIcon from "@material-ui/icons/Menu";
import ChevronLeftIcon from "@material-ui/icons/ChevronLeft";
import NotificationsIcon from "@material-ui/icons/Notifications";
import {
  GuestListItems,
  CustomerListItems,
  OwnerListItems,
} from "./listItems";
import SimpleMap from "./SimpleMap";
 
import Button from "@material-ui/core/Button";
import { connect } from "react-redux";
import { logout } from "../actions/login";
import { withRouter } from "react-router";
import PropTypes from "prop-types";
import * as Request from './../helpers/backendRequests'
import {forEach} from "react-bootstrap/cjs/ElementChildren";

// change size of expanded sidebar
const drawerWidth = 600;


const useStyles = makeStyles(theme => ({
  root: {
    display: "flex"
  },
  toolbar: {
    paddingRight: 24 // keep right padding when drawer closed
  },
  toolbarIcon: {
    display: "flex",
    alignItems: "center",
    justifyContent: "flex-end",
    padding: "0 8px",
    ...theme.mixins.toolbar
  },
  appBar: {
    zIndex: theme.zIndex.drawer + 1,

    transition: theme.transitions.create(["width", "margin"], {
      easing: theme.transitions.easing.sharp,
      duration: theme.transitions.duration.leavingScreen
    })
  },
  appBarShift: {
    marginLeft: drawerWidth,
    width: `calc(100% - ${drawerWidth}px)`,
    transition: theme.transitions.create(["width", "margin"], {
      easing: theme.transitions.easing.sharp,
      duration: theme.transitions.duration.enteringScreen
    })
  },
  menuButton: {
    marginRight: 36
  },
  menuButtonHidden: {
    display: "none"
  },
  title: {
    flexGrow: 1
  },
  drawerPaper: {
    position: "relative",
    whiteSpace: "nowrap",
    width: drawerWidth,
    transition: theme.transitions.create("width", {
      easing: theme.transitions.easing.sharp,
      duration: theme.transitions.duration.enteringScreen
    })
  },
  drawerPaperClose: {
    overflowX: "hidden",
    transition: theme.transitions.create("width", {
      easing: theme.transitions.easing.sharp,
      duration: theme.transitions.duration.leavingScreen
    }),
    width: theme.spacing(7),
    [theme.breakpoints.up("sm")]: {
      // change size of collapsed side bar drawer
      width: theme.spacing(40)
    }
  },
  appBarSpacer: theme.mixins.toolbar,
  content: {
    flexGrow: 1,
    height: "100vh",
    overflow: "auto"
  },
  container: {
    paddingTop: theme.spacing(4),
    paddingBottom: theme.spacing(4)
  },
  paper: {
    padding: theme.spacing(2),
    display: "flex",
    overflow: "auto",
    flexDirection: "column"
  },
  fixedHeight: {
    height: 240
  }
}));

/*
function onTruckClick(truck){
  console.log(truck);
}
*/

function Dashboard(props) {
  const classes = useStyles();
  const [open, setOpen] = React.useState(false);
  const [trucks, setTrucks] = React.useState([]);
  const [role] = React.useState(
    typeof localStorage.getItem("role") === undefined || localStorage.getItem("role") === "undefined" || localStorage.getItem("role") === "null"
      ? "Guest"
      : localStorage.getItem("role")
  );

  React.useEffect(() => {
    Request.getTrucksForToday().then((x) => {
      let truck;
      for(truck of x) {
        truck.key = truck.name;
        truck.value = truck.name;
      }

      setTrucks(x)
    }); // <-- this is an async function to an axios request
},[]);

  const onTruckClick = (truck) => {
    if(true) { // TODO: check if logged in
      localStorage.setItem("clickedTruck",JSON.stringify(truck));
      props.history.push("/FoodTruckDetails")
    }
  };

  const handleDrawerOpen = () => {
    setOpen(true);
  };
  const handleDrawerClose = () => {
    setOpen(false);
  };

  let mainList;

  if (role === "owner") {
    mainList = OwnerListItems;
  } else if (role === "customer") {
    mainList = CustomerListItems;
  } else {
    mainList = GuestListItems;
  }

  let numNotifications = 0;
  let logOutButton;
  let logInButton;
  if (props.auth.isAuthenticated) {
    //function call to determine number of unread notifications
    numNotifications = 0
        logOutButton = (
      <Button
        type="submit"
        variant="contained"
        color="secondary"
        className={classes.submit}
      >
        LOG OUT
      </Button>
    );
  } else {
    logInButton = (
      <Button
        type="submit"
        variant="contained"
        color="secondary"
        className={classes.submit}
      >
        LOG IN
      </Button>
    );
  }

  return (
    <div className={classes.root}>
      <CssBaseline />
      <AppBar className={clsx(classes.appBar, open && classes.appBarShift)}>
        <Toolbar className={classes.toolbar}>
          <IconButton
            edge="start"
            color="inherit"
            aria-label="open drawer"
            onClick={handleDrawerOpen}
            className={clsx(
              classes.menuButton,
              open && classes.menuButtonHidden
            )}
          >
            <MenuIcon />
          </IconButton>
          <Typography
            component="h1"
            variant="h6"
            color="inherit"
            noWrap
            className={classes.title}
          >
            Wheels With Meals: {role}
          </Typography>

          <ReactSearchBox
            placeholder="Search"
            data={trucks}
            onSelect={selection => {
              onTruckClick(selection);
            }}
            className="asdf"
          />
       
          <form
            className={classes.form}
            noValidate
            onSubmit={() => props.history.push("/loginpage")}
          >
            {logInButton}
          </form>

          <form
            className={classes.form}
            noValidate
            onSubmit={() => props.logout()}
          >
            {logOutButton}
          </form>
          
          <IconButton color="inherit" href = "#/Notifications">
            <Badge badgeContent={numNotifications} color="secondary">
              <NotificationsIcon />
            </Badge>
          </IconButton>
        </Toolbar>
      </AppBar>
      <Drawer
        variant="permanent"
        classes={{
          paper: clsx(classes.drawerPaper, !open && classes.drawerPaperClose)
        }}
        open={open}
      >
        <div className={classes.toolbarIcon}>
          <IconButton onClick={handleDrawerClose}>
            <ChevronLeftIcon />
          </IconButton>
        </div>
        <Divider />
        <List>{mainList}</List>
      </Drawer>
      <SimpleMap trucks={trucks} onTruckClick={onTruckClick}/>
      {/* <InteractiveMap/> */}

    </div>
  );
}

Dashboard.propTypes = {
  history: PropTypes.object.isRequired,
  logout: PropTypes.func.isRequired
};

const mapStateToProps = state => ({
  auth: state.auth
});

export default connect(mapStateToProps, { logout })(withRouter(Dashboard));
