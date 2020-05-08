package cucumber.steps;


        import cucumber.AddAddressClass;
        import cucumber.api.PendingException;
        import cucumber.api.java.en.And;
        import cucumber.api.java.en.Given;
        import cucumber.api.java.en.Then;
        import org.openqa.selenium.By;
        import org.openqa.selenium.WebDriver;
        import org.openqa.selenium.WebElement;
        import org.openqa.selenium.chrome.ChromeDriver;
        import org.openqa.selenium.support.FindBy;
        import org.openqa.selenium.support.ui.Select;

public class AddAddressSteps extends AddAddressClass {
    private WebDriver driver;

    @Given("^Open browser with address: https://prod-kurs\\.coderslab\\.pl/index\\.php\\?controller=addresses$")
    public void OpenBrowserAndSetHomePage() {
        System.setProperty("webdriver.chrome.driver",
                "src/main/resources/drivers/chromedriver");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://prod-kurs.coderslab.pl/index.php?controller=addresses");
    }

    @Then("^Log in using user:elftiptfinbmkemsjc@awdrt\\.net with password: coderslab$")
    public void LogIn() {

        WebElement login = driver.findElement(By.name("email"));
        login.clear();
        login.sendKeys("elftiptfinbmkemsjc@awdrt.net");
        WebElement password = driver.findElement(By.name("password"));
        password.clear();
        password.sendKeys("coderslab");
        WebElement submitLogin = driver.findElement(By.id("submit-login"));
        submitLogin.click();

    }

    @Then("^Choose \"([^\"]*)\"$")
    public void addNew(String arg0) throws Throwable {
        WebElement addNew = driver.findElement(By.cssSelector(".addresses-footer > a:nth-child(1) > span:nth-child(2)"));
        addNew.click();
    }
    @Then("^Fill form using \"example\" table with fields: (.*),(.*),(.*),(.*),(.*)$")
    public void fillFormUsingTableWithFieldsAlias(String alias, String address, String city, String zipCode, String phone) throws Throwable {
        driver.findElement(By.name("alias")).sendKeys(alias);
        driver.findElement(By.name("address1")).sendKeys(address);
        driver.findElement(By.name("city")).sendKeys(city);
        driver.findElement(By.name("postcode")).sendKeys(zipCode);
        new Select(driver.findElement(By.name("id_country"))).selectByIndex(1);
        driver.findElement(By.name("phone")).sendKeys(phone);
        WebElement submitAddress = driver.findElement(By.cssSelector("#content > div > div > form > footer > button"));
        submitAddress.click();
        driver.close();
        throw new PendingException();
    }



}
