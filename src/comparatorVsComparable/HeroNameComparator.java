package comparatorVsComparable;

import java.util.Comparator;

public class HeroNameComparator implements Comparator<Hero> {
    @Override
    public int compare(Hero hero1, Hero hero2) {
        int result = hero1.getName().compareTo(hero2.getName());
        return result;
    }
}
