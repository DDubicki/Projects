// // const BASE_URL = 'http://localhost:8080';
// //
// // function fetchData(url, options) {
// //     fetch(url, options)
// //         .then(response => response.json())
// //         .then(d => {
// //             console.log(d)
// //         })
// //         .catch(error => {
// //             console.log("Error occurred in submit form.")
// //         })
// // }
// //
// // function saveNewStory() {
// //     let form = document.getElementById("saveNewStory");
// //     form.addEventListener("submit", submitNewStory)
// // }
// //
// // function submitNewStory() {
// //     let input = getNewStoryUserInput();
// //     let options = getOptions(input);
// //     fetchData(BASE_URL + "/story", options);
// // }
// //
// // function getOptions(input) {
// //     return {
// //         method: 'POST',
// //         headers: {
// //             'Content-Type': 'application/json'
// //         },
// //         body: JSON.stringify(input)
// //     };
// // }
// //
// // function getNewStoryUserInput() {
// //     return {
// //         "title": document.getElementById("story_title").value,
// //         "description": document.getElementById("user_story").value,
// //         "acceptanceCriteria": document.getElementById("acceptance").value,
// //         "businessValue": document.getElementById("business_value").value,
// //         "estimation": document.getElementById("estimation").value,
// //     };
// // }
//
// (function () {
//     saveNewStory();
// })();
// alert("Alert");