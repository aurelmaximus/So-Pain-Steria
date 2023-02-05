
  function DemasquePassword() {
    var x = document.getElementById("Mot de passe");
    var y = document.getElementById("show-password");

    if (x.type === "password") {
      x.type = "text";
      y.classList.remove("fa-eye-slash");
      y.classList.add("fa-eye");
    } else {
      x.type = "password";
      y.classList.remove("fa-eye");
      y.classList.add("fa-eye-slash");
    }
  }
