import React from 'react';
import Radio from '@material-ui/core/Radio';
import RadioGroup from '@material-ui/core/RadioGroup';
import FormControlLabel from '@material-ui/core/FormControlLabel';
import FormControl from '@material-ui/core/FormControl';
import FormLabel from '@material-ui/core/FormLabel';

export default function FormControlLabelPosition(props) {
  const [value, setValue] = React.useState('female');

  const handleChange = event => {
    setValue(event.target.value);
    props.action();
  };

  return (
    <FormControl component="fieldset">
      <FormLabel component="legend">Account Type</FormLabel>
      <RadioGroup aria-label="position" name="type" value={value} onChange={handleChange} row>
        <FormControlLabel
          value="customer"
          control={<Radio color="primary" />}
          label="Customer"
          labelPlacement="start"
        />
        <FormControlLabel
          value="owner"
          control={<Radio color="primary" />}
          label="Food Truck Owner"
          labelPlacement="start"
        />
      </RadioGroup>
    </FormControl>
  );
}