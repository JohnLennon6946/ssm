package com.dao;

import com.domain.Member;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

@Repository
public interface IMemberdao {
    @Select("select *from members where id=#{memberId}")
    Member findById(String memberId);
}
