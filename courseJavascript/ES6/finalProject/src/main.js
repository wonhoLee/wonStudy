class Blog{
    constructor(){
        //console.log("Blog is started!");
        this.setInitVariables();
        this.registerEvents();
        this.likedSet = new Set();
    }

    setInitVariables(){
        this.blogList = document.querySelector(".blogList > ul");
    }

    registerEvents(){
        const dataURL = "/data/data.json";
        const startBtn = document.querySelector(".start");
        
        startBtn.addEventListener("click", () => {
            this.setInitData(dataURL);
        });

        this.blogList.addEventListener("click", ({target}) => {
            const targetClassName = target.className;
            //console.log(targetClassName);
            //className이 like라면 내 찜 목록에 새로운 블로그제목을 추가한다.
            if(targetClassName !== "like" && targetClassName !== "unlike") return;

            //찜 취소를 클릭한 경우에 찜하기로 다시 변경하고 찜록록을 제거하고 찜목록뷰를 렌더링
            const postTitle = target.previousElementSibling.textContent;

            if(targetClassName === "unlike"){
                this.likedSet.delete(postTitle);
                target.className = "like";
                target.innerText = "찜하기";
            }else{
                //찜 목록에 추가
                this.likedSet.add(postTitle);

                //찜 된 목록(div)의 클래스를 like -> unlike로 변경하기
                target.className = "unlike";
                target.innerText = "찜취소";
            }

            //this.likedSet.forEach(v => console.log(v));
            //내 찜 목록 View에 추가
            this.updateLikedList();
        });
    }

    updateLikedList(){
        const ul = document.querySelector(".like-list > ul");
        let likedSum = "";

        //li태그에 찜리스트를 넣고 한번에 innerHTML을 사용한다.
        this.likedSet.forEach( v => {
            likedSum += `<li>${v}</li>`;
        });
        ul.innerHTML = likedSum;
    }

    setInitData(dataURL){
        this.getData(dataURL, this.insertPosts.bind(this));
        // do something..
    }

    getData(dataURL, fn){
        const oReq = new XMLHttpRequest();
        oReq.addEventListener("load", () => {
            const list = JSON.parse(oReq.responseText).body;
            //console.log("list is : ", list);
            //list.forEach(v => console.log(v.title));
            fn(list);
        });
        oReq.open('GET', dataURL);
        oReq.send();
    }

    insertPosts(list){
        list.forEach(v => {
            this.blogList.innerHTML += `
                <li>
                    <a href=${v.link}>${v.title}</a>
                    <div class="like">찜하기</div>
                </li>
            `;
        });
    }

}

export default Blog;