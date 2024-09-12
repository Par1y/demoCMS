document.addEventListener( "DOMContentLoaded", function() {
    // 当用户输入email时，取消原始的默认值
    document.getElementById('username').addEventListener( "focus", function() {
        if (this.value === "username") {
            this.value = "";
            var pwd = document.getElementById("password");
            var confirm_pwd = document.getElementById("confirm-password");
            if (pwd.value === "password") {
                pwd.value = "";
            }
            if (confirm_pwd.value === "password") {
                confirm_pwd.value = "";
            }
        }
    })

    // 当用户输入password时，取消原始的默认值
    document.getElementById("password").addEventListener( "focus", function() {
        if  (this.value === "password") {
            this.value = "";
        }
    })

    // 当用户输入password时，取消原始的默认值
    document.getElementById("confirm-password").addEventListener( "focus", function() {
        if  (this.value === "password") {
            this.value = "";
        }
    })

    // 跳转登录页面
    document.getElementById("login").addEventListener( "click", function() {
        window.location.href = "./login.html";
    })
} );

// 注册页面，传用户名和密码
const params = new URLSearchParams();
document.getElementById("register-submit").addEventListener( "submit", function(event) {
    event.preventDefault();

    const username = document.getElementById('username').value;
    const password = document.getElementById('password').value;
    const confirmPassword = document.getElementById('confirm-password').value;

    if(password !== confirmPassword) {
        alert("Passwords do not match");
        return;
    }

    params.append('username', username);
    params.append('password', password);

    axios.post("/user/register", params, {
        headers: {
            'Content-Type': 'application/x-www-form-unlencoded'
        }
    })
    .then(res => {
        console.log(res.data);
    })
    .catch(err => {
        console.log(err);
    })
})