package com.abc.app.memberapp;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by hb2010 on 2016-07-27.
 */
public interface MemberService {
    public void regist(MemberBean bean);
    public void update(MemberBean bean);
    public void delete(MemberBean bean);
    public MemberBean findById(String id);
    public List<MemberBean> findByName(String findName);
    public boolean existId(String id);
    public void logout(MemberBean bean);
    public ArrayList<MemberBean> list();
    public List<?> findBy(String keyword);
    public MemberBean findBy();
    public boolean login(MemberBean bean);
}
