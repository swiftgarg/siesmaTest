## Introduction
This is the application that uses a POST endpoint to calculate tax of employees
according to ATO. The program 

## Local Testing
The following commands can be run in order to test, build and run spring boot.

```
mvn test
mvn package
mvn spring-boot:run
```
## Testing on AWS 

To access the application for siesma test, please use:

[siesm-ecssi-1NZVXZBO0PEHS-f5e03097a656ee85.elb.us-west-2.amazonaws.com:8080/calcTaxOfEmployees]()

Access the application as POST request. Use a payload like:
```json
[
{

"firstName": "David",
"lastName": "Rudd",
"annualSalary": 60000,
"paymentMonth": 1,
"superRate": 0.09
},
{
"firstName": "Ryan",
"lastName": "Chen",
"annualSalary": 120000,
"paymentMonth": 1,
"superRate": 0.1
}
]
```

For deployment infrastructure code please refer to [siesmaTestCDK](https://github.com/swiftgarg/siesmaTestCDK).
```bash
curl -X POST http://siesm-ecssi-1NZVXZBO0PEHS-f5e03097a656ee85.elb.us-west-2.amazonaws.com:8080/calcTaxOfEmployees
   -H 'Content-Type: application/json'
   -d '[{
   "firstName": "David",
   "lastName": "Rudd",
   "annualSalary": 60000,
   "paymentMonth": 1,
   "superRate": 0.09
   },
   {
   "firstName": "Ryan",
   "lastName": "Chen",
   "annualSalary": 120000,
   "paymentMonth": 1,
   "superRate": 0.1
   }
]'
```
