package dei.basic.order;

import dei.basic.discount.DiscountPolicy;
import dei.basic.member.Member;
import dei.basic.member.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class OrderServiceImpl implements OrderService {

    private final MemberRepository memberRepository;
    private final DiscountPolicy discountPolicy;

    @Autowired
    public OrderServiceImpl(MemberRepository _memberRepository, DiscountPolicy _discountPolicy) {
        this.memberRepository = _memberRepository;
        this.discountPolicy = _discountPolicy;
    }

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        // 회원 정보 조회
        Member member = memberRepository.findById(memberId);
        // 할인 가격 조회
        int discount = discountPolicy.discount(member, itemPrice);

        // 최종 생성된 주문 반환
        return new Order(memberId, itemName, itemPrice, discount);
    }
}
