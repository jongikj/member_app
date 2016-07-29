package com.abc.app.memberapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class JoinActivity extends Activity implements View.OnClickListener{
    EditText et_id, et_pw, et_name, et_ssn, et_email, et_phone;
    Button bt_join, bt_reset;
    MemberService service;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_join);

        service = new MemberServiceImpl(this.getApplicationContext());

        et_id = (EditText) findViewById(R.id.et_id);
        et_pw = (EditText) findViewById(R.id.et_pw);
        et_name = (EditText) findViewById(R.id.et_name);
        et_ssn = (EditText) findViewById(R.id.et_ssn);
        et_email = (EditText) findViewById(R.id.et_email);
        et_phone = (EditText) findViewById(R.id.et_phone);
        bt_join = (Button) findViewById(R.id.bt_join);
        bt_reset = (Button) findViewById(R.id.bt_reset);

        bt_join.setOnClickListener(this);
        bt_reset.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.bt_join :
                Toast.makeText(JoinActivity.this,
                        "ID : " + et_id.getText().toString() +
                        ", PW : " + et_pw.getText().toString() +
                        ", 이름 : " + et_name.getText().toString() +
                        ", SSN : " + et_ssn.getText().toString() +
                        ", Email : " + et_email.getText().toString() +
                        ", Phone : " + et_phone.getText().toString(),
                        Toast.LENGTH_SHORT).show();
                MemberBean bean = new MemberBean();
                bean.setId(et_id.getText().toString());
                bean.setPw(et_pw.getText().toString());
                bean.setName(et_name.getText().toString());
                bean.setSsn(et_ssn.getText().toString());
                bean.setEmail(et_email.getText().toString());
                bean.setProfile("default.jpg");
                bean.setPhone(et_phone.getText().toString());
                service.regist(bean);
                startActivity(new Intent(this, MainActivity.class));
                break;

            case R.id.bt_reset :
                startActivity(new Intent(this, MainActivity.class));
                break;
        }
    }
}