const BaseRepository = require("./base.repository");

class CityRepository extends BaseRepository {
  constructor(CityDb) {
    super(CityDb);
  }

  async getAllWithoutPagination() {
    return await this.model.find();
  }
}

module.exports = CityRepository

