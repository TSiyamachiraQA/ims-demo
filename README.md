# Inventory Management system (IMS) Project

This individual project comprises of the implementation of java language source code in conjuction with a JDBC which is executed via SQL queries, which is hosted on Google's Cloud platform. Agile Project Management methodologies were used throughout this project via Github, which was also used for version control. Eclipse was used as the most suitable IDE to conduct and compose JUnit and Mockito manual tests. Maven was used to build the application. The C.I pipeline comprises of Jenkins, which respectively sends the build to Sonarqube and Nexus artifect repository in order to manage and address the DevOps of this project. 

## Getting Started

These instructions will get you a copy of the project up and running on your local machine for development and testing purposes. See deployment for notes on how to deploy the project on a live system.

1. Fork the repository onto your own repository, clone the new repo to your PC.
2. Open the project as a Maven project in Eclipse or other IDE.
3. Commence with the development of the source code.
4. To conduct unit tests, you can highlight the test class and 'Run as Jnit test' or highlight the maven project then 'Coverage as JUnit'.


### Prerequisites

What softwares you need to install the software;

1. JAVA JDK & JRE
2. Eclipse
3. Apache Maven
4. Jenkins
5. Git 

(these softwares can be installed via the respective download pages below)

1. [Java SE 14](https://www.oracle.com/java/technologies/javase-downloads.html#JDK14)
2. [Eclipse](https://www.eclipse.org/downloads/)
3. [Apache Maven](https://www.eclipse.org/downloads/)
4. [Jenkins](https://jenkins.io/download/)
5. [Git](https://git-scm.com/downloads)

```
Give examples
```

### Installing

A step by step series of examples that tell you how to get a development env running

##Setup for Environment Variables
```
After successfully installing all of the above softwares/technologies;
- Ensure JAVA and MAVEN have been added to the Environment Variables within the system's settings
- Ensure that both JAVA and MAVEN can be accessed from the command line.
- Use local-based mySQL or cloud-based mySQL for the JDBC.(Google Cloud Platform can be used as a cloud based JDBC)
-  
```

##Running the application in Java Development Environment.
```
- Open Eclipse IDE and run the respective 'ims' class in order to access the application in the Command Line cosnole within Eclipse.
- Insert username and password to access the cloud based database.
```


## Running the tests

An explanation of the tests and what they do.

### Unit Tests 
This method of testing is manual testing which is conducted via J-Unit test which are run in Eclipse IDE.

```
- A test class is present for the Domain class
- Each of the entities have a respective test class associated to the main class. For example, the ItemsControler main class is accociated with its respective test class.
- To run the test, highlight the test class and run the class as a JUnit test. 
```

### Integration Tests 
This method of testing is automated testing which is conducted via Jenkins and sent to Sonarqube for observation.

```
- Configure Jenkins to add the repository of the project in order to import the maven file and build the application
- Configure to clean the package using maven command within the Windows Command Prompt.
- In the command prompt input commands to transfer the build to Sonarqube and Nexus respectively in the Windows Command Prompt.
- View the integrated test's results within Sonarqube.
```


## Built With

* [Maven](https://maven.apache.org/) - Dependency Management

## Versioning

We use [SemVer](http://semver.org/) for versioning.

## Authors

* **Tawanda Siyamachira** - [tsiyamachiraqa](https://github.com/TSiyamachiraQA)
* **Chris Perrins** - *Initial work* - [christophperrins](https://github.com/christophperrins)

## License

This project is licensed under the MIT license - see the [LICENSE.md](LICENSE.md) file for details 

*For help in [Choosing a license](https://choosealicense.com/)*

## Acknowledgments

* Nick Johnson [nickrstewarttds](https://github.com/nickrstewarttds)
* Chris Perrins [christophperrins](https://github.com/christophperrins/ims-demo)
* Jordan Harrison [JHarry444](https://github.com/JHarry444/MarchJDBC)
