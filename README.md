##JSON parser
###STACK
Maven, Lombok, Jackson

The Task is:

Two files are input as arguments to the program: tests.json and values.json 
(there are examples of these files in the attachment to the task).

• values.json contains test results with unique id's
• tests.json contains a structure for building a report based on passed tests 
(nesting may be greater than in the example).

Write a program that generates a report.json file with value fields filled in for 
the tests.json structure based on values.json.

###Example
####Part of tests.json structure:
{"id": 122, "title": "Security test", "value": "", "values": 
[{"id": 5321, "title": "Confidentiality", "value": ""}, 
{"id": 5322, "title": "Integrity", "value": ""}]}

####After filling in according to values.json:
{"values": [{"id": 122, "value": "failed"}, {"id": 5321,"value": "passed"}, {"id": 5322,"value": "failed"}]}

####It will look like this in the report.json file:
{"id": 122, "title": "Security test", "value": "failed", "values": 
[{"id": 5321, "title": "Confidentiality", "value": "passed"}, 
{"id": 5322, "title": "Integrity", "value": "failed"}]}

