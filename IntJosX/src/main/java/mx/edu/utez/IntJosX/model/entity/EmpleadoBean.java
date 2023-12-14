package mx.edu.utez.IntJosX.model.entity;


import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
@Table(name = "empleado")
public class EmpleadoBean {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_e")
    private Integer id_e;

    @Column(name = "turno")
    private String turno;

    @Column(name = "salario")
    private double salario;

    @Column(name = "nombre")
    private String nombre;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "person_id")
    private PersonBean personBean;

    @OneToMany(fetch = FetchType.LAZY, cascade =CascadeType.ALL, mappedBy = "empleadoBean")
    private Set<EntrenamientoBean> entrenamientos= new HashSet<>();

}
