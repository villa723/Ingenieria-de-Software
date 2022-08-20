var createError = require('http-errors');
const express = require('express');
var path = require('path');
var cookieParser = require('cookie-parser');
var logger = require('morgan');

var app = express();
// var env = require('node-env-file'); // .env file
// env(__dirname + '/.env');

var indexRouter = require('./interfaces/routes/index');
var usersRouter = require('./interfaces/routes/users');
var apiRouter = require('./interfaces/routes/api');

// view engine setup
app.set('views', path.join(__dirname, '/presentation/views'));
app.set('view engine', 'jade');

app.use(logger('dev'));
app.use(express.json());
app.use(express.urlencoded({ extended: false }));
app.use(cookieParser());
app.use(express.static(path.join(__dirname, '/presentation/public')));

app.use('/', indexRouter);
app.use('/users', usersRouter);
app.use('/api', apiRouter);



// catch 404 and forward to error handler
app.use(function (req, res, next) {
  next(createError(404));
});

// error handler
app.use(function (err, req, res, next) {
  // set locals, only providing error in development
  res.locals.message = err.message;
  res.locals.error = req.app.get('env') === 'development' ? err : {};

  // render the error page
  res.status(err.status || 500);
  res.render('error');
});

module.exports = app;
