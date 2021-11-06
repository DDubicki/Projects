const BASE_URL = 'http://localhost:8080';

// function fetchData(base_url, route) {
//     window.history.pushState(null, null, base_url);
//     fetch(base_url + route)
//         .then(response => response.json())
//         .catch(error => {
//             console.log("")
//         });
// }

function saveNewStory() {
    let form = document.getElementById("saveNewStory");
    form.addEventListener("submit", function (){
        console.log("work");
    })
    // fetchData(BASE_URL,"/story");
}


(function() {

    saveNewStory();
})();