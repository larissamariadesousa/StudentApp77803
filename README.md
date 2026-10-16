StudentApp77803 – Student Registration App

Android app built for Mobile App Development 2 – CA1 (Dorset College Dublin).

Student: Larissa Maria de Sousa (77803) Lecturer: Eugene O'Regan

About

A multi-page app that simulates a student registration system:

Home page – navigate to the other pages.
Register page – register a student (Name, Course, Year). The Student ID is generated automatically and the data is saved in a Room database.
Search page – search a student by ID. Shows the name and course, or an error message if the student does not exist.
Validation – the year must be between 1 and 4.
Built with
Kotlin
Room (local database)
ViewModel + LiveData (MVVM)
Navigation Component
ViewBinding
Material Design 3
How to run
Clone the repository:
   git clone https://github.com/larissamariadesousa/StudentApp77803.git
Open the project in Android Studio and wait for the Gradle sync.
Select an emulator or device (Android 7.0 / API 24 or newer).

Click Run ▶.
Project structure
app/src/main/java/com/example/studentapp77803/
├── MainActivity.kt
├── data/   → Student, StudentDao, AppDatabase, StudentRepository, StudentValidator
└── ui/     → HomeFragment, RegisterFragment, SearchFragment, StudentViewModel
