import React from "react";
import { makeStyles } from "@material-ui/core/styles";
import List from "@material-ui/core/List";
import ListItem from "@material-ui/core/ListItem";
import ListItemIcon from "@material-ui/core/ListItemIcon";
import ListItemText from "@material-ui/core/ListItemText";
import Checkbox from "@material-ui/core/Checkbox";

const useStyles = makeStyles(theme => ({
  root: {
    width: "100%",
    maxWidth: 360,
    backgroundColor: theme.palette.background.paper
  }
}));

export default function CheckboxList(props) {
  const classes = useStyles();
  const [checked, setChecked] = React.useState([]);

  for (let i = 0; i < props.likes.size; i++) {
    setChecked(checked.push(props.liked[i].charAt(0) + props.liked[i].slice[1].toLowerCase()));
  }

  console.log("props liked values")
  console.log(props.liked)

  const handleToggle = value => () => {
    if (!props.disabled) {
      const currentIndex = checked.indexOf(value.toUpperCase());
      const newChecked = [...checked];

      console.log("before adding");
      console.log(newChecked);

      if (currentIndex === -1) {
        newChecked.push(value.toUpperCase());
      } else {
        newChecked.splice(currentIndex, 1);
      }

      console.log("after adding");
      console.log(newChecked);

      setChecked(newChecked);
      props.onChange(newChecked);
    }
  };

  console.log(checked);

  return (
    <List className={classes.root}>
      {props.foodList.map(value => {
        const labelId = `checkbox-list-label-${value}`;

        return (
          <ListItem
            key={value}
            role={undefined}
            dense
            button
            onClick={handleToggle(value)}
          >
            <ListItemIcon>
              <Checkbox
                edge="start"
                checked={checked.indexOf(value.toUpperCase()) !== -1}
                tabIndex={-1}
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
