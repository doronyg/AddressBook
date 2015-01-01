
package com.example.yakovlev_golani.addressbook.models;

import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.orm.SugarRecord;

@Generated("org.jsonschema2pojo")
public class Name extends SugarRecord<Name> implements Comparable<Name>{

    @Expose
    private String title;
    @Expose
    private String first;
    @Expose
    private String last;

    public Name(){}

    /**
     * 
     * @return
     *     The title
     */
    public String getTitle() {
        return title;
    }

    /**
     * 
     * @param title
     *     The title
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * 
     * @return
     *     The first
     */
    public String getFirst() {
        return first;
    }

    /**
     * 
     * @param first
     *     The first
     */
    public void setFirst(String first) {
        this.first = first;
    }

    /**
     * 
     * @return
     *     The last
     */
    public String getLast() {
        return last;
    }

    /**
     * 
     * @param last
     *     The last
     */
    public void setLast(String last) {
        this.last = last;
    }

    @Override
    public int compareTo(Name another) {
        int retVal = 0;
        if (another == null){
            return 1;
        }

        if (first == null){
            if (another.getFirst() == null){
                return 0;
            }
            return -1;
        } else {
            retVal = first.compareTo(another.getFirst());
            if (retVal == 0){
                if (last == null){
                    if (another.getLast() == null){
                        return 0;
                    }
                    return -1;
                }
                retVal = last.compareTo(another.getLast());
            }
        }
        return retVal;
    }
}
