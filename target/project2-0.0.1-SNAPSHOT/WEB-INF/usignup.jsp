<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Update page</title>
    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
</head>
<body class="bg-light">
    <div class="container mt-5">
        <div class="row justify-content-center">
            <div class="col-md-6">
                <div class="card">
                    <div class="card-body">
                        <h1 class="text-center">UPDATE</h1>
                        <form action="usignup" method="post">
                            <h2 class="text-center">${message}</h2>
                            <div class="form-group">
                            
                            <label>FIRST NAME</label>
                                <input value="${calldata.first_name}" type="text" name="first_name" class="form-control">
                            </div>
                            <div class="form-group">
                            <label>LAST NAME</label>
                                <input value="${calldata.last_name}" type="text" name="last_name" class="form-control">
                            </div>                            
                            <div class="form-group">
    						<label>Username:</label>
    						<input value="${calldata.username}" type="hidden" name="username" class="form-control">
    							<input value="${calldata.username}" type="text" name="username" disabled="disabled" class="form-control">
							</div>

                            <div class="form-group">
                            <label>PASSWORD</label>
                                <input value="${calldata.password}" type="password" name="password" class="form-control">
                            </div>
                            <div class="form-group"><label>EMAIL</label>
                                <input value="${calldata.email}" type="text" name="email" class="form-control">
                            </div>
                            <div class="form-row">
                                <div class="form-group col-md-4" >
                                    <label>D.O.B :</label>
                                    <select name="DOB_month" class="form-control" required>
                                        <option ${addnewdata.DOB_month=='Jan'? 'selected':''}>Jan</option>
                                        <option ${addnewdata.DOB_month=='Feb'? 'selected':''}>Feb</option>
                                        <option ${addnewdata.DOB_month=='Mar'? 'selected':''}>Mar</option>
                                        <option ${addnewdata.DOB_month=='Apr'? 'selected':''}>Apr</option>
                                        <option ${addnewdata.DOB_month=='May'? 'selected':''}>May</option>
                                        <option ${addnewdata.DOB_month=='Jun'? 'selected':''}>Jun</option>
                                        <option ${addnewdata.DOB_month=='Jul'? 'selected':''}>Jul</option>
                                        <option ${addnewdata.DOB_month=='Aug'? 'selected':''}>Aug</option>
                                        <option ${addnewdata.DOB_month=='Sep'? 'selected':''}>Sep</option>
                                        <option ${addnewdata.DOB_month=='Oct'? 'selected':''}>Oct</option>
                                        <option ${addnewdata.DOB_month=='Nov'? 'selected':''}>Nov</option>
                                        <option ${addnewdata.DOB_month=='Dec'? 'selected':''}>Dec</option>
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
                                    <option ${calldata.gender=='Male'? 'selected':'N/A'}>Male</option>
                                    <option ${calldata.gender=='Female'? 'selected':'N/A'}>Female</option>
                                </select>
                            </div>
                            <div class="form-row">
                                <div class="col text-center">
                                    <button type="submit" class="btn btn-primary">UPDATE</button>
                                    <button id="back" class="btn btn-secondary">BACK</button>
                                    <a href="login" class="btn btn-success">LOGOUT</a>
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