import React from "react";

var data = {
    columns: [
    "Proximity",
    "Price",
    "Food Type",
    
    ],
    rows: [
    [
    "Proximity Placeholder", "Price placeholder", "Food Type Placeholder"],
    ],
    }

class CustomerPreferences extends React.Component{
    constructor(props) {
        super(props);
        this.state = {
            rows: [],
            columns: []
        }

    }
    componentDidMount(){
        this.setState( { rows: data.rows, columns: data.columns } );
    }

    render(){
        return (
            
            <div id="container" className="container">
                <h1>Recommended Food Trucks</h1>
                <h3>Your Preferences</h3>
                   <table className="table">
                    <thead>
                            <tr>
                             {this.state.columns.map(( column, index ) =>                                  {
       
                                 return (<th>{column}</th>)
                              }
                               )
                              }
                            </tr>
                            </thead>
                            <tbody> {
                                this.state.rows.map(( row ) => (
                                    <tr>
                                        <td>{row[0]}</td>
                                        <td>{row[1]}</td>
                                        <td>{row[2]}</td>
                                        
                                    </tr>
                                ) )
                            }
                            </tbody>
                        </table>
                    </div>
        )
    }
}

export default CustomerPreferences;