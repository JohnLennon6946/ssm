package com.service;

import com.domain.Member;

public interface IMemberservice {
    Member findById(String memberId);
}
