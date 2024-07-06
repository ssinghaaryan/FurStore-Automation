# FurStore RESTAssured API Automation Framework

![REST Assured](https://img.shields.io/badge/RESTAssured-43B02A?style=for-the-badge&logo=restassured&logoColor=black)
![TestNG](https://img.shields.io/badge/TestNG-FFD700?style=for-the-badge&logo=testng&logoColor=white)
![Java](https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=java&logoColor=white)
![Maven](https://img.shields.io/badge/Maven-C71A36?style=for-the-badge&logo=apache-maven&logoColor=white)
![Jenkins](https://img.shields.io/badge/Jenkins-D24939?style=for-the-badge&logo=jenkins&logoColor=white)
![Git](https://img.shields.io/badge/Git-F05032?style=for-the-badge&logo=git&logoColor=white)
![Extent Reports](https://img.shields.io/badge/Extent%20Reports-4B8BBE?style=for-the-badge&logo=extent-reports&logoColor=white)




![image](https://github.com/ssinghaaryan/FurStore-Automation/assets/86829777/bb2116a5-d958-452d-a8bd-41bc2529db4e)




## Introduction

This project is a comprehensive API testing framework designed to test and automate the API of the [Swagger Petstore](https://petstore.swagger.io/#/) for the User, Pet, and Store models. Built using REST Assured, Java, TestNG, Maven, Jenkins, Git, and Extent Reports, it is designed to simplify API testing and reporting, ensuring efficient and reliable automated testing processes.


## Features

> **REST Assured:** For simplified and efficient API testing.

> **Java:** The core programming language for the framework.  

> **TestNG:** To manage test cases and generate reports.  

> **Maven:** For project build management and dependency management.  

> **Jenkins:** For continuous integration and continuous delivery (CI/CD).  

> **Git:** For version control.  

> **Extent Reports:** For generating detailed and visually appealing test reports.  



## Prerequisites


* Java Development Kit (JDK) 1.8 or higher  

* An IDE of your choice (Eclipse in my case)  

* Maven 3.9 or higher  

* Git  

* Jenkins  


## Setup


1. Clone the repository:
   
```
git clone https://github.com/your-username/your-repo-name.git
```

2. Navigate to the project directory:

```
cd your-repo-name
```

## Configuration


1. Update the [pom.xml](/pom.xml) file with the necessary dependencies for REST Assured, TestNG, and Extent Reports, and more.

     Dependencies you would need:

      * [rest-assured](https://mvnrepository.com/artifact/io.rest-assured/rest-assured)
      * [json-path](https://mvnrepository.com/artifact/io.rest-assured/json-path)  
      * [json](https://mvnrepository.com/artifact/org.json/json)  
      * [gson](https://mvnrepository.com/artifact/com.google.code.gson/gson)  
      * [testng](https://mvnrepository.com/artifact/org.testng/testng)  
      * [scribejava-apis](https://mvnrepository.com/artifact/com.github.scribejava/scribejava-apis)  
      * [Json-schema-validator](https://mvnrepository.com/artifact/io.rest-assured/json-schema-validator)  
      * [Extent-Reports](https://mvnrepository.com/artifact/com.aventstack/extentreports)  
      * [Apache POI](https://mvnrepository.com/artifact/org.apache.poi/poi)  
      * [Lombok](https://mvnrepository.com/artifact/org.projectlombok/lombok)  
      * [java-faker](https://github.com/DiUS/java-faker)(in case of generating random fake data)



2. Configure the TestNG XML file [testng.xml](/testng.xml) to include your test classes and define the suite settings (currently Data Driven UserTest is included)

3. Set up Jenkins:

     Create a new Jenkins job.
     Configure the job to pull from your Git repository.
     Add build steps to run your Maven commands.

## Running Tests

To execute the test suite via Terminal/Cmd, run the following Maven command:

```
mvn test
```

## Reporting
After executing the tests, Extent Reports will generate a detailed report. You can find the report in the ```/reports``` directory.


## Continuous Integration
To set up continuous integration, configure your Jenkins job to run the tests automatically on every commit. This ensures that your API is continuously tested and any issues are detected early.


## Project Structure

```
├── README.md
├── pom.xml
├── src
│   ├── main
│   │   ├── java
│   │   └── resources
│   └── test
│       ├── java
│       │   └── api
│       │       ├── endpoints
│       │       │   ├── PetEndpoint.java
│       │       │   ├── Routes.java
│       │       │   ├── StoreEndpoint.java
│       │       │   ├── UserEndpoint.java
│       │       │   └── UserEndpointViaRoutes.java
│       │       ├── payload
│       │       │   ├── PetPayload.java
│       │       │   ├── StorePayload.java
│       │       │   └── UserPayload.java
│       │       ├── test
│       │       │   ├── PetTestsViaProperties.java
│       │       │   ├── StoreTestsViaProperties.java
│       │       │   ├── UserTestsDataDriven.java
│       │       │   ├── UserTestsViaProperties.java
│       │       │   └── UserTestsViaRoutes.java
│       │       └── utilities
│       │           ├── DataProviders.java
│       │           ├── ExtentReportManager.java
│       │           └── XLUtility.java
│       └── resources
│           └── routes.properties
├── reports
│   ├── Test-Report - 2024.07.04.12.16.48.html
│   └── Test-Report - 2024.07.04.13.04.56.html
├── testData
│   ├── TestCases.xlsx
│   ├── Userdata.xlsx
│   ├── Storedata.xlsx
│   ├── Petdata.xlsx
└── testng.xml
```





