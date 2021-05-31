package com.tarpe19.mobiiltunniplaan;

public class TunniplaaniModel {

    private int id;
    private String group_name;
    private int date;
    private int teacher_name;
    private int day;
    private boolean isActive;

    // Construct


    public TunniplaaniModel(int id, String group_name, int date, int teacher_name, int day, boolean isActive) {
        this.id = id;
        this.group_name = group_name;
        this.date = date;
        this.teacher_name = teacher_name;
        this.day = day;
        this.isActive = isActive;
    }

    public TunniplaaniModel(int tunniplaaniID, String groupName, int date, String aClass, String teacherName, String day) {
    }

    @Override
    public String toString() {
        return "TunniplaaniModel{" +
                "id=" + id +
                ", group_name='" + group_name + '\'' +
                ", date=" + date +
                ", teacher_name=" + teacher_name +
                ", day=" + day +
                ", isActive=" + isActive +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public static String getGroup_name() {
        return getGroup_name();
    }

    public void setGroup_name(String group_name) {
        this.group_name = group_name;
    }

    public int getDate() {
        return date;
    }

    public void setDate(int date) {
        this.date = date;
    }

    public int getTeacher_name() {
        return teacher_name;
    }

    public void setTeacher_name(int teacher_name) {
        this.teacher_name = teacher_name;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }
}

