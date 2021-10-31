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

c. Outputs

- Home (User)

<img src="https://user-images.githubusercontent.com/31448375/139572697-946eaa0d-d638-42f2-aa36-f79f02df522c.png" width="520" height="440" />

- User Login

<img src="https://user-images.githubusercontent.com/31448375/139572716-6c2465a2-8be8-4fb4-8af2-b886217c5dea.png" width="620" height="300" />

- Product View (User)

<img src="https://user-images.githubusercontent.com/31448375/139572721-3cb07a6d-137a-4939-a194-8725ff277a7b.png" width="580" height="440" />

- Create Product (Admin)

<img src="https://user-images.githubusercontent.com/31448375/139572719-081f68fb-61fe-4b16-b8b7-6d37e99ec8af.png" width="620" height="340" />

