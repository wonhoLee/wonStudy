const myObj = {
    runTimeout(){
        // setTimeout(function(){
        //     console.log(this === window);
        // }, 200);

        setTimeout(function(){
            this.printData()
        }.bind(this), 200);
    },
    runTimeout2(){
        //console.log(this === window);
        setTimeout(() => this.printData(), 200);
    },
    printData(){
        console.log("hi code");
    }
}

//myObj.runTimeout();
myObj.runTimeout2();