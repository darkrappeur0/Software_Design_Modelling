import org.junit.jupiter.api.Test;
import org.put.common.Contest;
import org.put.common.contestant.Player;
import org.put.common.contestant.Contestant;
import org.put.common.events.Event;
import static org.junit.jupiter.api.Assertions.*;
import java.sql.Timestamp;


class EventTest {

    static class TestEvent extends Event {
        public TestEvent(Timestamp timestamp, String matchpart, Contestant contestant, int typeEvent, Contest contest) {
            super(timestamp, matchpart, contestant, typeEvent, contest);

        }
    }

    @Test
    void testEventConstructorAndGetters() {


        Timestamp timestamp = new Timestamp(1839321);
        String matchpart = "First Half";
        Contestant contestant = new Player("John Doe", "Basketball", "Poland", 193, 89);
        int typeEvent = 1;
        Contest contest = new Contest("ContestName");

        Event event = new TestEvent(timestamp, matchpart, contestant, typeEvent, contest);

        assertEquals(timestamp, event.getTimestamp());
        assertEquals(matchpart, event.getMatchpart());
        assertEquals(contestant, event.getContestant());
        assertEquals(typeEvent, event.getTypeEvent());
        assertEquals(contest, event.getContest());
    }

    @Test
    void testToStringContainsFields() {
        Timestamp timestamp = new Timestamp(18381);
        String matchpart = "Second Half";
        Contestant contestant = new Player("John Doe", "Football", "USA", 176, 76);;
        int typeEvent = 2;
        Contest contest = new Contest("AnotherContest");

        Event event = new TestEvent(timestamp, matchpart, contestant, typeEvent, contest);

        String str = event.toString();
        assertTrue(str.contains("Timestamp"));
        assertTrue(str.contains(timestamp.toString()));
        assertTrue(str.contains("Match Part"));
        assertTrue(str.contains(matchpart));
        assertTrue(str.contains("Responsible"));
        assertTrue(str.contains(contestant.toString()));
    }
}