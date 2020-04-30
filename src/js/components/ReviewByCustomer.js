import React from 'react';
import {forwardRef} from 'react';
import MaterialTable from 'material-table';
import Rating from '@material-ui/lab/Rating';
import Box from '@material-ui/core/Box';

import ArrowDownward from '@material-ui/icons/ArrowDownward';
import GradeIcon from '@material-ui/icons/Grade';
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

const tableIcons = {
    GradeIcon: forwardRef((props, ref) => <GradeIcon {...props} ref={ref}/>),
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

var constants = require("../helpers/constants");

class ReviewTable extends React.Component{
    constructor(props) {
        super(props);
        //may need to rename fields to match data returns
        this.state = {
            columns: [
                {title: 'Customer', field: 'customer'},
                {title: 'Food Truck', field: 'name'},
                {title: 'Rating', 
                    field: 'rating',
                    render: rowData => (
                        <Box component="fieldset" mb={3} borderColor="transparent">
                            <Rating value={rowData.rating} disabled />
                        </Box>
                    )},
                {title: 'Review', field: 'description'}
            ], data:[],
        }
    }


    
    //fill with list from database

    componentDidMount = () => {
        // console.log("ID: ", this.props.auth.user.sub);
        axios.get(constants.backend_url + "getfunction", {
            params: {
                id: this.props.auth.user.id
            }
    }).then(res => {
            this.setState({data: res.data})
            // console.log(this.state.data)
        });
    }


    render() {
        return (
            <MaterialTable
                icons={tableIcons}
                title="Reviews"
                columns={this.state.columns}
                data={this.state.data}
            />
        );
    }
}

export default ReviewTable;