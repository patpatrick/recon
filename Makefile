all: compil tests

bin:
	mkdir $@

compil: bin
	javac sources/mvc/controller/utils/*.java sources/mvc/controller/minions/*.java sources/mvc/controller/*.java sources/services/*.java sources/tests/*.java sources/mvc/model/*.java  -d bin

tests:
	@echo "=============== TEST RECON REGX ==================";
	cd bin ; java tests/TestReconRegex ;
	
clean:
	rm -r bin ;
