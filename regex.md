### reg exp brief
1. ^ Start of the string
2. $ End of the string
3. . anything
4. (.*) Matches anything (including nothing)
5. (.+) Matches at least one of the anything
6. (\\d+) sequence of digits e.g. @Given("^I ordered (\\d+) packets$")
7. (\\w+) sequence of letters or digits
8. s?he (? optional character: matches she or he)
9. an? matches 'a' or 'an'
10. (?:order|have ordered) matches 'order' or 'have ordered', but does not capture it as a parameter
11. 
