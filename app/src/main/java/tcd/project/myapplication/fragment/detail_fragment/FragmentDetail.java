package tcd.project.myapplication.fragment.detail_fragment;

import android.os.Bundle;
import android.util.Log;

import baseproject.tran.canhdinh.base.BaseFragment;
import baseproject.tran.canhdinh.base.BaseParameters;
import tcd.project.myapplication.activity.HomeActivity;
import tcd.project.myapplication.models.ItemModel;
import tcd.project.myapplication.views.fragment.detail_fragment.FragmentDetailView;
import tcd.project.myapplication.views.fragment.detail_fragment.FragmentDetailViewCallback;
import tcd.project.myapplication.views.fragment.detail_fragment.FragmentDetailViewInterface;

public class FragmentDetail extends BaseFragment<FragmentDetailViewInterface, BaseParameters> implements FragmentDetailViewCallback {
    HomeActivity homeActivity;

    public static FragmentDetail newInstance(ItemModel item) {

        Bundle args = new Bundle();
        args.putSerializable("item", item);
        FragmentDetail fragment = new FragmentDetail();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    protected void initialize() {
        homeActivity = (HomeActivity) getActivity();
        view.init(homeActivity, this);

        Bundle bundle = getArguments();
        if (bundle != null) {
            ItemModel item = (ItemModel)bundle.getSerializable("item");
            if (item != null) {
                view.setDataToView(item);
            }
        }
    }

    @Override
    protected FragmentDetailViewInterface getViewInstance() {
        return new FragmentDetailView();
    }

    @Override
    public void onBackHeader() {
        if (homeActivity != null) {
            homeActivity.checkBack();
        }
    }

    @Override
    public void changeToFragmentDelivery(ItemModel item) {
        if (homeActivity != null) {
            homeActivity.changeToFragmentDelivery(item);
        }
    }

    @Override
    protected BaseParameters getParametersContainer() {
        return null;
    }
}
