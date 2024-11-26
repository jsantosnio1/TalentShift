# TalentShift
Development testing

Create Employee (POST /employee/create):

Endpoint: /employee/create

HTTP Method: POST

Request Body (Example JSON):

json
{
    "firstName": "Ana",
    "middleName": "Maria",
    "lastName": "Lopez",
    "locationCity": "Bogotá",
    "address": "5678 Maple Ave",
    "birthDate": "1985-07-22",
    "telephone": "0987654321",
    "positionTitle": "Product Manager",
    "hireDate": "2018-06-15",
    "email": "ana.lopez@example.com",
    "salary": 95000.00,
    "timeInPosition": 4
}
Description: This endpoint accepts a POST request with a JSON payload that contains employee information. When you send a request with this data, the backend will:

Validate the data (using annotations like @NotNull, @NotBlank, @Past, etc., to ensure that the fields meet the required criteria).
Create a new employee in the database with the provided information.
Return a 201 CREATED status response along with the newly created employee object.
Get All Employees (GET /employee/all):

Endpoint: /employee/all
HTTP Method: GET
Response: A list of all employees in the system.
Description: This endpoint retrieves a list of all employees. It does not require any input, and it will return an array of employee objects (in JSON format). This is useful for displaying all employees in a list view.
Update Employee (PUT /employee/{id}):

Endpoint: /employee/{id}
HTTP Method: PUT
Request Body (Example JSON):
json
{
    "firstName": "Ana",
    "middleName": "Maria",
    "lastName": "Lopez",
    "locationCity": "Bogotá",
    "address": "5678 Maple Ave",
    "birthDate": "1985-07-22",
    "telephone": "0987654321",
    "positionTitle": "Product Manager",
    "hireDate": "2018-06-15",
    "email": "ana.lopez@example.com",
    "salary": 95000.00,
    "timeInPosition": 4
}
Description: This endpoint updates an existing employee's data based on their unique id. The PUT request requires the id in the URL (e.g., /employee/1), and the updated employee data is sent in the request body. The backend will:
Validate the updated data.
Update the employee with the corresponding id in the database.
Return the updated employee information as a response.
Get Employee by ID (GET /employee/{id}):

Endpoint: /employee/{id}
HTTP Method: GET
Description: This endpoint retrieves the details of a specific employee by their id. When you send a GET request to this endpoint, it will return the employee's information.
If the employee with the given id is found, the backend will return the employee data in JSON format.
If no employee with that id is found, it will return a 404 NOT FOUND status.
Example Flow:
Creating a New Employee: When you want to create a new employee, you send a POST request to the /employee/create endpoint with the employee data in the request body. In Postman, this would look like:

URL: http://localhost:8080/employee/create
HTTP Method: POST
Request Body (using the JSON example provided):
json
{
    "firstName": "Ana",
    "middleName": "Maria",
    "lastName": "Lopez",
    "locationCity": "Bogotá",
    "address": "5678 Maple Ave",
    "birthDate": "1985-07-22",
    "telephone": "0987654321",
    "positionTitle": "Product Manager",
    "hireDate": "2018-06-15",
    "email": "ana.lopez@example.com",
    "salary": 95000.00,
    "timeInPosition": 4
}
After the backend processes the data, it will create a new employee and return the created employee object with a 201 CREATED status.

Getting All Employees: To retrieve a list of all employees, send a GET request to the /employee/all endpoint. This will return a list of employee objects in JSON format.

Updating an Employee: If you need to update an existing employee's information, you can send a PUT request to the /employee/{id} endpoint with the updated employee data. For example, to update the employee with id=1, send a PUT request to /employee/1 with the updated employee data in the body.

Getting Employee by ID: To view a specific employee's details, send a GET request to the /employee/{id} endpoint, where {id} is the employee's unique ID. For example, to retrieve the employee with id=1, you would send a GET request to /employee/1.
