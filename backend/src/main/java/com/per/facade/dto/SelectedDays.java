package com.per.facade.dto;

import lombok.Data;

@Data
public class SelectedDays {

    private boolean monday;
    private boolean tuesday;
    private boolean wednesday;
    private boolean thursday;
    private boolean friday;
    private boolean saturday;
    private boolean sunday;

    public void setDay(int dayNumber, boolean isSelected) {
        switch (dayNumber) {
            case 0 :
                this.setMonday(isSelected);
                return;
            case 1 :
                this.setTuesday(isSelected);
                return;
            case 2 :
                this.setWednesday(isSelected);
                return;
            case 3 :
                this.setThursday(isSelected);
                return;
            case 4 :
                this.setFriday(isSelected);
                return;
            case 5 :
                this.setSaturday(isSelected);
                return;
            case 6 :
                this.setSunday(isSelected);
                return;
            default: throw new IllegalArgumentException("dayNumber must be from 0 to 6");
        }
    }

    public boolean getDay(int dayNumber) {
        switch (dayNumber) {
            case 0 : return this.isMonday();
            case 1 : return this.isTuesday();
            case 2 : return this.isWednesday();
            case 3 : return this.isThursday();
            case 4 : return this.isFriday();
            case 5 : return this.isSaturday();
            case 6 : return this.isSunday();
            default: throw new IllegalArgumentException("dayNumber must be from 0 to 6");
        }
    }

}
