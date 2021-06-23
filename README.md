# projectg4-selenium-webdriver
This repository to support the online course. This framework supports GUI selenium test and BDD.

José Hurtado<br />
* Twitter : [@jhumbertoh](https://twitter.com/jhumbertoh) <br />
* Linkedin: [@jhumbertoh](https://www.linkedin.com/in/jhumbertoh/)

License
=======
You can use this code for your own personal learning and development. Please do not use it to train others. 

And do not use it for commercial purposes.

## After you clone this repo, you must:
    mvn clean install
    
## Running  all test classes
    mvn clean test

## Running Cucumber Test with a subset of scenarios tagged with "@gui"
    mvn clean test -Dcucumber.filter.tags="@gui"

## Running Cucumber Test with a subset of scenarios tagged with "@gui and @Working"
    mvn clean test -Dcucumber.filter.tags="@gui and @Working"

## Running Cucumber Test with a subset of scenarios tagged with "@gui or @Working"
    mvn clean test -Dcucumber.filter.tags="@gui or @Working"

## Crear variables de entorno
Mac OS and Linux
 * ```export browserName=firefox```

Windows
 * ```set browserName=firefox```        