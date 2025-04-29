package Ejercicio_1.primero;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class AuthorTest {

    @Test
    void getName() {
        Author ahTeck = new Author("Tan Ah Teck", "ahteck@nowhere.com", 'm');
        assertEquals("Tan Ah Teck", ahTeck.getName());
    }

    @Test
    void getEmail() {
        Author ahTeck = new Author("Tan Ah Teck", "ahteck@nowhere.com", 'm');
        assertEquals("ahteck@nowhere.com", ahTeck.getEmail());
    }

    @Test
    void setEmail() {
        Author ahTeck = new Author("Tan Ah Teck", "ahteck@nowhere.com", 'm');
        ahTeck.setEmail("ahteck@nowhere.es");
        assertEquals("ahteck@nowhere.es", ahTeck.getEmail());
    }

    @Test
    void getGender() {
        Author ahTeck = new Author("Tan Ah Teck", "ahteck@nowhere.com", 'm');
        assertEquals('m', ahTeck.getGender());
    }

    @Test
    void testToString() {
        Author ahTeck = new Author("Tan Ah Teck", "ahteck@nowhere.com", 'm');
        assertEquals("Author[name=Tan Ah Teck, email=ahteck@nowhere.com, gender=m]", ahTeck.toString());
    }
}