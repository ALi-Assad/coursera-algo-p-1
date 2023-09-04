package secondWeek.Sort.Date;

public class DateComparable implements Comparable<DateComparable> {
    public final int year, month, day;

    public DateComparable(int y, int m, int d) {
        year = y;
        month = m;
        day = d;
    }

    public int compareTo(DateComparable that) {
        if (this.year < that.year) return -1;
        if (this.year > that.year) return +1;
        if (this.month < that.month) return -1;
        if (this.month > that.month) return +1;
        if (this.day < that.day) return -1;
        if (this.day > that.day) return +1;
        return 0;
    }
}
