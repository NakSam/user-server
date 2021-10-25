//package com.naksam.userserver;
//
//import com.naksam.userserver.domain.entity.User;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.stereotype.Component;
//import org.springframework.transaction.annotation.Transactional;
//
//import javax.annotation.PostConstruct;
//import javax.persistence.EntityManager;
//import javax.persistence.PersistenceContext;
//
//@Component
//public class InitData {
//    private final InitDataService initDataService;
//
//    public InitData(InitDataService initDataService) {
//        this.initDataService = initDataService;
//    }
//
//    @PostConstruct
//    public void init() {
//        initDataService.init();
//    }
//
//    @Component
//    static class InitDataService {
//        @PersistenceContext
//        EntityManager em;
//
//        private final PasswordEncoder passwordEncoder;
//
//        InitDataService(PasswordEncoder passwordEncoder) {
//            this.passwordEncoder = passwordEncoder;
//        }
//
//        @Transactional
//        public void init() {
//            User user1 = User.builder()
//                    .name("asd")
//                    .email("xcq@google.com")
//                    .password(passwordEncoder.encode("1q2w3e4r"))
//                    .build();
//            em.persist(user1);
//
//            User user2 = User.builder()
//                    .name("asd")
//                    .email("jhjd@google.com")
//                    .password(passwordEncoder.encode("1q2w3e4r"))
//                    .build();
//            em.persist(user2);
//
//            User user3 = User.builder()
//                    .name("asd")
//                    .email("zxcasd@google.com")
//                    .password(passwordEncoder.encode("1q2w3e4r"))
//                    .build();
//            em.persist(user3);
//
//            User user4 = User.builder()
//                    .name("asd")
//                    .email("asddqw@google.com")
//                    .password(passwordEncoder.encode("1q2w3e4r"))
//                    .build();
//            em.persist(user4);
//
//            User user5 = User.builder()
//                    .name("asd")
//                    .email("cxvxcv@google.com")
//                    .password(passwordEncoder.encode("1q2w3e4r"))
//                    .build();
//            em.persist(user5);
//
//            User user6 = User.builder()
//                    .name("asd")
//                    .email("asdadsasdqw@google.com")
//                    .password(passwordEncoder.encode("1q2w3e4r"))
//                    .build();
//            em.persist(user6);
//
//            User user = User.builder()
//                    .name("tester")
//                    .email("test@test.com")
//                    .password(passwordEncoder.encode("1q2w3e4r"))
//                    .build();
//
//            em.persist(user);
//        }
//    }
//}
