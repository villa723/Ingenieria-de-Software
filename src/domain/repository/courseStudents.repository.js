const BaseRepository = require("./base.repository");

class CourseStudentsRepository extends BaseRepository {
  constructor(CourseStudentsDb) {
    super(CourseStudentsDb);
  }
  async getAllWithoutPagination() {
    return await this.model.find();
  }
}

module.exports = CourseStudentsRepository
