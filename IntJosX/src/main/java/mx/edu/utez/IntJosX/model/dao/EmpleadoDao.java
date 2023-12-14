package mx.edu.utez.IntJosX.model.dao;

import mx.edu.utez.IntJosX.model.entity.EmpleadoBean;
import org.springframework.data.repository.CrudRepository;

public interface EmpleadoDao extends CrudRepository<EmpleadoBean, Integer> {
}
