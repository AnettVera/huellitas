package mx.edu.utez.IntJosX.service;

import mx.edu.utez.IntJosX.model.dto.EmpleadoDto;
import mx.edu.utez.IntJosX.model.entity.EmpleadoBean;

import java.util.List;

public interface IEmpleado {

    EmpleadoBean save (EmpleadoDto empleado);

    EmpleadoBean findById(Integer id);

    List<EmpleadoBean> findAll();

    void delete(EmpleadoBean empleado);
}
