package tcd.project.myapplication.views.fragment.delivery;

import android.os.SystemClock;
import android.widget.Chronometer;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.maps.SupportMapFragment;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import baseproject.tran.canhdinh.base.BaseUiContainer;
import baseproject.tran.canhdinh.base.BaseView;
import baseproject.tran.canhdinh.widgets.roundview.RoundLinearLayout;
import de.hdodenhof.circleimageview.CircleImageView;
import tcd.project.myapplication.R;
import tcd.project.myapplication.activity.HomeActivity;

public class FragmentDeliveryView extends BaseView<FragmentDeliveryView.UIContainer> implements FragmentDeliveryViewInterface {
    HomeActivity activity;
    FragmentDeliveryViewCallback callback;
    String timeStart;
    String totalTime = "";
    @Override
    public void init(HomeActivity activity, FragmentDeliveryViewCallback callback) {
        this.activity = activity;
        this.callback = callback;
        ui.tvSubmit.setText("Giao hàng");
        ui.tvTitleHeader.setText("Đang giao hàng");

        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy HH:mm");
        timeStart = sdf.format(new Date());

        //Start thoi gian
        ui.simpleChronometer.start();

        setUpAction();

    }

    private void setUpAction() {

        ui.simpleChronometer.setOnChronometerTickListener(chronometer -> {
            long time = SystemClock.elapsedRealtime() - chronometer.getBase();
            int h   = (int)(time /3600000);
            int m = (int)(time - h*3600000)/60000;
            int s= (int)(time - h*3600000- m*60000)/1000 ;
            String hh = h < 10 ? "0"+h: h+"";
            String mm = m < 10 ? "0"+m: m+"";
            String ss = s < 10 ? "0"+s: s+"";
            chronometer.setText(hh+":"+mm+":"+ss);
            totalTime = (String) chronometer.getText();
        });

        setGone(ui.btnBackHeader);

        ui.btnSubmit.setOnClickListener(view -> {
            if (callback != null) {
                callback.onChangeFragmentEnd(timeStart, totalTime);
            }
        });
    }

    @Override
    public void setDataLocation(double a, double b) {

    }

    @Override
    public BaseUiContainer getUiContainer() {
        return new FragmentDeliveryView.UIContainer();
    }

    @Override
    public int getViewId() {
        return R.layout.dinh_layout_location;
    }


    public class UIContainer extends BaseUiContainer {
        @UiElement(R.id.btnBackHeader)
        public ImageView btnBackHeader;

        @UiElement(R.id.tvTitleHeader)
        public TextView tvTitleHeader;

        @UiElement(R.id.tvSubmit)
        public TextView tvSubmit;

        @UiElement(R.id.imgProfile)
        public CircleImageView imgProfile;

        @UiElement(R.id.btnSubmit)
        public RoundLinearLayout btnSubmit;

        @UiElement(R.id.simpleChronometer)
        public Chronometer simpleChronometer;


    }
}
