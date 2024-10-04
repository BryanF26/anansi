

### **Aplikasi Daftar Film - Requirements and Tasks**

### **Project Overview:**
This app will allow users to browse movies, search by category, save movies to a watchlist, and rate movies they have watched. The app will interact with a movie database API to fetch the latest movies and detailed movie information.

### **Fragments and Activity Overview:**

#### **1. Fragment Daftar Film (Movie List Fragment):**
- Displays a list of the latest movies fetched from a movie API.
- For each movie, display:
  - **Poster Image**
  - **Title**
  - **Release Date**
  - **Short Overview**
- Clicking on a movie takes the user to the **Activity Detail Film** to view more information.

#### **2. Fragment Search by Kategori (Search by Category Fragment):**
- Displays a list of movie categories (e.g., Action, Comedy, Drama, etc.).
- Each category can be clicked to search movies within that category.
- Clicking on a category takes the user to a new fragment or activity that displays a list of movies in that category.

#### **3. Activity Detail Film (Movie Detail Activity):**
- Displays detailed information about a selected movie:
  - **Title**
  - **Synopsis**
  - **Release Date**
  - **Rating** (average rating)
  - **Trailer** (embedded video)
  - **User Rating**: Allows the user to rate the movie.
- Users can also add the movie to their **watchlist** from this page.

#### **4. Fragment Daftar Tontonan (Watchlist Fragment):**
- Displays movies that the user has added to their watchlist.
- Each movie in the watchlist displays:
  - **Poster Image**
  - **Title**
  - **Release Date**
  - **Rating**

---

### **Feature Details:**

#### **1. Fetching Movies from an API:**
- Use the **The Movie Database (TMDb) API** to fetch the latest movies and details.
  - **API Link**: [TMDb API](https://www.themoviedb.org/documentation/api)
  - **Endpoints**:
    - Get Latest Movies:  
      ```bash
      GET https://api.themoviedb.org/3/movie/now_playing?api_key=YOUR_API_KEY
      ```
    - Get Movies by Category:  
      ```bash
      GET https://api.themoviedb.org/3/genre/movie/list?api_key=YOUR_API_KEY
      ```
    - Get Movie Details:  
      ```bash
      GET https://api.themoviedb.org/3/movie/{movie_id}?api_key=YOUR_API_KEY
      ```

#### **2. Movie List Fragment (Daftar Film):**
- Display a list of the latest movies fetched from the TMDb API.
- Clicking on a movie navigates the user to the **Movie Detail Activity** to view more information.

#### **3. Search by Category (Kategori):**
- Display a list of categories (such as Action, Comedy, Drama, etc.) fetched from the API.
- Clicking on a category performs a search and displays movies within that category.

#### **4. Movie Detail Activity:**
- Show detailed movie information, including:
  - **Title**
  - **Release Date**
  - **Synopsis**
  - **Rating** (both user and average rating)
  - **Trailer** (video embedded via YouTube or another source)
- Allow users to:
  - Rate the movie (using a rating bar or similar).
  - Add or remove the movie from their **watchlist**.

#### **5. Watchlist Fragment (Daftar Tontonan):**
- Display the movies saved to the user’s watchlist.
- Users can remove movies from their watchlist from this fragment.

---

### **Tasks Breakdown:**

#### **1. Fragment Daftar Film (Movie List Fragment):**
**Tasks**:
- **Task 1: Fetch Movies**:
  - Use the TMDb API to fetch the latest movies and display them in a `RecyclerView`.
  - Show the movie poster, title, release date, and short overview.

- **Task 2: Navigate to Movie Detail Activity**:
  - Set up a click listener on each movie item in the list to navigate to the **Movie Detail Activity**.

#### **2. Fragment Search by Kategori (Search by Category Fragment):**
**Tasks**:
- **Task 3: Fetch Categories**:
  - Use the TMDb API to fetch a list of available movie categories.
  
- **Task 4: Search by Category**:
  - Allow users to click on a category and search for movies in that category.
  - Display the movies in a new fragment or activity.

#### **3. Activity Detail Film (Movie Detail Activity):**
**Tasks**:
- **Task 5: Display Movie Details**:
  - Use the TMDb API to fetch detailed movie information.
  - Display the movie’s title, release date, synopsis, rating, and trailer.

- **Task 6: Rate Movie**:
  - Add a rating bar or slider to allow users to rate the movie.
  - Store the user’s rating in local storage (e.g., SQLite or Room).

- **Task 7: Add to Watchlist**:
  - Allow users to add or remove the movie from their watchlist.
  - Save watchlist items to local storage.

#### **4. Fragment Daftar Tontonan (Watchlist Fragment):**
**Tasks**:
- **Task 8: Display Watchlist Movies**:
  - Display the movies saved to the user’s watchlist in a `RecyclerView`.
  - Show the movie poster, title, and release date.
  
- **Task 9: Remove from Watchlist**:
  - Allow users to remove movies from their watchlist.

---

### **Code Snippets:**

#### **Fetching Movies from TMDb API with Retrofit:**
You can fetch movie data using `Retrofit` with the TMDb API:

1. **Add Dependencies in `build.gradle.kts`**:
   ```kotlin
   implementation("com.squareup.retrofit2:retrofit:2.9.0")
   implementation("com.squareup.retrofit2:converter-gson:2.9.0")
   ```

2. **Create API Interface**:
   ```kotlin
   interface MovieApiService {
       @GET("movie/now_playing")
       fun getLatestMovies(@Query("api_key") apiKey: String): Call<MovieResponse>
   }
   ```

3. **Make the API Call**:
   ```kotlin
   val retrofit = Retrofit.Builder()
       .baseUrl("https://api.themoviedb.org/3/")
       .addConverterFactory(GsonConverterFactory.create())
       .build()

   val movieApi = retrofit.create(MovieApiService::class.java)
   val call = movieApi.getLatestMovies("YOUR_API_KEY")
   call.enqueue(object : Callback<MovieResponse> {
       override fun onResponse(call: Call<MovieResponse>, response: Response<MovieResponse>) {
           if (response.isSuccessful) {
               val movies = response.body()?.results
               // Update UI with movie data
           }
       }

       override fun onFailure(call: Call<MovieResponse>, t: Throwable) {
           // Handle error
       }
   })
   ```

#### **RecyclerView for Movie List**:
Use `RecyclerView` to display the list of movies:

```kotlin
class MovieAdapter(private val movieList: List<Movie>, private val onItemClick: (Movie) -> Unit) :
    RecyclerView.Adapter<MovieAdapter.MovieViewHolder>() {

    class MovieViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val movieTitle: TextView = view.findViewById(R.id.movie_title)
        val moviePoster: ImageView = view.findViewById(R.id.movie_poster)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_movie, parent, false)
        return MovieViewHolder(view)
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        val movie = movieList[position]
        holder.movieTitle.text = movie.title
        // Load movie poster using Glide or Picasso
        holder.itemView.setOnClickListener { onItemClick(movie) }
    }

    override fun getItemCount(): Int = movieList.size
}
```
