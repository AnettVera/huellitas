package mx.edu.utez.IntJosX.service.impl;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import mx.edu.utez.IntJosX.model.dao.EmpleadoDao;
import mx.edu.utez.IntJosX.model.dao.EntrenamientoDao;
import mx.edu.utez.IntJosX.model.dao.MascotaDao;
import mx.edu.utez.IntJosX.model.dto.EntrenamientoDto;
import mx.edu.utez.IntJosX.model.entity.EmpleadoBean;
import mx.edu.utez.IntJosX.model.entity.EntrenamientoBean;
import mx.edu.utez.IntJosX.model.entity.MascotaBean;
import mx.edu.utez.IntJosX.service.IEntrenamiento;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.SQLException;
import java.util.List;

@Service
@AllArgsConstructor
@JsonIgnoreProperties({"mascotaBean"})
public class ImplEntrenamiento implements IEntrenamiento {

    private final EntrenamientoDao entrenamientoDao;

    private final MascotaDao mascotaDao;

    private final EmpleadoDao empleadoDao;

    @Override
    @Transactional(rollbackFor = {SQLException.class})
    public EntrenamientoBean save(EntrenamientoDto entrenamientoDto){
        EmpleadoBean empleadoBean= empleadoDao.findById(entrenamientoDto.getId_empleado()).orElse(null);
        MascotaBean mascotaBean= mascotaDao.findById(entrenamientoDto.getId_mascota()).orElse(null);
        EntrenamientoBean entrenamiento= EntrenamientoBean.builder()
                .id_en(entrenamientoDto.getId_e())
                .horario(entrenamientoDto.getHorario())
                .empleadoBean(empleadoBean)
                .mascotaBean(mascotaBean)
                .build();
        return entrenamientoDao.save(entrenamiento);
    }

    @Override
    public EntrenamientoBean findById(Integer id){
        return entrenamientoDao.findById(id).orElse(null);
    }

    @Override
    @Transactional(readOnly = true)
    public List<EntrenamientoBean>findAll(){
        return (List<EntrenamientoBean>) entrenamientoDao.findAll();
    }

    @Override
    @Transactional
    public void delete(EntrenamientoBean entrenamiento){
        entrenamientoDao.delete(entrenamiento);
    }

}
