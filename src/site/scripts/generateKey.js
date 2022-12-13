function generateKey() {
    let x = Math.floor ((Math.random() * 10000)+1);
    var s = document.getElementById('test'); //testing the key generator
    s.value = s.value.toString()+ x.toString();
}