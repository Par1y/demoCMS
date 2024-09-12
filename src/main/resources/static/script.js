function toLogin() {
    window.location.href = "/login.html";
}

document.addEventListener("DOMContentLoaded", function() {
    var button = document.getElementById("logButton");
    button.addEventListener("click", toLogin)
})