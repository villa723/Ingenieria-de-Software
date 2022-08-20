const BaseRepository = require("./base.repository");

class SectionRepository extends BaseRepository {
  constructor(SectionDb) {
    super(SectionDb);
  }

  async getAllWithoutPagination() {
    return this.model.find();
  }
}

module.exports = SectionRepository

