package mx.edu.utez.IntJosX.model.dto;


import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class PersonDto {

    private Integer id;

    private String nombre;

    private  String ape1;

    private String ape2;

    private String mail;

    private long tel;

    private String rol;
}
