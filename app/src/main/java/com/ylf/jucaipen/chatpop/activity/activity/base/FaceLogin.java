package com.ylf.jucaipen.chatpop.activity.activity.base;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.ylf.jucaipen.chatpop.R;

/**
 * Created by Administrator on 2015/12/22.
 *   人脸登录
 */
public class FaceLogin extends Activity {
    private TextView tv_left;
    private  TextView tv_right;
    private  TextView tv_center;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ui_facelogin);
        initView();
    }

    private void initView() {
        tv_left= (TextView) findViewById(R.id.tv_left);
        tv_right= (TextView) findViewById(R.id.tv_right);
        tv_center= (TextView) findViewById(R.id.tv_center);
        tv_center.setText("人脸登录");
        tv_right.setVisibility(View.GONE);

    }
}
