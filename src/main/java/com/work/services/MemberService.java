package com.work.services;

import com.work.repository.interfaces.MemberInterface;

public class MemberService {
    private final MemberInterface MemberRepository;

    public MemberService(MemberInterface MemberRepository) {
        this.MemberRepository = MemberRepository;
    }
}
