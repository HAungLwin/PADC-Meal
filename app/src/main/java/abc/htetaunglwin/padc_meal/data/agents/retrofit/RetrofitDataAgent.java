package abc.htetaunglwin.padc_meal.data.agents.retrofit;


import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import abc.htetaunglwin.padc_meal.data.agents.MealDataAgent;
import abc.htetaunglwin.padc_meal.data.models.MealModel;
import abc.htetaunglwin.padc_meal.data.responses.MealListResponse;
import abc.htetaunglwin.padc_meal.utils.CommonInstances;
import abc.htetaunglwin.padc_meal.utils.MealConstants;


public class RetrofitDataAgent implements MealDataAgent {

    private static RetrofitDataAgent objInstance;

    private final MealApi theApi;

    private RetrofitDataAgent() {
        final OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .connectTimeout(15, TimeUnit.SECONDS)
                .writeTimeout(15, TimeUnit.SECONDS)
                .readTimeout(60, TimeUnit.SECONDS)
                .build();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(MealConstants.MEAL_BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(CommonInstances.getGsonInstance()))
                .client(okHttpClient)
                .build();

        theApi = retrofit.create(MealApi.class);
    }

    public static RetrofitDataAgent getInstance() {
        if (objInstance == null) {
            objInstance = new RetrofitDataAgent();
        }
        return objInstance;
    }

    @Override
    public void loadMeals() {
        Call<MealListResponse> loadMealsCall = theApi.loadMeals(MealConstants.ACCESS_TOKEN);
        loadMealsCall.enqueue(new Callback<MealListResponse>() {
            @Override
            public void onResponse(Call<MealListResponse> call, Response<MealListResponse> response) {
                MealListResponse mealListResponse = response.body();
                if (mealListResponse == null) {
                    MealModel.getInstance().notifyErrorInLoadingMeals(response.message());
                } else {
                    MealModel.getInstance().notifyAttractionsLoaded(mealListResponse.getMealList());


                }
            }

            @Override
            public void onFailure(Call<MealListResponse> call, Throwable t) {
                MealModel.getInstance().notifyErrorInLoadingMeals(t.getMessage());
            }
        });
    }
}
