# Tdo - Task Management Android App

A modern, feature-rich Android application for managing your daily tasks with built-in timer functionality and Firebase authentication.

## 📱 Features

### Authentication
- **User Registration**: Create a new account with email and password
- **Secure Login**: Sign in with Firebase Authentication
- **Remember Me**: Option to save login credentials for quick access
- **Password Validation**: Ensures password confirmation matches

### Task Management
- **Add Tasks**: Create and organize your daily tasks
- **Mark Complete**: Check off completed tasks
- **Delete Tasks**: Remove tasks with confirmation dialog
- **Task List**: View all tasks in a clean, scrollable RecyclerView

### Timer Functionality
- **Countdown Timer**: Set a timer in minutes for focused work sessions
- **Start/Pause/Resume**: Full control over your timer
- **Reset Timer**: Quickly reset to start over
- **Visual Display**: Real-time countdown display in MM:SS format

### User Experience
- **Splash Screen**: Beautiful splash screen on app launch
- **Material Design**: Modern UI following Material Design guidelines
- **Dark Theme Support**: Built-in dark theme support
- **Smooth Animations**: Enhanced user experience with animations

## 🛠️ Technology Stack

- **Language**: Java
- **Platform**: Android (API 24+)
- **Build System**: Gradle with Kotlin DSL
- **Authentication**: Firebase Authentication
- **Database**: Firebase Realtime Database
- **UI Framework**: AndroidX Material Components
- **Architecture**: Standard Android Activities

## 📋 Requirements

- Android Studio (latest version recommended)
- JDK 11 or higher
- Android SDK (API 24 - Android 7.0 or higher)
- Firebase project with Authentication and Realtime Database enabled
- Google Services JSON file (`google-services.json`)

## 🚀 Getting Started

### Prerequisites

1. **Firebase Setup**:
   - Create a Firebase project at [Firebase Console](https://console.firebase.google.com/)
   - Enable Authentication (Email/Password)
   - Enable Realtime Database
   - Download `google-services.json` and place it in the `app/` directory

2. **Android Studio**:
   - Install Android Studio with Android SDK
   - Ensure Android SDK API 24+ is installed

### Installation

1. **Clone the repository**:
   ```bash
   git clone [https://github.com/yourusername/tdo.git](https://github.com/OmarAhmed770/Tdo-Task-Management-Android-App.git)
   cd tdo
   ```

2. **Open in Android Studio**:
   - Launch Android Studio
   - Select "Open an existing project"
   - Navigate to the cloned directory

3. **Configure Firebase**:
   - Ensure `google-services.json` is in the `app/` directory
   - Sync Gradle files (File → Sync Project with Gradle Files)

4. **Build and Run**:
   - Connect an Android device or start an emulator
   - Click "Run" or press `Shift + F10`

## 📁 Project Structure

```
Tdo/
├── app/
│   ├── src/
│   │   ├── main/
│   │   │   ├── java/com/example/tdo/
│   │   │   │   ├── MainActivity.java          # Login activity
│   │   │   │   ├── SignUpActivity.java        # Registration activity
│   │   │   │   ├── HomeActivity.java          # Main task management screen
│   │   │   │   ├── SplashActivity.java        # Splash screen
│   │   │   │   ├── Task.java                  # Task model class
│   │   │   │   └── TaskAdapter.java           # RecyclerView adapter
│   │   │   ├── res/                           # Resources (layouts, drawables, etc.)
│   │   │   └── AndroidManifest.xml
│   │   └── test/                              # Unit tests
│   ├── build.gradle.kts                       # App-level build configuration
│   └── google-services.json                   # Firebase configuration
├── gradle/
│   └── libs.versions.toml                      # Dependency versions
├── build.gradle.kts                           # Project-level build configuration
└── settings.gradle.kts                         # Project settings
```

## 🎯 Usage

1. **First Time Setup**:
   - Launch the app
   - Tap "Sign Up" to create a new account
   - Enter username, email, password, and confirm password
   - Tap "Sign Up" to register

2. **Login**:
   - Enter your email and password
   - Optionally check "Remember Me" to save credentials
   - Tap "Login" to access your tasks

3. **Managing Tasks**:
   - Enter a task description in the input field
   - Tap "Save Task" to add it to your list
   - Check the checkbox to mark a task as complete
   - Tap the delete button to remove a task (with confirmation)

4. **Using the Timer**:
   - Enter the desired time in minutes
   - Tap "Start Timer" to begin countdown
   - Use "Pause Timer" to pause, "Resume Timer" to continue
   - Tap "Reset Timer" to reset the countdown

## 🔧 Configuration

### Firebase Configuration

The app requires Firebase Authentication and Realtime Database. Make sure:

1. Firebase Authentication is enabled with Email/Password provider
2. Realtime Database is created and rules are configured
3. `google-services.json` is properly placed in the `app/` directory

### Build Configuration

- **Minimum SDK**: 24 (Android 7.0)
- **Target SDK**: 34 (Android 14)
- **Compile SDK**: 34

## 📦 Dependencies

- `androidx.appcompat:appcompat` - AndroidX compatibility library
- `com.google.android.material:material` - Material Design components
- `androidx.constraintlayout:constraintlayout` - Constraint layout
- `com.google.firebase:firebase-auth` - Firebase Authentication
- `com.google.firebase:firebase-database` - Firebase Realtime Database

## 🤝 Contributing

Contributions are welcome! Please feel free to submit a Pull Request.

1. Fork the project
2. Create your feature branch (`git checkout -b feature/AmazingFeature`)
3. Commit your changes (`git commit -m 'Add some AmazingFeature'`)
4. Push to the branch (`git push origin feature/AmazingFeature`)
5. Open a Pull Request

## 📝 License

This project is open source and available under the [MIT License](LICENSE).

## 👤 Author

**Your Name**
- GitHub: [@OmarAhmed770](https://github.com/OmarAhmed770)

## 🙏 Acknowledgments

- Firebase for authentication and database services
- Material Design for UI components
- Android community for support and resources

---

⭐ If you find this project helpful, please consider giving it a star!
