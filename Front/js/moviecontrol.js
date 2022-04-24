const movies = "http://localhost:8080/api/movie/all-movies"
const sortedMovies = "http://localhost:8080/api/movie/moviesort"
document.addEventListener('DOMContentLoaded', createFormEventListener);

let movieForm;

async function callMovieList() {
  return fetch(movies).then(response => response.json())
}

async function callSortedMovies() {
  return fetch(sortedMovies).then(response => response.json())
}

async function displayTable() {
  const movieList = await callSortedMovies();

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

displayTable()

function createFormEventListener() {
  movieForm = document.getElementById('newMovieForm');
  movieForm.addEventListener('submit', handleFormSubmit);
}

function validateMovieTitle(data) {
  if (data.get('movieTitle') === "" || data.get('moviePosterHref') === "") {
    alert('Missing title or url')

    //skal sørge for at posterHref er en href
    return null
  } else return data
}

async function handleFormSubmit(event) {
  //preventDefault forhindrer form i at udføre default submit. altås sende sig selv til backend.
  event.preventDefault();
  const form = event.currentTarget;
  const url = form.action;

  try {
    const formData = new FormData(form);

    if (!validateMovieTitle(formData) === false) {
      await postFormDataAsJson(url, formData);
      alert(formData.get('movieTitle') + ' er oprettet' + 'moviePosterHref');
    }
  } catch (err) {
    alert(err.message);
    out(err);
  }
}

async function postFormDataAsJson(url, formData) {
  out(formData.entries());
  const plainFormData = Object.fromEntries(formData.entries());
  out(plainFormData);

  const formDataJsonString = JSON.stringify(plainFormData);

  const fetchOptions = {
    method: "POST",
    headers: {"Content-Type": "application/json"},
    body: formDataJsonString
  };

  const response = await fetch(url, fetchOptions);
  if (!response) {
    const errorMessage = await response.text();
    throw new Error(errorMessage);
  }

  return response.json();
}
