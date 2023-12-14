package mx.edu.utez.IntJosX.model.dao;

import mx.edu.utez.IntJosX.model.entity.MascotaBean;
import org.springframework.data.repository.CrudRepository;

public interface MascotaDao extends CrudRepository<MascotaBean, Integer> {
}
