package com.abc.app.memberapp;

import android.content.Context;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by hb2010 on 2016-07-27.
 */
public class MemberServiceImpl implements MemberService{
    MemberDAO dao;
    MemberBean session;

    public MemberServiceImpl(Context context) {
        dao = new MemberDAO(context);
    }

    @Override
    public void regist(MemberBean bean) {
        dao.insert(bean);
    }

    @Override
    public void update(MemberBean bean) {
        int result = dao.update(bean);
        if (result == 1) {
            System.out.println("서비스 수정 결과 성공");
        } else {
            System.out.println("서비스 수정 결과 실패");
        }
    }

    @Override
    public void delete(MemberBean bean) {
        dao.delete(bean);
    }

    public int count(){
        return dao.count();
    }

    @Override
    public MemberBean findById(String findID) {
        return dao.findById(findID);
    }

    @Override
    public ArrayList<MemberBean> list() {
        return dao.list();
    }

    @Override
    public List<MemberBean> findByName(String findName) {
        return dao.findByName(findName);
    }

    @Override
    public List<?> findBy(String keyword) {
        // TODO Auto-generated method stub
        return dao.findByName(keyword);
    }

    @Override
    public boolean existId(String id) {
        return dao.existId(id);
    }

    public void logout(MemberBean bean){
        if(bean.getId().equals(session.getId()) && bean.getPw().equals(session.getPw())){
            this.session = null;
        }
    }

    public MemberBean findBy(){
        return session;
    }

    public boolean login(MemberBean bean){
        return dao.login(bean);
    }
}