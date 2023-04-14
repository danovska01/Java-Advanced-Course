package comparatorVsComparable;

import java.util.Comparator;

public class HeroHealthComparator implements Comparator<Hero> {
    @Override
    public int compare(Hero hero1, Hero hero2) {
        int result= Integer.compare(hero1.getHealth(), hero2.getHealth());

        return result;
    }
}
