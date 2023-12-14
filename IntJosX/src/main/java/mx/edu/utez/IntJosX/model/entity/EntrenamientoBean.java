package mx.edu.utez.IntJosX.model.entity;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "entrenamiento")
public class EntrenamientoBean {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_en")
    private Integer id_en;
    @Column(name = "horario", nullable = false)
    private String horario;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "mascota_id")
    @JsonIgnoreProperties({"entrenamientos"})
    private MascotaBean mascotaBean;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "empleado_id")
    @JsonIgnoreProperties({"entrenamientos"})
    private EmpleadoBean empleadoBean;

}
