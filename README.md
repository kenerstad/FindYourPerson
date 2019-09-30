### Instructions

	2 options to run backend server:
		- using gradle
			gradle build
			gradle bootrun
		
		- running executable jar
			build jar: gradle fatJar
			open cmdline & 'java -jar <jarfile>.jar in $project/build/libs
	
	Run backend alongside frontend to make the application work.
	

### Dependencies included

	H2 Database, starter-data-jpa, dev-tools, starter-test


### Planned features
	
	* Finish (DbPersonService.java) - repository.save() function currently not working,
	methods need fleshing out.
	
	* Test suite - (Integration, unit tests)
	
	* Backend validation on entity objects
	
	* Authentication/Authorization using Spring Security