package tcd.project.myapplication.views.fragment.fragment_end;

import android.text.TextUtils;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Date;

import baseproject.tran.canhdinh.base.BaseUiContainer;
import baseproject.tran.canhdinh.base.BaseView;
import baseproject.tran.canhdinh.widgets.roundview.RoundLinearLayout;
import tcd.project.myapplication.R;
import tcd.project.myapplication.activity.HomeActivity;
import tcd.project.myapplication.models.ItemModel;

public class FragmentEndDeliveryView extends BaseView<FragmentEndDeliveryView.UIContainer> implements FragmentEndDeliveryViewInterface{
    private HomeActivity activity;
    private FragmentEndDeliveryViewCallback callback;

    @Override
    public void init(HomeActivity activity, FragmentEndDeliveryViewCallback callback) {
        this.activity = activity;
        this.callback = callback;


        ui.tvTitleHeader.setText("Lịch sử chuyến hàng");
        setGone(ui.btnBackHeader);
    }

    @Override
    public void setDataList(ItemModel model) {
        if (model != null) {
            SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy HH:mm");
            String timeEnd = sdf.format(new Date());

            if (!TextUtils.isEmpty(timeEnd)) {
                model.setTimeEnd(timeEnd);
            }
            if (!TextUtils.isEmpty(model.getShipment())) {
                ui.tvShipment.setText("Chuyến: " +model.getShipment());
            }
            if (!TextUtils.isEmpty(model.getTotalTime())) {
                ui.tvTimeTotal.setText("Tổng thời gian: "+model.getTotalTime());
            }
            if (!TextUtils.isEmpty(model.getTimeStart())) {
                ui.tvTimeStart.setText("Thời gian bắt đầu: "+ model.getTimeStart());
            }
            if (!TextUtils.isEmpty(model.getTimeEnd())) {
                ui.tvTimeEnd.setText("Thời gian kết thúc: "+model.getTimeEnd());
            }

            ui.btnSubmit.setOnClickListener(view -> {
                //todo: submit lên sqlite lưu dữ liệu
                if (callback != null) {
                    callback.goToHomeDashBoard();
                }
            });
        }
    }

    @Override
    public BaseUiContainer getUiContainer() {
        return new FragmentEndDeliveryView.UIContainer();
    }

    @Override
    public int getViewId() {
        return R.layout.dinh_layout_end;
    }

    public class UIContainer extends BaseUiContainer {
        @UiElement(R.id.btnBackHeader)
        public ImageView btnBackHeader;

        @UiElement(R.id.tvTitleHeader)
        public TextView tvTitleHeader;

        @UiElement(R.id.tvShipment)
        public TextView tvShipment;

        @UiElement(R.id.tvTimeTotal)
        public TextView tvTimeTotal;

        @UiElement(R.id.tvTimeStart)
        public TextView tvTimeStart;

        @UiElement(R.id.tvTimeEnd)
        public TextView tvTimeEnd;

        @UiElement(R.id.imgItem)
        public ImageView imgItem;

        @UiElement(R.id.btnSubmit)
        public RoundLinearLayout btnSubmit;
    }
}
