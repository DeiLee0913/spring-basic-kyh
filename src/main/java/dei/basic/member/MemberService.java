package dei.basic.member;

import java.util.Optional;

public interface MemberService {
    void join(Member member);
    void joinWithEmail(Member member);
    Member findMember(Long memberId);
    Optional<Member> findMemberByEmail(String email);
}
