//console.log("test");
function deleteTodo(element){
    fetch("/api/todo/delete",{
        method: "DELETE",
        headers:{
            'Content-Type': 'application/json'
        },
      body: JSON.stringify({id: element.id})
      });
      var row = document.getElementById('row_' + element.id);
      row.remove();
}
