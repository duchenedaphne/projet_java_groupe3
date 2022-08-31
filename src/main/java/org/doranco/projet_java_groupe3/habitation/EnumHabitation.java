package org.doranco.projet_java_groupe3.habitation;

public enum EnumHabitation {

    APPARTEMENT ("Appartement"),
    MAISON ("Maison");

    private String type;

    EnumHabitation(String type) {
        this.type = type;
    }
    
    public String getEnumHabitation() {
        return type;
    }
}
