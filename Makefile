#Makefile Script


Main: *.java
	@javac Main.java

clean:
	@rm Main

edit:
	@vim Main.java

run:
	@java Main
