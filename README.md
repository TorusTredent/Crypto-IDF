# Crypto

Getting Started
=====================
##### 1. git clone git@github.com:TorusTredent/Crypto-IDF.git
##### 2. start your application from your Idea
        ## Before start install Java https://www.java.com/
        ## Allow all installations suggested by IDE
        ## After indexing all your files accept all plugins, which IDE propose to install
        ## Leave default settings
        ## Install Postman https://www.postman.com/downloads/
        ## Import file crypto-idf.postman_collection.json (path: postman/crypto-idf.postman_collection.json) to postman

Using technologies
=====================
##### 1. Java 17
##### 2. H2
##### 3. Spring
##### 4. Hibernate
##### 5. OpenFeign
##### 6. Liquibase
##### 7. Logging SLF4J;

Files path
=====================
This path - templates - uses by default in Spring boot application (It is classpath for spring boot)
1. src/main/java - it is a path for main logic of your application
2. src/main/resources - you can find application configurations
3. src/main/resources/db - migration (liquibase)
4. src/main/resources/logs - you can find logger file


TODO
=====================
1. Add a new user with certain currencies
2. Get all available currencies
3. Get available currency by id
4. View user profile by username
5. Change the recorded price to a specific currency from the user
