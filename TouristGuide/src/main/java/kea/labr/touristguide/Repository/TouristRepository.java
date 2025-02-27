package kea.labr.touristguide.Repository;

import kea.labr.touristguide.Model.Tags;
import kea.labr.touristguide.Model.TouristAttraction;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class TouristRepository {
    private String touristName;
    private String touristDescription;
    private final List<TouristAttraction> touristAttractions = new ArrayList<>();

    public TouristRepository() {
        allTouristAttraction();
    } // Konstuktør der initialiserer listen over alle turistattraktioner

    public TouristAttraction addAttraction(TouristAttraction touristAttraction) { // Metode til at tilføje en ny attraktion
        touristAttractions.add(touristAttraction);
        return touristAttraction;
    }

    public TouristAttraction addTouristAttraction(String name, String description, String city, List<Tags> tags) { // Opretter og tilføjer en ny turistattraktion baseret på de givne parametre
        TouristAttraction touristAttraction = new TouristAttraction(name, description, city);
        touristAttraction.setTags(tags);
        this.touristAttractions.add(touristAttraction);
        return touristAttraction;
    }

    public String getTouristName() {
        return touristName;
    }

    public void allTouristAttraction() { // Initialiserer listen med foruddefinerede turistattraktioner
        addTouristAttraction("Tivoli", "En af verdens ældste forlystelsesparker med smukke haver, forlystelser og restauranter.", "København", List.of(Tags.CHILD_FRIENDLY, Tags.DISABILITY_FRIENDLY));
        addTouristAttraction("Den Lille Havfrue", "Den ikoniske statue inspireret af H.C. Andersens eventyr, placeret ved Langelinie.", "København", List.of(Tags.FOR_FREE, Tags.DISABILITY_FRIENDLY));
        addTouristAttraction("Legoland", "En populær familiepark fyldt med forlystelser og imponerende LEGO-modeller.", "Billund", List.of(Tags.CHILD_FRIENDLY, Tags.DISABILITY_FRIENDLY));
        addTouristAttraction("Nyhavn", "Et charmerende havneområde med farverige bygninger, restauranter og en maritim stemning.", "København", List.of(Tags.FOR_FREE, Tags.DISABILITY_FRIENDLY));
        addTouristAttraction("Kronborg Slot", "Det berømte slot fra Shakespeares Hamlet, med en rig historie og imponerende arkitektur.", "Helsingør", List.of(Tags.MUSEUM, Tags.ART, Tags.DISABILITY_FRIENDLY));
        addTouristAttraction("Rundetårn", "Et historisk tårn med en unik spiralrampe og en fantastisk udsigt over København.", "København", List.of(Tags.MUSEUM, Tags.DISABILITY_FRIENDLY));
        addTouristAttraction("Nationalmuseet", "Danmarks største museum for kulturhistorie med udstillinger fra oldtid til nutid.", "København", List.of(Tags.MUSEUM, Tags.DISABILITY_FRIENDLY));
        addTouristAttraction("Aros Aarhus Kunstmuseum", "Moderne kunstmuseum kendt for den ikoniske regnbuepanorama på taget.", "Aarhus", List.of(Tags.MUSEUM, Tags.ART, Tags.DISABILITY_FRIENDLY));
        addTouristAttraction("Den Gamle By", "Et levende frilandsmuseum, der viser dansk byliv fra forskellige tidsperioder.", "Aarhus", List.of(Tags.MUSEUM, Tags.CHILD_FRIENDLY));
        addTouristAttraction("Ribe Vikingecenter", "En autentisk rekonstruktion af en vikingeby med aktiviteter og levende historieformidling.", "Ribe", List.of(Tags.MUSEUM, Tags.CHILD_FRIENDLY));
        addTouristAttraction("Lalandia", "En populær ferie- og vandlandresort med aktiviteter for hele familien.", "Billund", List.of(Tags.CHILD_FRIENDLY, Tags.DISABILITY_FRIENDLY));
        addTouristAttraction("Djurs Sommerland", "En af Danmarks største forlystelsesparker med rutsjebaner og vandland.", "Nimtofte", List.of(Tags.CHILD_FRIENDLY));
        addTouristAttraction("Fårup Sommerland", "En stor forlystelsespark i Nordjylland med forlystelser og naturaktiviteter.", "Blokhus", List.of(Tags.CHILD_FRIENDLY, Tags.NATURE));
        addTouristAttraction("Egeskov Slot", "Et smukt renæssanceslot med store haver og en imponerende veteranbil- og motorcykelsamling.", "Kværndrup", List.of(Tags.MUSEUM, Tags.NATURE));
        addTouristAttraction("Møns Klint", "En af Danmarks mest spektakulære naturoplevelser med høje kridtklinter ud mod Østersøen.", "Møn", List.of(Tags.NATURE, Tags.FOR_FREE));
    }

    public List<TouristAttraction> getAllTouristAttractions() {
        return touristAttractions;
    } // Returnerer listen over alle turistattraktioner

    public TouristAttraction updateTouristAttraction(String name, TouristAttraction updateTouristAttraction) { // Opdaterer en eksisterende attraktion baseret på navnet.
        for (int i = 0; i < touristAttractions.size(); i++) {
            if (touristAttractions.get(i).getName().equalsIgnoreCase(name)) {
                // Bevar navnet fra den eksisterende attraktion
                updateTouristAttraction.setName(name);
                touristAttractions.set(i, updateTouristAttraction);
                return updateTouristAttraction;
            }
        }
        return null; // Returnér null, hvis attraktionen ikke blev fundet
    }

    public TouristAttraction findTouristAttractionByName(String name) { // Finder en attraktion baseret på navnet
        for(TouristAttraction t1 : touristAttractions) {
            if(t1.getName().equalsIgnoreCase(name)) {
                return t1;
            }
        }
        return null;
    }

    public TouristAttraction deleteTouristAttraction(String name) { // Sletter en attraktion, også baseret på navnet
        TouristAttraction attractionToDelete = findTouristAttractionByName(name);

        if (attractionToDelete != null) {
            touristAttractions.remove(attractionToDelete);
            return attractionToDelete;
        }
        return null; // Returnér null, hvis attraktionen ikke findes
    }

    public List<Tags> getTags(String attractionName) { // Returnerer tags fr en attraktion baseret på navnet
        for(TouristAttraction i : touristAttractions) {
            if (attractionName.equalsIgnoreCase(i.getName())) {
                return i.getTags();
            }
        }
        return null;
    }

    public List<String> allCities() { // Returnerer en liste over alle tilgængelige byer
        List<String> cities = new ArrayList<>();
        cities.add("København");
        cities.add("Aarhus");
        cities.add("Odense");
        cities.add("Fredericia");
        cities.add("Ballerup");
        cities.add("Viborg");
        cities.add("Køge");
        cities.add("Holstebro");
        cities.add("Aalborg");
        cities.add("Esbjerg");
        cities.add("Hørsholm");
        cities.add("Helsingør");
        cities.add("Silkeborg");
        cities.add("Næstved");
        cities.add("Randers");
        cities.add("Kolding");
        cities.add("Horsens");
        cities.add("Vejle");
        cities.add("Roskilde");
        cities.add("Herning");
        return cities;
    }

}
