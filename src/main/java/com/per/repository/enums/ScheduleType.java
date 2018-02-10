package com.per.repository.enums;

public enum ScheduleType {

    STANDART(PeriodType.WEEK, 4),
    LOVE(PeriodType.DAY, 7),
    INSANE(PeriodType.WEEK, 52);

    private PeriodType period;
    private Integer recurrenceCount;

    ScheduleType(PeriodType period, Integer recurrenceCount) {
        this.period = period;
        this.recurrenceCount = recurrenceCount;
    }

    public PeriodType getPeriod() {
        return period;
    }

    public Integer getRecurrenceCount() {
        return recurrenceCount;
    }
}
