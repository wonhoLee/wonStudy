/**
 * http://usejsdoc.org/
 */
console.log("hello world! Node");

var dog = {
	name:"amy", age:7	
};

console.log(dog);

function sum(a,b){
	return a+b;
}

console.log(sum(1,2));

var print = function(){
	console.log("function print");
}

print();

setTimeout(() => {
	print();
}, 5000);