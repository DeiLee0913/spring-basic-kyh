package dei.basic;

import dei.basic.discount.DiscountPolicy;
import dei.basic.discount.RateDiscountPolicy;
import dei.basic.member.*;
import dei.basic.order.OrderService;
import dei.basic.order.OrderServiceImpl;

public class AppConfig {
    public MemberService memberService() {
        return new MemberServiceImpl(memberRepository());
    }

    private MemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }

    public OrderService orderService() {
        return new OrderServiceImpl(memberRepository(), discountPolicy());
    }

    public DiscountPolicy discountPolicy() {
        return new RateDiscountPolicy();
    }
}
