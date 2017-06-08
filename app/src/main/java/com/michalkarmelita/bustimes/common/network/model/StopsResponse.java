
package com.michalkarmelita.bustimes.common.network.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class StopsResponse {

    @SerializedName("$type")
    @Expose
    private String $type;
    @SerializedName("centrePoint")
    @Expose
    private List<Double> centrePoint = new ArrayList<Double>();
    @SerializedName("stopPoints")
    @Expose
    private List<StopPoint> stopPoints = new ArrayList<StopPoint>();
    @SerializedName("pageSize")
    @Expose
    private Integer pageSize;
    @SerializedName("total")
    @Expose
    private Integer total;
    @SerializedName("page")
    @Expose
    private Integer page;

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
     * @return The centrePoint
     */
    public List<Double> getCentrePoint() {
        return centrePoint;
    }

    /**
     * @param centrePoint The centrePoint
     */
    public void setCentrePoint(List<Double> centrePoint) {
        this.centrePoint = centrePoint;
    }

    /**
     * @return The stopPoints
     */
    public List<StopPoint> getStopPoints() {
        return stopPoints;
    }

    /**
     * @param stopPoints The stopPoints
     */
    public void setStopPoints(List<StopPoint> stopPoints) {
        this.stopPoints = stopPoints;
    }

    /**
     * @return The pageSize
     */
    public Integer getPageSize() {
        return pageSize;
    }

    /**
     * @param pageSize The pageSize
     */
    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    /**
     * @return The total
     */
    public Integer getTotal() {
        return total;
    }

    /**
     * @param total The total
     */
    public void setTotal(Integer total) {
        this.total = total;
    }

    /**
     * @return The page
     */
    public Integer getPage() {
        return page;
    }

    /**
     * @param page The page
     */
    public void setPage(Integer page) {
        this.page = page;
    }

}
