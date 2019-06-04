package android.thaihn.mvparchitect.screen.login;

import android.thaihn.mvparchitect.BasePresenter;
import android.thaihn.mvparchitect.BaseView;

public interface MainContract {

    interface View extends BaseView {
        void loginSuccess();

        void loginFail(String message);
    }

    interface Presenter extends BasePresenter<View> {
        void checkLogin(String userName, String password);
    }
}
