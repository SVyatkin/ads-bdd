
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
 * Windfarm
 * <p>
 * Wind farm
 * 
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@Generated("org.jsonschema2pojo")
@JsonPropertyOrder({
    "uri",
    "name",
    "owner",
    "location"
})
public class Windfarm {

    /**
     * System generated uri which can uniquely identify Wind Farm
     * 
     */
    @JsonProperty("uri")
    private java.lang.String uri;
    /**
     * Name
     * 
     */
    @JsonProperty("name")
    private java.lang.String name;
    /**
     * Wind farm owner
     * 
     */
    @JsonProperty("owner")
    private java.lang.String owner;
    /**
     * map contains lat and long
     * 
     */
    @JsonProperty("location")
    private LinkedHashMap<String,  Double> location;

    /**
     * System generated uri which can uniquely identify Wind Farm
     * 
     */
    @JsonProperty("uri")
    public java.lang.String getUri() {
        return uri;
    }

    /**
     * System generated uri which can uniquely identify Wind Farm
     * 
     */
    @JsonProperty("uri")
    public void setUri(java.lang.String uri) {
        this.uri = uri;
    }

    /**
     * Name
     * 
     */
    @JsonProperty("name")
    public java.lang.String getName() {
        return name;
    }

    /**
     * Name
     * 
     */
    @JsonProperty("name")
    public void setName(java.lang.String name) {
        this.name = name;
    }

    /**
     * Wind farm owner
     * 
     */
    @JsonProperty("owner")
    public java.lang.String getOwner() {
        return owner;
    }

    /**
     * Wind farm owner
     * 
     */
    @JsonProperty("owner")
    public void setOwner(java.lang.String owner) {
        this.owner = owner;
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
