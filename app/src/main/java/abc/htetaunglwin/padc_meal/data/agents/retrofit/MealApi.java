package abc.htetaunglwin.padc_meal.data.agents.retrofit;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;
import abc.htetaunglwin.padc_meal.data.responses.MealListResponse;
import abc.htetaunglwin.padc_meal.utils.MealConstants;



public interface MealApi {
    @FormUrlEncoded
    @POST(MealConstants.API_GET_MEAL_LIST)
    Call<MealListResponse> loadMeals(
            @Field(MealConstants.PARAM_ACCESS_TOKEN) String param);

}
