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
            <Route exact path="/page1" component={Pages.Page1} />
            <Route exact path="/page2" component={Pages.Page2} />
			<Route exact path="/Request" component={Pages.DatabaseListing} />
          </div>
        </HashRouter>
      </div>
    );
  }
}
