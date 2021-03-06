package tcd.project.myapplication;

import android.app.Application;
import android.content.Context;

import androidx.multidex.MultiDex;

import baseproject.tran.canhdinh.helper.MyLog;
import baseproject.tran.canhdinh.widgets.ACRA.ACRA;
import baseproject.tran.canhdinh.widgets.ACRA.ReportingInteractionMode;
import baseproject.tran.canhdinh.widgets.ACRA.annotation.ReportsCrashes;
import baseproject.tran.canhdinh.helper.MyLifecycleHandler;
import tcd.project.myapplication.dependency.AppObjectProvider;
import tcd.project.myapplication.dependency.AppProvider;
import tcd.project.myapplication.dependency.ObjectProviderInterface;
import tcd.project.myapplication.helper.Consts;

@ReportsCrashes(

        mailTo = "qtctek@gmail.com",
        mode = ReportingInteractionMode.DIALOG,
        resNotifTickerText = R.string.crash_notif_ticker_text,
        resNotifTitle = R.string.crash_notif_title,
        resNotifText = R.string.crash_notif_text,
        resNotifIcon = android.R.drawable.stat_notify_error,
        resDialogText = R.string.crash_dialog_text,
        resDialogIcon = android.R.drawable.ic_dialog_info,
        resDialogTitle = R.string.crash_dialog_title,
        resDialogOkToast = R.string.crash_dialog_ok_toast

)
public class MyApplication extends Application {

    @Override
    protected void attachBaseContext(Context context) {
        super.attachBaseContext(context);
        MultiDex.install(this);
    }

    @Override
    public void onCreate() {
        super.onCreate();

        // Đăng ký ActivityLifecycleCallbacks để kiểm tra application có background running hay visible on screen
        registerActivityLifecycleCallbacks(new MyLifecycleHandler());

        MultiDex.install(this);
        if (Consts.MODE.equalsIgnoreCase("debug"))
            MyLog.isEnableLog = true;
        else
            MyLog.isEnableLog = false;

        ObjectProviderInterface objectProviderInterface = new AppObjectProvider(this);
        AppProvider.init(objectProviderInterface);


        ACRA.init(this);

    }


}
