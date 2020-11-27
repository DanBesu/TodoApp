function changeDoneField(element) {
    fetch("/api/todo/check", {
        method: "PUT",
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify({id: element.id})
    }).then(res => {
        return res.json();
    }).then(res => {
        var dynamicCss = "";
        if (res.done) {
            dynamicCss = "linethrough";
        }
        document.getElementById('span_' + res.id).className = dynamicCss;

    })
}

