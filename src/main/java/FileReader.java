import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class FileReader {
    private static List<String> AdressesList = new ArrayList<>();
    private static List<String> CityList = new ArrayList<>();
    private static List<String> CountryList = new ArrayList<>();
    private static List<String> StateList = new ArrayList<>();
    private static List<String> StreetNameList = new ArrayList<>();
    private static List<String> ZipCodeList = new ArrayList<>();
    private static int currentIndexAdress = 0;
    private static int currentIndexCity = 0;
    private static int currentIndexCountry = 0;
    private static int currentIndexState = 0;
    private static int currentIndexStreetName = 0;
    private static int currentIndexZipCode = 0;

    public static void fileRead(String fileName, List<String> list) throws IOException {
        ClassLoader classLoader = FileReader.class.getClassLoader();
        try (InputStream inputStream = classLoader.getResourceAsStream(fileName);
             BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream))) {
            if (inputStream == null) {
                throw new IOException("Niepoprawne dane, nie znaleziono pliku: " + fileName);
            }
            list.addAll(reader.lines().toList());
        }
    }

    public static synchronized String getNextAddress() throws IOException {
        if (AdressesList.isEmpty()) {
            fileRead("Adresses", AdressesList);
        }
        String nextAddress = AdressesList.get(currentIndexAdress);
        currentIndexAdress = (currentIndexAdress + 1) % AdressesList.size();
        return nextAddress;
    }

    public static synchronized String getNextCity() throws IOException {
        if (CityList.isEmpty()) {
            fileRead("City", CityList);
        }
        String nextCity = CityList.get(currentIndexCity);
        currentIndexCity = (currentIndexCity + 1) % CityList.size();
        return nextCity;
    }

    public static synchronized String getNextCountry() throws IOException {
        if (CountryList.isEmpty()) {
            fileRead("Country", CountryList);
        }
        String nextCountry = CountryList.get(currentIndexCountry);
        currentIndexCountry = (currentIndexCountry + 1) % CountryList.size();
        return nextCountry;
    }

    public static synchronized String getNextState() throws IOException {
        if (StateList.isEmpty()) {
            fileRead("State", StateList);
        }
        String nextState = StateList.get(currentIndexState);
        currentIndexState = (currentIndexState + 1) % StateList.size();
        return nextState;
    }

    public static synchronized String getNextStreetName() throws IOException {
        if (StreetNameList.isEmpty()) {
            fileRead("StreetName", StreetNameList);
        }
        String nextStreetName = StreetNameList.get(currentIndexStreetName);
        currentIndexStreetName = (currentIndexStreetName + 1) % StreetNameList.size();
        return nextStreetName;
    }

    public static synchronized String getNextZipCode() throws IOException {
        if (ZipCodeList.isEmpty()) {
            fileRead("ZipCode", ZipCodeList);
        }
        String nextZipCode = ZipCodeList.get(currentIndexZipCode);
        currentIndexZipCode = (currentIndexZipCode + 1) % ZipCodeList.size();
        return nextZipCode;
    }
}
