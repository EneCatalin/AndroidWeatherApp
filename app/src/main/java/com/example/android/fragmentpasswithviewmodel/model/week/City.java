
package com.example.android.fragmentpasswithviewmodel.model.week;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class City {

    @SerializedName("geoname_id")
    @Expose
    private Integer geonameId;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("lat")
    @Expose
    private Float lat;
    @SerializedName("lon")
    @Expose
    private Float lon;
    @SerializedName("country")
    @Expose
    private String country;
    @SerializedName("iso2")
    @Expose
    private String iso2;
    @SerializedName("type")
    @Expose
    private String type;
    @SerializedName("population")
    @Expose
    private Integer population;

    /**
     * No args constructor for use in serialization
     * 
     */
    public City() {
    }

    /**
     * 
     * @param lon
     * @param name
     * @param iso2
     * @param type
     * @param geonameId
     * @param lat
     * @param population
     * @param country
     */
    public City(Integer geonameId, String name, Float lat, Float lon, String country, String iso2, String type, Integer population) {
        super();
        this.geonameId = geonameId;
        this.name = name;
        this.lat = lat;
        this.lon = lon;
        this.country = country;
        this.iso2 = iso2;
        this.type = type;
        this.population = population;
    }

    public Integer getGeonameId() {
        return geonameId;
    }

    public void setGeonameId(Integer geonameId) {
        this.geonameId = geonameId;
    }

    public City withGeonameId(Integer geonameId) {
        this.geonameId = geonameId;
        return this;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public City withName(String name) {
        this.name = name;
        return this;
    }

    public Float getLat() {
        return lat;
    }

    public void setLat(Float lat) {
        this.lat = lat;
    }

    public City withLat(Float lat) {
        this.lat = lat;
        return this;
    }

    public Float getLon() {
        return lon;
    }

    public void setLon(Float lon) {
        this.lon = lon;
    }

    public City withLon(Float lon) {
        this.lon = lon;
        return this;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public City withCountry(String country) {
        this.country = country;
        return this;
    }

    public String getIso2() {
        return iso2;
    }

    public void setIso2(String iso2) {
        this.iso2 = iso2;
    }

    public City withIso2(String iso2) {
        this.iso2 = iso2;
        return this;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public City withType(String type) {
        this.type = type;
        return this;
    }

    public Integer getPopulation() {
        return population;
    }

    public void setPopulation(Integer population) {
        this.population = population;
    }

    public City withPopulation(Integer population) {
        this.population = population;
        return this;
    }

}
