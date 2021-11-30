package ec.edu.espe.arquitectura.servidor.controller;

import ec.edu.espe.arquitectura.servidor.prueba.*;
import ec.edu.espe.arquitectura.servidor.service.PartidoFutbolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import javax.xml.datatype.DatatypeConfigurationException;
import java.util.List;

@Endpoint
public class PartidoFutbolController {

    private static final String NAMESPACE_URI = "http://arquitectura.espe.edu.ec/servidor/prueba";

    @Autowired
    private PartidoFutbolService partidoFutbolService;

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "partidosDisponiblesRequest")
    @ResponsePayload
    public PartidosDisponiblesResponse partidosDisponibles(@RequestPayload PartidosDisponiblesRequest request) throws DatatypeConfigurationException {
        PartidosDisponiblesResponse response = new PartidosDisponiblesResponse();
        List<PartidoRS> partidoRSList = this.partidoFutbolService.partidosDisponibles();
        for (PartidoRS partidoRS : partidoRSList){
            response.getPartidoRS().add(partidoRS);
        }

        return response;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "localidadDisponibleRequest")
    @ResponsePayload
    public LocalidadDisponibleResponse partidosDisponibles(@RequestPayload LocalidadDisponibleRequest request) throws DatatypeConfigurationException {
        LocalidadDisponibleResponse response = new LocalidadDisponibleResponse();
        List<LocalidadRS> localidadRSList = this.partidoFutbolService.localidadesDisponibles();
        for (LocalidadRS localidadRS : localidadRSList){
            response.getLocalidadRS().add(localidadRS);
        }
        return response;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "comprarBoletoRequest")
    @ResponsePayload
    public ComprarBoletoResponse comprarBoleto(@RequestPayload ComprarBoletoRequest request) throws Exception {
        ComprarBoletoResponse response = new ComprarBoletoResponse();
        try {
            this.partidoFutbolService.comprarBoleto(request.getCodPartido().intValue(),request.getCodLocalidad());
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
        return response;
    }
}
