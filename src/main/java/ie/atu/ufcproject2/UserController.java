package ie.atu.ufcproject2;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class UserController {

    private final List<UserDetails> fighterRoster = new ArrayList<>();

    public UserController() {
        fighterRoster.add(new UserDetails("Jon Jones", "27-1-0", "001", "HeavyWeight Champion"));
        fighterRoster.add(new UserDetails("Alex Pereira", "9-2-0", "002", "Light HeavyWeight Champion"));
        fighterRoster.add(new UserDetails("Sean Strickland", "28-5-0", "003", "MiddleWeight Champion"));
        fighterRoster.add(new UserDetails("Leon Edwards", "22-3-0", "004", "WelterWeight Champion"));
        fighterRoster.add(new UserDetails("Islam Makhachev", "25-1-0", "005", "LightWeight Champion"));
        fighterRoster.add(new UserDetails("Alexander Volkanovski", "26-3-0", "006", "FeatherWeight Champion"));
        fighterRoster.add(new UserDetails("Sean O'Malley", "17-1-0", "007", "BantamWeight Champion"));
        fighterRoster.add(new UserDetails("Alexandre Pantoja", "27-5-0", "008", "FlyWeight Champion"));
    }

    @GetMapping("/get-fighter-details/{name}")
    public UserDetails getFighterDetails(@PathVariable String name) {

        return fighterRoster.stream()
                .filter(fighter -> fighter.getName().equalsIgnoreCase(name))
                .findFirst()
                .orElse(null);
    }
}
