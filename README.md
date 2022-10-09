# Compare-versions
This app compares 2 given version and expose result of comparison. An util created for comparsion. OpenApi/swagger-ui integrated. Services developer by Java Spring Boot framework and deployed on Heroku. You can see swagger and openApi urls below. Used lombok library for getters/setters. /compare rest api uses the comparsion util from com.sojern.compare.versions.util.CompareVersionsUtil.java


## Live Service (Swagger URL)
Click on the link to see Swagger-UI pages. https://github-version-comperasion.herokuapp.com/swagger-ui/index.html

## Live Open-API URL 
Click on the link to see openApi service details. https://github-version-comperasion.herokuapp.com/v3/api-docs

## Endpoins
Project include an endpoint to test easily. You can test from command line after clone and build project. You can see the instruction in below parts.

### 1- /compare
URL https://github-version-comperasion.herokuapp.com/compare Method GET return comparsion result of util class and human readable result.  Service acceps 2 request paramers name v2 and v2 to compate.

#### Example

curl --location --request GET 'https://github-version-comperasion.herokuapp.com/compare?v1=1.11.0&v2=1.11'

#### Output
{
    "result": 0,
    "message": "1.11.0 == 1.11"
}

#### Example
curl --location --request GET 'https://github-version-comperasion.herokuapp.com/compare?v1=05.8.11&v2=05.9.11'

#### Output
{
    "result": -1,
    "message": "05.8.11 < 05.9.11"
}

#### Example
curl --location --request GET 'https://github-version-comperasion.herokuapp.com/compare?v1=1.9.1&v2=1.8.9'

#### Output
{
    "result": 1,
    "message": "1.9.1 > 1.8.9"
}

### JUnit Test
Junit test included for equals, greatert-han and less-than cases. See "Local deployment and test" part for maven execution.

### Local deployment and test
#### Clone repo
  Clone repo to your local machine
  URL https://github.com/kerimsisman/compare-versions.git 
#### Open terminal
  Be sure you have maven and java in your class path and then open terminal.
 
>java -version

>mvn -version

#### Maven clean install
  "mvn clean install -U" Clean and install project to bild jar file
#### Unit test
  "mvn test" run 3 unit test
  
####  Change directory
  "cd ${targetFolderForJar} "Change your directory to target folder for your project

#### Test util file
  java -cp compare-versions-0.0.1-SNAPSHOT.jar -Dloader.main=com.sojern.compare.versions.CompareVersionsUtilTestMain org.springframework.boot.loader.PropertiesLauncher 1.0 2.0
##### Expected result
  v1:     1.0
  v2:     2.0

  Result: 1.0 < 2.0





