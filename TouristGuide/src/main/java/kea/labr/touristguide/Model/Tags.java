package kea.labr.touristguide.Model;

public enum Tags {
    ART("Kunst"),
    MUSEUM("Museum"),
    DISABILITY_FRIENDLY("Handikapvenligt"),
    CHILD_FRIENDLY("Børnevenlig"),
    NATURE("Natur"),
    FOR_FREE("Gratis");

    private final String displayName;

    Tags(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return this.displayName;
    }

}