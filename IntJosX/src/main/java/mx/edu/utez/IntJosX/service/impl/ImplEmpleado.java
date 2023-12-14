package mx.edu.utez.IntJosX.service.impl;

import lombok.AllArgsConstructor;
import mx.edu.utez.IntJosX.model.dao.EmpleadoDao;
import mx.edu.utez.IntJosX.model.dao.PersonDao;
import mx.edu.utez.IntJosX.model.dto.EmpleadoDto;
import mx.edu.utez.IntJosX.model.entity.EmpleadoBean;
import mx.edu.utez.IntJosX.model.entity.PersonBean;
import mx.edu.utez.IntJosX.service.IEmpleado;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.SQLException;
import java.util.List;

@Service
@AllArgsConstructor
public class ImplEmpleado implements IEmpleado {
    private final PersonDao personDao;
    private final EmpleadoDao empleadoDao;

    @Override
    @Transactional(rollbackFor = {SQLException.class})
    public EmpleadoBean save(EmpleadoDto empleadoDto){
       EmpleadoBean empleado= EmpleadoBean.builder()
               .id_e(empleadoDto.getId_e())
               .turno(empleadoDto.getTurno())
               .salario(empleadoDto.getSalario())
               .nombre(empleadoDto.getNombre())
               .personBean(null)
               .build();

       return empleadoDao.save(empleado);
    }

    @Override
    @Transactional(readOnly = true)
    public List<EmpleadoBean>findAll(){
        return (List<EmpleadoBean>) empleadoDao.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public EmpleadoBean findById(Integer id_e){
        return  empleadoDao.findById(id_e).orElse(null);
    }

    @Override
    @Transactional
    public void delete(EmpleadoBean empleado){

        empleadoDao.delete(empleado);
    }
}
