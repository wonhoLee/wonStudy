var express = require('express');
var app = express();
app.listen(3000, () => {
	console.log("start!! express server on port 3000");
});

app.get('/', (req, res) => {
//	res.send("<h1>Hi friend!</>");
	res.sendFile(__dirname + "/public/main.html");
});