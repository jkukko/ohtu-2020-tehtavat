package statistics;

import statistics.matcher.*;

public class Main {
    public static void main(String[] args) {
        // seuraavassa osoitteessa 27.11.2019 päivitetyt tilastot
        //String url = "https://nhl27112019.herokuapp.com/players.txt";
        // ajan tasalla olevat tilastot osoitteessa
        //String url = "https://nhlstatisticsforohtu.herokuapp.com/players.txt";

        //Statistics stats = new Statistics(new PlayerReaderImpl(url));
          
        /*Matcher m = new And( new HasAtLeast(5, "goals"),
                             new HasAtLeast(5, "assists"),
                             new PlaysIn("PHI")
        );*/
        /*Matcher m = new And(
            new HasAtLeast(20, "points"),
            new Or( 
                new PlaysIn("NYR"),
                new PlaysIn("NYI"),
                new PlaysIn("NJD")
            )
        );       
        for (Player player : stats.matches(m)) {
            System.out.println(player);
        }*/
        Statistics stats = new Statistics(new PlayerReaderImpl("https://nhl27112019.herokuapp.com/players.txt"));

        QueryBuilder query = new QueryBuilder();

        Matcher m = query.playsIn("NYR")
                         .hasAtLeast(5, "goals")
                         .hasFewerThan(10, "goals").build();

        for (Player player : stats.matches(m)) {
            System.out.println( player );
        }      
    }
}
