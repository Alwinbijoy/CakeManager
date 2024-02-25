"# CakeManager" 

This documentation provides an overview of the Cake Management API endpoints and their expected inputs and outputs.

Cake Management API endpoints

1. To add the bulk data  from url - https://gist.githubusercontent.com/hart88/198f29ec5114a3ec3460/raw/8dd19a88f9b8d24c23d9960f3300d0c917a4f07c/cake.json
   -------------------------------------------------------------------------------------------------------------------------------------------------------
   POST method - http://localhost:8080/cakes/add-from-url
   
2. To Add a Cake
   -------------
   POST method - http://localhost:8080/cakes/add
{
    "title": "Lemon cheesecake",
    "description": "A cheesecake made of lemon",
    "image": "https://s3-eu-west-1.amazonaws.com/s3.mediafileserver.co.uk/carnation/WebFiles/RecipeImages/lemoncheesecake_lg.jpg"
}
3. Get a Cake by ID
   ----------------
   GET method - http://localhost:8080/cakes/get?id=1
    Params: Key: id ; Value: 1
4. Get All Cakes
   -------------
   GET method - http://localhost:8080/cakes/all
5. Update a Cake
   -------------
   PUT method - http://localhost:8080/cakes/update/4
   {
    "title": "Carrot cake",
    "description": "Bugs bunny's favourite",
    "image": "http://www.villageinn.com/i/pies/profile/carrotcake_main1.jpg"
}
6. Delete a Cake
    --------------
   DELETE method - http://localhost:8080/cakes/delete/4
   
7. Update Cake Title by ID
    --------------------------
   PATCH method - http://localhost:8080/cakes/updatetitle/5
   {
    "title": "Birthday cake11"
}

-------------------------------------------------------------------------------------------------
This project involves both authentication and authorization mechanisms, requiring valid usernames and passwords 
1. GET method - http://localhost:8080/cakes/all
need Admin credentials
2. GET method - http://localhost:8080/cakes/get?id=1
need User credentials
-----------------------------------------------------------------------------------------------------------
. Controller Testcases added. These test cases involve mocking API behaviors to verify the response status code and messages returned by the controller.

. Added github Workflows : cakeworkflow

. Integrated Dockerfile in Cakemanger project , so the Cakemanager-1.0.0 image is depolyed in the Container., using Docker Desktop

MySQL Database - alwinsys

MySQL Table - cakes

Stores information about cakes, including their title, description, and image URL.

Columns: id (Primary Key): Unique identifier for each cake, title: Title of the cake, description: Description of the cake, image: URL of the image representing the cake.
