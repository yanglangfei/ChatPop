package com.ylf.jucaipen.chatpop.activity.activity.base;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.ylf.jucaipen.chatpop.R;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Administrator on 2015/12/22.
 * <p/>
 *  注册人脸
 */


public class CreateFace extends Activity implements View.OnClickListener {
    private Map<String,String> param=new HashMap<>();
    private TextView tv_right;
    private TextView tv_center;
    private Button btn_pic;
    private  Button btn_camare;
    private ImageView iv_face;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ui_reginface);
        initView();

    }

    private void initView() {
        tv_right= (TextView) findViewById(R.id.tv_right);
        tv_center= (TextView) findViewById(R.id.tv_center);
        btn_pic= (Button) findViewById(R.id.btn_pic);
        btn_camare= (Button) findViewById(R.id.btn_camare);
        iv_face= (ImageView) findViewById(R.id.iv_face);
        btn_camare.setOnClickListener(this);
        tv_right.setOnClickListener(this);
        btn_pic.setOnClickListener(this);
        tv_center.setText("注册");
        tv_right.setText("登录");
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case  R.id.btn_pic:
                //相册选择
                Intent picList=new Intent(this,PictureList.class);
                startActivityForResult(picList,100);
                break;
            case  R.id.tv_right:
                //返回登录
                this.finish();
                break;
            case R.id.btn_camare:
                //相机拍照
                Intent photo=new Intent(this,CameraActivity.class);
                startActivityForResult(photo,10);
                break;

        }

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(data!=null){
            if(requestCode==100&&resultCode==20){
               String path=data.getStringExtra("position");
                Bitmap bm= BitmapFactory.decodeFile(path);
                iv_face.setImageBitmap(bm);
            }
        }
    }
}
