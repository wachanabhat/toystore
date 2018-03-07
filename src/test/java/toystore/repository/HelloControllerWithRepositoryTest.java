package toystore.repository;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.test.context.junit4.SpringRunner;
import toystore.domain.Hello;

import java.util.Optional;

import static org.junit.Assert.*;
import static org.mockito.BDDMockito.given;
import static org.mockito.MockitoAnnotations.initMocks;

@RunWith(SpringRunner.class)
public class HelloControllerWithRepositoryTest {

    private HelloControllerWithRepository controller;

    @Mock
    private PersonRepository personRepository;

    @Before
    public void init() {
        initMocks( this);
        controller = new HelloControllerWithRepository(personRepository);
    }

    @Test
    public void shouldReturnHelloSomkiat(){
        //Arrange
        Person somkiat = new Person("somkiat","pui");
        given(personRepository.findByFirstName("somkiat"))
                .willReturn(Optional.of(somkiat));
        //Action
        Hello hello = controller.sayHi("somkiat");

        //Assert
        assertEquals("Hello somkiat", hello.getMessage());
    }
}