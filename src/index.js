import React from 'react';
import ReactDOM from 'react-dom';
import App from './js/App';
import {applyMiddleware, compose, createStore} from "redux";
import {Provider} from "react-redux";
import rootReducer from "./js/rootReducer";
import thunk from "redux-thunk";

const store = createStore(
    rootReducer,
    compose(
        applyMiddleware(thunk),
        window.devToolsExtension ? window.devToolsExtension() : f => f
    )
);


ReactDOM.render(<Provider store={store}> <App /> </Provider>, document.getElementById('root'));
