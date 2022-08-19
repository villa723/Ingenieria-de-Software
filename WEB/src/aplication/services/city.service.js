const BaseService = require("./base.service");

class CityService extends BaseService {
  constructor(CityRepository) {
    super(CityRepository);
    this._cityRepository = CityRepository;
  }
  //async getAllCities
}

module.exports = CityService;