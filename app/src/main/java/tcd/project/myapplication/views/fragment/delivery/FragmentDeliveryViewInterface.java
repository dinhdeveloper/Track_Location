package tcd.project.myapplication.views.fragment.delivery;

import baseproject.tran.canhdinh.base.BaseViewInterface;
import tcd.project.myapplication.activity.HomeActivity;

public interface FragmentDeliveryViewInterface extends BaseViewInterface {

    void init(HomeActivity activity,FragmentDeliveryViewCallback callback);

    void setDataLocation(double a, double b);
}
