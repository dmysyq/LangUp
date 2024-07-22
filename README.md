# LangUp

## Introduction

In the modern world, knowing English is becoming an increasingly important skill, opening up numerous opportunities in various areas of life. With the growing popularity of learning English, there is a need for effective and accessible teaching methods. One such method is using video content, such as movies and TV shows, which not only entertains but also serves as an excellent tool for immersion in the language environment.

**LangUp** is a mobile application designed to help users learn English through watching movies and TV shows. The app offers interactive exercises for memorizing words and phrases extracted from subtitles, making the learning process both engaging and enjoyable.

**LangUp** is aimed at:
- People who want to learn English in their free time.
- Movie and TV show enthusiasts.
- Mobile users seeking convenient and effective ways to learn a language.

## Key Features

- **Interactive Exercises**: Users can create sentences from provided words.
- **Level and Life System**: Motivation for users and increased interest in learning.
- **Personal Account and Settings**: Manage account details, change passwords, set nicknames, enable dark mode, and adjust other parameters.

## Technologies Used

- **Gson**: For extracting data from subtitles.
- **Cloud Firestore and Firebase Realtime Database**: For storing and managing user data.
- **Java and Android Studio**: For creating a user-friendly and intuitive interface.

## Libraries Used

- **SharedPreferences**: Mechanism for storing simple data in key-value pairs.
- **Firebase Authentication (FirebaseAuth)**: User authentication through various methods.
- **Gson**: Serialization and deserialization of Java objects to and from JSON format.
- **Intent (android.content.Intent)**: Launching Android components and exchanging data between them.
- **androidx.core.content.ContextCompat**: Access to application resources and functions.
- **TypeToken (com.google.gson.reflect.TypeToken)**: Handling complex data types in JSON format.
- **ArrayList (java.util.ArrayList)**: Storing and managing collections of objects.

## Input and Output Data

### Input Data

The mobile application uses the following input data:
- **JSON with Content from TV Shows**: JSON format data containing information about TV show titles, episode numbers, episode titles, and dialogue text in both original and translated languages, used for level functionality and learning.
- **Authorization**: Login and password for accessing personal accounts and application features.
- **Sentences in Levels and Flags in Settings**: Collected sentences and flags for setting language proficiency levels and other application settings.

### Output Data

The output data of the mobile application includes:
- **Content in Levels**: Content relevant to the user’s language proficiency level.
- **Dynamic Buttons**: Buttons for selecting specific actions, such as choosing a movie or episode.
- **Profile Data Output**: Display of user information, language proficiency level, and other settings in the personal account.
- **Error Messages**: Informative messages for users in case of errors or malfunctions in the application.

## Program Components

The application consists of the following activities and classes:
- **WelcomeActivity**: The first screen users see when launching the app, offering options for login or registration. Uses the `AuthManager` class to check the user's login status and redirect them to the appropriate screens.
- **LoginActivity**: The login screen where users enter their credentials. Uses Firebase Authentication to verify credentials and the `AuthManager` class to manage login status.
- **SigninActivity**: The registration screen where users can create a new account by entering the necessary details. Uses Firebase Authentication to create new accounts and the `AuthManager` class to manage login status.
- **StartupActivity**: Determines if the user is authorized. Uses the `AuthManager` class to check if the user has logged in previously and redirects them to either the main app screen or the welcome screen.
- **MainActivity**: The main screen of the app with a list of available TV show episodes. Allows users to select and view episodes.
- **SettingsActivity**: The settings screen where users can adjust sound effects, vibration, and other parameters. Uses the `AuthManager` class to manage login status.
- **UserProfileActivity**: The user profile screen where personal details can be viewed and edited. Uses the `AuthManager` class to manage login status and provides the option to log out.
- **AuthManager**: Manages user authentication in the app. It maintains information about whether the user is logged in and provides methods for managing this state.

## Installation

To run the application on your device, follow these steps:

1. Clone the repository:

   git clone https://github.com/your-username/langup.git

3. Open the project in [Android Studio](https://developer.android.com/studio).

4. Sync the project with Gradle.

5. Run the application on an emulator or connected device.
