package tcd.project.myapplication.views.fragment.dashboard;

import java.util.List;

import baseproject.tran.canhdinh.base.BaseViewInterface;
import tcd.project.myapplication.activity.HomeActivity;
import tcd.project.myapplication.models.ItemModel;

public interface FragmentDashboardViewInterface extends BaseViewInterface {

    void init(HomeActivity activity,FragmentDashboardViewCallback callback);

    void setDataList(List<ItemModel> arrItem);
}
