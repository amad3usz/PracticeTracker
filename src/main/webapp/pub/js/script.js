function deleteSession(id) {
    var result = confirm("Want to delete this entry?");
    if (result) {
        window.location = "/user/deleteEntry?id=" + id;
    }
}
