package ec.edu.espe.arquitectura.servidor.model;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Data
@Table(name = "Partido_Futbol", uniqueConstraints = {
        @UniqueConstraint(columnNames = {"codigo"})})
public class PartidoFutbol {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "codigo", nullable = false)
    private Integer codigo;

    @Column(name = "equipo_local", nullable = false)
    private String equipoLocal;

    @Column(name = "equipo_visita", nullable = false)
    private String equipoVisita;

    @Column(name = "fecha", nullable = false)
    private Date fecha;

    @Column(name = "lugar", nullable = false)
    private String lugar;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "partido")
    private List<LocalidadPartido> localidad;

}
