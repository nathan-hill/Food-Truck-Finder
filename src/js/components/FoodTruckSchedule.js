import React from "react";
import { RadioGroup, RadioButton, ReversedRadioButton } from 'react-radio-buttons';
import TimeForm from "./TimeForm";

class FoodTruckSchedule extends React.Component{
    constructor(props) {
        super(props);

        this.state = {
                
        };       
        
    }
    render(){
        return(
            <form>
                <div>
                    Monday  
                    <RadioGroup onChange={ this.onChange } horizontal>
                        <RadioButton value="Open">
                            Open
                        </RadioButton>
                        <RadioButton value="Close">
                            Closed
                        </RadioButton>
                    </RadioGroup>
                    <TimeForm/>
                </div>
                <div>
                    Tuesday 
                    <RadioGroup onChange={ this.onChange } horizontal>
                        <RadioButton value="Open">
                            Open
                        </RadioButton>
                        <RadioButton value="Close">
                            Closed
                        </RadioButton>
                    </RadioGroup>
                    <TimeForm/>
                </div>
                <div>
                    Wednesday 
                    <RadioGroup onChange={ this.onChange } horizontal>
                        <RadioButton value="Open">
                            Open
                        </RadioButton>
                        <RadioButton value="Close">
                            Closed
                        </RadioButton>
                    </RadioGroup>
                    <TimeForm/>
                </div>
                <div>
                    Thursday 
                    <RadioGroup onChange={ this.onChange } horizontal>
                        <RadioButton value="Open">
                            Open
                        </RadioButton>
                        <RadioButton value="Close">
                            Closed
                        </RadioButton>
                    </RadioGroup>
                    <TimeForm/>
                </div>
                <div>
                    Friday
                    <RadioGroup onChange={ this.onChange } horizontal>
                        <RadioButton value="Open">
                            Open
                        </RadioButton>
                        <RadioButton value="Close">
                            Closed
                        </RadioButton>
                    </RadioGroup>
                    <TimeForm/>
                </div>
                <div>
                    Saturday
                    <RadioGroup onChange={ this.onChange } horizontal>
                        <RadioButton value="Open">
                            Open
                        </RadioButton>
                        <RadioButton value="Close">
                            Closed
                        </RadioButton>
                    </RadioGroup>
                    <TimeForm/>
                </div>
                <div>
                    Sunday  
                    <RadioGroup onChange={ this.onChange } horizontal>
                        <RadioButton value="Open">
                            Open
                        </RadioButton>
                        <RadioButton value="Close">
                            Closed
                        </RadioButton>
                    </RadioGroup>
                    <TimeForm/>
                </div>

            </form>
        );
    }
}

export default FoodTruckSchedule;