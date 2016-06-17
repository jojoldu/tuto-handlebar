/**
 * Created by jojoldu@gmail.com on 2016-06-17.
 */
var template = Handlebars.templates.basic;
var data = {
    'title' : 'Javascript',
    'body' : 'Handlebar'
};

Handlebars.registerHelper('email', function(id){
    return id+'@gmail.com'
});

//위 Handlebars.compile을 통해 생성된 template를 통해 html 템플릿 진행
var html = template(data);
var $body = $('body');
$body.append(html);

var template2 = Handlebars.templates.basic2;
var data2 = {
    'title' : 'Springboot',
    'body' : 'Jpa'
};

var html2 = template2(data2);
$body.append(html2);