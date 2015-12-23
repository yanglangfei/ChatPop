package com.ylf.jucaipen.chatpop.activity.adapter;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.util.List;

/**
 * Created by Administrator on 2015/12/23.
 */
public class PicAdapter extends RecyclerView.Adapter<PicAdapter.MyHolder> implements View.OnClickListener {

    private final List<String> imagePaths;
    private  OnItemClickListener listener;

    public PicAdapter(List<String> imagePaths) {
        this.imagePaths=imagePaths;
    }

    public void setListener(OnItemClickListener listener) {
        this.listener = listener;
    }

    @Override
    public void onClick(View v) {
        if(listener!=null){
           listener.onClickListener(v,v.getTag()+"");
        }
    }

    public  interface  OnItemClickListener{
        void  onClickListener(View view,String position);
    }

    @Override
    public MyHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        ImageView image=new ImageView(parent.getContext());
        ViewGroup.LayoutParams lm=new ViewGroup.LayoutParams(250,200);
        image.setLayoutParams(lm);
        image.setScaleType(ImageView.ScaleType.FIT_XY);
        image.setOnClickListener(this);
        MyHolder holder=new MyHolder(image);
        return holder;
    }

    @Override
    public void onBindViewHolder(MyHolder holder, int position) {
        Bitmap bm= BitmapFactory.decodeFile(imagePaths.get(position));
        holder.imageView.setImageBitmap(bm);
        holder.imageView.setTag(position);
    }

    @Override
    public int getItemCount() {
        return imagePaths.size();
    }

    class  MyHolder extends  RecyclerView.ViewHolder{
        private  ImageView imageView;

        public MyHolder(ImageView itemView) {
            super(itemView);
            this.imageView=itemView;
        }
    }
}
