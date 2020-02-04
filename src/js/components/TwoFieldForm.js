import React, { Component } from "react";
import axios from "axios";

export const TwoFieldForm = props => {
  return (
    <div>
      <form name="addUser" onSubmit={props.action}>
        {props.fieldOne} <br />
        <input type="text" name="name"></input>
        <br />
        {props.fieldTwo} <br />
        <input type="text" name="email"></input>
        <input type="submit" value={props.buttonLabel}></input>
      </form>
    </div>
  );
};

export default TwoFieldForm;
