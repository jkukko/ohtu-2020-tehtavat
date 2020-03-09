
package ohtu;

public class Player implements Comparable<Player>{
    private String name;
    private String team;
    private String nationality;
    private int goals;
    private int assists;

    public String getTeam() {
        return team;
    }

    public void setTeam(String team) {
        this.team = team;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public int getGoals() {
        return goals;
    }

    public void setGoals(int goals) {
        this.goals = goals;
    }

    public int getAssists() {
        return assists;
    }

    public void setAssists(int assists) {
        this.assists = assists;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
    
    public int getPoints() {
        return this.assists + this.goals;
    }
    
    public int compareTo(Player p) {
        int comparePoints = p.getPoints();
        
        return comparePoints - this.getPoints();
    }

    @Override
    public String toString() {
        return 
                String.format("%-20s", this.name) +
                String.format("%-5s", this.team) +
                String.format("%2d", this.goals) +
                " + " + 
                String.format("%2d", this.assists) + 
                " = " +
                String.format("%2d", this.getPoints());
    }
      
}
