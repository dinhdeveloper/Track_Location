package tcd.project.myapplication.views.fragment.detail_fragment;

import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import baseproject.tran.canhdinh.base.BaseUiContainer;
import baseproject.tran.canhdinh.base.BaseView;
import baseproject.tran.canhdinh.widgets.roundview.RoundLinearLayout;
import tcd.project.myapplication.R;
import tcd.project.myapplication.activity.HomeActivity;
import tcd.project.myapplication.adapter.ListDashboardAdapter;
import tcd.project.myapplication.adapter.ListProductAdapter;
import tcd.project.myapplication.dependency.AppProvider;
import tcd.project.myapplication.helper.Consts;
import tcd.project.myapplication.models.ItemModel;
import tcd.project.myapplication.models.ProductModel;

public class FragmentDetailView extends BaseView<FragmentDetailView.UIContainer> implements FragmentDetailViewInterface {
    HomeActivity activity;
    FragmentDetailViewCallback callback;
    @Override
    public void init(HomeActivity activity, FragmentDetailViewCallback callback) {
        this.activity = activity;
        this.callback = callback;
        setUpAction();
    }

    private void setUpAction() {
        ui.btnBackHeader.setOnClickListener(view -> {
            if (callback != null) {
                callback.onBackHeader();
            }
        });
    }

    @Override
    public void setDataToView(ItemModel item) {
        if (item != null) {
            if (!TextUtils.isEmpty(item.getShipment())) {
                ui.tvTitleHeader.setText(item.getShipment());
            }
            ui.btnSubmit.setVisibility(View.VISIBLE);
            if (!TextUtils.isEmpty(item.getImages())) {
                AppProvider.getImageHelper().displayImage(item.getImages(), ui.imgItem, null, R.drawable.image_background);
            }
            if (item.getProduct() != null && item.getProduct().size() > 0) {
                LinearLayoutManager layoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);
                ui.recycler_view_list.setLayoutManager(layoutManager);
                ListProductAdapter productAdapter = new ListProductAdapter(activity, item.getProduct());
                ui.recycler_view_list.setAdapter(productAdapter);
                productAdapter.notifyDataSetChanged();

            }
            ui.btnSubmit.setOnClickListener(view -> {
                if (callback != null) {
                    callback.changeToFragmentDelivery(item);
                }
            });
        }else {
            ui.btnSubmit.setVisibility(View.INVISIBLE);
            ui.tvTitleHeader.setText("Sản phẩm được vận chuyển");
        }
    }

    @Override
    public BaseUiContainer getUiContainer() {
        return new FragmentDetailView.UIContainer();
    }

    @Override
    public int getViewId() {
        return R.layout.dinh_fragment_detail;
    }


    public class UIContainer extends BaseUiContainer {
        @UiElement(R.id.btnBackHeader)
        public ImageView btnBackHeader;

        @UiElement(R.id.tvTitleHeader)
        public TextView tvTitleHeader;

        @UiElement(R.id.recycler_view_list)
        public RecyclerView recycler_view_list;

        @UiElement(R.id.imgItem)
        public ImageView imgItem;

        @UiElement(R.id.btnSubmit)
        public RoundLinearLayout btnSubmit;


    }
}
