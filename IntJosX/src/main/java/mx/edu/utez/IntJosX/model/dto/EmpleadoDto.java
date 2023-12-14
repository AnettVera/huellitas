package mx.edu.utez.IntJosX.model.dto;


import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class EmpleadoDto {
    private Integer id_e;
    private String turno;
    private double salario;
    private String nombre;
}
