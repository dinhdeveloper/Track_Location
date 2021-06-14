package tcd.project.myapplication.fragment.history;

import baseproject.tran.canhdinh.base.BaseFragment;
import baseproject.tran.canhdinh.base.BaseParameters;
import tcd.project.myapplication.activity.HomeActivity;
import tcd.project.myapplication.views.fragment.history.FragmentHistoryDeliveryView;
import tcd.project.myapplication.views.fragment.history.FragmentHistoryDeliveryViewCallback;
import tcd.project.myapplication.views.fragment.history.FragmentHistoryDeliveryViewInterface;

public class FragmentHistoryDelivery extends BaseFragment<FragmentHistoryDeliveryViewInterface, BaseParameters> implements FragmentHistoryDeliveryViewCallback {

    HomeActivity homeActivity;

    @Override
    protected void initialize() {
        homeActivity = (HomeActivity)getActivity();
        view.init(homeActivity,this);
    }

    @Override
    protected FragmentHistoryDeliveryViewInterface getViewInstance() {
        return new FragmentHistoryDeliveryView();
    }

    @Override
    protected BaseParameters getParametersContainer() {
        return null;
    }
}
