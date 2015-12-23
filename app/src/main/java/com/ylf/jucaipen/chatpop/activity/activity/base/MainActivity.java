package com.ylf.jucaipen.chatpop.activity.activity.base;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.TextView;

import com.ylf.jucaipen.chatpop.R;
import com.ylf.jucaipen.chatpop.activity.activity.message.ContactList;
import com.ylf.jucaipen.chatpop.activity.activity.message.MessageList;
import com.ylf.jucaipen.chatpop.activity.activity.message.MoreInfo;
import com.ylf.jucaipen.chatpop.activity.adapter.MainPageAdapter;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends FragmentActivity implements View.OnClickListener {
    private TextView tv_left;
    private ViewPager vp_main;
    private List<Fragment> fragments = new ArrayList<>();
    private MainPageAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();

    }

    private void initView() {
        tv_left = (TextView) findViewById(R.id.tv_left);
        vp_main = (ViewPager) findViewById(R.id.vp_main);
        tv_left.setOnClickListener(this);
        MessageList messageList = new MessageList();
        ContactList contactList = new ContactList();
        MoreInfo info = new MoreInfo();
        fragments.add(messageList);
        fragments.add(contactList);
        fragments.add(info);
        adapter = new MainPageAdapter(getSupportFragmentManager(), fragments);
        vp_main.setAdapter(adapter);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.tv_left:
                this.finish();
                break;
        }
    }
}
