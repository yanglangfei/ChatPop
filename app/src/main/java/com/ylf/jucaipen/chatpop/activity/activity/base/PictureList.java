package com.ylf.jucaipen.chatpop.activity.activity.base;

import android.app.Activity;
import android.content.ContentResolver;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.ylf.jucaipen.chatpop.R;
import com.ylf.jucaipen.chatpop.activity.adapter.PicAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2015/12/23.
 */
public class PictureList extends Activity implements View.OnClickListener {
    private RecyclerView rv_piclist;
    private ContentResolver receiver;
    private TextView tv_right;
    private  TextView tv_center;
    private  TextView tv_left;
    private List<String> imagePaths=new ArrayList<>();
    private static final String[] STORE_IMAGES = {
            MediaStore.Images.Media.DATA,
            MediaStore.Images.Media.DISPLAY_NAME,
            MediaStore.Images.Media.LATITUDE,
            MediaStore.Images.Media.LONGITUDE,
            MediaStore.Images.Media._ID
    };
    private PicAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ui_piclist);
        initView();
    }

    private void initView() {
        rv_piclist= (RecyclerView) findViewById(R.id.rv_piclist);
        tv_right= (TextView) findViewById(R.id.tv_right);
        tv_center= (TextView) findViewById(R.id.tv_center);
        tv_left= (TextView) findViewById(R.id.tv_left);
        tv_left.setOnClickListener(this);
        tv_center.setText("选择相册");
        tv_right.setText("确定");
        GridLayoutManager gridLayoutManager=new GridLayoutManager(this,3);
        rv_piclist.setLayoutManager(gridLayoutManager);
        rv_piclist.setHasFixedSize(true);
        adapter=new PicAdapter(imagePaths);
        rv_piclist.setAdapter(adapter);
        adapter.setListener(new PicAdapter.OnItemClickListener() {
            @Override
            public void onClickListener(View view, String position) {
                Intent finish=new Intent();
                finish.putExtra("position",imagePaths.get(Integer.parseInt(position)));
                PictureList.this.setResult(20, finish);
                PictureList.this.finish();
            }
        });
        getImagePath();
    }

    public  void getImagePath(){
        imagePaths.clear();
        receiver=getContentResolver();
        Cursor cursor=receiver.query(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, STORE_IMAGES, null, null, null);
        if(cursor!=null){
            while (cursor.moveToNext()){
                String path=cursor.getString(0);
                imagePaths.add(path);
            }
        }
        adapter.notifyDataSetChanged();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case  R.id.tv_left:
                this.finish();
                break;
        }
    }
}
