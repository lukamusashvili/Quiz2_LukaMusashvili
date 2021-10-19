import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.List;
public class Quiz2Test {
    @Test
    public void main(){
        WebDriverManager.chromedriver().setup();

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless");

        WebDriver driver = new ChromeDriver(options);

        String url1 = "https://demoqa.com/progress-bar";
        driver.get(url1);
        driver.findElement(By.id("startStopButton")).click();

        WebElement progressBar = driver.findElement(By.xpath("/html/body/div[2]/div/div/div[2]/div[2]/div[1]/div[2]/div"));

        WebDriverWait waitForTheProgressBar = new WebDriverWait(driver,20);
        waitForTheProgressBar.until(ExpectedConditions.attributeContains(progressBar, "aria-valuenow", "100"));
        System.out.println("100%");
    }

    @Test
    public void theSecondTest(){
        WebDriverManager.chromedriver().setup();

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless");

        WebDriver driver = new ChromeDriver(options);

        String url2 = "https://webdriveruniversity.com/Dropdown-Checkboxes-RadioButtons/index.html";
        driver.get(url2);
        WebElement Options = driver.findElement(By.xpath("/html/body/div/div[2]/div/div/select[1]"));
        Select select = new Select(Options);
        select.selectByVisibleText("C#");

        WebElement checkboxes = driver.findElement(By.xpath("/html/body/div/div[3]/div/div"));
        List<WebElement> checkboxList = checkboxes.findElements(By.xpath("//label/input"));

        for (WebElement element : checkboxList) {
            if (!element.isSelected()){
                element.click();
            }
        }

        WebElement radios = driver.findElement(By.xpath("/html/body/div/div[4]/div/div/form"));
        WebElement yellowRadio = radios.findElement(By.xpath("//input[@value='yellow']"));
        yellowRadio.click();

        WebElement selectedDisabled = driver.findElement(By.xpath("/html/body/div/div[5]/div/div/select"));
        boolean isDisabled = !selectedDisabled.findElement(By.xpath("//option[@value='orange']")).isEnabled();
        System.out.println(isDisabled);
    }
}
