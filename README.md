# API to manage users without authentication.

Api development by Morg4n, an easy example of how to use spring boot with a MySQL database.

1. Clone the repository
   ```bash
      git clone https://github.com/jdacamacho/API-with-SpringBoot-and-MySQL/edit/main/README.md
   ```
   > **Note:** If you have Java 17 and MySQL installed on your machine, just open your MySQL manager, update the application.properties with your MySQL credentials, and run the project in your preferred IDE. Otherwise, follow the steps below.
   
2. Generate the .jar file in your preferred IDE by performing clean and install operations.
3. In the root of the cloned repository, open the terminal and execute the following commands (ensure you have Docker installed).
  ```bash
      docker-compose build
      docker-compose up
   ```
   It will generate the images of the Spring boot application and MySQL inside a container

The API will be available at http://localhost:5000    
Documentation: http://localhost:5000/swagger-ui.html

Tecnologies:

1. Java 17
2. Spring boot:
   Dependencies
   - Spring web
   - MySql connector
   - JPA
   - Lombok
   - Model Mapper
3. MySQL: 8.0.33 

Julian Camacho Erazo <jdacamachoe@gmail.com>  
Software Developer  
Lover of open source


