import React from 'react';
import {forwardRef} from 'react';
import MaterialTable from 'material-table';

import ArrowDownward from '@material-ui/icons/ArrowDownward';
import Check from '@material-ui/icons/Check';
import ChevronLeft from '@material-ui/icons/ChevronLeft';
import ChevronRight from '@material-ui/icons/ChevronRight';
import Clear from '@material-ui/icons/Clear';
import DeleteOutline from '@material-ui/icons/DeleteOutline';
import Edit from '@material-ui/icons/Edit';
import FilterList from '@material-ui/icons/FilterList';
import FirstPage from '@material-ui/icons/FirstPage';
import LastPage from '@material-ui/icons/LastPage';
import Remove from '@material-ui/icons/Remove';
import SaveAlt from '@material-ui/icons/SaveAlt';
import Search from '@material-ui/icons/Search';
import ViewColumn from '@material-ui/icons/ViewColumn';
import axios from "axios";
import {connect} from "react-redux";
import * as Request from './../helpers/backendRequests'

const tableIcons = {
    Check: forwardRef((props, ref) => <Check {...props} ref={ref}/>),
    Clear: forwardRef((props, ref) => <Clear {...props} ref={ref}/>),
    Delete: forwardRef((props, ref) => <DeleteOutline {...props} ref={ref}/>),
    DetailPanel: forwardRef((props, ref) => <ChevronRight {...props} ref={ref}/>),
    Edit: forwardRef((props, ref) => <Edit {...props} ref={ref}/>),
    Export: forwardRef((props, ref) => <SaveAlt {...props} ref={ref}/>),
    Filter: forwardRef((props, ref) => <FilterList {...props} ref={ref}/>),
    FirstPage: forwardRef((props, ref) => <FirstPage {...props} ref={ref}/>),
    LastPage: forwardRef((props, ref) => <LastPage {...props} ref={ref}/>),
    NextPage: forwardRef((props, ref) => <ChevronRight {...props} ref={ref}/>),
    PreviousPage: forwardRef((props, ref) => <ChevronLeft {...props} ref={ref}/>),
    ResetSearch: forwardRef((props, ref) => <Clear {...props} ref={ref}/>),
    Search: forwardRef((props, ref) => <Search {...props} ref={ref}/>),
    SortArrow: forwardRef((props, ref) => <ArrowDownward {...props} ref={ref}/>),
    ThirdStateCheck: forwardRef((props, ref) => <Remove {...props} ref={ref}/>),
    ViewColumn: forwardRef((props, ref) => <ViewColumn {...props} ref={ref}/>)
};

var constants = require("./../helpers/constants");

class NotificationTable extends React.Component {
    

    constructor(props) {
        super(props);
        //may need to rename fields to match data returns
        this.state = {
            columns: [
                {title: 'Date', field: 'sentTime'},
                {title: 'Food Truck', field: 'truckName'},
                {title: 'Food Truck ID', field: 'sender'},
                {title: 'Message', field: 'text'},
            ], data:[],
        }
    }

    //fill with list from database

    componentDidMount = () => {
        console.log("ID: ", this.props.auth.user.sub);
        axios.get(constants.backend_url + "message/getMessagesbyUserID", {
            params: {
                id: this.props.auth.user.sub
            }
    }).then(res => {
            this.setState({data: res.data})
            console.log(this.state.data)
        });
    }

    render() {
        return (
            <MaterialTable
                
                actions={[ 
                    rowData => ({
                        icon: Check,
                        tooltip: 'Mark as Read',
                        onClick: (event, rowData) => Request.markMessageRead(rowData.id),
                        disabled: rowData.isRead,
                        hidden: rowData.isRead,
                      }),
                    // {
                    //     icon: Check,
                    //     tooltip: 'Mark as Read',
                    //     onClick: (e, rowData) => {
                    //         console.log(rowData)
                    //         Request.markMessageRead(rowData.id);
                    //     }, 
                        // disabled: rowData.isRead,
                        // hidden: rowData.isRead,
                // }
            ]}
                icons={tableIcons}
                title="Notifications"
                columns={this.state.columns}
                data={this.state.data}
                editable={{
                    onRowDelete: oldData =>
                        new Promise(resolve => {
                            setTimeout(() => {
                                resolve();
                                this.setState(prevState => {
                                    // sets the table to current state
                                    const data = [...prevState.data];

                                    // deletes a data point form the table
                                    data.splice(data.indexOf(oldData), 1);
                                    return {...prevState, data};
                                });
                            }, 600);
                        }),
                }}

            />
        );
    }
}

const mapStateToProps = state => ({
    auth: state.auth,
});

export default connect(mapStateToProps, null)(NotificationTable);