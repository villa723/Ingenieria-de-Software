
const mysql = require('mysql2');
    // create the pool
const pool = mysql.createPool({host:'localhost', user: 'root', database: 'attendance', password:'buscandoelcambio-5'});
module.exports = pool;
