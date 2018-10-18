const data = [
    {
        name : 'coffee-bean',
        order : true,
        items : ['americano', 'milk', 'green-tea']
    },
    {
        name : 'starbucks',
        order : false,
    }
]
//Tagged template literals
// const template = `<div>welcome ${data[0].name} !!</div> 
//     <h2>주문가능항목</h2><div>${data[0].items}</div>`;
// console.log(template);

function fn(tags, name, items){
    if(typeof items === 'undefined'){
        items = "<span style='color:red'>주문가능한 상품이 없습니다</span>";
    }
    return (tags[0] + name + tags[1] + items + tags[2]);
}

// const template = fn`<div>welcome ${data[1].name} !!</div> 
//     <h2>주문가능항목</h2><div>${data[1].items}</div>`;
// console.log(template);

// const template2 = fn`<div>welcome ${data[0].name} !!</div> 
//     <h2>주문가능항목</h2><div>${data[0].items}</div>`;
// console.log(template2);

data.forEach((v) => {
    const template3 = fn`<h2>welcome ${v.name} !!</h2> 
    <h4>주문가능항목</h4><div>${v.items}</div>`;
    console.log(template3);
    document.querySelector("#message").innerHTML += template3;
});