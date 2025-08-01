package hello.core.singleton;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

import static org.junit.jupiter.api.Assertions.*;

class StatefulServiceTest {

    @Test
    void statefulService() {
        ApplicationContext ac = new AnnotationConfigApplicationContext(StatefulService.class);
        StatefulService statefulService1 = ac.getBean(StatefulService.class);
        StatefulService statefulService2 = ac.getBean(StatefulService.class);

        //ThreadA : A사용자 10000원 주문
        int userAPrice = statefulService1.order("userA", 10000);
        //ThreadB : B사용자 20000원 주문
        int userBPrice = statefulService2.order("userB", 20000);

        //ThreadA : 사용자A 주문 금액 조회
    //    int price = statefulService1.getPrice();
        System.out.println(userAPrice);

       // Assertions.assertThat(statefulService2.getPrice()).isEqualTo(20000);

    }
    static class  TestConfig {

        @Bean
        public StatefulService statefulService() {
            return new StatefulService();
        }
    }

}