Feature: User Registeraion
   i want to check the user to register to website
   
 Scenario Outline: User Registeration
 Given the user in home page
 When i click on register link
 And i entered "<fname>","<lname>","<day>","<month>","<year>","<mail>","<com>","<pass>","<cpass>"
 Then user registeration page is display
 
 
 Examples:
      | fname | lname | day | month | year | mail | com | pass | cpass |
      | Nagwa | Ibrahim | 10 | April | 2020 | nog10@mail.com | wello | noga123 | noga123 |
      | Nada | Ibrahim | 10 | April | 2020 | nad10@mail.com | wello | noga123 | noga123 |
