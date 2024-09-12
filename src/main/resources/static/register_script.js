document.addEventListener( "DOMContentLoaded", function() {
    // 跳转登录页面
    document.getElementById("login").addEventListener( "click", function() {
        window.location.href = "./login.html";
    })
} );

// 注册页面，传用户名和密码
document.getElementById("register-submit").addEventListener( "submit", function(event) {
    event.preventDefault();

    const username = document.getElementById('username').value;
    const password = document.getElementById('password').value;
    const confirmPassword = document.getElementById('confirm-password').value;

    if(password !== confirmPassword) {
        alert("Passwords do not match");
        document.getElementById("confirm-password").value = '';
        document.getElementById("password").value = "";
        return;
    }

    const params = new URLSearchParams();
    params.append('username', username);
    params.append('password', password);

    axios.post("/user/register", params, {
        headers: {
            'Content-Type': 'application/x-www-form-urlencoded'
        }
    })
    .then(res => {
        if (res.code === 0) {
            window.location.href="./login.html";
        }
        else {
            alert("Registration failed: " + res.data.message);
        }
    })
    .catch(err => {
        console.error("Error during registration:", err);
    });
})