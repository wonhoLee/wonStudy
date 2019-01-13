var express = require('express');
var bodyParser = require('body-parser');

var cors = require('cors');

var app = express();
app.listen(3000, () => {
	console.log("start!! express server on port 3000");
});

app.use(cors());
app.use(express.static('public'));
app.use(bodyParser.json());
app.use(bodyParser.urlencoded({extended:true}));
app.set('view engine', 'ejs');

app.post('/ajax_send_search', (req,res) => {
	console.log(req.body.search);
	//check validation about input value => select db
	var responseData = {'result' : 'ok', 'data' : req.body.search};
	res.json(responseData);
});