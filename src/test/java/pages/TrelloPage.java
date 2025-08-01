package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.*;

import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.time.Duration;

public class TrelloPage {
    WebDriver driver;
    WebDriverWait wait;
    Actions actions;

    public TrelloPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        actions = new Actions(driver);
    }

    private By loginBtn = By.xpath("//a[@data-uuid='MJFtCCgVhXrVl7v9HA7EH_login']");
    private By usernameField = By.id("username-uid1");
    private By continueBtn = By.xpath("//span[normalize-space()='Continue']");
    private By passwordField = By.id("password");
    private By loginSubmitBtn = By.xpath("//span[text()='Log in']");
    private By createBtn = By.xpath("//p[text()='Create']");
    private By createBoardBtn = By.xpath("//span[text()='Create board']");
    private By boardTitle = By.xpath("//input[@type='text']");
    private By boardCreateConfirm = By.xpath("//button[@type='button'  and text()='Create']");
    private By listNameField = By.xpath("//textarea[@placeholder='Enter list name…']");
    private By addListBtn = By.xpath("//button[text()='Add list']");
    private By closeBtn = By.xpath("//span[@data-testid='CloseIcon']");
    private By addCardBtn = By.xpath("//button[@aria-label='Add a card in To Do']");
    private By cardTitleField = By.xpath("//textarea[@placeholder='Enter a title or paste a link']");
    private By addCardConfirmBtn = By.xpath("//button[text()='Add card']");
    private By cardName = By.xpath("//a[@data-testid='card-name']");
    private By editCardBtn = By.xpath("//span[@aria-label='Edit card']");
    private By changeCoverBtn = By.xpath("//button[normalize-space()='Change cover']");
    private By redColorBtn = By.xpath("//button[@aria-label='red']");
    private By saveBtn = By.xpath("//button[normalize-space()='Save']");
    private By labelsBtn = By.xpath("//button[normalize-space()='Labels']");
    private By orangeLabel = By.xpath("//span[@aria-label='Color: orange, title: none']");
    private By closeLabelPopup = By.xpath("//button[@aria-label='Close popover']//span");
    private By attachmentBtn = By.xpath("//button[normalize-space()='Attachment']");
    private By chooseFileBtn = By.xpath("//label[text()='Choose a file']");
    private By successMsg = By.xpath("//span[@class='VmbXKMJLSqfD0U']");

    public void login(String email, String password) {
        wait.until(ExpectedConditions.elementToBeClickable(loginBtn)).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(usernameField)).sendKeys(email);
        wait.until(ExpectedConditions.elementToBeClickable(continueBtn)).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(passwordField)).sendKeys(password);
        wait.until(ExpectedConditions.elementToBeClickable(loginSubmitBtn)).click();
    }

    public void createBoard(String boardName) {
        wait.until(ExpectedConditions.elementToBeClickable(createBtn)).click();
        wait.until(ExpectedConditions.elementToBeClickable(createBoardBtn)).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(boardTitle)).sendKeys(boardName);
        wait.until(ExpectedConditions.elementToBeClickable(boardCreateConfirm)).click();
    }

    public void addLists() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(listNameField)).sendKeys("To Do");
        driver.findElement(addListBtn).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(listNameField)).sendKeys("In Progress");
        driver.findElement(addListBtn).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(listNameField)).sendKeys("Done");
        driver.findElement(addListBtn).click();
        wait.until(ExpectedConditions.elementToBeClickable(closeBtn)).click();
    }

    public void addCard(String title) {
        wait.until(ExpectedConditions.elementToBeClickable(addCardBtn)).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(cardTitleField)).sendKeys(title);
        driver.findElement(addCardConfirmBtn).click();
        wait.until(ExpectedConditions.elementToBeClickable(closeBtn)).click();
    }

    public void editCardAppearance() {
        actions.moveToElement(driver.findElement(cardName)).perform();
        wait.until(ExpectedConditions.elementToBeClickable(editCardBtn)).click();
        driver.findElement(changeCoverBtn).click();
        driver.findElement(redColorBtn).click();
        driver.findElement(saveBtn).click();
    }

    public void labelCard() {
        driver.findElement(cardName).click();
        wait.until(ExpectedConditions.elementToBeClickable(labelsBtn)).click();
        wait.until(ExpectedConditions.elementToBeClickable(orangeLabel)).click();
        driver.findElement(closeLabelPopup).click();
    }

    public void moveCard() throws InterruptedException {
        WebElement card = wait.until(ExpectedConditions.visibilityOfElementLocated(cardName));
        WebElement toProgress = driver.findElement(By.xpath("//button[@aria-label='Add a card in In Progress']"));
        WebElement toDone = driver.findElement(By.xpath("//button[@aria-label='Add a card in Done']"));
        
        actions.dragAndDrop(card, toProgress).perform();
       
        actions.dragAndDrop(card, toDone).perform();
    }
}
