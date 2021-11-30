package ec.edu.espe.arquitectura.servidor.dao;

import ec.edu.espe.arquitectura.servidor.model.PartidoFutbol;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.List;

public interface PartidoFutbolRepository extends JpaRepository<PartidoFutbol,Integer> {

    List<PartidoFutbol> findByFechaAfter(Date fechaActual);
}
