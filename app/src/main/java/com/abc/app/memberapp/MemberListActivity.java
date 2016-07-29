package com.abc.app.memberapp;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MemberListActivity extends Activity {
    ListView lv_memberlist;
    MemberService service;
    Phone phone;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_member_list);
        service = new MemberServiceImpl(this.getApplicationContext());
        phone = new Phone(this, this);
        ArrayList<MemberBean> list = service.list();

        lv_memberlist = (ListView) findViewById(R.id.lv_memberlist);
        lv_memberlist.setAdapter(new MemberAdapter(this, list));
        lv_memberlist.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int i, long id) {
                Object o = lv_memberlist.getItemAtPosition(i);
                MemberBean member = (MemberBean) o;
                Toast.makeText(MemberListActivity.this, "선택한 이름 : " + member.getName(), Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(MemberListActivity.this, DetailActivity.class);
                intent.putExtra("id", member.getId());
                startActivity(intent);

            }
        });

        lv_memberlist.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener(){
            public boolean onItemLongClick(AdapterView<?> adapterView, View v, int i, long id){
                new AlertDialog.Builder(MemberListActivity.this)
                        .setTitle("Delete entry")
                        .setMessage("Are you sure you want to delete this entry?")
                        .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                // continue with delete
                            }
                        })
                        .setNegativeButton(android.R.string.no, new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                // do nothing
                            }
                        })
                        .setIcon(android.R.drawable.ic_dialog_alert)
                        .show();
                return true;
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
