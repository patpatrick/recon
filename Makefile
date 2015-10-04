all: compil

compil: BIN
	javac -d bin ./sources/mvc/controller/*.java  ./sources/utils/*.java  ./sources/mvc/controller/minions/*.java  ./sources/services/*.java  

BIN:
	mkdir bin
