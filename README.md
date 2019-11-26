"# selenium-test" 
# 2019-ITCS473-SodaAndTheBoys
### Automated Web Testing using Selenium

The website which we tested is https://thaiortho.org/ thats about The Thai Association of Orthodontists.

There are 12 test cases that tested this website as list below:
                
1. Get page title text to find whether access correct webpage 
2. Go to FindDentist page from Homepage's nav bar
3. Search by inputting name into search box
4. Search by inputting Country into search box then appears the error alert
5. Access Facebook Page 
6. Access Youtube Page
7. Access Search Blog Page
8. Access the Category page
9. Payment Page Test
10. Login Page Test
11. Share facebook Test
12. Download Article Test


**Test Case #1** : Page Title Text Test  
Description: This test case checks the page title of the accessing website.  
Expected Output: The page title of accessing page must names "สมาคมทันตแพทย์จัดฟันแห่งประเทศไทย"

**Test Case #2** : Go to FindDentist page from Homepage's nav bar  
Description: This test checks that able go to find dentist page from Homepage's nav bar.  
Expected Output: The page title of accessing page must names "ค้นหาทันตแพทย์จัดฟัน"

**Test Case #3** : Search by inputting name into search box  
Description: This test checks the result of searching dentist name by inputting into search box.  
Expected Output: The output must show the dentist who names "นิรมล"

**Test Case #4** : Search by inputting Country into search box then appears the error alert  
Description: This test checks the error alert when typing "กรุงเทพมหานคร" in the searching by location.  
Expected Output: The error must be alert "There was a problem with your submission. Errors are marked below." message.

**Test Case #5** : Access Facebook Page  
Description: This test checks that the Facebook button can access their own Facebook page correctly or not.  
Expected Output: The output page must access the Facebook page names "หมอจัดฟันไทย - หน้าหลัก | Facebook". 

**Test Case #6** : Access Youtube Page  
Description: This test checks that the Youtube button can access their own Youtube correctly or not.  
Expected Output: The output page must access the Facebook page names "หมอจัดฟันไทย - YouTube". 

**Test Case #7** : Access Search Blog Page  
Description: This test checks the result of input which is "การจัดฟันคืออะไร".  
Expected Output: The output page must access the page that contain the result of searching.

**Test Case #8** : Access Category Page   
Description: This test checks that can access the "สาระน่ารู้" page correctly or not.  
Expected Output: The output page must access the page names "สาระน่ารู้".

**Test Case #9** : Payment Page Test  
Description: The test checks that the Payment button can be use for make a payment or not.  
Expected Output: The output page must contain text which is "CLICK HERE TO BEGIN CREDIT CARD ONLINE PAYMENT".  

**Test Case #10** : Login Page Test  
Description: The test checks that the login of the website using invalid account.  
Expected Output: The output must show the error message "Unknown username. Check again or try your email address.".

**Test Case #11** : Share facebook Test  
Description: The test checks that the content can be share on Facebook directly via Facebook pop-up.  
Expected Output: The output pop-up must show the title as "Facebook".  

**Test Case #12** : Download Article Test  
Description: This test checks that the article can be download correctly.  
Expected Output: The output must access "https://thaiortho.org/wp-content/uploads/2019/07/Cleft-ebook.pdf".  


