Feature: validate alert window and iframes

  Background: common steps for alert window iframe handling
    Given user launch demoqa browser
    When enter demoqa url "https://demoqa.com/"

  @Regression @simpleAlert @alert
  Scenario: validate simple alert functionality
    And go to alert page
    When click on simple alert clickon button
    Then simple alert should be open
    And close alert
    And close browser

  @Regression @alert @TimerAlert
  Scenario: validate timer alert functionality
    And go to alert page
    When click on Timer alert clickon button
    Then handle timer alert
    And close browser

  @Regression @alert @promptAlert
  Scenario: validate prompt alert functionality
    And go to alert page
    When click on prompt alert clickon button
    Then handle prompt alert sendkeys with accept
    Then handle prompt alert sendkeys with dissmiss
    And close browser
    
    @Regression @multiplewindowHnadling
    Scenario: multiple window handling in selenium
    
    When enter demoqa url "https://www.hyrtutorials.com/p/window-handles-practice.html#google_vignette"
    When click on newTabsWindowsBtn
    Then switch to secnd window and handle it
    And close browser
    
    @Regression @iframeHandling
    Scenario: validate iframe and nested iframe functionality
    When enter demoqa url "https://www.hyrtutorials.com/p/frames-practice.html"
    When switch to first iframe and return back to main page
    Then switch to secnd iframe and andle a child frame and return back to main page
    And close browser
    
    
    @Regression   @calendorHandling
    Scenario: handling a present past and future date by calendor
    When enter demoqa url "https://www.hyrtutorials.com/p/calendar-practice.html"
    And handle first date as a current date
    And handle second calendor as future date
    Then handle Third calendor as past date
    And close browser
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
     
     
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
