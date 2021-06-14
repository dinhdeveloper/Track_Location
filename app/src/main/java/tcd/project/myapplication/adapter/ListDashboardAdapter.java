package tcd.project.myapplication.adapter;

import android.content.Context;
import android.text.TextUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;

import baseproject.tran.canhdinh.widgets.superadapter.SuperAdapter;
import baseproject.tran.canhdinh.widgets.superadapter.SuperViewHolder;
import tcd.project.myapplication.R;
import tcd.project.myapplication.dependency.AppProvider;
import tcd.project.myapplication.models.ItemModel;

public class ListDashboardAdapter extends SuperAdapter<ItemModel> {

    private ListDashboardAdapterListener listener;

    public interface ListDashboardAdapterListener {
        void onItemSelected(ItemModel item);
    }

    public void setListener(ListDashboardAdapterListener listener) {
        this.listener = listener;
    }

    public ListDashboardAdapter(Context context, List<ItemModel> items) {
        super(context, items, R.layout.dinh_custom_item_list_dashbord);
    }

    @Override
    public void onBind(SuperViewHolder holder, int viewType, int layoutPosition, ItemModel item) {
        LinearLayout layoutItem = holder.findViewById(R.id.layoutItem);
        ImageView imgItem = holder.findViewById(R.id.imgItem);
        TextView tvShipment = holder.findViewById(R.id.tvShipment);
        TextView tvDestination = holder.findViewById(R.id.tvDestination);
        TextView tvDeparture = holder.findViewById(R.id.tvDeparture);

        if (!TextUtils.isEmpty(item.getShipment())) {
            tvShipment.setText(item.getShipment());
        }
        if (!TextUtils.isEmpty(item.getDestination())) {
            tvDestination.setText(item.getDestination());
        }
        if (!TextUtils.isEmpty(item.getDeparture())) {
            tvDeparture.setText(item.getDeparture());
        }
        AppProvider.getImageHelper().displayImage(item.getImages(),imgItem,null,R.drawable.image_background);

        layoutItem.setOnClickListener(view -> {
            if (listener != null) {
                listener.onItemSelected(item);
            }
        });
    }
}
