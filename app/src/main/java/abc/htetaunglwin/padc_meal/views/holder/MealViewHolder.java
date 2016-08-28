package abc.htetaunglwin.padc_meal.views.holder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import butterknife.BindView;
import butterknife.ButterKnife;
import abc.htetaunglwin.padc_meal.R;
import abc.htetaunglwin.padc_meal.data.vos.MealVO;

/**
 * Created by aung on 7/6/16.
 */
public class MealViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

    @BindView(R.id.tv_meal_title)
    TextView tvMealTitle;

    @BindView(R.id.iv_meal)
    ImageView ivMeal;

/*    @BindView(R.id.tv_meal_desc)
    TextView tvMealDesc;*/
private ControllerMealItem mController;

    private MealVO  mMeal;

    public MealViewHolder(View itemView, ControllerMealItem controller) {
        super(itemView);
        ButterKnife.bind(this, itemView);
        itemView.setOnClickListener(this);
        mController = controller;
    }

    public void bindData(MealVO meal) {
        mMeal = meal;
        tvMealTitle.setText(meal.getName());
        /*tvMealDesc.setText(meal.getDescription());*/

        String imageUrl =  meal.getImg_url();

        Glide.with(ivMeal.getContext())
                .load(imageUrl)
                .centerCrop()
                .placeholder(R.drawable.stock_photo_placeholder)
                .error(R.drawable.stock_photo_placeholder)
                .into(ivMeal);
    }


    @Override
    public void onClick(View view) {
        mController.onTapAttraction(mMeal, ivMeal);
    }

    public interface ControllerMealItem {
        void onTapAttraction(MealVO meal, ImageView ivAttraction);
    }
}
