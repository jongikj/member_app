package com.abc.app.memberapp;

import java.util.List;

/**
 * Created by hb2010 on 2016-07-27.
 */
public interface MemberService {
    public String regist(MemberBean bean);
    public void update(MemberBean bean);
    public void delete(MemberBean bean);
    public MemberBean findById(String id);
    public List<MemberBean> findByName(String findName);
    public boolean existId(String id);
    public MemberBean findBy();
    public void logout(MemberBean bean);
    public List<MemberBean> list();
    public List<?> findBy(String keyword);
}
