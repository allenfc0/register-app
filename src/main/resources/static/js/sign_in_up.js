
//arraylist database
let userDatabase = []


let user1 = {
    firstName: "Allen",
    lastName: "Farias",
    address: "123 st lane",
    email: "allenfarias29@gmail.com",
    user: "allen",
    password: "apass"
}
let user2 = {
    firstName: "Joseph",
    lastName: "P",
    address: "4343  Rose Gold St",
    email: "jp434329@gmail.com",
    user: "joseph",
    password: "jpass"
};

userDatabase.push(user1);
userDatabase.push(user2);

const adminPin = 1234;


//******EVENT LISTENER******
function signIn() {
    for(let i = 0; i < userDatabase.length; i++) {
        if(userDatabase[i]["user"] == document.getElementById("luser").value &&
            userDatabase[i]["password"] == document.getElementById("lpass").value){
            console.log("User signed in!!!");
            alert("User signed in!!!");
            break;
        } else {
            if(i == userDatabase.length - 1){
                console.log("Invalid user sign in!!!");
                alert("Invalid user sign in!!!");
            }
        }
    }
    //get password


    //connect to sql database


    /*
     * logic: userId will be a sql query. If the userId is in the result set it will
     *stop the loop and check for that specific userId's password. If they both match
     *then it will take you to the register page
    */
}

function signUp() {
    if(validateEmail() && document.getElementById("pin").value == adminPin) {
        let sfName = document.getElementById("fName").value;
        let slName = document.getElementById("lName").value;
        let saddress = document.getElementById("address").value;
        let semail = document.getElementById("email").value;
        let suser = document.getElementById("user").value;
        let spassword = document.getElementById("password").value;

        let newUser = {
            firstName: sfName,
            lastName: slName,
            address: saddress,
            email: semail,
            user: suser,
            password: spassword
        }
        userDatabase.push(newUser);
        console.log("Added new employee...")
    }
}

//helper function for signUp function
function validateEmail() {
    let email = document.getElementById("email").value;
    const re = new RegExp(/^(([^<>()[\]\\.,;:\s@"]+(\.[^<>()[\]\\.,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/);

    if(re.test(email)){
        console.log("Valid email");
        document.getElementById("error-message").style.display = "none";
        return true;
    } else {
        console.log("Invalid email");
        document.getElementById("error-message").style.display = "inline";

        return false;

    }

}
