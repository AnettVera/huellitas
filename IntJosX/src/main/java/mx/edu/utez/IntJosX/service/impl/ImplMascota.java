package mx.edu.utez.IntJosX.service.impl;


import lombok.AllArgsConstructor;
import mx.edu.utez.IntJosX.model.dao.ClienteDao;
import mx.edu.utez.IntJosX.model.dao.MascotaDao;
import mx.edu.utez.IntJosX.model.dto.MascotaDto;
import mx.edu.utez.IntJosX.model.entity.ClienteBean;
import mx.edu.utez.IntJosX.model.entity.MascotaBean;
import mx.edu.utez.IntJosX.service.IMascota;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.SQLException;
import java.util.List;

@Service
@AllArgsConstructor
public class ImplMascota implements IMascota {
    private final MascotaDao mascotaDao;
    private final ClienteDao clienteDao;

    @Override
    @Transactional(rollbackFor = {SQLException.class})
    public MascotaBean save(MascotaDto mascotaDto){
        ClienteBean clienteBean= clienteDao.findById(mascotaDto.getId_cliente()).orElse(null);
        MascotaBean mascota=MascotaBean.builder()
                .id_mascota(mascotaDto.getId_mascota())
                .raza(mascotaDto.getRaza())
                .size(mascotaDto.getSize())
                .peso(mascotaDto.getPeso())
                .edad(mascotaDto.getEdad())
                .nombre(mascotaDto.getNombre())
                .clienteBean(clienteBean)
                .build();
        return mascotaDao.save(mascota);
    }


    @Override
    @Transactional(readOnly = true)
    public List<MascotaBean>findAll(){
        return (List<MascotaBean>) mascotaDao.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public MascotaBean findById(Integer id_mascota){
        return  mascotaDao.findById(id_mascota).orElse(null);
    }

    @Override
    @Transactional
    public void delete(MascotaBean mascota){
        mascotaDao.delete(mascota);
    }

}
