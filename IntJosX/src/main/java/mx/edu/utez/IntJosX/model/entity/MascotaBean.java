package mx.edu.utez.IntJosX.model.entity;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "mascota")
public class MascotaBean {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_mascota", nullable = false)
    private Integer id_mascota;
    @Column(name = "nombre", nullable = false)
    private String nombre;
    @Column(name = "raza", nullable = false)
    private String raza;
    @Column(name = "size", nullable = false)
    private double size;
    @Column(name = "edad", nullable = false, length = 2)
    private double edad;
    @Column(name = "peso", nullable = false)
    private double peso;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cliente_id")
    @JsonIgnoreProperties({"mascotas"})
    private ClienteBean clienteBean;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "mascotaBean")
    private Set<EntrenamientoBean> entrenamientos= new HashSet<>();
}
