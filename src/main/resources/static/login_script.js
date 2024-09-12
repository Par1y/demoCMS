document.addEventListener( "DOMContentLoaded", function() {
    // 跳转注册页面
    document.getElementById("register").addEventListener( "click", function() {
        window.location.href = "./register.html";
    })
} );

// 登录页面：post
document.getElementById('loginForm').addEventListener('submit', function(event) {
    event.preventDefault(); 

     // 获取用户输入的数据
     const username = document.getElementById('username').value;
     const password = document.getElementById('password').value;
 
     // 使用 axios 发送 POST 请求
    const params = new URLSearchParams();
    params.append("username", username);
    params.append("password", password);

     axios.post('/user/login', params, {
        headers: {
            'Content-Type': 'application/x-www-form-urlencoded'
        }
     })
     .then(res => {
         if (res.data.code === 0) {
            alert(`登录成功，欢迎您 ${username}!`);
         } 
         else {
            alert(`登录失败: ${res.data.message}`);
        }
     })
     .catch(function(error) {
         console.error('Error fetching user ID:', error);
     });
 });
