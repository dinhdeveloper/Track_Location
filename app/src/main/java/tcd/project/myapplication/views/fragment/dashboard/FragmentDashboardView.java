package tcd.project.myapplication.views.fragment.dashboard;

import android.widget.Toast;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import baseproject.tran.canhdinh.base.BaseUiContainer;
import baseproject.tran.canhdinh.base.BaseView;
import de.hdodenhof.circleimageview.CircleImageView;
import tcd.project.myapplication.R;
import tcd.project.myapplication.activity.HomeActivity;
import tcd.project.myapplication.adapter.ListDashboardAdapter;
import tcd.project.myapplication.models.ItemModel;

public class FragmentDashboardView extends BaseView<FragmentDashboardView.UIContainer> implements FragmentDashboardViewInterface{
    HomeActivity activity;
    FragmentDashboardViewCallback callback;

    @Override
    public void init(HomeActivity activity, FragmentDashboardViewCallback callback) {
        this.activity = activity;
        this.callback = callback;

        initData();
        setUpAction();
    }

    private void setUpAction() {
        ui.imgProfile.setOnClickListener(view -> {
            if (callback != null) {
                callback.onClickImgProfile();
            }
        });
    }


    private void initData() {
        if (callback != null) {
            callback.initDataList();
        }
    }

    @Override
    public void setDataList(List<ItemModel> arrItem) {
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);
        ui.recyclerListHome.setLayoutManager(layoutManager);

        ListDashboardAdapter listItemAdapter = new ListDashboardAdapter(activity,arrItem);
        ui.recyclerListHome.setAdapter(listItemAdapter);
        listItemAdapter.notifyDataSetChanged();

        listItemAdapter.setListener(item -> {
            if (callback != null) {
                callback.changeToFragmentDetail(item);
            }
        });
    }

    @Override
    public BaseUiContainer getUiContainer() {
        return new FragmentDashboardView.UIContainer();
    }

    @Override
    public int getViewId() {
        return R.layout.dinh_fragment_dashboard;
    }

    public class UIContainer extends BaseUiContainer {
        @UiElement(R.id.imgProfile)
        public CircleImageView imgProfile;

        @UiElement(R.id.recyclerListHome)
        public RecyclerView recyclerListHome;
    }
}
