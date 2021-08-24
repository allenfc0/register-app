# register-app
Casual register app that will compute basic math.

Whenever a new employee is hired they will be registered. If an employee logs in then they will
only redirect to the register page and they will not be able to go anywhere else other than the
log in/ sign up page whenever they log out. If an admin/manager logs in then they will have the
features of the employee as well as an employee list and a product list. I had a technical challenge
to get proper mapping so that Admins and Users get their proper pages to display, I solved this by
creating a whole another page for the user, a register page that only has the option to make the 
user sign out. Another challenged I faced was the Spring secutiry, I wanted there to be encryption 
for the password that would be stored in the database. I solved this issue by looking up a tutorial
and the past lectures that covered this topic. I also had trouble creating relationships between 
classes. I solved this by looking up the differences between the different types of relationships
and applying it to the classes.