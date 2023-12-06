# Project Challenge: Lab Learn Kotlin with Examples

<br>
Repository for my abstraction for the project challenge "Abstracting Using Object Orientation with Kotlin"!!

<br>

## Technologies used
###
* **Language:** Kotlin
* **Versioning:** Git/GitHub
* **IDE:** IntelliJ IDEA Community Edition

<br>

## The project
###
* This is an application for simulating a registration system.
* The build system presents users, training, educational content, user types, types of educational content and difficulty levels (applicable to training and educational content).
* Trainings may contain educational content and registered users.

<br>

## Some details about the application
###

* There is no database. Therefore, when the execution ends, all data (registered users, content, training, etc.) is lost;
- The simulation of a type of interface running on the console added to the connection built between all the functions allows for cyclical and continuous navigation between all these functions, storing and using the data during this execution time;
* Data from classes and various variables are not inserted prior to execution. All values are received by a keyboard input reading system and are therefore entered by the user;
- All reception of values per entry have their validations according to each case and need.<br>Ex: validations to not receive numbers, validations to not receive null, validations to receive values from among offered options, etc.;
* There are also checks that provide feedback and options to the user.<br>Ex: The user is going to register a user for training, but there are no employees registered in the system. You will be notified that there are no users registered in the system and given the option to register users in the system.<br>Ex: The user is removing users in a formation. When there are no more users, a warning will be given and the application will direct you to the menu;
- Constructor overloading is used in classes for empty constructor calls and in some cases, default values (which can be changed) are determined for variables;
* There are loops that allow the user to perform operations repeatedly in an easier way.<br>Ex: Remove more than one user from the same formation in sequence;

<br>

## Organization
###

At [src/main/kotlin](https://github.com/jessicaraissapessoa/desafio-projeto-aprenda-kotlin-com-exemplos-lab-bootcamp-santander-dio-2023/tree/main/src/main/kotlin ) are the application codes.
These codes are divided into packages (folders/directories). Below is a description of what each package encompasses:

| Package                                                                                                                                              | Description                                                                                                                                                          | Files                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                        |
|------------------------------------------------------------------------------------------------------------------------------------------------------|----------------------------------------------------------------------------------------------------------------------------------------------------------------------|------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| [src/main/kotlin/application](https://github.com/daniellimadev/learn-kotlin-with-lab-examples/tree/main/src/main/kotlin/application)                 | Folder contains the main (application initializer) and interface simulations (user navigation menus that connect and order all application executions)               | [Main.kt](https://github.com/daniellimadev/learn-kotlin-with-lab-examples/blob/main/src/main/kotlin/application/main.kt)<br/>[homeScreen.kt](https://github.com/daniellimadev/learn-kotlin-with-lab-examples/blob/main/src/main/kotlin/application/homeScreen.kt)<br/>[menuUser.kt](https://github.com/daniellimadev/learn-kotlin-with-lab-examples/blob/main/src/main/kotlin/application/menuUser.kt)<br/>[menuContentEducational.kt](https://github.com/daniellimadev/learn-kotlin-with-lab-examples/blob/main/src/main/kotlin/application/menuContentEducational.kt)<br/>[menuTraining.kt](https://github.com/daniellimadev/learn-kotlin-with-lab-examples/blob/main/src/main/kotlin/application/menuTraining.kt)                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                         |
| [src/main/kotlin/enums](https://github.com/daniellimadev/learn-kotlin-with-lab-examples/tree/main/src/main/kotlin/enums)                             | Folder contains all application enums. Data type that stores sets of fixed values                                                                                    | [TypeUser.kt](https://github.com/daniellimadev/learn-kotlin-with-lab-examples/blob/main/src/main/kotlin/enums/TypeUser.kt)<br/> [TypeEducationalContent.kt](https://github.com/daniellimadev/learn-kotlin-with-lab-examples/blob/main/src/main/kotlin/enums/TypeEducationalContent.kt)<br/>[LevelDifficulty.kt](https://github.com/daniellimadev/learn-kotlin-with-lab-examples/blob/main/src/main/kotlin/enums/LevelDifficulty.kt)<br/>                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                     |
| [src/main/kotlin/user](https://github.com/daniellimadev/learn-kotlin-with-lab-examples/tree/main/src/main/kotlin/user)                               | Folder contains user-related class and functions. Adding, editing and removing users in the system                                                                   | [User.kt](https://github.com/daniellimadev/learn-kotlin-with-lab-examples/blob/main/src/main/kotlin/user/User.kt)<br/>[listUsers.kt](https://github.com/daniellimadev/learn-kotlin-with-lab-examples/blob/main/src/main/kotlin/user/listUsers.kt)<br/>[viewsUsers.kt](https://github.com/daniellimadev/learn-kotlin-with-lab-examples/blob/main/src/main/kotlin/user/viewsUsers.kt)<br/>[registerUser.kt](https://github.com/daniellimadev/learn-kotlin-with-lab-examples/blob/main/src/main/kotlin/user/registerUser.kt)<br/>[editUser.kt](https://github.com/daniellimadev/learn-kotlin-with-lab-examples/blob/main/src/main/kotlin/user/editUser.kt)<br/>[removalUser.kt](https://github.com/daniellimadev/learn-kotlin-with-lab-examples/blob/main/src/main/kotlin/user/removalUser.kt)<br/>                                                                                                                                                                                                                                                                                                                                                                                                                             |
| [src/main/kotlin/contentEducational](https://github.com/daniellimadev/learn-kotlin-with-lab-examples/tree/main/src/main/kotlin/contentEducational)   | Folder contains class and functions related to educational content. Adding, editing and removing educational content in the system                                   | [ContentEducational.kt](https://github.com/daniellimadev/learn-kotlin-with-lab-examples/blob/main/src/main/kotlin/contentEducational/ContentEducational.kt)<br>[listEducationalContents.kt](https://github.com/daniellimadev/learn-kotlin-with-lab-examples/blob/main/src/main/kotlin/contentEducational/listEducationalContents.kt)<br/>[displayEducationalContentsOptionMenu.kt](https://github.com/daniellimadev/learn-kotlin-with-lab-examples/blob/main/src/main/kotlin/contentEducational/displayEducationalContentsOptionMenu.kt)<br/>[registerEducationalContent.kt](https://github.com/daniellimadev/learn-kotlin-with-lab-examples/blob/main/src/main/kotlin/contentEducational/registerEducationalContent.kt)<br/>[editEducationalContent](https://github.com/daniellimadev/learn-kotlin-with-lab-examples/blob/main/src/main/kotlin/contentEducational/editEducationalContent.kt)<br/>[deleteEducationalContent](https://github.com/daniellimadev/learn-kotlin-with-lab-examples/blob/main/src/main/kotlin/contentEducational/deleteEducationalContent.kt)<br/>                                                                                                                                                  |
| [src/main/kotlin/training](https://github.com/daniellimadev/learn-kotlin-with-lab-examples/tree/main/src/main/kotlin/training)                       | Folder contains class and functions related to educational training. Adding, editing and removing trainings, users in trainings and educational content in trainings | [Training.kt](https://github.com/daniellimadev/learn-kotlin-with-lab-examples/blob/main/src/main/kotlin/training/Training.kt)<br/>[listTraining.kt](https://github.com/daniellimadev/learn-kotlin-with-lab-examples/blob/main/src/main/kotlin/training/listTraining.kt)<br/>[displayListTrainingsOptionMenu.kt](https://github.com/daniellimadev/learn-kotlin-with-lab-examples/blob/main/src/main/kotlin/training/displayListTrainingsOptionMenu.kt)<br/>[registerTraining.kt](https://github.com/daniellimadev/learn-kotlin-with-lab-examples/blob/main/src/main/kotlin/training/registerTraining.kt)<br/>[editDataTraining.kt](https://github.com/daniellimadev/learn-kotlin-with-lab-examples/blob/main/src/main/kotlin/training/editDataTraining.kt)<br/>[excludeTraining.kt](https://github.com/daniellimadev/learn-kotlin-with-lab-examples/blob/main/src/main/kotlin/training/excludeTraining.kt)<br/>[editUsersTraining.kt](https://github.com/daniellimadev/learn-kotlin-with-lab-examples/blob/main/src/main/kotlin/training/editUsersTraining.kt)<br/>[editContentsTraining.kt](https://github.com/daniellimadev/learn-kotlin-with-lab-examples/blob/main/src/main/kotlin/training/editContentsTraining.kt)<br/> |

<br>

## Demo screenshots
###

### Navigation between menus and termination of execution:

<br>

**Part of Home screen:**

![homeScreen.png](img/homeScreen.png "Navigation between menus")

<br>

**Part of user of creation:**

![registeringUser.png](img/registeringUser.png "Registering users")

<br>

**Part of list of User:**

![listUser.png](img/listUser.png "listing users")

<br>