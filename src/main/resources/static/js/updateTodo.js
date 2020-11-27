//console.log("test");
function updateTodo(element){
    fetch("/api/todo/update",{
        method: "PUT",
        headers:{
            'Content-Type': 'application/json'
        },
      body: JSON.stringify({id: element.id})
      });
      var row = document.getElementById('row_' + element.id);
      row.remove();
}


