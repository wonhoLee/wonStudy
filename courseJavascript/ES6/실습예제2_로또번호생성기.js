/*##. Destructuring and Set 활용
### lotto 번호 만들기
1. 유일한값을 추출하는 과정에서 Set 을 사용합니다.
2. getRandomNumber함수에 변수를 전달하는 과정에서 Destructuring 을 사용합니다.
*/

let mySet = new Set();

const SETTING = {
    name : "LUCKY LOTTO!",
    count : 6,
    maxNumber : 45
}

function getRandomNumber(maxNumber){
    //랜덤한 유일한 숫자값을 추출
    return Math.floor(Math.random()*maxNumber)+1;
}
const {name,count,maxNumber} = SETTING;

while(mySet.size != count){
    mySet.add(getRandomNumber(maxNumber));
}
console.log(mySet.values());