package android.thaihn.mvparchitect.screen.login;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.thaihn.mvparchitect.R;
import android.thaihn.mvparchitect.data.model.UserObject;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, MainContract.View {

    private EditText mEditUserName, mEditPassWord;
    private Button mButtonLogin;

    private MainContract.Presenter mPresenter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mEditPassWord = findViewById(R.id.edit_password);
        mEditUserName = findViewById(R.id.edit_user_name);
        mButtonLogin = findViewById(R.id.button_login);

        mPresenter = new MainPresenter(new UserObject("thaihn", "acb123"));
        mPresenter.setView(this);
        mButtonLogin.setOnClickListener(this);

    }


    @Override
    protected void onStart() {
        super.onStart();
        mPresenter.onStart();
    }

    @Override
    protected void onStop() {
        super.onStop();
        mPresenter.onStop();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button_login: {
                mPresenter.checkLogin(mEditUserName.getText().toString(),
                        mEditPassWord.getText().toString());
                break;
            }
        }
    }

    @Override
    public void loginSuccess() {
        Toast.makeText(this, "Login success", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void loginFail(String message) {
        Toast.makeText(this, "Login fail " + message, Toast.LENGTH_SHORT).show();
    }
}
