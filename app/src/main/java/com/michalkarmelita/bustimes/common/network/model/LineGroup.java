
package com.michalkarmelita.bustimes.common.network.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class LineGroup {

    @SerializedName("$type")
    @Expose
    private String $type;
    @SerializedName("naptanIdReference")
    @Expose
    private String naptanIdReference;
    @SerializedName("stationAtcoCode")
    @Expose
    private String stationAtcoCode;
    @SerializedName("lineIdentifier")
    @Expose
    private List<String> lineIdentifier = new ArrayList<String>();

    /**
     * @return The $type
     */
    public String get$type() {
        return $type;
    }

    /**
     * @param $type The $type
     */
    public void set$type(String $type) {
        this.$type = $type;
    }

    /**
     * @return The naptanIdReference
     */
    public String getNaptanIdReference() {
        return naptanIdReference;
    }

    /**
     * @param naptanIdReference The naptanIdReference
     */
    public void setNaptanIdReference(String naptanIdReference) {
        this.naptanIdReference = naptanIdReference;
    }

    /**
     * @return The stationAtcoCode
     */
    public String getStationAtcoCode() {
        return stationAtcoCode;
    }

    /**
     * @param stationAtcoCode The stationAtcoCode
     */
    public void setStationAtcoCode(String stationAtcoCode) {
        this.stationAtcoCode = stationAtcoCode;
    }

    /**
     * @return The lineIdentifier
     */
    public List<String> getLineIdentifier() {
        return lineIdentifier;
    }

    /**
     * @param lineIdentifier The lineIdentifier
     */
    public void setLineIdentifier(List<String> lineIdentifier) {
        this.lineIdentifier = lineIdentifier;
    }

}
