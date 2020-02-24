import React from "react";

export const TwoFieldForm = props => {
  return (
    <div>
      <form name="addUser" onSubmit={props.action}>
        {props.fieldOne} <br />
        <input type="text" name="email"></input>
        <br />
        {props.fieldTwo} <br />
        <input type="text" name="password"></input>
        <br/>
        <input type="submit" value={props.buttonLabel}></input>
      </form>
    </div>
  );
};

export default TwoFieldForm;
