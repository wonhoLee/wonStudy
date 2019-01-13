const express = require('express');
const bodyParser = require('body-parser');
const cors = require('cors');
const mysql = require('mysql');
const connection = mysql.createConnection({
	host : '192.168.0.11',
	user : 'myuser',
	password : 'test1234',
	database : 'mydatabase'
});

connection.connect();

const app = express();
app.listen(3000, () => {
	console.log("start!! express server on port 3000");
});

app.use(cors());
app.use(express.static('public'));
app.use(bodyParser.json());
app.use(bodyParser.urlencoded({extended:true}));
app.set('view engine', 'ejs');

app.get('/', (req, res) => {
//	res.send("<h1>Hi friend!</>");
	res.sendFile(__dirname + "/public/main.html");
});

app.get('/main', (req,res) => {
	res.sendFile(__dirname + "/public/main.html");
});

app.post('/email_post', (req,res) => {
	console.log(req.body.email);
//	res.send("<h1>welcome! " + req.body.email + "</h1>");
	res.render('email.ejs', {'email' : req.body.email});
});

app.post('/ajax_send_email', (req,res) => {
	console.log(req.body.email);
	//check validation about input value => select db
	let responseData = {'result' : 'ok', 'email' : req.body.email};
	res.json(responseData);
});