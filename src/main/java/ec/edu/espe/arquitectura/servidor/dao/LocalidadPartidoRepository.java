package ec.edu.espe.arquitectura.servidor.dao;

import ec.edu.espe.arquitectura.servidor.model.LocalidadPartido;
import ec.edu.espe.arquitectura.servidor.model.PartidoFutbol;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface LocalidadPartidoRepository extends JpaRepository<LocalidadPartido,String> {

    List<LocalidadPartido> findByDisponibilidadGreaterThan(Integer numero);

    Optional<LocalidadPartido> findByPartidoAndCodigoLocalidad(PartidoFutbol partidoFutbol, String localidad);
}
