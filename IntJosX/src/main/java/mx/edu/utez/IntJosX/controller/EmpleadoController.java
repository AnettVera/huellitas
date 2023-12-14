package mx.edu.utez.IntJosX.controller;

import lombok.AllArgsConstructor;
import mx.edu.utez.IntJosX.model.dto.EmpleadoDto;
import mx.edu.utez.IntJosX.model.entity.EmpleadoBean;
import mx.edu.utez.IntJosX.service.impl.ImplEmpleado;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@AllArgsConstructor
@RestController
@RequestMapping("api/v1/empleado")
public class EmpleadoController {
    private final ImplEmpleado empleadoService;

    @GetMapping("/")
    @CrossOrigin(origins = "*", methods = {RequestMethod.GET})
    public List<EmpleadoBean> getEmpleados(){ return empleadoService.findAll(); }

    @GetMapping("/{id_empleado}")
    @CrossOrigin(origins = "*", methods = {RequestMethod.GET})
    public EmpleadoBean showById(@PathVariable Integer id_empleado){
        return empleadoService.findById(id_empleado);
    }

    @PostMapping("/")
    @CrossOrigin(origins = "*", methods = {RequestMethod.POST})
    public ResponseEntity<?> create(@RequestBody EmpleadoDto empleadoDto){
        Map<String, Object> response= new HashMap<>();
        try {
            EmpleadoBean empleadoSave= empleadoService.save(empleadoDto);
            response.put("mensaje","Empleado registrado");
            response.put("Empleado", empleadoSave);
            return new ResponseEntity<>(response, HttpStatus.OK);
        }catch (Exception e){
            response.put("mensaje", "Error al registrar el empleado");
            response.put("Empleado",null);
            response.put("error", e.getMessage());
            return  new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/")
    @CrossOrigin(origins = "*", methods = {RequestMethod.PUT})
    public EmpleadoDto update(@RequestBody EmpleadoDto empleadoDto){
        EmpleadoBean empleadoUpdate=empleadoService.save(empleadoDto);
        return EmpleadoDto.builder()
                .id_e(empleadoUpdate.getId_e())
                .turno(empleadoUpdate.getTurno())
                .salario(empleadoUpdate.getSalario())
                .nombre(empleadoUpdate.getNombre())
                .build();
    }

    @DeleteMapping("/{id_empleado}")
    @CrossOrigin(origins = "*", methods = {RequestMethod.DELETE})
    public void delete(@PathVariable Integer id_empleado){
        EmpleadoBean empleado = empleadoService.findById(id_empleado);
        empleadoService.delete(empleado);
    }
}
