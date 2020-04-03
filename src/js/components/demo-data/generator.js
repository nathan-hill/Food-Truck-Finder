import randomSeed from './random';

export const globalSalesValues = {
  cost: ['$', '$$', '$$$', '$$$$'],
  foodTruckName: [
    'Renewable Supplies', 'Energy Systems', 'Environment Solar', 'Beacon Systems', 'Apollo Inc',
    'Gemini Stores', 'McCord Builders', 'Building M Inc', 'Global Services',
    'Market Eco', 'Johnson & Assoc', 'Get Solar Inc', 'Supply Warehouse', 'Discovery Systems', 'Mercury Solar'],
  schedule: ['SolarMax', 'SolarOne', 'EnviroCare', 'EnviroCare Max'],
  shipped: [true, false],
};


export function generateRows({
  columnValues = globalSalesValues,
  length,
  random = randomSeed(329972281),
}) {
  const data = [];
  const columns = Object.keys(columnValues);

  for (let i = 0; i < length; i += 1) {
    const record = {};

    columns.forEach((column) => {
      let values = columnValues[column];

      if (typeof values === 'function') {
        record[column] = values({ random, index: i, record });
        return;
      }

      while (values.length === 2 && typeof values[1] === 'object') {
        values = values[1][record[values[0]]];
      }

      const value = values[Math.floor(random() * values.length)];
      if (typeof value === 'object') {
        record[column] = { ...value };
      } else {
        record[column] = value;
      }
    });

    data.push(record);
  }

  return data;
}
