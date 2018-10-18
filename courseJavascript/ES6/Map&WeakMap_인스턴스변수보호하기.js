//WeakMap 활용
const wm = new WeakMap();

// function Area(height, width){
//     this.height = height;
//     this.width = width;
// }

function Area(height, width){
    wm.set(this, {height, width});
}


// Area.prototype.getArea = function(){
//     return this.height * this.width;
// }

Area.prototype.getArea = function(){
    const {height, width} = wm.get(this);
    return height * width;
}

let myarea = new Area(10, 20);
console.log(myarea.getArea());
//console.log(myarea.height);

console.log(wm.has(myarea));
myarea = null;
console.log(wm.has(myarea));

////////////////////////////////////////////
const obj = {};

function Area2(height, width){
    obj.height = height;
    obj.width = width;
}

Area2.prototype.getArea = function(){
    return obj.height * obj.width;
}

let myarea2 = new Area2(10, 20);
console.log(myarea2.getArea());