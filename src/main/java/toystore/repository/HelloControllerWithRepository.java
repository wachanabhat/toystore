package toystore.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import toystore.domain.Hello;

import java.util.Optional;

@RestController
public class HelloControllerWithRepository {

    @Autowired
    private PersonRepository personRepository;

    public HelloControllerWithRepository(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @GetMapping("/hello/data/{name}")
    public Hello sayHi(@PathVariable String name){
        Optional<Person> foundPerson = personRepository.findByFirstName(name);

        String message = foundPerson.map(person -> String.format("Hello %s", person.getFirstName()))
                .orElse("Data not found");

        return new Hello(message);
    }
}
