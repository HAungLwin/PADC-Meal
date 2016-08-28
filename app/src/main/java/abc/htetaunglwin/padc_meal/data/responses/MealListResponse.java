package abc.htetaunglwin.padc_meal.data.responses;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

import abc.htetaunglwin.padc_meal.data.vos.MealVO;

public class MealListResponse {
    @SerializedName("code")
    private int code;

    @SerializedName("message")
    private String message;

    @SerializedName("meal_list")
    private ArrayList<MealVO> mealList;

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    public ArrayList<MealVO> getMealList() {
        return mealList;
    }
}
