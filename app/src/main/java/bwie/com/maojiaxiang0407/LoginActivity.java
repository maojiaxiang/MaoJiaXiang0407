package bwie.com.maojiaxiang0407;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.gson.Gson;

import bwie.com.maojiaxiang0407.bean.LoginBean;
import bwie.com.maojiaxiang0407.presenter.Presenter;
/*
* 登录页面
* 毛佳翔
* 2019-04-07
* */
public class LoginActivity extends AppCompatActivity {
    private EditText phone1;
    private EditText pwd1;
    private Button denglu;
    private Presenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        phone1 = findViewById(R.id.phone);
        pwd1 = findViewById(R.id.pwd);
        denglu = findViewById(R.id.denglu);
        presenter = new Presenter(this);
        denglu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String phone = phone1.getText().toString();
                String pwd = pwd1.getText().toString();

                if (TextUtils.isEmpty(phone)||TextUtils.isEmpty(pwd)){
                    Toast.makeText(LoginActivity.this,"输入框不能空",Toast.LENGTH_SHORT).show();
                }else {
                    presenter.getLogin(phone,pwd);
                }
            }
        });
    }

    public void getLogin(final String data) {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                Gson gson =new Gson();
                LoginBean loginBean = gson.fromJson(data, LoginBean.class);
                String status = loginBean.getStatus();
                if (status.equals("0000")){
                    Toast.makeText(LoginActivity.this,"登录成功",Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(LoginActivity.this,MainActivity.class);
                    startActivity(intent);
                    finish();
                }else {
                    Toast.makeText(LoginActivity.this,"登录失败",Toast.LENGTH_SHORT).show();

                }
            }
        });

    }
}
