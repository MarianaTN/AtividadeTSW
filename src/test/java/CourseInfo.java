import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CourseInfo {

    private WebDriver driver;

    @FindBy(id="edit-course-info")
    private WebElement editButton;

    @FindBy(xpath="/html/body/app/div/main/app-course-details/div/div[4]/md-tab-group/div[2]/div[1]/div/div[2]/app-error-message/div")
    private WebElement infoTextbox;

    @FindBy(xpath = "/html/body/app/div/main/app-course-details/div/div[4]/md-tab-group/div[2]/div[1]/div/div[2]/p-editor/div/div[2]/div[1]")
    private WebElement infoTextboxEnable;

    @FindBy(id = "send-info-btn")
    private WebElement sendButton;

    @FindBy(xpath = "/html/body/app/div/main/app-course-details/div/div[4]/md-tab-group/div[2]/div[1]/div/div[2]/div/a[1]")
    private WebElement cancelButton;

    @FindBy(xpath = "/html/body/app/div/main/app-course-details/div/div[4]/md-tab-group/div[2]/div[1]/div/div[2]/div/a[2]")
    private WebElement previewButton;

    public CourseInfo(WebDriver driver) {

        this.driver = driver;
    }

    public CourseInfo InsertDescription(String description) {
        infoTextboxEnable.sendKeys(description);

        PageFactory.initElements((WebDriver) driver, this);

        sendButton.click();

        return this;
    }

}
