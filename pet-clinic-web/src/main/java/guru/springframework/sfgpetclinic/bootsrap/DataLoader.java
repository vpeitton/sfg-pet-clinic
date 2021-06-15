package guru.springframework.sfgpetclinic.bootsrap;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import guru.springframework.sfgpetclinic.model.services.OwnerService;
import guru.springframework.sfgpetclinic.model.services.VetService;
import guru.springframework.sfgpetclinic.model.services.map.OwnerServiceMap;
import guru.springframework.sfgpetclinic.model.services.map.VetServiceMap;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;

    public DataLoader() {
        ownerService = new OwnerServiceMap();
        vetService = new VetServiceMap();

    }

    @Override
    public void run(String... args) throws Exception {

    }
}
