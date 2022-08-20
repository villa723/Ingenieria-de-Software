const BaseService = require("./base.service");

class InscriptionService extends BaseService {
  constructor(InscriptionRepository) {
    super(InscriptionRepository);
    this._InscriptionRepository = InscriptionRepository;
  }
}

module.exports = InscriptionService;