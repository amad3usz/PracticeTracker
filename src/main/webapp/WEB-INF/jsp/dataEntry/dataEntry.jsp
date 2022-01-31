<jsp:include page="../include/header.jsp" />
<main>
    <div class="container">
        <div id="title" class="h1">INPUT SESSION</div>
        <div
                id="content"
                class="py-5 me-md-3 px-3 px-md-5 text-white overflow-hidden"
        >
            <form>
                <div class="form-group row">
                    <div class="col-lg">
                        <label for="Date" class="form-label">Date of Session</label>
                        <input
                                type="date"
                                id="Date"
                                name="Date"
                                class="form-control"
                                required
                        />
                    </div>
                    <div class="col-lg">
                        <label
                        >Name of Session:
                            <input
                                    class="form-control form-control-lg dropdown"
                                    list="sessions"
                                    name="mySession"
                                    required
                            /></label>
                        <datalist id="sessions">
                            <option value="Writing Novel"></option>
                            <option value="Paganini Caprice No. 24"></option>
                            <option
                                    value="Mendelssohn Violin Concerto - 1st Mov."
                            ></option>
                            <option value="Bach Partita No. 3 - Bouree"></option>
                        </datalist>
                    </div>
                    <div class="col-lg">
                        <label
                        >Time Spent in Minutes:
                            <input
                                    class="form-control form-control-lg dropdown"
                                    list="minutes"
                                    name="myTime"
                                    required
                            /></label>
                        <datalist id="minutes">
                            <option value="15"></option>
                            <option value="30"></option>
                            <option value="45"></option>
                            <option value="60"></option>
                        </datalist>
                    </div>
                    <div class="col-lg">
                        <label for="rating">Session Rating: </label>
                        <select
                                class="form-control form-control-lg dropdown"
                                name="rating"
                                id="rating"
                                required
                        >
                            <option value="5">☆☆☆☆☆</option>
                            <option value="4">☆☆☆☆</option>
                            <option value="3">☆☆☆</option>
                            <option value="2">☆☆</option>
                            <option value="1">☆</option>
                        </select>
                    </div>
                </div>
                <br />
                <div class="form-group row">
                    <div class="col">
                        <label for="notes" class="form-label">Session Notes:</label>
                        <textarea
                                class="form-control form-control-lg"
                                id="notes"
                                rows="4"
                        ></textarea>
                    </div>
                </div>
                <br />
                <div class="row">
                    <div class="col-sm text-center">
                        <button class="btn btn-primary" type="submit">
                            Record Your Session
                        </button>
                    </div>
                </div>
            </form>
        </div>
    </div>
</main>

<jsp:include page="../include/footer.jsp" />