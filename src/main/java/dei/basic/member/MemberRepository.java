package dei.basic.member;

import java.util.Optional;

public interface MemberRepository {

    void save(Member member);
    void saveWithEmail(Member member);

    Member findById(Long memberId);
    Optional<Member> findByEmail(Email email);
}
