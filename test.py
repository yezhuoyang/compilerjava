
import os





path2ravel="/Users/yezhuoyang/Desktop/share/compilerjava"
codegenPath="/Users/yezhuoyang/Desktop/Compiler-2020/testcase/codegen/shortest_path/"
case="dijkstra.mx"
simulatorOutput = '\n'.join(map(lambda x: x.strip('\n'), open(os.path.join(path2ravel, 'test.out'), 'r').readlines()))
# load test case
caseData = open(os.path.join(codegenPath, case), 'r').readlines()
caseData = [i.strip('\n') for i in caseData]
metaIdx = (caseData.index('/*'), caseData.index('*/'))
metaArea = caseData[metaIdx[0] + 1: metaIdx[1]]
metaConfigArea = []
inputOrOutput = False
for i in metaArea:
    if '===' in i: inputOrOutput = not inputOrOutput
    if inputOrOutput: continue
    if '===' in i or 'output' in i or 'Input' in i or 'Output' in i or ':' not in i: continue
    metaConfigArea.append(i)
metaConfigArea = [i.split(': ') for i in metaConfigArea]
metaDict = {i[0]:i[1] for i in metaConfigArea}




newMetaArea = metaArea[metaArea.index('=== end ===') + 1:]
inputDataStr = '\n'.join(metaArea[metaArea.index('=== input ===') + 1 : metaArea.index('=== end ===')])
outputLines = newMetaArea[newMetaArea.index('=== output ===') + 1 : newMetaArea.index('=== end ===')]
#if outputLines[-1] == '':
#    outputLines.pop(-1)
outputDataStr = '\n'.join(outputLines)


outputDataStr
