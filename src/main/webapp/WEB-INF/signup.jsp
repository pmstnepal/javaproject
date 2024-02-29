<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Signup page</title>
    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
</head>
<body class="bg-light">
    <div class="container mt-5">
        <div class="row justify-content-center">
            <div class="col-md-6">
                <div class="card">
                    <div class="card-body">
                        <h1 class="text-center">SIGNUP</h1>
                        <form action="signup" method="post">
                            <h2 class="text-center">${message}</h2>
                            <div class="form-group">
                            <label>FIRST NAME</label>
                                <input type="text" name="first_name" class="form-control" required>
                            </div>
                            <div class="form-group">
                            <label>LAST NAME</label>
                                <input type="text" name="last_name" class="form-control" required>
                            </div>                            
                            <div class="form-group">
    						<label>Username:</label>
    							<input type="text" name="username" class="form-control" required>
							</div>

                            <div class="form-group">
                            <label>PASSWORD</label>
                                <input type="password" name="password" class="form-control" required>
                            </div>
                            <div class="form-group"><label>EMAIL</label>
                                <input type="text" name="email" class="form-control" required>
                            </div>
                            <div class="form-row">
                                <div class="form-group col-md-4" >
                                    <label>D.O.B :</label>
                                    <select name="DOB_month" class="form-control" required>
                                        <option>Jan</option>
                                        <option>Feb</option>
                                        <option>Mar</option>
                                        <option>Apr</option>
                                        <option>May</option>
                                        <option>Jun</option>
                                        <option>Jul</option>
                                        <option>Aug</option>
                                        <option>Sep</option>
                                        <option>Oct</option>
                                        <option>Nov</option>
                                        <option>Dec</option>
                                    </select>
                                </div>
                                <div class="form-group col-md-4">
    								<label>Day:</label>
								    <select name="DOB_day" class="form-control" required>
								        <% for (int i = 1; i <= 31; i++) { %>
								            <option><%= i %></option>
								        <% } %>
								    </select>
								</div>

                                <div class="form-group col-md-4">
                                    <label>Year:</label>
                                    <select name="DOB_year" class="form-control" required>
                                        <% for (int i = 2024; i >= 1920; i--) { %>
                                            <option><%= i %></option>
                                        <% } %>
                                    </select>
                                </div>
                            </div>
                            <div class="form-group">
                                <label>Gender:</label>
                                <select name="gender" class="form-control">                               
                                    <option>Male</option>
                                    <option>Female</option>
                                </select>
                            </div>
                            <div class="form-row">
                                <div class="col text-center">
                                    <button type="submit" class="btn btn-primary">SUBMIT</button>
                                    <button type="reset" class="btn btn-secondary">CANCEL</button>
                                    <a href="login" class="btn btn-success">LOGIN</a>
                                </div>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>

    <!-- Bootstrap JS and Popper.js -->
    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
</body>
</html>