document.addEventListener( "DOMContentLoaded", function() {
    // 当用户输入email时，取消原始的默认值
    document.getElementById('username').addEventListener( "focus", function() {
        if (this.value === "username") {
            this.value = "";
            var pwd = document.getElementById("password");
            if (pwd.value === "password") {
                pwd.value = "";
            }
        }
    })

    // 当用户输入password时，取消原始的默认值
    document.getElementById("password").addEventListener( "focus", function() {
        if  (this.value === "password") {
            this.value = "";
        }
    })

    // 跳转注册页面
    document.getElementById("register").addEventListener( "click", function() {
        window.location.href = "./register.html";
    })
} );

// 登录页面：get方法查询id
document.getElementById('loginForm').addEventListener('submit', function(event) {
    event.preventDefault(); // 阻止默认的表单提交行为
     // 获取用户输入的数据
     const username = document.getElementById('username').value;
     const password = document.getElementById('password').value;
 
     // 使用 axios 发送 GET 请求
     axios.get('/user/login', {
         params: {
             username: username,
             password: password
         }
     })
     .then(function(response) {
         console.log(response.data); 
     })
     .catch(function(error) {
         console.error('Error fetching user ID:', error);
     });
 });
