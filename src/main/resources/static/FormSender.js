function sendLoginForm() {
    // Pobierz wartości pól formularza
    const email = document.getElementById("emailInput").value;
    const password = document.getElementById("passwordInput").value;

    // Utwórz obiekt JSON z danymi formularza
    const formData = {
        login: email,
        haslo: password,
    };

    // Wysyłanie formularza jako JSON na serwer
    fetch('url_do_endpointu', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json',
        },
        body: JSON.stringify(formData),
    })
        .then(response => {
            if (!response.ok) {
                throw new Error('Network response was not ok');
            }
            return response.json();
        })
        .then(data => {
            // Odpowiedź serwera - możesz obsłużyć ją tutaj
            console.log(data);
        })
        .catch(error => {
            // Błąd po stronie klienta lub serwera
            console.error('Error:', error);
        });
}