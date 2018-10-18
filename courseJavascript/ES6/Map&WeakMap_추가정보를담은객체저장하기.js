//map & WeakMap
//Array  -> Set, WeakSet
//Object -> Map, WeakMap

//Map은 Key / Value 구조
let wm = new WeakMap();
//let myfun = function(){};
let myfun = () => {};
//이 함수가 얼마나 실행됐지? 를 알려고 할때

wm.set(myfun, 0);

//console.log(wm.get(myfun));

for (let i = 0; i < 10; i++) {
    count = wm.get(myfun);
    count++;
    wm.set(myfun, count);
}

console.log(wm.get(myfun));

myfun = null;
console.log(wm.get(myfun));
console.log(wm.has(myfun));