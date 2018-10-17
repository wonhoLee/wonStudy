//weakSet
//참조를 가지고 있는 객체만 저장이 가능하다.
//객체형태를 중복없이 저장하려고 할 때 유용하다.

let arr = [1,2,3,4];
let arr2 = [5,6,7,8];
let obj = {arr, arr2};
let ws = new WeakSet();

ws.add(arr);
ws.add(arr2);
ws.add(obj);
//ws.add(111);
//ws.add("111");
//ws.add(null);

arr = null;
arr2 = null;

console.log(ws);
console.log(ws.has(arr), ws.has(arr2));