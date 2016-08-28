package abc.htetaunglwin.padc_meal.events;

import java.util.List;

import abc.htetaunglwin.padc_meal.data.vos.MealVO;


public class MealEvent {
    public static class MealDataLoadedEvent {

        private String extraMessage;
        private List<MealVO> mealList;

        public MealDataLoadedEvent(String extraMessage, List<MealVO> mealList) {
            this.extraMessage = extraMessage;
            this.mealList = mealList;
        }

        public String getExtraMessage() {
            return extraMessage;
        }

        public List<MealVO> getAttractionList() {
            return mealList;
        }
    }
}
