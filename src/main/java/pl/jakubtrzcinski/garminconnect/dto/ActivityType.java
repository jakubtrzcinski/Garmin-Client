
package pl.jakubtrzcinski.garminconnect.dto;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
class ActivityType implements Serializable
{

    @SerializedName("typeId")
    @Expose
    private int typeId;
    @SerializedName("typeKey")
    @Expose
    private String typeKey;
    @SerializedName("parentTypeId")
    @Expose
    private int parentTypeId;
    @SerializedName("sortOrder")
    @Expose
    private int sortOrder;
    @SerializedName("isHidden")
    @Expose
    private boolean isHidden;
    private final static long serialVersionUID = -4411530336774141254L;

}
