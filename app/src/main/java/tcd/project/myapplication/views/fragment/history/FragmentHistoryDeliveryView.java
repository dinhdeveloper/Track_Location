package tcd.project.myapplication.views.fragment.history;

import baseproject.tran.canhdinh.base.BaseUiContainer;
import baseproject.tran.canhdinh.base.BaseView;
import tcd.project.myapplication.R;
import tcd.project.myapplication.activity.HomeActivity;

public class FragmentHistoryDeliveryView extends BaseView<FragmentHistoryDeliveryView.UIContainer> implements FragmentHistoryDeliveryViewInterface {
    HomeActivity activity;
    FragmentHistoryDeliveryViewCallback callback;


    @Override
    public void init(HomeActivity activity, FragmentHistoryDeliveryViewCallback callback) {
        this.activity = activity;
        this.callback = callback;
    }

    @Override
    public BaseUiContainer getUiContainer() {
        return new FragmentHistoryDeliveryView.UIContainer();
    }

    @Override
    public int getViewId() {
        return R.layout.dinh_fragment_dashboard;
    }


    public class UIContainer extends BaseUiContainer {
    }
}
