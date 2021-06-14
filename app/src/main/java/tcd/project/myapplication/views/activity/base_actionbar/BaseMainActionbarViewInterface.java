package tcd.project.myapplication.views.activity.base_actionbar;

import androidx.annotation.ColorRes;
import androidx.annotation.DrawableRes;

import baseproject.tran.canhdinh.base.BaseActionbarView;

public interface BaseMainActionbarViewInterface extends BaseActionbarView {
    void initialize(String title, BaseMainActionbarViewCallback callback);

    void setActionbarColor(@ColorRes int resId);

    void setTitle(String title);

    void showActionbar();

    void hideActionbar();

    void configButtonLeftActionBar(@DrawableRes int iconLeft, @ColorRes int tintCorlor);

    void showButtonLeftActionBar();

    void hideButtonLeftActionBar();

    void configButtonRightActionBar(@DrawableRes int iconRight, @ColorRes int tintCorlor);

    void showButtonRightActionBar();

    void hideButtonRightActionBar();

    void showLayoutFilter();

    void hideLayoutFilter();

    void showButtonBackFilter();

    void hideButtonBackFilter();

    void configBackgroundLayoutFilter(@ColorRes int backgroundCorlor);

    void configBackgroundLayoutFilterContainer(@DrawableRes int drawableBackground);

    void configButtonBackLayoutFilter(@ColorRes int tintCorlor);

    void configButtonCancelSearchLayoutFilter(@ColorRes int tintCorlor);

    void configEdtSearchLayoutFilter(@ColorRes int textColor, @ColorRes int backgroundColor);

}
