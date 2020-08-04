# Babysitter
Tools for babysitting service

The first feature for this web application is a calculator to determine how much to charge for one evening/night of babysitting.

###########################################################################
# commands to build, test, and run this application on your Windows computer
# this application uses Maven, which is bundled with the application and
# executed with the mvnw command
###########################################################################

1. clone the repository on your local
2. cd {your local repository}\babysitter  # this is where the pom.xml file and mvnw are
3. mvnw clean install                     # builds the application and runs unit tests
4. mvnw test                              # runs the unit tests
5. mvnw spring-boot:run                   # runs the application which will then be accessible via 'localhost:8080' from your browser

#######################################################################################
# including KATA description and email instructions for futher reference.
#######################################################################################

#######################################################################################
# Kata description from GitHub: https://github.com/OhioHealth/kata-babysitter
#######################################################################################

Babysitter Kata
Background
This kata simulates a babysitter working and getting paid for one night. The rules are pretty straight forward.

The babysitter:

starts no earlier than 5:00PM
leaves no later than 4:00AM
gets paid $12/hour from start-time to bedtime
gets paid $8/hour from bedtime to midnight
gets paid $16/hour from midnight to end of job
gets paid for full hours (no fractional hours)
Feature
As a babysitter
In order to get paid for 1 night of work
I want to calculate my nightly charge

#######################################################################################
# Instructions from email
#######################################################################################

Intructions: Babysitter Kata instructions

https://github.com/OhioHealth/kata-babysitter

Your code will be evaluated on the basis of:

· Ease of building the project and running tests
· Project organization and ease of understanding
· Naming conventions and clarity
· Clean code (as defined by the book of the same name) at the module/class and function/method level
· Minimal duplication (DRY)
· Idiomatic use of the programming language and associated tools
· Originality of solution (it must not be plagiarized)
· Do not add unneeded technology that makes the solution difficult to follow. Remember, ease of understanding

Building and Running Tests

Please include a README file with your submission that tells us exactly how to build and run your solution. The best option is to have one or two commands to accomplish that, depending on the tech stack and tools you've chosen. I'd like to see the equivalent of 'make build' or 'gradle test'.

Managing Dependencies

You're welcome to use whatever dependency management tool/approach you'd like. Just ensure that you're not expecting me nor the team to go out and download all your dependencies. You should include those in your solution, either as hard references to the files themselves, or via something like Gradle or NuGet.

My main goal for the kata is to be able to see how you problem-solve, as well as your ability to generate meaningful, clean, and test-driven code. Please use a Github or Bitbucket repository with frequent commits with meaningful messages so that I can see into your unique brand of problem-solving. Do not feel obligated to complete the entire Kata, but please complete at least about half, and as much as you're able. I consider this a representation of your best work that I will review with the team and use to move your application process forward. My goal is to have an in-depth conversation with you about your work. When completed, please email the URL to your Github or Bitbucket repository to Amanda and she can forward it on to me.

Other Information
If you have any questions or concerns, don't hesitate to reach out to me and I will do my best to clarify things.

You may use any one of the following languages to perform your kata:

Ruby
Groovy
Java - Please use Java for this role!
C#
C/C++
Python
JavaScript
Scala
Swift
