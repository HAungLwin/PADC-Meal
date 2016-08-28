package abc.htetaunglwin.padc_meal.data.agents;

import com.google.gson.reflect.TypeToken;

import org.json.JSONException;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.List;

import abc.htetaunglwin.padc_meal.data.models.MealModel;
import abc.htetaunglwin.padc_meal.data.vos.MealVO;
import abc.htetaunglwin.padc_meal.utils.CommonInstances;
import abc.htetaunglwin.padc_meal.utils.JsonUtils;


public class OfflineDataAgent implements MealDataAgent {

    private static final String OFFLINE_ATTRACTION_LIST = "meals.json";

    private static OfflineDataAgent objInstance;

    private OfflineDataAgent() {

    }

    public static OfflineDataAgent getInstance() {
        if (objInstance == null) {
            objInstance = new OfflineDataAgent();
        }

        return objInstance;
    }

    @Override
    public void loadMeals() {
        try {
            String attractions = JsonUtils.getInstance().loadDummyData(OFFLINE_ATTRACTION_LIST);
            Type listType = new TypeToken<List<MealVO>>() {
            }.getType();
            List<MealVO> mealList = CommonInstances.getGsonInstance().fromJson(attractions, listType);

            MealModel.getInstance().notifyAttractionsLoaded(mealList);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }




}
