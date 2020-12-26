
package pl.jakubtrzcinski.garminconnect.dto;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
class SummarizedDiveInfo implements Serializable
{

    @SerializedName("weight")
    @Expose
    private Object weight;
    @SerializedName("weightUnit")
    @Expose
    private Object weightUnit;
    @SerializedName("visibility")
    @Expose
    private Object visibility;
    @SerializedName("visibilityUnit")
    @Expose
    private Object visibilityUnit;
    @SerializedName("surfaceCondition")
    @Expose
    private Object surfaceCondition;
    @SerializedName("current")
    @Expose
    private Object current;
    @SerializedName("waterType")
    @Expose
    private Object waterType;
    @SerializedName("waterDensity")
    @Expose
    private Object waterDensity;
    @SerializedName("summarizedDiveGases")
    @Expose
    private List<Object> summarizedDiveGases = new ArrayList<Object>();
    @SerializedName("totalSurfaceTime")
    @Expose
    private Object totalSurfaceTime;
    private final static long serialVersionUID = 1263914134963513261L;

}
