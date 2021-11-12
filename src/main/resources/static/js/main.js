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

function fetchData(URL, options) {
    fetch(URL, options)
        // .then(response => {
        //     response.json()
        //         .then(data => doSomethingWithData(data))
        // })
        .then(window.location.href = BASE_URL)
        .catch(error => {
            console.log("Error occurred in submit form: " + error)
        })
}

function putCurrentStatusOption() {
    let currentOption = document.getElementById("status").attributes.data.value;
    document.getElementById(currentOption).setAttribute("selected", "selected")
}

function submitNewStory() {
    let URL = BASE_URL + "/story";
    let input = getUserInputToAddNewStory();
    let options = getOptions(input, 'POST');
    fetchData(URL, options);
}

function getUserInputToUpdateStory() {
    return {
        "title": document.getElementById("story_title").value,
        "description": document.getElementById("user_story").value,
        "acceptanceCriteria": document.getElementById("acceptance").value,
        "businessValue": document.getElementById("business_value").value,
        "estimation": document.getElementById("estimation").value,
        "status": document.getElementById("status").value,
    }
}

function updateStory() {
    let URL = window.location.href;
    let input = getUserInputToUpdateStory();
    let options = getOptions(input, 'PUT');
    fetchData(URL, options);
}
