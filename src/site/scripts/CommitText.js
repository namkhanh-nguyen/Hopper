function makeApage() {
    var data = document.getElementById("UploadText").innerHTML;
    localStorage.setItem("UploadText", data)
    var key = document.getElementById("key").innerHTML;
    localStorage.setItem("key", key)
}

function buildApage(){
    document.getElementById("UploadText").innerHTML = localStorage.getItem("data");
}

function grabAKey(){
    document.getElementById("key").innerHTML = localStorage.getItem("key");
}