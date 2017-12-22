<div class="container">
    <div class="row"> 
        <div class="col-md-3"></div>
        <div class="col-md-6">
            <form class="form-signin" action="register.do" method="post">
                <h2 class="form-signin-heading">Join us now!</h2>
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
				
				<% 
					if (request.getParameter("firstName").equals("null")) {

				%>
						<input name="firstName" id="FirstName" class="form-control setMargin" placeholder="FirstName" required autofocus>
				<%
					} else {
				%>
			
                   		<input name="firstName" id="FirstName" class="form-control setMargin" placeholder="FirstName" name="firstName" value=${param.firstName} required autofocus>
                 <%
                 	}
				%>
                
				<% 
					if (request.getParameter("lastName").equals("null")) {

				%>
						<input name="lastName" id="LastName" class="form-control setMargin" placeholder="LastName" required autofocus>
				<%
					} else {
				%>
			
                   		<input name="lastName" id="LastName" class="form-control setMargin" placeholder="LastName" name="firstName" value=${param.lastName} required autofocus>
                 <%
                 	}
				%>
				
                

                <input name="password1" type="password" id="inputPassword" class="form-control setMargin" placeholder="Password" required>

                <input name="password2" type="password" id="comfirmPassword" class="form-control setMargin" placeholder="Confirm Your Password" required>
                
                <div class="setMargin">
                    <button name="button" value="Register" class="btn btn-outline-success my-2 my-sm-0" type="submit">Register</button>
                </div>

            </form>

        </div>
        <div class="col-md-3"></div>
    </div>
</div>