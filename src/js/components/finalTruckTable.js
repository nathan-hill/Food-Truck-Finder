import React, { useState } from 'react';
import Paper from '@material-ui/core/Paper';
import Select from '@material-ui/core/Select';

import MenuItem from '@material-ui/core/MenuItem';
import Input from '@material-ui/core/Input';
import Chip from '@material-ui/core/Chip';
import {
  DataTypeProvider,
  EditingState,
} from '@devexpress/dx-react-grid';
import {
  Grid,
  Table,
  TableHeaderRow,
  TableEditRow,
  TableEditColumn,
} from '@devexpress/dx-react-grid-material-ui';

import {
  generateRows,
  globalSalesValues,
} from './demo-data/generator';

export default () => {
  const getRowId = row => row.id;
  const [costState, setCost] = React.useState('$');
  

const costChange = (event) =>{
  costState=event.target.value;
}

const CostFormatter = ({ value}) => value;

const CostEditor = ({ costState, costChange}) => (
        <Select
          input={<Input />}
          labelId="costSelect"
          id="cost"
          value={costState}
          onChange={costChange}
          style={{ width: '100%' }}
        >
          <MenuItem value={'$'}>$</MenuItem>
          <MenuItem value={'$$'}>$$</MenuItem>
          <MenuItem value={'$$$'}>$$$</MenuItem>
          <MenuItem value={'$$$$'}>$$$$</MenuItem>
        </Select>
        
);

const CostTypeProvider = props => (
  <DataTypeProvider
    formatterComponent={CostFormatter}
    editorComponent={CostEditor}
    {...props}
  />
);


  const [columns] = useState([
    { name: 'foodTruckName', title: 'Food Truck Name' },
    { name: 'schedule', title: 'Schedule' },
    { name: 'cost', title: 'Cost' },
    { name: 'foodType', title: 'Food Type' },
    { name: 'menu', title: 'Menu' },
  ]);
  const [rows, setRows] = useState(generateRows({
    columnValues: { id: ({ index }) => index, ...globalSalesValues },
    length: 8,
  }));
  const [costColumns] = useState(['cost']);

  const commitChanges = ({ added, changed, deleted }) => {
    let changedRows;
    if (added) {
      const startingAddedId = rows.length > 0 ? rows[rows.length - 1].id + 1 : 0;
      changedRows = [
        ...rows,
        ...added.map((row, index) => ({
          id: startingAddedId + index,
          ...row,
        })),
      ];
    }
    if (changed) {
      changedRows = rows.map(row => (changed[row.id] ? { ...row, ...changed[row.id] } : row));
    }
    if (deleted) {
      const deletedSet = new Set(deleted);
      changedRows = rows.filter(row => !deletedSet.has(row.id));
    }
    setRows(changedRows);
  };

  return (
    <Paper>
      <Grid
        rows={rows}
        columns={columns}
        getRowId={getRowId}
      >
        <CostTypeProvider
          for={costColumns}
        />
        <EditingState
          onCommitChanges={commitChanges}
          defaultEditingRowIds={[0]}
        />
        <Table />
        <TableHeaderRow />
        <TableEditRow />
        <TableEditColumn
          showAddCommand
          showEditCommand
          showDeleteCommand
        />
      </Grid>
    </Paper>
  );
};