const BaseRepository = require("./base.repository");

class ProfessorRepository extends BaseRepository {
  constructor(ProfessorDb) {
    super(ProfessorDb);
  }
  async getAllWithoutPagination() {
    return await this.model.find();
  }
}

module.exports = ProfessorRepository
