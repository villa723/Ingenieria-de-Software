const BaseRepository = require("./base.repository");

class LoginRepository extends BaseRepository {
  constructor(LoginDb) {
    super(LoginDb);
  }
  async getAllWithoutPagination() {
    return await this.model.find();
  }

  async authenticate(email , password) {
    return await this.model.authenticate(email , password);
  }
}

module.exports = LoginRepository
