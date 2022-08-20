const BaseRepository = require("./base.repository");

class InscriptionRepository extends BaseRepository {
  constructor(InscriptionDb) {
    super(InscriptionDb);
  }
  async getAllWithoutPagination() {
    return await this.model.find();
  }
}

module.exports = InscriptionRepository
