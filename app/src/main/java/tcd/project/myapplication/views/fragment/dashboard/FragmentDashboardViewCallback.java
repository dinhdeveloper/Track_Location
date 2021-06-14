package tcd.project.myapplication.views.fragment.dashboard;

import tcd.project.myapplication.models.ItemModel;

public interface FragmentDashboardViewCallback {
    void initDataList();

    void onClickImgProfile();

    void changeToFragmentDetail(ItemModel item);
}
