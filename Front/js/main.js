const movies = "http://localhost:8080/api/movie/all-movies"

function out(text) {
  console.log(text)
}

async function callMovieList() {
  return fetch(movies).then(response => response.json())
}

async function displayTable() {
  const movieList = await callMovieList();
  for (let movie of movieList) {
    let parent = document.getElementById('movie-content');
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
    movieOverview.append(poster)
    movieOverview.append(title)
  }
}

displayTable()
