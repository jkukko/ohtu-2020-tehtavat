package statistics.matcher;

import statistics.Player;

public class Not implements Matcher {
    
    Matcher matcher;
    
    public Not(Matcher matcher) {
        this.matcher = matcher;
    }

    @Override
    public boolean matches(Player p) {
        
        
        if (this.matcher.matches(p)) {
            return false;
        }
        
        return true;
    }
    
}
