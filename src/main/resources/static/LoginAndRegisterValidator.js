function validateEmail(email) {
    // Prosta walidacja adresu e-mail przy użyciu wyrażenia regularnego
    const emailRegex = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;
    return emailRegex.test(email);
}

function validatePassword(password) {
    // Tutaj możesz dodać dodatkowe zasady walidacji hasła, na przykład sprawdzanie długości itp.
    return password.length >= 8;
}

function validateLoginForm() {
    // Pobierz wartości pól formularza
    const email = document.getElementById("form3Example3").value;
    const password = document.getElementById("form3Example4").value;

    // Sprawdź, czy pola są wypełnione
    if (email.trim() === "" || password.trim() === "") {
        alert("Wprowadź adres e-mail i hasło.");
        return false;
    }

    // Walidacja adresu e-mail
    if (!validateEmail(email)) {
        alert("Nieprawidłowy adres e-mail.");
        return false;
    }

    // Walidacja hasła
    if (!validatePassword(password)) {
        alert("Hasło musi mieć co najmniej 8 znaków.");
        return false;
    }

    // Jeśli walidacja przebiegła pomyślnie, możesz zezwolić na zalogowanie się
    return true;
}