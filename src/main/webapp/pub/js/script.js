function addFriend() {
    let stateOfFriend = ["ADDED", "REMOVED"];
    const add = "This person has been added to your list.";
    const remove = "This person has been removed from your list.";

    if (document.getElementById("addFriend").innerText === "Add Friend") {
        document.getElementById("addFriend").innerText = "Remove Friend";
        document.getElementById("friendAddRemove").innerHTML = add;
        document.getElementById("friendModalLabel").innerHTML = stateOfFriend[0];
    } else if (
        document.getElementById("addFriend").innerText === "Remove Friend"
    ) {
        document.getElementById("addFriend").innerText = "Add Friend";
        document.getElementById("friendAddRemove").innerHTML = remove;
        document.getElementById("friendModalLabel").innerHTML = stateOfFriend[1];
    }
}



    function selects() {
    let ele = document.getElementsByClassName("practice");
    for (let i = 0; i < ele.length; i++) {
    if (ele[i].type == "checkbox") ele[i].checked = true;
}
}
    function deSelect() {
    let ele = document.getElementsByClassName("practice");
    for (let i = 0; i < ele.length; i++) {
    if (ele[i].type == "checkbox") ele[i].checked = false;
}
}


// var skillsPracticing = []
// var checkboxes = document.querySelectorAll('input[type=checkbox]:checked')
//
// for (var i = 0; i < checkboxes.length; i++) {
//     skillsPracticing.push(checkboxes[i].value)
// }
// var form = document.getElementById("registerForm"),
//     inputs = form.getElementsByClassName("practice"),
//     activitiesArr = [];
//
// for (var i = 0, max = inputs.length; i < max; i += 1) {
//     // Take only those inputs which are checkbox
//     if (inputs[i].type === "checkbox" && inputs[i].checked) {
//         activitiesArr.push(inputs[i].value);
//
//     }
// }
//
// console.log(activitiesArr);
