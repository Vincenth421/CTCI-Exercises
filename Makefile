JFLAGS = -g
JC = javac
.SUFFIXES: .java .class
.java.class:
	$(JC) $(JFLAGS) $*.java

CLASSES = \
	Chapter2.java

TO_RUN = \
	Chapter2

default: run

run: classes
	java -cp ./out $(TO_RUN)

classes:
	$(JC) -d ./out $(CLASSES)

clean:
	$(RM) -rf ./out/ *.class
