// const name = "crong";
// const age = 33;

// const obj = {
//     name : name,
//     age : age
// }

// console.log(obj);

function getObj(){
    const name = "crong";
    // const getName = function(){
    //     return name;
    // }
    // const setName = function(newName){
    //     name = newName;
    // }
    // const printName = function(){
    //     console.log(name);
    // }
    const getName = () => name;
    const setName = v => name = v;
    const printName = () => console.log(name);

    // return {
    //     getName : getName,
    //     setName : setName
    // }
    return {getName, setName};
}

const obj = getObj();
console.log(obj.getName());