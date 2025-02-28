package kea.labr.touristguide.Model;

import java.util.ArrayList;
import java.util.List;

public class TouristAttraction {

    // Instans-variabler, der repræsenterer en turistattraktion
    private String name; // Navn på attraktionen
    private String description; // Beskrivelse af attraktionen
    private List<Tags> tags; // Liste over tags, der kategoriserer attraktionen
    private String city; // Byen, hvor attraktionen befinder sig

    // Tom konstruktør (bruges når objektet oprettes uden værdier)
    public TouristAttraction(String name, String forlystelsesparkMidtIKøbenhavnCentrum) {
    }

    // Konstruktør til at oprette en attraktion med navn, beskrivelse og by
    public TouristAttraction(String name, String description, String city) {
        setName(name); // Sætter attraktionens navn
        setDescription(description); // Sætter beskrivelsen
        setCity(city); // Sætter byen
        tags = new ArrayList<>(); // Initialiserer en tom liste til tags
    }

    // Getter-metoder til at hente værdierne for hver variabel
    public String getName() {
        return name; // Returnerer attraktionens navn
    }

    public String getDescription() {
        return description; // Returnerer attraktionens beskrivelse
    }

    public List<Tags> getTags() {
        return tags; // Returnerer listen over tags
    }

    public String getCity() {
        return city; // Returnerer byen, hvor attraktionen befinder sig
    }

    // Setter-metoder til at opdatere værdierne for hver variabel
    public void setName(String name) {
        this.name = name; // Opdaterer attraktionens navn
    }

    public void setDescription(String description) {
        this.description = description; // Opdaterer attraktionens beskrivelse
    }

    public void setTags(List<Tags> tags) {
        this.tags = tags; // Opdaterer listen af tags
    }

    public void setCity(String city) {
        this.city = city; // Opdaterer byen
    }

    // toString-metode til at returnere attraktionens navn og beskrivelse som en String
    @Override
    public String toString() {
        return this.name + ": " + this.description;
    }
}