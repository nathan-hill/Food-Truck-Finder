import React from 'react';
import MaterialTable from 'material-table';


export default function MaterialTableDemo() {
  const [state, setState] = React.useState({
    columns: [
      { title: 'Food Truck Name', field: 'name' },
      { title: 'Schedule', field: 'schedule' },
      { title: 'Route', field: 'Route' },
    ],
    data: [
      { name: 'tacos', schedule: 'Monday-Friday', Route: 'BSB' },
      {
        name: 'burgers',
        schedule: 'Monday-Saturday',
        Route: 'Baylor Sub Building',
       
      },
    ],
  });

  return (
    <MaterialTable
      title="Food Truck Table"
      columns={state.columns}
      data={state.data}
      editable={{
        // add method
        onRowAdd: newData =>
          new Promise(resolve => {
            setTimeout(() => {
              resolve();
              setState(prevState => {
                // sets the table to current state
                const data = [...prevState.data];

                // adds a new data point to the table
                data.push(newData);


                return { ...prevState, data };
              });
            }, 600);
          }),
        onRowUpdate: (newData, oldData) =>
          new Promise(resolve => {
            setTimeout(() => {
              resolve();
              if (oldData) {
                setState(prevState => {
                  // sets the table to current state
                  const data = [...prevState.data];

                  // updates the table position
                  data[data.indexOf(oldData)] = newData;
                  return { ...prevState, data };
                });
              }
            }, 600);
          }),
        onRowDelete: oldData =>
          new Promise(resolve => {
            setTimeout(() => {
              resolve();
              setState(prevState => {
                // sets the table to current state
                const data = [...prevState.data];

                // deletes a data point form the table
                data.splice(data.indexOf(oldData), 1);
                return { ...prevState, data };
              });
            }, 600);
          }),
      }}
    />
  );
}