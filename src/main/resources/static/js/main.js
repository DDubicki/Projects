const BASE_URL = 'http://localhost:8080';

function getUserInputToAddNewStory() {
    return {
        "title": document.getElementById("story_title").value,
        "description": document.getElementById("user_story").value,
        "acceptanceCriteria": document.getElementById("acceptance").value,
        "businessValue": document.getElementById("business_value").value,
        "estimation": document.getElementById("estimation").value,
    };
}

function getOptions(input, method) {
    return {
        method: method,
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(input)
    };
}

function doSomethingWithData(data) {
    alert(data);
}

function fetchData(options) {
    fetch(BASE_URL + "/story", options)
        .then(response => {
            response.json()
                .then(data => doSomethingWithData(data))
        })
        .then(window.location.replace(BASE_URL))
        .catch(error => {
            console.log("Error occurred in submit form: " + error)
        })
}

function submitNewStory() {
    let input = getUserInputToAddNewStory();
    let options = getOptions(input, 'POST');
    fetchData(options);
}