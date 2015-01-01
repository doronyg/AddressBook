
package com.example.yakovlev_golani.addressbook.models;

import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.orm.SugarRecord;

@Generated("org.jsonschema2pojo")
public class Picture extends SugarRecord<Picture> {

    @Expose
    private String large;
    @Expose
    private String medium;
    @Expose
    private String thumbnail;

    public Picture(){}

    /**
     * 
     * @return
     *     The large
     */
    public String getLarge() {
        return large;
    }

    /**
     * 
     * @param large
     *     The large
     */
    public void setLarge(String large) {
        this.large = large;
    }

    /**
     * 
     * @return
     *     The medium
     */
    public String getMedium() {
        return medium;
    }

    /**
     * 
     * @param medium
     *     The medium
     */
    public void setMedium(String medium) {
        this.medium = medium;
    }

    /**
     * 
     * @return
     *     The thumbnail
     */
    public String getThumbnail() {
        return thumbnail;
    }

    /**
     * 
     * @param thumbnail
     *     The thumbnail
     */
    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }

}
