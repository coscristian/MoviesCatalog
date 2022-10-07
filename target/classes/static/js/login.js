function login() {
    const errorDiv = document.getElementById("error");    
    const username = document.getElementById("floatingInput").value;
    const password = document.getElementById("floatingpassword").value;

    if(username == "") {
        errorDiv.innerHTML = "Username is required";
        return;
    }

    if(password == "") {
        errorDiv.innerHTML = "Password is required";
        return;
    }

    const body = {
        "username": username,
        "password": password
    }

    postToLogin(body);
}

const postToLogin = async (bodyObject) => {
    const url = "/api/login";
    const response = await fetch(url, {
        method: "POST",
        body: JSON.stringify(bodyObject),
        headers: {
            "Content-Type":"application/json"
        }
    });

    if(response.ok){
        const user = await response.json();
        localStorage.setItem("loggedUser", JSON.stringify(user));
        console.log("Login exitoso ", user.username);
    }else{
        document.getElementById("error").innerHTML = await response.text();
    }
};