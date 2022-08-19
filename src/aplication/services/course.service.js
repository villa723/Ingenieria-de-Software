const BaseService = require("./base.service");

class CourseService extends BaseService {
  constructor(CourseRepository) {
    super(CourseRepository);
    this._CourseRepository = CourseRepository;
  }

}

module.exports = CourseService;