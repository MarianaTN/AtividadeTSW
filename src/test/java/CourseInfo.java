import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static org.junit.Assert.assertEquals;

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

    @FindBy(xpath = "/html/body/app/div/main/app-dashboard/div/div[3]/div/div[1]/ul/li[1]/div/div[3]/a")
    private WebElement editButtonHome;

    @FindBy(id = "input-put-course-name")
    private WebElement titleTextHome;

    @FindBy(id = "submit-put-course-btn")
    private WebElement sendButtonHome;

    @FindBy(id = "label-delete-checkbox")
    private WebElement deleteCheckboxHome;

    @FindBy(id = "input-post-course-name")
    private WebElement titleCourse;

    @FindBy(id = "submit-post-course-btn")
    private WebElement sendButtonAdd;

    public CourseInfo(WebDriver driver) {

        this.driver = driver;
    }

    public void InsertDescription(String description) {
        infoTextboxEnable.sendKeys(description);
        sendButton.click();

        PageFactory.initElements((WebDriver) driver, this);

        assertEquals(infoTextbox.getText(), description);
    }

    public void InsertTitle(String description) {
        editButtonHome.click();
        titleTextHome.sendKeys(description);
        sendButtonHome.submit();

        PageFactory.initElements((WebDriver) driver, this);
    }

    public void DeleteCourse() {
        editButtonHome.click();
        deleteCheckboxHome.click();

        PageFactory.initElements((WebDriver) driver, this);
    }

    public void AddCourse(String title) {
        titleCourse.sendKeys(title);
        sendButtonAdd.submit();

        PageFactory.initElements((WebDriver) driver, this);
    }

}
