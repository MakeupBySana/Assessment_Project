package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.TrelloPage;

public class TrelloAutomationTest extends BaseTest {

    @Test
    public void completeTrelloWorkflow() throws Exception {
        TrelloPage page = new TrelloPage(driver);
        page.login(prop.getProperty("email"), prop.getProperty("password"));
        page.createBoard("QA Scrum Board - UI - 08/01/2025");
        page.addLists();
        Thread.sleep(3000);
        page.addCard("Test Plan");
        Thread.sleep(3000);
        page.editCardAppearance();
        page.labelCard();
        page.moveCard();
        Thread.sleep(5000);
    }
}
