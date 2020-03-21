package com.farmclick;

import com.farmclick.api.model.User;
import com.farmclick.api.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.math.BigDecimal;

@Component
@AllArgsConstructor
public class InitMockDB {

    private final UserRepository userRepository;

    @PostConstruct
    public void initialize(){
        initUser("Worms308", "hasłoWormsa", "worms308@wp.pl", new BigDecimal(1234), 999L);
        initUser("DreamTeamHeroin", "hasłoHeroiny", "amy1@o2.pl", new BigDecimal(978), 54397L);
    }

    private void initUser(String login, String password, String email, BigDecimal coins, Long clicks){
        User user = new User();
        user.setLogin(login);
        user.setPassword(password);
        user.setEmail(email);
        user.setCoins(coins);
        user.setClicks(clicks);

        userRepository.save(user);
    }
}
