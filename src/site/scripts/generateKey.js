function generateKey() {
    let x = Math.floor ((Math.random() * 10000)+1);
    var s = document.getElementById('key'); //testing the key generator
    s.value = s.value.toString()+ x.toString();
    document.getElementById('key').innerHTML = s.value;
    console.log(s.value);
}