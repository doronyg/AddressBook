
package com.example.yakovlev_golani.addressbook.models;

import javax.annotation.Generated;
import com.google.gson.annotations.Expose;

@Generated("org.jsonschema2pojo")
public class Result {

    @Expose
    private User user;
    @Expose
    private String seed;

    /**
     * 
     * @return
     *     The user
     */
    public User getUser() {
        return user;
    }

    /**
     * 
     * @param user
     *     The user
     */
    public void setUser(User user) {
        this.user = user;
    }

    /**
     * 
     * @return
     *     The seed
     */
    public String getSeed() {
        return seed;
    }

    /**
     * 
     * @param seed
     *     The seed
     */
    public void setSeed(String seed) {
        this.seed = seed;
    }

}
