<%-- 
    Document   : addGeologist
    Created on : 9 Jan, 2016, 8:52:59 PM
    Author     : raxton
--%>
<jsp:include page="header.jsp" ></jsp:include>
    <div class="container">
        <div class="row">

            <div class="col-md-12 fontbigger" >            
                <div class="col-md-2 fontbigger"  >
                </div>
                <div class="col-md-8 fontbigger message-mail addUserForm "  >
                    <form action="addGeologist" id="registration" method="post"  onsubmit="return(formValidation());" name="frm">
                        <div class="col-md-6 fontbigger message-mail">
                        <jsp:include page="/addUserForm.html"></jsp:include>
                        </div>
                        <div class="col-md-6 fontbigger message-mail ">
                            <img src="images/Geo-can-add-ME.png" alt="Geologist can add Mining engineer!" height="264px" width="200px"/>
                        </div>
                        <legend></legend>
                        <input type="submit" name="submit-message" name="submit" value="submit" style="color: white;" class="message-mail2 sub-btn"/>
                    </form>
                </div>
                <div class="col-md-2 fontbigger" >
                </div>
            </div>

        </div>
    </div>

  

<jsp:include page="footer.jsp"></jsp:include>