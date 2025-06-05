import org.junit.jupiter.api.Test;
import org.put.common.contestant.Contestant;
import static org.junit.jupiter.api.Assertions.*;


public class ContestantTest {

    private class TestContestant extends Contestant {
        public TestContestant(String name, String sportType, String country) {
            super(name, sportType, country);
        }
    }

    @Test
    public void testValidConstruction() {
        Contestant contestant = new TestContestant("John Doe", "Swimming", "USA");
        assertEquals("John Doe", contestant.getName());
        assertEquals("Swimming", contestant.getSportType());
        assertEquals("USA", contestant.getCountry());
    }

    @Test
    public void testSetValidCountry() {
        Contestant contestant = new TestContestant("Jane Doe", "Running", "USA");
        contestant.setCountry("France");
        assertEquals("France", contestant.getCountry());
    }

    @Test
    public void testSetInvalidCountry() {
        Contestant contestant = new TestContestant("Jane Doe", "Running", "USA");
        assertThrows(IllegalArgumentException.class, () -> {
            contestant.setCountry("Brazil");
        });
    }

    @Test
    public void testSetName() {
        Contestant contestant = new TestContestant("John Doe", "Swimming", "USA");
        contestant.setName("Jane Doe");
        assertEquals("Jane Doe", contestant.getName());
    }

    @Test
    public void testSetSportType() {
        Contestant contestant = new TestContestant("John Doe", "Swimming", "USA");
        contestant.setSportType("Running");
        assertEquals("Running", contestant.getSportType());
    }

    @Test
    public void testConstructorWithInvalidCountry() {
        assertThrows(IllegalArgumentException.class, () -> {
            new TestContestant("John Doe", "Swimming", "Invalid");
        });
    }
}