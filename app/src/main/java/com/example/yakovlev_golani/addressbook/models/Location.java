
package com.example.yakovlev_golani.addressbook.models;

import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.orm.SugarRecord;

@Generated("org.jsonschema2pojo")
public class Location extends SugarRecord<Location> {

    @Expose
    private String street;
    @Expose
    private String city;
    @Expose
    private String state;
    @Expose
    private String zip;

    public Location(){}

    /**
     * 
     * @return
     *     The street
     */
    public String getStreet() {
        return street;
    }

    /**
     * 
     * @param street
     *     The street
     */
    public void setStreet(String street) {
        this.street = street;
    }

    /**
     * 
     * @return
     *     The city
     */
    public String getCity() {
        return city;
    }

    /**
     * 
     * @param city
     *     The city
     */
    public void setCity(String city) {
        this.city = city;
    }

    /**
     * 
     * @return
     *     The state
     */
    public String getState() {
        return state;
    }

    /**
     * 
     * @param state
     *     The state
     */
    public void setState(String state) {
        this.state = state;
    }

    /**
     * 
     * @return
     *     The zip
     */
    public String getZip() {
        return zip;
    }

    /**
     * 
     * @param zip
     *     The zip
     */
    public void setZip(String zip) {
        this.zip = zip;
    }

}
