<nav class="navbar navbar-expand-lg navbar-light bg-light">
  <a class="navbar-brand" href="#">Welcome, ${users.firstName}</a>
  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarText" aria-controls="navbarText" aria-expanded="false" aria-label="Toggle navigation">
    <span class="navbar-toggler-icon"></span>
  </button>
  <div class="collapse navbar-collapse" id="navbarText">
    <ul class="navbar-nav mr-auto">
      <li class="nav-item active">
        <a class="nav-link" href="UserHome.jsp">Home <span class="sr-only">(current)</span></a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="AddMember.jsp">Add Member</a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="ListMembersController">List Members</a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="AddHouseDetails.jsp">Add HouseDetails</a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="ListHouseDetailsController">List HouseDetails</a>
      </li>
       <li class="nav-item">
        <a class="nav-link" href="AddInstruction.jsp">Add Instruction</a>
      </li>
       <li class="nav-item">
        <a class="nav-link" href="ListInstructionForUser">List Instruction</a>
      </li>
    </ul>
       <a class="btn btn-outline-danger my-2 my-sm-0" href="LogoutController">Logout</a>
   
  </div>
  
</nav>