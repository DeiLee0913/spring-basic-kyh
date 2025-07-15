package dei.basic;

import dei.basic.member.Grade;
import dei.basic.member.Member;
import dei.basic.member.MemberService;
import dei.basic.member.MemberServiceImpl;
import org.springframework.context.ApplicationContext;

public class MemberApp {

    public static void main(String[] args) {
        AppConfig appConfig = new AppConfig();
        MemberService memberService = appConfig.memberService();

        Member member = new Member(1L, "memberA", Grade.VIP);
        memberService.join(member);

        Member findMember = memberService.findMember(1L);
        System.out.println("new member = " + member.getName());
        System.out.println("find member = " + findMember.getName());



    }
}
