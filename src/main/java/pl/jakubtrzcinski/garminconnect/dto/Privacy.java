
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
class Privacy implements Serializable
{

    @SerializedName("typeId")
    @Expose
    private int typeId;
    @SerializedName("typeKey")
    @Expose
    private String typeKey;
    private final static long serialVersionUID = 2033216142226189150L;

}
