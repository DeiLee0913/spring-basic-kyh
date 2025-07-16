package dei.basic.member;

import java.util.Optional;

public class MemberServiceImpl implements MemberService {

    private final MemberRepository memberRepository;

    public MemberServiceImpl(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Override
    public void join(Member member) {
        memberRepository.save(member);
    }

    @Override
    public void joinWithEmail(Member member) {
        validateDuplicateEmail(member.getEmail());
        memberRepository.saveWithEmail(member);
    }

    @Override
    public Member findMember(Long memberId) {
        return memberRepository.findById(memberId);
    }

    @Override
    public Optional<Member> findMemberByEmail(Email email) {
        return memberRepository.findByEmail(email);
    }

    public void validateDuplicateEmail(Email email) {
        memberRepository.findByEmail(email).ifPresent(m -> {
            throw new IllegalArgumentException("Invalid email address!");
        });
    }
}
