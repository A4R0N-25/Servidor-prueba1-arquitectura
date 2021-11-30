package ec.edu.espe.arquitectura.servidor.service;

import ec.edu.espe.arquitectura.servidor.dao.LocalidadPartidoRepository;
import ec.edu.espe.arquitectura.servidor.dao.PartidoFutbolRepository;
import ec.edu.espe.arquitectura.servidor.model.LocalidadPartido;
import ec.edu.espe.arquitectura.servidor.model.PartidoFutbol;
import ec.edu.espe.arquitectura.servidor.prueba.Localidad;
import ec.edu.espe.arquitectura.servidor.prueba.LocalidadRS;
import ec.edu.espe.arquitectura.servidor.prueba.Partido;
import ec.edu.espe.arquitectura.servidor.prueba.PartidoRS;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class PartidoFutbolService {

    @Autowired
    private PartidoFutbolRepository partidoFutbolRepository;
    private LocalidadPartidoRepository localidadPartidoRepository;

    public List<PartidoRS> partidosDisponibles() throws DatatypeConfigurationException {

        List<PartidoRS> partidosRS = new ArrayList<>();

        List<PartidoFutbol> partidosFutbol = this.partidoFutbolRepository.findByFechaAfter(new Date());

        for(PartidoFutbol partidoFutbol: partidosFutbol){
            PartidoRS partidoRS = new PartidoRS();
            partidoRS.setCodigo(BigInteger.valueOf(partidoFutbol.getCodigo()));
            partidoRS.setEquipoLocal(partidoFutbol.getEquipoLocal());
            partidoRS.setEquipoVisita(partidoFutbol.getEquipoVisita());
            partidoRS.setFecha(DatatypeFactory.newInstance().newXMLGregorianCalendar(partidoFutbol.getFecha().toString()));
            partidoRS.setLugar(partidoFutbol.getLugar());
            List<Localidad> localidades = transformLocalidadPartido(partidoFutbol.getLocalidad());
            for(Localidad localidad : localidades){
                partidoRS.getLocalidad().add(localidad);
            }
            partidosRS.add(partidoRS);
        }

        return partidosRS;

    }

    public List<LocalidadRS> localidadesDisponibles() throws DatatypeConfigurationException {
        List<LocalidadRS> localidadesRS = new ArrayList<>();

        List<LocalidadPartido> localidadPartidos = this.localidadPartidoRepository.findByDisponibilidadGreaterThan(0);

        for(LocalidadPartido localidadPartido: localidadPartidos){
            Partido partido = new Partido();
            partido.setCodigo(BigInteger.valueOf(localidadPartido.getPartido().getCodigo()));
            partido.setEquipoLocal(localidadPartido.getPartido().getEquipoLocal());
            partido.setEquipoVisita(localidadPartido.getPartido().getEquipoVisita());
            partido.setFecha(DatatypeFactory.newInstance().newXMLGregorianCalendar(localidadPartido.getPartido().getFecha().toString()));
            partido.setLugar(localidadPartido.getPartido().getLugar());
            LocalidadRS localidadRS = new LocalidadRS();
            localidadRS.setCodigoLocalidad(localidadPartido.getCodigoLocalidad());
            localidadRS.setDisponibilidad(BigInteger.valueOf(localidadPartido.getDisponibilidad()));
            localidadRS.setPrecio(localidadPartido.getPrecio());
            localidadRS.setPartido(partido);
            localidadesRS.add(localidadRS);
        }

        return localidadesRS;
    }

    public void comprarBoleto(Integer codigoPartido, String localidad) throws Exception {

        Optional<PartidoFutbol> optionalPartidoFutbol = this.partidoFutbolRepository.findById(codigoPartido);

        if (!optionalPartidoFutbol.isPresent()) {
            throw new Exception("No se encontro este partido");
        }

        PartidoFutbol partidoFutbol = optionalPartidoFutbol.get();

        Optional<LocalidadPartido> optionalLocalidadPartido = this.localidadPartidoRepository.findByPartidoAndCodigoLocalidad(partidoFutbol, localidad);

        if (!optionalLocalidadPartido.isPresent()) {
            throw new Exception("No se encontro la localidad");
        }

    }

    private List<Localidad> transformLocalidadPartido(List<LocalidadPartido> localidadPartidos){
        List<Localidad> localidads = new ArrayList<>();

        for(LocalidadPartido localidadPartido: localidadPartidos){
            Localidad localidad = new Localidad();
            localidad.setCodigoLocalidad(localidadPartido.getCodigoLocalidad());
            localidad.setDisponibilidad(BigInteger.valueOf(localidadPartido.getDisponibilidad()));
            localidad.setPrecio(localidadPartido.getPrecio());
            localidads.add(localidad);
        }
        return localidads;
    }
}
