var express = require('express');
var router = express.Router();
var path = require('path')
var app = require('../app')

/* GET home page. */
router.get('/', function(req, res, next) {
  res.render('index', { title: 'Express' });
});

router.get('/login',function (req,res,next) {
    res.sendFile(process.cwd() +'/public/login.html');
});


router.get('/resign',function (req,res,next) {
    res.sendFile(process.cwd() +'/public/resign.html');
     });

module.exports = router;


