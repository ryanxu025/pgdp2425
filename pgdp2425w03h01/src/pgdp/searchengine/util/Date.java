package pgdp.searchengine.util;

public class Date {
    private int day;
    private int month;
    private int year;
    public Date(int day, int month, int year) {
        this.day = day;
        this.month = month;
        this.year = year;
    }


    public boolean equals(Date other) {
        return this.day == other.day && this.month == other.month && this.year == other.year;
    }

    @Override
    public String toString() {
        return this.day + "." + this.month + "." + this.year;
    }

    public int getDay() {
        return day;
    }

    public int getMonth() {
        return month;
    }

    public int getYear() {
        return year;
    }
}
