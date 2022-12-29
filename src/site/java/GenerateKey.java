public class GenerateKey {

abstract string KeyCreate(string s){
    int offset = Math.floor ((Math.random() * 10000)+1);
    string x = s;
    string key = s + x.toString();
    return key;
}
}