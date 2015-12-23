package com.ylf.jucaipen.chatpop.activity.activity.message;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ylf.jucaipen.chatpop.R;

/**
 * Created by Administrator on 2015/12/23.
 */
public class ContactList extends Fragment {

    private View view;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view=inflater.inflate(R.layout.ui_contactlist,container,false);
        return view;
    }
}
