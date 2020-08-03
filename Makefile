JFLAGS = -g
JC = javac
.SUFFIXES: .java .class
.java.class:
	$(JC) $(JFLAGS) $*.java

CLASSES = \
	Chapter3.java

TO_RUN = \
	Chapter3

default: run

run: classes
	java -cp ./out $(TO_RUN)

classes:
	$(JC) -d ./out $(CLASSES)

clean:
	$(RM) -rf ./out/ *.class
