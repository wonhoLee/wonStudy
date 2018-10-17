function addMark(){
    // let newData = [];
    // for (let i = 0; i < arguments.length; i++) {
    //     newData.push(arguments[i] + "!");
    // }
    //let newArray = Array.from(arguments);
    // let newData = newArray.map(function(value){
    //     return value + "!";
    // } );
    //let newData = newArray.map(value => value + "!");
    let newData = Array.from(arguments)
                    .map(value => value + "!");

    console.log(newData);
}

addMark(1,2,3,4,5);