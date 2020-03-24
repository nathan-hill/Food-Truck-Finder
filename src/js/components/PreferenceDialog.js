// import React from "react";
// import { makeStyles, withStyles } from "@material-ui/core/styles";
// import InputBase from "@material-ui/core/InputBase";
// import InputLabel from "@material-ui/core/InputLabel";
// import Input from "@material-ui/core/Input";
// import Select from "@material-ui/core/Select";
// import Slider from "@material-ui/core/Slider";
// import Grid from "@material-ui/core/Grid";
// import Paper from "@material-ui/core/Paper";
// import { Typography } from "@material-ui/core";
// import CheckBoxList from "./CheckBoxList";

// const BootstrapInput = withStyles(theme => ({
//   root: {
//     "label + &": {
//       marginTop: theme.spacing(3)
//     }
//   },
//   input: {
//     borderRadius: 4,
//     position: "relative",
//     backgroundColor: theme.palette.background.paper,
//     border: "1px solid #ced4da",
//     fontSize: 16,
//     padding: "10px 26px 10px 12px",
//     transition: theme.transitions.create(["border-color", "box-shadow"]),
//     // Use the system font instead of the default Roboto font.
//     fontFamily: [
//       "-apple-system",
//       "BlinkMacSystemFont",
//       '"Segoe UI"',
//       "Roboto",
//       '"Helvetica Neue"',
//       "Arial",
//       "sans-serif",
//       '"Apple Color Emoji"',
//       '"Segoe UI Emoji"',
//       '"Segoe UI Symbol"'
//     ].join(","),
//     "&:focus": {
//       borderRadius: 4,
//       borderColor: "#80bdff",
//       boxShadow: "0 0 0 0.2rem rgba(0,123,255,.25)"
//     }
//   }
// }))(InputBase);

// const useStyles = makeStyles(theme => ({
//   container: {
//     display: "flex",
//     flexWrap: "wrap"
//   },
//   formControl: {
//     margin: theme.spacing(1),
//     minWidth: 120
//   },
//   margin: {
//     margin: theme.spacing(1)
//   },
//   root: {
//     flexGrow: 1
//   },
//   paper: {
//     padding: theme.spacing(2),
//     textAlign: "center",
//     color: theme.palette.text.secondary
//   }
// }));

// export default function UserPreferences(props) {
//   const classes = useStyles();
//   const [open, setOpen] = React.useState(false);
//   const [food, setFood] = React.useState("");
//   const [price, setPrice] = React.useState("");

//   const handleChange = event => {
//     setFood(event.target.value || "");
//     setPrice(Number(event.target.value) || "");
//     props.onChange(event.target);
//   };

//   function valuetext(value) {
//     return `${value} miles`;
//   }

//   const handleClickOpen = () => {
//     setOpen(true);
//   };

//   const handleClose = e => {
//     setOpen(false);
//     console.log(e);
//     //props.sendDialogData()
//   };

//   return (
//     <div>
//       <Grid container styles={{ flexGrow: 1 }}>
//         <form className={classes.container}>
//           <Grid item xs={12}>
//             <Paper className={classes.paper}>
//               <Typography gutterBottom>Maximum distance (mi)</Typography>
//               <Slider 
//                 defaultValue={30}
//                 getAriaValueText={valuetext}
//                 aria-labelledby="discrete-slider"
//                 valueLabelDisplay="auto"
//                 step={1}
//                 marks
//                 min={1}
//                 max={30}
//                 disabled={props.disabled}
//                 onChange={props.onChange}
//               />
//             </Paper>
//           </Grid>

//           <Grid item xs={12}>
//             <Paper className={classes.paper}>
//               <InputLabel htmlFor="price-native">Price</InputLabel>
//               <Select
//                 native
//                 priceValue={price}
//                 onChange={handleChange}
//                 input={<Input id="price-native" />}
//                 disabled={props.disabled}
//               >
//                 <option aria-label="None" priceValue="" />
//                 <option priceValue={1}>$</option>
//                 <option priceValue={2}>$$</option>
//                 <option priceValue={3}>$$$</option>
//                 <option priceValue={4}>$$$$</option>
//               </Select>
//             </Paper>
//           </Grid>

//           <Grid item xs>
//             <Paper className={classes.paper}>
//               <InputLabel htmlFor="foodtype-native">Food Type</InputLabel>
//               <CheckBoxList
//                 foodList={[
//                   "Mexican",
//                   "American",
//                   "Italian",
//                   "Chinese",
//                   "Vietnamese"
//                 ]}
//                 disabled={props.disabled}
//                 onChange={props.onChange}
//               />
//             </Paper>
//           </Grid>
//         </form>
//       </Grid>
//     </div>
//   );
// }
