
package com.example.springwsdemo.gen;

import jakarta.xml.bind.annotation.XmlRegistry;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.example.springwsdemo.gen package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {


    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.example.springwsdemo.gen
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link PeticionActualizarCredencial }
     * 
     */
    public PeticionActualizarCredencial createPeticionActualizarCredencial() {
        return new PeticionActualizarCredencial();
    }

    /**
     * Create an instance of {@link PeticionConsulta }
     * 
     */
    public PeticionConsulta createPeticionConsulta() {
        return new PeticionConsulta();
    }

    /**
     * Create an instance of {@link PeticionConsultaCertificado }
     * 
     */
    public PeticionConsultaCertificado createPeticionConsultaCertificado() {
        return new PeticionConsultaCertificado();
    }

    /**
     * Create an instance of {@link ResultadoActualizacionCredencial }
     * 
     */
    public ResultadoActualizacionCredencial createResultadoActualizacionCredencial() {
        return new ResultadoActualizacionCredencial();
    }

    /**
     * Create an instance of {@link ResultadoConsulta }
     * 
     */
    public ResultadoConsulta createResultadoConsulta() {
        return new ResultadoConsulta();
    }

    /**
     * Create an instance of {@link DatosPersona }
     * 
     */
    public DatosPersona createDatosPersona() {
        return new DatosPersona();
    }

}
