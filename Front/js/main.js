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
    for (let i = 0; i<movieList.length; i++){
      let parent = document.getElementById('table-parent');
      const tableRow = document.createElement('tr');
      const title = document.createElement('td');
      const description = document.createElement('td');
      let length = document.createElement('td');
      title.textContent = movie.movieTitle;
      console.log(title)
      description.textContent = movie.movieDescription;
      length = movie.movieLength;
      tableRow.append(title)
      tableRow.append(description);
      tableRow.append(length)
      parent.append(tableRow)
    }

  }
}

displayTable()
