function validateForm() {
    var name = document.getElementById("name").value;
    if (name === "") {
        alert("Пожалуйста, введите имя.");
        return false; // Останавливает отправку формы
    }
    return true; // Разрешает отправку формы
}