package com.abc.app.memberapp;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MemberListActivity extends Activity {
    ListView lv_memberlist;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_member_list);
        ArrayList<MemberBean> list = this.getList();
        lv_memberlist = (ListView) findViewById(R.id.lv_memberlist);
        lv_memberlist.setAdapter(new MemberAdapter(this, list));
        lv_memberlist.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int i, long id) {
                Object o = lv_memberlist.getItemAtPosition(i);
                MemberBean member = (MemberBean) o;
                Toast.makeText(MemberListActivity.this, "선택한 이름 : " + member.getName(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    public ArrayList<MemberBean> getList(){
        int i = 0;
        ArrayList<MemberBean> list = new ArrayList<MemberBean>();
        String[] names = {
                "cupcake",
                "donut",
                "eclair",
                "froyo",
                "gingerbread",
                "honeycomb",
                "icecream",
                "jellybean",
                "kitkat",
                "lollipop"
        };

        while(i <= names.length-1) {
            MemberBean member = new MemberBean();
            member.setName(names[i]);
            member.setPhone("010-4912-2226");
            list.add(member);
            i++;
        }
        return list;
    }
}
