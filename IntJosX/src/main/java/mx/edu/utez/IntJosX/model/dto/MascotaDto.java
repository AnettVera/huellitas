package mx.edu.utez.IntJosX.model.dto;

import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class MascotaDto {
    private Integer id_mascota;

    private String nombre;

    private String raza;

    private double size;

    private double edad;

    private double peso;

    private Integer id_cliente;
}
