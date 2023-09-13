package com.example.realtimechatproject;

import com.example.realtimechatproject.models.UserEntity;
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

        UserEntity entity1 = new UserEntity("4744@wp.pl","mati1");
        userRepository.save(entity1);

//        MessageDigest messageDigest = MessageDigest.getInstance("MD5");
//        String password = entity1.getHaslo();
//        byte[] message = messageDigest.digest(password.getBytes());
//
//        BigInteger bigInteger = new BigInteger(1,message);
//
//
//        System.out.println(bigInteger.toString(16));
//
//        if(bigInteger.toString(16).equals("75f3af6270ac666850054b12620f7442"))
//        {
//            System.out.println("poprawne");
//        }




//        HashingPassword hashingPassword2 = new HashingPassword(entity1.getLogin());

//        System.out.println(hashingPassword.getHashedPassword());
//        System.out.println(hashingPassword2.getHashedPassword());
//        if(hashingPassword.getHashedPassword().equals(hashingPassword2.getHashedPassword()))
//        {
//            System.out.println("oba sa rowne");
//        }
//        else {
//            System.out.println("nierowne");
//        }

        //kazdy uzytkownik bedzie mial zahashowane haslo ktore bedzie
        //przy rejestracji haslo bedzie hashowane i przypisywane do konta
        //teraz jak bedziemy sie logowac to bedziemy sprawdzac czy podane haslo/hash jest juz w bazie
        //jesli tak to dostaje cookie z hashem ktory za kazdym razem bedzie odpytywal baze




        System.out.println(userRepository.findAll());

    }
}
