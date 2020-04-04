import React from "react";
import LocalShippingIcon from "@material-ui/icons/LocalShipping";
import { Typography } from "@material-ui/core";
import Tooltip from '@material-ui/core/Tooltip'

export default function MapIcon(props) {
  return (
    <div>
      <Tooltip title={<React.Fragment>
        <Typography>{props.truckData.name}</Typography>
      </React.Fragment>}>
        <LocalShippingIcon {...props} />
      </Tooltip>
    </div>
  );
}
