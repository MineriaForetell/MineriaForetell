<%-- 
    Document   : ProjectList
    Created on : 9 Jan, 2016, 9:52:45 PM
    Author     : raxton
--%>
<%@page import="Model.ProjectDetails"%>
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
        <link rel="shortcut icon" href="../images/favicon.ico" type="image/x-icon">
        <link rel="stylesheet" href="css2/style2.css">


    </head>
    <script>
        function dispatch()
        {
            var table = document.getElementById('ProjTable')
            ,
                    var cells = table.getElementsByTagName('td');

            for (var i = 0, len = cells.length; i < len; i++) {
                cells[i].onclick = function () {
                    console.log(this.innerHTML);

                }
            }
        }
    </script>

    <body>

        <%
            HttpSession hs = request.getSession();
            UserInfo ui = (UserInfo) hs.getAttribute("fname");
            String role = hs.getAttribute("role").toString();
            String login_role = "";
            if (role.equals("G")) {
                login_role = "Geologist";
            } else if (role.equals("M")) {
                login_role = "Mining Engineer";
            } else if (role.equals("D")) {
                login_role = "Drill Rig Operator";
            }
        %>
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
                            <h4 class="pull-right whitefontcolor reporttext"><%=login_role%>:<a href="#" id="loginform"><span class="pull-right" style="padding-left:5px;"><%=ui.getUserFirstName()%></span></a></h4>
                          
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
        <!--template navigation start-->
        <div class="tp-navigations">
            <nav class="navbar navbar-default" role="navigation">
                <div class="container"> 
                    <!-- Brand and toggle get grouped for better mobile display -->

                    <div class="navbar-header">
                        <div class="tp-navigations">
                            <nav class="navbar navbar-default" role="navigation">
                                <div class="container"> 
                                    <!-- Brand and toggle get grouped for better mobile display -->                                    

                                    <!-- Collect the nav links, forms, and other content for toggling -->
                                    <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                                        <ul class="nav navbar-nav">
                                            <%
                                                if (role.equals("G")) {%>
                                            <li onclick="return(activeClassFunction(this))"><a href="addMiningEngineer.jsp">Add Engineer</a></li>
                                            <li onclick="return(activeClassFunction(this))"><a href="addProject.jsp">Add Project</a></li>
                                            <li onclick="return(activeClassFunction(this))"><a href="ProjectList?page=viewReport">View Report</a></li>
                                            <li onclick="return(activeClassFunction(this))"><a href="ProjectList?page=GraphicalFormat">Graphical Format</a></li>
                                                <%} else if (role.equals("M")) {%>
                                            <li onclick="return(activeClassFunction(this))" class="activeclassic"><a href="addDRO.jsp">Add DRO</a></li>
                                            <li onclick="return(activeClassFunction(this))"><a href="ProjectList?page=ViewProject">View Project</a></li>
                                            <li onclick="return(activeClassFunction(this))"><a href="ProjectList?page=assignWork.jsp">Assign Tasks</a></li>
                                            <li onclick="return(activeClassFunction(this))"><a href="ProjectList?page=analyzeFiles">Analyze Files</a></li>
                                                <%} else if (role.equals("D")) {%>
                                            <li onclick="return(activeClassFunction(this))" class="activeclassic"><a href="ProjectList?page=viewTask">View Tasks</a></li>
                                            <li onclick="return(activeClassFunction(this))"><a href="ProjectList?page=uploadFile.jsp">Upload File</a></li>
                                                <%}%>
                                        </ul>

                                    </div>
                                    <!-- /navbar-collapse --> 

                                </div>
                                <!-- /.container --> 
                            </nav>
                        </div>
                    </div>

                    <!-- Collect the nav links, forms, and other content for toggling -->

                    <!-- /navbar-collapse --> 

                </div>
                <!-- /.container --> 
            </nav>
        </div>
        <!--template navigation close--> 
        <!--tp Heading End--> 

       

        <div class="container container-fluid">
            <div class="row">
                <div class="col-md-12">
                    <div class="col-md-1">

                    </div>
                    <div class="col-md-10">
                        <table border="3" class="table-bordered table-responsive padding" id="ProjTable" style="width: 100%;text-align:center">
                            <thead>
                                <tr>
                                    <th style="text-align: center">Sr. No.</th> 
                                    <!--<th style="text-align: center">Mine ID</th>--> 
                                    <th style="text-align: center">Company Name</th>                                    
                                    <th style="text-align: center">Project Name</th>
                                    <th style="text-align: center">Mine Location</th>
                                    <th style="text-align: center">Project Link</th>
                                </tr>
                            </thead>

                            <tbody>
                                <%
                                    if (request.getSession().getAttribute("ProjectList") != null) {
                                        ArrayList<ProjectDetails> ProjectList = (ArrayList<ProjectDetails>) request.getSession().getAttribute("ProjectList");
                                        for (int i = 0; i < ProjectList.size(); i++) {
                                %>
                                <tr>                                
                                    <td><%=i + 1%></td>                                     
                                    <td><%=ProjectList.get(i).getCompanyName()%></td>                                    
                                    <td><%=ProjectList.get(i).getProjectName()%></td>
                                    <td><%=ProjectList.get(i).getMineLocation()%></td>
                                    <td><a href="<%=session.getAttribute("page")%>?mineId=<%=ProjectList.get(i).getMineId()%>"><input type="button" value="Go"></a></td>
                                </tr>


                                <%}
                                    }%>
                            </tbody>
                        </table>


                    </div>
                    <div class="col-md-1">

                    </div>
                </div>            
            </div>
        </div>

        <!------------------------------->

        <jsp:include page="commonstickyfooter.jsp"></jsp:include>