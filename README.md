# Upgrade Interview

This is the instructions in order to get this Automated frame to work and how to run it:

# Local computer set up process

- First: Install latest Chrome browser on you computer. You can download it from: https://www.google.com/chrome/

- Second: You need to access https://chromedriver.chromium.org/downloads and download the chromedriver.exe version that matches the version of the browser you have installed on your local computer.

- Third: In order for this framework to work with the recently downloaded chromedriver.exe you'll need to provide the path where the file is located in configuration.properties file, located here: https://github.com/andresmilanesi/UpgradeInterview/blob/master/configs/configuration.properties. Make sure you provide that path to variable "driverPath".

# Execution 

This automated framework contains 4 test cases that can be executed individually or as a test suite.

In order the execute the test cases you'll need to download thi repo to your local computer, you can do that by opening a terminal / console, find a proper directory and run the following command:
- git clone https://github.com/andresmilanesi/UpgradeInterview.git

Once you downloaded the repo, you can now start running the test cases:

For UI case proposed in the QA challenge, run the following command:
- mvn test -Dtest=upgradeInterviewTest#testUserFlow

For the first API case (Validate that for correct credentials provided in the payload below, the API response code is a 200 (OK)), run the following command:
- mvn test -Dtest=upgradeInterviewTest#testAPIOne

For the second API case (For the above use case, parse each json value in the response payload individually. Then validate the productType attribute has value PERSONAL_LOAN), run the following command:
- mvn test -Dtest=upgradeInterviewTest#testAPITwo

For the third API case (Validate that in the initial POST request, if a different username is provided (that doesn't exist in our system) - the API response is a 401 (UnAuthorized)), run the following command:
- mvn test -Dtest=upgradeInterviewTest#testAPIThree

If you want to run the whole suit, run the following command:
- mvn clean package
