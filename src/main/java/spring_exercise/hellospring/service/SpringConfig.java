package spring_exercise.hellospring.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import spring_exercise.hellospring.aop.TimeTraceAop;
import spring_exercise.hellospring.repository.MemberRepository;

@Configuration
public class SpringConfig {
//    private DataSource dataSource;
//
//    @Autowired
//    public SpringConfig(DataSource dataSource){
//        this.dataSource = dataSource;
//    }
//    private EntityManager em;


//    public SpringConfig(EntityManager em) {
//        this.em = em;
//    }
    private final MemberRepository memberRepository;

    @Autowired
    public SpringConfig(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }


    @Bean
    public MemberService memberService() {
        return new MemberService(memberRepository);
    }


//    @Bean
//    public MemberRepository memberRepository() {
//       // return new MemoryMemberRepository();
//       // return new JdbcTemplateRepository(dataSource);
//       // return new JpaMemberRepository(em);
//    }
}
