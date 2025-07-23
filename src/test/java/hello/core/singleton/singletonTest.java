package hello.core.singleton;

import hello.core.AppConfig;
import hello.core.member.MemberService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class singletonTest {

    @Test
    @DisplayName("스프링 없는 순수한 DI 컨테이너")
    void pureContainer() {
        AppConfig appConfig = new AppConfig();
        //1. 조회 : 호출할 때 마다 객체를 생성
        MemberService memberSevice1 = appConfig.memberService();
        //2. 조회 : 호출할 때 마다 객체를 생성
        MemberService memberSevice2 = appConfig.memberService();
        //참조값이 다른 것을 확인
        System.out.println("memberService1: " + memberSevice1);
        System.out.println("memberService2: " + memberSevice2);

        //memberService 1 은 memberService랑 다름
        assertThat(memberSevice1).isNotSameAs(memberSevice2);
    }
    @Test
    @DisplayName("싱글톤 패턴을 적용한 객체 사용")
    void singletonServiceTest() {
        SingletonService singletonService1 = SingletonService.getInstance();
        SingletonService singletonService2 = SingletonService.getInstance();

        System.out.println("singletonService1: " + singletonService1);
        System.out.println("singletonService2: " + singletonService2);

        assertThat(singletonService1).isSameAs(singletonService2);
    }

}
