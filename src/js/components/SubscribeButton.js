import React from 'react'


class SubscribeButton extends React.Component {
        constructor(props) {
          super(props);
          this.state = { isToggleOn: true};
          this.handleClick = this.handleClick.bind(this);
        }
      
        handleClick() {
          this.setState(state => ({
            isToggleOn: !state.isToggleOn
          }));
        }
      
        render() {
          return (
            <form>
              <button onClick={this.handleClick}>
                {this.state.isToggleOn ? 'Subscribe To This Truck' : 'Subscribed'}
              </button>
            </form>
        );
    }
}
export default SubscribeButton;