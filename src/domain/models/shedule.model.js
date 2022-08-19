const express = require("express");
const router = express.Router();
const connectionDb = require("../../config/dbconnections");

class SheduleModel {
  async getAll() {
    const con = connectionDb.promise();
    const data = await con.query("SELECT * FROM shedule");
    return data[0];
  }

  async create(
    Day,
    Start,
    Finish,
    CourseID
  ) {
    const con = connectionDb.promise();
    const data = await con.query("INSERT INTO schedule (Day,Start,Finish,CourseID) VALUES (?,?,?,?)",
      [Day, Start, Finish, CourseID]
    );
    //console.log("error",data);
    return data[0];
  }

  async findById(id) {
    const con = connectionDb.promise();
    const data = await con.query("SELECT * FROM schedule WHERE CourseID = ?", [id]);
    console.log("model", data);
    return data[0];
  }
}

module.exports = SheduleModel;