package com.ylf.jucaipen.chatpop.activity.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import java.util.List;
/**
 * Created by Administrator on 2015/12/23.
 */
public class MoreAdapter extends RecyclerView.Adapter<MoreAdapter.MoreHolder> {
    private final List<String> arrays;

    public MoreAdapter(List<String> arrays) {
        this.arrays = arrays;
    }

    @Override
    public MoreHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public int getItemCount() {
        return arrays.size();
    }

    @Override
    public void onBindViewHolder(MoreHolder holder, int position) {

    }

    class MoreHolder extends RecyclerView.ViewHolder {
        View view;

        public MoreHolder(View itemView) {
            super(itemView);
            this.view = itemView;
        }
    }
}
