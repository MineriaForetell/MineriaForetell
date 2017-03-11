<%-- 
    Document   : reset
    Created on : Mar 5, 2016, 9:56:53 PM
    Author     : raxton
--%>
<jsp:include page="header.jsp"></jsp:include>
    <div class="col-md-12 "> 
        <div class="col-md-4 ">

        </div>
        <div class="col-md-4 message-mail ">
            <form action="MailServ">
                <span class="reporttext whitefontcolor">Enter your Email-id: </span>

                <input type="text" name="mail" class="message-mail fullwidth register " required/>
                <center><input type="submit" value="Send" class="message-mail sub-btn"/> </center>
            </form>

       
    </div>
    <div class="col-md-4">

    </div>
</div>
<jsp:include page="stickyfooter.jsp"></jsp:include>

