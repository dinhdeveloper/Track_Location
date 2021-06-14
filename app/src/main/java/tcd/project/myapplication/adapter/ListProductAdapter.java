package tcd.project.myapplication.adapter;

import android.content.Context;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;

import baseproject.tran.canhdinh.widgets.superadapter.SuperAdapter;
import baseproject.tran.canhdinh.widgets.superadapter.SuperViewHolder;
import tcd.project.myapplication.R;
import tcd.project.myapplication.models.ProductModel;

public class ListProductAdapter extends SuperAdapter<ProductModel> {

    private ListProductAdapterListener listener;

    public interface ListProductAdapterListener {
        void onItemSelected(ProductModel item);
    }

    public void setListener(ListProductAdapterListener listener) {
        this.listener = listener;
    }

    public ListProductAdapter(Context context, List<ProductModel> items) {
        super(context, items, R.layout.dinh_custom_item_list_product);
    }

    @Override
    public void onBind(SuperViewHolder holder, int viewType, int layoutPosition, ProductModel item) {
        TextView tvProductName = holder.findViewById(R.id.tvProductName);

        tvProductName.setText(item.getProductName());
    }
}
