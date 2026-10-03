package com.champ.GmailServer;

public class EmailDto {
    private String playerName;
    private String registrationId;
    private String category;
    private String proficiency;
    private String email;

    public EmailDto() {
    }

    public String getPlayerName() {
        return playerName;
    }

    public String getProficiency() {
        return proficiency;
    }

    public String getCategory() {
        return category;
    }

    public String getRegistrationId() {
        return registrationId;
    }

    public String getEmail(){
        return email;
    }
}
