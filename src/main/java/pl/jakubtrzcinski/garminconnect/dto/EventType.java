
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
class EventType implements Serializable
{

    @SerializedName("typeId")
    @Expose
    private int typeId;
    @SerializedName("typeKey")
    @Expose
    private String typeKey;
    @SerializedName("sortOrder")
    @Expose
    private int sortOrder;
    private final static long serialVersionUID = 7428655091504477921L;

}
