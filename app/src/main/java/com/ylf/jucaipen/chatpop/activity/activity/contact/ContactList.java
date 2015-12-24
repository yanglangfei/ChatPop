package com.ylf.jucaipen.chatpop.activity.activity.contact;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ExpandableListView;

import com.ylf.jucaipen.chatpop.R;
import com.ylf.jucaipen.chatpop.activity.adapter.ContactAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2015/12/23.
 */
public class ContactList extends Fragment {

    private View view;
    private ExpandableListView elv;
    private ContactAdapter adapter;
    private List<String> parents=new ArrayList<>();
    private  List<List<String>> children=new ArrayList<>();

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view=inflater.inflate(R.layout.ui_contactlist,container,false);
        initView();
        initData();
        return view;
    }

    private void initData() {
        parents.clear();
        children.clear();
        List<String> shanxi=new ArrayList<>();
        shanxi.add("西安");
        shanxi.add("咸阳");
        children.add(shanxi);
        parents.add("陕西");
        List<String> jiangsu=new ArrayList<>();
        jiangsu.add("南京");
        jiangsu.add("苏州");
        jiangsu.add("无锡");
        children.add(jiangsu);
        parents.add("江苏");
        adapter.notifyDataSetChanged();

    }

    private void initView() {
        elv= (ExpandableListView) view.findViewById(android.R.id.list);
        adapter=new ContactAdapter(parents,children,getActivity());
        elv.setAdapter(adapter);
    }
}
