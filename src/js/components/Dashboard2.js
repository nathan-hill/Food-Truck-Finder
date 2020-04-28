import React from "react";
import clsx from "clsx";
import { makeStyles, useTheme } from "@material-ui/core/styles";
import Drawer from "@material-ui/core/Drawer";
import AppBar from "@material-ui/core/AppBar";
import Toolbar from "@material-ui/core/Toolbar";
import List from "@material-ui/core/List";
import CssBaseline from "@material-ui/core/CssBaseline";
import Typography from "@material-ui/core/Typography";
import Divider from "@material-ui/core/Divider";
import IconButton from "@material-ui/core/IconButton";
import MenuIcon from "@material-ui/icons/Menu";
import ChevronLeftIcon from "@material-ui/icons/ChevronLeft";
import ChevronRightIcon from "@material-ui/icons/ChevronRight";
import * as Request from "./../helpers/backendRequests";
import { GuestListItems, CustomerListItems, OwnerListItems } from "./listItems";
import { connect } from "react-redux";
import PropTypes from "prop-types";
import LoginPage from "./LoginPage";
import Button from "@material-ui/core/Button";
import Badge from "@material-ui/core/Badge";
import NotificationsIcon from "@material-ui/icons/Notifications";
import SimpleMap from "./SimpleMap";
import Notifications from "./Notifications";
const selectionDrawerWidth = 240;
const componentDrawerWidth = 500;

const useStyles = makeStyles((theme) => ({
  root: {
    display: "flex",
    overflowY: "hidden",
  },
  appBar: {
    zIndex: theme.zIndex.drawer + 1,
    transition: theme.transitions.create(["width", "margin"], {
      easing: theme.transitions.easing.sharp,
      duration: theme.transitions.duration.leavingScreen,
    }),
  },
  title: {
    flexGrow: 1,
  },
  appBarShift: {
    marginLeft: selectionDrawerWidth,
    width: `calc(100% - ${selectionDrawerWidth}px)`,
    transition: theme.transitions.create(["width", "margin"], {
      easing: theme.transitions.easing.sharp,
      duration: theme.transitions.duration.enteringScreen,
    }),
  },
  menuButton: {
    marginRight: 36,
  },
  hide: {
    display: "none",
  },
  selectionDrawer: {
    width: selectionDrawerWidth,
    flexShrink: 0,
    whiteSpace: "nowrap",
  },
  componentDrawer: {
    width: selectionDrawerWidth,
    flexShrink: 0,
    whiteSpace: "nowrap",
  },
  selectionDrawerOpen: {
    width: selectionDrawerWidth,
    transition: theme.transitions.create("width", {
      easing: theme.transitions.easing.sharp,
      duration: theme.transitions.duration.enteringScreen,
    }),
  },
  selectionDrawerClose: {
    transition: theme.transitions.create("width", {
      easing: theme.transitions.easing.sharp,
      duration: theme.transitions.duration.leavingScreen,
    }),
    overflowX: "hidden",
    width: theme.spacing(7) + 1,
    [theme.breakpoints.up("sm")]: {
      width: theme.spacing(9) + 1,
    },
  },
  componentDrawerOpen: {
    width: componentDrawerWidth,
    transition: theme.transitions.create("width", {
      easing: theme.transitions.easing.sharp,
      duration: theme.transitions.duration.enteringScreen,
    }),
  },
  componentDrawerClose: {
    transition: theme.transitions.create("width", {
      easing: theme.transitions.easing.sharp,
      duration: theme.transitions.duration.leavingScreen,
    }),
    overflowX: "hidden",
    width: theme.spacing(7) + 1,
    [theme.breakpoints.up("sm")]: {
      width: theme.spacing(9) + 1,
    },
  },
  toolbar: {
    display: "flex",
    alignItems: "center",
    justifyContent: "flex-end",
    padding: theme.spacing(0, 1),
    // necessary for content to be below app bar
    ...theme.mixins.toolbar,
  },
  content: {
    flexGrow: 1,
    // display: "flex",
    padding: theme.spacing(2),
  },
}));

function Dashboard2(props) {
  const classes = useStyles();
  const theme = useTheme();

  const [openSelection, setOpenSelection] = React.useState(false);
  const [openComponent, setOpenComponent] = React.useState(false);
  const [componentDrawerRender, setComponentDrawerRender] = React.useState(
    null
  );
  const [role, setRole] = React.useState(
    typeof localStorage.getItem("role") === undefined ||
      localStorage.getItem("role") === "undefined" ||
      localStorage.getItem("role") === null
      ? "guest"
      : localStorage.getItem("role")
  );

  const [trucks, setTrucks] = React.useState([]);

  React.useEffect(() => {
    Request.getTrucksForToday().then((x) => {
      setTrucks(x);
    });
  }, []);

  let numNotifications = 0;
  let logButton;
  if (props.auth.isAuthenticated) {
    //function call to determine number of unread notifications
    numNotifications = 0;
    logButton = (
      <Button
        type="submit"
        variant="contained"
        color="secondary"
        className={classes.submit}
        onClick={() => {
          props.logout();
          setRole("guest");
          setMainList(genList("guest"));
        }}
      >
        LOG OUT
      </Button>
    );
  } else {
    logButton = (
      <Button
        type="submit"
        variant="contained"
        color="secondary"
        className={classes.submit}
        onClick={() => {
          handleSelectionDrawerClick(
            <LoginPage callback={handleLoginCallback} changeDrawer={handleSelectionDrawerClick}/>
          );
        }}
      >
        LOG IN
      </Button>
    );
  }
  const handleLoginCallback = (val) => {
    console.log("start login callback");
    console.log(val);
    if (val !== false) {
      handleCloseComponentDrawer();
      setRole(val.type);
      setMainList(genList(val.type));
      console.log("the current role is " + role + " from " + val.type);
    } else {
      //do nothing
      console.log("SOMETHING HAS GONE WRONG");
    }
    console.log("end login callback");
  };

  const handleOpenSelectionDrawer = () => {
    setOpenSelection(true);
  };

  const handleOpenComponentDrawer = () => {
    setOpenComponent(true);
    setOpenSelection(false);
  };

  const handleCloseSelectionDrawer = () => {
    setOpenSelection(false);
  };

  const handleCloseComponentDrawer = () => {
    setOpenComponent(false);
  };

  const handleSelectionDrawerClick = (component) => {
    // console.log(component);
    setComponentDrawerRender(component);
    handleOpenComponentDrawer(true);
  };

  const onTruckClick = (truck) => {
    console.log(truck);
  };

  const genList = (role) => {
    console.log(role);
    if (role === undefined || role === null || role === "guest") {
      // console.log(role + " = " + "guest")
      return GuestListItems(handleSelectionDrawerClick);
    } else if (role === "customer") {
      // console.log(role + " = " + "customer")
      return CustomerListItems(handleSelectionDrawerClick);
    } else {
      // console.log(role + " = " + "owner")
      return OwnerListItems(handleSelectionDrawerClick);
    }
  };

  const [mainList, setMainList] = React.useState(genList(role));

  return (
    <div className={classes.root}>
      <CssBaseline />
      <AppBar
        position="fixed"
        className={clsx(classes.appBar, {
          [classes.appBarShift]: openSelection,
        })}
      >
        <Toolbar>
          <IconButton
            color="inherit"
            aria-label="open drawer"
            onClick={handleOpenSelectionDrawer}
            edge="start"
            className={clsx(classes.menuButton, {
              [classes.hide]: openSelection,
            })}
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
            Meals With Wheels : {role.charAt(0).toUpperCase() + role.slice(1)}
          </Typography>
          {logButton}
          <IconButton
            color="inherit"
            onClick={() => {
              handleSelectionDrawerClick(<Notifications />);
            }}
          >
            <Badge badgeContent={numNotifications} color="secondary">
              <NotificationsIcon />
            </Badge>
          </IconButton>
        </Toolbar>
      </AppBar>
      <Drawer
        variant="permanent"
        className={clsx(classes.selectionDrawer, {
          [classes.selectionDrawerOpen]: openSelection,
          [classes.selectionDrawerClose]: !openSelection,
        })}
        classes={{
          paper: clsx({
            [classes.selectionDrawerOpen]: openSelection,
            [classes.selectionDrawerClose]: !openSelection,
          }),
        }}
      >
        <div className={classes.toolbar}>
          <IconButton onClick={handleCloseSelectionDrawer}>
            {theme.direction === "rtl" ? (
              <ChevronRightIcon />
            ) : (
              <ChevronLeftIcon />
            )}
          </IconButton>
        </div>
        <Divider />
        <List>{mainList}</List>
      </Drawer>
      <Drawer
        variant="temporary"
        open={openComponent}
        ModalProps={{
          onBackdropClick: () => {
            setOpenComponent(false);
          },
        }}
      >
        {componentDrawerRender}
        {/* <DrawerDecider state={componentDrawerRender} /> */}
      </Drawer>
      <SimpleMap trucks={trucks} onTruckClick={onTruckClick} />
      {/* <InteractiveMap onClick/> */}
    </div>
  );
}

Dashboard2.propTypes = {
  history: PropTypes.object.isRequired,
  logout: PropTypes.func.isRequired,
};

const mapStateToProps = (state) => ({
  auth: state.auth,
});

export default connect(mapStateToProps)(Dashboard2);
