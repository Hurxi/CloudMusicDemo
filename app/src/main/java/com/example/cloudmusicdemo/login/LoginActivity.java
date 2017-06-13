package com.example.cloudmusicdemo.login;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.example.cloudmusicdemo.R;
import com.example.cloudmusicdemo.login.fragment.LoginFragment;

import butterknife.ButterKnife;

public class LoginActivity extends AppCompatActivity {

//    @BindView(R.id.fl_content)
//    FrameLayout flContent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);

        FragmentManager manager = getFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        LoginFragment loginFragment = new LoginFragment();
        transaction.add(R.id.fl_content, loginFragment);
        transaction.commit();


    }

}
