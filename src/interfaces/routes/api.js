var express = require("express");
var router = express.Router();
const StudentController = require("../controllers/student.controller");
const studentDb = new StudentController();
const DataController = require("../controllers/data.controller");
const dataDb = new DataController();
const ProfessorController = require("../controllers/professor.controller");
const professorDb = new ProfessorController();

router.get("/", function (req, res, next) {
  res.render('api', { title: 'Express' });
});
router.get("/alumnos", async (req, res) => {
  const info = await studentDb.getAll();
  res.setHeader("Content-Type", "application/json");
  res.end(JSON.stringify(info));
});
router.get("/alumnos/:cui", async (req, res) => {
  const info = await studentDb.findBydCui(req.params.cui);
  res.setHeader("Content-Type", "application/json");
  console.log("info",info);
  res.end(JSON.stringify(info));
});
router.post("/alumnos/registrar", async (req, res) => {
  console.log("post", req.body);
  const info = await studentDb.register(
    req.body.First_Name,
    req.body.Last_Name,
    req.body.Email,
    req.body.DNI,
    req.body.Home_Phone,
    req.body.Mobile_Phone,
    req.body.CityID,
    req.body.StudentID,
    req.body.Career,
    req.body.Faculty,
    req.body.Password,
    req.body.IMEI
  );
  res.setHeader("Content-Type", "application/json");
  res.end(JSON.stringify(info));
});
router.post("/alumnos/ingresar", async (req, res) => {
  const info = await studentDb.login(req.body.email,req.body.password);
  res.setHeader("Content-Type", "application/json");
  res.end(JSON.stringify(info));
});
router.post("/alumnos/asistencia", async (req, res) => {
  const info = await studentDb.attendance(req.body.studentid,req.body.professorid,req.body.curseid)
  res.setHeader("Content-Type", "application/json");
  res.end(JSON.stringify(info));
});
router.get("/profesores", async (req, res) => {
  const info = await professorDb.getAll();
  res.setHeader("Content-Type", "application/json");
  res.end(JSON.stringify(info));
});
router.get("/profesores/:code", async (req, res) => {
  const info = await professorDb.findBydCode(req.params.code);
  res.setHeader("Content-Type", "application/json");
  res.end(JSON.stringify(info));
});

router.post("/profesores/inscribir", async (req, res) => {
  const info = await professorDb.studentInscription(req.body.studentid,req.body.curseid);
  res.setHeader("Content-Type", "application/json");
  res.end(JSON.stringify(info));
});

router.get("/personas", async (req, res) => {
  const info = await dataDb.getAllPerson();
  res.setHeader("Content-Type", "application/json");
  res.end(JSON.stringify(info));
});
router.get("/verificar", async (req, res) => {
  const info = await dataDb.getAllVerify();
  res.setHeader("Content-Type", "application/json");
  res.end(JSON.stringify(info));
});
router.get("/verificar/:cui", async (req, res) => {
  const info = await dataDb.getDataVerifyByCui(req.params.cui);
  res.setHeader("Content-Type", "application/json");
  res.end(JSON.stringify(info));
});
router.get("/ciudades", async (req, res) => {
  const info = await dataDb.getAllCities();
  res.setHeader("Content-Type", "application/json");
  res.end(JSON.stringify(info));
});
router.get("/ciudades/nombre/:name", async (req, res) => {
  const info = await dataDb.findCityByName(req.params.name);
  res.setHeader("Content-Type", "application/json");
  res.end(JSON.stringify(info));
});
router.get("/ciudades/id/:id", async (req, res) => {
  const info = await dataDb.findCityById(req.params.id);
  res.setHeader("Content-Type", "application/json");
  res.end(JSON.stringify(info));
});
router.get("/cursos", async (req, res) => {
  const info = await dataDb.getAllCourses();
  res.setHeader("Content-Type", "application/json");
  res.end(JSON.stringify(info));
});
router.get("/cursos/id/:id", async (req, res) => {
  const info = await dataDb.findCourseById(req.params.id);
  res.setHeader("Content-Type", "application/json");
  res.end(JSON.stringify(info));
});
router.get("/cursos/nombre/:name", async (req, res) => {
  const info = await dataDb.findCourseByName(req.params.name);
  res.setHeader("Content-Type", "application/json");
  res.end(JSON.stringify(info));
});
module.exports = router;
