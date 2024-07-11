import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.IDataProviderAnnotation;
import org.testng.annotations.Test;
import javax.swing.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

public class HerokuApp {

    @Test
    public void CompleteWebForm() throws IOException {
        ChromeOptions options = new ChromeOptions();
        //options.addArguments("--headless");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();


        int iterations = 1; //
        for (int i = 0; i < iterations; i++) {
            String firstName = FileReaderUtil.getNextName();
            String lastName = FileReaderUtil.getNextLastname();
            String date = FileReaderUtil.getNextDate();
            String jobTitlee = FileReaderUtil.getNextJobTitle();
            Random rand = new Random();
            int RandomSchool = rand.nextInt(3) + 1;
            int RandomSex = rand.nextInt(3) + 1;
            int RandomExp = rand.nextInt(4) + 1;
            driver.get("https://formy-project.herokuapp.com/form");
            WebElement imie = driver.findElement(By.xpath("//input[@placeholder='Enter first name']"));
            imie.click();
            imie.sendKeys(firstName);
            WebElement lastname = driver.findElement(By.xpath("//input[@placeholder='Enter last name']"));
            lastname.click();
            lastname.sendKeys(lastName);
            WebElement jobTitle = driver.findElement(By.xpath("//input[@placeholder='Enter your job title']"));
            jobTitle.click();
            jobTitle.sendKeys(jobTitlee);
            //Education selector
            switch (RandomSchool) {
                case 1:
                    WebElement highSchool = driver.findElement(By.xpath("//input[@id='radio-button-1']"));
                    highSchool.click();
                    break;
                case 2:
                    WebElement College = driver.findElement(By.xpath("//input[@id='radio-button-2']"));
                    College.click();
                    break;

                case 3:
                    WebElement grandSchool = driver.findElement(By.xpath("//input[@id='radio-button-3']"));
                    grandSchool.click();
                    break;
            }
            //Sex selector
            switch (RandomSex) {
                case 1:
                    WebElement sexMale = driver.findElement(By.xpath("//input[@id='checkbox-1']"));
                    sexMale.click();
                    break;
                case 2:
                    WebElement sexFemale = driver.findElement(By.xpath("//input[@id='checkbox-2']"));
                    sexFemale.click();
                    break;
                case 3:
                    WebElement sexNot = driver.findElement(By.xpath("//input[@id='checkbox-3']"));
                    sexNot.click();
                    break;

            }
            WebElement yearsOfExperienceList = driver.findElement(By.xpath("//select[@id='select-menu']"));
            yearsOfExperienceList.click();
            switch (RandomExp) {
                case 1:
                    WebElement option01 = driver.findElement(By.xpath("//option[text()='0-1']"));
                    option01.click();
                    break;
                case 2:
                    WebElement option24 = driver.findElement(By.xpath("//option[text()='2-4']"));
                    option24.click();
                    break;
                case 3:
                    WebElement option59 = driver.findElement(By.xpath("//option[text()='5-9']"));
                    option59.click();
                    break;
                case 4:
                    WebElement option10 = driver.findElement(By.xpath("//option[text()='10+']"));
                    option10.click();
                    break;
            }
            WebElement dateElement = driver.findElement(By.xpath("//input[@id='datepicker']"));
            dateElement.click();
            dateElement.sendKeys(date);
            WebElement submit = driver.findElement(By.xpath("//a[text()='Submit']"));
            submit.click();
        }


        driver.quit();
    }

    @Test
    public void Autocomplete() throws IOException {
        ChromeOptions option = new ChromeOptions();
        //option.addArguments("--headless");
        WebDriver driver = new ChromeDriver(option);
        driver.manage().window().maximize();
        int interactions = 1;
        for (int i = 0; i < interactions; i++) {
            String Adress = FileReader.getNextAddress();
            String City = FileReader.getNextCity();
            String Contry = FileReader.getNextCountry();
            String State = FileReader.getNextState();
            String StreetName = FileReader.getNextStreetName();
            String ZipCode = FileReader.getNextZipCode();

            driver.get("https://formy-project.herokuapp.com/autocomplete");
            WebElement enterAdress = driver.findElement(By.xpath("//input[@placeholder='Enter address']"));
            enterAdress.click();
            enterAdress.sendKeys(Adress);
            WebElement streetAdress = driver.findElement(By.xpath("//input[@placeholder='Street address']"));
            streetAdress.click();
            streetAdress.sendKeys(StreetName);
            WebElement streetAdress2 = driver.findElement(By.xpath("//input[@placeholder='Street address 2']"));
            streetAdress2.click();
            streetAdress2.sendKeys(StreetName);
            WebElement city = driver.findElement(By.xpath("//input[@placeholder='City']"));
            city.click();
            city.sendKeys(City);
            WebElement state = driver.findElement(By.xpath("//input[@placeholder='State']"));
            state.click();
            state.sendKeys(State);
            WebElement zipcode = driver.findElement(By.xpath("//input[@placeholder='Zip code']"));
            zipcode.click();
            zipcode.sendKeys(ZipCode);
            WebElement country = driver.findElement(By.xpath("//input[@placeholder='Country']"));
            country.click();
            country.sendKeys(Contry);
            driver.navigate().refresh();
        }
    }

    @Test
    public void Buttons() {
        ChromeOptions option = new ChromeOptions();
        option.addArguments("--headless");
        WebDriver driver = new ChromeDriver(option);
        driver.manage().window().maximize();

        driver.get("https://formy-project.herokuapp.com/buttons");
        WebElement primarryButton = driver.findElement(By.xpath("//button[text()='Primary']"));
        primarryButton.click();
        WebElement successButton = driver.findElement(By.xpath("//button[text()='Success']"));
        successButton.click();
        WebElement infoButton = driver.findElement(By.xpath("//button[text()='Info']"));
        infoButton.click();
        WebElement warningButton = driver.findElement(By.xpath("//button[text()='Warning']"));
        warningButton.click();
        WebElement dangerButton = driver.findElement(By.xpath("//button[text()='Danger']"));
        dangerButton.click();
        WebElement linkButton = driver.findElement(By.xpath("//button[text()='Link']"));
        linkButton.click();
        WebElement leftButton = driver.findElement(By.xpath("//button[text()='Left']"));
        leftButton.click();
        WebElement middleButton = driver.findElement(By.xpath("//button[text()='Middle']"));
        middleButton.click();
        WebElement rightButton = driver.findElement(By.xpath("//button[text()='Right']"));
        rightButton.click();
        WebElement oneButton = driver.findElement(By.xpath("//button[text()='1']"));
        oneButton.click();
        WebElement twoButton = driver.findElement(By.xpath("//button[text()='2']"));
        twoButton.click();
        WebElement dropdownButton = driver.findElement(By.xpath("//button[@class='btn btn-lg btn-primary dropdown-toggle']"));
        dropdownButton.click();
        WebElement dropdownLinkOneButton = driver.findElement(By.xpath("//a[text()='Dropdown link 1']"));
        dropdownLinkOneButton.click();
        dropdownButton.click();
        WebElement dropdownLinkTwoButton = driver.findElement(By.xpath("//a[text()='Dropdown link 2']"));
        dropdownLinkTwoButton.click();


        driver.quit();


    }

    @Test
    public void Checkboxes() {
        ChromeOptions option = new ChromeOptions();
        option.addArguments("--headless");
        WebDriver driver = new ChromeDriver(option);
        driver.manage().window().maximize();

        driver.get("https://formy-project.herokuapp.com/checkbox");
        WebElement Checkbox1 = driver.findElement(By.id("checkbox-1"));
        Checkbox1.click();
        WebElement Checkbox2 = driver.findElement(By.id("checkbox-2"));
        Checkbox2.click();
        WebElement Checkbox3 = driver.findElement(By.id("checkbox-3"));
        Checkbox3.click();

    }

    @Test
    public void Datepicker() {
        ChromeOptions option = new ChromeOptions();
        option.addArguments("--headless");
        WebDriver driver = new ChromeDriver(option);
        driver.manage().window().maximize();
        int instancje = 10;
        for (int i = 0; i < instancje; i++) {
            Random random = new Random();
            int month = random.nextInt(12) + 1;
            int day = random.nextInt(30) + 1;
            int year = random.nextInt(21) + 2000;
            String date = String.format("%02d/%02d/%04d", month, day, year);
            driver.get("https://formy-project.herokuapp.com/datepicker");
            WebElement dateElement = driver.findElement(By.xpath("//input[@id='datepicker']"));
            dateElement.click();
            dateElement.sendKeys(date);
            driver.navigate().refresh();
        }

    }

    @Test
    public void dragAndDrop() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();

        driver.get("https://formy-project.herokuapp.com/dragdrop");
        WebElement drag = driver.findElement(By.xpath("//div[@class='ui-widget-content ui-draggable ui-draggable-handle']"));
        WebElement drop = driver.findElement(By.xpath("//div[@class='ui-widget-header ui-droppable']"));

        Actions action = new Actions(driver);
        action.dragAndDrop(drag, drop).build().perform();
        driver.quit();
    }

    @Test
    public void dropdown() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();

        driver.get("https://formy-project.herokuapp.com/dropdown");
        WebElement dropdown = driver.findElement(By.xpath("//button[@id='dropdownMenuButton']"));
        dropdown.click();

        WebElement dropdownDropdown = driver.findElement(By.linkText("Dropdown"));
        dropdownDropdown.click();
        driver.quit();
    }

    @Test
    public void enabledAndDisabledElements() throws IOException {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();

        driver.get("https://formy-project.herokuapp.com/enabled");
        WebElement enabledElement = driver.findElement(By.xpath("//input[@id='input']"));
        enabledElement.click();
        enabledElement.sendKeys("sadkjaskdjgskdjhga");
    }

    @Test
    public void uploadFile() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();

        driver.get("https://formy-project.herokuapp.com/fileupload");
        WebElement chooseFile = driver.findElement(By.xpath("//input[@id='file-upload-field']"));
        chooseFile.sendKeys("C:\\Users\\brykd.DESKTOP-EHLBJ6D\\Desktop\\projekt magnes\\ULTRA.png>");
        driver.quit();
    }

    @Test
    public void uploadFile2() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();

        driver.get("https://system.erecruiter.pl/FormTemplates/RecruitmentForm.aspx?WebID=b6093d1364904fbdbc9f738339d66fc9");
        WebElement chooseFile = driver.findElement(By.xpath("//input[@name='ctl00$DefaultContent$ctl45$fuCv']"));
        chooseFile.sendKeys("C:\\Users\\brykd.DESKTOP-EHLBJ6D\\Desktop\\projekt magnes\\ULTRA.png");


    }
    @Test
    public void keyboardAndMouse(){
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();

        driver.get("https://formy-project.herokuapp.com/keypress");
        WebElement fullName = driver.findElement(By.xpath("//input[@id='name']"));
        fullName.click();
        fullName.sendKeys("Dawjkfasdh afdskljhfadslkjhflk");

        driver.findElement(By.xpath("//button[@id='button']")).click();
    }
    @Test
    public void modal() throws InterruptedException {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();

        driver.get("https://formy-project.herokuapp.com/modal");
        WebElement modal = driver.findElement(By.xpath("//button[@id='modal-button']"));
        modal.click();
        Thread.sleep(2000);

        WebElement ok = driver.findElement(By.xpath("//button[@id='ok-button']"));
        ok.click();
        Thread.sleep(2000);
        WebElement close = driver.findElement(By.xpath("//button[@id='close-button']"));
        close.click();
        Thread.sleep(2000);
        driver.quit();

    }
    @Test
    public void pageScroll(){

        ChromeOptions options = new ChromeOptions();
        //options.addArguments("--headless");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();

        driver.get("https://formy-project.herokuapp.com/scroll");

        WebElement fullName = driver.findElement(By.xpath("//input[@id='name']"));
        WebElement date = driver.findElement(By.xpath("//input[@id='date']"));
        fullName.sendKeys("kjdsahfkjsdf");
        date.sendKeys("02/02/2000");


        driver.quit();
    }
    @Test
    public void radioButtons() throws InterruptedException {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();

        driver.get("https://formy-project.herokuapp.com/radiobutton");
        WebElement radio1 = driver.findElement(By.xpath("//input[@id='radio-button-1']"));
        WebElement radio2 = driver.findElement(By.xpath("//input[@value='option2']"));
        WebElement radio3 = driver.findElement(By.xpath("//input[@value='option3']"));

        if(!radio1.isSelected()) {
            radio1.click();
            Thread.sleep(2000);
        }

        radio2.click();
        Thread.sleep(2000);

        radio3.click();
        Thread.sleep(2000);

        driver.quit();
    }
    @Test
    public void switchWindow() throws InterruptedException {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();

        driver.get("https://formy-project.herokuapp.com/switch-window");
        WebElement openNewTab = driver.findElement(By.xpath("//button[@id='new-tab-button']"));
        WebElement openAlert = driver.findElement(By.xpath("//button[@id='alert-button']"));
        openAlert.click();
        driver.switchTo().alert().accept();

        openNewTab.click();
        ArrayList<String> tabs = new ArrayList (driver.getWindowHandles());
        System.out.println(tabs.size());
        Thread.sleep(2000);
        driver.switchTo().window(tabs.get(0));
        Thread.sleep(2000);
        driver.switchTo().window(tabs.get(1));
    }
}

