# DemoWebShop.com Testing Project

### Project Overview

This project aims to test various functionalities of a web store using Selenium and TestNG. The web store being tested is [DemoWebShop](https://demowebshop.tricentis.com/).

## User Stories Covered

**User Registration (US 201):** This user story involves the ability for users to register on the web store platform. Registration enables users to create an account, which grants them access to features like shopping, order tracking, and personalized recommendations.

**Negative Registration (US 202):** This user story focuses on handling error scenarios during user registration. Specifically, it addresses the situation where a user tries to register with an email address that is already associated with an existing account. Providing clear error messages in such cases enhances the user experience by guiding them appropriately.

**Logout (US 203):** This user story revolves around the capability for users to securely log out from their accounts on the web store platform. Logging out ensures the safety of the user's account and personal information, especially if they are accessing the platform from shared or public devices.

**Login (US 204):** This user story is about users logging into our web store. Logging in allows users to manage their account, track orders, and access features easily. We'll ensure a smooth login process by testing different scenarios like correct and incorrect credentials. Clear error messages will guide users if any issues arise, making the login experience secure and user-friendly.

**Negative Login (US 205):** Similar to US 202, this user story pertains to handling error scenarios, but during the login process. It involves testing various negative scenarios, such as incorrect credentials or account lockouts, to ensure that the login mechanism is robust and secure against unauthorized access.

**Ordering (US 206):** This user story deals with the functionality for users to place orders for products available on the web store platform. It typically involves selecting items, adding them to a cart, providing payment details (such as credit card information), and completing the purchase process.

**Survey Response (US 207):** This user story relates to the feature allowing users to participate in surveys or polls hosted on the web store platform. It includes functionalities such as answering survey questions and viewing survey results. The user experience is enhanced by providing appropriate warnings or prompts, such as requiring users to log in before participating in surveys.

**Negative Coupon/Gift Card Usage (US 208):** Similar to US 202 and US 205, this user story focuses on handling error scenarios, specifically related to the usage of coupons and gift cards during the shopping process. It involves displaying alert messages when users attempt to apply invalid or nonexistent coupons or gift cards, improving the overall customer experience.

**Download Order History (US 209):** This user story addresses the need for users to view and download their order history from the web store platform. It enables users to track their past purchases, review order details, and obtain order documents (such as invoices or receipts), thereby facilitating better management of their shopping  activities.

## Prerequisites

1. Java Development Kit (JDK) installed.
   
2. Selenium WebDriver configured in the project.
   
3. TestNG framework set up for running test suites.
   
4. WebDriver for the browser under test (e.g., ChromeDriver, FirefoxDriver).

## **Technologies and Tools:** 

- Selenium WebDriver
  
- TestNG
  
- JUnit (for test execution and assertions)
  
- WebDriverManager (for managing browser drivers)
  



## **Getting Started**

To run the tests locally, follow these steps:

1. Clone the repository to your local machine:
  
2. Set up the necessary dependencies in the project, including Selenium WebDriver and TestNG.
    
3. Configure WebDriver for the desired browser (e.g., ChromeDriver, FirefoxDriver).
   
4. Update the test scripts in the project to reflect the specific test scenarios and requirements.

## CONTRIBUTION:

| Contributor                                               | Role                                  |
|-----------------------------------------------------------|---------------------------------------|
| [Nigar Ayla Özcanan](https://github.com/NigarAylaOzcanan) | Project Lead & QA Automation Engineer |
| [Erdem Gürel](https://github.com/artam109)                | QA Automation Engineer                |
| [Onur Girgin](https://github.com/Mednasa)                 | QA Automation Engineer                |
| [Beyzanur Er](https://github.com/beyzanurer)              | QA Automation Engineer                |
| [Ahmet Kaya](https://github.com/0AhmetKaya0)              | QA Automation Engineer                |
| [Ömer Faruk Ayrıç](https://github.com/faruk-ayrcc25)      | QA Automation Engineer                |
| [Şeyma Nur Aladağ](https://github.com/SeymaNur44)         | QA Automation Engineer                |

Contributions are welcome! If you find any issues or want to add more tests, feel free to open a pull request.
Please follow these steps to contribute:

- Fork the repository.
- Create a new branch for your feature or bugfix.
- Make your changes and commit them.
- Push to your branch.
- Create a pull request.

## Pull Request Rules

When contributing to this project, please adhere to the following guidelines:

1. **Create a Descriptive Pull Request Title**: Ensure that your pull request title clearly describes the changes you're making.

2. **Provide Detailed Descriptions**: In your pull request description, provide a clear and detailed explanation of the changes you've made and why they are necessary.

3. **One Pull Request per Feature**: If you're adding multiple features or making several changes, please submit each as a separate pull request.

4. **Follow Code Standards**: Maintain code cleanliness and adhere to the coding standards used in the project.

5. **Test Your Changes**: Before submitting a pull request, test your changes thoroughly to ensure they work as expected and do not introduce any regressions.

6. **Update Documentation**: If your changes impact any documentation, make sure to update it accordingly.

7. **Resolve Conflicts**: If there are any conflicts with the base branch, resolve them before submitting your pull request.

8. **Request Reviews**: Assign reviewers to your pull request to ensure that your changes are properly reviewed before merging.

9. **Be Responsive**: Respond promptly to any feedback or comments on your pull request.

10. **Ensure CI/CD Passes**: Ensure that all continuous integration (CI) checks pass before merging your pull request.

## License

This project is open-sourced software licensed under the [MIT license](https://opensource.org/licenses/MIT).
