//arrow function
// setTimeout(function() {
//     console.log("setTimeOut");
// }, 1000);

//setTimeout(() => console.log("setTimeOut"), 1000);

const newArr = [1,2,3,4,5].map(
    function(v){
        return v * 2;
    });

console.log(newArr);

const newArr2 = [1,2,3,4,5]
    .map((v) => v * 2);

console.log(newArr2);