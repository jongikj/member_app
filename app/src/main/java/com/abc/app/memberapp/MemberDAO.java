package com.abc.app.memberapp;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by hb2010 on 2016-07-27.
 */
public class MemberDAO extends SQLiteOpenHelper {

    public MemberDAO(Context context) {
        super(context, "", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public int insert(MemberBean bean) {
        int result = 0;
        String sql = "insert into member(id, pw, name, reg_date, ssn, email, profile_img, phone)"
                + " values(?, ?, ?, ?, ?, ?, ?, ?)";
        return result;
    }

    public int update(MemberBean bean) {
        int result = 0;
        String sql = "update member set pw = ?, email = ? where id = ?";
        return result;
    }

    public int delete(MemberBean bean) {
        int result = 0;
        String sql = "delete from member where id = ? and pw = ?";
        return result;
    }

    public int exeUpdate(String sql) {
        int updateResult = 0;
        return updateResult;
    }

    //list
    public List<MemberBean> list() {
        String sql = "select * from member";
        List<MemberBean> list = new ArrayList<MemberBean>();
        return list;
    }

    //findByPK
    public MemberBean findById(String id) {
        String sql = "select * from member where id = ?";
        MemberBean temp = null;
        return temp;
    }

    //findByNotPK
    public List<MemberBean> findByName(String name) {
        String sql = "select * from member where name = ?";
        List<MemberBean> list = new ArrayList<MemberBean>();
        return list;
    }

    //count
    public int count() {
        String sql = "select count(*) as count from member";
        int count = 0;
        return count;
    }

    public boolean login(MemberBean param) {
        boolean loginOK = false;
        if (param.getId() != null && param.getPw() != null && this.existId(param.getId())) {
            MemberBean bean = this.findById(param.getId());
            if (bean.getPw().equals(param.getPw())) {
                loginOK = true;
            }
        }
        return loginOK;
    }

    public boolean existId(String id) {
        boolean existOK = false;
        int result = 0;
        String sql = "select count(*) as count from member where id = ?";
        return existOK;
    }
}