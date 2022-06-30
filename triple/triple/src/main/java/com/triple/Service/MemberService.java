package com.triple.Service;

import com.triple.Repository.MemberRepository;
import com.triple.domain.Member;
import lombok.AllArgsConstructor;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;

    public List<Member> findAll(){
        return memberRepository.findAll();
    }
    public Optional<Member> findById(Long memberId){return memberRepository.findById(memberId);}

}
