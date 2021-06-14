package tcd.project.myapplication.views.fragment.fragment_end;

import baseproject.tran.canhdinh.base.BaseViewInterface;
import tcd.project.myapplication.activity.HomeActivity;
import tcd.project.myapplication.models.ItemModel;

public interface FragmentEndDeliveryViewInterface extends BaseViewInterface {

    void init(HomeActivity activity,FragmentEndDeliveryViewCallback callback);

    void setDataList(ItemModel model);
}
