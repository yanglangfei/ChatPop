package com.ylf.jucaipen.chatpop.activity.model;

import java.io.Serializable;

/**
 * Created by Administrator on 2015/12/23.
 */
public class CreateGroup implements Serializable {
    /**
     *  成功添加人数
     */
    private  int added_person;
    /**
     *  group id
     */
    private  int group_id;
    /**
     *  group name  （唯一性）
     */
    private  String group_name;
    /**
     *   tag (不属于唯一)
     */
    private  String tag;

    public CreateGroup(int added_person, int group_id, String group_name, String tag) {
        this.added_person = added_person;
        this.group_id = group_id;
        this.group_name = group_name;
        this.tag = tag;
    }

    public int getAdded_person() {
        return added_person;
    }

    public void setAdded_person(int added_person) {
        this.added_person = added_person;
    }

    public int getGroup_id() {
        return group_id;
    }

    public void setGroup_id(int group_id) {
        this.group_id = group_id;
    }

    public String getGroup_name() {
        return group_name;
    }

    public void setGroup_name(String group_name) {
        this.group_name = group_name;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }
}
