package com.example.realtimechatproject;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class RealTimeChatProjectApplication implements CommandLineRunner {

//    UserRepository userRepository;
//
//    public RealTimeChatProjectApplication(UserRepository userRepository)
//    {
//        this.userRepository = userRepository;
//    }
    public static void main(String[] args) {
        SpringApplication.run(RealTimeChatProjectApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
//
//        UserEntity entity1 = new UserEntity("4740911@wp.pl","mati1");
//        userRepository.save(entity1);
//        HashingEmail hashingEmail = new HashingEmail();
//        System.out.println(hashingEmail.HashTheEmail("Fake Email"));

            //dlaczego chcialbys wyciagac z bazy jakies bardziej zaawansowane pytania?
            //po pierwsze rest api jest dla innych aplikacji lub dla frontendu
            //zlozone zapytania ktore maja sluzyc do analizy powinny byc
    }


}


