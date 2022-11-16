package com.calendar.enums;

public enum TypeDay {
	NGAYNGHI("NGAYNGHI"), NGAYLAM("NGAYLAM");
	
	private String typeDay;
	 
    private TypeDay(String typeDay) {
        this.typeDay = typeDay;
    }
 
    public String getTypeDay() {
        return typeDay;
    }
    
    public static TypeDay fromTypeDay(String typeDay) {
        switch (typeDay) {
        case "NGAYLAM":
            return TypeDay.NGAYLAM;
 
        case "NGAYNGHI":
            return TypeDay.NGAYNGHI;
        default:
            throw new IllegalArgumentException("TypeDay [" + typeDay
                    + "] not supported.");
        }
    }
}
