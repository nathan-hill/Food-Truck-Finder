import React from "react";
import LocalShippingIcon from "@material-ui/icons/LocalShipping";
import { Typography } from "@material-ui/core";
import Tooltip from '@material-ui/core/Tooltip'

export default function MapIcon(props) {
  return (
    <div>
      <Tooltip title={<React.Fragment>
        <Typography align={"center"}>{props.truckData.name}</Typography>
        <Typography variant="caption" align={"center"}>{props.truckData.type.toLowerCase().replace(/^\w/, c => c.toUpperCase())}</Typography>
        <br/>
        <Typography variant="caption" align={"center"}>{props.truckData.description.toLowerCase().replace(/^\w/, c => c.toUpperCase())}</Typography>
      </React.Fragment>}>
        <LocalShippingIcon {...props} />
      </Tooltip>
    </div>
  );
}
