define i64 @func  %a_1 %b_1 {
func_entry_1:
   %saved.vs4_1 = move %vs4_1
   %saved.vs7_1 = move %vs7_1
   %saved.vs5_1 = move %vs5_1
   %saved.vs6_1 = move %vs6_1
   %saved.vs2_1 = move %vs2_1
   %saved.vs1_1 = move %vs1_1
   %saved.vs8_1 = move %vs8_1
   %saved.vs11_1 = move %vs11_1
   %saved.vs9_1 = move %vs9_1
   %saved.vs10_1 = move %vs10_1
   %saved.vs3_1 = move %vs3_1
   %b_1 = move %va1_1
   %a_1 = move %va0_1
   %t_1 = add %a_1 %b_1
   %t_2 = move %t_1
   %vs3_1 = move %saved.vs3_1
   %vs10_1 = move %saved.vs10_1
   %vs9_1 = move %saved.vs9_1
   %vs11_1 = move %saved.vs11_1
   %vs8_1 = move %saved.vs8_1
   %vs1_1 = move %saved.vs1_1
   %vs2_1 = move %saved.vs2_1
   %vs6_1 = move %saved.vs6_1
   %vs5_1 = move %saved.vs5_1
   %vs7_1 = move %saved.vs7_1
   %vs4_1 = move %saved.vs4_1
   %va0_1 = move %t_2
   ret %va0_1
}

define i64 @main  {
main_entry_1:
   %saved.vs4_2 = move %vs4_1
   %saved.vs7_2 = move %vs7_1
   %saved.vs5_2 = move %vs5_1
   %saved.vs6_2 = move %vs6_1
   %saved.vs2_2 = move %vs2_1
   %saved.vs1_2 = move %vs1_1
   %saved.vs8_2 = move %vs8_1
   %saved.vs11_2 = move %vs11_1
   %saved.vs9_2 = move %vs9_1
   %saved.vs10_2 = move %vs10_1
   %saved.vs3_2 = move %vs3_1
   %b_2 = move 3
   %c_1 = move 4
   %va0_1 = move %b_2
   %va1_1 = move %c_1
   %va0_1 = call func %va0_1 %va1_1 
   %t_3 = move %va0_1
   %t_4 = move %t_3
   %vs3_1 = move %saved.vs3_2
   %vs10_1 = move %saved.vs10_2
   %vs9_1 = move %saved.vs9_2
   %vs11_1 = move %saved.vs11_2
   %vs8_1 = move %saved.vs8_2
   %vs1_1 = move %saved.vs1_2
   %vs2_1 = move %saved.vs2_2
   %vs6_1 = move %saved.vs6_2
   %vs5_1 = move %saved.vs5_2
   %vs7_1 = move %saved.vs7_2
   %vs4_1 = move %saved.vs4_2
   %va0_1 = move %t_4
   ret %va0_1
}

define i64 @__init  {
__init_entry_1:
   %saved.vs4_3 = move %vs4_1
   %saved.vs7_3 = move %vs7_1
   %saved.vs5_3 = move %vs5_1
   %saved.vs6_3 = move %vs6_1
   %saved.vs2_3 = move %vs2_1
   %saved.vs1_3 = move %vs1_1
   %saved.vs8_3 = move %vs8_1
   %saved.vs11_3 = move %vs11_1
   %saved.vs9_3 = move %vs9_1
   %saved.vs10_3 = move %vs10_1
   %saved.vs3_3 = move %vs3_1
   %va0_1 = call main 
   %t_5 = move %va0_1
   %t_6 = move %t_5
   %vs3_1 = move %saved.vs3_3
   %vs10_1 = move %saved.vs10_3
   %vs9_1 = move %saved.vs9_3
   %vs11_1 = move %saved.vs11_3
   %vs8_1 = move %saved.vs8_3
   %vs1_1 = move %saved.vs1_3
   %vs2_1 = move %saved.vs2_3
   %vs6_1 = move %saved.vs6_3
   %vs5_1 = move %saved.vs5_3
   %vs7_1 = move %saved.vs7_3
   %vs4_1 = move %saved.vs4_3
   %va0_1 = move %t_6
   ret %va0_1
}

=====================func Iteration 0=====================
========func Graph Info ========
saved.vs8_1:
AdjList : 
degree : 0
Alias :None
Color : null
Priority : 0
------
t_1:
AdjList :  vzero_1
degree : 1
Alias :None
Color : null
Priority : 0
------
saved.vs4_1:
AdjList : 
degree : 0
Alias :None
Color : null
Priority : 0
------
saved.vs9_1:
AdjList : 
degree : 0
Alias :None
Color : null
Priority : 0
------
saved.vs3_1:
AdjList : 
degree : 0
Alias :None
Color : null
Priority : 0
------
saved.vs10_1:
AdjList : 
degree : 0
Alias :None
Color : null
Priority : 0
------
t_2:
AdjList :  vzero_1
degree : 1
Alias :None
Color : null
Priority : 0
------
saved.vs5_1:
AdjList : 
degree : 0
Alias :None
Color : null
Priority : 0
------
saved.vs7_1:
AdjList : 
degree : 0
Alias :None
Color : null
Priority : 0
------
saved.vs1_1:
AdjList : 
degree : 0
Alias :None
Color : null
Priority : 0
------
saved.vs6_1:
AdjList : 
degree : 0
Alias :None
Color : null
Priority : 0
------
saved.vs2_1:
AdjList : 
degree : 0
Alias :None
Color : null
Priority : 0
------
b_1:
AdjList :  vzero_1 a_1 va0_1
degree : 3
Alias :None
Color : null
Priority : 0
------
saved.vs11_1:
AdjList : 
degree : 0
Alias :None
Color : null
Priority : 0
------
a_1:
AdjList :  vzero_1 b_1
degree : 2
Alias :None
Color : null
Priority : 0
------
========func move List Info ========
coalesced moves:
------
constrained moves:
------
fronzen moves:
------
workList moves:
va0_1 = move t_2
a_1 = move va0_1
t_2 = move t_1
b_1 = move va1_1
------
active moves:
========func Node List Info ========
simplify Nodes(low degree non move related):
saved.vs8_1(0) saved.vs2_1(0) saved.vs7_1(0) saved.vs3_1(0) saved.vs1_1(0) saved.vs11_1(0) saved.vs4_1(0) saved.vs9_1(0) saved.vs10_1(0) saved.vs6_1(0) saved.vs5_1(0) 
------
freeze Nodes(low degree move related):
t_1(0) b_1(0) t_2(0) a_1(0) 
------
spill Nodes(high degree):

------
spilled Nodes:

------
coalesced Nodes:

------
colored Nodes:

------
selected Stack:

------

define i64 @func  %a_1 %b_1 {
func_entry_1:
   %b_1 = move %va1_1
   %a_1 = move %va0_1
   %t_1 = add %a_1 %b_1
   %t_2 = move %t_1
   %va0_1 = move %t_2
   ret %va0_1
}

define i64 @main  {
main_entry_1:
   %saved.vs4_2 = move %vs4_1
   %saved.vs7_2 = move %vs7_1
   %saved.vs5_2 = move %vs5_1
   %saved.vs6_2 = move %vs6_1
   %saved.vs2_2 = move %vs2_1
   %saved.vs1_2 = move %vs1_1
   %saved.vs8_2 = move %vs8_1
   %saved.vs11_2 = move %vs11_1
   %saved.vs9_2 = move %vs9_1
   %saved.vs10_2 = move %vs10_1
   %saved.vs3_2 = move %vs3_1
   %b_2 = move 3
   %c_1 = move 4
   %va0_1 = move %b_2
   %va1_1 = move %c_1
   %va0_1 = call func %va0_1 %va1_1 
   %t_3 = move %va0_1
   %t_4 = move %t_3
   %vs3_1 = move %saved.vs3_2
   %vs10_1 = move %saved.vs10_2
   %vs9_1 = move %saved.vs9_2
   %vs11_1 = move %saved.vs11_2
   %vs8_1 = move %saved.vs8_2
   %vs1_1 = move %saved.vs1_2
   %vs2_1 = move %saved.vs2_2
   %vs6_1 = move %saved.vs6_2
   %vs5_1 = move %saved.vs5_2
   %vs7_1 = move %saved.vs7_2
   %vs4_1 = move %saved.vs4_2
   %va0_1 = move %t_4
   ret %va0_1
}

define i64 @__init  {
__init_entry_1:
   %saved.vs4_3 = move %vs4_1
   %saved.vs7_3 = move %vs7_1
   %saved.vs5_3 = move %vs5_1
   %saved.vs6_3 = move %vs6_1
   %saved.vs2_3 = move %vs2_1
   %saved.vs1_3 = move %vs1_1
   %saved.vs8_3 = move %vs8_1
   %saved.vs11_3 = move %vs11_1
   %saved.vs9_3 = move %vs9_1
   %saved.vs10_3 = move %vs10_1
   %saved.vs3_3 = move %vs3_1
   %va0_1 = call main 
   %t_5 = move %va0_1
   %t_6 = move %t_5
   %vs3_1 = move %saved.vs3_3
   %vs10_1 = move %saved.vs10_3
   %vs9_1 = move %saved.vs9_3
   %vs11_1 = move %saved.vs11_3
   %vs8_1 = move %saved.vs8_3
   %vs1_1 = move %saved.vs1_3
   %vs2_1 = move %saved.vs2_3
   %vs6_1 = move %saved.vs6_3
   %vs5_1 = move %saved.vs5_3
   %vs7_1 = move %saved.vs7_3
   %vs4_1 = move %saved.vs4_3
   %va0_1 = move %t_6
   ret %va0_1
}

===================== Simplify =====================
========func Graph Info ========
saved.vs8_1:
AdjList : 
degree : 0
Alias :None
Color : null
Priority : 0
------
t_1:
AdjList :  vzero_1
degree : 1
Alias :None
Color : null
Priority : 0
------
saved.vs4_1:
AdjList : 
degree : 0
Alias :None
Color : null
Priority : 0
------
saved.vs9_1:
AdjList : 
degree : 0
Alias :None
Color : null
Priority : 0
------
saved.vs3_1:
AdjList : 
degree : 0
Alias :None
Color : null
Priority : 0
------
saved.vs10_1:
AdjList : 
degree : 0
Alias :None
Color : null
Priority : 0
------
t_2:
AdjList :  vzero_1
degree : 1
Alias :None
Color : null
Priority : 0
------
saved.vs5_1:
AdjList : 
degree : 0
Alias :None
Color : null
Priority : 0
------
saved.vs7_1:
AdjList : 
degree : 0
Alias :None
Color : null
Priority : 0
------
saved.vs1_1:
AdjList : 
degree : 0
Alias :None
Color : null
Priority : 0
------
saved.vs6_1:
AdjList : 
degree : 0
Alias :None
Color : null
Priority : 0
------
saved.vs2_1:
AdjList : 
degree : 0
Alias :None
Color : null
Priority : 0
------
b_1:
AdjList :  vzero_1 a_1 va0_1
degree : 3
Alias :None
Color : null
Priority : 0
------
saved.vs11_1:
AdjList : 
degree : 0
Alias :None
Color : null
Priority : 0
------
a_1:
AdjList :  vzero_1 b_1
degree : 2
Alias :None
Color : null
Priority : 0
------
========func move List Info ========
coalesced moves:
------
constrained moves:
------
fronzen moves:
------
workList moves:
va0_1 = move t_2
a_1 = move va0_1
t_2 = move t_1
b_1 = move va1_1
------
active moves:
========func Node List Info ========
simplify Nodes(low degree non move related):
saved.vs2_1(0) saved.vs7_1(0) saved.vs3_1(0) saved.vs1_1(0) saved.vs11_1(0) saved.vs4_1(0) saved.vs9_1(0) saved.vs10_1(0) saved.vs6_1(0) saved.vs5_1(0) 
------
freeze Nodes(low degree move related):
t_1(0) b_1(0) t_2(0) a_1(0) 
------
spill Nodes(high degree):

------
spilled Nodes:

------
coalesced Nodes:

------
colored Nodes:

------
selected Stack:
saved.vs8_1(0) 
------

===================== Simplify =====================
========func Graph Info ========
saved.vs8_1:
AdjList : 
degree : 0
Alias :None
Color : null
Priority : 0
------
t_1:
AdjList :  vzero_1
degree : 1
Alias :None
Color : null
Priority : 0
------
saved.vs4_1:
AdjList : 
degree : 0
Alias :None
Color : null
Priority : 0
------
saved.vs9_1:
AdjList : 
degree : 0
Alias :None
Color : null
Priority : 0
------
saved.vs3_1:
AdjList : 
degree : 0
Alias :None
Color : null
Priority : 0
------
saved.vs10_1:
AdjList : 
degree : 0
Alias :None
Color : null
Priority : 0
------
t_2:
AdjList :  vzero_1
degree : 1
Alias :None
Color : null
Priority : 0
------
saved.vs5_1:
AdjList : 
degree : 0
Alias :None
Color : null
Priority : 0
------
saved.vs7_1:
AdjList : 
degree : 0
Alias :None
Color : null
Priority : 0
------
saved.vs1_1:
AdjList : 
degree : 0
Alias :None
Color : null
Priority : 0
------
saved.vs6_1:
AdjList : 
degree : 0
Alias :None
Color : null
Priority : 0
------
saved.vs2_1:
AdjList : 
degree : 0
Alias :None
Color : null
Priority : 0
------
b_1:
AdjList :  vzero_1 a_1 va0_1
degree : 3
Alias :None
Color : null
Priority : 0
------
saved.vs11_1:
AdjList : 
degree : 0
Alias :None
Color : null
Priority : 0
------
a_1:
AdjList :  vzero_1 b_1
degree : 2
Alias :None
Color : null
Priority : 0
------
========func move List Info ========
coalesced moves:
------
constrained moves:
------
fronzen moves:
------
workList moves:
va0_1 = move t_2
a_1 = move va0_1
t_2 = move t_1
b_1 = move va1_1
------
active moves:
========func Node List Info ========
simplify Nodes(low degree non move related):
saved.vs7_1(0) saved.vs3_1(0) saved.vs1_1(0) saved.vs11_1(0) saved.vs4_1(0) saved.vs9_1(0) saved.vs10_1(0) saved.vs6_1(0) saved.vs5_1(0) 
------
freeze Nodes(low degree move related):
t_1(0) b_1(0) t_2(0) a_1(0) 
------
spill Nodes(high degree):

------
spilled Nodes:

------
coalesced Nodes:

------
colored Nodes:

------
selected Stack:
saved.vs8_1(0) saved.vs2_1(0) 
------

===================== Simplify =====================
========func Graph Info ========
saved.vs8_1:
AdjList : 
degree : 0
Alias :None
Color : null
Priority : 0
------
t_1:
AdjList :  vzero_1
degree : 1
Alias :None
Color : null
Priority : 0
------
saved.vs4_1:
AdjList : 
degree : 0
Alias :None
Color : null
Priority : 0
------
saved.vs9_1:
AdjList : 
degree : 0
Alias :None
Color : null
Priority : 0
------
saved.vs3_1:
AdjList : 
degree : 0
Alias :None
Color : null
Priority : 0
------
saved.vs10_1:
AdjList : 
degree : 0
Alias :None
Color : null
Priority : 0
------
t_2:
AdjList :  vzero_1
degree : 1
Alias :None
Color : null
Priority : 0
------
saved.vs5_1:
AdjList : 
degree : 0
Alias :None
Color : null
Priority : 0
------
saved.vs7_1:
AdjList : 
degree : 0
Alias :None
Color : null
Priority : 0
------
saved.vs1_1:
AdjList : 
degree : 0
Alias :None
Color : null
Priority : 0
------
saved.vs6_1:
AdjList : 
degree : 0
Alias :None
Color : null
Priority : 0
------
saved.vs2_1:
AdjList : 
degree : 0
Alias :None
Color : null
Priority : 0
------
b_1:
AdjList :  vzero_1 a_1 va0_1
degree : 3
Alias :None
Color : null
Priority : 0
------
saved.vs11_1:
AdjList : 
degree : 0
Alias :None
Color : null
Priority : 0
------
a_1:
AdjList :  vzero_1 b_1
degree : 2
Alias :None
Color : null
Priority : 0
------
========func move List Info ========
coalesced moves:
------
constrained moves:
------
fronzen moves:
------
workList moves:
va0_1 = move t_2
a_1 = move va0_1
t_2 = move t_1
b_1 = move va1_1
------
active moves:
========func Node List Info ========
simplify Nodes(low degree non move related):
saved.vs3_1(0) saved.vs1_1(0) saved.vs11_1(0) saved.vs4_1(0) saved.vs9_1(0) saved.vs10_1(0) saved.vs6_1(0) saved.vs5_1(0) 
------
freeze Nodes(low degree move related):
t_1(0) b_1(0) t_2(0) a_1(0) 
------
spill Nodes(high degree):

------
spilled Nodes:

------
coalesced Nodes:

------
colored Nodes:

------
selected Stack:
saved.vs8_1(0) saved.vs2_1(0) saved.vs7_1(0) 
------

===================== Simplify =====================
========func Graph Info ========
saved.vs8_1:
AdjList : 
degree : 0
Alias :None
Color : null
Priority : 0
------
t_1:
AdjList :  vzero_1
degree : 1
Alias :None
Color : null
Priority : 0
------
saved.vs4_1:
AdjList : 
degree : 0
Alias :None
Color : null
Priority : 0
------
saved.vs9_1:
AdjList : 
degree : 0
Alias :None
Color : null
Priority : 0
------
saved.vs3_1:
AdjList : 
degree : 0
Alias :None
Color : null
Priority : 0
------
saved.vs10_1:
AdjList : 
degree : 0
Alias :None
Color : null
Priority : 0
------
t_2:
AdjList :  vzero_1
degree : 1
Alias :None
Color : null
Priority : 0
------
saved.vs5_1:
AdjList : 
degree : 0
Alias :None
Color : null
Priority : 0
------
saved.vs7_1:
AdjList : 
degree : 0
Alias :None
Color : null
Priority : 0
------
saved.vs1_1:
AdjList : 
degree : 0
Alias :None
Color : null
Priority : 0
------
saved.vs6_1:
AdjList : 
degree : 0
Alias :None
Color : null
Priority : 0
------
saved.vs2_1:
AdjList : 
degree : 0
Alias :None
Color : null
Priority : 0
------
b_1:
AdjList :  vzero_1 a_1 va0_1
degree : 3
Alias :None
Color : null
Priority : 0
------
saved.vs11_1:
AdjList : 
degree : 0
Alias :None
Color : null
Priority : 0
------
a_1:
AdjList :  vzero_1 b_1
degree : 2
Alias :None
Color : null
Priority : 0
------
========func move List Info ========
coalesced moves:
------
constrained moves:
------
fronzen moves:
------
workList moves:
va0_1 = move t_2
a_1 = move va0_1
t_2 = move t_1
b_1 = move va1_1
------
active moves:
========func Node List Info ========
simplify Nodes(low degree non move related):
saved.vs1_1(0) saved.vs11_1(0) saved.vs4_1(0) saved.vs9_1(0) saved.vs10_1(0) saved.vs6_1(0) saved.vs5_1(0) 
------
freeze Nodes(low degree move related):
t_1(0) b_1(0) t_2(0) a_1(0) 
------
spill Nodes(high degree):

------
spilled Nodes:

------
coalesced Nodes:

------
colored Nodes:

------
selected Stack:
saved.vs8_1(0) saved.vs2_1(0) saved.vs7_1(0) saved.vs3_1(0) 
------

===================== Simplify =====================
========func Graph Info ========
saved.vs8_1:
AdjList : 
degree : 0
Alias :None
Color : null
Priority : 0
------
t_1:
AdjList :  vzero_1
degree : 1
Alias :None
Color : null
Priority : 0
------
saved.vs4_1:
AdjList : 
degree : 0
Alias :None
Color : null
Priority : 0
------
saved.vs9_1:
AdjList : 
degree : 0
Alias :None
Color : null
Priority : 0
------
saved.vs3_1:
AdjList : 
degree : 0
Alias :None
Color : null
Priority : 0
------
saved.vs10_1:
AdjList : 
degree : 0
Alias :None
Color : null
Priority : 0
------
t_2:
AdjList :  vzero_1
degree : 1
Alias :None
Color : null
Priority : 0
------
saved.vs5_1:
AdjList : 
degree : 0
Alias :None
Color : null
Priority : 0
------
saved.vs7_1:
AdjList : 
degree : 0
Alias :None
Color : null
Priority : 0
------
saved.vs1_1:
AdjList : 
degree : 0
Alias :None
Color : null
Priority : 0
------
saved.vs6_1:
AdjList : 
degree : 0
Alias :None
Color : null
Priority : 0
------
saved.vs2_1:
AdjList : 
degree : 0
Alias :None
Color : null
Priority : 0
------
b_1:
AdjList :  vzero_1 a_1 va0_1
degree : 3
Alias :None
Color : null
Priority : 0
------
saved.vs11_1:
AdjList : 
degree : 0
Alias :None
Color : null
Priority : 0
------
a_1:
AdjList :  vzero_1 b_1
degree : 2
Alias :None
Color : null
Priority : 0
------
========func move List Info ========
coalesced moves:
------
constrained moves:
------
fronzen moves:
------
workList moves:
va0_1 = move t_2
a_1 = move va0_1
t_2 = move t_1
b_1 = move va1_1
------
active moves:
========func Node List Info ========
simplify Nodes(low degree non move related):
saved.vs11_1(0) saved.vs4_1(0) saved.vs9_1(0) saved.vs10_1(0) saved.vs6_1(0) saved.vs5_1(0) 
------
freeze Nodes(low degree move related):
t_1(0) b_1(0) t_2(0) a_1(0) 
------
spill Nodes(high degree):

------
spilled Nodes:

------
coalesced Nodes:

------
colored Nodes:

------
selected Stack:
saved.vs8_1(0) saved.vs2_1(0) saved.vs7_1(0) saved.vs3_1(0) saved.vs1_1(0) 
------

===================== Simplify =====================
========func Graph Info ========
saved.vs8_1:
AdjList : 
degree : 0
Alias :None
Color : null
Priority : 0
------
t_1:
AdjList :  vzero_1
degree : 1
Alias :None
Color : null
Priority : 0
------
saved.vs4_1:
AdjList : 
degree : 0
Alias :None
Color : null
Priority : 0
------
saved.vs9_1:
AdjList : 
degree : 0
Alias :None
Color : null
Priority : 0
------
saved.vs3_1:
AdjList : 
degree : 0
Alias :None
Color : null
Priority : 0
------
saved.vs10_1:
AdjList : 
degree : 0
Alias :None
Color : null
Priority : 0
------
t_2:
AdjList :  vzero_1
degree : 1
Alias :None
Color : null
Priority : 0
------
saved.vs5_1:
AdjList : 
degree : 0
Alias :None
Color : null
Priority : 0
------
saved.vs7_1:
AdjList : 
degree : 0
Alias :None
Color : null
Priority : 0
------
saved.vs1_1:
AdjList : 
degree : 0
Alias :None
Color : null
Priority : 0
------
saved.vs6_1:
AdjList : 
degree : 0
Alias :None
Color : null
Priority : 0
------
saved.vs2_1:
AdjList : 
degree : 0
Alias :None
Color : null
Priority : 0
------
b_1:
AdjList :  vzero_1 a_1 va0_1
degree : 3
Alias :None
Color : null
Priority : 0
------
saved.vs11_1:
AdjList : 
degree : 0
Alias :None
Color : null
Priority : 0
------
a_1:
AdjList :  vzero_1 b_1
degree : 2
Alias :None
Color : null
Priority : 0
------
========func move List Info ========
coalesced moves:
------
constrained moves:
------
fronzen moves:
------
workList moves:
va0_1 = move t_2
a_1 = move va0_1
t_2 = move t_1
b_1 = move va1_1
------
active moves:
========func Node List Info ========
simplify Nodes(low degree non move related):
saved.vs4_1(0) saved.vs9_1(0) saved.vs10_1(0) saved.vs6_1(0) saved.vs5_1(0) 
------
freeze Nodes(low degree move related):
t_1(0) b_1(0) t_2(0) a_1(0) 
------
spill Nodes(high degree):

------
spilled Nodes:

------
coalesced Nodes:

------
colored Nodes:

------
selected Stack:
saved.vs8_1(0) saved.vs2_1(0) saved.vs7_1(0) saved.vs3_1(0) saved.vs1_1(0) saved.vs11_1(0) 
------

===================== Simplify =====================
========func Graph Info ========
saved.vs8_1:
AdjList : 
degree : 0
Alias :None
Color : null
Priority : 0
------
t_1:
AdjList :  vzero_1
degree : 1
Alias :None
Color : null
Priority : 0
------
saved.vs4_1:
AdjList : 
degree : 0
Alias :None
Color : null
Priority : 0
------
saved.vs9_1:
AdjList : 
degree : 0
Alias :None
Color : null
Priority : 0
------
saved.vs3_1:
AdjList : 
degree : 0
Alias :None
Color : null
Priority : 0
------
saved.vs10_1:
AdjList : 
degree : 0
Alias :None
Color : null
Priority : 0
------
t_2:
AdjList :  vzero_1
degree : 1
Alias :None
Color : null
Priority : 0
------
saved.vs5_1:
AdjList : 
degree : 0
Alias :None
Color : null
Priority : 0
------
saved.vs7_1:
AdjList : 
degree : 0
Alias :None
Color : null
Priority : 0
------
saved.vs1_1:
AdjList : 
degree : 0
Alias :None
Color : null
Priority : 0
------
saved.vs6_1:
AdjList : 
degree : 0
Alias :None
Color : null
Priority : 0
------
saved.vs2_1:
AdjList : 
degree : 0
Alias :None
Color : null
Priority : 0
------
b_1:
AdjList :  vzero_1 a_1 va0_1
degree : 3
Alias :None
Color : null
Priority : 0
------
saved.vs11_1:
AdjList : 
degree : 0
Alias :None
Color : null
Priority : 0
------
a_1:
AdjList :  vzero_1 b_1
degree : 2
Alias :None
Color : null
Priority : 0
------
========func move List Info ========
coalesced moves:
------
constrained moves:
------
fronzen moves:
------
workList moves:
va0_1 = move t_2
a_1 = move va0_1
t_2 = move t_1
b_1 = move va1_1
------
active moves:
========func Node List Info ========
simplify Nodes(low degree non move related):
saved.vs9_1(0) saved.vs10_1(0) saved.vs6_1(0) saved.vs5_1(0) 
------
freeze Nodes(low degree move related):
t_1(0) b_1(0) t_2(0) a_1(0) 
------
spill Nodes(high degree):

------
spilled Nodes:

------
coalesced Nodes:

------
colored Nodes:

------
selected Stack:
saved.vs8_1(0) saved.vs2_1(0) saved.vs7_1(0) saved.vs3_1(0) saved.vs1_1(0) saved.vs11_1(0) saved.vs4_1(0) 
------

===================== Simplify =====================
========func Graph Info ========
saved.vs8_1:
AdjList : 
degree : 0
Alias :None
Color : null
Priority : 0
------
t_1:
AdjList :  vzero_1
degree : 1
Alias :None
Color : null
Priority : 0
------
saved.vs4_1:
AdjList : 
degree : 0
Alias :None
Color : null
Priority : 0
------
saved.vs9_1:
AdjList : 
degree : 0
Alias :None
Color : null
Priority : 0
------
saved.vs3_1:
AdjList : 
degree : 0
Alias :None
Color : null
Priority : 0
------
saved.vs10_1:
AdjList : 
degree : 0
Alias :None
Color : null
Priority : 0
------
t_2:
AdjList :  vzero_1
degree : 1
Alias :None
Color : null
Priority : 0
------
saved.vs5_1:
AdjList : 
degree : 0
Alias :None
Color : null
Priority : 0
------
saved.vs7_1:
AdjList : 
degree : 0
Alias :None
Color : null
Priority : 0
------
saved.vs1_1:
AdjList : 
degree : 0
Alias :None
Color : null
Priority : 0
------
saved.vs6_1:
AdjList : 
degree : 0
Alias :None
Color : null
Priority : 0
------
saved.vs2_1:
AdjList : 
degree : 0
Alias :None
Color : null
Priority : 0
------
b_1:
AdjList :  vzero_1 a_1 va0_1
degree : 3
Alias :None
Color : null
Priority : 0
------
saved.vs11_1:
AdjList : 
degree : 0
Alias :None
Color : null
Priority : 0
------
a_1:
AdjList :  vzero_1 b_1
degree : 2
Alias :None
Color : null
Priority : 0
------
========func move List Info ========
coalesced moves:
------
constrained moves:
------
fronzen moves:
------
workList moves:
va0_1 = move t_2
a_1 = move va0_1
t_2 = move t_1
b_1 = move va1_1
------
active moves:
========func Node List Info ========
simplify Nodes(low degree non move related):
saved.vs10_1(0) saved.vs6_1(0) saved.vs5_1(0) 
------
freeze Nodes(low degree move related):
t_1(0) b_1(0) t_2(0) a_1(0) 
------
spill Nodes(high degree):

------
spilled Nodes:

------
coalesced Nodes:

------
colored Nodes:

------
selected Stack:
saved.vs8_1(0) saved.vs2_1(0) saved.vs7_1(0) saved.vs3_1(0) saved.vs1_1(0) saved.vs11_1(0) saved.vs4_1(0) saved.vs9_1(0) 
------

===================== Simplify =====================
========func Graph Info ========
saved.vs8_1:
AdjList : 
degree : 0
Alias :None
Color : null
Priority : 0
------
t_1:
AdjList :  vzero_1
degree : 1
Alias :None
Color : null
Priority : 0
------
saved.vs4_1:
AdjList : 
degree : 0
Alias :None
Color : null
Priority : 0
------
saved.vs9_1:
AdjList : 
degree : 0
Alias :None
Color : null
Priority : 0
------
saved.vs3_1:
AdjList : 
degree : 0
Alias :None
Color : null
Priority : 0
------
saved.vs10_1:
AdjList : 
degree : 0
Alias :None
Color : null
Priority : 0
------
t_2:
AdjList :  vzero_1
degree : 1
Alias :None
Color : null
Priority : 0
------
saved.vs5_1:
AdjList : 
degree : 0
Alias :None
Color : null
Priority : 0
------
saved.vs7_1:
AdjList : 
degree : 0
Alias :None
Color : null
Priority : 0
------
saved.vs1_1:
AdjList : 
degree : 0
Alias :None
Color : null
Priority : 0
------
saved.vs6_1:
AdjList : 
degree : 0
Alias :None
Color : null
Priority : 0
------
saved.vs2_1:
AdjList : 
degree : 0
Alias :None
Color : null
Priority : 0
------
b_1:
AdjList :  vzero_1 a_1 va0_1
degree : 3
Alias :None
Color : null
Priority : 0
------
saved.vs11_1:
AdjList : 
degree : 0
Alias :None
Color : null
Priority : 0
------
a_1:
AdjList :  vzero_1 b_1
degree : 2
Alias :None
Color : null
Priority : 0
------
========func move List Info ========
coalesced moves:
------
constrained moves:
------
fronzen moves:
------
workList moves:
va0_1 = move t_2
a_1 = move va0_1
t_2 = move t_1
b_1 = move va1_1
------
active moves:
========func Node List Info ========
simplify Nodes(low degree non move related):
saved.vs6_1(0) saved.vs5_1(0) 
------
freeze Nodes(low degree move related):
t_1(0) b_1(0) t_2(0) a_1(0) 
------
spill Nodes(high degree):

------
spilled Nodes:

------
coalesced Nodes:

------
colored Nodes:

------
selected Stack:
saved.vs8_1(0) saved.vs2_1(0) saved.vs7_1(0) saved.vs3_1(0) saved.vs1_1(0) saved.vs11_1(0) saved.vs4_1(0) saved.vs9_1(0) saved.vs10_1(0) 
------

===================== Simplify =====================
========func Graph Info ========
saved.vs8_1:
AdjList : 
degree : 0
Alias :None
Color : null
Priority : 0
------
t_1:
AdjList :  vzero_1
degree : 1
Alias :None
Color : null
Priority : 0
------
saved.vs4_1:
AdjList : 
degree : 0
Alias :None
Color : null
Priority : 0
------
saved.vs9_1:
AdjList : 
degree : 0
Alias :None
Color : null
Priority : 0
------
saved.vs3_1:
AdjList : 
degree : 0
Alias :None
Color : null
Priority : 0
------
saved.vs10_1:
AdjList : 
degree : 0
Alias :None
Color : null
Priority : 0
------
t_2:
AdjList :  vzero_1
degree : 1
Alias :None
Color : null
Priority : 0
------
saved.vs5_1:
AdjList : 
degree : 0
Alias :None
Color : null
Priority : 0
------
saved.vs7_1:
AdjList : 
degree : 0
Alias :None
Color : null
Priority : 0
------
saved.vs1_1:
AdjList : 
degree : 0
Alias :None
Color : null
Priority : 0
------
saved.vs6_1:
AdjList : 
degree : 0
Alias :None
Color : null
Priority : 0
------
saved.vs2_1:
AdjList : 
degree : 0
Alias :None
Color : null
Priority : 0
------
b_1:
AdjList :  vzero_1 a_1 va0_1
degree : 3
Alias :None
Color : null
Priority : 0
------
saved.vs11_1:
AdjList : 
degree : 0
Alias :None
Color : null
Priority : 0
------
a_1:
AdjList :  vzero_1 b_1
degree : 2
Alias :None
Color : null
Priority : 0
------
========func move List Info ========
coalesced moves:
------
constrained moves:
------
fronzen moves:
------
workList moves:
va0_1 = move t_2
a_1 = move va0_1
t_2 = move t_1
b_1 = move va1_1
------
active moves:
========func Node List Info ========
simplify Nodes(low degree non move related):
saved.vs5_1(0) 
------
freeze Nodes(low degree move related):
t_1(0) b_1(0) t_2(0) a_1(0) 
------
spill Nodes(high degree):

------
spilled Nodes:

------
coalesced Nodes:

------
colored Nodes:

------
selected Stack:
saved.vs8_1(0) saved.vs2_1(0) saved.vs7_1(0) saved.vs3_1(0) saved.vs1_1(0) saved.vs11_1(0) saved.vs4_1(0) saved.vs9_1(0) saved.vs10_1(0) saved.vs6_1(0) 
------

===================== Simplify =====================
========func Graph Info ========
saved.vs8_1:
AdjList : 
degree : 0
Alias :None
Color : null
Priority : 0
------
t_1:
AdjList :  vzero_1
degree : 1
Alias :None
Color : null
Priority : 0
------
saved.vs4_1:
AdjList : 
degree : 0
Alias :None
Color : null
Priority : 0
------
saved.vs9_1:
AdjList : 
degree : 0
Alias :None
Color : null
Priority : 0
------
saved.vs3_1:
AdjList : 
degree : 0
Alias :None
Color : null
Priority : 0
------
saved.vs10_1:
AdjList : 
degree : 0
Alias :None
Color : null
Priority : 0
------
t_2:
AdjList :  vzero_1
degree : 1
Alias :None
Color : null
Priority : 0
------
saved.vs5_1:
AdjList : 
degree : 0
Alias :None
Color : null
Priority : 0
------
saved.vs7_1:
AdjList : 
degree : 0
Alias :None
Color : null
Priority : 0
------
saved.vs1_1:
AdjList : 
degree : 0
Alias :None
Color : null
Priority : 0
------
saved.vs6_1:
AdjList : 
degree : 0
Alias :None
Color : null
Priority : 0
------
saved.vs2_1:
AdjList : 
degree : 0
Alias :None
Color : null
Priority : 0
------
b_1:
AdjList :  vzero_1 a_1 va0_1
degree : 3
Alias :None
Color : null
Priority : 0
------
saved.vs11_1:
AdjList : 
degree : 0
Alias :None
Color : null
Priority : 0
------
a_1:
AdjList :  vzero_1 b_1
degree : 2
Alias :None
Color : null
Priority : 0
------
========func move List Info ========
coalesced moves:
------
constrained moves:
------
fronzen moves:
------
workList moves:
va0_1 = move t_2
a_1 = move va0_1
t_2 = move t_1
b_1 = move va1_1
------
active moves:
========func Node List Info ========
simplify Nodes(low degree non move related):

------
freeze Nodes(low degree move related):
t_1(0) b_1(0) t_2(0) a_1(0) 
------
spill Nodes(high degree):

------
spilled Nodes:

------
coalesced Nodes:

------
colored Nodes:

------
selected Stack:
saved.vs8_1(0) saved.vs2_1(0) saved.vs7_1(0) saved.vs3_1(0) saved.vs1_1(0) saved.vs11_1(0) saved.vs4_1(0) saved.vs9_1(0) saved.vs10_1(0) saved.vs6_1(0) saved.vs5_1(0) 
------

===================== Coalesce =====================
========func Graph Info ========
saved.vs8_1:
AdjList : 
degree : 0
Alias :None
Color : null
Priority : 0
------
t_1:
AdjList :  vzero_1
degree : 1
Alias :None
Color : null
Priority : 0
------
saved.vs4_1:
AdjList : 
degree : 0
Alias :None
Color : null
Priority : 0
------
saved.vs9_1:
AdjList : 
degree : 0
Alias :None
Color : null
Priority : 0
------
saved.vs3_1:
AdjList : 
degree : 0
Alias :None
Color : null
Priority : 0
------
saved.vs10_1:
AdjList : 
degree : 0
Alias :None
Color : null
Priority : 0
------
t_2:
AdjList :  vzero_1
degree : 1
Alias :va0_1
Color : null
Priority : 0
------
saved.vs5_1:
AdjList : 
degree : 0
Alias :None
Color : null
Priority : 0
------
saved.vs7_1:
AdjList : 
degree : 0
Alias :None
Color : null
Priority : 0
------
saved.vs1_1:
AdjList : 
degree : 0
Alias :None
Color : null
Priority : 0
------
saved.vs6_1:
AdjList : 
degree : 0
Alias :None
Color : null
Priority : 0
------
saved.vs2_1:
AdjList : 
degree : 0
Alias :None
Color : null
Priority : 0
------
b_1:
AdjList :  vzero_1 a_1 va0_1
degree : 3
Alias :None
Color : null
Priority : 0
------
saved.vs11_1:
AdjList : 
degree : 0
Alias :None
Color : null
Priority : 0
------
a_1:
AdjList :  vzero_1 b_1
degree : 2
Alias :None
Color : null
Priority : 0
------
========func move List Info ========
coalesced moves:
va0_1 = move t_2
------
constrained moves:
------
fronzen moves:
------
workList moves:
a_1 = move va0_1
t_2 = move t_1
b_1 = move va1_1
------
active moves:
========func Node List Info ========
simplify Nodes(low degree non move related):

------
freeze Nodes(low degree move related):
t_1(0) b_1(0) a_1(0) 
------
spill Nodes(high degree):

------
spilled Nodes:

------
coalesced Nodes:
t_2(0) 
------
colored Nodes:

------
selected Stack:
saved.vs8_1(0) saved.vs2_1(0) saved.vs7_1(0) saved.vs3_1(0) saved.vs1_1(0) saved.vs11_1(0) saved.vs4_1(0) saved.vs9_1(0) saved.vs10_1(0) saved.vs6_1(0) saved.vs5_1(0) 
------

===================== Coalesce =====================
========func Graph Info ========
saved.vs8_1:
AdjList : 
degree : 0
Alias :None
Color : null
Priority : 0
------
t_1:
AdjList :  vzero_1
degree : 1
Alias :None
Color : null
Priority : 0
------
saved.vs4_1:
AdjList : 
degree : 0
Alias :None
Color : null
Priority : 0
------
saved.vs9_1:
AdjList : 
degree : 0
Alias :None
Color : null
Priority : 0
------
saved.vs3_1:
AdjList : 
degree : 0
Alias :None
Color : null
Priority : 0
------
saved.vs10_1:
AdjList : 
degree : 0
Alias :None
Color : null
Priority : 0
------
t_2:
AdjList :  vzero_1
degree : 1
Alias :va0_1
Color : null
Priority : 0
------
saved.vs5_1:
AdjList : 
degree : 0
Alias :None
Color : null
Priority : 0
------
saved.vs7_1:
AdjList : 
degree : 0
Alias :None
Color : null
Priority : 0
------
saved.vs1_1:
AdjList : 
degree : 0
Alias :None
Color : null
Priority : 0
------
saved.vs6_1:
AdjList : 
degree : 0
Alias :None
Color : null
Priority : 0
------
saved.vs2_1:
AdjList : 
degree : 0
Alias :None
Color : null
Priority : 0
------
b_1:
AdjList :  vzero_1 a_1 va0_1
degree : 2
Alias :None
Color : null
Priority : 0
------
saved.vs11_1:
AdjList : 
degree : 0
Alias :None
Color : null
Priority : 0
------
a_1:
AdjList :  vzero_1 b_1
degree : 2
Alias :va0_1
Color : null
Priority : 0
------
========func move List Info ========
coalesced moves:
va0_1 = move t_2
a_1 = move va0_1
------
constrained moves:
------
fronzen moves:
------
workList moves:
t_2 = move t_1
b_1 = move va1_1
------
active moves:
========func Node List Info ========
simplify Nodes(low degree non move related):

------
freeze Nodes(low degree move related):
t_1(0) b_1(0) 
------
spill Nodes(high degree):

------
spilled Nodes:

------
coalesced Nodes:
t_2(0) a_1(0) 
------
colored Nodes:

------
selected Stack:
saved.vs8_1(0) saved.vs2_1(0) saved.vs7_1(0) saved.vs3_1(0) saved.vs1_1(0) saved.vs11_1(0) saved.vs4_1(0) saved.vs9_1(0) saved.vs10_1(0) saved.vs6_1(0) saved.vs5_1(0) 
------

===================== Coalesce =====================
========func Graph Info ========
saved.vs8_1:
AdjList : 
degree : 0
Alias :None
Color : null
Priority : 0
------
t_1:
AdjList :  vzero_1
degree : 1
Alias :va0_1
Color : null
Priority : 0
------
saved.vs4_1:
AdjList : 
degree : 0
Alias :None
Color : null
Priority : 0
------
saved.vs9_1:
AdjList : 
degree : 0
Alias :None
Color : null
Priority : 0
------
saved.vs3_1:
AdjList : 
degree : 0
Alias :None
Color : null
Priority : 0
------
saved.vs10_1:
AdjList : 
degree : 0
Alias :None
Color : null
Priority : 0
------
t_2:
AdjList :  vzero_1
degree : 1
Alias :va0_1
Color : null
Priority : 0
------
saved.vs5_1:
AdjList : 
degree : 0
Alias :None
Color : null
Priority : 0
------
saved.vs7_1:
AdjList : 
degree : 0
Alias :None
Color : null
Priority : 0
------
saved.vs1_1:
AdjList : 
degree : 0
Alias :None
Color : null
Priority : 0
------
saved.vs6_1:
AdjList : 
degree : 0
Alias :None
Color : null
Priority : 0
------
saved.vs2_1:
AdjList : 
degree : 0
Alias :None
Color : null
Priority : 0
------
b_1:
AdjList :  vzero_1 a_1 va0_1
degree : 2
Alias :None
Color : null
Priority : 0
------
saved.vs11_1:
AdjList : 
degree : 0
Alias :None
Color : null
Priority : 0
------
a_1:
AdjList :  vzero_1 b_1
degree : 2
Alias :va0_1
Color : null
Priority : 0
------
========func move List Info ========
coalesced moves:
va0_1 = move t_2
a_1 = move va0_1
t_2 = move t_1
------
constrained moves:
------
fronzen moves:
------
workList moves:
b_1 = move va1_1
------
active moves:
========func Node List Info ========
simplify Nodes(low degree non move related):

------
freeze Nodes(low degree move related):
b_1(0) 
------
spill Nodes(high degree):

------
spilled Nodes:

------
coalesced Nodes:
t_1(0) t_2(0) a_1(0) 
------
colored Nodes:

------
selected Stack:
saved.vs8_1(0) saved.vs2_1(0) saved.vs7_1(0) saved.vs3_1(0) saved.vs1_1(0) saved.vs11_1(0) saved.vs4_1(0) saved.vs9_1(0) saved.vs10_1(0) saved.vs6_1(0) saved.vs5_1(0) 
------

===================== Coalesce =====================
========func Graph Info ========
saved.vs8_1:
AdjList : 
degree : 0
Alias :None
Color : null
Priority : 0
------
t_1:
AdjList :  vzero_1
degree : 1
Alias :va0_1
Color : null
Priority : 0
------
saved.vs4_1:
AdjList : 
degree : 0
Alias :None
Color : null
Priority : 0
------
saved.vs9_1:
AdjList : 
degree : 0
Alias :None
Color : null
Priority : 0
------
saved.vs3_1:
AdjList : 
degree : 0
Alias :None
Color : null
Priority : 0
------
saved.vs10_1:
AdjList : 
degree : 0
Alias :None
Color : null
Priority : 0
------
t_2:
AdjList :  vzero_1
degree : 1
Alias :va0_1
Color : null
Priority : 0
------
saved.vs5_1:
AdjList : 
degree : 0
Alias :None
Color : null
Priority : 0
------
saved.vs7_1:
AdjList : 
degree : 0
Alias :None
Color : null
Priority : 0
------
saved.vs1_1:
AdjList : 
degree : 0
Alias :None
Color : null
Priority : 0
------
saved.vs6_1:
AdjList : 
degree : 0
Alias :None
Color : null
Priority : 0
------
saved.vs2_1:
AdjList : 
degree : 0
Alias :None
Color : null
Priority : 0
------
b_1:
AdjList :  vzero_1 a_1 va0_1
degree : 2
Alias :va1_1
Color : null
Priority : 0
------
saved.vs11_1:
AdjList : 
degree : 0
Alias :None
Color : null
Priority : 0
------
a_1:
AdjList :  vzero_1 b_1
degree : 2
Alias :va0_1
Color : null
Priority : 0
------
========func move List Info ========
coalesced moves:
va0_1 = move t_2
a_1 = move va0_1
t_2 = move t_1
b_1 = move va1_1
------
constrained moves:
------
fronzen moves:
------
workList moves:
------
active moves:
========func Node List Info ========
simplify Nodes(low degree non move related):

------
freeze Nodes(low degree move related):

------
spill Nodes(high degree):

------
spilled Nodes:

------
coalesced Nodes:
t_1(0) b_1(0) t_2(0) a_1(0) 
------
colored Nodes:

------
selected Stack:
saved.vs8_1(0) saved.vs2_1(0) saved.vs7_1(0) saved.vs3_1(0) saved.vs1_1(0) saved.vs11_1(0) saved.vs4_1(0) saved.vs9_1(0) saved.vs10_1(0) saved.vs6_1(0) saved.vs5_1(0) 
------

===================== after ASSIGN =====================
========func Graph Info ========
saved.vs8_1:
AdjList : 
degree : 0
Alias :None
Color : s11
Priority : 0
------
t_1:
AdjList :  vzero_1
degree : 1
Alias :va0_1
Color : a0
Priority : 0
------
saved.vs4_1:
AdjList : 
degree : 0
Alias :None
Color : s11
Priority : 0
------
saved.vs9_1:
AdjList : 
degree : 0
Alias :None
Color : s11
Priority : 0
------
saved.vs3_1:
AdjList : 
degree : 0
Alias :None
Color : s11
Priority : 0
------
saved.vs10_1:
AdjList : 
degree : 0
Alias :None
Color : s11
Priority : 0
------
t_2:
AdjList :  vzero_1
degree : 1
Alias :va0_1
Color : a0
Priority : 0
------
saved.vs5_1:
AdjList : 
degree : 0
Alias :None
Color : s11
Priority : 0
------
saved.vs7_1:
AdjList : 
degree : 0
Alias :None
Color : s11
Priority : 0
------
saved.vs1_1:
AdjList : 
degree : 0
Alias :None
Color : s11
Priority : 0
------
saved.vs6_1:
AdjList : 
degree : 0
Alias :None
Color : s11
Priority : 0
------
saved.vs2_1:
AdjList : 
degree : 0
Alias :None
Color : s11
Priority : 0
------
b_1:
AdjList :  vzero_1 a_1 va0_1
degree : 2
Alias :va1_1
Color : a1
Priority : 0
------
saved.vs11_1:
AdjList : 
degree : 0
Alias :None
Color : s11
Priority : 0
------
a_1:
AdjList :  vzero_1 b_1
degree : 2
Alias :va0_1
Color : a0
Priority : 0
------
========func move List Info ========
coalesced moves:
va0_1 = move t_2
a_1 = move va0_1
t_2 = move t_1
b_1 = move va1_1
------
constrained moves:
------
fronzen moves:
------
workList moves:
------
active moves:
========func Node List Info ========
simplify Nodes(low degree non move related):

------
freeze Nodes(low degree move related):

------
spill Nodes(high degree):

------
spilled Nodes:

------
coalesced Nodes:
t_1(0) b_1(0) t_2(0) a_1(0) 
------
colored Nodes:
saved.vs8_1(0) saved.vs2_1(0) saved.vs7_1(0) saved.vs3_1(0) saved.vs11_1(0) saved.vs1_1(0) saved.vs6_1(0) saved.vs10_1(0) saved.vs9_1(0) saved.vs4_1(0) saved.vs5_1(0) 
------
selected Stack:

------

=====================main Iteration 0=====================
========main Graph Info ========
saved.vs6_2:
AdjList : 
degree : 0
Alias :None
Color : null
Priority : 0
------
saved.vs4_2:
AdjList : 
degree : 0
Alias :None
Color : null
Priority : 0
------
saved.vs2_2:
AdjList : 
degree : 0
Alias :None
Color : null
Priority : 0
------
t_4:
AdjList :  vzero_1
degree : 1
Alias :None
Color : null
Priority : 0
------
saved.vs1_2:
AdjList : 
degree : 0
Alias :None
Color : null
Priority : 0
------
saved.vs11_2:
AdjList : 
degree : 0
Alias :None
Color : null
Priority : 0
------
saved.vs9_2:
AdjList : 
degree : 0
Alias :None
Color : null
Priority : 0
------
c_1:
AdjList :  vzero_1 b_2 va0_1
degree : 3
Alias :None
Color : null
Priority : 0
------
saved.vs5_2:
AdjList : 
degree : 0
Alias :None
Color : null
Priority : 0
------
saved.vs8_2:
AdjList : 
degree : 0
Alias :None
Color : null
Priority : 0
------
t_3:
AdjList :  vzero_1
degree : 1
Alias :None
Color : null
Priority : 0
------
b_2:
AdjList :  c_1 vzero_1
degree : 2
Alias :None
Color : null
Priority : 0
------
saved.vs3_2:
AdjList : 
degree : 0
Alias :None
Color : null
Priority : 0
------
saved.vs7_2:
AdjList : 
degree : 0
Alias :None
Color : null
Priority : 0
------
saved.vs10_2:
AdjList : 
degree : 0
Alias :None
Color : null
Priority : 0
------
========main move List Info ========
coalesced moves:
------
constrained moves:
------
fronzen moves:
------
workList moves:
t_4 = move t_3
va1_1 = move c_1
t_3 = move va0_1
va0_1 = move t_4
va0_1 = move b_2
------
active moves:
========main Node List Info ========
simplify Nodes(low degree non move related):
saved.vs2_2(0) saved.vs1_2(0) saved.vs6_2(0) saved.vs5_2(0) saved.vs8_2(0) saved.vs4_2(0) saved.vs11_2(0) saved.vs3_2(0) saved.vs7_2(0) saved.vs10_2(0) saved.vs9_2(0) 
------
freeze Nodes(low degree move related):
c_1(0) t_4(0) t_3(0) b_2(0) 
------
spill Nodes(high degree):

------
spilled Nodes:

------
coalesced Nodes:

------
colored Nodes:

------
selected Stack:

------

define i64 @func  %a_1 %b_1 {
func_entry_1:
   %b_1 = move %va1_1
   %a_1 = move %va0_1
   %t_1 = add %a_1 %b_1
   %t_2 = move %t_1
   %va0_1 = move %t_2
   ret %va0_1
}

define i64 @main  {
main_entry_1:
   %b_2 = move 3
   %c_1 = move 4
   %va0_1 = move %b_2
   %va1_1 = move %c_1
   %va0_1 = call func %va0_1 %va1_1 
   %t_3 = move %va0_1
   %t_4 = move %t_3
   %va0_1 = move %t_4
   ret %va0_1
}

define i64 @__init  {
__init_entry_1:
   %saved.vs4_3 = move %vs4_1
   %saved.vs7_3 = move %vs7_1
   %saved.vs5_3 = move %vs5_1
   %saved.vs6_3 = move %vs6_1
   %saved.vs2_3 = move %vs2_1
   %saved.vs1_3 = move %vs1_1
   %saved.vs8_3 = move %vs8_1
   %saved.vs11_3 = move %vs11_1
   %saved.vs9_3 = move %vs9_1
   %saved.vs10_3 = move %vs10_1
   %saved.vs3_3 = move %vs3_1
   %va0_1 = call main 
   %t_5 = move %va0_1
   %t_6 = move %t_5
   %vs3_1 = move %saved.vs3_3
   %vs10_1 = move %saved.vs10_3
   %vs9_1 = move %saved.vs9_3
   %vs11_1 = move %saved.vs11_3
   %vs8_1 = move %saved.vs8_3
   %vs1_1 = move %saved.vs1_3
   %vs2_1 = move %saved.vs2_3
   %vs6_1 = move %saved.vs6_3
   %vs5_1 = move %saved.vs5_3
   %vs7_1 = move %saved.vs7_3
   %vs4_1 = move %saved.vs4_3
   %va0_1 = move %t_6
   ret %va0_1
}

===================== Simplify =====================
========main Graph Info ========
saved.vs6_2:
AdjList : 
degree : 0
Alias :None
Color : null
Priority : 0
------
saved.vs4_2:
AdjList : 
degree : 0
Alias :None
Color : null
Priority : 0
------
saved.vs2_2:
AdjList : 
degree : 0
Alias :None
Color : null
Priority : 0
------
t_4:
AdjList :  vzero_1
degree : 1
Alias :None
Color : null
Priority : 0
------
saved.vs1_2:
AdjList : 
degree : 0
Alias :None
Color : null
Priority : 0
------
saved.vs11_2:
AdjList : 
degree : 0
Alias :None
Color : null
Priority : 0
------
saved.vs9_2:
AdjList : 
degree : 0
Alias :None
Color : null
Priority : 0
------
c_1:
AdjList :  vzero_1 b_2 va0_1
degree : 3
Alias :None
Color : null
Priority : 0
------
saved.vs5_2:
AdjList : 
degree : 0
Alias :None
Color : null
Priority : 0
------
saved.vs8_2:
AdjList : 
degree : 0
Alias :None
Color : null
Priority : 0
------
t_3:
AdjList :  vzero_1
degree : 1
Alias :None
Color : null
Priority : 0
------
b_2:
AdjList :  c_1 vzero_1
degree : 2
Alias :None
Color : null
Priority : 0
------
saved.vs3_2:
AdjList : 
degree : 0
Alias :None
Color : null
Priority : 0
------
saved.vs7_2:
AdjList : 
degree : 0
Alias :None
Color : null
Priority : 0
------
saved.vs10_2:
AdjList : 
degree : 0
Alias :None
Color : null
Priority : 0
------
========main move List Info ========
coalesced moves:
------
constrained moves:
------
fronzen moves:
------
workList moves:
t_4 = move t_3
va1_1 = move c_1
t_3 = move va0_1
va0_1 = move t_4
va0_1 = move b_2
------
active moves:
========main Node List Info ========
simplify Nodes(low degree non move related):
saved.vs1_2(0) saved.vs6_2(0) saved.vs5_2(0) saved.vs8_2(0) saved.vs4_2(0) saved.vs11_2(0) saved.vs3_2(0) saved.vs7_2(0) saved.vs10_2(0) saved.vs9_2(0) 
------
freeze Nodes(low degree move related):
c_1(0) t_4(0) t_3(0) b_2(0) 
------
spill Nodes(high degree):

------
spilled Nodes:

------
coalesced Nodes:

------
colored Nodes:

------
selected Stack:
saved.vs2_2(0) 
------

===================== Simplify =====================
========main Graph Info ========
saved.vs6_2:
AdjList : 
degree : 0
Alias :None
Color : null
Priority : 0
------
saved.vs4_2:
AdjList : 
degree : 0
Alias :None
Color : null
Priority : 0
------
saved.vs2_2:
AdjList : 
degree : 0
Alias :None
Color : null
Priority : 0
------
t_4:
AdjList :  vzero_1
degree : 1
Alias :None
Color : null
Priority : 0
------
saved.vs1_2:
AdjList : 
degree : 0
Alias :None
Color : null
Priority : 0
------
saved.vs11_2:
AdjList : 
degree : 0
Alias :None
Color : null
Priority : 0
------
saved.vs9_2:
AdjList : 
degree : 0
Alias :None
Color : null
Priority : 0
------
c_1:
AdjList :  vzero_1 b_2 va0_1
degree : 3
Alias :None
Color : null
Priority : 0
------
saved.vs5_2:
AdjList : 
degree : 0
Alias :None
Color : null
Priority : 0
------
saved.vs8_2:
AdjList : 
degree : 0
Alias :None
Color : null
Priority : 0
------
t_3:
AdjList :  vzero_1
degree : 1
Alias :None
Color : null
Priority : 0
------
b_2:
AdjList :  c_1 vzero_1
degree : 2
Alias :None
Color : null
Priority : 0
------
saved.vs3_2:
AdjList : 
degree : 0
Alias :None
Color : null
Priority : 0
------
saved.vs7_2:
AdjList : 
degree : 0
Alias :None
Color : null
Priority : 0
------
saved.vs10_2:
AdjList : 
degree : 0
Alias :None
Color : null
Priority : 0
------
========main move List Info ========
coalesced moves:
------
constrained moves:
------
fronzen moves:
------
workList moves:
t_4 = move t_3
va1_1 = move c_1
t_3 = move va0_1
va0_1 = move t_4
va0_1 = move b_2
------
active moves:
========main Node List Info ========
simplify Nodes(low degree non move related):
saved.vs6_2(0) saved.vs5_2(0) saved.vs8_2(0) saved.vs4_2(0) saved.vs11_2(0) saved.vs3_2(0) saved.vs7_2(0) saved.vs10_2(0) saved.vs9_2(0) 
------
freeze Nodes(low degree move related):
c_1(0) t_4(0) t_3(0) b_2(0) 
------
spill Nodes(high degree):

------
spilled Nodes:

------
coalesced Nodes:

------
colored Nodes:

------
selected Stack:
saved.vs2_2(0) saved.vs1_2(0) 
------

===================== Simplify =====================
========main Graph Info ========
saved.vs6_2:
AdjList : 
degree : 0
Alias :None
Color : null
Priority : 0
------
saved.vs4_2:
AdjList : 
degree : 0
Alias :None
Color : null
Priority : 0
------
saved.vs2_2:
AdjList : 
degree : 0
Alias :None
Color : null
Priority : 0
------
t_4:
AdjList :  vzero_1
degree : 1
Alias :None
Color : null
Priority : 0
------
saved.vs1_2:
AdjList : 
degree : 0
Alias :None
Color : null
Priority : 0
------
saved.vs11_2:
AdjList : 
degree : 0
Alias :None
Color : null
Priority : 0
------
saved.vs9_2:
AdjList : 
degree : 0
Alias :None
Color : null
Priority : 0
------
c_1:
AdjList :  vzero_1 b_2 va0_1
degree : 3
Alias :None
Color : null
Priority : 0
------
saved.vs5_2:
AdjList : 
degree : 0
Alias :None
Color : null
Priority : 0
------
saved.vs8_2:
AdjList : 
degree : 0
Alias :None
Color : null
Priority : 0
------
t_3:
AdjList :  vzero_1
degree : 1
Alias :None
Color : null
Priority : 0
------
b_2:
AdjList :  c_1 vzero_1
degree : 2
Alias :None
Color : null
Priority : 0
------
saved.vs3_2:
AdjList : 
degree : 0
Alias :None
Color : null
Priority : 0
------
saved.vs7_2:
AdjList : 
degree : 0
Alias :None
Color : null
Priority : 0
------
saved.vs10_2:
AdjList : 
degree : 0
Alias :None
Color : null
Priority : 0
------
========main move List Info ========
coalesced moves:
------
constrained moves:
------
fronzen moves:
------
workList moves:
t_4 = move t_3
va1_1 = move c_1
t_3 = move va0_1
va0_1 = move t_4
va0_1 = move b_2
------
active moves:
========main Node List Info ========
simplify Nodes(low degree non move related):
saved.vs5_2(0) saved.vs8_2(0) saved.vs4_2(0) saved.vs11_2(0) saved.vs3_2(0) saved.vs7_2(0) saved.vs10_2(0) saved.vs9_2(0) 
------
freeze Nodes(low degree move related):
c_1(0) t_4(0) t_3(0) b_2(0) 
------
spill Nodes(high degree):

------
spilled Nodes:

------
coalesced Nodes:

------
colored Nodes:

------
selected Stack:
saved.vs2_2(0) saved.vs1_2(0) saved.vs6_2(0) 
------

===================== Simplify =====================
========main Graph Info ========
saved.vs6_2:
AdjList : 
degree : 0
Alias :None
Color : null
Priority : 0
------
saved.vs4_2:
AdjList : 
degree : 0
Alias :None
Color : null
Priority : 0
------
saved.vs2_2:
AdjList : 
degree : 0
Alias :None
Color : null
Priority : 0
------
t_4:
AdjList :  vzero_1
degree : 1
Alias :None
Color : null
Priority : 0
------
saved.vs1_2:
AdjList : 
degree : 0
Alias :None
Color : null
Priority : 0
------
saved.vs11_2:
AdjList : 
degree : 0
Alias :None
Color : null
Priority : 0
------
saved.vs9_2:
AdjList : 
degree : 0
Alias :None
Color : null
Priority : 0
------
c_1:
AdjList :  vzero_1 b_2 va0_1
degree : 3
Alias :None
Color : null
Priority : 0
------
saved.vs5_2:
AdjList : 
degree : 0
Alias :None
Color : null
Priority : 0
------
saved.vs8_2:
AdjList : 
degree : 0
Alias :None
Color : null
Priority : 0
------
t_3:
AdjList :  vzero_1
degree : 1
Alias :None
Color : null
Priority : 0
------
b_2:
AdjList :  c_1 vzero_1
degree : 2
Alias :None
Color : null
Priority : 0
------
saved.vs3_2:
AdjList : 
degree : 0
Alias :None
Color : null
Priority : 0
------
saved.vs7_2:
AdjList : 
degree : 0
Alias :None
Color : null
Priority : 0
------
saved.vs10_2:
AdjList : 
degree : 0
Alias :None
Color : null
Priority : 0
------
========main move List Info ========
coalesced moves:
------
constrained moves:
------
fronzen moves:
------
workList moves:
t_4 = move t_3
va1_1 = move c_1
t_3 = move va0_1
va0_1 = move t_4
va0_1 = move b_2
------
active moves:
========main Node List Info ========
simplify Nodes(low degree non move related):
saved.vs8_2(0) saved.vs4_2(0) saved.vs11_2(0) saved.vs3_2(0) saved.vs7_2(0) saved.vs10_2(0) saved.vs9_2(0) 
------
freeze Nodes(low degree move related):
c_1(0) t_4(0) t_3(0) b_2(0) 
------
spill Nodes(high degree):

------
spilled Nodes:

------
coalesced Nodes:

------
colored Nodes:

------
selected Stack:
saved.vs2_2(0) saved.vs1_2(0) saved.vs6_2(0) saved.vs5_2(0) 
------

===================== Simplify =====================
========main Graph Info ========
saved.vs6_2:
AdjList : 
degree : 0
Alias :None
Color : null
Priority : 0
------
saved.vs4_2:
AdjList : 
degree : 0
Alias :None
Color : null
Priority : 0
------
saved.vs2_2:
AdjList : 
degree : 0
Alias :None
Color : null
Priority : 0
------
t_4:
AdjList :  vzero_1
degree : 1
Alias :None
Color : null
Priority : 0
------
saved.vs1_2:
AdjList : 
degree : 0
Alias :None
Color : null
Priority : 0
------
saved.vs11_2:
AdjList : 
degree : 0
Alias :None
Color : null
Priority : 0
------
saved.vs9_2:
AdjList : 
degree : 0
Alias :None
Color : null
Priority : 0
------
c_1:
AdjList :  vzero_1 b_2 va0_1
degree : 3
Alias :None
Color : null
Priority : 0
------
saved.vs5_2:
AdjList : 
degree : 0
Alias :None
Color : null
Priority : 0
------
saved.vs8_2:
AdjList : 
degree : 0
Alias :None
Color : null
Priority : 0
------
t_3:
AdjList :  vzero_1
degree : 1
Alias :None
Color : null
Priority : 0
------
b_2:
AdjList :  c_1 vzero_1
degree : 2
Alias :None
Color : null
Priority : 0
------
saved.vs3_2:
AdjList : 
degree : 0
Alias :None
Color : null
Priority : 0
------
saved.vs7_2:
AdjList : 
degree : 0
Alias :None
Color : null
Priority : 0
------
saved.vs10_2:
AdjList : 
degree : 0
Alias :None
Color : null
Priority : 0
------
========main move List Info ========
coalesced moves:
------
constrained moves:
------
fronzen moves:
------
workList moves:
t_4 = move t_3
va1_1 = move c_1
t_3 = move va0_1
va0_1 = move t_4
va0_1 = move b_2
------
active moves:
========main Node List Info ========
simplify Nodes(low degree non move related):
saved.vs4_2(0) saved.vs11_2(0) saved.vs3_2(0) saved.vs7_2(0) saved.vs10_2(0) saved.vs9_2(0) 
------
freeze Nodes(low degree move related):
c_1(0) t_4(0) t_3(0) b_2(0) 
------
spill Nodes(high degree):

------
spilled Nodes:

------
coalesced Nodes:

------
colored Nodes:

------
selected Stack:
saved.vs2_2(0) saved.vs1_2(0) saved.vs6_2(0) saved.vs5_2(0) saved.vs8_2(0) 
------

===================== Simplify =====================
========main Graph Info ========
saved.vs6_2:
AdjList : 
degree : 0
Alias :None
Color : null
Priority : 0
------
saved.vs4_2:
AdjList : 
degree : 0
Alias :None
Color : null
Priority : 0
------
saved.vs2_2:
AdjList : 
degree : 0
Alias :None
Color : null
Priority : 0
------
t_4:
AdjList :  vzero_1
degree : 1
Alias :None
Color : null
Priority : 0
------
saved.vs1_2:
AdjList : 
degree : 0
Alias :None
Color : null
Priority : 0
------
saved.vs11_2:
AdjList : 
degree : 0
Alias :None
Color : null
Priority : 0
------
saved.vs9_2:
AdjList : 
degree : 0
Alias :None
Color : null
Priority : 0
------
c_1:
AdjList :  vzero_1 b_2 va0_1
degree : 3
Alias :None
Color : null
Priority : 0
------
saved.vs5_2:
AdjList : 
degree : 0
Alias :None
Color : null
Priority : 0
------
saved.vs8_2:
AdjList : 
degree : 0
Alias :None
Color : null
Priority : 0
------
t_3:
AdjList :  vzero_1
degree : 1
Alias :None
Color : null
Priority : 0
------
b_2:
AdjList :  c_1 vzero_1
degree : 2
Alias :None
Color : null
Priority : 0
------
saved.vs3_2:
AdjList : 
degree : 0
Alias :None
Color : null
Priority : 0
------
saved.vs7_2:
AdjList : 
degree : 0
Alias :None
Color : null
Priority : 0
------
saved.vs10_2:
AdjList : 
degree : 0
Alias :None
Color : null
Priority : 0
------
========main move List Info ========
coalesced moves:
------
constrained moves:
------
fronzen moves:
------
workList moves:
t_4 = move t_3
va1_1 = move c_1
t_3 = move va0_1
va0_1 = move t_4
va0_1 = move b_2
------
active moves:
========main Node List Info ========
simplify Nodes(low degree non move related):
saved.vs11_2(0) saved.vs3_2(0) saved.vs7_2(0) saved.vs10_2(0) saved.vs9_2(0) 
------
freeze Nodes(low degree move related):
c_1(0) t_4(0) t_3(0) b_2(0) 
------
spill Nodes(high degree):

------
spilled Nodes:

------
coalesced Nodes:

------
colored Nodes:

------
selected Stack:
saved.vs2_2(0) saved.vs1_2(0) saved.vs6_2(0) saved.vs5_2(0) saved.vs8_2(0) saved.vs4_2(0) 
------

===================== Simplify =====================
========main Graph Info ========
saved.vs6_2:
AdjList : 
degree : 0
Alias :None
Color : null
Priority : 0
------
saved.vs4_2:
AdjList : 
degree : 0
Alias :None
Color : null
Priority : 0
------
saved.vs2_2:
AdjList : 
degree : 0
Alias :None
Color : null
Priority : 0
------
t_4:
AdjList :  vzero_1
degree : 1
Alias :None
Color : null
Priority : 0
------
saved.vs1_2:
AdjList : 
degree : 0
Alias :None
Color : null
Priority : 0
------
saved.vs11_2:
AdjList : 
degree : 0
Alias :None
Color : null
Priority : 0
------
saved.vs9_2:
AdjList : 
degree : 0
Alias :None
Color : null
Priority : 0
------
c_1:
AdjList :  vzero_1 b_2 va0_1
degree : 3
Alias :None
Color : null
Priority : 0
------
saved.vs5_2:
AdjList : 
degree : 0
Alias :None
Color : null
Priority : 0
------
saved.vs8_2:
AdjList : 
degree : 0
Alias :None
Color : null
Priority : 0
------
t_3:
AdjList :  vzero_1
degree : 1
Alias :None
Color : null
Priority : 0
------
b_2:
AdjList :  c_1 vzero_1
degree : 2
Alias :None
Color : null
Priority : 0
------
saved.vs3_2:
AdjList : 
degree : 0
Alias :None
Color : null
Priority : 0
------
saved.vs7_2:
AdjList : 
degree : 0
Alias :None
Color : null
Priority : 0
------
saved.vs10_2:
AdjList : 
degree : 0
Alias :None
Color : null
Priority : 0
------
========main move List Info ========
coalesced moves:
------
constrained moves:
------
fronzen moves:
------
workList moves:
t_4 = move t_3
va1_1 = move c_1
t_3 = move va0_1
va0_1 = move t_4
va0_1 = move b_2
------
active moves:
========main Node List Info ========
simplify Nodes(low degree non move related):
saved.vs3_2(0) saved.vs7_2(0) saved.vs10_2(0) saved.vs9_2(0) 
------
freeze Nodes(low degree move related):
c_1(0) t_4(0) t_3(0) b_2(0) 
------
spill Nodes(high degree):

------
spilled Nodes:

------
coalesced Nodes:

------
colored Nodes:

------
selected Stack:
saved.vs2_2(0) saved.vs1_2(0) saved.vs6_2(0) saved.vs5_2(0) saved.vs8_2(0) saved.vs4_2(0) saved.vs11_2(0) 
------

===================== Simplify =====================
========main Graph Info ========
saved.vs6_2:
AdjList : 
degree : 0
Alias :None
Color : null
Priority : 0
------
saved.vs4_2:
AdjList : 
degree : 0
Alias :None
Color : null
Priority : 0
------
saved.vs2_2:
AdjList : 
degree : 0
Alias :None
Color : null
Priority : 0
------
t_4:
AdjList :  vzero_1
degree : 1
Alias :None
Color : null
Priority : 0
------
saved.vs1_2:
AdjList : 
degree : 0
Alias :None
Color : null
Priority : 0
------
saved.vs11_2:
AdjList : 
degree : 0
Alias :None
Color : null
Priority : 0
------
saved.vs9_2:
AdjList : 
degree : 0
Alias :None
Color : null
Priority : 0
------
c_1:
AdjList :  vzero_1 b_2 va0_1
degree : 3
Alias :None
Color : null
Priority : 0
------
saved.vs5_2:
AdjList : 
degree : 0
Alias :None
Color : null
Priority : 0
------
saved.vs8_2:
AdjList : 
degree : 0
Alias :None
Color : null
Priority : 0
------
t_3:
AdjList :  vzero_1
degree : 1
Alias :None
Color : null
Priority : 0
------
b_2:
AdjList :  c_1 vzero_1
degree : 2
Alias :None
Color : null
Priority : 0
------
saved.vs3_2:
AdjList : 
degree : 0
Alias :None
Color : null
Priority : 0
------
saved.vs7_2:
AdjList : 
degree : 0
Alias :None
Color : null
Priority : 0
------
saved.vs10_2:
AdjList : 
degree : 0
Alias :None
Color : null
Priority : 0
------
========main move List Info ========
coalesced moves:
------
constrained moves:
------
fronzen moves:
------
workList moves:
t_4 = move t_3
va1_1 = move c_1
t_3 = move va0_1
va0_1 = move t_4
va0_1 = move b_2
------
active moves:
========main Node List Info ========
simplify Nodes(low degree non move related):
saved.vs7_2(0) saved.vs10_2(0) saved.vs9_2(0) 
------
freeze Nodes(low degree move related):
c_1(0) t_4(0) t_3(0) b_2(0) 
------
spill Nodes(high degree):

------
spilled Nodes:

------
coalesced Nodes:

------
colored Nodes:

------
selected Stack:
saved.vs2_2(0) saved.vs1_2(0) saved.vs6_2(0) saved.vs5_2(0) saved.vs8_2(0) saved.vs4_2(0) saved.vs11_2(0) saved.vs3_2(0) 
------

===================== Simplify =====================
========main Graph Info ========
saved.vs6_2:
AdjList : 
degree : 0
Alias :None
Color : null
Priority : 0
------
saved.vs4_2:
AdjList : 
degree : 0
Alias :None
Color : null
Priority : 0
------
saved.vs2_2:
AdjList : 
degree : 0
Alias :None
Color : null
Priority : 0
------
t_4:
AdjList :  vzero_1
degree : 1
Alias :None
Color : null
Priority : 0
------
saved.vs1_2:
AdjList : 
degree : 0
Alias :None
Color : null
Priority : 0
------
saved.vs11_2:
AdjList : 
degree : 0
Alias :None
Color : null
Priority : 0
------
saved.vs9_2:
AdjList : 
degree : 0
Alias :None
Color : null
Priority : 0
------
c_1:
AdjList :  vzero_1 b_2 va0_1
degree : 3
Alias :None
Color : null
Priority : 0
------
saved.vs5_2:
AdjList : 
degree : 0
Alias :None
Color : null
Priority : 0
------
saved.vs8_2:
AdjList : 
degree : 0
Alias :None
Color : null
Priority : 0
------
t_3:
AdjList :  vzero_1
degree : 1
Alias :None
Color : null
Priority : 0
------
b_2:
AdjList :  c_1 vzero_1
degree : 2
Alias :None
Color : null
Priority : 0
------
saved.vs3_2:
AdjList : 
degree : 0
Alias :None
Color : null
Priority : 0
------
saved.vs7_2:
AdjList : 
degree : 0
Alias :None
Color : null
Priority : 0
------
saved.vs10_2:
AdjList : 
degree : 0
Alias :None
Color : null
Priority : 0
------
========main move List Info ========
coalesced moves:
------
constrained moves:
------
fronzen moves:
------
workList moves:
t_4 = move t_3
va1_1 = move c_1
t_3 = move va0_1
va0_1 = move t_4
va0_1 = move b_2
------
active moves:
========main Node List Info ========
simplify Nodes(low degree non move related):
saved.vs10_2(0) saved.vs9_2(0) 
------
freeze Nodes(low degree move related):
c_1(0) t_4(0) t_3(0) b_2(0) 
------
spill Nodes(high degree):

------
spilled Nodes:

------
coalesced Nodes:

------
colored Nodes:

------
selected Stack:
saved.vs2_2(0) saved.vs1_2(0) saved.vs6_2(0) saved.vs5_2(0) saved.vs8_2(0) saved.vs4_2(0) saved.vs11_2(0) saved.vs3_2(0) saved.vs7_2(0) 
------

===================== Simplify =====================
========main Graph Info ========
saved.vs6_2:
AdjList : 
degree : 0
Alias :None
Color : null
Priority : 0
------
saved.vs4_2:
AdjList : 
degree : 0
Alias :None
Color : null
Priority : 0
------
saved.vs2_2:
AdjList : 
degree : 0
Alias :None
Color : null
Priority : 0
------
t_4:
AdjList :  vzero_1
degree : 1
Alias :None
Color : null
Priority : 0
------
saved.vs1_2:
AdjList : 
degree : 0
Alias :None
Color : null
Priority : 0
------
saved.vs11_2:
AdjList : 
degree : 0
Alias :None
Color : null
Priority : 0
------
saved.vs9_2:
AdjList : 
degree : 0
Alias :None
Color : null
Priority : 0
------
c_1:
AdjList :  vzero_1 b_2 va0_1
degree : 3
Alias :None
Color : null
Priority : 0
------
saved.vs5_2:
AdjList : 
degree : 0
Alias :None
Color : null
Priority : 0
------
saved.vs8_2:
AdjList : 
degree : 0
Alias :None
Color : null
Priority : 0
------
t_3:
AdjList :  vzero_1
degree : 1
Alias :None
Color : null
Priority : 0
------
b_2:
AdjList :  c_1 vzero_1
degree : 2
Alias :None
Color : null
Priority : 0
------
saved.vs3_2:
AdjList : 
degree : 0
Alias :None
Color : null
Priority : 0
------
saved.vs7_2:
AdjList : 
degree : 0
Alias :None
Color : null
Priority : 0
------
saved.vs10_2:
AdjList : 
degree : 0
Alias :None
Color : null
Priority : 0
------
========main move List Info ========
coalesced moves:
------
constrained moves:
------
fronzen moves:
------
workList moves:
t_4 = move t_3
va1_1 = move c_1
t_3 = move va0_1
va0_1 = move t_4
va0_1 = move b_2
------
active moves:
========main Node List Info ========
simplify Nodes(low degree non move related):
saved.vs9_2(0) 
------
freeze Nodes(low degree move related):
c_1(0) t_4(0) t_3(0) b_2(0) 
------
spill Nodes(high degree):

------
spilled Nodes:

------
coalesced Nodes:

------
colored Nodes:

------
selected Stack:
saved.vs2_2(0) saved.vs1_2(0) saved.vs6_2(0) saved.vs5_2(0) saved.vs8_2(0) saved.vs4_2(0) saved.vs11_2(0) saved.vs3_2(0) saved.vs7_2(0) saved.vs10_2(0) 
------

===================== Simplify =====================
========main Graph Info ========
saved.vs6_2:
AdjList : 
degree : 0
Alias :None
Color : null
Priority : 0
------
saved.vs4_2:
AdjList : 
degree : 0
Alias :None
Color : null
Priority : 0
------
saved.vs2_2:
AdjList : 
degree : 0
Alias :None
Color : null
Priority : 0
------
t_4:
AdjList :  vzero_1
degree : 1
Alias :None
Color : null
Priority : 0
------
saved.vs1_2:
AdjList : 
degree : 0
Alias :None
Color : null
Priority : 0
------
saved.vs11_2:
AdjList : 
degree : 0
Alias :None
Color : null
Priority : 0
------
saved.vs9_2:
AdjList : 
degree : 0
Alias :None
Color : null
Priority : 0
------
c_1:
AdjList :  vzero_1 b_2 va0_1
degree : 3
Alias :None
Color : null
Priority : 0
------
saved.vs5_2:
AdjList : 
degree : 0
Alias :None
Color : null
Priority : 0
------
saved.vs8_2:
AdjList : 
degree : 0
Alias :None
Color : null
Priority : 0
------
t_3:
AdjList :  vzero_1
degree : 1
Alias :None
Color : null
Priority : 0
------
b_2:
AdjList :  c_1 vzero_1
degree : 2
Alias :None
Color : null
Priority : 0
------
saved.vs3_2:
AdjList : 
degree : 0
Alias :None
Color : null
Priority : 0
------
saved.vs7_2:
AdjList : 
degree : 0
Alias :None
Color : null
Priority : 0
------
saved.vs10_2:
AdjList : 
degree : 0
Alias :None
Color : null
Priority : 0
------
========main move List Info ========
coalesced moves:
------
constrained moves:
------
fronzen moves:
------
workList moves:
t_4 = move t_3
va1_1 = move c_1
t_3 = move va0_1
va0_1 = move t_4
va0_1 = move b_2
------
active moves:
========main Node List Info ========
simplify Nodes(low degree non move related):

------
freeze Nodes(low degree move related):
c_1(0) t_4(0) t_3(0) b_2(0) 
------
spill Nodes(high degree):

------
spilled Nodes:

------
coalesced Nodes:

------
colored Nodes:

------
selected Stack:
saved.vs2_2(0) saved.vs1_2(0) saved.vs6_2(0) saved.vs5_2(0) saved.vs8_2(0) saved.vs4_2(0) saved.vs11_2(0) saved.vs3_2(0) saved.vs7_2(0) saved.vs10_2(0) saved.vs9_2(0) 
------

===================== Coalesce =====================
========main Graph Info ========
saved.vs6_2:
AdjList : 
degree : 0
Alias :None
Color : null
Priority : 0
------
saved.vs4_2:
AdjList : 
degree : 0
Alias :None
Color : null
Priority : 0
------
saved.vs2_2:
AdjList : 
degree : 0
Alias :None
Color : null
Priority : 0
------
t_4:
AdjList :  vzero_1
degree : 1
Alias :None
Color : null
Priority : 0
------
saved.vs1_2:
AdjList : 
degree : 0
Alias :None
Color : null
Priority : 0
------
saved.vs11_2:
AdjList : 
degree : 0
Alias :None
Color : null
Priority : 0
------
saved.vs9_2:
AdjList : 
degree : 0
Alias :None
Color : null
Priority : 0
------
c_1:
AdjList :  vzero_1 b_2 va0_1
degree : 3
Alias :None
Color : null
Priority : 0
------
saved.vs5_2:
AdjList : 
degree : 0
Alias :None
Color : null
Priority : 0
------
saved.vs8_2:
AdjList : 
degree : 0
Alias :None
Color : null
Priority : 0
------
t_3:
AdjList :  vzero_1
degree : 1
Alias :t_4
Color : null
Priority : 0
------
b_2:
AdjList :  c_1 vzero_1
degree : 2
Alias :None
Color : null
Priority : 0
------
saved.vs3_2:
AdjList : 
degree : 0
Alias :None
Color : null
Priority : 0
------
saved.vs7_2:
AdjList : 
degree : 0
Alias :None
Color : null
Priority : 0
------
saved.vs10_2:
AdjList : 
degree : 0
Alias :None
Color : null
Priority : 0
------
========main move List Info ========
coalesced moves:
t_4 = move t_3
------
constrained moves:
------
fronzen moves:
------
workList moves:
va1_1 = move c_1
t_3 = move va0_1
va0_1 = move t_4
va0_1 = move b_2
------
active moves:
========main Node List Info ========
simplify Nodes(low degree non move related):

------
freeze Nodes(low degree move related):
c_1(0) t_4(0) b_2(0) 
------
spill Nodes(high degree):

------
spilled Nodes:

------
coalesced Nodes:
t_3(0) 
------
colored Nodes:

------
selected Stack:
saved.vs2_2(0) saved.vs1_2(0) saved.vs6_2(0) saved.vs5_2(0) saved.vs8_2(0) saved.vs4_2(0) saved.vs11_2(0) saved.vs3_2(0) saved.vs7_2(0) saved.vs10_2(0) saved.vs9_2(0) 
------

===================== Coalesce =====================
========main Graph Info ========
saved.vs6_2:
AdjList : 
degree : 0
Alias :None
Color : null
Priority : 0
------
saved.vs4_2:
AdjList : 
degree : 0
Alias :None
Color : null
Priority : 0
------
saved.vs2_2:
AdjList : 
degree : 0
Alias :None
Color : null
Priority : 0
------
t_4:
AdjList :  vzero_1
degree : 1
Alias :None
Color : null
Priority : 0
------
saved.vs1_2:
AdjList : 
degree : 0
Alias :None
Color : null
Priority : 0
------
saved.vs11_2:
AdjList : 
degree : 0
Alias :None
Color : null
Priority : 0
------
saved.vs9_2:
AdjList : 
degree : 0
Alias :None
Color : null
Priority : 0
------
c_1:
AdjList :  vzero_1 b_2 va0_1
degree : 3
Alias :va1_1
Color : null
Priority : 0
------
saved.vs5_2:
AdjList : 
degree : 0
Alias :None
Color : null
Priority : 0
------
saved.vs8_2:
AdjList : 
degree : 0
Alias :None
Color : null
Priority : 0
------
t_3:
AdjList :  vzero_1
degree : 1
Alias :t_4
Color : null
Priority : 0
------
b_2:
AdjList :  c_1 vzero_1 va1_1
degree : 2
Alias :None
Color : null
Priority : 0
------
saved.vs3_2:
AdjList : 
degree : 0
Alias :None
Color : null
Priority : 0
------
saved.vs7_2:
AdjList : 
degree : 0
Alias :None
Color : null
Priority : 0
------
saved.vs10_2:
AdjList : 
degree : 0
Alias :None
Color : null
Priority : 0
------
========main move List Info ========
coalesced moves:
t_4 = move t_3
va1_1 = move c_1
------
constrained moves:
------
fronzen moves:
------
workList moves:
t_3 = move va0_1
va0_1 = move t_4
va0_1 = move b_2
------
active moves:
========main Node List Info ========
simplify Nodes(low degree non move related):

------
freeze Nodes(low degree move related):
t_4(0) b_2(0) 
------
spill Nodes(high degree):

------
spilled Nodes:

------
coalesced Nodes:
c_1(0) t_3(0) 
------
colored Nodes:

------
selected Stack:
saved.vs2_2(0) saved.vs1_2(0) saved.vs6_2(0) saved.vs5_2(0) saved.vs8_2(0) saved.vs4_2(0) saved.vs11_2(0) saved.vs3_2(0) saved.vs7_2(0) saved.vs10_2(0) saved.vs9_2(0) 
------

===================== Coalesce =====================
========main Graph Info ========
saved.vs6_2:
AdjList : 
degree : 0
Alias :None
Color : null
Priority : 0
------
saved.vs4_2:
AdjList : 
degree : 0
Alias :None
Color : null
Priority : 0
------
saved.vs2_2:
AdjList : 
degree : 0
Alias :None
Color : null
Priority : 0
------
t_4:
AdjList :  vzero_1
degree : 1
Alias :va0_1
Color : null
Priority : 0
------
saved.vs1_2:
AdjList : 
degree : 0
Alias :None
Color : null
Priority : 0
------
saved.vs11_2:
AdjList : 
degree : 0
Alias :None
Color : null
Priority : 0
------
saved.vs9_2:
AdjList : 
degree : 0
Alias :None
Color : null
Priority : 0
------
c_1:
AdjList :  vzero_1 b_2 va0_1
degree : 3
Alias :va1_1
Color : null
Priority : 0
------
saved.vs5_2:
AdjList : 
degree : 0
Alias :None
Color : null
Priority : 0
------
saved.vs8_2:
AdjList : 
degree : 0
Alias :None
Color : null
Priority : 0
------
t_3:
AdjList :  vzero_1
degree : 1
Alias :t_4
Color : null
Priority : 0
------
b_2:
AdjList :  c_1 vzero_1 va1_1
degree : 2
Alias :None
Color : null
Priority : 0
------
saved.vs3_2:
AdjList : 
degree : 0
Alias :None
Color : null
Priority : 0
------
saved.vs7_2:
AdjList : 
degree : 0
Alias :None
Color : null
Priority : 0
------
saved.vs10_2:
AdjList : 
degree : 0
Alias :None
Color : null
Priority : 0
------
========main move List Info ========
coalesced moves:
t_4 = move t_3
va1_1 = move c_1
t_3 = move va0_1
------
constrained moves:
------
fronzen moves:
------
workList moves:
va0_1 = move t_4
va0_1 = move b_2
------
active moves:
========main Node List Info ========
simplify Nodes(low degree non move related):

------
freeze Nodes(low degree move related):
b_2(0) 
------
spill Nodes(high degree):

------
spilled Nodes:

------
coalesced Nodes:
c_1(0) t_4(0) t_3(0) 
------
colored Nodes:

------
selected Stack:
saved.vs2_2(0) saved.vs1_2(0) saved.vs6_2(0) saved.vs5_2(0) saved.vs8_2(0) saved.vs4_2(0) saved.vs11_2(0) saved.vs3_2(0) saved.vs7_2(0) saved.vs10_2(0) saved.vs9_2(0) 
------

===================== Coalesce =====================
========main Graph Info ========
saved.vs6_2:
AdjList : 
degree : 0
Alias :None
Color : null
Priority : 0
------
saved.vs4_2:
AdjList : 
degree : 0
Alias :None
Color : null
Priority : 0
------
saved.vs2_2:
AdjList : 
degree : 0
Alias :None
Color : null
Priority : 0
------
t_4:
AdjList :  vzero_1
degree : 1
Alias :va0_1
Color : null
Priority : 0
------
saved.vs1_2:
AdjList : 
degree : 0
Alias :None
Color : null
Priority : 0
------
saved.vs11_2:
AdjList : 
degree : 0
Alias :None
Color : null
Priority : 0
------
saved.vs9_2:
AdjList : 
degree : 0
Alias :None
Color : null
Priority : 0
------
c_1:
AdjList :  vzero_1 b_2 va0_1
degree : 3
Alias :va1_1
Color : null
Priority : 0
------
saved.vs5_2:
AdjList : 
degree : 0
Alias :None
Color : null
Priority : 0
------
saved.vs8_2:
AdjList : 
degree : 0
Alias :None
Color : null
Priority : 0
------
t_3:
AdjList :  vzero_1
degree : 1
Alias :t_4
Color : null
Priority : 0
------
b_2:
AdjList :  c_1 vzero_1 va1_1
degree : 2
Alias :None
Color : null
Priority : 0
------
saved.vs3_2:
AdjList : 
degree : 0
Alias :None
Color : null
Priority : 0
------
saved.vs7_2:
AdjList : 
degree : 0
Alias :None
Color : null
Priority : 0
------
saved.vs10_2:
AdjList : 
degree : 0
Alias :None
Color : null
Priority : 0
------
========main move List Info ========
coalesced moves:
t_4 = move t_3
va1_1 = move c_1
t_3 = move va0_1
va0_1 = move t_4
------
constrained moves:
------
fronzen moves:
------
workList moves:
va0_1 = move b_2
------
active moves:
========main Node List Info ========
simplify Nodes(low degree non move related):

------
freeze Nodes(low degree move related):
b_2(0) 
------
spill Nodes(high degree):

------
spilled Nodes:

------
coalesced Nodes:
c_1(0) t_4(0) t_3(0) 
------
colored Nodes:

------
selected Stack:
saved.vs2_2(0) saved.vs1_2(0) saved.vs6_2(0) saved.vs5_2(0) saved.vs8_2(0) saved.vs4_2(0) saved.vs11_2(0) saved.vs3_2(0) saved.vs7_2(0) saved.vs10_2(0) saved.vs9_2(0) 
------

===================== Coalesce =====================
========main Graph Info ========
saved.vs6_2:
AdjList : 
degree : 0
Alias :None
Color : null
Priority : 0
------
saved.vs4_2:
AdjList : 
degree : 0
Alias :None
Color : null
Priority : 0
------
saved.vs2_2:
AdjList : 
degree : 0
Alias :None
Color : null
Priority : 0
------
t_4:
AdjList :  vzero_1
degree : 1
Alias :va0_1
Color : null
Priority : 0
------
saved.vs1_2:
AdjList : 
degree : 0
Alias :None
Color : null
Priority : 0
------
saved.vs11_2:
AdjList : 
degree : 0
Alias :None
Color : null
Priority : 0
------
saved.vs9_2:
AdjList : 
degree : 0
Alias :None
Color : null
Priority : 0
------
c_1:
AdjList :  vzero_1 b_2 va0_1
degree : 3
Alias :va1_1
Color : null
Priority : 0
------
saved.vs5_2:
AdjList : 
degree : 0
Alias :None
Color : null
Priority : 0
------
saved.vs8_2:
AdjList : 
degree : 0
Alias :None
Color : null
Priority : 0
------
t_3:
AdjList :  vzero_1
degree : 1
Alias :t_4
Color : null
Priority : 0
------
b_2:
AdjList :  c_1 vzero_1 va1_1
degree : 2
Alias :va0_1
Color : null
Priority : 0
------
saved.vs3_2:
AdjList : 
degree : 0
Alias :None
Color : null
Priority : 0
------
saved.vs7_2:
AdjList : 
degree : 0
Alias :None
Color : null
Priority : 0
------
saved.vs10_2:
AdjList : 
degree : 0
Alias :None
Color : null
Priority : 0
------
========main move List Info ========
coalesced moves:
t_4 = move t_3
va1_1 = move c_1
t_3 = move va0_1
va0_1 = move t_4
va0_1 = move b_2
------
constrained moves:
------
fronzen moves:
------
workList moves:
------
active moves:
========main Node List Info ========
simplify Nodes(low degree non move related):

------
freeze Nodes(low degree move related):

------
spill Nodes(high degree):

------
spilled Nodes:

------
coalesced Nodes:
c_1(0) t_4(0) t_3(0) b_2(0) 
------
colored Nodes:

------
selected Stack:
saved.vs2_2(0) saved.vs1_2(0) saved.vs6_2(0) saved.vs5_2(0) saved.vs8_2(0) saved.vs4_2(0) saved.vs11_2(0) saved.vs3_2(0) saved.vs7_2(0) saved.vs10_2(0) saved.vs9_2(0) 
------

===================== after ASSIGN =====================
========main Graph Info ========
saved.vs6_2:
AdjList : 
degree : 0
Alias :None
Color : s11
Priority : 0
------
saved.vs4_2:
AdjList : 
degree : 0
Alias :None
Color : s11
Priority : 0
------
saved.vs2_2:
AdjList : 
degree : 0
Alias :None
Color : s11
Priority : 0
------
t_4:
AdjList :  vzero_1
degree : 1
Alias :va0_1
Color : a0
Priority : 0
------
saved.vs1_2:
AdjList : 
degree : 0
Alias :None
Color : s11
Priority : 0
------
saved.vs11_2:
AdjList : 
degree : 0
Alias :None
Color : s11
Priority : 0
------
saved.vs9_2:
AdjList : 
degree : 0
Alias :None
Color : s11
Priority : 0
------
c_1:
AdjList :  vzero_1 b_2 va0_1
degree : 3
Alias :va1_1
Color : a1
Priority : 0
------
saved.vs5_2:
AdjList : 
degree : 0
Alias :None
Color : s11
Priority : 0
------
saved.vs8_2:
AdjList : 
degree : 0
Alias :None
Color : s11
Priority : 0
------
t_3:
AdjList :  vzero_1
degree : 1
Alias :va0_1
Color : a0
Priority : 0
------
b_2:
AdjList :  c_1 vzero_1 va1_1
degree : 2
Alias :va0_1
Color : a0
Priority : 0
------
saved.vs3_2:
AdjList : 
degree : 0
Alias :None
Color : s11
Priority : 0
------
saved.vs7_2:
AdjList : 
degree : 0
Alias :None
Color : s11
Priority : 0
------
saved.vs10_2:
AdjList : 
degree : 0
Alias :None
Color : s11
Priority : 0
------
========main move List Info ========
coalesced moves:
t_4 = move t_3
va1_1 = move c_1
t_3 = move va0_1
va0_1 = move t_4
va0_1 = move b_2
------
constrained moves:
------
fronzen moves:
------
workList moves:
------
active moves:
========main Node List Info ========
simplify Nodes(low degree non move related):

------
freeze Nodes(low degree move related):

------
spill Nodes(high degree):

------
spilled Nodes:

------
coalesced Nodes:
c_1(0) t_4(0) t_3(0) b_2(0) 
------
colored Nodes:
saved.vs2_2(0) saved.vs1_2(0) saved.vs6_2(0) saved.vs5_2(0) saved.vs8_2(0) saved.vs4_2(0) saved.vs11_2(0) saved.vs10_2(0) saved.vs7_2(0) saved.vs3_2(0) saved.vs9_2(0) 
------
selected Stack:

------

=====================__init Iteration 0=====================
========__init Graph Info ========
saved.vs7_3:
AdjList : 
degree : 0
Alias :None
Color : null
Priority : 0
------
saved.vs5_3:
AdjList : 
degree : 0
Alias :None
Color : null
Priority : 0
------
saved.vs8_3:
AdjList : 
degree : 0
Alias :None
Color : null
Priority : 0
------
saved.vs4_3:
AdjList : 
degree : 0
Alias :None
Color : null
Priority : 0
------
saved.vs11_3:
AdjList : 
degree : 0
Alias :None
Color : null
Priority : 0
------
saved.vs6_3:
AdjList : 
degree : 0
Alias :None
Color : null
Priority : 0
------
saved.vs2_3:
AdjList : 
degree : 0
Alias :None
Color : null
Priority : 0
------
saved.vs9_3:
AdjList : 
degree : 0
Alias :None
Color : null
Priority : 0
------
t_5:
AdjList :  vzero_1
degree : 1
Alias :None
Color : null
Priority : 0
------
t_6:
AdjList :  vzero_1
degree : 1
Alias :None
Color : null
Priority : 0
------
saved.vs1_3:
AdjList : 
degree : 0
Alias :None
Color : null
Priority : 0
------
saved.vs3_3:
AdjList : 
degree : 0
Alias :None
Color : null
Priority : 0
------
saved.vs10_3:
AdjList : 
degree : 0
Alias :None
Color : null
Priority : 0
------
========__init move List Info ========
coalesced moves:
------
constrained moves:
------
fronzen moves:
------
workList moves:
t_5 = move va0_1
va0_1 = move t_6
t_6 = move t_5
------
active moves:
========__init Node List Info ========
simplify Nodes(low degree non move related):
saved.vs7_3(0) saved.vs8_3(0) saved.vs1_3(0) saved.vs4_3(0) saved.vs11_3(0) saved.vs5_3(0) saved.vs6_3(0) saved.vs3_3(0) saved.vs2_3(0) saved.vs9_3(0) saved.vs10_3(0) 
------
freeze Nodes(low degree move related):
t_6(0) t_5(0) 
------
spill Nodes(high degree):

------
spilled Nodes:

------
coalesced Nodes:

------
colored Nodes:

------
selected Stack:

------

define i64 @func  %a_1 %b_1 {
func_entry_1:
   %b_1 = move %va1_1
   %a_1 = move %va0_1
   %t_1 = add %a_1 %b_1
   %t_2 = move %t_1
   %va0_1 = move %t_2
   ret %va0_1
}

define i64 @main  {
main_entry_1:
   %b_2 = move 3
   %c_1 = move 4
   %va0_1 = move %b_2
   %va1_1 = move %c_1
   %va0_1 = call func %va0_1 %va1_1 
   %t_3 = move %va0_1
   %t_4 = move %t_3
   %va0_1 = move %t_4
   ret %va0_1
}

define i64 @__init  {
__init_entry_1:
   %va0_1 = call main 
   %t_5 = move %va0_1
   %t_6 = move %t_5
   %va0_1 = move %t_6
   ret %va0_1
}

===================== Simplify =====================
========__init Graph Info ========
saved.vs7_3:
AdjList : 
degree : 0
Alias :None
Color : null
Priority : 0
------
saved.vs5_3:
AdjList : 
degree : 0
Alias :None
Color : null
Priority : 0
------
saved.vs8_3:
AdjList : 
degree : 0
Alias :None
Color : null
Priority : 0
------
saved.vs4_3:
AdjList : 
degree : 0
Alias :None
Color : null
Priority : 0
------
saved.vs11_3:
AdjList : 
degree : 0
Alias :None
Color : null
Priority : 0
------
saved.vs6_3:
AdjList : 
degree : 0
Alias :None
Color : null
Priority : 0
------
saved.vs2_3:
AdjList : 
degree : 0
Alias :None
Color : null
Priority : 0
------
saved.vs9_3:
AdjList : 
degree : 0
Alias :None
Color : null
Priority : 0
------
t_5:
AdjList :  vzero_1
degree : 1
Alias :None
Color : null
Priority : 0
------
t_6:
AdjList :  vzero_1
degree : 1
Alias :None
Color : null
Priority : 0
------
saved.vs1_3:
AdjList : 
degree : 0
Alias :None
Color : null
Priority : 0
------
saved.vs3_3:
AdjList : 
degree : 0
Alias :None
Color : null
Priority : 0
------
saved.vs10_3:
AdjList : 
degree : 0
Alias :None
Color : null
Priority : 0
------
========__init move List Info ========
coalesced moves:
------
constrained moves:
------
fronzen moves:
------
workList moves:
t_5 = move va0_1
va0_1 = move t_6
t_6 = move t_5
------
active moves:
========__init Node List Info ========
simplify Nodes(low degree non move related):
saved.vs8_3(0) saved.vs1_3(0) saved.vs4_3(0) saved.vs11_3(0) saved.vs5_3(0) saved.vs6_3(0) saved.vs3_3(0) saved.vs2_3(0) saved.vs9_3(0) saved.vs10_3(0) 
------
freeze Nodes(low degree move related):
t_6(0) t_5(0) 
------
spill Nodes(high degree):

------
spilled Nodes:

------
coalesced Nodes:

------
colored Nodes:

------
selected Stack:
saved.vs7_3(0) 
------

===================== Simplify =====================
========__init Graph Info ========
saved.vs7_3:
AdjList : 
degree : 0
Alias :None
Color : null
Priority : 0
------
saved.vs5_3:
AdjList : 
degree : 0
Alias :None
Color : null
Priority : 0
------
saved.vs8_3:
AdjList : 
degree : 0
Alias :None
Color : null
Priority : 0
------
saved.vs4_3:
AdjList : 
degree : 0
Alias :None
Color : null
Priority : 0
------
saved.vs11_3:
AdjList : 
degree : 0
Alias :None
Color : null
Priority : 0
------
saved.vs6_3:
AdjList : 
degree : 0
Alias :None
Color : null
Priority : 0
------
saved.vs2_3:
AdjList : 
degree : 0
Alias :None
Color : null
Priority : 0
------
saved.vs9_3:
AdjList : 
degree : 0
Alias :None
Color : null
Priority : 0
------
t_5:
AdjList :  vzero_1
degree : 1
Alias :None
Color : null
Priority : 0
------
t_6:
AdjList :  vzero_1
degree : 1
Alias :None
Color : null
Priority : 0
------
saved.vs1_3:
AdjList : 
degree : 0
Alias :None
Color : null
Priority : 0
------
saved.vs3_3:
AdjList : 
degree : 0
Alias :None
Color : null
Priority : 0
------
saved.vs10_3:
AdjList : 
degree : 0
Alias :None
Color : null
Priority : 0
------
========__init move List Info ========
coalesced moves:
------
constrained moves:
------
fronzen moves:
------
workList moves:
t_5 = move va0_1
va0_1 = move t_6
t_6 = move t_5
------
active moves:
========__init Node List Info ========
simplify Nodes(low degree non move related):
saved.vs1_3(0) saved.vs4_3(0) saved.vs11_3(0) saved.vs5_3(0) saved.vs6_3(0) saved.vs3_3(0) saved.vs2_3(0) saved.vs9_3(0) saved.vs10_3(0) 
------
freeze Nodes(low degree move related):
t_6(0) t_5(0) 
------
spill Nodes(high degree):

------
spilled Nodes:

------
coalesced Nodes:

------
colored Nodes:

------
selected Stack:
saved.vs7_3(0) saved.vs8_3(0) 
------

===================== Simplify =====================
========__init Graph Info ========
saved.vs7_3:
AdjList : 
degree : 0
Alias :None
Color : null
Priority : 0
------
saved.vs5_3:
AdjList : 
degree : 0
Alias :None
Color : null
Priority : 0
------
saved.vs8_3:
AdjList : 
degree : 0
Alias :None
Color : null
Priority : 0
------
saved.vs4_3:
AdjList : 
degree : 0
Alias :None
Color : null
Priority : 0
------
saved.vs11_3:
AdjList : 
degree : 0
Alias :None
Color : null
Priority : 0
------
saved.vs6_3:
AdjList : 
degree : 0
Alias :None
Color : null
Priority : 0
------
saved.vs2_3:
AdjList : 
degree : 0
Alias :None
Color : null
Priority : 0
------
saved.vs9_3:
AdjList : 
degree : 0
Alias :None
Color : null
Priority : 0
------
t_5:
AdjList :  vzero_1
degree : 1
Alias :None
Color : null
Priority : 0
------
t_6:
AdjList :  vzero_1
degree : 1
Alias :None
Color : null
Priority : 0
------
saved.vs1_3:
AdjList : 
degree : 0
Alias :None
Color : null
Priority : 0
------
saved.vs3_3:
AdjList : 
degree : 0
Alias :None
Color : null
Priority : 0
------
saved.vs10_3:
AdjList : 
degree : 0
Alias :None
Color : null
Priority : 0
------
========__init move List Info ========
coalesced moves:
------
constrained moves:
------
fronzen moves:
------
workList moves:
t_5 = move va0_1
va0_1 = move t_6
t_6 = move t_5
------
active moves:
========__init Node List Info ========
simplify Nodes(low degree non move related):
saved.vs4_3(0) saved.vs11_3(0) saved.vs5_3(0) saved.vs6_3(0) saved.vs3_3(0) saved.vs2_3(0) saved.vs9_3(0) saved.vs10_3(0) 
------
freeze Nodes(low degree move related):
t_6(0) t_5(0) 
------
spill Nodes(high degree):

------
spilled Nodes:

------
coalesced Nodes:

------
colored Nodes:

------
selected Stack:
saved.vs7_3(0) saved.vs8_3(0) saved.vs1_3(0) 
------

===================== Simplify =====================
========__init Graph Info ========
saved.vs7_3:
AdjList : 
degree : 0
Alias :None
Color : null
Priority : 0
------
saved.vs5_3:
AdjList : 
degree : 0
Alias :None
Color : null
Priority : 0
------
saved.vs8_3:
AdjList : 
degree : 0
Alias :None
Color : null
Priority : 0
------
saved.vs4_3:
AdjList : 
degree : 0
Alias :None
Color : null
Priority : 0
------
saved.vs11_3:
AdjList : 
degree : 0
Alias :None
Color : null
Priority : 0
------
saved.vs6_3:
AdjList : 
degree : 0
Alias :None
Color : null
Priority : 0
------
saved.vs2_3:
AdjList : 
degree : 0
Alias :None
Color : null
Priority : 0
------
saved.vs9_3:
AdjList : 
degree : 0
Alias :None
Color : null
Priority : 0
------
t_5:
AdjList :  vzero_1
degree : 1
Alias :None
Color : null
Priority : 0
------
t_6:
AdjList :  vzero_1
degree : 1
Alias :None
Color : null
Priority : 0
------
saved.vs1_3:
AdjList : 
degree : 0
Alias :None
Color : null
Priority : 0
------
saved.vs3_3:
AdjList : 
degree : 0
Alias :None
Color : null
Priority : 0
------
saved.vs10_3:
AdjList : 
degree : 0
Alias :None
Color : null
Priority : 0
------
========__init move List Info ========
coalesced moves:
------
constrained moves:
------
fronzen moves:
------
workList moves:
t_5 = move va0_1
va0_1 = move t_6
t_6 = move t_5
------
active moves:
========__init Node List Info ========
simplify Nodes(low degree non move related):
saved.vs11_3(0) saved.vs5_3(0) saved.vs6_3(0) saved.vs3_3(0) saved.vs2_3(0) saved.vs9_3(0) saved.vs10_3(0) 
------
freeze Nodes(low degree move related):
t_6(0) t_5(0) 
------
spill Nodes(high degree):

------
spilled Nodes:

------
coalesced Nodes:

------
colored Nodes:

------
selected Stack:
saved.vs7_3(0) saved.vs8_3(0) saved.vs1_3(0) saved.vs4_3(0) 
------

===================== Simplify =====================
========__init Graph Info ========
saved.vs7_3:
AdjList : 
degree : 0
Alias :None
Color : null
Priority : 0
------
saved.vs5_3:
AdjList : 
degree : 0
Alias :None
Color : null
Priority : 0
------
saved.vs8_3:
AdjList : 
degree : 0
Alias :None
Color : null
Priority : 0
------
saved.vs4_3:
AdjList : 
degree : 0
Alias :None
Color : null
Priority : 0
------
saved.vs11_3:
AdjList : 
degree : 0
Alias :None
Color : null
Priority : 0
------
saved.vs6_3:
AdjList : 
degree : 0
Alias :None
Color : null
Priority : 0
------
saved.vs2_3:
AdjList : 
degree : 0
Alias :None
Color : null
Priority : 0
------
saved.vs9_3:
AdjList : 
degree : 0
Alias :None
Color : null
Priority : 0
------
t_5:
AdjList :  vzero_1
degree : 1
Alias :None
Color : null
Priority : 0
------
t_6:
AdjList :  vzero_1
degree : 1
Alias :None
Color : null
Priority : 0
------
saved.vs1_3:
AdjList : 
degree : 0
Alias :None
Color : null
Priority : 0
------
saved.vs3_3:
AdjList : 
degree : 0
Alias :None
Color : null
Priority : 0
------
saved.vs10_3:
AdjList : 
degree : 0
Alias :None
Color : null
Priority : 0
------
========__init move List Info ========
coalesced moves:
------
constrained moves:
------
fronzen moves:
------
workList moves:
t_5 = move va0_1
va0_1 = move t_6
t_6 = move t_5
------
active moves:
========__init Node List Info ========
simplify Nodes(low degree non move related):
saved.vs5_3(0) saved.vs6_3(0) saved.vs3_3(0) saved.vs2_3(0) saved.vs9_3(0) saved.vs10_3(0) 
------
freeze Nodes(low degree move related):
t_6(0) t_5(0) 
------
spill Nodes(high degree):

------
spilled Nodes:

------
coalesced Nodes:

------
colored Nodes:

------
selected Stack:
saved.vs7_3(0) saved.vs8_3(0) saved.vs1_3(0) saved.vs4_3(0) saved.vs11_3(0) 
------

===================== Simplify =====================
========__init Graph Info ========
saved.vs7_3:
AdjList : 
degree : 0
Alias :None
Color : null
Priority : 0
------
saved.vs5_3:
AdjList : 
degree : 0
Alias :None
Color : null
Priority : 0
------
saved.vs8_3:
AdjList : 
degree : 0
Alias :None
Color : null
Priority : 0
------
saved.vs4_3:
AdjList : 
degree : 0
Alias :None
Color : null
Priority : 0
------
saved.vs11_3:
AdjList : 
degree : 0
Alias :None
Color : null
Priority : 0
------
saved.vs6_3:
AdjList : 
degree : 0
Alias :None
Color : null
Priority : 0
------
saved.vs2_3:
AdjList : 
degree : 0
Alias :None
Color : null
Priority : 0
------
saved.vs9_3:
AdjList : 
degree : 0
Alias :None
Color : null
Priority : 0
------
t_5:
AdjList :  vzero_1
degree : 1
Alias :None
Color : null
Priority : 0
------
t_6:
AdjList :  vzero_1
degree : 1
Alias :None
Color : null
Priority : 0
------
saved.vs1_3:
AdjList : 
degree : 0
Alias :None
Color : null
Priority : 0
------
saved.vs3_3:
AdjList : 
degree : 0
Alias :None
Color : null
Priority : 0
------
saved.vs10_3:
AdjList : 
degree : 0
Alias :None
Color : null
Priority : 0
------
========__init move List Info ========
coalesced moves:
------
constrained moves:
------
fronzen moves:
------
workList moves:
t_5 = move va0_1
va0_1 = move t_6
t_6 = move t_5
------
active moves:
========__init Node List Info ========
simplify Nodes(low degree non move related):
saved.vs6_3(0) saved.vs3_3(0) saved.vs2_3(0) saved.vs9_3(0) saved.vs10_3(0) 
------
freeze Nodes(low degree move related):
t_6(0) t_5(0) 
------
spill Nodes(high degree):

------
spilled Nodes:

------
coalesced Nodes:

------
colored Nodes:

------
selected Stack:
saved.vs7_3(0) saved.vs8_3(0) saved.vs1_3(0) saved.vs4_3(0) saved.vs11_3(0) saved.vs5_3(0) 
------

===================== Simplify =====================
========__init Graph Info ========
saved.vs7_3:
AdjList : 
degree : 0
Alias :None
Color : null
Priority : 0
------
saved.vs5_3:
AdjList : 
degree : 0
Alias :None
Color : null
Priority : 0
------
saved.vs8_3:
AdjList : 
degree : 0
Alias :None
Color : null
Priority : 0
------
saved.vs4_3:
AdjList : 
degree : 0
Alias :None
Color : null
Priority : 0
------
saved.vs11_3:
AdjList : 
degree : 0
Alias :None
Color : null
Priority : 0
------
saved.vs6_3:
AdjList : 
degree : 0
Alias :None
Color : null
Priority : 0
------
saved.vs2_3:
AdjList : 
degree : 0
Alias :None
Color : null
Priority : 0
------
saved.vs9_3:
AdjList : 
degree : 0
Alias :None
Color : null
Priority : 0
------
t_5:
AdjList :  vzero_1
degree : 1
Alias :None
Color : null
Priority : 0
------
t_6:
AdjList :  vzero_1
degree : 1
Alias :None
Color : null
Priority : 0
------
saved.vs1_3:
AdjList : 
degree : 0
Alias :None
Color : null
Priority : 0
------
saved.vs3_3:
AdjList : 
degree : 0
Alias :None
Color : null
Priority : 0
------
saved.vs10_3:
AdjList : 
degree : 0
Alias :None
Color : null
Priority : 0
------
========__init move List Info ========
coalesced moves:
------
constrained moves:
------
fronzen moves:
------
workList moves:
t_5 = move va0_1
va0_1 = move t_6
t_6 = move t_5
------
active moves:
========__init Node List Info ========
simplify Nodes(low degree non move related):
saved.vs3_3(0) saved.vs2_3(0) saved.vs9_3(0) saved.vs10_3(0) 
------
freeze Nodes(low degree move related):
t_6(0) t_5(0) 
------
spill Nodes(high degree):

------
spilled Nodes:

------
coalesced Nodes:

------
colored Nodes:

------
selected Stack:
saved.vs7_3(0) saved.vs8_3(0) saved.vs1_3(0) saved.vs4_3(0) saved.vs11_3(0) saved.vs5_3(0) saved.vs6_3(0) 
------

===================== Simplify =====================
========__init Graph Info ========
saved.vs7_3:
AdjList : 
degree : 0
Alias :None
Color : null
Priority : 0
------
saved.vs5_3:
AdjList : 
degree : 0
Alias :None
Color : null
Priority : 0
------
saved.vs8_3:
AdjList : 
degree : 0
Alias :None
Color : null
Priority : 0
------
saved.vs4_3:
AdjList : 
degree : 0
Alias :None
Color : null
Priority : 0
------
saved.vs11_3:
AdjList : 
degree : 0
Alias :None
Color : null
Priority : 0
------
saved.vs6_3:
AdjList : 
degree : 0
Alias :None
Color : null
Priority : 0
------
saved.vs2_3:
AdjList : 
degree : 0
Alias :None
Color : null
Priority : 0
------
saved.vs9_3:
AdjList : 
degree : 0
Alias :None
Color : null
Priority : 0
------
t_5:
AdjList :  vzero_1
degree : 1
Alias :None
Color : null
Priority : 0
------
t_6:
AdjList :  vzero_1
degree : 1
Alias :None
Color : null
Priority : 0
------
saved.vs1_3:
AdjList : 
degree : 0
Alias :None
Color : null
Priority : 0
------
saved.vs3_3:
AdjList : 
degree : 0
Alias :None
Color : null
Priority : 0
------
saved.vs10_3:
AdjList : 
degree : 0
Alias :None
Color : null
Priority : 0
------
========__init move List Info ========
coalesced moves:
------
constrained moves:
------
fronzen moves:
------
workList moves:
t_5 = move va0_1
va0_1 = move t_6
t_6 = move t_5
------
active moves:
========__init Node List Info ========
simplify Nodes(low degree non move related):
saved.vs2_3(0) saved.vs9_3(0) saved.vs10_3(0) 
------
freeze Nodes(low degree move related):
t_6(0) t_5(0) 
------
spill Nodes(high degree):

------
spilled Nodes:

------
coalesced Nodes:

------
colored Nodes:

------
selected Stack:
saved.vs7_3(0) saved.vs8_3(0) saved.vs1_3(0) saved.vs4_3(0) saved.vs11_3(0) saved.vs5_3(0) saved.vs6_3(0) saved.vs3_3(0) 
------

===================== Simplify =====================
========__init Graph Info ========
saved.vs7_3:
AdjList : 
degree : 0
Alias :None
Color : null
Priority : 0
------
saved.vs5_3:
AdjList : 
degree : 0
Alias :None
Color : null
Priority : 0
------
saved.vs8_3:
AdjList : 
degree : 0
Alias :None
Color : null
Priority : 0
------
saved.vs4_3:
AdjList : 
degree : 0
Alias :None
Color : null
Priority : 0
------
saved.vs11_3:
AdjList : 
degree : 0
Alias :None
Color : null
Priority : 0
------
saved.vs6_3:
AdjList : 
degree : 0
Alias :None
Color : null
Priority : 0
------
saved.vs2_3:
AdjList : 
degree : 0
Alias :None
Color : null
Priority : 0
------
saved.vs9_3:
AdjList : 
degree : 0
Alias :None
Color : null
Priority : 0
------
t_5:
AdjList :  vzero_1
degree : 1
Alias :None
Color : null
Priority : 0
------
t_6:
AdjList :  vzero_1
degree : 1
Alias :None
Color : null
Priority : 0
------
saved.vs1_3:
AdjList : 
degree : 0
Alias :None
Color : null
Priority : 0
------
saved.vs3_3:
AdjList : 
degree : 0
Alias :None
Color : null
Priority : 0
------
saved.vs10_3:
AdjList : 
degree : 0
Alias :None
Color : null
Priority : 0
------
========__init move List Info ========
coalesced moves:
------
constrained moves:
------
fronzen moves:
------
workList moves:
t_5 = move va0_1
va0_1 = move t_6
t_6 = move t_5
------
active moves:
========__init Node List Info ========
simplify Nodes(low degree non move related):
saved.vs9_3(0) saved.vs10_3(0) 
------
freeze Nodes(low degree move related):
t_6(0) t_5(0) 
------
spill Nodes(high degree):

------
spilled Nodes:

------
coalesced Nodes:

------
colored Nodes:

------
selected Stack:
saved.vs7_3(0) saved.vs8_3(0) saved.vs1_3(0) saved.vs4_3(0) saved.vs11_3(0) saved.vs5_3(0) saved.vs6_3(0) saved.vs3_3(0) saved.vs2_3(0) 
------

===================== Simplify =====================
========__init Graph Info ========
saved.vs7_3:
AdjList : 
degree : 0
Alias :None
Color : null
Priority : 0
------
saved.vs5_3:
AdjList : 
degree : 0
Alias :None
Color : null
Priority : 0
------
saved.vs8_3:
AdjList : 
degree : 0
Alias :None
Color : null
Priority : 0
------
saved.vs4_3:
AdjList : 
degree : 0
Alias :None
Color : null
Priority : 0
------
saved.vs11_3:
AdjList : 
degree : 0
Alias :None
Color : null
Priority : 0
------
saved.vs6_3:
AdjList : 
degree : 0
Alias :None
Color : null
Priority : 0
------
saved.vs2_3:
AdjList : 
degree : 0
Alias :None
Color : null
Priority : 0
------
saved.vs9_3:
AdjList : 
degree : 0
Alias :None
Color : null
Priority : 0
------
t_5:
AdjList :  vzero_1
degree : 1
Alias :None
Color : null
Priority : 0
------
t_6:
AdjList :  vzero_1
degree : 1
Alias :None
Color : null
Priority : 0
------
saved.vs1_3:
AdjList : 
degree : 0
Alias :None
Color : null
Priority : 0
------
saved.vs3_3:
AdjList : 
degree : 0
Alias :None
Color : null
Priority : 0
------
saved.vs10_3:
AdjList : 
degree : 0
Alias :None
Color : null
Priority : 0
------
========__init move List Info ========
coalesced moves:
------
constrained moves:
------
fronzen moves:
------
workList moves:
t_5 = move va0_1
va0_1 = move t_6
t_6 = move t_5
------
active moves:
========__init Node List Info ========
simplify Nodes(low degree non move related):
saved.vs10_3(0) 
------
freeze Nodes(low degree move related):
t_6(0) t_5(0) 
------
spill Nodes(high degree):

------
spilled Nodes:

------
coalesced Nodes:

------
colored Nodes:

------
selected Stack:
saved.vs7_3(0) saved.vs8_3(0) saved.vs1_3(0) saved.vs4_3(0) saved.vs11_3(0) saved.vs5_3(0) saved.vs6_3(0) saved.vs3_3(0) saved.vs2_3(0) saved.vs9_3(0) 
------

===================== Simplify =====================
========__init Graph Info ========
saved.vs7_3:
AdjList : 
degree : 0
Alias :None
Color : null
Priority : 0
------
saved.vs5_3:
AdjList : 
degree : 0
Alias :None
Color : null
Priority : 0
------
saved.vs8_3:
AdjList : 
degree : 0
Alias :None
Color : null
Priority : 0
------
saved.vs4_3:
AdjList : 
degree : 0
Alias :None
Color : null
Priority : 0
------
saved.vs11_3:
AdjList : 
degree : 0
Alias :None
Color : null
Priority : 0
------
saved.vs6_3:
AdjList : 
degree : 0
Alias :None
Color : null
Priority : 0
------
saved.vs2_3:
AdjList : 
degree : 0
Alias :None
Color : null
Priority : 0
------
saved.vs9_3:
AdjList : 
degree : 0
Alias :None
Color : null
Priority : 0
------
t_5:
AdjList :  vzero_1
degree : 1
Alias :None
Color : null
Priority : 0
------
t_6:
AdjList :  vzero_1
degree : 1
Alias :None
Color : null
Priority : 0
------
saved.vs1_3:
AdjList : 
degree : 0
Alias :None
Color : null
Priority : 0
------
saved.vs3_3:
AdjList : 
degree : 0
Alias :None
Color : null
Priority : 0
------
saved.vs10_3:
AdjList : 
degree : 0
Alias :None
Color : null
Priority : 0
------
========__init move List Info ========
coalesced moves:
------
constrained moves:
------
fronzen moves:
------
workList moves:
t_5 = move va0_1
va0_1 = move t_6
t_6 = move t_5
------
active moves:
========__init Node List Info ========
simplify Nodes(low degree non move related):

------
freeze Nodes(low degree move related):
t_6(0) t_5(0) 
------
spill Nodes(high degree):

------
spilled Nodes:

------
coalesced Nodes:

------
colored Nodes:

------
selected Stack:
saved.vs7_3(0) saved.vs8_3(0) saved.vs1_3(0) saved.vs4_3(0) saved.vs11_3(0) saved.vs5_3(0) saved.vs6_3(0) saved.vs3_3(0) saved.vs2_3(0) saved.vs9_3(0) saved.vs10_3(0) 
------

===================== Coalesce =====================
========__init Graph Info ========
saved.vs7_3:
AdjList : 
degree : 0
Alias :None
Color : null
Priority : 0
------
saved.vs5_3:
AdjList : 
degree : 0
Alias :None
Color : null
Priority : 0
------
saved.vs8_3:
AdjList : 
degree : 0
Alias :None
Color : null
Priority : 0
------
saved.vs4_3:
AdjList : 
degree : 0
Alias :None
Color : null
Priority : 0
------
saved.vs11_3:
AdjList : 
degree : 0
Alias :None
Color : null
Priority : 0
------
saved.vs6_3:
AdjList : 
degree : 0
Alias :None
Color : null
Priority : 0
------
saved.vs2_3:
AdjList : 
degree : 0
Alias :None
Color : null
Priority : 0
------
saved.vs9_3:
AdjList : 
degree : 0
Alias :None
Color : null
Priority : 0
------
t_5:
AdjList :  vzero_1
degree : 1
Alias :va0_1
Color : null
Priority : 0
------
t_6:
AdjList :  vzero_1
degree : 1
Alias :None
Color : null
Priority : 0
------
saved.vs1_3:
AdjList : 
degree : 0
Alias :None
Color : null
Priority : 0
------
saved.vs3_3:
AdjList : 
degree : 0
Alias :None
Color : null
Priority : 0
------
saved.vs10_3:
AdjList : 
degree : 0
Alias :None
Color : null
Priority : 0
------
========__init move List Info ========
coalesced moves:
t_5 = move va0_1
------
constrained moves:
------
fronzen moves:
------
workList moves:
va0_1 = move t_6
t_6 = move t_5
------
active moves:
========__init Node List Info ========
simplify Nodes(low degree non move related):

------
freeze Nodes(low degree move related):
t_6(0) 
------
spill Nodes(high degree):

------
spilled Nodes:

------
coalesced Nodes:
t_5(0) 
------
colored Nodes:

------
selected Stack:
saved.vs7_3(0) saved.vs8_3(0) saved.vs1_3(0) saved.vs4_3(0) saved.vs11_3(0) saved.vs5_3(0) saved.vs6_3(0) saved.vs3_3(0) saved.vs2_3(0) saved.vs9_3(0) saved.vs10_3(0) 
------

===================== Coalesce =====================
========__init Graph Info ========
saved.vs7_3:
AdjList : 
degree : 0
Alias :None
Color : null
Priority : 0
------
saved.vs5_3:
AdjList : 
degree : 0
Alias :None
Color : null
Priority : 0
------
saved.vs8_3:
AdjList : 
degree : 0
Alias :None
Color : null
Priority : 0
------
saved.vs4_3:
AdjList : 
degree : 0
Alias :None
Color : null
Priority : 0
------
saved.vs11_3:
AdjList : 
degree : 0
Alias :None
Color : null
Priority : 0
------
saved.vs6_3:
AdjList : 
degree : 0
Alias :None
Color : null
Priority : 0
------
saved.vs2_3:
AdjList : 
degree : 0
Alias :None
Color : null
Priority : 0
------
saved.vs9_3:
AdjList : 
degree : 0
Alias :None
Color : null
Priority : 0
------
t_5:
AdjList :  vzero_1
degree : 1
Alias :va0_1
Color : null
Priority : 0
------
t_6:
AdjList :  vzero_1
degree : 1
Alias :va0_1
Color : null
Priority : 0
------
saved.vs1_3:
AdjList : 
degree : 0
Alias :None
Color : null
Priority : 0
------
saved.vs3_3:
AdjList : 
degree : 0
Alias :None
Color : null
Priority : 0
------
saved.vs10_3:
AdjList : 
degree : 0
Alias :None
Color : null
Priority : 0
------
========__init move List Info ========
coalesced moves:
t_5 = move va0_1
va0_1 = move t_6
------
constrained moves:
------
fronzen moves:
------
workList moves:
t_6 = move t_5
------
active moves:
========__init Node List Info ========
simplify Nodes(low degree non move related):

------
freeze Nodes(low degree move related):

------
spill Nodes(high degree):

------
spilled Nodes:

------
coalesced Nodes:
t_6(0) t_5(0) 
------
colored Nodes:

------
selected Stack:
saved.vs7_3(0) saved.vs8_3(0) saved.vs1_3(0) saved.vs4_3(0) saved.vs11_3(0) saved.vs5_3(0) saved.vs6_3(0) saved.vs3_3(0) saved.vs2_3(0) saved.vs9_3(0) saved.vs10_3(0) 
------

===================== Coalesce =====================
========__init Graph Info ========
saved.vs7_3:
AdjList : 
degree : 0
Alias :None
Color : null
Priority : 0
------
saved.vs5_3:
AdjList : 
degree : 0
Alias :None
Color : null
Priority : 0
------
saved.vs8_3:
AdjList : 
degree : 0
Alias :None
Color : null
Priority : 0
------
saved.vs4_3:
AdjList : 
degree : 0
Alias :None
Color : null
Priority : 0
------
saved.vs11_3:
AdjList : 
degree : 0
Alias :None
Color : null
Priority : 0
------
saved.vs6_3:
AdjList : 
degree : 0
Alias :None
Color : null
Priority : 0
------
saved.vs2_3:
AdjList : 
degree : 0
Alias :None
Color : null
Priority : 0
------
saved.vs9_3:
AdjList : 
degree : 0
Alias :None
Color : null
Priority : 0
------
t_5:
AdjList :  vzero_1
degree : 1
Alias :va0_1
Color : null
Priority : 0
------
t_6:
AdjList :  vzero_1
degree : 1
Alias :va0_1
Color : null
Priority : 0
------
saved.vs1_3:
AdjList : 
degree : 0
Alias :None
Color : null
Priority : 0
------
saved.vs3_3:
AdjList : 
degree : 0
Alias :None
Color : null
Priority : 0
------
saved.vs10_3:
AdjList : 
degree : 0
Alias :None
Color : null
Priority : 0
------
========__init move List Info ========
coalesced moves:
t_5 = move va0_1
va0_1 = move t_6
t_6 = move t_5
------
constrained moves:
------
fronzen moves:
------
workList moves:
------
active moves:
========__init Node List Info ========
simplify Nodes(low degree non move related):

------
freeze Nodes(low degree move related):

------
spill Nodes(high degree):

------
spilled Nodes:

------
coalesced Nodes:
t_6(0) t_5(0) 
------
colored Nodes:

------
selected Stack:
saved.vs7_3(0) saved.vs8_3(0) saved.vs1_3(0) saved.vs4_3(0) saved.vs11_3(0) saved.vs5_3(0) saved.vs6_3(0) saved.vs3_3(0) saved.vs2_3(0) saved.vs9_3(0) saved.vs10_3(0) 
------

===================== after ASSIGN =====================
========__init Graph Info ========
saved.vs7_3:
AdjList : 
degree : 0
Alias :None
Color : s11
Priority : 0
------
saved.vs5_3:
AdjList : 
degree : 0
Alias :None
Color : s11
Priority : 0
------
saved.vs8_3:
AdjList : 
degree : 0
Alias :None
Color : s11
Priority : 0
------
saved.vs4_3:
AdjList : 
degree : 0
Alias :None
Color : s11
Priority : 0
------
saved.vs11_3:
AdjList : 
degree : 0
Alias :None
Color : s11
Priority : 0
------
saved.vs6_3:
AdjList : 
degree : 0
Alias :None
Color : s11
Priority : 0
------
saved.vs2_3:
AdjList : 
degree : 0
Alias :None
Color : s11
Priority : 0
------
saved.vs9_3:
AdjList : 
degree : 0
Alias :None
Color : s11
Priority : 0
------
t_5:
AdjList :  vzero_1
degree : 1
Alias :va0_1
Color : a0
Priority : 0
------
t_6:
AdjList :  vzero_1
degree : 1
Alias :va0_1
Color : a0
Priority : 0
------
saved.vs1_3:
AdjList : 
degree : 0
Alias :None
Color : s11
Priority : 0
------
saved.vs3_3:
AdjList : 
degree : 0
Alias :None
Color : s11
Priority : 0
------
saved.vs10_3:
AdjList : 
degree : 0
Alias :None
Color : s11
Priority : 0
------
========__init move List Info ========
coalesced moves:
t_5 = move va0_1
va0_1 = move t_6
t_6 = move t_5
------
constrained moves:
------
fronzen moves:
------
workList moves:
------
active moves:
========__init Node List Info ========
simplify Nodes(low degree non move related):

------
freeze Nodes(low degree move related):

------
spill Nodes(high degree):

------
spilled Nodes:

------
coalesced Nodes:
t_6(0) t_5(0) 
------
colored Nodes:
saved.vs1_3(0) saved.vs8_3(0) saved.vs7_3(0) saved.vs11_3(0) saved.vs4_3(0) saved.vs5_3(0) saved.vs3_3(0) saved.vs6_3(0) saved.vs9_3(0) saved.vs2_3(0) saved.vs10_3(0) 
------
selected Stack:

------

