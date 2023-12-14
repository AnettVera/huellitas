package mx.edu.utez.IntJosX.service;

import mx.edu.utez.IntJosX.model.dto.EntrenamientoDto;
import mx.edu.utez.IntJosX.model.entity.EntrenamientoBean;

import java.util.List;

public interface IEntrenamiento {

    EntrenamientoBean save(EntrenamientoDto entrenamientoDto);

    EntrenamientoBean findById(Integer id);

    List<EntrenamientoBean> findAll();

    void delete(EntrenamientoBean entrenamientoBean);
}
