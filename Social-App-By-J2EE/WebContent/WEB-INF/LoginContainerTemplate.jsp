

<div class="container">
    <div class="row"> 
        <div class="col-md-3"></div>
        <div class="col-md-6">
                <form class="form-signin" action="login.do" method="post">
                    <h2 class="form-signin-heading setMargin">Please sign in</h2>
                    <!-- <label for="inputEmail" class="sr-only">Email address</label> -->
					<% 
						if (request.getParameter("email").equals("null")) {

					%>
							<input type="email" class="form-control setMargin" placeholder="Email address" name="email" required autofocus>
					<%
						} else {
					%>
				
                    			<input type="email" class="form-control setMargin" placeholder="Email address" name="email" value=${param.email} required autofocus>
                    	<%
                    		}
					%>
                    <!-- <label for="inputPassword" class="sr-only">Password</label> -->
                    <input type="password" class="form-control setMargin" placeholder="Password" name="password" required>
                    <div class="checkbox setMargin">
                        <label>
                            <input type="checkbox" value="remember-me"> Remember me
                        </label>
                    </div>

                    <div class="setMargin">
                        <button class="btn btn-outline-success my-2 my-sm-0" type="submit" name="button" value="Login">Login
                        </button>
                    </div>

                    <div class="setMargin">
                        <a href="register.do" class="btn btn-info" role="button" name="button" value="Register">Register</a>
                    </div>
                </form>
        </div>
        <div class="col-md-3"></div>
    </div>
</div>