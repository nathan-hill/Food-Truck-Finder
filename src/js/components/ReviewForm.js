import React from 'react'

class ReviewForm extends React.Component {
    constructor(props) {
      super(props);
      this.state = {
        value: 'Please write about your experience with this food truck.'
      };
  
      this.handleChange = this.handleChange.bind(this);
      this.handleSubmit = this.handleSubmit.bind(this);
    }
  
    handleChange(event) {
      this.setState({value: event.target.value});
    }
  
    handleSubmit(event) {
      //alert('An essay was submitted: ' + this.state.value);
      event.preventDefault();
    }
  
    render() {
      return (
        <form onSubmit={this.handleSubmit} style={{ width: "50%"}}>
          <label>
            <textarea value={this.state.value} onChange={this.handleChange} style={{ width: "300px", height: "200px"}}/>
          </label>
          <input type="submit" value="Submit" />
        </form>
      );
    }
  }

export default ReviewForm;