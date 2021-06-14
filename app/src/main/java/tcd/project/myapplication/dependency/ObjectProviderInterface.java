package tcd.project.myapplication.dependency;

import baseproject.tran.canhdinh.api.ApiManagement;
import baseproject.tran.canhdinh.helper.AppCleanerHelper;
import baseproject.tran.canhdinh.helper.AuthHelper;
import baseproject.tran.canhdinh.helper.ConnectivityHelper;
import baseproject.tran.canhdinh.helper.FileHelper;
import baseproject.tran.canhdinh.helper.ImageHelper;
import baseproject.tran.canhdinh.helper.InstallationHelper;
import baseproject.tran.canhdinh.helper.LanguageHelper;
import tcd.project.myapplication.helper.SharePrefs;

public interface ObjectProviderInterface
{
    SharePrefs getPreferences();

//    DatabaseHelper getDatabaseHelper();

    ImageHelper getImageHelper();

    ConnectivityHelper getConnectivityHelper();

    InstallationHelper getInstallationHelper();

    AppCleanerHelper getAppCleanerHelper();

    FileHelper getFileHelper();

    ApiManagement getApiManagement();

    LanguageHelper getLanguageHelper();

    AuthHelper getAuthHelper();

}

