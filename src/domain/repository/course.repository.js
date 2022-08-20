const BaseRepository = require("./base.repository");

class CourseRepository extends BaseRepository {
  constructor(CourseDb) {
    super(CourseDb);
  }

  async getAllWithoutPagination() {
    return await this.model.find();
  }

  async findByIdProfessor(id) {
    return await this.model.findByIdProfessor(id);
  }
}

module.exports = CourseRepository

