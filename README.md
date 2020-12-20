# mock-service-template

The application can be used to mock any response for an API. Instead of changing the response every time you want to dev test a functionality of an external micro service, you can simply use this service which can dynamicaly change the response by just changing the value in the database without having to re start the application or make any code changes.

### Use cases:
If you are trying to dev test in your local environment and have an external HTTP API call to another service. 
- You can mock the response to test out different scenarios
- You do not want to actually hit the external API since you do not want to persist any changes or carry forward the load to them
- You simply do not want to waste time in setting their end points, coordinate with them, etc

### Tools required:
- Mysql : to store the api mappings and response mappings

### Setup :
- Once you set up the project on the IDE, simply specify the properties file which the spring boot application should take by adding this in the VM options
> `-Dspring.profiles.active=local`

- There is the mysql schema attached in the code, but if you do not want to run the create commands, simply un comment the following line and run the application, it will automatically create the schema in your local db
> `#spring.jpa.hibernate.ddl-auto=update` 

### Table structure

There are 2 tables: 
- api_mapping : to store which api are you trying to get the mocked response of
- response_mapping: to store the actual response of the api that is in the api_mapping table

### How to use:

- Populate the api id in the api_mapping table and response of the api that you want to mock  in the response_mapping table.
- There are 2 API flavours exposed, one GET and one POST
- Hit the api and pass the api id for which you want to get the mocked response of
> `curl --location --request GET 'localhost:8080/mock-service/get-api/1'`

It shall return you the response that is stored in the response_mapping table for the key id: 1
