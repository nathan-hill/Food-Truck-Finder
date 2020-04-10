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

  let size = props.selected || 0;

  for (let i = 0; i < size.size ; i++) {
    setChecked(checked.push(props.liked[i].charAt(0) + props.liked[i].slice[1].toLowerCase()));
  }


  const handleToggle = value => () => {
    if (!props.disabled) {
      const currentIndex = checked.indexOf(value.toUpperCase());
      const newChecked = [...checked];


      if (currentIndex === -1) {
        newChecked.push(value.toUpperCase());
      } else {
        newChecked.splice(currentIndex, 1);
      }

      setChecked(newChecked);
      props.onChange(newChecked);
    }
  };

  return (
    <List className={classes.root}>
      {props.options.map(value => {
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
