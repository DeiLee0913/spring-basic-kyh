package dei.basic;

import dei.basic.member.Grade;
import dei.basic.member.Member;
import dei.basic.member.MemberService;
import dei.basic.member.MemberServiceImpl;
import dei.basic.order.Order;
import dei.basic.order.OrderService;
import dei.basic.order.OrderServiceImpl;

public class OrderApp {

    public static void main(String[] args) {
        AppConfig appConfig = new AppConfig();
        MemberService memberService = appConfig.memberService();
        OrderService orderService = appConfig.orderService();

        Long memberId = 1L;
        Member member = new Member(memberId, "memberA", Grade.VIP);
        memberService.join(member);

        Order order = orderService.createOrder(memberId, "itemA", 20000);

        System.out.println("order = " + order);
    }
}
