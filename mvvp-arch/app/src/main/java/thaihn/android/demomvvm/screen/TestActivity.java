package thaihn.android.demomvvm.screen;

import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import thaihn.android.demomvvm.R;

public class TestActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

                DataBindingUtil.setContentView(this, R.layout.activity_test);
    }
}
