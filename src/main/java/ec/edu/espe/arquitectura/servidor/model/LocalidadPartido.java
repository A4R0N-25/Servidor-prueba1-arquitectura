package ec.edu.espe.arquitectura.servidor.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Data
@Table(name = "Localidad_Partido", uniqueConstraints = {
        @UniqueConstraint(columnNames = {"codigo_localidad"})})
public class LocalidadPartido {

    @Id
    @Column(name = "codigo_localidad", nullable = false)
    private String codigoLocalidad;

    @Column(name = "disponibilidad", nullable = false)
    private Integer disponibilidad;

    @Column(name = "precio", nullable = false)
    private BigDecimal precio;

    @JoinColumn(name = "partido", nullable = false,insertable = false, updatable = false)
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER,optional = false)
    @JsonBackReference
    private PartidoFutbol partido;

}
