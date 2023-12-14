package mx.edu.utez.IntJosX.service;

import mx.edu.utez.IntJosX.model.dto.MascotaDto;
import mx.edu.utez.IntJosX.model.entity.MascotaBean;

import java.util.List;

public interface IMascota {

    MascotaBean save(MascotaDto mascota);

    MascotaBean findById(Integer id_mascota);

    List<MascotaBean> findAll();

    void delete(MascotaBean mascota);
}
