package mx.edu.utez.IntJosX.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
@Table(name = "person")
public class PersonBean {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "name", nullable = false)
    private String nombre;

    @Column(name = "ape1", nullable = false)
    private String ape1;

    @Column(name = "ap2", nullable = false)
    private String ape2;

    @Column(name = "mail", nullable = false)
    private String mail;

    @Column(name = "tel", nullable = false, length = 10)
    private long tel;

    @Column(name = "rol", length = 8)
    private String rol;


    @OneToOne(mappedBy = "personBean", cascade =CascadeType.ALL )
    @JsonIgnore
    private EmpleadoBean empleadoBean;


    @OneToOne(mappedBy = "personBean", cascade= CascadeType.ALL)
    @JsonIgnore
    private ClienteBean clienteBean;

}
