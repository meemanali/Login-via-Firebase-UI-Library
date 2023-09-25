# Login-via-Firebase-UI-Library
Welcome to "Login-via-Firebase-UI-Library" repo. It contains an Android App which helps users to sign in with their Email, Google account, Github, Facebook, Twitter and with their phone number. Some features in this project are:

* Sign in using Email, Google, Github, Facebook, Twitter, or phone number.
* Firebase Authentication for secure and easy authentication methods.
* Clean and intuitive user interface.
* Easily customizable for your own branding.

# Preview:

<span>
  <img src="https://github.com/meemanali/Login-via-Firebase-UI-Library/blob/master/Login-via-Firebase-UI-Library%201.png" alt="Main Screen" width="250" height="550" title="Main Screen">
</span>

<span>
  <img src="https://github.com/meemanali/Login-via-Firebase-UI-Library/blob/master/Login-via-Firebase-UI-Library%202.png" alt="Sign in Screen" width="250" height="550" title="Sign in Screen">
</span>

<span>
  <img src="https://github.com/meemanali/Login-via-Firebase-UI-Library/blob/master/Login-via-Firebase-UI-Library%203.png" alt="Main Screen After Signing In" width="250" height="550" title="Main Screen After Signing In">
</span>

# Getting Started:
As the project does not contain play-services.json file, thus you have to get your own from Firebase. To get this config file and to use the project on your system, follow the steps below:

<h4>Create a Firebase Project:</h4>

* Go to the [Firebase Console](https://firebase.google.com/)
* Click 'Add Project' and follow the prompts to create a new project with the same project ID as this one.

<h4>Enable Google Sign-In:</h4>

* In your Firebase project's console, navigate to the "Authentication" section.
* Under the "Sign-in method" tab, enable the "Google" sign-in provider. (don't forget to enable other providers for using them. Rememeber, for enabling facebook provider you also need App Id and App secret which you can get from [develpoers.facebook.com](https://develpoers.facebook.com/)

<h4>Download google-services.json:</h4>

* After enabling Google Sign-In, click on the "Download" button next to "google-services.json".
* Place the downloaded google-services.json file in the app directory of your Android project.

<h4>Run the App:</h4>

* Open the project in Android Studio.
* Build and run the app in Emulator or in your physical device.
