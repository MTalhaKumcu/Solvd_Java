package com.solvd.laba.block1.task2.Enums;

public enum WeekDaysEnum {
    MONDAY(8, 17),
    TUESDAY(8, 17),
    WEDNESDAY(8, 17),
    THURSDAY(8, 17),
    FRIDAY(8, 17);

    private final int START_HOUR;
    private final int END_HOUR;

    WeekDaysEnum(int START_HOUR, int END_HOUR) {
        this.START_HOUR = START_HOUR;
        this.END_HOUR = END_HOUR;
    }

    public int getStartHour() {
        return START_HOUR;
    }

    public int getEndHour() {
        return END_HOUR;
    }

    public static void writeWeekDays() {
        for (WeekDaysEnum day : WeekDaysEnum.values()) {
            System.out.println("----------------------" + "\n" + day + "\n" +
                    " Starting hour: " + day.getStartHour() + "\n" +
                    " Ending hour: " + day.getEndHour());
        }

    }

}
