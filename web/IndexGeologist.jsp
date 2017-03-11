<%@page import="java.util.ArrayList"%>
<%@page import="Model.UserInfo"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8">
        <meta name="description" content="Industrial web templates for the mining company and service templates. Industrial web templates are designed with high standards and bootstrap framework.">
        <meta name="keywords" content="Industiral Templates, Service Templates, Bootstrap, Responsive">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>Mineria Foretell</title>

        <!-- Bootstrap -->

        <link href="css/bootstrap.min.css" rel="stylesheet">
        <!--Custom template style.css-->
        <link href="css/style.css" rel="stylesheet">
        <!--Custom template style.css-->
        <link href="css/camera.css" rel="stylesheet">
        <link href="css/font-awesome.min.css" rel="stylesheet">
        <link rel="shortcut icon" href="images/favicon.ico" type="image/x-icon">
        <link rel="stylesheet" href="css2/style2.css">


    </head>

    <body>
        <!--header start-->
        <div class="header-row" id="header-row">
            <div class="container">
                <div class="row"> 
                    <!--logo start-->
                    <div class="col-md-2"> 
                        <a class="navbar-brand logo" href="index.jsp"><img src="images/logo.png" alt="company logo"></a> </div>
                    <!--logo start close-->
                    <div class="col-md-8 contact-info">
                        <span class="call-number"></span>

                        <div id="navthing" >

                            <%
                                HttpSession hs = request.getSession();
                                UserInfo ui = (UserInfo) hs.getAttribute("fname");
                            %>
                            <h4 class="pull-right whitefontcolor">Geologist:<a href="#" id="loginform">
                                    <span class="pull-right" style="padding-left:5px;"><%=ui.getUserFirstName()%></span></a></h4>

                         
                            <img class="profile-shape" height="30px" width="30px" src="images/Rax.jpg">
                         
                        </div>
                    </div>
                  
                    <div class="col-md-2">
                        <ul class="social-icon">

                           
                            <li class="dropdown"> 
                                <a href="#" class="paddingsetter-left dropdown-toggle fa fa-cogs" data-toggle="dropdown">
                                    <span class="caret"></span></a>
                                <ul class="dropdown-menu" role="menu">
                                    <li><a href="profileEditor/index.html">Edit Profile</a></li>
                                   
                                    <li><a href="Logout.jsp">Logout</a></li>
                                </ul>
                            </li>
                          
                        </ul>
                    </div>


                </div>
               
            </div>
        </div>

        <!--header Close--> 

        <!--tp Heading End--> 


        <div id="footer" class="footer-section">
            <div class="container">
                <div class="row">
                    <div class="tp-ft-section-second  ">
                        <div class="col-md-12 " style="text-align:center;height:250px" >            
                            <div class="col-md-2 " style="text-align: center" >

                            </div>
                            <%--<jsp:forward page="addMiningEngineer.jsp" />--%>
                            
                            <a href="captcha.jsp" >
                                <div class="col-md-4 font-fade" style="text-align: center" >
                                    <div class="menudivs">
                                        <span>Add Mining Engineer</span>
                                    </div>
                                </div>
                            </a> 
                            <a href="addProject.jsp" >
                                <div class="col-md-4 font-fade" style="text-align: center" id="servicesection">
                                    <div class="menudivs">
                                        <span>Add Project</span>
                                    </div>
                                </div>
                            </a>
                            <div class="col-md-2 font-fade" style="text-align: center" >

                            </div>
                        </div>
                    </div>
                    <div class="col-md-12 fontbigger" style="text-align: center;height: 250px" >            
                        <div class="col-md-2 " style="text-align: center" >

                        </div>
                        <a href="ProjectList?page=viewReport" >
                            <div class="col-md-4 font-fade" id="viewReport" onclick="setPage()" style="text-align: center" >
                                <div class="menudivs">
                                    <span>View Report</span>                            
                                </div>
                            </div>
                        </a>
                        <a href="ProjectList?page=GraphicalFormat" >
                            <div class="col-md-4 font-fade" id="GraphicalFormat" onclick="setPage()" style="text-align: center" id="servicesection">
                                <div class="menudivs">
                                    <span>Graphical Format</span>
                                </div>
                            </div>
                        </a>
                        <div class="col-md-2 fontbigger" style="text-align: center" >

                        </div>
                    </div>
                </div>
            </div>
        </div>
      
        <jsp:include page="footerGeologist.jsp"></jsp:include>