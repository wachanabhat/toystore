package toystore.domain;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

public class HelloTest {


    @Test
    public void shouldReturnSomkiat(){
        Hello hello = new Hello("somkiat");
        assertEquals("somkiat", hello.getMessage());
    }

}