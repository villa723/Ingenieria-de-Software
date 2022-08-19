var app = require('../app');
const { createContainer, asClass, asValue, asFunction } = require("awilix");
//services
const CityService = require("../aplication/services/city.service");
//routes
//models
var routes = require('./interfaces/routes');
var indexRouter = require('./interfaces/routes/index');
var usersRouter = require('./interfaces/routes/users');
var apiRouter = require('./interfaces/routes/api');

const CityModel = require("../domain/models/city.model");
//repoitoies
const CityRepository = require("../domain/repository/city.repository");

const container = createContainer();
container
  .register({ CityService: asClass(CityService).singleton() })
  .register({ indedxRouter: asfunction(indexRouter).singleton() })
  .register({ CityModel: asValue(CityModel) })
  .register({ CityRepository: asClass(CityRepository).singleton() })

module.exports = container;
  // .register({ CityRoutes: asFunction(CityRoutes).singleton() })
  //   app: asClass(app).singleton(),
  //   router: asFunction(Routes).singleton(),
  //   config: asValue(config)
  // })