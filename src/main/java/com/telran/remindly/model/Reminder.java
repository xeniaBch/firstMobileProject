package com.telran.remindly.model;

public class Reminder {
    private  String text;
    private  int time;
    private  int millis;
    private  String month;
    private  int number;
    private  String monthType;
    private  int day;
    private  String year;
    private  String yearType;
    private  String timeOfDay;
    private  int xHour;
    private  int yHour;
    private  int xMinute;
    private  int yMinute;
    private  String repeats;

    public Reminder setText(String text) {
        this.text = text;
        return this;
    }

    public Reminder setTime(int time) {
        this.time = time;
        return this;

    }

    public Reminder setMillis(int millis) {
        this.millis = millis;
        return this;

    }

    public Reminder setMonth(String month) {
        this.month = month;
        return this;

    }

    public Reminder setNumber(int number) {
        this.number = number;
        return this;

    }

    public Reminder setMonthType(String monthType) {
        this.monthType = monthType;
        return this;

    }

    public Reminder setDay(int day) {
        this.day = day;
        return this;

    }

    public Reminder setYear(String year) {
        this.year = year;
        return this;

    }

    public Reminder setYearType(String yearType) {
        this.yearType = yearType;
        return this;

    }

    public Reminder setTimeOfDay(String timeOfDay) {
        this.timeOfDay = timeOfDay;
        return this;

    }

    public Reminder setxHour(int xHour) {
        this.xHour = xHour;
        return this;

    }

    public Reminder setyHour(int yHour) {
        this.yHour = yHour;
        return this;

    }

    public Reminder setxMinute(int xMinute) {
        this.xMinute = xMinute;
        return this;

    }

    public Reminder setyMinute(int yMinute) {
        this.yMinute = yMinute;
        return this;

    }

    public Reminder setRepeats(String repeats) {
        this.repeats = repeats;
        return this;

    }

    public String getText() {
        return text;
    }

    public int getTime() {
        return time;
    }

    public int getMillis() {
        return millis;
    }

    public String getMonth() {
        return month;
    }

    public int getNumber() {
        return number;
    }

    public String getMonthType() {
        return monthType;
    }

    public int getDay() {
        return day;
    }

    public String getYear() {
        return year;
    }

    public String getYearType() {
        return yearType;
    }

    public String getTimeOfDay() {
        return timeOfDay;
    }

    public int getxHour() {
        return xHour;
    }

    public int getyHour() {
        return yHour;
    }

    public int getxMinute() {
        return xMinute;
    }

    public int getyMinute() {
        return yMinute;
    }

    public String getRepeats() {
        return repeats;
    }
}
