<%@taglib uri='/WEB-INF/mytags/mytags.tld' prefix='my' %>
    <jsp:useBean id="messageBean" scope="request" class="com.thinking.machines.hr.beans.MessageBean" />
    <jsp:include page="/MasterPageTopSection.jsp" />
    <center>
        <h2>${messageBean.heading}</h2>
        ${messageBean.message}
        <my:If condition='${messageBean.generateButton}'>
            <table>
                <tr>
                    <td>
                        <form action="/styletwo/${messageBean.buttonOneAction}">
                            <button style="margin:10px;" class="btn btn-outline-success" type="submit">${messageBean.buttonOneText}</button>
                        </form>
                    </td>

                    <my:If condition='${messageBean.generateTwoButton}'>

                        <td>
                            <form action="/styletwo/${messageBean.buttonTwoAction}">
                                <button style="margin:10px;" class="btn btn-outline-danger"
                                    type="submit">${messageBean.buttonTwoText}</button>
                            </form>
                        </td>

                    </my:If>
                </tr>
            </table>
    </center>

    </my:If>
    <jsp:include page="/MasterPageBottomSection.jsp" />