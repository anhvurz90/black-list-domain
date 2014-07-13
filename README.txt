Blacklisted Domain Management 
=================
Introduction:

 Author: Nguyen Anh Vu
 Email : anhvurz90@gmail.com
 Project git url: https://github.com/anhvurz90/black-list-domain

 ------------------------
How to build:
 1.Build from attached source:
   1.1.Unzip file BlackListedDomain.zip to a folder
   1.2.Go to that folder
   1.3.mvn clean install
 
 Or if you prefer git: (you do not need the BlackListedDomain.zip file)
 2.Using git:
   2.1.git clone https://github.com/anhvurz90/black-list-domain.git
   2.2.cd black-list-domain
   2.3.mvn clean install
 
 You can freely choose one of two approaches above

 ------------------------
How to deploy:
 This is a small project, and everthing is packaged into one war file: \webapp\target\BlackListedDomain.war
 You just need to deploy this war into your application server/ servlet container. 
 For example: copy this file into webapps folder of tomcat

 ------------------------
How to run:
 - Please access the application by the url: 
     + http://localhost:8080/BlackListedDomain or
     + http://localhost:8080/BlackListedDomain/index.jsp or
     + http://localhost:8080/BlackListedDomain/listDomain
   (I suggest that you deploy the application in localhost with 8080 port)
 - By default, the application user FileStorageDomainManagerImpl as the implementation of DomainManager. 
   It means data is stored using local file. 
   If you want to change to use hsql instead, please specify property "domainStorage".
   For example, in tomcat/conf/catalina.properties, you can set:
     + domainStorage=file -> using file storage mechanism
     + domainStorage=hsql -> using hsql storage mechanism



 ------------------------
Architecture:
 The project includes 2 sub modules: 
  - A jar contains business model (Domain), business logic api (DomainManager), and some implementations of DomainManager
    + This module is the 'services' module.
    + For the DomainManager, there are 2 implementations: FileStorageDomainManagerImpl and HsqlDomainManagerImpl. The first one uses local file to store data, and the second one stores data in the Hsql RDBMS.
    + To manage the services, Spring core is used. Of couse we can simply implement Singleton design pattern for these services, but I use Spring for the professional purpose.

  - A war contains UI logics: the 'webapp' module.
    + Spring MVC is used for UI part.
    + The only one controller here is the DomainController which navigates the request flow and selects appropriate view to display
    + There are mainly 3 pages: 
      * addDomain for adding new domain in the list	
      * listDomain for listing all existing domains in the list      
      * checkEmail for checking whether an email's domain is blacklisted.
    + jquery.form.validator is used to perform some input validations(domain format, email format)