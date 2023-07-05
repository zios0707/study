package com.example.mInt_BE.repository;

import com.example.mInt_BE.repository.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MemberRepository extends JpaRepository<Member, Long> {
    Member findByIdAndPs(String id, String ps);
    Member findByIdAndPsAndEmail(String id, String ps, String email);
}
