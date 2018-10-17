let news = [
    {
        "title" : "sbs",
        "imgurl" : "https://imgnews.pstatic.net/image/001/2018/10/17/AKR20181017060600009_01_i_20181017104901444.jpg?type=w647",
        "newslist" : [
            "(서울=연합뉴스) 강건택 기자 = ",
            "도널드 트럼프 미국 대통령은 16일(현지시간) ",
            "김정은 북한 국무위원장과의 2차 북미정상회담은 ",
            "11월6일 중간선거 이후에 열릴 것이라고 말했다."
        ]
    },
    {
        "title" : "mbc",
        "imgurl" : "https://imgnews.pstatic.net/image/018/2018/10/17/0004226202_001_20181017100234795.jpg?type=w647",
        "newslist" : [
            "SK텔레콤이 코딩을 몰라도 ",
            "제작북을 통해 인공지능(AI) 서비스를 만들 수",
            "있는 AI 오픈 플랫폼 ‘누구 디벨로퍼스’를 공개한다."
        ]
    }
];

function getNewsList([{newslist}]){
    console.log(newslist);
}

getNewsList(news);