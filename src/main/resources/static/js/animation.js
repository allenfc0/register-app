

function register() {
    let x = document.getElementById("login");
    let y = document.getElementById("register");
    let z = document.getElementById("btn");

    //console.log(x);
    x.style.left = "-400px";
    y.style.left = "50px";
    z.style.left = "110px";
}

function login() {
    let x = document.getElementById("login");
    let y = document.getElementById("register");
    let z = document.getElementById("btn");

    x.style.left = "50px";
    y.style.left = "450px";
    z.style.left = "0px";
}

function hamburger_toggle(a) {

    let p = document.getElementById("allPages");

    a.classList.toggle("change");


    if (a.style.display === "none") {
        p.style.display = "block";
        console.log("hamburger was clicked");
    } else {
        console.log("hamburger was unclicked");
    }

}