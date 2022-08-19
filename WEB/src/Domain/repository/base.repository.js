class BaseRepository {
  constructor(model) {
    this.model = model;
    this.model.getAll();
  }
  async get(id) {
    return await this.model.findById(id);
  }
  async getAll() {
    return await this.model.getAll();
  }
  async getByName(name) {
    return await this.model.getByName(name);
  }
  async create(entity) {
    return await this.model.create(entity);
  }
}

module.exports = BaseRepository;