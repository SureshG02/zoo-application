# Zoo application

Prerequisite:

Java 8+ and Apache Maven

Build project: 

git clone https://github.com/SureshG02/zoo-application.git

Go to directory zoo-application and run below command:

mvn clean install

Run main class: 

mvn exec:java -Dexec.mainClass="zoo.demo.App"

About application:

Zoo console application lets you manage below three options. Please enter options as number 1 or 2 or 3. 

1 >> SHOW_ANIMALS

Used for displaying all animals detail along with friends.

2 >> LIVE_ONE_DAY

Let’s each animal make friend or unfriend with other animal in zoo. Basically, works on below three rules.

•	If A is a friend of B, then B is a friend of A automatically.

•	Similarly, if A loses friendship with B then B automatically loses with A.

•	Every day each animal randomly loses one friend (if there are any) and gets from zero to one new friend.

3 >> Exit

Exit console
