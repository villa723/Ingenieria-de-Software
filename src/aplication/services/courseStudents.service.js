const BaseService = require("./base.service");

class CourseStudentsService extends BaseService {
  constructor(CourseStudentsRepository) {
    super(CourseStudentsRepository);
    this._CourseStudentsRepository = CourseStudentsRepository;
  }

}

module.exports = CourseStudentsService;
