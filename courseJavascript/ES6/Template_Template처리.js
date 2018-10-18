const data = [
    {
        name : 'coffee-bean',
        order : true,
        items : ['americano', 'milk', 'green-tea']
    },
    {
        name : 'starbucks',
        order : false,
        items : ['americano', 'milk', 'green-tea']
    }
]

//json으로 응답을 받고 javascript object로 변환한 후에 어떠한 데이터처리 조작을 한 후에 dom에 추가!
//데이터 + HTML문자열의 결합이 필요하기 때문
const template = `<div>welcome ${data[0].name} !!`;
console.log(template);

const a = 5;
const b = 10;
console.log(`Fifteen is ${ a + b }`);

categoryName="name";
categoryElements="element";
console.log(`categoryName: ${categoryName}\ncategoryElements: ${categoryElements} `)