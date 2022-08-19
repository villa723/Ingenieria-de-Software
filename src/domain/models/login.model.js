const express = require("express");
const router = express.Router();
const connectionDb = require("../../config/dbconnections");
const tools = require("../../libs/tools");
class LoginModel {
  constructor() { }

  async create(email, password, imei, id, role) {
    const con = connectionDb.promise();
    const data = await con.query(
      "INSERT INTO login (Email_Address,Password,IMEI,ID,Role) VALUES (?,?,?,?,?)",
      [email, tools.toHash(password), imei, id, role]
    );
    return data[0];
  }
  async getAll() {
    const con = connectionDb.promise();
    const data = await con.query("SELECT * FROM login");
    return data[0];
  }
  async authenticate(email, password) {
    const con = connectionDb.promise();
    const data = await con.query("SELECT * FROM login WHERE Email_Address = ?", [
      email,
    ]);
    if (tools.compareHash(password, data[0][0].Password)) {
      return { status: "ok", id: data[0][0].ID };
    }
    return { status: "error" };
  }
}

module.exports = LoginModel;
