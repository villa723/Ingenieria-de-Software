const BaseRepository = require("./base.repository");

class LoginRepository extends BaseRepository {
  constructor(LoginDb) {
    super(LoginDb);
  }
  async getAllWithoutPagination() {
    return await this.model.find();
  }
}

module.exports = LoginRepository
