



set -e
cd "$(dirname "$0")"
export CCHK="java -classpath ./lib/antlr-4.7.1-complete.jar:./lib/commons-text-1.6.jar:./bin:./lib/commons-lang3-3.8.1.jar compilerjava.Main"
cat > test.txt   # save everything in stdin to program.txt
$CCHK


