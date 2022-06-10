$(function() {
    app.init();
});

var app = new App();
function App() {
    
    this.init = function() {
        $("#add").click(function(){
            location.href = "/form";
        });

    }

    this.update = function(id) {
        location.href = "update/" + id;
    }

    this.delete = function(id) {
        location.href = "delete/" + id;
    }
}