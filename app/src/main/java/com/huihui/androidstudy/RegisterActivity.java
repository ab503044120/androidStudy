package com.huihui.androidstudy;

import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;

import com.huihui.common.component.BaseActivity;
import com.huihui.common.utils.ToastUtil;

import butterknife.BindView;
import cn.bmob.v3.BmobUser;
import cn.bmob.v3.listener.SaveListener;

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
                String email = RegisterActivity.this.email.getText().toString();
                String password = RegisterActivity.this.password.getText().toString();
                String repassword = RegisterActivity.this.repassword.getText().toString();

                if (email.isEmpty()) {
                    RegisterActivity.this.email.setError("请输入邮箱");
                    return;
                }
                if (password.isEmpty()) {
                    RegisterActivity.this.password.setError("请输入密码");
                    return;
                }
                if (repassword.isEmpty()) {
                    RegisterActivity.this.repassword.setError("请再次输入密码");
                    return;
                }
                if (!password.equals(repassword)) {
                    RegisterActivity.this.repassword.setError("两次密码不一致");
                    return;
                }
                BmobUser bmobUser = new BmobUser();
                bmobUser.setUsername(email);
                bmobUser.setEmail(email);
                bmobUser.setPassword(password);
                bmobUser.signUp(getApplicationContext(), new SaveListener() {
                    @Override
                    public void onSuccess() {
                        ToastUtil.showMessage(getApplicationContext(),"注册成功");
                    }

                    @Override
                    public void onFailure(int i, String s) {
                        ToastUtil.showMessage(getApplicationContext(),s);
                    }
                });
            }
        });
    }

    @Override
    public void initData() {

    }

}
