<%-- 
    Document   : TaskList
    Created on : 12 Jan, 2016, 12:52:45 PM
    Author     : raxton
--%>
<%@page import="Model.TaskDetails"%>
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
    <body>

        <%
            HttpSession hs = request.getSession();
            UserInfo ui = (UserInfo) hs.getAttribute("fname");            
            ArrayList<TaskDetails> TaskList = (ArrayList<TaskDetails>) request.getAttribute("TaskList");
            ArrayList<UserInfo> uiList = (ArrayList<UserInfo>) request.getAttribute("uiList");
            String page_forward =request.getAttribute("page").toString();
            System.out.println(page_forward);
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
                            <h4 class="pull-right whitefontcolor reporttext"><b>Drill Rig Operator:</b><a href="#" id="loginform"><span class="pull-right" style="padding-left:5px;"><%=ui.getUserFirstName()%></span></a></h4>
                         
                            <img class="profile-shape" height="30px" width="30px" src="images/rak.jpg">
                          
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
                                            <li class="activeclassic"><a href="viewTask?page=ViewTask">View Tasks</a></li>
                                            <li><a href="viewTask?page=uploadFile.jsp">Upload File</a></li>                                                
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
                                    <th style="text-align: center">Project Name</th>
                                    <th style="text-align: center">Mining Engineer</th>
                                    <th style="text-align: center">Due date</th>
                                    <th style="text-align: center">Task Link</th>
                                </tr>
                            </thead>

                            <tbody>
                                <%
                                    if (request.getAttribute("TaskList") != null) {                                        
                                        for (int i = 0; i < TaskList.size(); i++) {                                                                                        
                                %>
                                <tr>                                
                                    <td><%=i + 1%></td>                                                                                                            
                                    <td><%=TaskList.get(i).getMineId().getProjectName()%></td>
                                    <td><%=uiList.get(i).getUserFirstName() %></td>
                                    <td><%=TaskList.get(i).getDueDate() %></td>
                                    <td><a href="<%=page_forward%>?task_id=<%=TaskList.get(i).getTaskId()%>"><input type="button" value="Go"></a></td>
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

        

        <jsp:include page="commonstickyfooter.jsp"></jsp:include>