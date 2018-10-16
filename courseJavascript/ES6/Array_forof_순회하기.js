var data = [1,2,undefined,NaN,null,""];
Array.prototype.getIndex = function(){};

/*for(let i = 0 ; i < data.length ; i++){
    console.log(data[i]);
}*/

/*data.forEach(function(value){
    console.log(value)
});
*/
/*
data.forEach(e => {
    console.log(e);
});
*/

/*  
문제 : 자기자신이 가지고 있지않은 상위 인덱스정보도 가져옴
    배열에서 쓰지 말것
Array.prototype.getIndex = function(){};
for (let key in data) {
    console.log(data[key]);
}
*/

Array.prototype.getIndex = function(){};
for(let value of data){
    console.log(value);
}

var str = "hello world!!!";
for(let value of str){
    console.log(value);
}
