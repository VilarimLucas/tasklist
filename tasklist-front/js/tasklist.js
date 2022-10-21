function carregar(){
    const url='http://localhost:8080/tasks'
    $.getJSON(url, function(data){
        console.log(data);
    });
}