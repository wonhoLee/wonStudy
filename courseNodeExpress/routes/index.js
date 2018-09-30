
/*
 * GET home page.
 */
var jd = require("../jdata.json");

exports.index = function(req, res){
  res.render('index', { title: 'courseNodeExpress', name: 'courseName',
	  jdata:jd});
};

