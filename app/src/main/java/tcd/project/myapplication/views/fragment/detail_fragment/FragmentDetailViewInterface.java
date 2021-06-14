package tcd.project.myapplication.views.fragment.detail_fragment;

import baseproject.tran.canhdinh.base.BaseViewInterface;
import tcd.project.myapplication.activity.HomeActivity;
import tcd.project.myapplication.models.ItemModel;

public interface FragmentDetailViewInterface extends BaseViewInterface {

    void init(HomeActivity activity,FragmentDetailViewCallback callback);

    void setDataToView(ItemModel item);
}
