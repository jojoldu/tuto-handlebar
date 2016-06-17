 module.exports = function(grunt) {
 
    // Project configuration.
    grunt.initConfig({
        pkg: grunt.file.readJSON('package.json'),

        'handlebars': {
            options: {
                namespace: "Handlebars.templates",
                processName:function(filePath) {
                    var pattern=/handlebar\/(.+\/)*(.+)\.handlebars/gi;
                    return pattern.exec(filePath)[2];
                }
            },
            compile : {
                files: {
                    //destination : [target list]
                    "templates.js" : ["handlebar/*.handlebars"]
                }
            }
        }
    });
 
    grunt.loadNpmTasks('grunt-contrib-handlebars');
 
    // Default task(s).
    grunt.registerTask('default', ['handlebars']); //grunt 명령어로 실행할 작업
 
};