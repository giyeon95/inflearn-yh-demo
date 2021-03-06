package inflearn.yh.course1.order;

import inflearn.yh.course1.AppConfig;
import inflearn.yh.course1.member.Grade;
import inflearn.yh.course1.member.Member;
import inflearn.yh.course1.member.MemberService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

class OrderServiceTest {


    private MemberService memberService;
    private OrderService orderService;

    @BeforeEach
    void beforeEach() {
//        AppConfig appConfig = new AppConfig();
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

        this.memberService = context.getBean("memberService", MemberService.class);
        this.orderService = context.getBean("orderService", OrderService.class);
//        memberService = appConfig.memberService();
//        orderService = appConfig.orderService();
    }

    @Test
    void createOrder() {
        //given
//        MemberService memberService = appConfig.memberService();
//        OrderService orderService = appConfig.orderService();

        Long memberId = 1L;
        Member member = new Member(memberId, "memberA", Grade.VIP);

        //when
        memberService.join(member);
        Order order = orderService.createOrder(memberId, "itemA", 10000);

        //then
        Assertions.assertThat(order.getDiscountPrice()).isEqualTo(1000);
    }

}