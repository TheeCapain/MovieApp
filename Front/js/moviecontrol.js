document.addEventListener('DOMContentLoaded', createFormEventListener);

let movieForm;

function createFormEventListener() {
  movieForm = document.getElementById('newMovieForm');
  movieForm.addEventListener('submit', handleFormSubmit);
}

function validateMovieTitle(data) {
  if (data.get('movieTitle') || data.get('moviePosterHref') === "") {
    alert('Missing title')
    return null
  }
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
