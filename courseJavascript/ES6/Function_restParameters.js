//rest parameters
// function checkNumAsis(){
//     const argArray = Array.prototype.slice.call(arguments);
//     console.log(argArray);
//     const result = argArray.every((v) => typeof v === "number")
//     console.log(result);
// }

function checkNum(...argArray){
    console.log(toString.call(argArray));
    console.log(argArray);
    const result = argArray.every((v) => typeof v === "number")
    console.log(result);
}

const result = checkNum(10,2,"55");
const result2 = checkNum(10,2,3,4,5,"55");