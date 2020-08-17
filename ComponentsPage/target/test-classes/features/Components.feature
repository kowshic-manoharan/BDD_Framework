Feature: Components Checking

Scenario: Components page Loading
Given user is on the Components page
When user navigate to the page
Then Component page should display

Scenario: Radio Button component
When clicking on the second radio button
Then second radio button have to select

Scenario: Suggestion have to be displayed in the auto suggestive field
When entering the letters in the field
Then Corresponding letter country display

Scenario: Drop down Component check
When select the value in the drop down
Then Corresponding value have to be displayed

Scenario: Check box component check
When check the second checkbox
Then Corresponding check box have to be selected

Scenario: new window opening
When click on the Open window button
Then new window have to opened

Scenario: new tab opening
When click on the Open tab button
Then new tab have to opened

Scenario: Alert Function check
When entering the value and click the button
Then alert have to display

Scenario: Course detail check
When checking course list
Then course list is displayed as per requirement

Scenario: Hide functionality check
When  i am clicking on the Hide button
Then Hide Show text box should hide

Scenario: Hide functionality check
When  i am clicking on the show button
Then Hide Show text box should show

Scenario: Mouse Hover Functionality 
When  Hovering on the Mouse Hower button
Then Options have to display

Scenario: iFrame component 
When clicking on all the links to open in seperate tab
Then all the links are opened in individual tab

