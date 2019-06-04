package android.thaihn.mvparchitect.screen.login;

import android.thaihn.mvparchitect.data.model.UserObject;

public class MainPresenter implements MainContract.Presenter {

    public static final String TAG = MainPresenter.class.getSimpleName();

    private MainContract.View mView;
    private UserObject mUser;

    public MainPresenter(UserObject userObject) {
        this.mUser = userObject;
    }

    @Override
    public void setView(MainContract.View view) {
        this.mView = view;
    }

    @Override
    public void onStart() {

    }

    @Override
    public void onStop() {

    }

    @Override
    public void checkLogin(String userName, String password) {
        if (userName.equalsIgnoreCase(mUser.getUserName())
                && password.equalsIgnoreCase(mUser.getPassWord())) {
            mView.loginSuccess();
        } else {
            mView.loginFail("Error password");
        }
    }
}
