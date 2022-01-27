package hello.hellospring.repository;

import hello.hellospring.domain.Member;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class MemoryMemberRepository implements MemberRepository{

    private static Map<Long, Member> store = new HashMap<>();
    private static long sequence = 0L;

    @Override
    public Member save(Member member) {
        member.setId(++sequence);
        store.put(member.getId(), member);
        return member;
    }

    @Override
    public Optional<Member> findById(Long id) {
        return Optional.ofNullable(store.get(id));
    }
    /*
    null이라서 오류가 뜨므로 null이여도 포함해주는 o
    ptional을 사용해서 null도 감싸준다
     */



    public Optional<Member> findByName(String name) {
        return store.values().stream()
                .filter(member -> member.getName().equals(name))  //줄이 달라도 식이 다 끝나지 않으면 ; 붙이지 않기
                .findAny();
    }
    /*
    getName이 파라미터로 넘어온 name과
    같은지 filter를 통해확인
     */

    @Override
    public List<Member> findAll() {
        return new ArrayList<>(store.values());
    }
}
