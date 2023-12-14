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
@Table(name = "cliente")
public class ClienteBean {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_c")
    private Integer id_c;

    @OneToOne(cascade = CascadeType.ALL,optional = false)
    @JoinColumn(name = "person_id")
    private PersonBean personBean;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "clienteBean")
    private Set<MascotaBean> mascotas= new HashSet<>();

}
