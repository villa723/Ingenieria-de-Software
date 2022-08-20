
const mysql = require('mysql2');
// create the pool
const pool = mysql.createPool(
  {
    host: 'localhost',
    user: 'root',
    database: 'attendance',
    password: 'contra'
  });
module.exports = pool;

// const mysql = require('mysql2');
// // create the pool
// const pool = mysql.createPool(
//   {
//     host: process.env.host,
//     user: process.env.user,
//     database: process.env.database,
//     password: process.env.password
//   });
// module.exports = pool;
