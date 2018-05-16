import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CourseFile {

    private WebDriver driver;

    @FindBy(xpath="/html/body/app/div/main/app-course-details/div/div[3]/md-tab-group/div[2]/div[4]/div/div[1]/app-file-group/div/div[2]/div[1]/div")
    private WebElement fileLink;

    public CourseFile(WebDriver driver) {

        this.driver = driver;
    }

    public void DownloadFile(){
        fileLink.click();
    }
}
