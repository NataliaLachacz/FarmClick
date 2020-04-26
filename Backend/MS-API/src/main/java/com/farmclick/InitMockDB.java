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
import java.util.Arrays;

@Component
@AllArgsConstructor
public class InitMockDB {

    private final UserRepository userRepository;
    private final PlantRepository plantRepository;
    private final RoleRepository roleRepository;

    @PostConstruct
    public void initialize() {
        Plant zboze = initPlant("Zboże", "zboze", new BigDecimal(10), new BigDecimal(0));
        Plant marchew = initPlant("Marchew", "marchew", new BigDecimal(30), new BigDecimal(500));
        Plant dynia = initPlant("Dynia", "dynia", new BigDecimal(50), new BigDecimal(1500));
        insertPlants(zboze, marchew, dynia);

        Role role = initUserRole();
        insertRole(role);

        User worms = initUser("Worms308", "hasłoWormsa", "worms308@wp.pl", new BigDecimal(1234), 999L, dynia, role);
        User dream = initUser("DreamTeamHeroin", "hasłoHeroiny", "amy1@o2.pl", new BigDecimal(978), 54397L, zboze, role);
        insertUsers(worms, dream);
    }

    private User initUser(String login, String password, String email, BigDecimal coins, Long clicks, Plant unlockedPlant, Role role) {
        User user = new User();
        user.setLogin(login);
        user.setPassword(password);
        user.setEmail(email);
        user.setCoins(coins);
        user.setClicks(clicks);
        user.setRole(role);
        user.getUnlockedPlants().add(unlockedPlant);

        return user;
    }

    private void insertUser(User user){
        if (!userRepository.findByLogin(user.getLogin()).isPresent())
            userRepository.save(user);
    }

    private void insertUsers(User... users){
        Arrays.stream(users).forEach(this::insertUser);
    }

    private Plant initPlant(String name, String filename, BigDecimal value, BigDecimal cost) {
        Plant plant = new Plant();
        plant.setName(name);
        plant.setFilename(filename);
        plant.setValue(value);
        plant.setUnlockCost(cost);

        return plant;
    }

    private void insertPlant(Plant plant){
        if (!plantRepository.findByNameIgnoreCase(plant.getName()).isPresent())
            plantRepository.save(plant);
    }

    private void insertPlants(Plant... plants){
        Arrays.stream(plants).forEach(this::insertPlant);
    }

    private Role initUserRole() {
        Role role = new Role();
        role.setName("ROLE_USER");
        role.setAuthority(UserAuthorities.USER);

        return role;
    }

    private void insertRole(Role role){
        if (roleRepository.findAll().stream().noneMatch(item -> role.getName().equals(item.getName())))
            roleRepository.save(role);
    }
}
