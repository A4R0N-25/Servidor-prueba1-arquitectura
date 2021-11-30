//
// Este archivo ha sido generado por la arquitectura JavaTM para la implantación de la referencia de enlace (JAXB) XML v2.3.2 
// Visite <a href="https://javaee.github.io/jaxb-v2/">https://javaee.github.io/jaxb-v2/</a> 
// Todas las modificaciones realizadas en este archivo se perderán si se vuelve a compilar el esquema de origen. 
// Generado el: 2021.11.29 a las 09:21:46 PM COT 
//


package ec.edu.espe.arquitectura.servidor.prueba;

import java.math.BigInteger;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para anonymous complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="codPartido" type="{http://www.w3.org/2001/XMLSchema}integer"/&gt;
 *         &lt;element name="codLocalidad" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "codPartido",
    "codLocalidad"
})
@XmlRootElement(name = "comprarBoletoRequest")
public class ComprarBoletoRequest {

    @XmlElement(required = true)
    protected BigInteger codPartido;
    @XmlElement(required = true)
    protected String codLocalidad;

    /**
     * Obtiene el valor de la propiedad codPartido.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getCodPartido() {
        return codPartido;
    }

    /**
     * Define el valor de la propiedad codPartido.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setCodPartido(BigInteger value) {
        this.codPartido = value;
    }

    /**
     * Obtiene el valor de la propiedad codLocalidad.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCodLocalidad() {
        return codLocalidad;
    }

    /**
     * Define el valor de la propiedad codLocalidad.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCodLocalidad(String value) {
        this.codLocalidad = value;
    }

}
