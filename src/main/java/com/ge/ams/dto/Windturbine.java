
package com.ge.ams.dto;

import java.util.LinkedHashMap;
import javax.annotation.Generated;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;


/**
 * Windturbine
 * <p>
 * Wind Turbine flat model with hybrid elements 
 * 
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@Generated("org.jsonschema2pojo")
@JsonPropertyOrder({
    "uri",
    "name",
    "model",
    "parent",
    "manufacture",
    "obsolete",
    "frequency",
    "power",
    "towerType",
    "rotorDiameter",
    "hubHeight",
    "nacelle",
    "bladeType",
    "ratedWindSpeed",
    "certification",
    "signature",
    "location"
})
public class Windturbine {

    /**
     * System generated uri which can uniquely identify Wind Turbine
     * 
     */
    @JsonProperty("uri")
    private java.lang.String uri;
    /**
     * Wind Turbine name
     * 
     */
    @JsonProperty("name")
    private java.lang.String name;
    /**
     * Description for the domain object - Wind Turbine
     * 
     */
    @JsonProperty("model")
    private java.lang.String model;
    /**
     * wind farm reference
     * 
     */
    @JsonProperty("parent")
    private java.lang.String parent;
    /**
     * wind turbine manufacture
     * 
     */
    @JsonProperty("manufacture")
    private java.lang.String manufacture;
    /**
     * Obsolete/non-obsolete Asset
     * (Required)
     * 
     */
    @JsonProperty("obsolete")
    private Boolean obsolete = false;
    /**
     * frequency
     * 
     */
    @JsonProperty("frequency")
    private java.lang.String frequency;
    /**
     * tower model
     * 
     */
    @JsonProperty("power")
    private java.lang.String power;
    /**
     * tower model type
     * 
     */
    @JsonProperty("towerType")
    private java.lang.String towerType;
    /**
     * Rotor Diameter
     * 
     */
    @JsonProperty("rotorDiameter")
    private Double rotorDiameter;
    /**
     * Height of hub
     * 
     */
    @JsonProperty("hubHeight")
    private Double hubHeight;
    /**
     * uri -  including the generator, gearbox, drive train, and brake assembly
     * 
     */
    @JsonProperty("nacelle")
    private java.lang.String nacelle;
    /**
     * Blade(s) Type
     * 
     */
    @JsonProperty("bladeType")
    private java.lang.String bladeType;
    /**
     * Rated Wind Speed
     * 
     */
    @JsonProperty("ratedWindSpeed")
    private java.lang.String ratedWindSpeed;
    /**
     * Certification
     * 
     */
    @JsonProperty("certification")
    private java.lang.String certification;
    /**
     * Signature
     * 
     */
    @JsonProperty("signature")
    private java.lang.String signature;
    /**
     * map contains lat and long
     * 
     */
    @JsonProperty("location")
    private LinkedHashMap<String,  Double> location;

    /**
     * System generated uri which can uniquely identify Wind Turbine
     * 
     */
    @JsonProperty("uri")
    public java.lang.String getUri() {
        return uri;
    }

    /**
     * System generated uri which can uniquely identify Wind Turbine
     * 
     */
    @JsonProperty("uri")
    public void setUri(java.lang.String uri) {
        this.uri = uri;
    }

    /**
     * Wind Turbine name
     * 
     */
    @JsonProperty("name")
    public java.lang.String getName() {
        return name;
    }

    /**
     * Wind Turbine name
     * 
     */
    @JsonProperty("name")
    public void setName(java.lang.String name) {
        this.name = name;
    }

    /**
     * Description for the domain object - Wind Turbine
     * 
     */
    @JsonProperty("model")
    public java.lang.String getModel() {
        return model;
    }

    /**
     * Description for the domain object - Wind Turbine
     * 
     */
    @JsonProperty("model")
    public void setModel(java.lang.String model) {
        this.model = model;
    }

    /**
     * wind farm reference
     * 
     */
    @JsonProperty("parent")
    public java.lang.String getParent() {
        return parent;
    }

    /**
     * wind farm reference
     * 
     */
    @JsonProperty("parent")
    public void setParent(java.lang.String parent) {
        this.parent = parent;
    }

    /**
     * wind turbine manufacture
     * 
     */
    @JsonProperty("manufacture")
    public java.lang.String getManufacture() {
        return manufacture;
    }

    /**
     * wind turbine manufacture
     * 
     */
    @JsonProperty("manufacture")
    public void setManufacture(java.lang.String manufacture) {
        this.manufacture = manufacture;
    }

    /**
     * Obsolete/non-obsolete Asset
     * (Required)
     * 
     */
    @JsonProperty("obsolete")
    public Boolean getObsolete() {
        return obsolete;
    }

    /**
     * Obsolete/non-obsolete Asset
     * (Required)
     * 
     */
    @JsonProperty("obsolete")
    public void setObsolete(Boolean obsolete) {
        this.obsolete = obsolete;
    }

    /**
     * frequency
     * 
     */
    @JsonProperty("frequency")
    public java.lang.String getFrequency() {
        return frequency;
    }

    /**
     * frequency
     * 
     */
    @JsonProperty("frequency")
    public void setFrequency(java.lang.String frequency) {
        this.frequency = frequency;
    }

    /**
     * tower model
     * 
     */
    @JsonProperty("power")
    public java.lang.String getPower() {
        return power;
    }

    /**
     * tower model
     * 
     */
    @JsonProperty("power")
    public void setPower(java.lang.String power) {
        this.power = power;
    }

    /**
     * tower model type
     * 
     */
    @JsonProperty("towerType")
    public java.lang.String getTowerType() {
        return towerType;
    }

    /**
     * tower model type
     * 
     */
    @JsonProperty("towerType")
    public void setTowerType(java.lang.String towerType) {
        this.towerType = towerType;
    }

    /**
     * Rotor Diameter
     * 
     */
    @JsonProperty("rotorDiameter")
    public Double getRotorDiameter() {
        return rotorDiameter;
    }

    /**
     * Rotor Diameter
     * 
     */
    @JsonProperty("rotorDiameter")
    public void setRotorDiameter(Double rotorDiameter) {
        this.rotorDiameter = rotorDiameter;
    }

    /**
     * Height of hub
     * 
     */
    @JsonProperty("hubHeight")
    public Double getHubHeight() {
        return hubHeight;
    }

    /**
     * Height of hub
     * 
     */
    @JsonProperty("hubHeight")
    public void setHubHeight(Double hubHeight) {
        this.hubHeight = hubHeight;
    }

    /**
     * uri -  including the generator, gearbox, drive train, and brake assembly
     * 
     */
    @JsonProperty("nacelle")
    public java.lang.String getNacelle() {
        return nacelle;
    }

    /**
     * uri -  including the generator, gearbox, drive train, and brake assembly
     * 
     */
    @JsonProperty("nacelle")
    public void setNacelle(java.lang.String nacelle) {
        this.nacelle = nacelle;
    }

    /**
     * Blade(s) Type
     * 
     */
    @JsonProperty("bladeType")
    public java.lang.String getBladeType() {
        return bladeType;
    }

    /**
     * Blade(s) Type
     * 
     */
    @JsonProperty("bladeType")
    public void setBladeType(java.lang.String bladeType) {
        this.bladeType = bladeType;
    }

    /**
     * Rated Wind Speed
     * 
     */
    @JsonProperty("ratedWindSpeed")
    public java.lang.String getRatedWindSpeed() {
        return ratedWindSpeed;
    }

    /**
     * Rated Wind Speed
     * 
     */
    @JsonProperty("ratedWindSpeed")
    public void setRatedWindSpeed(java.lang.String ratedWindSpeed) {
        this.ratedWindSpeed = ratedWindSpeed;
    }

    /**
     * Certification
     * 
     */
    @JsonProperty("certification")
    public java.lang.String getCertification() {
        return certification;
    }

    /**
     * Certification
     * 
     */
    @JsonProperty("certification")
    public void setCertification(java.lang.String certification) {
        this.certification = certification;
    }

    /**
     * Signature
     * 
     */
    @JsonProperty("signature")
    public java.lang.String getSignature() {
        return signature;
    }

    /**
     * Signature
     * 
     */
    @JsonProperty("signature")
    public void setSignature(java.lang.String signature) {
        this.signature = signature;
    }

    /**
     * map contains lat and long
     * 
     */
    @JsonProperty("location")
    public LinkedHashMap<String,  Double> getLocation() {
        return location;
    }

    /**
     * map contains lat and long
     * 
     */
    @JsonProperty("location")
    public void setLocation(LinkedHashMap<String,  Double> location) {
        this.location = location;
    }

    @Override
    public java.lang.String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    @Override
    public int hashCode() {
        return HashCodeBuilder.reflectionHashCode(this);
    }

    @Override
    public boolean equals(Object other) {
        return EqualsBuilder.reflectionEquals(this, other);
    }

}
