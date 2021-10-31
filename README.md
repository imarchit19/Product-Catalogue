## Implementation

### API's

- Login Auth - "http://localhost:8081/api/auth/login"
- Signup Auth - "http://localhost:8081/api/auth/signup"
- Fetch All Items - "http://localhost:8081/api/items/all"
- Fetch No. of Times Items have been accessed - "http://localhost:8081/api/items/all/byAccesses"
- Fetch All Items by Price (Low to High) - "http://localhost:8081/api/items/all/byItemPriceAsc"
- Fetch All Items by Price (High to Low) - "http://localhost:8081/api/items/all/byItemPriceDesc"
- Search Items by Category - "http://localhost:8081/api/items/all/byCategory/{theCategory}"
- Search Items by Brand - "http://localhost:8081/api/items/all/byBrand/{brand}"
- Search Items by Item Name - "http://localhost:8081/api/items/all/byName/{term}"
- Search Items by Item ID - "http://localhost:8081/api/items/all/byId/{theId}"
- Create Item (Admin) - "http://localhost:8081/api/items/all/create"
- Delete Item (Admin) - "http://localhost:8081/api/items/all/delete/{id}"
- Update Item (Admin) - "http://localhost:8081/api/items/all/update/{id}"
- Get Item with ID - "http://localhost:8081/api/items/all/item/{id}"

a. Exit Backend

    - Maven -> Update Project
    - Using MySQL create database "exitdb"
    - Create Admin User (Use Signup Form to Register as a normal user), to set id of user as Admin use SQL Query
    - UPDATE user_roles SET role_id=2 WHERE user_id="{USER ID of Registered User}"
    - Run as Spring Boot Project (Running at PORT - 8081)

b. Exit Frontend

    - npm install
    - ng serve (Running at PORT - 4200)
