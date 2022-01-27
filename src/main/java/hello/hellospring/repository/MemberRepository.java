package hello.hellospring.repository;

import hello.hellospring.domain.Member;

import java.util.List;
import java.util.Optional;

public interface MemberRepository {
    Member save(Member member);
    Optional<Member> findById(Long id);

    static Optional<Member> findByName() {
        return findByName();
    }


    static Optional<Member> findById(String name) {
        return null;
    }


    List<Member> findAll();
}
