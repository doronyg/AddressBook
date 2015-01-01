
package com.example.yakovlev_golani.addressbook.models;

import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.orm.SugarRecord;

@Generated("org.jsonschema2pojo")
public class User extends SugarRecord<User> implements Comparable<User> {

    @Expose
    private Name name;
    @Expose
    private Location location;
    @Expose
    private String email;
    @Expose
    private String phone;
    @Expose
    private String cell;
    @Expose
    private Picture picture;
    @Expose
    private String version;

    public User(){
    }

    /**
     * 
     * @return
     *     The name
     */
    public Name getName() {
        return name;
    }

    /**
     * 
     * @param name
     *     The name
     */
    public void setName(Name name) {
        this.name = name;
    }

    /**
     * 
     * @return
     *     The location
     */
    public Location getLocation() {
        return location;
    }

    /**
     * 
     * @param location
     *     The location
     */
    public void setLocation(Location location) {
        this.location = location;
    }

    /**
     * 
     * @return
     *     The email
     */
    public String getEmail() {
        return email;
    }

    /**
     * 
     * @param email
     *     The email
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * 
     * @return
     *     The phone
     */
    public String getPhone() {
        return phone;
    }

    /**
     * 
     * @param phone
     *     The phone
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }

    /**
     * 
     * @return
     *     The cell
     */
    public String getCell() {
        return cell;
    }

    /**
     * 
     * @param cell
     *     The cell
     */
    public void setCell(String cell) {
        this.cell = cell;
    }

    /**
     * 
     * @return
     *     The picture
     */
    public Picture getPicture() {
        return picture;
    }

    /**
     * 
     * @param picture
     *     The picture
     */
    public void setPicture(Picture picture) {
        this.picture = picture;
    }

    @Override
    public int compareTo(User another) {
        if (another == null){
            return 1;
        }

        Name thisName = getName();
        if (thisName == null){
            return -1;
        }

        return thisName.compareTo(another.getName());
    }
}
