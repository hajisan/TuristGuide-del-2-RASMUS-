package kea.labr.touristguide.Model;

/*
 - Enum for tags, der bruges til at kategorisere turistattraktioner.
 - Hvert tag har en tilknyttet visningsværdi (displayName), der kan bruges i UI.
 */
public enum Tags {
    ART("Kunst"), // Tag for kunstrelaterede attraktioner
    MUSEUM("Museum"), // Tag for museer
    DISABILITY_FRIENDLY("Handikapvenligt"), // Angiver om attraktionen er handikapvenlig
    CHILD_FRIENDLY("Børnevenlig"), // Angiver om attraktionen er egnet til børn
    NATURE("Natur"), // Tag for naturoplevelser
    FOR_FREE("Gratis"); // Angiver at attraktionen er gratis

    private final String displayName; // Brugerdefineret visningsnavn for tagget

    // Konstruktør til at tildele en visningsværdi til hvert tag
    Tags(String displayName) {
        this.displayName = displayName;
    }

    // Getter-metode til at hente visningsnavnet
    public String getDisplayName() {
        return this.displayName;
    }
}