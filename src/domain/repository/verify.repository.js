const BaseRepository = require("./base.repository");

class VerifyRepository extends BaseRepository {
  constructor(VerifyDb) {
    super(VerifyDb);
  }

  async getAllWithoutPagination() {
    return await this.model.find();
  }
}

module.exports = VerifyRepository

