package com.farmclick;

import com.farmclick.api.model.Plant;
import com.farmclick.api.model.Role;
import com.farmclick.api.model.User;
import com.farmclick.api.repository.PlantRepository;
import com.farmclick.api.repository.RoleRepository;
import com.farmclick.api.repository.UserRepository;
import com.farmclick.security.UserAuthorities;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.math.BigDecimal;

@Component
@AllArgsConstructor
public class InitMockDB {

    private final UserRepository userRepository;
    private final PlantRepository plantRepository;
    private final RoleRepository roleRepository;

    @PostConstruct
    public void initialize(){
        Plant zboze = initPlant("Zboże", "zboze", new BigDecimal(10), new BigDecimal(0));
        Plant marchew = initPlant("Marchew", "marchew", new BigDecimal(30), new BigDecimal(500));
        Plant dynia = initPlant("Dynia", "dynia", new BigDecimal(50), new BigDecimal(1500));

        Role role = initUserRole();

        initUser("Worms308", "hasłoWormsa", "worms308@wp.pl", new BigDecimal(1234), 999L, dynia, role);
        initUser("DreamTeamHeroin", "hasłoHeroiny", "amy1@o2.pl", new BigDecimal(978), 54397L, zboze, role);
    }

    private void initUser(String login, String password, String email, BigDecimal coins, Long clicks, Plant unlockedPlant, Role role){
        User user = new User();
        user.setLogin(login);
        user.setPassword(password);
        user.setEmail(email);
        user.setCoins(coins);
        user.setClicks(clicks);
        user.setRole(role);

        user.getUnlockedPlants().add(unlockedPlant);

        userRepository.save(user);
    }

    private Plant initPlant(String name, String filename, BigDecimal value, BigDecimal cost){
        Plant plant = new Plant();
        plant.setName(name);
        plant.setFilename(filename);
        plant.setValue(value);
        plant.setUnlockCost(cost);

        plantRepository.save(plant);
        return plant;
    }

    private Role initUserRole(){
        Role role = new Role();
        role.setName("ROLE_USER");
        role.setAuthority(UserAuthorities.USER);

        roleRepository.save(role);
        return role;
    }

}
