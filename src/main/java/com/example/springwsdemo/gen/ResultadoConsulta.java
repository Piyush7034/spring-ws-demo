
package com.example.springwsdemo.gen;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlType;


/**
 * <p>Java class for resultadoConsulta complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="resultadoConsulta"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="coResultado" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="deResultado" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="datosPersona" type="{http://endpoint.wsconsultadni.reniec.gob.pe/}datosPersona" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "resultadoConsulta", propOrder = {
    "coResultado",
    "deResultado",
    "datosPersona"
})
public class ResultadoConsulta {

    protected String coResultado;
    protected String deResultado;
    protected DatosPersona datosPersona;

    /**
     * Gets the value of the coResultado property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCoResultado() {
        return coResultado;
    }

    /**
     * Sets the value of the coResultado property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCoResultado(String value) {
        this.coResultado = value;
    }

    /**
     * Gets the value of the deResultado property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDeResultado() {
        return deResultado;
    }

    /**
     * Sets the value of the deResultado property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDeResultado(String value) {
        this.deResultado = value;
    }

    /**
     * Gets the value of the datosPersona property.
     * 
     * @return
     *     possible object is
     *     {@link DatosPersona }
     *     
     */
    public DatosPersona getDatosPersona() {
        return datosPersona;
    }

    /**
     * Sets the value of the datosPersona property.
     * 
     * @param value
     *     allowed object is
     *     {@link DatosPersona }
     *     
     */
    public void setDatosPersona(DatosPersona value) {
        this.datosPersona = value;
    }

}
