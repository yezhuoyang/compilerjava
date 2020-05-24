
set -e
cd "$(dirname "$0")"
export CCHK="java -classpath ./lib/antlr-4.7.1-complete.jar:./bin Main 1"
cat > test.txt
$CCHK

