package mx.edu.utez.IntJosX.model.dao;

import mx.edu.utez.IntJosX.model.entity.PersonBean;
import org.springframework.data.repository.CrudRepository;

public interface PersonDao extends CrudRepository<PersonBean, Integer> {
}
