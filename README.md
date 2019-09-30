# Findyourperson

## Temporary branch
This branch is intended for bug-fixing and doing some additional work on the project before merging back into master.

## Instructions
REST api that provides basic CRUD functionality for person objects.
Designed to run alongside frontend application findyourperson-frontend: https://github.com/kenerstad/Findyourperson-FrontEnd

### Project setup
2 options to run backend server:
- using gradle: gradle build, gradle bootrun
		
- running executable jar: gradle fatJar, then 'java -jar <jarfile>.jar in $project/build/libs
	
Frontend has been configured to run on port 8082, backend will run on standard 8080 so no worries! :D
	

### Dependencies included
H2 Database, starter-data-jpa, dev-tools, starter-test

### Unresolved issues


### Planned features	
* Test suite - (Integration, unit tests)
	
* Backend validation on person objects
	
* Authentication/Authorization using Spring Security