//Proxy
////////////////////////*case 01*/////////////////////////////
// const myObj = {name:'crone'};
// const proxy = new Proxy(myObj, {});

// console.log(proxy.name);
// proxy.name = "jisu";
// console.log(proxy.name);
// console.log(toString.call(proxy));
// console.log(proxy);
// console.log(myObj);
// console.log(proxy === myObj);
// console.log(proxy.name === myObj.name);

////////////////////////*case 02*/////////////////////////////
// const myObj = {name:'crone',changedValue:0};
// const proxy = new Proxy(myObj, {
//     get : function(target, property, receiver){
//         console.log('log : get value');
//         return target[property];
//     },
//     set : function(target, property, value){
//         console.log('log : set value');
//         target['changedValue']++;
//         target[property] = value;
//     }
// });

// console.log(proxy.changedValue);
// proxy.name = "testName";
// console.log(proxy.name);
// console.log(proxy.changedValue);

////////////////////////*case 03*/////////////////////////////
// const proxy = new Proxy({name:'crone',changedValue:0}, {
//     get : function(target, property, receiver){
//         return Reflect.get(target, property);
//     },
//     set : function(target, property, value){
//         console.log('log : set value');
//         target['changedValue']++;
//         target[property] = value;
//     }
// });

// console.log(proxy.changedValue);
// proxy.name = "testName";
// console.log(proxy.name);
// console.log(proxy.changedValue);

////////////////////////*case 04*/////////////////////////////
const proxy = new Proxy({name:'crone',changedValue:0}, {
    get : function(target, property, receiver){
        return (property in target) ? target[property] : "defaultValue";
    },
    set : function(target, property, value){
        console.log('log : set value');
        target['changedValue']++;
        target[property] = value;
    }
});

console.log(proxy.changedValue);
proxy.name = "testName";
console.log(proxy.name);
console.log(proxy.changedValue);
console.log(proxy.test1234);