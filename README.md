# compilerjava

A  compiler implemented in java, transform a mini c-like language to riscv assembly, whic is one of the big projects in acm honor class 2020.

(I tried to implemented in C++ at first and failed)

I have to admit I mainly refer to the code of git@github.com:spectrometerHBH/Daedalus.git.

Follows are several optimizations I implememted:


## Front end:
1. Short circuit optimization.
2. Eliminate codes that are irrelevant to output or exitcode directly


## Back end(IR)
1. Control flow graph simplification.
2. Common subexpression elimination.
3. Constant and copy proppagation.
4. Aggressive dead code elimination.










