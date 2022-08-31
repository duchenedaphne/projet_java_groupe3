package org.doranco.projet_java_groupe3.document;

public enum EnumDocument {
    
    PIECE_IDENTITE ("Pièce d'identité"),
    FICHE_PAYE ("Fiche de paye"),
    CONTRAT_TRAVAIL ("Contrat de travail"),
    AVIS_IMPOSITION ("Avis d'imposition"),
    JUSTIFICATIF_DOMICILE ("Justificatif de domicile"),
    QUITTANCE_LOYER ("Quittance de loyer"),
    ACTE_PROPRIETE ("Avis d'imposition"),
    RIB ("RIB");

    private String type;

    EnumDocument(String type) {
        this.type = type;
    }
    
    public String getEnumDocument() {
        return type;
    }

}
