package ohtuesimerkki;



import java.util.ArrayList;
import java.util.List;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;

public class StatisticsTest {
    Reader readerStub = new Reader() {
 
        public List<Player> getPlayers() {
            ArrayList<Player> players = new ArrayList<>();
 
            players.add(new Player("Semenko", "EDM", 4, 12));
            players.add(new Player("Lemieux", "PIT", 45, 54));
            players.add(new Player("Kurri",   "EDM", 37, 53));
            players.add(new Player("Yzerman", "DET", 42, 56));
            players.add(new Player("Gretzky", "EDM", 35, 89));
 
            return players;
        }
    };
 
    Statistics stats;
    
    
    @Before    
    public void setUp(){
        // luodaan Statistics-olio joka käyttää "stubia"
        stats = new Statistics(readerStub);
    }
    
    @Test
    public void playerName() {
        Player p = stats.search("Kurri");
        assertEquals("Kurri", p.getName());
    }
    
    
    @Test
    public void topPlayer() {
        List<Player> p = stats.topScorers(1);
        assertEquals("Gretzky", p.get(0).getName());
    }
    
    @Test
    public void notPlayer() {
        Player p = stats.search("Teemu");
        assertEquals(null, p);
    }
    
    @Test
    public void playesByTeam() {
        List<Player> p = stats.team("EDM");
        assertEquals("EDM", p.get(0).getTeam());
    }
}