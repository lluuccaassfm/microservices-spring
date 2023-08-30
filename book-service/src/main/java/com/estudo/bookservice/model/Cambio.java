package com.estudo.bookservice.model;




import java.io.Serializable;
import java.util.Objects;

public class Cambio implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;
    private String from;
    private String to;
    private Double conversionFactor;
    private Double convertValue;
    private String enviroment;

    public Cambio(Long id, String from, String to, Double conversionFactor, Double convertValue, String enviroment) {
        this.id = id;
        this.from = from;
        this.to = to;
        this.conversionFactor = conversionFactor;
        this.convertValue = convertValue;
        this.enviroment = enviroment;
    }

    public Cambio() { }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public Double getConversionFactor() {
        return conversionFactor;
    }

    public void setConversionFactor(Double conversionFactor) {
        this.conversionFactor = conversionFactor;
    }

    public Double getConvertValue() {
        return convertValue;
    }

    public void setConvertValue(Double convertValue) {
        this.convertValue = convertValue;
    }

    public String getEnviroment() {
        return enviroment;
    }

    public void setEnviroment(String enviroment) {
        this.enviroment = enviroment;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cambio cambio = (Cambio) o;
        return id.equals(cambio.id) && from.equals(cambio.from) && to.equals(cambio.to)
                && conversionFactor.equals(cambio.conversionFactor) && convertValue.equals(cambio.convertValue)
                && enviroment.equals(cambio.enviroment);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, from, to, conversionFactor, convertValue, enviroment);
    }
}
