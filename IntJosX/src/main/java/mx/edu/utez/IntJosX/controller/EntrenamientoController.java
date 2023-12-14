package mx.edu.utez.IntJosX.controller;

import lombok.AllArgsConstructor;
import mx.edu.utez.IntJosX.model.dto.EntrenamientoDto;
import mx.edu.utez.IntJosX.model.entity.EntrenamientoBean;
import mx.edu.utez.IntJosX.service.impl.ImplEntrenamiento;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@AllArgsConstructor
@RestController
@RequestMapping("api/v1/entrenamiento")
public class EntrenamientoController {

    private final ImplEntrenamiento eService;

    @GetMapping("/")
    public List<EntrenamientoBean>getEntrenamientos(){
        return eService.findAll();
    }

    @GetMapping("/{id}")
    public EntrenamientoBean showById(@PathVariable Integer id){
        return eService.findById(id);
    }

    @PostMapping("/")
    public ResponseEntity<?>create(@RequestBody EntrenamientoDto entrenamientoDto){
        Map<String, Object> response= new HashMap<>();
        try {
            EntrenamientoBean eSave=eService.save(entrenamientoDto);
            response.put("mensaje","Entrenamiento creado");
            response.put("entrenamiento", eSave);
            return new ResponseEntity<>(response, HttpStatus.OK);
        }catch (Exception e){
            response.put("mensaje", "Error al crear el entrenamiento");
            response.put("Entrenamiento", null);
            response.put("error", e.getMessage());
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }


    @PutMapping("/")
    public EntrenamientoDto update(@RequestBody EntrenamientoDto entrenamientoDto){
        EntrenamientoBean eUpdate= eService.save(entrenamientoDto);
        return EntrenamientoDto.builder()
                .id_e(eUpdate.getId_en())
                .horario(eUpdate.getHorario())
                .id_empleado(entrenamientoDto.getId_empleado())
                .build();

    }


    @DeleteMapping("/{id}")
    public ResponseEntity<?>delete(@PathVariable Integer id){
        Map<String,Object> response= new HashMap<>();
        try {
            EntrenamientoBean entrenamiento= eService.findById(id);
            eService.delete(entrenamiento);
            response.put("mensaje","Entrenamiento eliminado");
            return new ResponseEntity<>(response,HttpStatus.OK);
        }catch (DataAccessException e){
            response.put("mensaje", "Error al eliminar");
            response.put("Entrenamiento", null);
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
