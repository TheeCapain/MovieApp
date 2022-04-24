const searchMovie = "http://localhost:8080/api/movie/movie-title/"

const searchByTitleField = document.getElementById("text-input")
const searchByTitleBtn = document.getElementById("search-button-input")


function fetchMovieByTitle(title) {
  return fetch(searchMovie + title).then(response => response.json());
}

async function getByTitle() {
  location.reload();
  const title = searchByTitleField.value;
  const movieList = await fetchMovieByTitle(title)

  for (let movie of movieList) {
    let parent = document.getElementById('movie-content');
    let aTag = document.createElement('a')
    aTag.href = "api/movie/" + movie.movieId
    //each movie box
    let movieOverview = document.createElement('div')
    movieOverview.classList.add('movie-overview')
    //the movie poster
    let poster = document.createElement('img')
    poster.classList.add('movie-poster')
    poster.src = movie.moviePosterHref
    //the movie title
    let title = document.createElement('div')
    title.classList.add('movie-title')
    title.innerText = movie.movieTitle
    out(movie)
    parent.append(movieOverview)
    movieOverview.append(aTag)
    aTag.append(poster)
    movieOverview.append(title)
  }
}

searchByTitleBtn.addEventListener('click', getByTitle)
