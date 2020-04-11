import React, { Component } from "react";
import { HashRouter, Route } from "react-router-dom";
import { createMuiTheme, ThemeProvider } from '@material-ui/core/styles';
import * as Pages from "./pages/pages";
import { amber, green } from "@material-ui/core/colors";

const baylorTheme = createMuiTheme({
  palette: {
    primary: green,
    secondary: amber,
  },
});

export default class App extends Component {
  render() {
    return (
      <ThemeProvider theme={baylorTheme}>
        <div>
          <HashRouter>
            <div>
              <Route exact path="/" component={Pages.Home} />
              <Route exact path="/create_account" component={Pages.CreateAccount} />
              <Route exact path="/Request" component={Pages.DatabaseListing} />
              <Route exact path="/loginpage" component={Pages.Login} />
              <Route exact path="/Notifications" component={Pages.Notifications} />
              <Route exact path="/SendNotifications" component={Pages.SendNotification} />
              <Route exact path="/Profile" component={Pages.UserProfile} />
              <Route exact path="/TestRouting" component={Pages.TestRouting} />
              <Route exact path="/FoodTruckTable" component={Pages.Table} />
              <Route exact path="/FoodTruckDetails" component={Pages.TruckDetails} />
              <Route exact path="/UserProfile" component={Pages.UserProfile} />
              {/* <Route exact path="/OwnerProfile" component={Pages.OwnerProfile} /> */}
              <Route exact path="/FoodTruckPreference" component={Pages.CustPreferences} />
            </div>
          </HashRouter>
        </div>
        
        </ThemeProvider>
    );
  }
}
