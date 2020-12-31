<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
    <meta charset="ISO-8859-1" />
    <link href="assets/css/bootstrap.min.css" rel="stylesheet" />
    <link href="assets/css/bootstrap-theme.min.css" rel="stylesheet" />
    <script src="assets/js/jquery-2.2.0.min.js" type="text/javascript"></script>
    <script src="assets/js/bootstrap.min.js" type="text/javascript"></script>
</head>

<body>
    <!-- banner -->
    <section>
        <div class="container-fluid">
            <div class="row">
                <div class="col-sm-12 text-center">
                 <h5 style="color:red">
					<%
					    if(null!=request.getAttribute("invalidEmailIdErrorMessage"))
					        out.println(request.getAttribute("invalidEmailIdErrorMessage"));
					%>
				</h5>
                      
                    <h1>
                        <button type="button" class="btn btn-info">
                            <span data-target="#pwdModal" data-toggle="modal">Click here to reset your password!</span>
                        </button>
                    </h1>
                </div>
            </div>
        </div>
    </section>
    <!-- end of banner -->

    <!--modal-->
    <div id="pwdModal" class="modal fade" tabindex="-1" role="dialog" aria-hidden="true">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">
                        x
                    </button>
                    <h1 class="text-center">Forgot Password?</h1>
                </div>
                <div class="modal-body">
                    <div class="col-md-12">
                        <div class="panel panel-default">
                            <div class="panel-body">
                                <div class="text-center">
                                    <h4>
                                        Enter your registered e-mail id to reset password
                                    </h4>
                                    <div class="panel-body">
                                        <form action="ForgotPasswordController" method="post">
                                            <div class="form-group">
                                                <input class="form-control input-lg" placeholder="abc@gmail.com"
                                                    name="emailId" />
                                                                         </div>
                                            <input class="btn btn-lg btn-primary btn-block"
                                                value="Send reset password link" type="submit" />
                                        </form>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="modal-footer">
                    <div class="col-md-12">
                        <button class="btn btn-danger" data-dismiss="modal" aria-hidden="true">
                            Cancel
                        </button>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <!-- end of modal -->
</body>

</html>