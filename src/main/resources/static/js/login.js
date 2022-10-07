function login() {

    const username = document.getElementById("floatingInput").value;
    const password = document.getElementById("floatingpassword").value;

    if(username == "") {
        showError("Username is required");
        return;
    }

    if(password == "") {
        showError("Password is required");
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
        window.location.href = "/catalog";
    }else{
        const message = await response.text();
        showError(message);
    }
};

const showError = (message) =>{
    const errorDiv = document.getElementById("error");    
    const errorMessage = document.getElementById("error-message");

    errorDiv.style.display = 'block';
    errorMessage.innerHTML = message;
}