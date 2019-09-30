# Findyourperson

## Instructions
REST api that provides basic CRUD functionality for person objects.
Designed to run alongside frontend application findyourperson-frontend: https://github.com/kenerstad/Findyourperson-FrontEnd
	
2 options to run backend server:
- using gradle
	gradle build
	gradle bootrun
		
- running executable jar
	build jar: gradle fatJar
	open cmdline & 'java -jar <jarfile>.jar in $project/build/libs
	
	Frontend has been configured to run on port 8082, backend will run on standard 8080 so no worries! :D
	

### Dependencies included
H2 Database, starter-data-jpa, dev-tools, starter-test


### Planned features
* Finish (DbPersonService.java) - repository.save() function currently not working,
methods need fleshing out.
	
* Test suite - (Integration, unit tests)
	
* Backend validation on entity objects
	
* Authentication/Authorization using Spring Security