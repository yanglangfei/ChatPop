package com.ylf.jucaipen.chatpop.activity.activity.base;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.ylf.jucaipen.chatpop.R;

/**
 * Created by Administrator on 2015/12/22.
 */
public class LoginActivity extends Activity implements View.OnClickListener, CompoundButton.OnCheckedChangeListener {
    private Button mLogin;
    private CheckBox mRemberPwd;
    private CheckBox mShowPwd;
    private Button mLoginQq;
    private Button mLoginWeixin;
    private Button mLoginFace;
    private TextView tv_right;
    private EditText et_account;
    private EditText et_pwd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ui_login);
        initView();
    }

    private void initView() {
        mLogin = (Button) findViewById(R.id.ll4);
        mRemberPwd = (CheckBox) findViewById(R.id.cb_remberPwd);
        mShowPwd = (CheckBox) findViewById(R.id.cb_showPwd);
        mLoginQq = (Button) findViewById(R.id.btn_loginQQ);
        mLoginWeixin = (Button) findViewById(R.id.btn_loginWeixin);
        mLoginFace = (Button) findViewById(R.id.btn_loginFace);
        tv_right = (TextView) findViewById(R.id.tv_right);
        et_account = (EditText) findViewById(R.id.et_account);
        et_pwd = (EditText) findViewById(R.id.et_pwd);
        tv_right.setOnClickListener(this);
        mLoginFace.setOnClickListener(this);
        mLoginWeixin.setOnClickListener(this);
        mLoginQq.setOnClickListener(this);
        mRemberPwd.setOnCheckedChangeListener(this);
        mShowPwd.setOnCheckedChangeListener(this);
        mLogin.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.ll4:
                //登录
                String account = et_account.getText().toString();
                String pwd = et_pwd.getText().toString();
                if (account.length() > 0 && pwd.length() > 0) {
                    Intent main = new Intent(this, MainActivity.class);
                    startActivity(main);
                }else {
                    Toast.makeText(this,"账号、密码不能为空",Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.btn_loginQQ:
                //QQ登录
                break;
            case R.id.btn_loginWeixin:
                //微信登录
                break;
            case R.id.btn_loginFace:
                //人脸登录
                Intent face = new Intent();
                face.setClass(this, FaceLogin.class);
                startActivity(face);
                break;
            case R.id.tv_right:
                Intent createFace = new Intent(this, CreateFace.class);
                startActivity(createFace);
                break;
            default:
                break;
        }

    }

    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        switch (buttonView.getId()) {
            case R.id.cb_remberPwd:
                //记住密码
                break;
            case R.id.cb_showPwd:
                //显示密码
                break;
            default:
                break;
        }
    }
}
