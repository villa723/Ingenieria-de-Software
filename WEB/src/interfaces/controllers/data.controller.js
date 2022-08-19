const express = require("express");
const router = express.Router();
const VerifyModel = require("../../domain/models/verify.model");
const verifyDb = new VerifyModel();
const CityModel = require("../../domain/models/city.model");
const cityDb = new CityModel();
const SectionModel = require("../../domain/models/section.model");
const sectionDb = new SectionModel();
const TypeModel = require("../../domain/models/type.model");
const typeDb = new TypeModel();
const PersonModel = require("../../domain/models/person.model");
const personDb = new PersonModel();
const CourseModel = require("../../domain/models/course.model");

const CityService = require("../../aplication/services/city.service");
const CityRepository = require("../../domain/repository/city.repository");

const TypeService = require("../../aplication/services/type.service");
const TypeRepository = require("../../domain/repository/type.repository");

const courseDb = new CourseModel();

class DataController {
  constructor() { }

  async getAllPerson() {
    const result = personDb.getAll();
    const data = await result.catch(err => {
      console.log("controller Error", err);
      return null;
    });
    return data;
  }

  async getAllVerify() {
    const result = verifyDb.getAll();
    const data = await result.catch(err => {
      console.log("controller Error", err);
      return null;
    });
    return data;
  }

  async getDataVerifyByCui(cui) {
    const result = verifyDb.findCui(cui);
    const data = await result.catch(err => {
      console.log("controller Error", err);
      return null;
    });
    return data;
  }

  async getAllCities() {
    var instanceCityRepository = new CityRepository(cityDb);
    var instanceCityService = new CityService(instanceCityRepository);
    const data = await instanceCityService.getAll().catch(err => {
      console.log("controller Error", err);
      return null;
    });
    return data;
  }


  async getAllType() {
    var instanceTypeRepository = new TypeRepository(typeDb);
    var instanceTypeService = new TypeService(instanceTypeRepository);
    const data = await instanceTypeService.getAll().catch(err => {
      console.log("controller Error", err);
      return null;
    });
    return data;
  }

  async getAllSection() {
    const result = sectionDb.getAll();
    const data = await result.catch(err => {
      console.log("controller Error", err);
      return null;
    });
    return data;
  }


  async findCityByName(name) {
    const result = cityDb.findByName(name);
    const data = await result.catch(err => {
      console.log("controller Error", err);
      return null;
    });
    return data;
  }
  async findCityById(id) {
    const result = cityDb.findById(id);
    const data = await result.catch(err => {
      console.log("controller Error", err);
      return null;
    });
    return data;
  }

  async getAllCourses() {
    const result = courseDb.getAll();
    const data = await result.catch(err => {
      console.log("controller Error", err);
      return null;
    });
    return data;
  }

  async findCourseById(id) {
    const result = courseDb.findById(id)
    const data = await result.catch(err => {
      console.log("controller Error", err);
      return null;
    });
    return data;
  }

  async findCourseByName(name) {
    const result = courseDb.findByName(name)
    const data = await result.catch(err => {
      console.log("controller Error", err);
      return null;
    });
    return data;
  }
}

module.exports = DataController;
