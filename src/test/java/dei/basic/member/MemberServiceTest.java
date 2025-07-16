package dei.basic.member;

import dei.basic.AppConfig;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

public class MemberServiceTest {
    MemberService memberService;

    @BeforeEach
    public void beforeEach() {
        AppConfig appConfig = new AppConfig();
        memberService = appConfig.memberService();
    }

    @Test
    void join() {
        //given
        Member member = new Member(1L, "memberA", Grade.VIP);

        //when
        memberService.join(member);
        Member findMmember = memberService.findMember(1L);

        //then
        Assertions.assertThat(member).isEqualTo(findMmember);
    }

    @Test
    void joinWithEmail() {
        Member member = new Member(2L, "memberB", Grade.VIP, new Email("email@example.com"));
        memberService.join(member);

        Optional<Member> findMember = memberService.findMemberByEmail(new Email("email@example.com"));

        Assertions.assertThat(findMember.orElseThrow()).isEqualTo(member);
    }

    @Test
    void joinWithSameEmail() {
        Member member1 = new Member(3L, "memberC", Grade.VIP, new Email("email@example.com"));
        memberService.join(member1);

        Member member2 = new Member(4L, "memberD", Grade.VIP, new Email("email@example.com"));
        assertThatThrownBy(() -> memberService.joinWithEmail(member2))
                .isInstanceOf(IllegalStateException.class)
                .hasMessage("Email already exists!");
    }

    @Test
    void joinWithNotValidEmail() {
        assertThatThrownBy(() ->
                new Member(5L, "memberE", Grade.BASIC, new Email("email.com"))
            )
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage("Invalid email address!");
    }
}
