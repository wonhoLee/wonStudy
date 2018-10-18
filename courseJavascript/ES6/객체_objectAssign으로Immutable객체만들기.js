//Object assign Immutable 메서드

const previousObj = {
    name : "crong",
    lastTime : "11:20"
};

const myHealth = Object.assign({}, previousObj, {
    "lastTime" : "12:30",
    "name" : "honux",
    "age" : 99
});

console.log(myHealth);