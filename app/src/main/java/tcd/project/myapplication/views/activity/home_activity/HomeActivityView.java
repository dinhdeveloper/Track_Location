package tcd.project.myapplication.views.activity.home_activity;

import baseproject.tran.canhdinh.base.BaseUiContainer;
import baseproject.tran.canhdinh.base.BaseView;
import tcd.project.myapplication.R;
import tcd.project.myapplication.activity.HomeActivity;

public class HomeActivityView extends BaseView<HomeActivityView.UIContainer> implements HomeActivityViewInterface{
    HomeActivity activity;
    HomeActivityViewCallback callback;
    @Override
    public void init(HomeActivity activity, HomeActivityViewCallback callback) {
        this.activity = activity;
        this.callback = callback;
    }
    @Override
    public BaseUiContainer getUiContainer() {
        return new HomeActivityView.UIContainer();
    }

    @Override
    public int getViewId() {
        return R.layout.dinh_layout_activity_home;
    }



    public class UIContainer extends BaseUiContainer {
    }
}
