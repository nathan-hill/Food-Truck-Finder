import React from 'react'

//import CssBaseline from '@material-ui/core/CssBaseline'
import EnhancedTable from './tableComponents/EnhancedTable'
import makeData from './tableComponents/makeData'

const FoodTruckTable = () => {
  const columns = React.useMemo(
    () => [
      {
        Header: 'Food Truck Name',
        accessor: 'foodTruckName',
      },
      {
        Header: 'Schedule',
        accessor: 'schedule',
      },
      {
        Header: 'Cost',
        accessor: 'cost',
      },
      {
        Header: 'Food Type',
        accessor: 'foodType',
      },
      {
        Header: 'Menu',
        accessor: 'menu',
      },
      
    ],
    []
  )

  const [data, setData] = React.useState(React.useMemo(() => makeData(5), []))
  const [skipPageReset, setSkipPageReset] = React.useState(false)

  // We need to keep the table from resetting the pageIndex when we
  // Update data. So we can keep track of that flag with a ref.

  // When our cell renderer calls updateMyData, we'll use
  // the rowIndex, columnId and new value to update the
  // original data
  const updateMyData = (rowIndex, columnId, value) => {
    // We also turn on the flag to not reset the page
    setSkipPageReset(true)
    setData(old =>
      old.map((row, index) => {
        if (index === rowIndex) {
          return {
            ...old[rowIndex],
            [columnId]: value,
          }
        }
        return row
      })
    )
  }

  return (
    <div>
      {/* <CssBaseline /> */}
      <EnhancedTable
        columns={columns}
        data={data}
        setData={setData}
        updateMyData={updateMyData}
        skipPageReset={skipPageReset}
      />
    </div>
  )
}

export default FoodTruckTable
