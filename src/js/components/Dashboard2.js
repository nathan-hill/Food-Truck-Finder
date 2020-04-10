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
import ListItem from "@material-ui/core/ListItem";
import ListItemIcon from "@material-ui/core/ListItemIcon";
import ListItemText from "@material-ui/core/ListItemText";
import InboxIcon from "@material-ui/icons/MoveToInbox";
import MailIcon from "@material-ui/icons/Mail";
import SimpleMap from "./SimpleMap";
import DrawerDecider from "./DrawerDecider";
import {
  GuestListItems,
  CustomerListItems,
  OwnerListItems,
  secondaryListItems,
} from "./listItems";
import { connect } from "react-redux";
import { logout } from "../actions/login";
import { withRouter } from "react-router";
import PropTypes from "prop-types";

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

function Dashboard2() {
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
      ? "Guest"
      : localStorage.getItem("role").toUpperCase() +
          localStorage.getItem("role").slice(1)
  );

  console.log("Current state is " + localStorage.getItem("role"));

  const [trucks, setTrucks] = React.useState([]);

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
    console.log(component);
    setComponentDrawerRender(component);
    handleOpenComponentDrawer(true);
  };

  const onTruckClick = () => {
    console.log("clicked");
  };

  const [mainList, setMainList] = React.useState((role) => {
    if (role === "owner") {
      return OwnerListItems;
    } else if (role === "customer") {
      return CustomerListItems;
    } else {
      return GuestListItems(handleSelectionDrawerClick);
    }
  });

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
          <Typography variant="h6" noWrap>
            Meals With Wheels : {role}
          </Typography>
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
        transitionDuration={"1000"}
        ModalProps={{
          onBackdropClick: () => {
            setOpenComponent(false);
          },
        }}
        // className={clsx(classes.componentDrawer, {
        //   [classes.drawerOpen]: openComponent === true,
        //   [classes.drawerClose]: openComponent !== true,
        // })}
        // classes={{
        //   paper: clsx({
        //     [classes.drawerOpen]: openComponent === true,
        //     [classes.drawerClose]: openComponent !== true,
        //   }),
        // }}
      >
        {componentDrawerRender}
        {/* <DrawerDecider state={componentDrawerRender} /> */}
      </Drawer>
      {/* <SimpleMap trucks={trucks} onTruckClick={onTruckClick} /> */}
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

export default connect(mapStateToProps, { logout })(withRouter(Dashboard2));
