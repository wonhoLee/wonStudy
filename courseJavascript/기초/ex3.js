/*
댓글 선택자를 설정해주셔야 합니다. 
페이스북 페이지 댓글 : ._3b-9>div>.UFIComment .UFICommentActorName
페이스북 페이지 리액션 (좋아요 등) : #reaction_profile_browser>li>div ._5j0e.fsl.fwb.fcb>a
페이스북 공유 : '#repost_view_dialog .n_1gapi2flae .profileLink';
*/

var 댓글선택자 = '._3b-9>div>.UFIComment .UFICommentActorName';
function shuffle(a) {
    for (let i = a.length; i; i--) {
        let j = Math.floor(Math.random() * i);
        [a[i - 1], a[j]] = [a[j], a[i - 1]];
    }
}
var list = [];
document.querySelectorAll(댓글선택자).forEach(function(e){
	list.push({name:e.firstChild, url:e.href, tag:e});
});
list = list.filter((v,i,a) => a.indexOf(v)===i);
shuffle(list)
for(var i=0; i<list.length; i++){
   console.log(i+1, list[i].name, list[i].url);
}

//*[@id="js_pd"]
//*[@id="js_5q"]