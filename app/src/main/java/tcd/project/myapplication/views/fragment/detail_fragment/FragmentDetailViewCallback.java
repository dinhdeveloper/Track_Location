package tcd.project.myapplication.views.fragment.detail_fragment;

import tcd.project.myapplication.models.ItemModel;

public interface FragmentDetailViewCallback {
    void onBackHeader();

    void changeToFragmentDelivery(ItemModel item);
}
