import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.Date;

import static org.junit.Assert.assertTrue;

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

    @FindBy(id = "message")
    private WebElement messageConference;

    @FindBy(id = "send-btn")
    private WebElement sendButtonConference;

    @FindBy(id = "message_box")
    private WebElement messageBoxConference;

    @FindBy(id = "side-menu-button")
    private WebElement sideMenuConference;

    @FindBy(id = "show-chat-icon")
    private WebElement userChatIcon;

    @FindBy(id = "num-attenders-div")
    private WebElement onlineAttenders;

    @FindBy(xpath = "/html/body/app/div/main/app-video-session/div/div/div[1]/a")
    private WebElement expandButton;

    @FindBy(id = "exit-icon")
    private WebElement exitButton;

    public CourseSession(WebDriver driver) {

        this.driver = driver;
    }

    public CourseSession EditSession(String title, String description, Date date, boolean delete) {
        addButton.click();
        titleText.sendKeys(title);
        descriptionText.sendKeys(description);
        dateText.sendKeys(date.toString());
        timeText.sendKeys(String.valueOf(date.getTime()));

        if(delete)
            deleteCheckbox.click();

        return this;
    }

    public CourseSession ConferenceSession(String message){
        sideMenuConference.click();
        messageConference.sendKeys(message);
        sendButtonConference.submit();
        exitButton.click();
        //como não está funcionando, não sei como testar

        return this;
    }

    public void AttendersSession(){
        sideMenuConference.click();
        userChatIcon.click();

        assertTrue(onlineAttenders.isEnabled());
    }

    public void Expand(){
        expandButton.click();
    }
}
