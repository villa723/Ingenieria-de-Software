class BaseRepository {
  constructor(model) {
    this.model = model;
  }
  async get(id) {
    return await this.model.get(id);
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
  async update(entity) {
    return await this.model.update(entity);
  }
  async delete(id) {
    return await this.model.delete(id);
  }
}

module.exports = BaseRepository;