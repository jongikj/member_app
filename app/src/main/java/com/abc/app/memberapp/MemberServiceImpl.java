package com.abc.app.memberapp;

import java.util.List;

/**
 * Created by hb2010 on 2016-07-27.
 */
public class MemberServiceImpl implements MemberService{
    private MemberBean session;
    private MemberDAO dao = MemberDAO.getInstance();	// 4.DAO의 getInstance() 메소드를 호출한다 (싱글톤 패턴)
    private static MemberServiceImpl instance = new MemberServiceImpl();

    private MemberServiceImpl() {
        session = new MemberBean();
    }

    public static MemberServiceImpl getInstance() {
        return instance;
    }

    @Override
    public String regist(MemberBean bean) {
        String msg = "";
        MemberBean temp = this.findById(bean.getId());
        if (temp == null) {
            System.out.println(bean.getId() + "가 존재하지 않음, 가입 가능한 ID");
            int result = dao.insert(bean);
            if (result == 1) {
                msg = "success";
            } else {
                msg = "fail";
            }
        } else {
            System.out.println(bean.getId() + "가 존재함, 가입 불가능한 ID");
            msg = "fail";
        }
        return msg;
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
    public List<MemberBean> list() {
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

    @Override
    public MemberBean findBy() {
        return session;
    }

    public void logout(MemberBean bean){
        if(bean.getId().equals(session.getId()) && bean.getPw().equals(session.getPw())){
            this.session = null;
        }
    }
}