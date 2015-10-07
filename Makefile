all: compil

compil: BIN
	javac -d bin -cp ./classpath/*.jar  ./sources/tests/*.java  ./sources/mvc/controller/minions/*.java  ./sources/services/*.java  ./sources/utils/*.java  ./sources/mvc/controller/*.java  

BIN:
	mkdir bin

clean:
	rm -rf bin
