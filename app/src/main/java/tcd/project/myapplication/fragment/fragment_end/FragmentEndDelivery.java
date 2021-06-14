package tcd.project.myapplication.fragment.fragment_end;

import android.os.Bundle;

import baseproject.tran.canhdinh.base.BaseFragment;
import baseproject.tran.canhdinh.base.BaseParameters;
import tcd.project.myapplication.activity.HomeActivity;
import tcd.project.myapplication.models.ItemModel;
import tcd.project.myapplication.views.fragment.fragment_end.FragmentEndDeliveryView;
import tcd.project.myapplication.views.fragment.fragment_end.FragmentEndDeliveryViewCallback;
import tcd.project.myapplication.views.fragment.fragment_end.FragmentEndDeliveryViewInterface;

public class FragmentEndDelivery extends BaseFragment<FragmentEndDeliveryViewInterface, BaseParameters>  implements FragmentEndDeliveryViewCallback {
    HomeActivity homeActivity;

    public static FragmentEndDelivery newInstance(ItemModel model) {
        
        Bundle args = new Bundle();
        args.putSerializable("model",model);
        FragmentEndDelivery fragment = new FragmentEndDelivery();
        fragment.setArguments(args);
        return fragment;
    }
    
    @Override
    protected void initialize() {
        homeActivity = (HomeActivity)getActivity();
        view.init(homeActivity,this);

        Bundle bundle = getArguments();
        if (bundle != null) {
            ItemModel model = (ItemModel)bundle.getSerializable("model");
            view.setDataList(model);
        }
    }

    @Override
    protected FragmentEndDeliveryViewInterface getViewInstance() {
        return new FragmentEndDeliveryView();
    }

    @Override
    public void onBackHeader() {
        if (homeActivity != null) {
            homeActivity.checkBack();
        }
    }

    @Override
    public void goToHomeDashBoard() {
        if (homeActivity != null) {
            homeActivity.changeToFragmentDashboard();
        }
    }

    @Override
    protected BaseParameters getParametersContainer() {
        return null;
    }
}
