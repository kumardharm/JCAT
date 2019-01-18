package com.cg.jcat.api.entity;

public enum JournalType {

MISC_BILLING("Misc Billing"),
MISC_BILLING_AUTONUM("Misc Billing AutoNum"),
PRETTY_CASH("Petty Cash"),
RECURRING_AP("Recurring AP"),
GL_JOURNAL("GL Journal"),
GDS_NDS("GDS/NDS");

private final String journalType;

JournalType(String journalType) {
    this.journalType = journalType;
}

@Override
public String toString() {
    return journalType;
}

public static JournalType valueOfOrDefault(String myValue) {
    for(JournalType type : JournalType.class.getEnumConstants()) {
        if(type.toString().equals(myValue)) {
            return type;
        }
    }
   throw new IllegalArgumentException("JournalType not found");
}

}