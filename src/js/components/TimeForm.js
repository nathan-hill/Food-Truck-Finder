import React from 'react';

class TimeForm extends React.Component {
    constructor(props) {
      super(props);
      this.state = {open: '12:00 AM',
                    close: '12:00 PM'};
  
      this.handleChange = this.handleChange.bind(this);
      this.handleSubmit = this.handleSubmit.bind(this);
    }
  
    handleChange(event) {
      this.setState({value: event.target.value});
    }
  
    handleSubmit(event) {
      alert('Your opening time is: ' + this.state.open);
      alert('Your closing time is: ' + this.state.close);
      event.preventDefault();
    }
  
    render() {
      return (
        <form onSubmit={this.handleSubmit}>
          <label>
            opening time
            <select open={this.state.open} onChange={this.handleChange}>
              <option open="12:00AM">12:00 AM</option>
              <option open="12:30AM">12:30 AM</option>
              <option open="01:00AM">01:00 AM</option>
              <option open="01:30AM">01:30 AM</option>
              <option open="02:00AM">02:00 AM</option>
              <option open="02:30AM">02:30 AM</option>
              <option open="03:00AM">03:00 AM</option>
              <option open="03:30AM">03:30 AM</option>
              <option open="04:00AM">04:00 AM</option>
              <option open="04:30AM">04:30 AM</option>
              <option open="05:00AM">05:00 AM</option>
              <option open="05:30AM">05:30 AM</option>
              <option open="06:00AM">06:00 AM</option>
              <option open="06:30AM">06:30 AM</option>
              <option open="07:00AM">07:00 AM</option>
              <option open="07:30AM">07:30 AM</option>
              <option open="08:00AM">08:00 AM</option>
              <option open="08:30AM">08:30 AM</option>
              <option open="09:00AM">09:00 AM</option>
              <option open="09:30AM">09:30 AM</option>
              <option open="10:00AM">10:00 AM</option>
              <option open="10:30AM">10:30 AM</option>
              <option open="11:00AM">11:00 AM</option>
              <option open="11:30AM">11:30 AM</option>
              <option open="12:00PM">12:00 PM</option>
              <option open="12:30PM">12:30 PM</option>
              <option open="01:00PM">01:00 PM</option>
              <option open="01:30PM">01:30 PM</option>
              <option open="02:00PM">02:00 PM</option>
              <option open="02:30PM">02:30 PM</option>
              <option open="03:00PM">03:00 PM</option>
              <option open="03:30PM">03:30 PM</option>
              <option open="04:00PM">04:00 PM</option>
              <option open="04:30PM">04:30 PM</option>
              <option open="05:00PM">05:00 PM</option>
              <option open="05:30PM">05:30 PM</option>
              <option open="06:00PM">06:00 PM</option>
              <option open="06:30PM">06:30 PM</option>
              <option open="07:00PM">07:00 PM</option>
              <option open="07:30PM">07:30 PM</option>
              <option open="08:00PM">08:00 PM</option>
              <option open="08:30PM">08:30 PM</option>
              <option open="09:00PM">09:00 PM</option>
              <option open="09:30PM">09:30 PM</option>
              <option open="10:00PM">10:00 PM</option>
              <option open="10:30PM">10:30 PM</option>
              <option open="11:00PM">11:00 PM</option>
              <option open="11:30PM">11:30 PM</option>
            </select>
          </label>
          <label>
            Closing time
            <select close={this.state.close} onChange={this.handleChange}>
              <option close="12:00AM">12:00 AM</option>
              <option close="12:30AM">12:30 AM</option>
              <option close="01:00AM">01:00 AM</option>
              <option close="01:30AM">01:30 AM</option>
              <option close="02:00AM">02:00 AM</option>
              <option close="02:30AM">02:30 AM</option>
              <option close="03:00AM">03:00 AM</option>
              <option close="03:30AM">03:30 AM</option>
              <option close="04:00AM">04:00 AM</option>
              <option close="04:30AM">04:30 AM</option>
              <option close="05:00AM">05:00 AM</option>
              <option close="05:30AM">05:30 AM</option>
              <option close="06:00AM">06:00 AM</option>
              <option close="06:30AM">06:30 AM</option>
              <option close="07:00AM">07:00 AM</option>
              <option close="07:30AM">07:30 AM</option>
              <option close="08:00AM">08:00 AM</option>
              <option close="08:30AM">08:30 AM</option>
              <option close="09:00AM">09:00 AM</option>
              <option close="09:30AM">09:30 AM</option>
              <option close="10:00AM">10:00 AM</option>
              <option close="10:30AM">10:30 AM</option>
              <option close="11:00AM">11:00 AM</option>
              <option close="11:30AM">11:30 AM</option>
              <option close="12:00PM">12:00 PM</option>
              <option close="12:30PM">12:30 PM</option>
              <option close="01:00PM">01:00 PM</option>
              <option close="01:30PM">01:30 PM</option>
              <option close="02:00PM">02:00 PM</option>
              <option close="02:30PM">02:30 PM</option>
              <option close="03:00PM">03:00 PM</option>
              <option close="03:30PM">03:30 PM</option>
              <option close="04:00PM">04:00 PM</option>
              <option close="04:30PM">04:30 PM</option>
              <option close="05:00PM">05:00 PM</option>
              <option close="05:30PM">05:30 PM</option>
              <option close="06:00PM">06:00 PM</option>
              <option close="06:30PM">06:30 PM</option>
              <option close="07:00PM">07:00 PM</option>
              <option close="07:30PM">07:30 PM</option>
              <option close="08:00PM">08:00 PM</option>
              <option close="08:30PM">08:30 PM</option>
              <option close="09:00PM">09:00 PM</option>
              <option close="09:30PM">09:30 PM</option>
              <option close="10:00PM">10:00 PM</option>
              <option close="10:30PM">10:30 PM</option>
              <option close="11:00PM">11:00 PM</option>
              <option close="11:30PM">11:30 PM</option>
            </select>
          </label>
          <input type="submit" value="Submit" />
        </form>
      );
    }
  }

  export default TimeForm