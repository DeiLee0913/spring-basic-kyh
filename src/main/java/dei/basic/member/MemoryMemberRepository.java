package dei.basic.member;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class MemoryMemberRepository implements MemberRepository{

    private static Map<Long, Member> store = new HashMap<>();

    @Override
    public void save(Member member) {
        store.put(member.getId(), member);
    }

    @Override
    public void saveWithEmail(Member member) {
        store.put(member.getId(), member);
    }

    @Override
    public Member findById(Long memberId) {
        return store.get(memberId);
    }

    @Override
    public Optional<Member> findByEmail(Email email) {
        return store.values().stream()
                .filter(member -> email.equals(member.getEmail()))
                .findFirst();
    }
}
