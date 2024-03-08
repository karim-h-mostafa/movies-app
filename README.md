# movies-app

This Android application allows users to browse movies using The Movie Database (TMDb) API and view details about each movie.

## Business Requirements

- Connect the application with The Movie Database (TMDb) API.
- Sync movies from the API and cache them to Room Database.
- Invalidate cached movie list in the database every 4 hours.
    - If the user has already accessed the list, it should be displayed from the database.
    - If the app is opened after 4 hours, the cached list should be deleted and synced again from the API.

## Design

- Main screen listing movies categorized horizontally.
![App Screenshot](/Users/karim/StudioProjects/Movies/Screenshot 2024-03-07 at 8.15.38 PM.png)
- Details screen displaying required information about the selected movie.
- ![](/Users/karim/StudioProjects/Movies/Screenshot 2024-03-07 at 8.19.37 PM.png)

## Technical Achievements

- Project created in Kotlin.
- Handle requests and thread handling using Coroutine.
- Utilize DataBinding.
- Use Hilt for Dependency Injection.
- Project architecture based on MVVM .
- Project architecture based on Clean Architecture .
- Navigation handled using Navigation Component.
- Avoid using deprecated components.
- Avoid using RxJava or RxKotlin.
- ## Layers
1. Presentation: the layer that interacts with the UI.

2. Use cases: The actions that the user can trigger (clicking on a button, navigating to a destination)

3. Domain: contains all the business models (data classes)

4. Data: contains an abstract definition of different data sources. It's modeled using repositories and data sources


## App modules
- App: includes everything about android framework, so Framework and Presentation layer
- Domain: contains the definitions of business logic of the app, the server data model, the abstract definition of repositories and the definition of the use cases.
- Data: contains the implementation of the abstract definitions of the domain layer. Can be reused by any application without modifications. It contains repositories and data sources implementations, the database definition and its DAOs, the network APIs definitions, some mappers to convert network api models to database models and vice versa.




## Acknowledgments

- I'd like to acknowledge that the project is still in progress.
- Initially, I anticipated it to be a small task or code quiz, 
- but due to my full-time job commitments, I need an additional day to complete the app.
- Thank you for your understanding and patience.

## Contact
- karim.h.mostafa0@gmail.com
- +201000910367

