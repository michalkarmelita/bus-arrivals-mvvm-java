
package com.michalkarmelita.bustimes.common.network.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class StopPoint {

    @SerializedName("$type")
    @Expose
    private String $type;
    @SerializedName("naptanId")
    @Expose
    private String naptanId;
    @SerializedName("indicator")
    @Expose
    private String indicator;
    @SerializedName("stopLetter")
    @Expose
    private String stopLetter;
    @SerializedName("modes")
    @Expose
    private List<String> modes = new ArrayList<String>();
    @SerializedName("icsCode")
    @Expose
    private String icsCode;
    @SerializedName("stopType")
    @Expose
    private String stopType;
    @SerializedName("stationNaptan")
    @Expose
    private String stationNaptan;
    @SerializedName("hubNaptanCode")
    @Expose
    private String hubNaptanCode;
    @SerializedName("lines")
    @Expose
    private List<Line> lines = new ArrayList<>();
    @SerializedName("lineGroup")
    @Expose
    private List<LineGroup> lineGroup = new ArrayList<>();
    @SerializedName("lineModeGroups")
    @Expose
    private List<LineModeGroup> lineModeGroups = new ArrayList<>();
    @SerializedName("status")
    @Expose
    private Boolean status;
    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("commonName")
    @Expose
    private String commonName;
    @SerializedName("placeType")
    @Expose
    private String placeType;
    @SerializedName("additionalProperties")
    @Expose
    private List<AdditionalProperty> additionalProperties = new ArrayList<AdditionalProperty>();
    @SerializedName("children")
    @Expose
    private List<Object> children = new ArrayList<Object>();
    @SerializedName("lat")
    @Expose
    private Double lat;
    @SerializedName("lon")
    @Expose
    private Double lon;

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
     * @return The naptanId
     */
    public String getNaptanId() {
        return naptanId;
    }

    /**
     * @param naptanId The naptanId
     */
    public void setNaptanId(String naptanId) {
        this.naptanId = naptanId;
    }

    /**
     * @return The indicator
     */
    public String getIndicator() {
        return indicator;
    }

    /**
     * @param indicator The indicator
     */
    public void setIndicator(String indicator) {
        this.indicator = indicator;
    }

    /**
     * @return The stopLetter
     */
    public String getStopLetter() {
        return stopLetter;
    }

    /**
     * @param stopLetter The stopLetter
     */
    public void setStopLetter(String stopLetter) {
        this.stopLetter = stopLetter;
    }

    /**
     * @return The modes
     */
    public List<String> getModes() {
        return modes;
    }

    /**
     * @param modes The modes
     */
    public void setModes(List<String> modes) {
        this.modes = modes;
    }

    /**
     * @return The icsCode
     */
    public String getIcsCode() {
        return icsCode;
    }

    /**
     * @param icsCode The icsCode
     */
    public void setIcsCode(String icsCode) {
        this.icsCode = icsCode;
    }

    /**
     * @return The stopType
     */
    public String getStopType() {
        return stopType;
    }

    /**
     * @param stopType The stopType
     */
    public void setStopType(String stopType) {
        this.stopType = stopType;
    }

    /**
     * @return The stationNaptan
     */
    public String getStationNaptan() {
        return stationNaptan;
    }

    /**
     * @param stationNaptan The stationNaptan
     */
    public void setStationNaptan(String stationNaptan) {
        this.stationNaptan = stationNaptan;
    }

    /**
     * @return The hubNaptanCode
     */
    public String getHubNaptanCode() {
        return hubNaptanCode;
    }

    /**
     * @param hubNaptanCode The hubNaptanCode
     */
    public void setHubNaptanCode(String hubNaptanCode) {
        this.hubNaptanCode = hubNaptanCode;
    }

    /**
     * @return The lines
     */
    public List<Line> getLines() {
        return lines;
    }

    /**
     * @return The lineGroup
     */
    public List<LineGroup> getLineGroup() {
        return lineGroup;
    }

    /**
     * @return The lineModeGroups
     */
    public List<LineModeGroup> getLineModeGroups() {
        return lineModeGroups;
    }

    /**
     * @return The status
     */
    public Boolean getStatus() {
        return status;
    }

    /**
     * @return The id
     */
    public String getId() {
        return id;
    }

    /**
     * @return The commonName
     */
    public String getCommonName() {
        return commonName;
    }

    /**
     * @return The placeType
     */
    public String getPlaceType() {
        return placeType;
    }

    /**
     * @return The additionalProperties
     */
    public List<AdditionalProperty> getAdditionalProperties() {
        return additionalProperties;
    }

    /**
     * @return The children
     */
    public List<Object> getChildren() {
        return children;
    }

    /**
     * @return The lat
     */
    public Double getLat() {
        return lat;
    }

    /**
     * @return The lon
     */
    public Double getLon() {
        return lon;
    }

}
