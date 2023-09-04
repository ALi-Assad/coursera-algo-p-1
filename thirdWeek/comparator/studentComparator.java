package thirdWeek.comparator;

import java.util.Comparator;

public class studentComparator {

    public static final Comparator<studentComparator> BY_NAME = new ByName();
    public static final Comparator<studentComparator> BY_SECTION = new BySection();

    public final String name;
    public final int section;

    public studentComparator(String name, int section) {
        this.name = name;
        this.section = section;
    }

    private static class ByName implements Comparator<studentComparator>{
        @Override
        public int compare(studentComparator o1, studentComparator o2) {
            return o1.name.compareTo(o2.name);
        }
    }

    private static class BySection implements Comparator<studentComparator>{
        @Override
        public int compare(studentComparator o1, studentComparator o2) {
            return o1.section - o2.section;
        }
    }
}
