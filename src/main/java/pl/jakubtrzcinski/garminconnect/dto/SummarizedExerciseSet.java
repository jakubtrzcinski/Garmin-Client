
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
class SummarizedExerciseSet implements Serializable
{

    @SerializedName("category")
    @Expose
    private String category;
    @SerializedName("subCategory")
    @Expose
    private Object subCategory;
    @SerializedName("reps")
    @Expose
    private int reps;
    @SerializedName("volume")
    @Expose
    private int volume;
    @SerializedName("duration")
    @Expose
    private double duration;
    @SerializedName("sets")
    @Expose
    private int sets;
    private final static long serialVersionUID = 4551414132987777761L;

}
