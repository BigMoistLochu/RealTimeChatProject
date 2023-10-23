package com.example.realtimechatproject;
import com.example.realtimechatproject.exeptions.CookieException;
import com.example.realtimechatproject.models.User;
import com.example.realtimechatproject.repositories.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class RealTimeChatProjectApplication implements CommandLineRunner {

    UserRepository userRepository;


    public RealTimeChatProjectApplication(UserRepository userRepository)
    {
        this.userRepository = userRepository;
    }
    public static void main(String[] args) {
        SpringApplication.run(RealTimeChatProjectApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        User user1 = new User("474z911","mati12355","Pawel","Szymeczko","43nb43");
        User user = new User("4740911@wp.pl","mati12345","Konrad","Krok","43nb33");


        userRepository.save(user1);
        userRepository.save(user);
        System.out.println(userRepository.getFirstBySurnameAndName("Krok","Konrad"));
        System.out.println(userRepository.existsByLogin("4740911@wp.pl"));
        String cookie = "cokies";
        try
        {
            if(cookie.equals("cokiesd"))
            {
                System.out.println(cookie);
            }
            else
                throw new CookieException("Bad Ciastko In The Futhure");

        }catch (RuntimeException e)
        {
            System.out.println(e.getMessage());
        }

    }


}


