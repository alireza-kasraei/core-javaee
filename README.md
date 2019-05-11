***initial draft***


projects descriptions:

1- core infrastructure framework : consists of core functionalities that helps us to develop applications .
	it's modules are :
		* core-persistence-model : contains core classes for developing JPA based applications . (more functionalities may be added in future)
		* core-persistence : contains core classes for repository pattern
		* core-utils : contains utility classes for all projects
		* core-commons : contains common classes for all projects
2- card sample project : its a sample multi-module project that uses core framework as its infrastructure .
	it's modules are :
		* card-model : model classes (entities) are in this module , we separate it for reusing models among all service modules
		* card-service : contains service classes , you can see its module's structure in below :
			packaging based on feature such as card,usermanagement,...
			---card
					---CardRepository (Repository interface with default modifier)
					---CardRepositoryImpl (Repository implementation with default modifier)
					---CardService (Service interface with public modifier)
					---CardServiceImpl (Service implementation with public modifier)
					** there is only one or at least one entry point to card module witch is its service api (CardService),
						we have to restrict the access to service implementation , but EJBs need to be public so we can't restrict it in javaee 6 environment.
						

we use ejbs in javaee 6 environment because we have to use container managed transaction functionality (CMT) and bean managed transactions (BMT),
take a look to this link : https://www.tutorialspoint.com/ejb/ejb_transactions.htm. 						 
						
						
because we are on development phase , there is not much functionalities on the core framework,
it will be completed during the development of the projects.it may be changed , 
some modules might be added later or even removed from the infrastructure. so in the mean time , you have to checkout the sadad-card from
the repository and simply build it with maven : mvn clean install , it will copy the artifacts to your local repository.

then you can checkhout the sample project and start developing.

With trigger push events capability.