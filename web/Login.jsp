<%-- 
    Document   : Login
    Created on : 27 Jan, 2016, 11:50:39 PM
    Author     : raxton
--%>
<jsp:include page="header.jsp"></jsp:include>

    <div class="col-md-12 "> 
        
        <div class="col-md-4 ">

        </div>
        
        <div class="col-md-4 message-mail ">
            <form method="post" action="LoginServ" class="addUserForm ">
                <span class="reporttext"  style="margin: 10px;font-size: 14px;color:red"><b>Invalid credential ! Try again...</b></span>
                <fieldset>
                    <legend>
                        <input type="email" placeholder="abc@example.com" name="username" class="message-mail fullwidth register "/><br>

                        <input type="password" placeholder="********" class="register message-mail fullwidth " name="password"/><br>
                    </legend>
                    <div class="col-md-6 message-mail "><input type="submit" value="Login" class="message-mail sub-btn" style="width:48%" /></div>
                    
                    <div class="col-md-6 message-mail"><a href="reset.jsp"><span class="pull-left reporttext"  style="margin: 0;padding-top: 13px;font-size: 16px;color:#fac11b">Forgot Password?</span></a></div>
                    
                </fieldset>
            </form>

        </div>
        <div class="col-md-4">

        </div>
    </div>
<jsp:include page="footer.jsp"></jsp:include>



