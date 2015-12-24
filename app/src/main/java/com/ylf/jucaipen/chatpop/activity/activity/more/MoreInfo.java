package com.ylf.jucaipen.chatpop.activity.activity.more;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ylf.jucaipen.chatpop.R;
import com.ylf.jucaipen.chatpop.activity.adapter.MoreAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2015/12/23.
 */
public class MoreInfo extends Fragment {
    private RecyclerView lv_more;
    private View view;
    private MoreAdapter adapter;
    private List<String> arrays=new ArrayList<>();

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view=inflater.inflate(R.layout.ui_morelist,container,false);
        initView();
        initData();
        return view;
    }

    private void initData() {
        arrays.clear();
        arrays.add("我的");
        arrays.add("设置");
        arrays.add("关于");
        adapter.notifyDataSetChanged();
    }

    private void initView() {
        lv_more= (RecyclerView) view.findViewById(R.id.lv_more);
        adapter=new MoreAdapter(arrays);
        lv_more.setHasFixedSize(true);
        LinearLayoutManager lm=new LinearLayoutManager(getActivity());
        lm.setOrientation(LinearLayoutManager.VERTICAL);
        lv_more.setLayoutManager(lm);
        lv_more.setAdapter(adapter);
    }
}
