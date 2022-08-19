const BaseRepository = require("./base.repository");

class PersonRepository extends BaseRepository {
  constructor(personDb) {
    super(personDb);
  }
  async getAllWithoutPagination() {
    return await this.model.find();
  }
}

module.exports = PersonRepository

