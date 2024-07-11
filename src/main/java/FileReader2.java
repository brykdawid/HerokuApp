import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileReader2 {
    private static List<String> FullNamesList = new ArrayList<>();
    private static List<String> EmailList = new ArrayList<>();
    private static List<String> CurrentAdressList = new ArrayList<>();
    private static List<String> PermamentAdressList = new ArrayList<>();
    private static int currentIndexFullNameList = 0;
    private static int currentIndexEmailList = 0;
    private static int currentIndexCurrentAdressList = 0;
    private static int currentIndexPermamantAdressList = 0;


    public static void fileReader(String fileName, List<String> list) throws IOException {
        ClassLoader classLoader = FileReader.class.getClassLoader();
        try (InputStream inputStream = classLoader.getResourceAsStream(fileName);
             BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream))) {
            if (inputStream == null) {
                throw new IOException("Niepoprawne dane, nie znaleziono pliku" + fileName);

            }
            list.addAll(reader.lines().toList());
        }

    }

    public static synchronized String getNextFullName() throws IOException {
        if (FullNamesList.isEmpty()) {
            fileReader("FullName", FullNamesList);
        }
        String nextFullName = FullNamesList.get(currentIndexFullNameList);
        currentIndexFullNameList = (currentIndexFullNameList + 1) % FullNamesList.size();
        return nextFullName;

    }

    public static synchronized String getNextEmail() throws IOException {
        if (EmailList.isEmpty()) {
            fileReader("Email", EmailList);
        }
        String nextEmail = EmailList.get(currentIndexEmailList);
        currentIndexEmailList = (currentIndexEmailList + 1) % EmailList.size();
        return nextEmail;
    }

    public static synchronized String getNextCurrentAdress() throws IOException {
        if (CurrentAdressList.isEmpty()) {
            fileReader("CurrentAdress", CurrentAdressList);
        }
        String nextCurrentadress = CurrentAdressList.get(currentIndexCurrentAdressList);
        currentIndexCurrentAdressList = (currentIndexCurrentAdressList + 1) % CurrentAdressList.size();
        return nextCurrentadress;
    }

    public static synchronized String getNextPermamentAdress() throws IOException {
        if (PermamentAdressList.isEmpty()) {
            fileReader("PermamentAdress", PermamentAdressList);
        }
        String nextPermamentAdress = PermamentAdressList.get(currentIndexPermamantAdressList);
        currentIndexPermamantAdressList = (currentIndexPermamantAdressList + 1) % CurrentAdressList.size();
        return nextPermamentAdress;
    }
}

