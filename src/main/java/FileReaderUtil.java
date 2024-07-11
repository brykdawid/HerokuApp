import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class FileReaderUtil {
    private static List<String> namesList = new ArrayList<>();
    private static List<String> lastnamesList = new ArrayList<>();
    private static List<String> datesList = new ArrayList<>();
    private static List<String> jobTitleList = new ArrayList<>();
    private static int currentIndexNames = 0;
    private static int currentIndexLastnames = 0;
    private static int currentIndexDates = 0;
    private static int currentIndexjobTitles = 0;

    public static void loadFile(String fileName, List<String> list) throws IOException {
        ClassLoader classLoader = FileReaderUtil.class.getClassLoader();
        try (InputStream inputStream = classLoader.getResourceAsStream(fileName);
             BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream))) {
            if (inputStream == null) {
                throw new IOException("File not found: " + fileName);
            }
            list.addAll(reader.lines().toList());
        }
    }

    public static synchronized String getNextName() throws IOException {
        if (namesList.isEmpty()) {
            loadFile("names.txt", namesList);
        }
        String nextName = namesList.get(currentIndexNames);
        currentIndexNames = (currentIndexNames + 1) % namesList.size();
        return nextName;
    }

    public static synchronized String getNextLastname() throws IOException {
        if (lastnamesList.isEmpty()) {
            loadFile("lastnames.txt", lastnamesList);
        }
        String nextLastname = lastnamesList.get(currentIndexLastnames);
        currentIndexLastnames = (currentIndexLastnames + 1) % lastnamesList.size();
        return nextLastname;
    }

    public static synchronized String getNextDate() throws IOException {
        if (datesList.isEmpty()) {
            loadFile("dates.txt", datesList);
        }
        String nextDate = datesList.get(currentIndexDates);
        currentIndexDates = (currentIndexDates + 1) % datesList.size();
        return nextDate;
    }
    public static synchronized String getNextJobTitle() throws IOException{
        if(jobTitleList.isEmpty()){
            loadFile("jobTitles", jobTitleList);
        }
        String nextJobTitle = jobTitleList.get(currentIndexjobTitles);
        currentIndexjobTitles = (currentIndexjobTitles+1) % datesList.size();
        return nextJobTitle;
    }
}
