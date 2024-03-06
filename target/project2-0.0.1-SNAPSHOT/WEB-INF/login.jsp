<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <title>Login page</title>
    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
    <style>
        body {
            font-family: Verdana, sans-serif;
        }
    </style>
</head>
<body class="bg-light">
    <div class="container mt-5">
        <div class="row justify-content-center">
            <div class="col-md-4">
                <div class="card">
                    <div class="card-body">
                        <div class="text-center">
                            <h1 class="mb-4">LOGIN PAGE</h1>
                        </div>
                        <form action="login" method="post">
                            <h2 class="text-center">${message}</h2>
                            <div class="form-group">
                                <input type="text" name="username" value="USERNAME" class="form-control">
                            </div>
                            <div class="form-group">
                                <input type="password" name="password" value="PASSWORD" class="form-control">
                            </div>
                            
                                <div class="form-group">
                                    <label>Role :</label>
                                    <select name="role" class="form-control" required>
                                        <option>Admin</option>
                                        <option>User</option>                                                                          
                                    </select>
                                </div>
                            <div class="form-row">
                                <div class="col text-center">
                                    <button type="submit" class="btn btn-primary btn-block">LOGIN</button>
                                </div>
                                <div class="col text-center">
                                    <button type="reset" class="btn btn-secondary btn-block">CANCEL</button>
                                </div>
                            </div>
                            <div class="text-center mt-3">
                                <a href="signup" class="btn btn-link">SIGNUP</a>
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
