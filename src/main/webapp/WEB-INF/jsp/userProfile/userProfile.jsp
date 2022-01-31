<jsp:include page="../include/header.jsp" />

<main>
    <div class="container">
        <div id="title" class="h1">JohnDoe24</div>
        <div
                id="content"
                class="py-5 me-md-3 px-3 px-md-5 text-white overflow-hidden"
        >
            <div class="row">
                <div class="col-sm text-center">
                    <p class="h1">John Doe</p>
                    <span class="fa-stack fa-5x">
                <i class="fa fa-circle fa-stack-2x"></i>
                <i class="fa fa-music fa-stack-1x text-black"></i>
              </span>
                </div>
            </div>
            <div class="row">
                <div class="col-sm h3">
                    I'm currently working on...<br />
                    <ul>
                        <li>Music</li>
                        <li>Writing</li>
                    </ul>
                </div>
                <div class="col-sm h3 text-center">
                    Add Me!<br />
                    <button
                            id="addFriend"
                            onclick="addFriend()"
                            class="btn btn-primary"
                            type="submit"
                            data-bs-toggle="modal"
                            data-bs-target="#FriendModal"
                    >
                        Add Friend
                    </button>
                </div>
            </div>
            <div class="row">
                <div class="col-sm h3 text-center">My 3 Most Recent Sessions</div>
            </div>
            <div class="row">
                <div class="col-sm">
                    <table class="table text-white">
                        <thead>
                        <tr>
                            <th class="h3" scope="col">Date</th>
                            <th class="h3" scope="col" colspan="3">Session Name</th>
                            <th class="h3" scope="col">Time Spent</th>
                        </tr>
                        </thead>
                        <tbody>
                        <tr style="background-color: #6a994e !important">
                            <td>1/3/22</td>
                            <td colspan="3">Bach Partita No. 3 - Bouree</td>
                            <td>96 minutes</td>
                        </tr>
                        <tr>
                            <td>1/2/22</td>
                            <td colspan="3">Mendelssohn Violin Concerto - 1st Mov.</td>
                            <td>134 minutes</td>
                        </tr>
                        <tr>
                            <td>1/1/22</td>
                            <td colspan="3">Paganini Caprice No. 24</td>
                            <td>47 minutes</td>
                        </tr>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
    </div>
</main>

<jsp:include page="../include/footer.jsp" />