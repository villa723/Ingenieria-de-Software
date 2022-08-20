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

const ProfessorService = require("../../aplication/services/professor.service");
const ProfessorRepository = require("../../domain/repository/professor.repository");

const InscriptionService = require("../../aplication/services/inscription.service");
const InscriptionRepository = require("../../domain/repository/inscription.repository");

const SheduleService = require("../../aplication/services/shedule.service");
const SheduleRepository = require("../../domain/repository/shedule.repository");

const CourseService = require("../../aplication/services/course.service");
const CourseRepository = require("../../domain/repository/course.repository");

const PersonService = require("../../aplication/services/person.service");
const PersonRepository = require("../../domain/repository/person.repository");

const LoginService = require("../../aplication/services/login.service");
const LoginRepository = require("../../domain/repository/login.repository");

const CourseStudentsService = require("../../aplication/services/courseStudents.service");
const CourseStudentsRepository = require("../../domain/repository/courseStudents.repository");

class ProfessorController {
  async getAll() {
    var instanceProfessorRepository = new ProfessorRepository(professorDb);
    var instanceProfessorService = new ProfessorService(instanceProfessorRepository);
    const result = instanceProfesorService.getAll()
    const data = await result.catch((err) => {
      console.log("controller Error", err);
      return null;
    });
    return data;
  }

  async findBydCode(code) {
    var instanceProfessorRepository = new ProfessorRepository(professorDb);
    var instanceProfessorService = new ProfessorService(instanceProfessorRepository);
    const result = instanceProfessorService.findBydCode(code)
    const data = await result.catch(err => {
      console.log("controller Error", err);
      return null;
    });
    return data;
  }

  async studentInscription(StudentID, CourseID) {
    var instanceInscriptionRepository = new InscriptionRepository(inscriptionDb);
    var instanceInscriptionService = new InscriptionService(instanceInscriptionRepository);
    const result = instanceInscriptionService.create(StudentID, CourseID);
    const data = await result.catch(err => {
      console.log("controller Error", err);
      return null;
    });
    return data;
  }

  async NuevoHorario(Day, Start, Finish, CourseID) {
    var instanceSheduleRepository = new SheduleRepository(sheduleDb);
    var instanceSheduleService = new SheduleService(instanceSheduleRepository);
    const result = instanceSheduleService.create(Day, Start, Finish, CourseID);
    const data = await result.catch((err) => {
      console.log("controller Error", err);
      return null;
    });
    return data;
  }

  async GetHorario(CourseID) {
    var instanceSheduleRepository = new SheduleRepository(sheduleDb);
    var instanceSheduleService = new SheduleService(instanceSheduleRepository);
    const result = instanceSheduleService.findById(CourseID);
    const data = await result.catch((err) => {
      console.log("controller Error Get Horario ", err);
      return null;
    });
    return data;
  }

  async NuevoCourse(Course_Name, SectionID, TypeID, ProfessorID, NumEst, Semestre) {
    var instanceCourseRepository = new CourseRepository(courseDb);
    var instanceCourseService = new CourseService(instanceCourseRepository);
    
    const result = instanceCourseService.create(Course_Name, SectionID, TypeID, ProfessorID, NumEst, Semestre);
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
    var instancePersonRepository = new PersonRepository(personDb);
    var instancePersonService = new PersonService(instancePersonRepository);
    var instanceProfessorRepository = new ProfessorRepository(professorDb);
    var instanceProfessorService = new ProfessorService(instanceProfessorRepository);
    var instanceLoginRepository = new LoginRepository(loginDb);
    var instanceLoginService = new LoginService(instanceLoginRepository);
      
    const result = instancePersonService.create(
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

    const resultProfessor = instanceProfessorService.create(Department, data.insertId, idDNI);
    const dataProfessor = await resultProfessor.catch(err => {
      console.log("controller Error Professor", err);
      return null;
    })

    const resultLogin = instanceLoginService.create(Email, Password, null, idDNI, 1);
    const dataLogin = await result.catch((err) => {
      console.log("controller Error", err);
      return null;
    });
    console.log("dataLogin", dataLogin);
    return dataLogin;
  }

  async login(email, password) {
    var instanceLoginRepository = new LoginRepository(loginDb);
    var instanceLoginService = new LoginService(instanceLoginRepository);
    const resulLogin = instanceLoginService.authenticate(email, password);
    const dataLogin = await resulLogin.catch((err) => {
      console.log("controller Error", err);
      return null;
    });
    return dataLogin;
  }

  async getAllCourses(id) {
    var instanceCourseRepository = new CourseRepository(courseDb);
    var instanceCourseService = new CourseService(instanceCourseRepository);
    
    const resultCourse = await instanceCourseService.findByIdProfessor(id)
      .catch((err) => {
        console.log("Controller Error", err);
        return null;
      });
    return resultCourse;
  }


  async getProfessorToCourse(token) {
    var instanceProfessorRepository = new ProfessorRepository(professorDb);
    var instanceProfessorService = new ProfessorService(instanceProfessorRepository);
    
    const resultProfessor = instanceProfessorService.findByDNI(token);
    const dataProfessor = await resultProfessor.catch((err) => {
      console.log("Controller error", err);
      return null;
    });
    return dataProfessor;
  }

  async getStudentsOfCourses(token) {
    var instanceCourseStudentsRepository = new CourseStudentsRepository(courseStudentsDb);
    var instanceCourseStudentsService = new CourseStudentsService(instanceCourseStudentsRepository);
    
    const resultStudentsCourse = instanceCourseStudentsService.studentsForCourse(token);
    const dataStudentsCourse = await resultStudentsCourse.catch((err) => {
      console.log("Controller error", err);
      return null;
    });
    return dataStudentsCourse;
  }

  async deleteCourse(id) {
    var instanceCourseRepository = new CourseRepository(courseDb);
    var instanceCourseService = new CourseService(instanceCourseRepository);
    
    const result = instanceCourseService.delete(id);
    const data = await result.catch((err) => {
      console.log("Controller error", err);
      return null;
    });
    return data;
  }

  async getCourse(id) {
    var instanceCourseRepository = new CourseRepository(courseDb);
    var instanceCourseService = new CourseService(instanceCourseRepository);
    
    const result = instanceCourseService.findById(id)
    const data = await result.catch((err) => {
      console.log("Controller error", err);
      return null;
    });
    return data;
  }

  async updateCourse(name, section, type, semestre, id) {
    var instanceCourseRepository = new CourseRepository(courseDb);
    var instanceCourseService = new CourseService(instanceCourseRepository);
    
    const result = instanceCourseService.update(name, section, type, semestre, id)
    const data = await result.catch((err) => {
      console.log("Controller error", err);
      return null;
    });
    return data;
  }

}

module.exports = ProfessorController;
