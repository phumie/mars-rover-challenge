find . -name "*.class" -delete
find src/main -name "*.java" > sources.txt
javac -sourcepath . @sources.txt
java src.main.java.main.Main src/scenario.txt