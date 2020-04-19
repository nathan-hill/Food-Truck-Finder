import React from "react";
import { makeStyles } from "@material-ui/core/styles";
import List from "@material-ui/core/List";
import ListItem from "@material-ui/core/ListItem";
import ListItemIcon from "@material-ui/core/ListItemIcon";
import ListItemText from "@material-ui/core/ListItemText";
import Checkbox from "@material-ui/core/Checkbox";

const useStyles = makeStyles((theme) => ({
  root: {
    // width: "100%",
    // maxWidth: 360,
    // backgroundColor: theme.palette.background.paper
  },
}));

function findVal(array, val) {
  console.log("looking for " + val + " in " + array)
  for (let i = 0; i < array.length; i++) {
    if (val === array[i]) {
      console.log("found " + i)
      return i;
    }
  }
  console.log("not found")
  return -1;
}

export default function CheckboxList(props) {
  const classes = useStyles();
  const [checked, setChecked] = React.useState(props.checked);

  console.log(props.checked)

  const handleToggle = (value) => {
    console.log("toggling " + value);
    if (!props.disabled) {
      const currentIndex = checked.indexOf(value);
      const newChecked = [...checked];

      if (currentIndex === -1) {
        newChecked.push(value);
      } else {
        newChecked.splice(currentIndex, 1);
      }

      setChecked(newChecked);
      props.onChange(newChecked);
    }
  };

  console.log("## " + props.checked)

  return (
    <List className={classes.root}>
      {props.options.map((value) => {
        const labelId = `checkbox-list-label-${value}`;

        return (
          <ListItem
            key={value}
            role={undefined}
            dense
            button
            onClick={() => {
              handleToggle(value);
            }}
          >
            <ListItemIcon>
              <Checkbox
                edge="start"
                checked={findVal(checked, value) !== -1}
                // tabIndex={-1}
                disableRipple
                inputProps={{ "aria-labelledby": labelId }}
                disabled={props.disabled}
              />
            </ListItemIcon>
            <ListItemText id={labelId} primary={value} />
          </ListItem>
        );
      })}
    </List>
  );
}
