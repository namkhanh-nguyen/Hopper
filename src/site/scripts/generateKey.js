function generateKey() {
    let x = Math.floor ((Math.random() * 10000)+1);
    let y = x.valueOf();
    if (y < 10 ) {
        y = "000"+x.toString();}
    if (y < 100 &&x >= 10) {
        y = "00"+x.toString();}
    if (y < 1000 &&x >= 100) {
        y = "0"+x.toString();}
    const s = document.getElementById('test'); //testing the key generator
    s.value = s.value.toString()+ y;
}