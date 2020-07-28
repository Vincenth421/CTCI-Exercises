JFLAGS = -g
JC = javac
.SUFFIXES: .java .class
.java.class:
	$(JC) $(JFLAGS) $*.java

CLASSES = Chapter1.java
TO_RUN = Chapter1

default: run

run: classes
	java -cp ./out $(TO_RUN)

classes:
	$(JC) -d ./out $(CLASSES)

clean:
	$(RM) -rf ./out/ *.class
