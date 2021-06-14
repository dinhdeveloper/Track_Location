package tcd.project.myapplication.fragment.dashboard;

import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import baseproject.tran.canhdinh.base.BaseFragment;
import baseproject.tran.canhdinh.base.BaseParameters;
import tcd.project.myapplication.activity.HomeActivity;
import tcd.project.myapplication.models.ItemModel;
import tcd.project.myapplication.models.ProductModel;
import tcd.project.myapplication.views.fragment.dashboard.FragmentDashboardView;
import tcd.project.myapplication.views.fragment.dashboard.FragmentDashboardViewCallback;
import tcd.project.myapplication.views.fragment.dashboard.FragmentDashboardViewInterface;

public class FragmentDashboard extends BaseFragment<FragmentDashboardViewInterface, BaseParameters> implements FragmentDashboardViewCallback {
    HomeActivity homeActivity;
    @Override
    protected void initialize() {
        homeActivity = (HomeActivity)getActivity();
        view.init(homeActivity,this);
    }

    @Override
    protected FragmentDashboardViewInterface getViewInstance() {
        return new FragmentDashboardView();
    }

    @Override
    public void initDataList() {
         List<ProductModel> arrProduct = new ArrayList<>();
         List<ItemModel> arrItem = new ArrayList<>();

        ProductModel product1 = new ProductModel("Bút bi thiên long","120000");
        ProductModel product2 = new ProductModel("Vở thiên kim","230000");
        ProductModel product3 = new ProductModel("Ổ cứng SSD","430000");
        ProductModel product4 = new ProductModel("Bút chì robot","123000");

        arrProduct.add(product1);
        arrProduct.add(product2);
        arrProduct.add(product3);
        arrProduct.add(product4);

        //list data item
        ItemModel itemModel1 = new ItemModel("1","Chuyến Hàng Rau Củ","https://image.vietnamtourism.gov.vn/images/2021/CNMN/Thang2/09.02._Kham_pha_thien_nhien_hoang_da_vung_Dong_Nam_Bo_2.jpg","Hồ Chí Minh",
                "Hà Nội","5h00",arrProduct);
        ItemModel itemModel2 = new ItemModel("2","Chuyến Nông Sản","https://cdn3.ivivu.com/2020/08/ngam-tuyet-tac-thien-nhien-o-tien-canh-truong-gia-gioi-ivivu-05.jpg","Đà Nẵng",
                "Hà Nam","1h30",arrProduct);
        ItemModel itemModel3 = new ItemModel("3","Chuyến Vật Liệu Xây Dựng","https://media.truyenhinhdulich.vn/upload/news/7_2019/10%20ky%20quan%20thien%20nhien%20Nhat%20Ban%202_1562753447.jpg","Huế",
                "Khánh Hòa","4h00",arrProduct);
        ItemModel itemModel4 = new ItemModel("4","Chuyến Chở Khách","https://kinhdainam.com/wp-content/uploads/2020/12/tranh-kinh-3d-phong-canh-thien-nhien-13.jpg","Quảng Trị",
                "Hồ Chí Minh","2h30",arrProduct);

        arrItem.add(itemModel1);
        arrItem.add(itemModel2);
        arrItem.add(itemModel3);
        arrItem.add(itemModel4);

        if (view != null) {
            view.setDataList(arrItem);
        }
    }

    @Override
    public void onClickImgProfile() {
        if (homeActivity != null) {
            homeActivity.changeToFragmentHistory();
        }
    }

    @Override
    public void changeToFragmentDetail(ItemModel item) {
        if (homeActivity != null) {
            homeActivity.changeToFragmentDetail(item);
        }
    }

    @Override
    protected BaseParameters getParametersContainer() {
        return null;
    }
}
