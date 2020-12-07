package spring_exercise.hellospring.service;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import spring_exercise.hellospring.repository.JdbcTemplateRepository;
import spring_exercise.hellospring.repository.JpaMemberRepository;
import spring_exercise.hellospring.repository.MemberRepository;

import javax.persistence.EntityManager;

@Configuration
public class SpringConfig {
//    private DataSource dataSource;
//
//    @Autowired
//    public SpringConfig(DataSource dataSource){
//        this.dataSource = dataSource;
//    }
    private EntityManager em;

    public SpringConfig(EntityManager em) {
        this.em = em;
    }

    @Bean
    public MemberService memberService() {
        return new MemberService(memberRepository());
    }
    @Bean
    public MemberRepository memberRepository() {
       // return new MemoryMemberRepository();
       // return new JdbcTemplateRepository(dataSource);
        return new JpaMemberRepository(em);
    }
}
