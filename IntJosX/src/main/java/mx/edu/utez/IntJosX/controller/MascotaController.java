package mx.edu.utez.IntJosX.controller;


import lombok.AllArgsConstructor;
import mx.edu.utez.IntJosX.model.dto.MascotaDto;
import mx.edu.utez.IntJosX.model.entity.MascotaBean;
import mx.edu.utez.IntJosX.service.impl.ImplMascota;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@AllArgsConstructor
@RestController
@RequestMapping("api/v1/mascota")
public class MascotaController {

    private final ImplMascota mascotaService;

    @GetMapping("/")
    public List<MascotaBean>getMascotas(){
        return mascotaService.findAll();
    }

    @GetMapping("/{id_mascota}")
    public MascotaBean showById(@PathVariable Integer id_mascota){
        return mascotaService.findById(id_mascota);
    }

    @PostMapping("/")
    public ResponseEntity<?> create(@RequestBody MascotaDto mascotaDto){
        Map<String, Object> response= new HashMap<>();
        try {
            MascotaBean mascotaSave= mascotaService.save(mascotaDto);
            response.put("mensaje","Mascota registrada");
            response.put("Mascota", mascotaSave);
            return new ResponseEntity<>(response, HttpStatus.OK);
        }catch (Exception e){
            response.put("mensaje", "Error al registrar la mascota");
            response.put("Mascota",null);
            response.put("error", e.getMessage());
            return  new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    @PutMapping("/")
    public MascotaDto update(@RequestBody MascotaDto mascotaDto){
        MascotaBean mascotaUpdate=mascotaService.save(mascotaDto);
        return MascotaDto.builder()
                .id_mascota(mascotaUpdate.getId_mascota())
                .edad(mascotaUpdate.getEdad())
                .size(mascotaUpdate.getSize())
                .raza(mascotaUpdate.getRaza())
                .peso(mascotaUpdate.getPeso())
                .nombre(mascotaUpdate.getNombre())
                .build();
    }

    @DeleteMapping("/{id_mascota}")
    public void delete(@PathVariable Integer id_mascota){
        MascotaBean mascota=mascotaService.findById(id_mascota);
        mascotaService.delete(mascota);
    }
}
