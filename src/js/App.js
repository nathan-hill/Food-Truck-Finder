import React, { Component } from "react";
import { HashRouter, Route } from "react-router-dom";

import * as Pages from "./pages/pages";

export default class App extends Component {
  render() {
    return (
      <div>
        <HashRouter>
          <div>
            <Route exact path="/" component={Pages.Home} />
            <Route exact path="/Request" component={Pages.DatabaseListing} />
            <Route exact path="/loginpage" component={Pages.Login} />
          </div>
        </HashRouter>
      </div>
    );
  }
}
