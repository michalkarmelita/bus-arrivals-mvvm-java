
package com.michalkarmelita.bustimes.common.network.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class LineModeGroup {

    @SerializedName("$type")
    @Expose
    private String $type;
    @SerializedName("modeName")
    @Expose
    private String modeName;
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
     * @return The modeName
     */
    public String getModeName() {
        return modeName;
    }

    /**
     * @param modeName The modeName
     */
    public void setModeName(String modeName) {
        this.modeName = modeName;
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
