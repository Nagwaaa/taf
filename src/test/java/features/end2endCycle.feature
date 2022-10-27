Feature: End 2 End Cycle
   i want to buy from website
   
 Scenario Outline: End 2 End Cycle
 Given the user in home page
 When i click on register link
 And i entered "<fname>","<lname>","<day>","<month>","<year>","<mail>","<com>","<pass>","<cpass>"
 And i search 
 And i can add to cart
 And i can checkout product
 Then user buy laptop
 
 
 Examples:
      | fname | lname | day | month | year | mail | com | pass | cpass |
      | Nagwa | Ibrahim | 10 | April | 2020 | noga0081@mail.com | wello | noga123 | noga123 |
      | Nada | Ibrahim | 10 | April | 2020 | nada0800@mail.com | wello | noga123 | noga123 |
      
      
     