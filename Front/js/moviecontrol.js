document.addEventListener('DOMContentLoaded', createFormEventListener);

let movieForm;

function createFormEventListener(){
  movieForm = document.getElementById('newMovieForm');
  movieForm.addEventListener('submit', handleFormSubmit);
}

async function handleFormSubmit(event){
  event.preventDefault();
  const form = event.currentTarget;
  const url = form.action
  out(form);
  out(url);

  try {
    const formData = new FormData(form);
    const responseData = await postMovieAsJson(url, formData);
    out(responseData);
    alert(formData.get(movieTitle) + 'er lavet');
  } catch (err){
    alert(err.message)
    out(err)
  }
}

async function postMovieAsJson(url, formData) {
  out(formData.entries)
  const plainFormData = Object.fromEntries(formData.entries);
  out(plainFormData)

  plainFormData.movieTitle = {};

  const formDataJsonString = JSON.stringify(plainFormData)

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
