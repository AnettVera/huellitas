package mx.edu.utez.IntJosX.model.dto;


import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class EntrenamientoDto {

    private Integer id_e;

    private String horario;

    private Integer id_mascota;

    private Integer id_empleado;
}
