package dao;

import java.util.List;
import domain.Worker;

 // CRUD
public interface WorkerDao {
    public Long create(Worker worker);
    Worker read(Long id);
    void update(Worker worker);
    void delete(Worker worker);
    List<Worker> findAll();
}