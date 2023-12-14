package mx.edu.utez.IntJosX.model.dao;

import mx.edu.utez.IntJosX.model.entity.ClienteBean;
import org.springframework.data.repository.CrudRepository;

public interface ClienteDao extends CrudRepository<ClienteBean, Integer> {
}
