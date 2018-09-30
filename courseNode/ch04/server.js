/**
 * http://usejsdoc.org/
 */
var http = require('http');
function onRequest(request, response){
	console.log("사용자가 request 합니다." + request.url);
	response.writeHead(200, {'Content-Type': 'text/plain'});
	response.write("test World");
	response.end();
}


http.createServer(onRequest).listen(8888);
console.log("server Start!!!!")