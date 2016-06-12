package com.huihui.androidstudy;

import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;

import com.huihui.common.component.BaseActivity;

import butterknife.BindView;

/**
 * Created by huihui on 2016/6/10.
 */
public class RegisterActivity extends BaseActivity {

    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.email)
    AutoCompleteTextView email;
    @BindView(R.id.password)
    EditText password;
    @BindView(R.id.repassword)
    EditText repassword;
    @BindView(R.id.email_register_button)
    Button emailRegisterButton;

    @Override
    public int getLayoutResId() {
        return R.layout.activity_register;
    }

    @Override
    public void initVariable() {

    }

    @Override
    public void initView() {
        emailRegisterButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            }
        });
    }

    @Override
    public void initData() {

    }

}
