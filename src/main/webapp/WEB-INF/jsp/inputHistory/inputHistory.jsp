<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:include page="../include/header.jsp" />

<main>
    <div class="container">
        <div id="title" class="h1">My Entries</div>
        <div
                id="content"
                class="py-5 me-md-3 px-3 px-md-5 text-white overflow-hidden"
        >
            <div class="row">
                <div class="col-sm">
                    <table class="table text-white">
                        <thead>
                        <tr>
                            <th class="h3 twenty" scope="col">Date</th>
                            <th class="h3 sixty" scope="col" colspan="3">
                                Session Name
                            </th>
                            <th class="h3 twenty" scope="col">Time Spent</th>
                        </tr>
                        </thead>
                        <tbody>
                        <tr>
                            <td>1/3/22</td>
                            <td colspan="3">Bach Partita No. 3 - Bouree</td>
                            <td>96 minutes</td>
                        </tr>
                        <tr>
                            <td colspan="5">
                                Notes: Bacon ipsum dolor amet turkey salami kevin chuck
                                brisket jowl capicola flank. Boudin rump porchetta shank
                                pork chop bacon. Prosciutto capicola meatball beef ribs
                                strip steak spare ribs tenderloin swine fatback beef
                                andouille rump shank turducken. Spare ribs short loin
                                pancetta leberkas. Swine turkey short ribs biltong, tail
                                spare ribs ham hock chuck flank turducken leberkas
                                pastrami. Corned beef filet mignon turkey, t-bone cow
                                sirloin flank swine brisket biltong ham hock pork loin
                                drumstick rump
                            </td>
                        </tr>
                        <tr>
                            <td colspan="4">Rating: ☆☆☆☆☆</td>
                            <td><button class="btn btn-danger">Delete</button></td>
                        </tr>
                        <tr>
                            <td>1/2/22</td>
                            <td colspan="3">Mendelssohn Violin Concerto - 1st Mov.</td>
                            <td>134 minutes</td>
                        </tr>
                        <tr>
                            <td colspan="5">
                                Notes: Drumstick pork loin ball tip kevin prosciutto
                                sausage ham boudin picanha doner salami frankfurter. Ham
                                cupim chicken shankle. Ground round prosciutto drumstick
                                flank tenderloin brisket capicola shankle salami.
                                Frankfurter beef ribs pork belly tail pork loin salami
                                flank boudin ribeye. Ribeye fatback spare ribs, cupim cow
                                buffalo swine picanha brisket flank. Pork belly short loin
                                boudin frankfurter fatback shoulder filet mignon buffalo.
                            </td>
                        </tr>
                        <tr>
                            <td colspan="4">Rating: ☆☆☆</td>
                            <td><button class="btn btn-danger">Delete</button></td>
                        </tr>
                        <tr>
                            <td>1/1/22</td>
                            <td colspan="3">Paganini Caprice No. 24</td>
                            <td>47 minutes</td>
                        </tr>
                        <tr>
                            <td colspan="5">
                                Notes: Capicola cow doner andouille. Ham hock beef cow
                                biltong cupim. Landjaeger meatloaf andouille venison,
                                cupim rump sirloin short ribs prosciutto porchetta
                                tenderloin ham hock. Turducken picanha sirloin pork cupim.
                                Cupim bresaola cow capicola, pancetta tail short loin ham
                                hock sirloin boudin salami tri-tip. Leberkas sausage
                                venison, tenderloin sirloin tail chuck kielbasa filet
                                mignon bresaola pork chop t-bone. Sausage ham hock short
                                ribs porchetta landjaeger, cupim leberkas.
                            </td>
                        </tr>
                        <tr>
                            <td colspan="4">Rating: ☆☆☆☆</td>
                            <td><button class="btn btn-danger">Delete</button></td>
                        </tr>
                        <tr>
                            <td>12/31/21</td>
                            <td colspan="3">Writing Novel</td>
                            <td>342 minutes</td>
                        </tr>
                        <tr>
                            <td colspan="5">
                                Notes: Short ribs boudin beef ribs, spare ribs hamburger
                                pork doner turducken capicola pork belly bacon fatback.
                                Shank meatball ham, hamburger spare ribs flank frankfurter
                                filet mignon beef ribs short loin tenderloin tri-tip swine
                                turducken. Sausage rump bacon picanha meatball. Shankle
                                andouille chislic turducken filet mignon bacon picanha
                                swine. Chuck sirloin cow boudin turducken corned beef.
                                Pancetta tongue short ribs cupim pork loin bacon strip
                                steak beef landjaeger meatloaf.
                            </td>
                        </tr>
                        <tr>
                            <td colspan="4">Rating: ☆☆☆☆☆</td>
                            <td><button class="btn btn-danger">Delete</button></td>
                        </tr>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
    </div>
</main>

<jsp:include page="../include/footer.jsp" />