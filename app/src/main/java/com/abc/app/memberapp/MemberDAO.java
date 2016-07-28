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

    public static final String TABLE_NAME = "member";
    public static final String ID = "id";
    public static final String PW = "pw";
    public static final String NAME = "name";
    public static final String SSN = "ssn";
    public static final String EMAIL = "email";
    public static final String PHONE = "phone";

    public MemberDAO(Context context) {
        super(context, "hanbitdb", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) { //SQLite DB를 만드는 onCreate
        String sql = "create table if not exists "
                + TABLE_NAME
                + " ("
                + ID + " text primary key,"
                + PW + " text, "
                + NAME + " text, "
                + SSN + " text, "
                + EMAIL + " text, "
                + PHONE + " text);";
        db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String sql = "drop table if exists " + TABLE_NAME;
        db.execSQL(sql);
        this.onCreate(db);
    }

    public int insert(MemberBean bean) {
        int result = 0;
        String sql = "insert into member(id, pw, name, reg_date, ssn, email, profile_img, phone)"
                + " values(?, ?, ?, ?, ?, ?, ?, ?)";
        SQLiteDatabase db = this.getWritableDatabase(); //insert 등은 데이터를 쓰거나 지우기 때문에 Writable
        db.execSQL(sql);
        return result;
    }

    public int update(MemberBean bean) {
        int result = 0;
        String sql = "update member set pw = ?, email = ? where id = ?";
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL(sql);
        return result;
    }

    public int delete(MemberBean bean) {
        int result = 0;
        String sql = "delete from member where id = ? and pw = ?";
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL(sql);
        return result;
    }

    //list
    public List<MemberBean> list() {
        String sql = "select * from member";
        List<MemberBean> list = new ArrayList<MemberBean>();
        SQLiteDatabase db = this.getReadableDatabase(); //list는 읽어오기 때문에 Readable
        db.execSQL(sql);
        return list;
    }

    //findByPK
    public MemberBean findById(String id) {
        String sql = "select * from member where id = ?";
        MemberBean temp = null;
        SQLiteDatabase db = this.getReadableDatabase();
        db.execSQL(sql);
        return temp;
    }

    //findByNotPK
    public List<MemberBean> findByName(String name) {
        String sql = "select * from member where name = ?";
        List<MemberBean> list = new ArrayList<MemberBean>();
        SQLiteDatabase db = this.getReadableDatabase();
        db.execSQL(sql);
        return list;
    }

    //count
    public int count() {
        String sql = "select count(*) as count from member";
        SQLiteDatabase db = this.getReadableDatabase();
        db.execSQL(sql);
        int count = 0;
        return count;
    }

    public boolean login(MemberBean param) {
        boolean loginOK = false;
        String sql = "";
        if (param.getId() != null && param.getPw() != null && this.existId(param.getId())) {
            MemberBean bean = this.findById(param.getId());
            if (bean.getPw().equals(param.getPw())) {
                loginOK = true;
            }
        }
        SQLiteDatabase db = this.getReadableDatabase();
        db.execSQL(sql);
        return loginOK;
    }

    public boolean existId(String id) {
        boolean existOK = false;
        int result = 0;
        String sql = "select count(*) as count from member where id = ?";
        SQLiteDatabase db = this.getReadableDatabase();
        db.execSQL(sql);
        return existOK;
    }
}