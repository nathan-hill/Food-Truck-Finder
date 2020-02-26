import React from "react";

export const TwoFieldForm = props => {
  return (
    <div>
      <form name="addUser" onSubmit={props.action}>
        {props.fieldOne} <br />
        <input type="text" name="name"></input>
        <br />
        {props.fieldTwo} <br />
        <input type="text" name="schedule"></input>
        <br/>
        <input type="submit" value={props.buttonLabel}></input>
      </form>
    </div>
  );
};

export default TwoFieldForm;
