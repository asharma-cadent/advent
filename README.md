# advent: Used by the Hack &amp; Slay team for Advent 2020


How to run this application in your local environment.

## Install the following tools in your local environment.

- Git client
- Maven
- Java 8

## Perform the following steps:

### Clone the repository
   git clone https://github.com/asharma-cadent/advent.git /your_favorite_location/advent_git_repo
### Change your directory to /your_favorite_location/advent_git_repo/advent
   cd /your_favorite_location/advent_git_repo/advent
### Run maven install command
   mvn clean install
### Run the springboot app.
   java -jar .\target\advent-0.0.1-SNAPSHOT.jar tv.cadent.linear.Application
### Open your favorite browser and browse to the application URL:
   http://localhost:8085/feedtimeline/
   
