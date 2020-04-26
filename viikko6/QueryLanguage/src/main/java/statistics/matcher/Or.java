package statistics.matcher;

import statistics.Player;

public class Or implements Matcher {
    private Matcher[] matchers;
    
    public Or(Matcher... matcher) {
        this.matchers = matcher;
    }

    @Override
    public boolean matches(Player p) {
        for (Matcher matcher : this.matchers) {
            if (matcher.matches(p)) {
                return true;
            }
        }
        
        return false;
    }
    
}
