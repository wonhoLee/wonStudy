//Object assign 메서드
const healthObj = {
    showHealth : function(){
        console.log("오늘 운동시간 : " + this.healthTime);
    }
}

// const myHealth = Object.create(healthObj);
// myHealth.healthTime = "11:29";
// myHealth.name = "crong";
// console.log(myHealth);
// myHealth.showHealth();

const myHealth = Object.assign(Object.create(healthObj), {
    name : "crong",
    healthTime : "11:20"
});

console.log(myHealth);
myHealth.showHealth();