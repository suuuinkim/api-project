package com.clinic.veterinary.repository;

import com.clinic.veterinary.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<Member, Long> {
//    Optional<Member> findByEmail(String email);

    Optional<Member> findByLoginId(String loginId);
}
