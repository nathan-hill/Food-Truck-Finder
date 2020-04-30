import React, { Component } from "react";
import { createMuiTheme, ThemeProvider } from '@material-ui/core/styles';
import {HashRouter, Route } from "react-router-dom"
import Dashboard2 from './components/Dashboard2'

const baylorTheme = createMuiTheme({
  palette: {
    primary: {
      main: '#1b5e20',
    },
    secondary: {
      main: '#ffc107',
    },
  },
});

export default class App extends Component {
  render() {
    return (
      <ThemeProvider theme={baylorTheme}>
        <div>
          <HashRouter>
              <Route exact path="/" component={Dashboard2} />
          </HashRouter>
        </div>
        
        </ThemeProvider>
    );
  }
}
