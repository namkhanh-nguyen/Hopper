function makeApage() {

    window.open("textDatapage.html");
}

function saveData(){
    var data = document.getElementById("UploadText").value;
    localStorage.setItem("data", data);
    console.log(localStorage.getItem("data"));
    var key = document.getElementById("key").value;
    localStorage.setItem("key", key);
    console.log(localStorage.getItem("key"));
}

function buildApage(){
    var text = localStorage.getItem("data");
    document.getElementById("textdisplaypage").value = text.value;
}

function grabAKey(){
    var key = localStorage.getItem("data");
    document.getElementById("Hopperkeyarea").innerHTML = key.value;
}