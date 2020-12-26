
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
public class Activity implements Serializable
{

    @SerializedName("activityId")
    @Expose
    private long activityId;
    @SerializedName("activityName")
    @Expose
    private String activityName;
    @SerializedName("description")
    @Expose
    private String description;
    @SerializedName("startTimeLocal")
    @Expose
    private String startTimeLocal;
    @SerializedName("startTimeGMT")
    @Expose
    private String startTimeGMT;
    @SerializedName("activityType")
    @Expose
    private ActivityType activityType;
    @SerializedName("eventType")
    @Expose
    private EventType eventType;
    @SerializedName("comments")
    @Expose
    private Object comments;
    @SerializedName("parentId")
    @Expose
    private String parentId;
    @SerializedName("distance")
    @Expose
    private double distance;
    @SerializedName("duration")
    @Expose
    private double duration;
    @SerializedName("elapsedDuration")
    @Expose
    private double elapsedDuration;
    @SerializedName("movingDuration")
    @Expose
    private double movingDuration;
    @SerializedName("elevationGain")
    @Expose
    private double elevationGain;
    @SerializedName("elevationLoss")
    @Expose
    private double elevationLoss;
    @SerializedName("averageSpeed")
    @Expose
    private double averageSpeed;
    @SerializedName("maxSpeed")
    @Expose
    private double maxSpeed;
    @SerializedName("startLatitude")
    @Expose
    private double startLatitude;
    @SerializedName("startLongitude")
    @Expose
    private double startLongitude;
    @SerializedName("hasPolyline")
    @Expose
    private boolean hasPolyline;
    @SerializedName("ownerId")
    @Expose
    private long ownerId;
    @SerializedName("ownerDisplayName")
    @Expose
    private String ownerDisplayName;
    @SerializedName("ownerFullName")
    @Expose
    private String ownerFullName;
    @SerializedName("ownerProfileImageUrlSmall")
    @Expose
    private String ownerProfileImageUrlSmall;
    @SerializedName("ownerProfileImageUrlMedium")
    @Expose
    private String ownerProfileImageUrlMedium;
    @SerializedName("ownerProfileImageUrlLarge")
    @Expose
    private String ownerProfileImageUrlLarge;
    @SerializedName("calories")
    @Expose
    private double calories;
    @SerializedName("averageHR")
    @Expose
    private double averageHR;
    @SerializedName("maxHR")
    @Expose
    private double maxHR;
    @SerializedName("averageRunningCadenceInStepsPerMinute")
    @Expose
    private double averageRunningCadenceInStepsPerMinute;
    @SerializedName("maxRunningCadenceInStepsPerMinute")
    @Expose
    private double maxRunningCadenceInStepsPerMinute;
    @SerializedName("averageBikingCadenceInRevPerMinute")
    @Expose
    private double averageBikingCadenceInRevPerMinute;
    @SerializedName("maxBikingCadenceInRevPerMinute")
    @Expose
    private double maxBikingCadenceInRevPerMinute;
    @SerializedName("averageSwimCadenceInStrokesPerMinute")
    @Expose
    private double averageSwimCadenceInStrokesPerMinute;
    @SerializedName("maxSwimCadenceInStrokesPerMinute")
    @Expose
    private double maxSwimCadenceInStrokesPerMinute;
    @SerializedName("averageSwolf")
    @Expose
    private double averageSwolf;
    @SerializedName("activeLengths")
    @Expose
    private double activeLengths;
    @SerializedName("steps")
    @Expose
    private long steps;
    @SerializedName("conversationUuid")
    @Expose
    private Object conversationUuid;
    @SerializedName("conversationPk")
    @Expose
    private Object conversationPk;
    @SerializedName("numberOfActivityLikes")
    @Expose
    private Object numberOfActivityLikes;
    @SerializedName("numberOfActivityComments")
    @Expose
    private Object numberOfActivityComments;
    @SerializedName("likedByUser")
    @Expose
    private Object likedByUser;
    @SerializedName("commentedByUser")
    @Expose
    private Object commentedByUser;
    @SerializedName("activityLikeDisplayNames")
    @Expose
    private Object activityLikeDisplayNames;
    @SerializedName("activityLikeFullNames")
    @Expose
    private Object activityLikeFullNames;
    @SerializedName("requestorRelationship")
    @Expose
    private Object requestorRelationship;
    @SerializedName("userRoles")
    @Expose
    private List<String> userRoles = new ArrayList<String>();
    @SerializedName("privacy")
    @Expose
    private Privacy privacy;
    @SerializedName("userPro")
    @Expose
    private boolean userPro;
    @SerializedName("courseId")
    @Expose
    private Object courseId;
    @SerializedName("poolLength")
    @Expose
    private Object poolLength;
    @SerializedName("unitOfPoolLength")
    @Expose
    private Object unitOfPoolLength;
    @SerializedName("hasVideo")
    @Expose
    private boolean hasVideo;
    @SerializedName("videoUrl")
    @Expose
    private Object videoUrl;
    @SerializedName("timeZoneId")
    @Expose
    private long timeZoneId;
    @SerializedName("beglongimestamp")
    @Expose
    private long beglongimestamp;
    @SerializedName("sportTypeId")
    @Expose
    private long sportTypeId;
    @SerializedName("avgPower")
    @Expose
    private Object avgPower;
    @SerializedName("maxPower")
    @Expose
    private Object maxPower;
    @SerializedName("aerobicTrainingEffect")
    @Expose
    private Object aerobicTrainingEffect;
    @SerializedName("anaerobicTrainingEffect")
    @Expose
    private Object anaerobicTrainingEffect;
    @SerializedName("strokes")
    @Expose
    private Object strokes;
    @SerializedName("normPower")
    @Expose
    private Object normPower;
    @SerializedName("leftBalance")
    @Expose
    private Object leftBalance;
    @SerializedName("rightBalance")
    @Expose
    private Object rightBalance;
    @SerializedName("avgLeftBalance")
    @Expose
    private Object avgLeftBalance;
    @SerializedName("max20MinPower")
    @Expose
    private Object max20MinPower;
    @SerializedName("avgVerticalOscillation")
    @Expose
    private Object avgVerticalOscillation;
    @SerializedName("avgGroundContactTime")
    @Expose
    private Object avgGroundContactTime;
    @SerializedName("avgStrideLength")
    @Expose
    private Object avgStrideLength;
    @SerializedName("avgFractionalCadence")
    @Expose
    private Object avgFractionalCadence;
    @SerializedName("maxFractionalCadence")
    @Expose
    private Object maxFractionalCadence;
    @SerializedName("trainingStressScore")
    @Expose
    private Object trainingStressScore;
    @SerializedName("longensityFactor")
    @Expose
    private Object longensityFactor;
    @SerializedName("vO2MaxValue")
    @Expose
    private Object vO2MaxValue;
    @SerializedName("avgVerticalRatio")
    @Expose
    private Object avgVerticalRatio;
    @SerializedName("avgGroundContactBalance")
    @Expose
    private Object avgGroundContactBalance;
    @SerializedName("lactateThresholdBpm")
    @Expose
    private Object lactateThresholdBpm;
    @SerializedName("lactateThresholdSpeed")
    @Expose
    private Object lactateThresholdSpeed;
    @SerializedName("maxFtp")
    @Expose
    private Object maxFtp;
    @SerializedName("avgStrokeDistance")
    @Expose
    private Object avgStrokeDistance;
    @SerializedName("avgStrokeCadence")
    @Expose
    private Object avgStrokeCadence;
    @SerializedName("maxStrokeCadence")
    @Expose
    private Object maxStrokeCadence;
    @SerializedName("workoutId")
    @Expose
    private Object workoutId;
    @SerializedName("avgStrokes")
    @Expose
    private Object avgStrokes;
    @SerializedName("minStrokes")
    @Expose
    private Object minStrokes;
    @SerializedName("deviceId")
    @Expose
    private long deviceId;
    @SerializedName("mlongemperature")
    @Expose
    private Object mlongemperature;
    @SerializedName("maxTemperature")
    @Expose
    private Object maxTemperature;
    @SerializedName("minElevation")
    @Expose
    private Object minElevation;
    @SerializedName("maxElevation")
    @Expose
    private Object maxElevation;
    @SerializedName("avgDoubleCadence")
    @Expose
    private Object avgDoubleCadence;
    @SerializedName("maxDoubleCadence")
    @Expose
    private Object maxDoubleCadence;
    @SerializedName("summarizedExerciseSets")
    @Expose
    private List<SummarizedExerciseSet> summarizedExerciseSets = new ArrayList<SummarizedExerciseSet>();
    @SerializedName("maxDepth")
    @Expose
    private Object maxDepth;
    @SerializedName("avgDepth")
    @Expose
    private Object avgDepth;
    @SerializedName("surfacelongerval")
    @Expose
    private Object surfacelongerval;
    @SerializedName("startN2")
    @Expose
    private Object startN2;
    @SerializedName("endN2")
    @Expose
    private Object endN2;
    @SerializedName("startCns")
    @Expose
    private Object startCns;
    @SerializedName("endCns")
    @Expose
    private Object endCns;
    @SerializedName("summarizedDiveInfo")
    @Expose
    private SummarizedDiveInfo summarizedDiveInfo;
    @SerializedName("activityLikeAuthors")
    @Expose
    private Object activityLikeAuthors;
    @SerializedName("avgVerticalSpeed")
    @Expose
    private Object avgVerticalSpeed;
    @SerializedName("maxVerticalSpeed")
    @Expose
    private Object maxVerticalSpeed;
    @SerializedName("floorsClimbed")
    @Expose
    private Object floorsClimbed;
    @SerializedName("floorsDescended")
    @Expose
    private Object floorsDescended;
    @SerializedName("manufacturer")
    @Expose
    private String manufacturer;
    @SerializedName("diveNumber")
    @Expose
    private Object diveNumber;
    @SerializedName("locationName")
    @Expose
    private Object locationName;
    @SerializedName("bottomTime")
    @Expose
    private Object bottomTime;
    @SerializedName("lapCount")
    @Expose
    private long lapCount;
    @SerializedName("endLatitude")
    @Expose
    private Object endLatitude;
    @SerializedName("endLongitude")
    @Expose
    private Object endLongitude;
    @SerializedName("minAirSpeed")
    @Expose
    private Object minAirSpeed;
    @SerializedName("maxAirSpeed")
    @Expose
    private Object maxAirSpeed;
    @SerializedName("avgAirSpeed")
    @Expose
    private Object avgAirSpeed;
    @SerializedName("avgWindYawAngle")
    @Expose
    private Object avgWindYawAngle;
    @SerializedName("minCda")
    @Expose
    private Object minCda;
    @SerializedName("maxCda")
    @Expose
    private Object maxCda;
    @SerializedName("avgCda")
    @Expose
    private Object avgCda;
    @SerializedName("avgWattsPerCda")
    @Expose
    private Object avgWattsPerCda;
    @SerializedName("flow")
    @Expose
    private Object flow;
    @SerializedName("grit")
    @Expose
    private Object grit;
    @SerializedName("jumpCount")
    @Expose
    private Object jumpCount;
    @SerializedName("caloriesEstimated")
    @Expose
    private Object caloriesEstimated;
    @SerializedName("caloriesConsumed")
    @Expose
    private Object caloriesConsumed;
    @SerializedName("waterEstimated")
    @Expose
    private double waterEstimated;
    @SerializedName("waterConsumed")
    @Expose
    private Object waterConsumed;
    @SerializedName("maxAvgPower_1")
    @Expose
    private Object maxAvgPower1;
    @SerializedName("maxAvgPower_2")
    @Expose
    private Object maxAvgPower2;
    @SerializedName("maxAvgPower_5")
    @Expose
    private Object maxAvgPower5;
    @SerializedName("maxAvgPower_10")
    @Expose
    private Object maxAvgPower10;
    @SerializedName("maxAvgPower_20")
    @Expose
    private Object maxAvgPower20;
    @SerializedName("maxAvgPower_30")
    @Expose
    private Object maxAvgPower30;
    @SerializedName("maxAvgPower_60")
    @Expose
    private Object maxAvgPower60;
    @SerializedName("maxAvgPower_120")
    @Expose
    private Object maxAvgPower120;
    @SerializedName("maxAvgPower_300")
    @Expose
    private Object maxAvgPower300;
    @SerializedName("maxAvgPower_600")
    @Expose
    private Object maxAvgPower600;
    @SerializedName("maxAvgPower_1200")
    @Expose
    private Object maxAvgPower1200;
    @SerializedName("maxAvgPower_1800")
    @Expose
    private Object maxAvgPower1800;
    @SerializedName("maxAvgPower_3600")
    @Expose
    private Object maxAvgPower3600;
    @SerializedName("maxAvgPower_7200")
    @Expose
    private Object maxAvgPower7200;
    @SerializedName("maxAvgPower_18000")
    @Expose
    private Object maxAvgPower18000;
    @SerializedName("excludeFromPowerCurveReports")
    @Expose
    private Object excludeFromPowerCurveReports;
    @SerializedName("totalSets")
    @Expose
    private long totalSets;
    @SerializedName("activeSets")
    @Expose
    private long activeSets;
    @SerializedName("totalReps")
    @Expose
    private long totalReps;
    @SerializedName("minRespirationRate")
    @Expose
    private Object minRespirationRate;
    @SerializedName("maxRespirationRate")
    @Expose
    private Object maxRespirationRate;
    @SerializedName("avgRespirationRate")
    @Expose
    private Object avgRespirationRate;
    @SerializedName("trainingEffectLabel")
    @Expose
    private Object trainingEffectLabel;
    @SerializedName("activityTrainingLoad")
    @Expose
    private Object activityTrainingLoad;
    @SerializedName("avgFlow")
    @Expose
    private Object avgFlow;
    @SerializedName("avgGrit")
    @Expose
    private Object avgGrit;
    @SerializedName("minActivityLapDuration")
    @Expose
    private double minActivityLapDuration;
    @SerializedName("avgStress")
    @Expose
    private Object avgStress;
    @SerializedName("startStress")
    @Expose
    private Object startStress;
    @SerializedName("endStress")
    @Expose
    private Object endStress;
    @SerializedName("differenceStress")
    @Expose
    private Object differenceStress;
    @SerializedName("maxStress")
    @Expose
    private Object maxStress;
    @SerializedName("aerobicTrainingEffectMessage")
    @Expose
    private String aerobicTrainingEffectMessage;
    @SerializedName("anaerobicTrainingEffectMessage")
    @Expose
    private String anaerobicTrainingEffectMessage;
    @SerializedName("splitSummaries")
    @Expose
    private List<Object> splitSummaries = new ArrayList<Object>();
    @SerializedName("hasSplits")
    @Expose
    private boolean hasSplits;
    @SerializedName("moderatelongensityMinutes")
    @Expose
    private Integer moderatelongensityMinutes;
    @SerializedName("vigorouslongensityMinutes")
    @Expose
    private Integer vigorouslongensityMinutes;
    @SerializedName("elevationCorrected")
    @Expose
    private boolean elevationCorrected;
    @SerializedName("decoDive")
    @Expose
    private Object decoDive;
    @SerializedName("atpActivity")
    @Expose
    private boolean atpActivity;
    @SerializedName("manualActivity")
    @Expose
    private boolean manualActivity;
    @SerializedName("favorite")
    @Expose
    private boolean favorite;
    @SerializedName("purposeful")
    @Expose
    private boolean purposeful;
    @SerializedName("pr")
    @Expose
    private boolean pr;
    @SerializedName("autoCalcCalories")
    @Expose
    private boolean autoCalcCalories;
    @SerializedName("parent")
    @Expose
    private boolean parent;
    private final static long serialVersionUID = -5283024788550440333L;

}
