import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.Date;

public class CourseSession {
    private WebDriver driver;

    @FindBy(id="add-session-icon")
    private WebElement addButton;

    @FindBy(xpath="/html/body/app/div/main/app-course-details/div/div[4]/md-tab-group/div[2]/div[2]/div/ul/div[1]/li[1]/div/div[3]/a/i")
    private WebElement editButton;

    @FindBy(id="put-modal-btn")
    private WebElement sendButton;

    @FindBy(xpath="/html/body/app/div/main/app-course-details/div/div[1]/div/div/form/div[2]/a")
    private WebElement cancelButton;

    @FindBy(id="input-post-title")
    private WebElement titleText;

    @FindBy(id="input-post-comment")
    private WebElement descriptionText;

    @FindBy(id="input-post-date")
    private WebElement dateText;

    @FindBy(id="input-post-time")
    private WebElement timeText;

    @FindBy(id="label-delete-checkbox")
    private WebElement deleteCheckbox;

    @FindBy(xpath="/html/body/app/div/main/app-course-details/div/div[4]/md-tab-group/div[2]/div[2]/div/ul/div[1]/li[1]/div/div[1]")
    private WebElement sessionLabel;

    @FindBy(id = "fixed-icon")
    private WebElement menuConference;

    @FindBy(id = "message")
    private WebElement messageConference;

    @FindBy(xpath = "/html/body/app/div/main/app-video-session/div/ul/div/div/div[2]/form")
    private WebElement formConference;

    public CourseSession(WebDriver driver) {

        this.driver = driver;
    }

    public CourseSession EditSession(String title, String description, Date date, boolean delete) {
        titleText.sendKeys(title);
        descriptionText.sendKeys(description);
        dateText.sendKeys(date.toString());
        timeText.sendKeys(String.valueOf(date.getTime()));

        if(delete)
            deleteCheckbox.click();

        return this;
    }

    public CourseSession ConferenceSession(String message){
        sessionLabel.click();
        menuConference.click();
        messageConference.sendKeys(message);
        formConference.click();

        return this;
    }
}