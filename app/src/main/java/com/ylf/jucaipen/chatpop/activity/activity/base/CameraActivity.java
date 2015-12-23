package com.ylf.jucaipen.chatpop.activity.activity.base;

import android.app.Activity;
import android.graphics.PixelFormat;
import android.hardware.Camera;
import android.os.Bundle;
import android.os.Environment;
import android.view.Surface;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.ylf.jucaipen.chatpop.R;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Administrator on 2015/12/23.
 * <p/>
 * 拍照
 */
public class CameraActivity extends Activity implements View.OnClickListener, SurfaceHolder.Callback {
    private SurfaceView sv_photo;
    private Button btn_cancel;
    private Button btn_take;
    private Button btn_sure;
    private Camera camera;
    private Camera.Parameters parameters = null;
    private Bundle bundle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ui_camera);
        initView();
    }

    private void initView() {
        sv_photo = (SurfaceView) findViewById(R.id.sv_photo);
        btn_cancel = (Button) findViewById(R.id.btn_cancel);
        btn_take = (Button) findViewById(R.id.btn_take);
        btn_sure = (Button) findViewById(R.id.btn_sure);
        sv_photo.getHolder().setType(SurfaceHolder.SURFACE_TYPE_PUSH_BUFFERS);
        sv_photo.getHolder().setFixedSize(176, 144);  //设置分辨率
        sv_photo.getHolder().setKeepScreenOn(true);
        sv_photo.getHolder().addCallback(this); //为SurfaceView的句柄添加一个回调函数
        btn_sure.setOnClickListener(this);
        btn_cancel.setOnClickListener(this);
        btn_take.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_sure:
                //确定
                break;
            case R.id.btn_cancel:
                //取消
                this.finish();
                break;
            case R.id.btn_take:
                //拍照
                camera.takePicture(null, null, new MyPictureCallback());
                break;

        }
    }

    private class MyPictureCallback implements Camera.PictureCallback {

        @Override
        public void onPictureTaken(byte[] data, Camera camera) {
            //拍照结果
            bundle=new Bundle();
            ////将图片字节数据保存在bundle当中，实现数据交换
            bundle.putByteArray("data",data);
            saveToSDCard(data); // 保存图片到sd卡中
            Toast.makeText(CameraActivity.this,"成功",Toast.LENGTH_SHORT).show();
            camera.startPreview();
        }
    }

    /**
     * @param data  存储图片到SD卡
     */
    private void saveToSDCard(byte[] data) {
        try {
            Date date=new Date();
            SimpleDateFormat sdf=new SimpleDateFormat("yyyyMMddHHmmss");
            String fileName=sdf.format(date)+".jpg";
            File picFile=new File(Environment.getExternalStorageDirectory()+"/chat/");
            if(!picFile.exists()){
                picFile.mkdir();
            }
            File f=new File(picFile,fileName);
            FileOutputStream fos=new FileOutputStream(f);
            fos.write(data);
            fos.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Override
    public void surfaceCreated(SurfaceHolder holder) {
        try {
            // 开始拍照时调用该方法
            camera = Camera.open();
            camera.setPreviewDisplay(holder);  //设置用于显示拍照影像的SurfaceHolder对象
            camera.setDisplayOrientation(getPreviewDegree(CameraActivity.this));
            camera.startPreview(); // // 开始预览
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private int getPreviewDegree(CameraActivity cameraActivity) {
        // 获得手机的方向
        int rotation = cameraActivity.getWindowManager().getDefaultDisplay().getRotation();
        // 根据手机的方向计算相机预览画面应该选择的角度
        int degree = 0;
        switch (rotation) {
            case Surface.ROTATION_0:
                degree = 90;
                break;
            case Surface.ROTATION_90:
                degree = 0;
                break;
            case Surface.ROTATION_180:
                degree = 270;
                break;
            case Surface.ROTATION_270:
                degree = 180;
                break;
        }
        return degree;
    }

    @Override
    public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {
       parameters=camera.getParameters();  //获取相机参数
        parameters.setPictureFormat(PixelFormat.JPEG);  //设置照片格式
        parameters.setPreviewSize(width, height);  //设置预览大小
        parameters.setPreviewFrameRate(5);  //设置每秒显示4帧
        parameters.setPictureSize(width, height);  //设置照片大小
        parameters.setJpegQuality(80);  //设置拍照质量

    }

    @Override
    public void surfaceDestroyed(SurfaceHolder holder) {
        //释放相机
     if(camera!=null){
         camera.release();
         camera=null;
     }
    }
}
