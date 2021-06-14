package tcd.project.myapplication.activity;

import android.os.Bundle;

import androidx.fragment.app.FragmentManager;

import baseproject.tran.canhdinh.base.BaseFragmentActivity;
import baseproject.tran.canhdinh.base.BaseParameters;
import tcd.project.myapplication.R;
import tcd.project.myapplication.fragment.dashboard.FragmentDashboard;
import tcd.project.myapplication.fragment.delivery.FragmentDelivery;
import tcd.project.myapplication.fragment.detail_fragment.FragmentDetail;
import tcd.project.myapplication.fragment.fragment_end.FragmentEndDelivery;
import tcd.project.myapplication.fragment.history.FragmentHistoryDelivery;
import tcd.project.myapplication.models.ItemModel;
import tcd.project.myapplication.views.activity.base_actionbar.BaseMainActionbarViewCallback;
import tcd.project.myapplication.views.activity.base_actionbar.BaseMainActionbarViewInterface;
import tcd.project.myapplication.views.activity.home_activity.HomeActivityView;
import tcd.project.myapplication.views.activity.home_activity.HomeActivityViewCallback;
import tcd.project.myapplication.views.activity.home_activity.HomeActivityViewInterface;

public class HomeActivity extends BaseFragmentActivity<HomeActivityViewInterface, BaseMainActionbarViewInterface, BaseParameters> implements HomeActivityViewCallback, BaseMainActionbarViewCallback {
    @Override
    protected void initialize(Bundle savedInstanceState) {
        view.init(this, this);
//
//        AppDatabase database = Room.databaseBuilder(this, AppDatabase.class, "mydb")
//                .allowMainThreadQueries()
//                .build();

        changeToFragmentDashBoard();
    }

    private void changeToFragmentDashBoard() {
        isShowContainer = 0;
        replaceFragment(new FragmentDashboard(), false);
    }

    @Override
    protected HomeActivityViewInterface getViewInstance() {
        return new HomeActivityView();
    }

    @Override
    protected BaseMainActionbarViewInterface getActionbarInstance() {
        return null;
    }

    @Override
    protected BaseParameters getParametersContainer() {
        return null;
    }

    @Override
    protected int getFragmentContainerId() {
        return R.id.homeActivity;
    }

    private int isShowContainer = 0;

    public void checkBack() {

        if (isShowContainer > 0) {
            isShowContainer--;
            FragmentManager fm = getSupportFragmentManager();
            if (fm.getBackStackEntryCount() > 0) {
                fm.popBackStack();
            }
        } else {
            checkFragment();
        }
    }

    private void checkFragment() {

        FragmentManager fm = getSupportFragmentManager();

        if (fm.getBackStackEntryCount() > 0) {
            fm.popBackStack();

        } else {
            super.onBackPressed();
        }
    }

    ///////////////////////////////////////////////////////////////////////////
    // CHANGE TO FRAGMENT
    ///////////////////////////////////////////////////////////////////////////
    public void changeToFragmentDetail(ItemModel item) {
        isShowContainer++;
        replaceFragment(FragmentDetail.newInstance(item),true,null);
    }

    public void changeToFragmentDelivery(ItemModel item) {
        isShowContainer++;
        replaceFragment(FragmentDelivery.newInstance(item),true,null);
    }

    public void onChangeFragmentEnd(ItemModel model) {
        isShowContainer++;
        replaceFragment(FragmentEndDelivery.newInstance(model),true,null);
    }

    public void changeToFragmentHistory() {
        isShowContainer++;
        replaceFragment(new FragmentHistoryDelivery(),true,null);
    }

    public void changeToFragmentDashboard() {
        isShowContainer = 0;
        replaceFragment(new FragmentDashboard(),false,null);
    }
}
