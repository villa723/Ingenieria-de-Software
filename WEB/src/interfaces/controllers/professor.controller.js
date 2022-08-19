const express = require("express");
const router = express.Router();
const PersonModel = require("../../domain/models/person.model");
const personDb = new PersonModel();
const LoginModel = require("../../domain/models/login.model");
const loginDb = new LoginModel();
const ProfessorModel = require("../../domain/models/professor.model");
const professorDb = new ProfessorModel();
const InscriptionModel = require("../../domain/models/inscription.model");
const inscriptionDb = new InscriptionModel();
const CourseModel = require("../../domain/models/course.model")
const courseDb = new CourseModel();
const CourseStudentsModel = require("../../domain/models/course_student.model");
const courseStudentsDb = new CourseStudentsModel();
const SheduleModel = require("../../domain/models/shedule.model");
const sheduleDb = new SheduleModel();

class ProfessorController {
  async getAll() {
    const result = professorDb.getAll()
    const data = await result.catch((err) => {
      console.log("controller Error", err);
      return null;
    });
    return data;
  }

  async findBydCode(code) {
    const result = professorDb.findBydCode(code)
    const data = await result.catch(err => {
      console.log("controller Error", err);
      return null;
    });
    return data;
  }

  async studentInscription(StudentID, CourseID) {
    const result = inscriptionDb.create(StudentID, CourseID);
    const data = await result.catch(err => {
      console.log("controller Error", err);
      return null;
    });
    return data;
  }

  async NuevoHorario(Day, Start, Finish, CourseID) {
    const result = sheduleDb.create(Day, Start, Finish, CourseID);
    const data = await result.catch((err) => {
      console.log("controller Error", err);
      return null;
    });
    return data;
  }

  async GetHorario(CourseID) {
    const result = sheduleDb.findById(CourseID);
    const data = await result.catch((err) => {
      console.log("controller Error Get Horario ", err);
      return null;
    });
    return data;
  }

  async NuevoCourse(Course_Name, SectionID, TypeID, ProfessorID, NumEst, Semestre) {
    const result = courseDb.create(Course_Name, SectionID, TypeID, ProfessorID, NumEst, Semestre);
    const data = await result.catch(err => {
      console.log("controller Error", err);
      return null;
    });

    return data;
  }

  async register(
    First_Name,
    Last_Name,
    Email,
    DNI,
    Mobile_Phone,
    CityID,
    Department,
    Password,
    idDNI) {
    const result = personDb.create(
      First_Name,
      Last_Name,
      Email,
      DNI,
      null,
      Mobile_Phone,
      CityID
    );

    const data = await result.catch((err) => {
      console.log("controller Error", err);
      return null;
    });

    const resultProfessor = professorDb.create(Department, data.insertId, idDNI);
    const dataProfessor = await resultProfessor.catch(err => {
      console.log("controller Error Professor", err);
      return null;
    })

    const resultLogin = loginDb.create(Email, Password, null, idDNI, 1);
    const dataLogin = await result.catch((err) => {
      console.log("controller Error", err);
      return null;
    });
    console.log("dataLogin", dataLogin);
    return dataLogin;
  }

  async login(email, password) {
    const resulLogin = loginDb.authenticate(email, password);
    const dataLogin = await resulLogin.catch((err) => {
      console.log("controller Error", err);
      return null;
    });
    return dataLogin;
  }

  async getAllCourses(id) {
    const resultCourse = await courseDb.findByIdProfessor(id)
      .catch((err) => {
        console.log("Controller Error", err);
        return null;
      });
    return resultCourse;
  }


  async getProfessorToCourse(token) {
    const resultProfessor = professorDb.findByDNI(token);
    const dataProfessor = await resultProfessor.catch((err) => {
      console.log("Controller error", err);
      return null;
    });
    return dataProfessor;
  }

  async getStudentsOfCourses(token) {
    const resultStudentsCourse = courseStudentsDb.studentsForCourse(token);
    const dataStudentsCourse = await resultStudentsCourse.catch((err) => {
      console.log("Controller error", err);
      return null;
    });
    return dataStudentsCourse;
  }

  async deleteCourse(id) {
    const result = courseDb.delete(id);
    const data = await result.catch((err) => {
      console.log("Controller error", err);
      return null;
    });
    return data;
  }

  async getCourse(id) {
    const result = courseDb.findById(id)
    const data = await result.catch((err) => {
      console.log("Controller error", err);
      return null;
    });
    return data;
  }

  async updateCourse(name, section, type, semestre, id) {
    const result = courseDb.update(name, section, type, semestre, id)
    const data = await result.catch((err) => {
      console.log("Controller error", err);
      return null;
    });
    return data;
  }

}

module.exports = ProfessorController;
