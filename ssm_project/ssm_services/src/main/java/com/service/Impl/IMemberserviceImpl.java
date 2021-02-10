package com.service.Impl;

import com.dao.IMemberdao;
import com.domain.Member;
import com.service.IMemberservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class IMemberserviceImpl implements IMemberservice {

    @Autowired
    IMemberdao iMemberdao;

    @Override
    public Member findById(String memberId) {
        return iMemberdao.findById(memberId);
    }
}
