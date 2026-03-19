# 📝 Task Reference App

A modern Android application demonstrating **Clean Architecture** and **MVVM** using Jetpack Compose. This project was built as a reference for 1-year experienced Junior Developers.

---

## 🏗️ Architecture: Clean + MVVM
The project is divided into three distinct layers to ensure separation of concerns and testability:

1.  **UI (Presentation):** Built with **Jetpack Compose** and **Material 3**. ViewModels use `StateFlow` to expose state to the UI.
2.  **Domain:** The core business logic. Contains `UseCases` and pure Kotlin models.
3.  **Data:** Implementation of repositories. Handles **Room** for local caching and **Retrofit** for network calls.

---

## 🛠️ Tech Stack
* **Language:** Kotlin
* **UI Framework:** Jetpack Compose (Material 3)
* **Dependency Injection:** Hilt
* **Database:** Room (Single Source of Truth)
* **Networking:** Retrofit + Gson
* **Concurrency:** Coroutines & Flow

---

## 🚀 Key Features
* **Offline First:** Data is cached in Room and displayed even without internet.
* **Pull-to-Refresh:** Smooth synchronization with the JSONPlaceholder API.
* **Advanced UI:** Elevated cards, lifecycle-aware state collection, and empty state handling.

---

## 📸 Screenshots
| Task List | Empty State |
| :---: | :---: |
| *[Insert Screenshot 1]* | *[Insert Screenshot 2]* |