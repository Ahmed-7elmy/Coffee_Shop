# Coffee_Shop
CV Project Description (Concise):
E-Commerce Android App | Kotlin, MVVM, Android Jetpack, Glide

Developed a feature-rich e-commerce app using MVVM architecture with Android Jetpack components (LiveData, ViewModel).

Integrated dynamic UI components using RecyclerView, ViewBinding, and Glide for seamless image loading.

Implemented product browsing by category, detailed product views, cart management, and real-time price updates.

Utilized repository pattern for data handling and observed lifecycle-aware data flow between layers.

Long Project Description:
E-Commerce Android Application
This project is a fully functional e-commerce app that allows users to explore products by category, view detailed item information, adjust quantities, and manage a shopping cart. Key highlights include:

Architecture: Followed MVVM (Model-View-ViewModel) pattern to separate business logic from UI, ensuring scalability and testability.

ViewModel fetched data from a repository and exposed it via LiveData for lifecycle-aware UI updates.

Data Classes (BannerModel, CategoryModel, ItemsModel) structured API/data responses.

Features:

Dynamic Lists: Implemented horizontal and vertical RecyclerViews with adapters (CategoryAdapter, PopularAdapter) for category/product displays.

Item Details: Used Glide for image loading and enabled size selection, quantity adjustments, and cart additions in DetailActivity.

Cart Management: Tracked item quantities and total prices using a custom ManagmentCart class.

Responsive UI: Applied progress bars for loading states and handled click events for smooth navigation between activities.

Technical Tools:

Android Jetpack: LiveData, ViewModel, ViewBinding, and Activity/Fragment navigation.

Third-Party Libraries: Glide for efficient image loading.

UI Components: RecyclerView (with GridLayoutManager and LinearLayoutManager), Toast notifications, and Intent-based navigation.

Optimizations:

Alternating RecyclerView item layouts (left/right image placement) in ItemsListCategoryAdapter for enhanced visual appeal.

Efficient state management for selected categories using background resource updates.

Tools & Technologies Used:
Languages: Kotlin

Architecture: MVVM (Model-View-ViewModel)

Android Components: LiveData, ViewModel, RecyclerView, ViewBinding, Intent

Libraries: Glide (Image Loading)

Tools: Android Studio, Gradle
