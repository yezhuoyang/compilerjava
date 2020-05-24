define i64 @tmp_tmp %this_1 {
tmp_tmp_entry_1:
   store %vs4_1 %vsp_1 null 0 44
   store %vs1_1 %vsp_1 null 0 40
   store %vs10_1 %vsp_1 null 0 36
   store %vs6_1 %vsp_1 null 0 32
   store %vs9_1 %vsp_1 null 0 28
   store %vs11_1 %vsp_1 null 0 24
   store %vs8_1 %vsp_1 null 0 20
   store %vs3_1 %vsp_1 null 0 16
   store %vs2_1 %vsp_1 null 0 12
   store %vs5_1 %vsp_1 null 0 8
   store %vs7_1 %vsp_1 null 0 4
   store %ra %vsp_1 null 0 0
   %this_1 = move %va0_1
   %t_1 = add %this_1 0
   %t_2 = move 4
   store %t_2 %t_1
   %t_3 = add %this_1 4
   %t_4 = move 5
   store %t_4 %t_3
   %va0_1 = move 0
   %ra = load %vsp_1 null 0 0
   %vs7_1 = load %vsp_1 null 0 4
   %vs5_1 = load %vsp_1 null 0 8
   %vs2_1 = load %vsp_1 null 0 12
   %vs3_1 = load %vsp_1 null 0 16
   %vs8_1 = load %vsp_1 null 0 20
   %vs11_1 = load %vsp_1 null 0 24
   %vs9_1 = load %vsp_1 null 0 28
   %vs6_1 = load %vsp_1 null 0 32
   %vs10_1 = load %vsp_1 null 0 36
   %vs1_1 = load %vsp_1 null 0 40
   %vs4_1 = load %vsp_1 null 0 44
   ret %va0_1
}

define i64 @tmp_fuck %this_2 {
tmp_fuck_entry_1:
   store %vs4_1 %vsp_1 null 0 44
   store %vs1_1 %vsp_1 null 0 40
   store %vs10_1 %vsp_1 null 0 36
   store %vs6_1 %vsp_1 null 0 32
   store %vs9_1 %vsp_1 null 0 28
   store %vs11_1 %vsp_1 null 0 24
   store %vs8_1 %vsp_1 null 0 20
   store %vs3_1 %vsp_1 null 0 16
   store %vs2_1 %vsp_1 null 0 12
   store %vs5_1 %vsp_1 null 0 8
   store %vs7_1 %vsp_1 null 0 4
   store %ra %vsp_1 null 0 0
   %this_2 = move %va0_1
   %t_5 = add %this_2 0
   %t_6 = add %this_2 4
   %t_7 = load %t_5
   %t_8 = load %t_6
   %t_9 = add %t_7 %t_8
   %t_10 = move %t_9
   %va0_1 = move %t_10
   %ra = load %vsp_1 null 0 0
   %vs7_1 = load %vsp_1 null 0 4
   %vs5_1 = load %vsp_1 null 0 8
   %vs2_1 = load %vsp_1 null 0 12
   %vs3_1 = load %vsp_1 null 0 16
   %vs8_1 = load %vsp_1 null 0 20
   %vs11_1 = load %vsp_1 null 0 24
   %vs9_1 = load %vsp_1 null 0 28
   %vs6_1 = load %vsp_1 null 0 32
   %vs10_1 = load %vsp_1 null 0 36
   %vs1_1 = load %vsp_1 null 0 40
   %vs4_1 = load %vsp_1 null 0 44
   ret %va0_1
}

define i64 @main  {
main_entry_1:
   store %vs4_1 %vsp_1 null 0 44
   store %vs1_1 %vsp_1 null 0 40
   store %vs10_1 %vsp_1 null 0 36
   store %vs6_1 %vsp_1 null 0 32
   store %vs9_1 %vsp_1 null 0 28
   store %vs11_1 %vsp_1 null 0 24
   store %vs8_1 %vsp_1 null 0 20
   store %vs3_1 %vsp_1 null 0 16
   store %vs2_1 %vsp_1 null 0 12
   store %vs5_1 %vsp_1 null 0 8
   store %vs7_1 %vsp_1 null 0 4
   store %ra %vsp_1 null 0 0
   %va0_1 = move 8
   %t_11 = alloc 8
   %t_11 = move %va0_1
   %va0_1 = move %t_11
   call tmp_tmp %va0_1 
   %alpha_1 = move %t_11
   %va0_1 = move %alpha_1
   %va0_1 = call tmp_fuck %va0_1 
   %t_12 = move %va0_1
   %t_13 = move %t_12
   %va0_1 = move %t_13
   %ra = load %vsp_1 null 0 0
   %vs7_1 = load %vsp_1 null 0 4
   %vs5_1 = load %vsp_1 null 0 8
   %vs2_1 = load %vsp_1 null 0 12
   %vs3_1 = load %vsp_1 null 0 16
   %vs8_1 = load %vsp_1 null 0 20
   %vs11_1 = load %vsp_1 null 0 24
   %vs9_1 = load %vsp_1 null 0 28
   %vs6_1 = load %vsp_1 null 0 32
   %vs10_1 = load %vsp_1 null 0 36
   %vs1_1 = load %vsp_1 null 0 40
   %vs4_1 = load %vsp_1 null 0 44
   ret %va0_1
}

define i64 @__init  {
__init_entry_1:
   store %vs4_1 %vsp_1 null 0 44
   store %vs1_1 %vsp_1 null 0 40
   store %vs10_1 %vsp_1 null 0 36
   store %vs6_1 %vsp_1 null 0 32
   store %vs9_1 %vsp_1 null 0 28
   store %vs11_1 %vsp_1 null 0 24
   store %vs8_1 %vsp_1 null 0 20
   store %vs3_1 %vsp_1 null 0 16
   store %vs2_1 %vsp_1 null 0 12
   store %vs5_1 %vsp_1 null 0 8
   store %vs7_1 %vsp_1 null 0 4
   store %ra %vsp_1 null 0 0
   %va0_1 = call main 
   %t_14 = move %va0_1
   %t_15 = move %t_14
   %va0_1 = move %t_15
   %ra = load %vsp_1 null 0 0
   %vs7_1 = load %vsp_1 null 0 4
   %vs5_1 = load %vsp_1 null 0 8
   %vs2_1 = load %vsp_1 null 0 12
   %vs3_1 = load %vsp_1 null 0 16
   %vs8_1 = load %vsp_1 null 0 20
   %vs11_1 = load %vsp_1 null 0 24
   %vs9_1 = load %vsp_1 null 0 28
   %vs6_1 = load %vsp_1 null 0 32
   %vs10_1 = load %vsp_1 null 0 36
   %vs1_1 = load %vsp_1 null 0 40
   %vs4_1 = load %vsp_1 null 0 44
   ret %va0_1
}

=====================tmp_tmp Iteration 0=====================
========tmp_tmp Graph Info ========
this_1:
AdjList :  vzero_1 t_2 t_1 vsp_1
degree : 4
Alias :None
Color : null
Priority : 0
------
t_1:
AdjList :  vzero_1 t_2 this_1 vsp_1
degree : 4
Alias :None
Color : null
Priority : 0
------
t_4:
AdjList :  vzero_1 t_3 vsp_1
degree : 3
Alias :None
Color : null
Priority : 0
------
t_2:
AdjList :  vzero_1 this_1 t_1 vsp_1
degree : 4
Alias :None
Color : null
Priority : 0
------
t_3:
AdjList :  vzero_1 t_4 vsp_1
degree : 3
Alias :None
Color : null
Priority : 0
------
========tmp_tmp move List Info ========
coalesced moves:
------
constrained moves:
------
fronzen moves:
------
workList moves:
this_1 = move va0_1
------
active moves:
========tmp_tmp Node List Info ========
simplify Nodes(low degree non move related):
t_2(0) t_3(0) t_1(0) t_4(0) 
------
freeze Nodes(low degree move related):
this_1(0) 
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

define i64 @tmp_tmp %this_1 {
tmp_tmp_entry_1:
   store %vs4_1 %vsp_1 null 0 44
   store %vs1_1 %vsp_1 null 0 40
   store %vs10_1 %vsp_1 null 0 36
   store %vs6_1 %vsp_1 null 0 32
   store %vs9_1 %vsp_1 null 0 28
   store %vs11_1 %vsp_1 null 0 24
   store %vs8_1 %vsp_1 null 0 20
   store %vs3_1 %vsp_1 null 0 16
   store %vs2_1 %vsp_1 null 0 12
   store %vs5_1 %vsp_1 null 0 8
   store %vs7_1 %vsp_1 null 0 4
   store %ra %vsp_1 null 0 0
   %this_1 = move %va0_1
   %t_1 = add %this_1 0
   %t_2 = move 4
   store %t_2 %t_1
   %t_3 = add %this_1 4
   %t_4 = move 5
   store %t_4 %t_3
   %va0_1 = move 0
   %ra = load %vsp_1 null 0 0
   %vs7_1 = load %vsp_1 null 0 4
   %vs5_1 = load %vsp_1 null 0 8
   %vs2_1 = load %vsp_1 null 0 12
   %vs3_1 = load %vsp_1 null 0 16
   %vs8_1 = load %vsp_1 null 0 20
   %vs11_1 = load %vsp_1 null 0 24
   %vs9_1 = load %vsp_1 null 0 28
   %vs6_1 = load %vsp_1 null 0 32
   %vs10_1 = load %vsp_1 null 0 36
   %vs1_1 = load %vsp_1 null 0 40
   %vs4_1 = load %vsp_1 null 0 44
   ret %va0_1
}

define i64 @tmp_fuck %this_2 {
tmp_fuck_entry_1:
   store %vs4_1 %vsp_1 null 0 44
   store %vs1_1 %vsp_1 null 0 40
   store %vs10_1 %vsp_1 null 0 36
   store %vs6_1 %vsp_1 null 0 32
   store %vs9_1 %vsp_1 null 0 28
   store %vs11_1 %vsp_1 null 0 24
   store %vs8_1 %vsp_1 null 0 20
   store %vs3_1 %vsp_1 null 0 16
   store %vs2_1 %vsp_1 null 0 12
   store %vs5_1 %vsp_1 null 0 8
   store %vs7_1 %vsp_1 null 0 4
   store %ra %vsp_1 null 0 0
   %this_2 = move %va0_1
   %t_5 = add %this_2 0
   %t_6 = add %this_2 4
   %t_7 = load %t_5
   %t_8 = load %t_6
   %t_9 = add %t_7 %t_8
   %t_10 = move %t_9
   %va0_1 = move %t_10
   %ra = load %vsp_1 null 0 0
   %vs7_1 = load %vsp_1 null 0 4
   %vs5_1 = load %vsp_1 null 0 8
   %vs2_1 = load %vsp_1 null 0 12
   %vs3_1 = load %vsp_1 null 0 16
   %vs8_1 = load %vsp_1 null 0 20
   %vs11_1 = load %vsp_1 null 0 24
   %vs9_1 = load %vsp_1 null 0 28
   %vs6_1 = load %vsp_1 null 0 32
   %vs10_1 = load %vsp_1 null 0 36
   %vs1_1 = load %vsp_1 null 0 40
   %vs4_1 = load %vsp_1 null 0 44
   ret %va0_1
}

define i64 @main  {
main_entry_1:
   store %vs4_1 %vsp_1 null 0 44
   store %vs1_1 %vsp_1 null 0 40
   store %vs10_1 %vsp_1 null 0 36
   store %vs6_1 %vsp_1 null 0 32
   store %vs9_1 %vsp_1 null 0 28
   store %vs11_1 %vsp_1 null 0 24
   store %vs8_1 %vsp_1 null 0 20
   store %vs3_1 %vsp_1 null 0 16
   store %vs2_1 %vsp_1 null 0 12
   store %vs5_1 %vsp_1 null 0 8
   store %vs7_1 %vsp_1 null 0 4
   store %ra %vsp_1 null 0 0
   %va0_1 = move 8
   %t_11 = alloc 8
   %t_11 = move %va0_1
   %va0_1 = move %t_11
   call tmp_tmp %va0_1 
   %alpha_1 = move %t_11
   %va0_1 = move %alpha_1
   %va0_1 = call tmp_fuck %va0_1 
   %t_12 = move %va0_1
   %t_13 = move %t_12
   %va0_1 = move %t_13
   %ra = load %vsp_1 null 0 0
   %vs7_1 = load %vsp_1 null 0 4
   %vs5_1 = load %vsp_1 null 0 8
   %vs2_1 = load %vsp_1 null 0 12
   %vs3_1 = load %vsp_1 null 0 16
   %vs8_1 = load %vsp_1 null 0 20
   %vs11_1 = load %vsp_1 null 0 24
   %vs9_1 = load %vsp_1 null 0 28
   %vs6_1 = load %vsp_1 null 0 32
   %vs10_1 = load %vsp_1 null 0 36
   %vs1_1 = load %vsp_1 null 0 40
   %vs4_1 = load %vsp_1 null 0 44
   ret %va0_1
}

define i64 @__init  {
__init_entry_1:
   store %vs4_1 %vsp_1 null 0 44
   store %vs1_1 %vsp_1 null 0 40
   store %vs10_1 %vsp_1 null 0 36
   store %vs6_1 %vsp_1 null 0 32
   store %vs9_1 %vsp_1 null 0 28
   store %vs11_1 %vsp_1 null 0 24
   store %vs8_1 %vsp_1 null 0 20
   store %vs3_1 %vsp_1 null 0 16
   store %vs2_1 %vsp_1 null 0 12
   store %vs5_1 %vsp_1 null 0 8
   store %vs7_1 %vsp_1 null 0 4
   store %ra %vsp_1 null 0 0
   %va0_1 = call main 
   %t_14 = move %va0_1
   %t_15 = move %t_14
   %va0_1 = move %t_15
   %ra = load %vsp_1 null 0 0
   %vs7_1 = load %vsp_1 null 0 4
   %vs5_1 = load %vsp_1 null 0 8
   %vs2_1 = load %vsp_1 null 0 12
   %vs3_1 = load %vsp_1 null 0 16
   %vs8_1 = load %vsp_1 null 0 20
   %vs11_1 = load %vsp_1 null 0 24
   %vs9_1 = load %vsp_1 null 0 28
   %vs6_1 = load %vsp_1 null 0 32
   %vs10_1 = load %vsp_1 null 0 36
   %vs1_1 = load %vsp_1 null 0 40
   %vs4_1 = load %vsp_1 null 0 44
   ret %va0_1
}

===================== Simplify =====================
========tmp_tmp Graph Info ========
this_1:
AdjList :  vzero_1 t_2 t_1 vsp_1
degree : 3
Alias :None
Color : null
Priority : 0
------
t_1:
AdjList :  vzero_1 t_2 this_1 vsp_1
degree : 3
Alias :None
Color : null
Priority : 0
------
t_4:
AdjList :  vzero_1 t_3 vsp_1
degree : 3
Alias :None
Color : null
Priority : 0
------
t_2:
AdjList :  vzero_1 this_1 t_1 vsp_1
degree : 4
Alias :None
Color : null
Priority : 0
------
t_3:
AdjList :  vzero_1 t_4 vsp_1
degree : 3
Alias :None
Color : null
Priority : 0
------
========tmp_tmp move List Info ========
coalesced moves:
------
constrained moves:
------
fronzen moves:
------
workList moves:
this_1 = move va0_1
------
active moves:
========tmp_tmp Node List Info ========
simplify Nodes(low degree non move related):
t_3(0) t_1(0) t_4(0) 
------
freeze Nodes(low degree move related):
this_1(0) 
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
t_2(0) 
------

===================== Simplify =====================
========tmp_tmp Graph Info ========
this_1:
AdjList :  vzero_1 t_2 t_1 vsp_1
degree : 3
Alias :None
Color : null
Priority : 0
------
t_1:
AdjList :  vzero_1 t_2 this_1 vsp_1
degree : 3
Alias :None
Color : null
Priority : 0
------
t_4:
AdjList :  vzero_1 t_3 vsp_1
degree : 2
Alias :None
Color : null
Priority : 0
------
t_2:
AdjList :  vzero_1 this_1 t_1 vsp_1
degree : 4
Alias :None
Color : null
Priority : 0
------
t_3:
AdjList :  vzero_1 t_4 vsp_1
degree : 3
Alias :None
Color : null
Priority : 0
------
========tmp_tmp move List Info ========
coalesced moves:
------
constrained moves:
------
fronzen moves:
------
workList moves:
this_1 = move va0_1
------
active moves:
========tmp_tmp Node List Info ========
simplify Nodes(low degree non move related):
t_1(0) t_4(0) 
------
freeze Nodes(low degree move related):
this_1(0) 
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
t_2(0) t_3(0) 
------

===================== Simplify =====================
========tmp_tmp Graph Info ========
this_1:
AdjList :  vzero_1 t_2 t_1 vsp_1
degree : 2
Alias :None
Color : null
Priority : 0
------
t_1:
AdjList :  vzero_1 t_2 this_1 vsp_1
degree : 3
Alias :None
Color : null
Priority : 0
------
t_4:
AdjList :  vzero_1 t_3 vsp_1
degree : 2
Alias :None
Color : null
Priority : 0
------
t_2:
AdjList :  vzero_1 this_1 t_1 vsp_1
degree : 4
Alias :None
Color : null
Priority : 0
------
t_3:
AdjList :  vzero_1 t_4 vsp_1
degree : 3
Alias :None
Color : null
Priority : 0
------
========tmp_tmp move List Info ========
coalesced moves:
------
constrained moves:
------
fronzen moves:
------
workList moves:
this_1 = move va0_1
------
active moves:
========tmp_tmp Node List Info ========
simplify Nodes(low degree non move related):
t_4(0) 
------
freeze Nodes(low degree move related):
this_1(0) 
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
t_2(0) t_3(0) t_1(0) 
------

===================== Simplify =====================
========tmp_tmp Graph Info ========
this_1:
AdjList :  vzero_1 t_2 t_1 vsp_1
degree : 2
Alias :None
Color : null
Priority : 0
------
t_1:
AdjList :  vzero_1 t_2 this_1 vsp_1
degree : 3
Alias :None
Color : null
Priority : 0
------
t_4:
AdjList :  vzero_1 t_3 vsp_1
degree : 2
Alias :None
Color : null
Priority : 0
------
t_2:
AdjList :  vzero_1 this_1 t_1 vsp_1
degree : 4
Alias :None
Color : null
Priority : 0
------
t_3:
AdjList :  vzero_1 t_4 vsp_1
degree : 3
Alias :None
Color : null
Priority : 0
------
========tmp_tmp move List Info ========
coalesced moves:
------
constrained moves:
------
fronzen moves:
------
workList moves:
this_1 = move va0_1
------
active moves:
========tmp_tmp Node List Info ========
simplify Nodes(low degree non move related):

------
freeze Nodes(low degree move related):
this_1(0) 
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
t_2(0) t_3(0) t_1(0) t_4(0) 
------

===================== Coalesce =====================
========tmp_tmp Graph Info ========
this_1:
AdjList :  vzero_1 t_2 t_1 vsp_1
degree : 2
Alias :va0_1
Color : null
Priority : 0
------
t_1:
AdjList :  vzero_1 t_2 this_1 vsp_1
degree : 3
Alias :None
Color : null
Priority : 0
------
t_4:
AdjList :  vzero_1 t_3 vsp_1
degree : 2
Alias :None
Color : null
Priority : 0
------
t_2:
AdjList :  vzero_1 this_1 t_1 vsp_1
degree : 4
Alias :None
Color : null
Priority : 0
------
t_3:
AdjList :  vzero_1 t_4 vsp_1
degree : 3
Alias :None
Color : null
Priority : 0
------
========tmp_tmp move List Info ========
coalesced moves:
this_1 = move va0_1
------
constrained moves:
------
fronzen moves:
------
workList moves:
------
active moves:
========tmp_tmp Node List Info ========
simplify Nodes(low degree non move related):

------
freeze Nodes(low degree move related):

------
spill Nodes(high degree):

------
spilled Nodes:

------
coalesced Nodes:
this_1(0) 
------
colored Nodes:

------
selected Stack:
t_2(0) t_3(0) t_1(0) t_4(0) 
------

===================== after ASSIGN =====================
========tmp_tmp Graph Info ========
this_1:
AdjList :  vzero_1 t_2 t_1 vsp_1
degree : 2
Alias :va0_1
Color : a0
Priority : 0
------
t_1:
AdjList :  vzero_1 t_2 this_1 vsp_1
degree : 3
Alias :None
Color : s5
Priority : 0
------
t_4:
AdjList :  vzero_1 t_3 vsp_1
degree : 2
Alias :None
Color : s5
Priority : 0
------
t_2:
AdjList :  vzero_1 this_1 t_1 vsp_1
degree : 4
Alias :None
Color : s2
Priority : 0
------
t_3:
AdjList :  vzero_1 t_4 vsp_1
degree : 3
Alias :None
Color : s2
Priority : 0
------
========tmp_tmp move List Info ========
coalesced moves:
this_1 = move va0_1
------
constrained moves:
------
fronzen moves:
------
workList moves:
------
active moves:
========tmp_tmp Node List Info ========
simplify Nodes(low degree non move related):

------
freeze Nodes(low degree move related):

------
spill Nodes(high degree):

------
spilled Nodes:

------
coalesced Nodes:
this_1(0) 
------
colored Nodes:
t_2(0) t_3(0) t_1(0) t_4(0) 
------
selected Stack:

------

=====================tmp_fuck Iteration 0=====================
========tmp_fuck Graph Info ========
t_5:
AdjList :  t_6 vzero_1 vsp_1 this_2
degree : 4
Alias :None
Color : null
Priority : 0
------
this_2:
AdjList :  t_5 vzero_1 vsp_1
degree : 3
Alias :None
Color : null
Priority : 0
------
t_8:
AdjList :  vzero_1 t_7 vsp_1
degree : 3
Alias :None
Color : null
Priority : 0
------
t_6:
AdjList :  vzero_1 t_5 t_7 vsp_1
degree : 4
Alias :None
Color : null
Priority : 0
------
t_7:
AdjList :  vzero_1 t_6 vsp_1 t_8
degree : 4
Alias :None
Color : null
Priority : 0
------
t_10:
AdjList :  vzero_1 vsp_1
degree : 2
Alias :None
Color : null
Priority : 0
------
t_9:
AdjList :  vzero_1 vsp_1
degree : 2
Alias :None
Color : null
Priority : 0
------
========tmp_fuck move List Info ========
coalesced moves:
------
constrained moves:
------
fronzen moves:
------
workList moves:
this_2 = move va0_1
va0_1 = move t_10
t_10 = move t_9
------
active moves:
========tmp_fuck Node List Info ========
simplify Nodes(low degree non move related):
t_5(0) t_6(0) t_7(0) t_8(0) 
------
freeze Nodes(low degree move related):
t_10(0) t_9(0) this_2(0) 
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

define i64 @tmp_tmp %this_1 {
tmp_tmp_entry_1:
   store %vs4_1 %vsp_1 null 0 44
   store %vs1_1 %vsp_1 null 0 40
   store %vs10_1 %vsp_1 null 0 36
   store %vs6_1 %vsp_1 null 0 32
   store %vs9_1 %vsp_1 null 0 28
   store %vs11_1 %vsp_1 null 0 24
   store %vs8_1 %vsp_1 null 0 20
   store %vs3_1 %vsp_1 null 0 16
   store %vs2_1 %vsp_1 null 0 12
   store %vs5_1 %vsp_1 null 0 8
   store %vs7_1 %vsp_1 null 0 4
   store %ra %vsp_1 null 0 0
   %this_1 = move %va0_1
   %t_1 = add %this_1 0
   %t_2 = move 4
   store %t_2 %t_1
   %t_3 = add %this_1 4
   %t_4 = move 5
   store %t_4 %t_3
   %va0_1 = move 0
   %ra = load %vsp_1 null 0 0
   %vs7_1 = load %vsp_1 null 0 4
   %vs5_1 = load %vsp_1 null 0 8
   %vs2_1 = load %vsp_1 null 0 12
   %vs3_1 = load %vsp_1 null 0 16
   %vs8_1 = load %vsp_1 null 0 20
   %vs11_1 = load %vsp_1 null 0 24
   %vs9_1 = load %vsp_1 null 0 28
   %vs6_1 = load %vsp_1 null 0 32
   %vs10_1 = load %vsp_1 null 0 36
   %vs1_1 = load %vsp_1 null 0 40
   %vs4_1 = load %vsp_1 null 0 44
   ret %va0_1
}

define i64 @tmp_fuck %this_2 {
tmp_fuck_entry_1:
   store %vs4_1 %vsp_1 null 0 44
   store %vs1_1 %vsp_1 null 0 40
   store %vs10_1 %vsp_1 null 0 36
   store %vs6_1 %vsp_1 null 0 32
   store %vs9_1 %vsp_1 null 0 28
   store %vs11_1 %vsp_1 null 0 24
   store %vs8_1 %vsp_1 null 0 20
   store %vs3_1 %vsp_1 null 0 16
   store %vs2_1 %vsp_1 null 0 12
   store %vs5_1 %vsp_1 null 0 8
   store %vs7_1 %vsp_1 null 0 4
   store %ra %vsp_1 null 0 0
   %this_2 = move %va0_1
   %t_5 = add %this_2 0
   %t_6 = add %this_2 4
   %t_7 = load %t_5
   %t_8 = load %t_6
   %t_9 = add %t_7 %t_8
   %t_10 = move %t_9
   %va0_1 = move %t_10
   %ra = load %vsp_1 null 0 0
   %vs7_1 = load %vsp_1 null 0 4
   %vs5_1 = load %vsp_1 null 0 8
   %vs2_1 = load %vsp_1 null 0 12
   %vs3_1 = load %vsp_1 null 0 16
   %vs8_1 = load %vsp_1 null 0 20
   %vs11_1 = load %vsp_1 null 0 24
   %vs9_1 = load %vsp_1 null 0 28
   %vs6_1 = load %vsp_1 null 0 32
   %vs10_1 = load %vsp_1 null 0 36
   %vs1_1 = load %vsp_1 null 0 40
   %vs4_1 = load %vsp_1 null 0 44
   ret %va0_1
}

define i64 @main  {
main_entry_1:
   store %vs4_1 %vsp_1 null 0 44
   store %vs1_1 %vsp_1 null 0 40
   store %vs10_1 %vsp_1 null 0 36
   store %vs6_1 %vsp_1 null 0 32
   store %vs9_1 %vsp_1 null 0 28
   store %vs11_1 %vsp_1 null 0 24
   store %vs8_1 %vsp_1 null 0 20
   store %vs3_1 %vsp_1 null 0 16
   store %vs2_1 %vsp_1 null 0 12
   store %vs5_1 %vsp_1 null 0 8
   store %vs7_1 %vsp_1 null 0 4
   store %ra %vsp_1 null 0 0
   %va0_1 = move 8
   %t_11 = alloc 8
   %t_11 = move %va0_1
   %va0_1 = move %t_11
   call tmp_tmp %va0_1 
   %alpha_1 = move %t_11
   %va0_1 = move %alpha_1
   %va0_1 = call tmp_fuck %va0_1 
   %t_12 = move %va0_1
   %t_13 = move %t_12
   %va0_1 = move %t_13
   %ra = load %vsp_1 null 0 0
   %vs7_1 = load %vsp_1 null 0 4
   %vs5_1 = load %vsp_1 null 0 8
   %vs2_1 = load %vsp_1 null 0 12
   %vs3_1 = load %vsp_1 null 0 16
   %vs8_1 = load %vsp_1 null 0 20
   %vs11_1 = load %vsp_1 null 0 24
   %vs9_1 = load %vsp_1 null 0 28
   %vs6_1 = load %vsp_1 null 0 32
   %vs10_1 = load %vsp_1 null 0 36
   %vs1_1 = load %vsp_1 null 0 40
   %vs4_1 = load %vsp_1 null 0 44
   ret %va0_1
}

define i64 @__init  {
__init_entry_1:
   store %vs4_1 %vsp_1 null 0 44
   store %vs1_1 %vsp_1 null 0 40
   store %vs10_1 %vsp_1 null 0 36
   store %vs6_1 %vsp_1 null 0 32
   store %vs9_1 %vsp_1 null 0 28
   store %vs11_1 %vsp_1 null 0 24
   store %vs8_1 %vsp_1 null 0 20
   store %vs3_1 %vsp_1 null 0 16
   store %vs2_1 %vsp_1 null 0 12
   store %vs5_1 %vsp_1 null 0 8
   store %vs7_1 %vsp_1 null 0 4
   store %ra %vsp_1 null 0 0
   %va0_1 = call main 
   %t_14 = move %va0_1
   %t_15 = move %t_14
   %va0_1 = move %t_15
   %ra = load %vsp_1 null 0 0
   %vs7_1 = load %vsp_1 null 0 4
   %vs5_1 = load %vsp_1 null 0 8
   %vs2_1 = load %vsp_1 null 0 12
   %vs3_1 = load %vsp_1 null 0 16
   %vs8_1 = load %vsp_1 null 0 20
   %vs11_1 = load %vsp_1 null 0 24
   %vs9_1 = load %vsp_1 null 0 28
   %vs6_1 = load %vsp_1 null 0 32
   %vs10_1 = load %vsp_1 null 0 36
   %vs1_1 = load %vsp_1 null 0 40
   %vs4_1 = load %vsp_1 null 0 44
   ret %va0_1
}

===================== Simplify =====================
========tmp_fuck Graph Info ========
t_5:
AdjList :  t_6 vzero_1 vsp_1 this_2
degree : 4
Alias :None
Color : null
Priority : 0
------
this_2:
AdjList :  t_5 vzero_1 vsp_1
degree : 2
Alias :None
Color : null
Priority : 0
------
t_8:
AdjList :  vzero_1 t_7 vsp_1
degree : 3
Alias :None
Color : null
Priority : 0
------
t_6:
AdjList :  vzero_1 t_5 t_7 vsp_1
degree : 3
Alias :None
Color : null
Priority : 0
------
t_7:
AdjList :  vzero_1 t_6 vsp_1 t_8
degree : 4
Alias :None
Color : null
Priority : 0
------
t_10:
AdjList :  vzero_1 vsp_1
degree : 2
Alias :None
Color : null
Priority : 0
------
t_9:
AdjList :  vzero_1 vsp_1
degree : 2
Alias :None
Color : null
Priority : 0
------
========tmp_fuck move List Info ========
coalesced moves:
------
constrained moves:
------
fronzen moves:
------
workList moves:
this_2 = move va0_1
va0_1 = move t_10
t_10 = move t_9
------
active moves:
========tmp_fuck Node List Info ========
simplify Nodes(low degree non move related):
t_6(0) t_7(0) t_8(0) 
------
freeze Nodes(low degree move related):
t_10(0) t_9(0) this_2(0) 
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
t_5(0) 
------

===================== Simplify =====================
========tmp_fuck Graph Info ========
t_5:
AdjList :  t_6 vzero_1 vsp_1 this_2
degree : 4
Alias :None
Color : null
Priority : 0
------
this_2:
AdjList :  t_5 vzero_1 vsp_1
degree : 2
Alias :None
Color : null
Priority : 0
------
t_8:
AdjList :  vzero_1 t_7 vsp_1
degree : 3
Alias :None
Color : null
Priority : 0
------
t_6:
AdjList :  vzero_1 t_5 t_7 vsp_1
degree : 3
Alias :None
Color : null
Priority : 0
------
t_7:
AdjList :  vzero_1 t_6 vsp_1 t_8
degree : 3
Alias :None
Color : null
Priority : 0
------
t_10:
AdjList :  vzero_1 vsp_1
degree : 2
Alias :None
Color : null
Priority : 0
------
t_9:
AdjList :  vzero_1 vsp_1
degree : 2
Alias :None
Color : null
Priority : 0
------
========tmp_fuck move List Info ========
coalesced moves:
------
constrained moves:
------
fronzen moves:
------
workList moves:
this_2 = move va0_1
va0_1 = move t_10
t_10 = move t_9
------
active moves:
========tmp_fuck Node List Info ========
simplify Nodes(low degree non move related):
t_7(0) t_8(0) 
------
freeze Nodes(low degree move related):
t_10(0) t_9(0) this_2(0) 
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
t_5(0) t_6(0) 
------

===================== Simplify =====================
========tmp_fuck Graph Info ========
t_5:
AdjList :  t_6 vzero_1 vsp_1 this_2
degree : 4
Alias :None
Color : null
Priority : 0
------
this_2:
AdjList :  t_5 vzero_1 vsp_1
degree : 2
Alias :None
Color : null
Priority : 0
------
t_8:
AdjList :  vzero_1 t_7 vsp_1
degree : 2
Alias :None
Color : null
Priority : 0
------
t_6:
AdjList :  vzero_1 t_5 t_7 vsp_1
degree : 3
Alias :None
Color : null
Priority : 0
------
t_7:
AdjList :  vzero_1 t_6 vsp_1 t_8
degree : 3
Alias :None
Color : null
Priority : 0
------
t_10:
AdjList :  vzero_1 vsp_1
degree : 2
Alias :None
Color : null
Priority : 0
------
t_9:
AdjList :  vzero_1 vsp_1
degree : 2
Alias :None
Color : null
Priority : 0
------
========tmp_fuck move List Info ========
coalesced moves:
------
constrained moves:
------
fronzen moves:
------
workList moves:
this_2 = move va0_1
va0_1 = move t_10
t_10 = move t_9
------
active moves:
========tmp_fuck Node List Info ========
simplify Nodes(low degree non move related):
t_8(0) 
------
freeze Nodes(low degree move related):
t_10(0) t_9(0) this_2(0) 
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
t_5(0) t_6(0) t_7(0) 
------

===================== Simplify =====================
========tmp_fuck Graph Info ========
t_5:
AdjList :  t_6 vzero_1 vsp_1 this_2
degree : 4
Alias :None
Color : null
Priority : 0
------
this_2:
AdjList :  t_5 vzero_1 vsp_1
degree : 2
Alias :None
Color : null
Priority : 0
------
t_8:
AdjList :  vzero_1 t_7 vsp_1
degree : 2
Alias :None
Color : null
Priority : 0
------
t_6:
AdjList :  vzero_1 t_5 t_7 vsp_1
degree : 3
Alias :None
Color : null
Priority : 0
------
t_7:
AdjList :  vzero_1 t_6 vsp_1 t_8
degree : 3
Alias :None
Color : null
Priority : 0
------
t_10:
AdjList :  vzero_1 vsp_1
degree : 2
Alias :None
Color : null
Priority : 0
------
t_9:
AdjList :  vzero_1 vsp_1
degree : 2
Alias :None
Color : null
Priority : 0
------
========tmp_fuck move List Info ========
coalesced moves:
------
constrained moves:
------
fronzen moves:
------
workList moves:
this_2 = move va0_1
va0_1 = move t_10
t_10 = move t_9
------
active moves:
========tmp_fuck Node List Info ========
simplify Nodes(low degree non move related):

------
freeze Nodes(low degree move related):
t_10(0) t_9(0) this_2(0) 
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
t_5(0) t_6(0) t_7(0) t_8(0) 
------

===================== Coalesce =====================
========tmp_fuck Graph Info ========
t_5:
AdjList :  t_6 vzero_1 vsp_1 this_2
degree : 4
Alias :None
Color : null
Priority : 0
------
this_2:
AdjList :  t_5 vzero_1 vsp_1
degree : 2
Alias :va0_1
Color : null
Priority : 0
------
t_8:
AdjList :  vzero_1 t_7 vsp_1
degree : 2
Alias :None
Color : null
Priority : 0
------
t_6:
AdjList :  vzero_1 t_5 t_7 vsp_1
degree : 3
Alias :None
Color : null
Priority : 0
------
t_7:
AdjList :  vzero_1 t_6 vsp_1 t_8
degree : 3
Alias :None
Color : null
Priority : 0
------
t_10:
AdjList :  vzero_1 vsp_1
degree : 2
Alias :None
Color : null
Priority : 0
------
t_9:
AdjList :  vzero_1 vsp_1
degree : 2
Alias :None
Color : null
Priority : 0
------
========tmp_fuck move List Info ========
coalesced moves:
this_2 = move va0_1
------
constrained moves:
------
fronzen moves:
------
workList moves:
va0_1 = move t_10
t_10 = move t_9
------
active moves:
========tmp_fuck Node List Info ========
simplify Nodes(low degree non move related):

------
freeze Nodes(low degree move related):
t_10(0) t_9(0) 
------
spill Nodes(high degree):

------
spilled Nodes:

------
coalesced Nodes:
this_2(0) 
------
colored Nodes:

------
selected Stack:
t_5(0) t_6(0) t_7(0) t_8(0) 
------

===================== Coalesce =====================
========tmp_fuck Graph Info ========
t_5:
AdjList :  t_6 vzero_1 vsp_1 this_2
degree : 4
Alias :None
Color : null
Priority : 0
------
this_2:
AdjList :  t_5 vzero_1 vsp_1
degree : 2
Alias :va0_1
Color : null
Priority : 0
------
t_8:
AdjList :  vzero_1 t_7 vsp_1
degree : 2
Alias :None
Color : null
Priority : 0
------
t_6:
AdjList :  vzero_1 t_5 t_7 vsp_1
degree : 3
Alias :None
Color : null
Priority : 0
------
t_7:
AdjList :  vzero_1 t_6 vsp_1 t_8
degree : 3
Alias :None
Color : null
Priority : 0
------
t_10:
AdjList :  vzero_1 vsp_1
degree : 2
Alias :va0_1
Color : null
Priority : 0
------
t_9:
AdjList :  vzero_1 vsp_1
degree : 2
Alias :None
Color : null
Priority : 0
------
========tmp_fuck move List Info ========
coalesced moves:
this_2 = move va0_1
va0_1 = move t_10
------
constrained moves:
------
fronzen moves:
------
workList moves:
t_10 = move t_9
------
active moves:
========tmp_fuck Node List Info ========
simplify Nodes(low degree non move related):

------
freeze Nodes(low degree move related):
t_9(0) 
------
spill Nodes(high degree):

------
spilled Nodes:

------
coalesced Nodes:
t_10(0) this_2(0) 
------
colored Nodes:

------
selected Stack:
t_5(0) t_6(0) t_7(0) t_8(0) 
------

===================== Coalesce =====================
========tmp_fuck Graph Info ========
t_5:
AdjList :  t_6 vzero_1 vsp_1 this_2
degree : 4
Alias :None
Color : null
Priority : 0
------
this_2:
AdjList :  t_5 vzero_1 vsp_1
degree : 2
Alias :va0_1
Color : null
Priority : 0
------
t_8:
AdjList :  vzero_1 t_7 vsp_1
degree : 2
Alias :None
Color : null
Priority : 0
------
t_6:
AdjList :  vzero_1 t_5 t_7 vsp_1
degree : 3
Alias :None
Color : null
Priority : 0
------
t_7:
AdjList :  vzero_1 t_6 vsp_1 t_8
degree : 3
Alias :None
Color : null
Priority : 0
------
t_10:
AdjList :  vzero_1 vsp_1
degree : 2
Alias :va0_1
Color : null
Priority : 0
------
t_9:
AdjList :  vzero_1 vsp_1
degree : 2
Alias :va0_1
Color : null
Priority : 0
------
========tmp_fuck move List Info ========
coalesced moves:
this_2 = move va0_1
va0_1 = move t_10
t_10 = move t_9
------
constrained moves:
------
fronzen moves:
------
workList moves:
------
active moves:
========tmp_fuck Node List Info ========
simplify Nodes(low degree non move related):

------
freeze Nodes(low degree move related):

------
spill Nodes(high degree):

------
spilled Nodes:

------
coalesced Nodes:
t_10(0) t_9(0) this_2(0) 
------
colored Nodes:

------
selected Stack:
t_5(0) t_6(0) t_7(0) t_8(0) 
------

===================== after ASSIGN =====================
========tmp_fuck Graph Info ========
t_5:
AdjList :  t_6 vzero_1 vsp_1 this_2
degree : 4
Alias :None
Color : s2
Priority : 0
------
this_2:
AdjList :  t_5 vzero_1 vsp_1
degree : 2
Alias :va0_1
Color : a0
Priority : 0
------
t_8:
AdjList :  vzero_1 t_7 vsp_1
degree : 2
Alias :None
Color : s5
Priority : 0
------
t_6:
AdjList :  vzero_1 t_5 t_7 vsp_1
degree : 3
Alias :None
Color : s5
Priority : 0
------
t_7:
AdjList :  vzero_1 t_6 vsp_1 t_8
degree : 3
Alias :None
Color : s2
Priority : 0
------
t_10:
AdjList :  vzero_1 vsp_1
degree : 2
Alias :va0_1
Color : a0
Priority : 0
------
t_9:
AdjList :  vzero_1 vsp_1
degree : 2
Alias :va0_1
Color : a0
Priority : 0
------
========tmp_fuck move List Info ========
coalesced moves:
this_2 = move va0_1
va0_1 = move t_10
t_10 = move t_9
------
constrained moves:
------
fronzen moves:
------
workList moves:
------
active moves:
========tmp_fuck Node List Info ========
simplify Nodes(low degree non move related):

------
freeze Nodes(low degree move related):

------
spill Nodes(high degree):

------
spilled Nodes:

------
coalesced Nodes:
t_10(0) t_9(0) this_2(0) 
------
colored Nodes:
t_6(0) t_5(0) t_7(0) t_8(0) 
------
selected Stack:

------

=====================main Iteration 0=====================
========main Graph Info ========
t_11:
AdjList :  va1_1 vt3_1 vt2_1 vzero_1 vs7_1 va7_1 va2_1 vs0_1 vs5_1 va6_1 vs3_1 vs8_1 vs11_1 va3_1 vs9_1 vs1_1 vs4_1 vra_1 vt6_1 vtp_1 vt1_1 va5_1 vt4_1 va4_1 vsp_1 vt5_1 vs2_1 vt0_1 va0_1 vgp_1 vs6_1 vs10_1
degree : 32
Alias :None
Color : null
Priority : 0
------
alpha_1:
AdjList :  vzero_1 vsp_1
degree : 2
Alias :None
Color : null
Priority : 0
------
t_12:
AdjList :  vzero_1 vsp_1
degree : 2
Alias :None
Color : null
Priority : 0
------
t_13:
AdjList :  vzero_1 vsp_1
degree : 2
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
va0_1 = move t_13
va0_1 = move alpha_1
t_11 = move va0_1
t_13 = move t_12
t_12 = move va0_1
alpha_1 = move t_11
va0_1 = move t_11
------
active moves:
========main Node List Info ========
simplify Nodes(low degree non move related):

------
freeze Nodes(low degree move related):
t_12(0) t_13(0) alpha_1(0) 
------
spill Nodes(high degree):
t_11(0) 
------
spilled Nodes:

------
coalesced Nodes:

------
colored Nodes:

------
selected Stack:

------

define i64 @tmp_tmp %this_1 {
tmp_tmp_entry_1:
   store %vs4_1 %vsp_1 null 0 44
   store %vs1_1 %vsp_1 null 0 40
   store %vs10_1 %vsp_1 null 0 36
   store %vs6_1 %vsp_1 null 0 32
   store %vs9_1 %vsp_1 null 0 28
   store %vs11_1 %vsp_1 null 0 24
   store %vs8_1 %vsp_1 null 0 20
   store %vs3_1 %vsp_1 null 0 16
   store %vs2_1 %vsp_1 null 0 12
   store %vs5_1 %vsp_1 null 0 8
   store %vs7_1 %vsp_1 null 0 4
   store %ra %vsp_1 null 0 0
   %this_1 = move %va0_1
   %t_1 = add %this_1 0
   %t_2 = move 4
   store %t_2 %t_1
   %t_3 = add %this_1 4
   %t_4 = move 5
   store %t_4 %t_3
   %va0_1 = move 0
   %ra = load %vsp_1 null 0 0
   %vs7_1 = load %vsp_1 null 0 4
   %vs5_1 = load %vsp_1 null 0 8
   %vs2_1 = load %vsp_1 null 0 12
   %vs3_1 = load %vsp_1 null 0 16
   %vs8_1 = load %vsp_1 null 0 20
   %vs11_1 = load %vsp_1 null 0 24
   %vs9_1 = load %vsp_1 null 0 28
   %vs6_1 = load %vsp_1 null 0 32
   %vs10_1 = load %vsp_1 null 0 36
   %vs1_1 = load %vsp_1 null 0 40
   %vs4_1 = load %vsp_1 null 0 44
   ret %va0_1
}

define i64 @tmp_fuck %this_2 {
tmp_fuck_entry_1:
   store %vs4_1 %vsp_1 null 0 44
   store %vs1_1 %vsp_1 null 0 40
   store %vs10_1 %vsp_1 null 0 36
   store %vs6_1 %vsp_1 null 0 32
   store %vs9_1 %vsp_1 null 0 28
   store %vs11_1 %vsp_1 null 0 24
   store %vs8_1 %vsp_1 null 0 20
   store %vs3_1 %vsp_1 null 0 16
   store %vs2_1 %vsp_1 null 0 12
   store %vs5_1 %vsp_1 null 0 8
   store %vs7_1 %vsp_1 null 0 4
   store %ra %vsp_1 null 0 0
   %this_2 = move %va0_1
   %t_5 = add %this_2 0
   %t_6 = add %this_2 4
   %t_7 = load %t_5
   %t_8 = load %t_6
   %t_9 = add %t_7 %t_8
   %t_10 = move %t_9
   %va0_1 = move %t_10
   %ra = load %vsp_1 null 0 0
   %vs7_1 = load %vsp_1 null 0 4
   %vs5_1 = load %vsp_1 null 0 8
   %vs2_1 = load %vsp_1 null 0 12
   %vs3_1 = load %vsp_1 null 0 16
   %vs8_1 = load %vsp_1 null 0 20
   %vs11_1 = load %vsp_1 null 0 24
   %vs9_1 = load %vsp_1 null 0 28
   %vs6_1 = load %vsp_1 null 0 32
   %vs10_1 = load %vsp_1 null 0 36
   %vs1_1 = load %vsp_1 null 0 40
   %vs4_1 = load %vsp_1 null 0 44
   ret %va0_1
}

define i64 @main  {
main_entry_1:
   store %vs4_1 %vsp_1 null 0 44
   store %vs1_1 %vsp_1 null 0 40
   store %vs10_1 %vsp_1 null 0 36
   store %vs6_1 %vsp_1 null 0 32
   store %vs9_1 %vsp_1 null 0 28
   store %vs11_1 %vsp_1 null 0 24
   store %vs8_1 %vsp_1 null 0 20
   store %vs3_1 %vsp_1 null 0 16
   store %vs2_1 %vsp_1 null 0 12
   store %vs5_1 %vsp_1 null 0 8
   store %vs7_1 %vsp_1 null 0 4
   store %ra %vsp_1 null 0 0
   %va0_1 = move 8
   %t_11 = alloc 8
   %t_11 = move %va0_1
   %va0_1 = move %t_11
   call tmp_tmp %va0_1 
   %alpha_1 = move %t_11
   %va0_1 = move %alpha_1
   %va0_1 = call tmp_fuck %va0_1 
   %t_12 = move %va0_1
   %t_13 = move %t_12
   %va0_1 = move %t_13
   %ra = load %vsp_1 null 0 0
   %vs7_1 = load %vsp_1 null 0 4
   %vs5_1 = load %vsp_1 null 0 8
   %vs2_1 = load %vsp_1 null 0 12
   %vs3_1 = load %vsp_1 null 0 16
   %vs8_1 = load %vsp_1 null 0 20
   %vs11_1 = load %vsp_1 null 0 24
   %vs9_1 = load %vsp_1 null 0 28
   %vs6_1 = load %vsp_1 null 0 32
   %vs10_1 = load %vsp_1 null 0 36
   %vs1_1 = load %vsp_1 null 0 40
   %vs4_1 = load %vsp_1 null 0 44
   ret %va0_1
}

define i64 @__init  {
__init_entry_1:
   store %vs4_1 %vsp_1 null 0 44
   store %vs1_1 %vsp_1 null 0 40
   store %vs10_1 %vsp_1 null 0 36
   store %vs6_1 %vsp_1 null 0 32
   store %vs9_1 %vsp_1 null 0 28
   store %vs11_1 %vsp_1 null 0 24
   store %vs8_1 %vsp_1 null 0 20
   store %vs3_1 %vsp_1 null 0 16
   store %vs2_1 %vsp_1 null 0 12
   store %vs5_1 %vsp_1 null 0 8
   store %vs7_1 %vsp_1 null 0 4
   store %ra %vsp_1 null 0 0
   %va0_1 = call main 
   %t_14 = move %va0_1
   %t_15 = move %t_14
   %va0_1 = move %t_15
   %ra = load %vsp_1 null 0 0
   %vs7_1 = load %vsp_1 null 0 4
   %vs5_1 = load %vsp_1 null 0 8
   %vs2_1 = load %vsp_1 null 0 12
   %vs3_1 = load %vsp_1 null 0 16
   %vs8_1 = load %vsp_1 null 0 20
   %vs11_1 = load %vsp_1 null 0 24
   %vs9_1 = load %vsp_1 null 0 28
   %vs6_1 = load %vsp_1 null 0 32
   %vs10_1 = load %vsp_1 null 0 36
   %vs1_1 = load %vsp_1 null 0 40
   %vs4_1 = load %vsp_1 null 0 44
   ret %va0_1
}

===================== Coalesce =====================
========main Graph Info ========
t_11:
AdjList :  va1_1 vt3_1 vt2_1 vzero_1 vs7_1 va7_1 va2_1 vs0_1 vs5_1 va6_1 vs3_1 vs8_1 vs11_1 va3_1 vs9_1 vs1_1 vs4_1 vra_1 vt6_1 vtp_1 vt1_1 va5_1 vt4_1 va4_1 vsp_1 vt5_1 vs2_1 vt0_1 va0_1 vgp_1 vs6_1 vs10_1
degree : 32
Alias :None
Color : null
Priority : 0
------
alpha_1:
AdjList :  vzero_1 vsp_1
degree : 2
Alias :None
Color : null
Priority : 0
------
t_12:
AdjList :  vzero_1 vsp_1
degree : 2
Alias :None
Color : null
Priority : 0
------
t_13:
AdjList :  vzero_1 vsp_1
degree : 2
Alias :va0_1
Color : null
Priority : 0
------
========main move List Info ========
coalesced moves:
va0_1 = move t_13
------
constrained moves:
------
fronzen moves:
------
workList moves:
va0_1 = move alpha_1
t_11 = move va0_1
t_13 = move t_12
t_12 = move va0_1
alpha_1 = move t_11
va0_1 = move t_11
------
active moves:
========main Node List Info ========
simplify Nodes(low degree non move related):

------
freeze Nodes(low degree move related):
t_12(0) alpha_1(0) 
------
spill Nodes(high degree):
t_11(0) 
------
spilled Nodes:

------
coalesced Nodes:
t_13(0) 
------
colored Nodes:

------
selected Stack:

------

===================== Coalesce =====================
========main Graph Info ========
t_11:
AdjList :  va1_1 vt3_1 vt2_1 vzero_1 vs7_1 va7_1 va2_1 vs0_1 vs5_1 va6_1 vs3_1 vs8_1 vs11_1 va3_1 vs9_1 vs1_1 vs4_1 vra_1 vt6_1 vtp_1 vt1_1 va5_1 vt4_1 va4_1 vsp_1 vt5_1 vs2_1 vt0_1 va0_1 vgp_1 vs6_1 vs10_1
degree : 32
Alias :None
Color : null
Priority : 0
------
alpha_1:
AdjList :  vzero_1 vsp_1
degree : 2
Alias :va0_1
Color : null
Priority : 0
------
t_12:
AdjList :  vzero_1 vsp_1
degree : 2
Alias :None
Color : null
Priority : 0
------
t_13:
AdjList :  vzero_1 vsp_1
degree : 2
Alias :va0_1
Color : null
Priority : 0
------
========main move List Info ========
coalesced moves:
va0_1 = move t_13
va0_1 = move alpha_1
------
constrained moves:
------
fronzen moves:
------
workList moves:
t_11 = move va0_1
t_13 = move t_12
t_12 = move va0_1
alpha_1 = move t_11
va0_1 = move t_11
------
active moves:
========main Node List Info ========
simplify Nodes(low degree non move related):

------
freeze Nodes(low degree move related):
t_12(0) 
------
spill Nodes(high degree):
t_11(0) 
------
spilled Nodes:

------
coalesced Nodes:
t_13(0) alpha_1(0) 
------
colored Nodes:

------
selected Stack:

------

===================== Coalesce =====================
========main Graph Info ========
t_11:
AdjList :  va1_1 vt3_1 vt2_1 vzero_1 vs7_1 va7_1 va2_1 vs0_1 vs5_1 va6_1 vs3_1 vs8_1 vs11_1 va3_1 vs9_1 vs1_1 vs4_1 vra_1 vt6_1 vtp_1 vt1_1 va5_1 vt4_1 va4_1 vsp_1 vt5_1 vs2_1 vt0_1 va0_1 vgp_1 vs6_1 vs10_1
degree : 32
Alias :None
Color : null
Priority : 0
------
alpha_1:
AdjList :  vzero_1 vsp_1
degree : 2
Alias :va0_1
Color : null
Priority : 0
------
t_12:
AdjList :  vzero_1 vsp_1
degree : 2
Alias :None
Color : null
Priority : 0
------
t_13:
AdjList :  vzero_1 vsp_1
degree : 2
Alias :va0_1
Color : null
Priority : 0
------
========main move List Info ========
coalesced moves:
va0_1 = move t_13
va0_1 = move alpha_1
------
constrained moves:
t_11 = move va0_1
------
fronzen moves:
------
workList moves:
t_13 = move t_12
t_12 = move va0_1
alpha_1 = move t_11
va0_1 = move t_11
------
active moves:
========main Node List Info ========
simplify Nodes(low degree non move related):

------
freeze Nodes(low degree move related):
t_12(0) 
------
spill Nodes(high degree):
t_11(0) 
------
spilled Nodes:

------
coalesced Nodes:
t_13(0) alpha_1(0) 
------
colored Nodes:

------
selected Stack:

------

===================== Coalesce =====================
========main Graph Info ========
t_11:
AdjList :  va1_1 vt3_1 vt2_1 vzero_1 vs7_1 va7_1 va2_1 vs0_1 vs5_1 va6_1 vs3_1 vs8_1 vs11_1 va3_1 vs9_1 vs1_1 vs4_1 vra_1 vt6_1 vtp_1 vt1_1 va5_1 vt4_1 va4_1 vsp_1 vt5_1 vs2_1 vt0_1 va0_1 vgp_1 vs6_1 vs10_1
degree : 32
Alias :None
Color : null
Priority : 0
------
alpha_1:
AdjList :  vzero_1 vsp_1
degree : 2
Alias :va0_1
Color : null
Priority : 0
------
t_12:
AdjList :  vzero_1 vsp_1
degree : 2
Alias :va0_1
Color : null
Priority : 0
------
t_13:
AdjList :  vzero_1 vsp_1
degree : 2
Alias :va0_1
Color : null
Priority : 0
------
========main move List Info ========
coalesced moves:
va0_1 = move t_13
va0_1 = move alpha_1
t_13 = move t_12
------
constrained moves:
t_11 = move va0_1
------
fronzen moves:
------
workList moves:
t_12 = move va0_1
alpha_1 = move t_11
va0_1 = move t_11
------
active moves:
========main Node List Info ========
simplify Nodes(low degree non move related):

------
freeze Nodes(low degree move related):

------
spill Nodes(high degree):
t_11(0) 
------
spilled Nodes:

------
coalesced Nodes:
t_12(0) t_13(0) alpha_1(0) 
------
colored Nodes:

------
selected Stack:

------

===================== Coalesce =====================
========main Graph Info ========
t_11:
AdjList :  va1_1 vt3_1 vt2_1 vzero_1 vs7_1 va7_1 va2_1 vs0_1 vs5_1 va6_1 vs3_1 vs8_1 vs11_1 va3_1 vs9_1 vs1_1 vs4_1 vra_1 vt6_1 vtp_1 vt1_1 va5_1 vt4_1 va4_1 vsp_1 vt5_1 vs2_1 vt0_1 va0_1 vgp_1 vs6_1 vs10_1
degree : 32
Alias :None
Color : null
Priority : 0
------
alpha_1:
AdjList :  vzero_1 vsp_1
degree : 2
Alias :va0_1
Color : null
Priority : 0
------
t_12:
AdjList :  vzero_1 vsp_1
degree : 2
Alias :va0_1
Color : null
Priority : 0
------
t_13:
AdjList :  vzero_1 vsp_1
degree : 2
Alias :va0_1
Color : null
Priority : 0
------
========main move List Info ========
coalesced moves:
va0_1 = move t_13
va0_1 = move alpha_1
t_13 = move t_12
t_12 = move va0_1
------
constrained moves:
t_11 = move va0_1
------
fronzen moves:
------
workList moves:
alpha_1 = move t_11
va0_1 = move t_11
------
active moves:
========main Node List Info ========
simplify Nodes(low degree non move related):

------
freeze Nodes(low degree move related):

------
spill Nodes(high degree):
t_11(0) 
------
spilled Nodes:

------
coalesced Nodes:
t_12(0) t_13(0) alpha_1(0) 
------
colored Nodes:

------
selected Stack:

------

===================== Coalesce =====================
========main Graph Info ========
t_11:
AdjList :  va1_1 vt3_1 vt2_1 vzero_1 vs7_1 va7_1 va2_1 vs0_1 vs5_1 va6_1 vs3_1 vs8_1 vs11_1 va3_1 vs9_1 vs1_1 vs4_1 vra_1 vt6_1 vtp_1 vt1_1 va5_1 vt4_1 va4_1 vsp_1 vt5_1 vs2_1 vt0_1 va0_1 vgp_1 vs6_1 vs10_1
degree : 32
Alias :None
Color : null
Priority : 0
------
alpha_1:
AdjList :  vzero_1 vsp_1
degree : 2
Alias :va0_1
Color : null
Priority : 0
------
t_12:
AdjList :  vzero_1 vsp_1
degree : 2
Alias :va0_1
Color : null
Priority : 0
------
t_13:
AdjList :  vzero_1 vsp_1
degree : 2
Alias :va0_1
Color : null
Priority : 0
------
========main move List Info ========
coalesced moves:
va0_1 = move t_13
va0_1 = move alpha_1
t_13 = move t_12
t_12 = move va0_1
------
constrained moves:
t_11 = move va0_1
alpha_1 = move t_11
------
fronzen moves:
------
workList moves:
va0_1 = move t_11
------
active moves:
========main Node List Info ========
simplify Nodes(low degree non move related):

------
freeze Nodes(low degree move related):

------
spill Nodes(high degree):
t_11(0) 
------
spilled Nodes:

------
coalesced Nodes:
t_12(0) t_13(0) alpha_1(0) 
------
colored Nodes:

------
selected Stack:

------

===================== Coalesce =====================
========main Graph Info ========
t_11:
AdjList :  va1_1 vt3_1 vt2_1 vzero_1 vs7_1 va7_1 va2_1 vs0_1 vs5_1 va6_1 vs3_1 vs8_1 vs11_1 va3_1 vs9_1 vs1_1 vs4_1 vra_1 vt6_1 vtp_1 vt1_1 va5_1 vt4_1 va4_1 vsp_1 vt5_1 vs2_1 vt0_1 va0_1 vgp_1 vs6_1 vs10_1
degree : 32
Alias :None
Color : null
Priority : 0
------
alpha_1:
AdjList :  vzero_1 vsp_1
degree : 2
Alias :va0_1
Color : null
Priority : 0
------
t_12:
AdjList :  vzero_1 vsp_1
degree : 2
Alias :va0_1
Color : null
Priority : 0
------
t_13:
AdjList :  vzero_1 vsp_1
degree : 2
Alias :va0_1
Color : null
Priority : 0
------
========main move List Info ========
coalesced moves:
va0_1 = move t_13
va0_1 = move alpha_1
t_13 = move t_12
t_12 = move va0_1
------
constrained moves:
t_11 = move va0_1
alpha_1 = move t_11
va0_1 = move t_11
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
t_11(0) 
------
spilled Nodes:

------
coalesced Nodes:
t_12(0) t_13(0) alpha_1(0) 
------
colored Nodes:

------
selected Stack:

------

===================== SelectSpill =====================
========main Graph Info ========
t_11:
AdjList :  va1_1 vt3_1 vt2_1 vzero_1 vs7_1 va7_1 va2_1 vs0_1 vs5_1 va6_1 vs3_1 vs8_1 vs11_1 va3_1 vs9_1 vs1_1 vs4_1 vra_1 vt6_1 vtp_1 vt1_1 va5_1 vt4_1 va4_1 vsp_1 vt5_1 vs2_1 vt0_1 va0_1 vgp_1 vs6_1 vs10_1
degree : 32
Alias :None
Color : null
Priority : 0
------
alpha_1:
AdjList :  vzero_1 vsp_1
degree : 2
Alias :va0_1
Color : null
Priority : 0
------
t_12:
AdjList :  vzero_1 vsp_1
degree : 2
Alias :va0_1
Color : null
Priority : 0
------
t_13:
AdjList :  vzero_1 vsp_1
degree : 2
Alias :va0_1
Color : null
Priority : 0
------
========main move List Info ========
coalesced moves:
va0_1 = move t_13
va0_1 = move alpha_1
t_13 = move t_12
t_12 = move va0_1
------
constrained moves:
t_11 = move va0_1
alpha_1 = move t_11
va0_1 = move t_11
------
fronzen moves:
------
workList moves:
------
active moves:
========main Node List Info ========
simplify Nodes(low degree non move related):
t_11(0) 
------
freeze Nodes(low degree move related):

------
spill Nodes(high degree):

------
spilled Nodes:

------
coalesced Nodes:
t_12(0) t_13(0) alpha_1(0) 
------
colored Nodes:

------
selected Stack:

------

===================== Simplify =====================
========main Graph Info ========
t_11:
AdjList :  va1_1 vt3_1 vt2_1 vzero_1 vs7_1 va7_1 va2_1 vs0_1 vs5_1 va6_1 vs3_1 vs8_1 vs11_1 va3_1 vs9_1 vs1_1 vs4_1 vra_1 vt6_1 vtp_1 vt1_1 va5_1 vt4_1 va4_1 vsp_1 vt5_1 vs2_1 vt0_1 va0_1 vgp_1 vs6_1 vs10_1
degree : 32
Alias :None
Color : null
Priority : 0
------
alpha_1:
AdjList :  vzero_1 vsp_1
degree : 2
Alias :va0_1
Color : null
Priority : 0
------
t_12:
AdjList :  vzero_1 vsp_1
degree : 2
Alias :va0_1
Color : null
Priority : 0
------
t_13:
AdjList :  vzero_1 vsp_1
degree : 2
Alias :va0_1
Color : null
Priority : 0
------
========main move List Info ========
coalesced moves:
va0_1 = move t_13
va0_1 = move alpha_1
t_13 = move t_12
t_12 = move va0_1
------
constrained moves:
t_11 = move va0_1
alpha_1 = move t_11
va0_1 = move t_11
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
t_12(0) t_13(0) alpha_1(0) 
------
colored Nodes:

------
selected Stack:
t_11(0) 
------

===================== after ASSIGN =====================
========main Graph Info ========
t_11:
AdjList :  va1_1 vt3_1 vt2_1 vzero_1 vs7_1 va7_1 va2_1 vs0_1 vs5_1 va6_1 vs3_1 vs8_1 vs11_1 va3_1 vs9_1 vs1_1 vs4_1 vra_1 vt6_1 vtp_1 vt1_1 va5_1 vt4_1 va4_1 vsp_1 vt5_1 vs2_1 vt0_1 va0_1 vgp_1 vs6_1 vs10_1
degree : 32
Alias :None
Color : null
Priority : 0
------
alpha_1:
AdjList :  vzero_1 vsp_1
degree : 2
Alias :va0_1
Color : a0
Priority : 0
------
t_12:
AdjList :  vzero_1 vsp_1
degree : 2
Alias :va0_1
Color : a0
Priority : 0
------
t_13:
AdjList :  vzero_1 vsp_1
degree : 2
Alias :va0_1
Color : a0
Priority : 0
------
========main move List Info ========
coalesced moves:
va0_1 = move t_13
va0_1 = move alpha_1
t_13 = move t_12
t_12 = move va0_1
------
constrained moves:
t_11 = move va0_1
alpha_1 = move t_11
va0_1 = move t_11
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
t_11(0) 
------
coalesced Nodes:
t_12(0) t_13(0) alpha_1(0) 
------
colored Nodes:

------
selected Stack:

------

===================== IR after Rewrite =====================
define i64 @tmp_tmp %this_1 {
tmp_tmp_entry_1:
   store %vs4_1 %vsp_1 null 0 44
   store %vs1_1 %vsp_1 null 0 40
   store %vs10_1 %vsp_1 null 0 36
   store %vs6_1 %vsp_1 null 0 32
   store %vs9_1 %vsp_1 null 0 28
   store %vs11_1 %vsp_1 null 0 24
   store %vs8_1 %vsp_1 null 0 20
   store %vs3_1 %vsp_1 null 0 16
   store %vs2_1 %vsp_1 null 0 12
   store %vs5_1 %vsp_1 null 0 8
   store %vs7_1 %vsp_1 null 0 4
   store %ra %vsp_1 null 0 0
   %this_1 = move %va0_1
   %t_1 = add %this_1 0
   %t_2 = move 4
   store %t_2 %t_1
   %t_3 = add %this_1 4
   %t_4 = move 5
   store %t_4 %t_3
   %va0_1 = move 0
   %ra = load %vsp_1 null 0 0
   %vs7_1 = load %vsp_1 null 0 4
   %vs5_1 = load %vsp_1 null 0 8
   %vs2_1 = load %vsp_1 null 0 12
   %vs3_1 = load %vsp_1 null 0 16
   %vs8_1 = load %vsp_1 null 0 20
   %vs11_1 = load %vsp_1 null 0 24
   %vs9_1 = load %vsp_1 null 0 28
   %vs6_1 = load %vsp_1 null 0 32
   %vs10_1 = load %vsp_1 null 0 36
   %vs1_1 = load %vsp_1 null 0 40
   %vs4_1 = load %vsp_1 null 0 44
   ret %va0_1
}

define i64 @tmp_fuck %this_2 {
tmp_fuck_entry_1:
   store %vs4_1 %vsp_1 null 0 44
   store %vs1_1 %vsp_1 null 0 40
   store %vs10_1 %vsp_1 null 0 36
   store %vs6_1 %vsp_1 null 0 32
   store %vs9_1 %vsp_1 null 0 28
   store %vs11_1 %vsp_1 null 0 24
   store %vs8_1 %vsp_1 null 0 20
   store %vs3_1 %vsp_1 null 0 16
   store %vs2_1 %vsp_1 null 0 12
   store %vs5_1 %vsp_1 null 0 8
   store %vs7_1 %vsp_1 null 0 4
   store %ra %vsp_1 null 0 0
   %this_2 = move %va0_1
   %t_5 = add %this_2 0
   %t_6 = add %this_2 4
   %t_7 = load %t_5
   %t_8 = load %t_6
   %t_9 = add %t_7 %t_8
   %t_10 = move %t_9
   %va0_1 = move %t_10
   %ra = load %vsp_1 null 0 0
   %vs7_1 = load %vsp_1 null 0 4
   %vs5_1 = load %vsp_1 null 0 8
   %vs2_1 = load %vsp_1 null 0 12
   %vs3_1 = load %vsp_1 null 0 16
   %vs8_1 = load %vsp_1 null 0 20
   %vs11_1 = load %vsp_1 null 0 24
   %vs9_1 = load %vsp_1 null 0 28
   %vs6_1 = load %vsp_1 null 0 32
   %vs10_1 = load %vsp_1 null 0 36
   %vs1_1 = load %vsp_1 null 0 40
   %vs4_1 = load %vsp_1 null 0 44
   ret %va0_1
}

define i64 @main  {
main_entry_1:
   store %vs4_1 %vsp_1 null 0 44
   store %vs1_1 %vsp_1 null 0 40
   store %vs10_1 %vsp_1 null 0 36
   store %vs6_1 %vsp_1 null 0 32
   store %vs9_1 %vsp_1 null 0 28
   store %vs11_1 %vsp_1 null 0 24
   store %vs8_1 %vsp_1 null 0 20
   store %vs3_1 %vsp_1 null 0 16
   store %vs2_1 %vsp_1 null 0 12
   store %vs5_1 %vsp_1 null 0 8
   store %vs7_1 %vsp_1 null 0 4
   store %ra %vsp_1 null 0 0
   %va0_1 = move 8
   %spill_tmp_1 = alloc 8
   store %spill_tmp_1 %vsp_1 null 0 48
   store %va0_1 %vsp_1 null 0 48
   %va0_1 = load %vsp_1 null 0 48
   call tmp_tmp %va0_1 
   %alpha_1 = load %vsp_1 null 0 48
   %va0_1 = move %alpha_1
   %va0_1 = call tmp_fuck %va0_1 
   %t_12 = move %va0_1
   %t_13 = move %t_12
   %va0_1 = move %t_13
   %ra = load %vsp_1 null 0 0
   %vs7_1 = load %vsp_1 null 0 4
   %vs5_1 = load %vsp_1 null 0 8
   %vs2_1 = load %vsp_1 null 0 12
   %vs3_1 = load %vsp_1 null 0 16
   %vs8_1 = load %vsp_1 null 0 20
   %vs11_1 = load %vsp_1 null 0 24
   %vs9_1 = load %vsp_1 null 0 28
   %vs6_1 = load %vsp_1 null 0 32
   %vs10_1 = load %vsp_1 null 0 36
   %vs1_1 = load %vsp_1 null 0 40
   %vs4_1 = load %vsp_1 null 0 44
   ret %va0_1
}

define i64 @__init  {
__init_entry_1:
   store %vs4_1 %vsp_1 null 0 44
   store %vs1_1 %vsp_1 null 0 40
   store %vs10_1 %vsp_1 null 0 36
   store %vs6_1 %vsp_1 null 0 32
   store %vs9_1 %vsp_1 null 0 28
   store %vs11_1 %vsp_1 null 0 24
   store %vs8_1 %vsp_1 null 0 20
   store %vs3_1 %vsp_1 null 0 16
   store %vs2_1 %vsp_1 null 0 12
   store %vs5_1 %vsp_1 null 0 8
   store %vs7_1 %vsp_1 null 0 4
   store %ra %vsp_1 null 0 0
   %va0_1 = call main 
   %t_14 = move %va0_1
   %t_15 = move %t_14
   %va0_1 = move %t_15
   %ra = load %vsp_1 null 0 0
   %vs7_1 = load %vsp_1 null 0 4
   %vs5_1 = load %vsp_1 null 0 8
   %vs2_1 = load %vsp_1 null 0 12
   %vs3_1 = load %vsp_1 null 0 16
   %vs8_1 = load %vsp_1 null 0 20
   %vs11_1 = load %vsp_1 null 0 24
   %vs9_1 = load %vsp_1 null 0 28
   %vs6_1 = load %vsp_1 null 0 32
   %vs10_1 = load %vsp_1 null 0 36
   %vs1_1 = load %vsp_1 null 0 40
   %vs4_1 = load %vsp_1 null 0 44
   ret %va0_1
}

=====================main Iteration 1=====================
========main Graph Info ========
alpha_1:
AdjList :  vzero_1 vsp_1
degree : 2
Alias :None
Color : null
Priority : 0
------
t_12:
AdjList :  vzero_1 vsp_1
degree : 2
Alias :None
Color : null
Priority : 0
------
spill_tmp_1:
AdjList :  vtp_1 vzero_1 vs7_1 vs0_1 vsp_1 vs5_1 vs2_1 vs3_1 vs8_1 vs11_1 va0_1 vgp_1 vs9_1 vs6_1 vs10_1 vs1_1 vs4_1
degree : 17
Alias :None
Color : null
Priority : 0
------
t_13:
AdjList :  vzero_1 vsp_1
degree : 2
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
va0_1 = move t_13
va0_1 = move alpha_1
t_13 = move t_12
t_12 = move va0_1
------
active moves:
========main Node List Info ========
simplify Nodes(low degree non move related):
spill_tmp_1(0) 
------
freeze Nodes(low degree move related):
t_12(0) t_13(0) alpha_1(0) 
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

define i64 @tmp_tmp %this_1 {
tmp_tmp_entry_1:
   store %vs4_1 %vsp_1 null 0 44
   store %vs1_1 %vsp_1 null 0 40
   store %vs10_1 %vsp_1 null 0 36
   store %vs6_1 %vsp_1 null 0 32
   store %vs9_1 %vsp_1 null 0 28
   store %vs11_1 %vsp_1 null 0 24
   store %vs8_1 %vsp_1 null 0 20
   store %vs3_1 %vsp_1 null 0 16
   store %vs2_1 %vsp_1 null 0 12
   store %vs5_1 %vsp_1 null 0 8
   store %vs7_1 %vsp_1 null 0 4
   store %ra %vsp_1 null 0 0
   %this_1 = move %va0_1
   %t_1 = add %this_1 0
   %t_2 = move 4
   store %t_2 %t_1
   %t_3 = add %this_1 4
   %t_4 = move 5
   store %t_4 %t_3
   %va0_1 = move 0
   %ra = load %vsp_1 null 0 0
   %vs7_1 = load %vsp_1 null 0 4
   %vs5_1 = load %vsp_1 null 0 8
   %vs2_1 = load %vsp_1 null 0 12
   %vs3_1 = load %vsp_1 null 0 16
   %vs8_1 = load %vsp_1 null 0 20
   %vs11_1 = load %vsp_1 null 0 24
   %vs9_1 = load %vsp_1 null 0 28
   %vs6_1 = load %vsp_1 null 0 32
   %vs10_1 = load %vsp_1 null 0 36
   %vs1_1 = load %vsp_1 null 0 40
   %vs4_1 = load %vsp_1 null 0 44
   ret %va0_1
}

define i64 @tmp_fuck %this_2 {
tmp_fuck_entry_1:
   store %vs4_1 %vsp_1 null 0 44
   store %vs1_1 %vsp_1 null 0 40
   store %vs10_1 %vsp_1 null 0 36
   store %vs6_1 %vsp_1 null 0 32
   store %vs9_1 %vsp_1 null 0 28
   store %vs11_1 %vsp_1 null 0 24
   store %vs8_1 %vsp_1 null 0 20
   store %vs3_1 %vsp_1 null 0 16
   store %vs2_1 %vsp_1 null 0 12
   store %vs5_1 %vsp_1 null 0 8
   store %vs7_1 %vsp_1 null 0 4
   store %ra %vsp_1 null 0 0
   %this_2 = move %va0_1
   %t_5 = add %this_2 0
   %t_6 = add %this_2 4
   %t_7 = load %t_5
   %t_8 = load %t_6
   %t_9 = add %t_7 %t_8
   %t_10 = move %t_9
   %va0_1 = move %t_10
   %ra = load %vsp_1 null 0 0
   %vs7_1 = load %vsp_1 null 0 4
   %vs5_1 = load %vsp_1 null 0 8
   %vs2_1 = load %vsp_1 null 0 12
   %vs3_1 = load %vsp_1 null 0 16
   %vs8_1 = load %vsp_1 null 0 20
   %vs11_1 = load %vsp_1 null 0 24
   %vs9_1 = load %vsp_1 null 0 28
   %vs6_1 = load %vsp_1 null 0 32
   %vs10_1 = load %vsp_1 null 0 36
   %vs1_1 = load %vsp_1 null 0 40
   %vs4_1 = load %vsp_1 null 0 44
   ret %va0_1
}

define i64 @main  {
main_entry_1:
   store %vs4_1 %vsp_1 null 0 44
   store %vs1_1 %vsp_1 null 0 40
   store %vs10_1 %vsp_1 null 0 36
   store %vs6_1 %vsp_1 null 0 32
   store %vs9_1 %vsp_1 null 0 28
   store %vs11_1 %vsp_1 null 0 24
   store %vs8_1 %vsp_1 null 0 20
   store %vs3_1 %vsp_1 null 0 16
   store %vs2_1 %vsp_1 null 0 12
   store %vs5_1 %vsp_1 null 0 8
   store %vs7_1 %vsp_1 null 0 4
   store %ra %vsp_1 null 0 0
   %va0_1 = move 8
   %spill_tmp_1 = alloc 8
   store %spill_tmp_1 %vsp_1 null 0 48
   store %va0_1 %vsp_1 null 0 48
   %va0_1 = load %vsp_1 null 0 48
   call tmp_tmp %va0_1 
   %alpha_1 = load %vsp_1 null 0 48
   %va0_1 = move %alpha_1
   %va0_1 = call tmp_fuck %va0_1 
   %t_12 = move %va0_1
   %t_13 = move %t_12
   %va0_1 = move %t_13
   %ra = load %vsp_1 null 0 0
   %vs7_1 = load %vsp_1 null 0 4
   %vs5_1 = load %vsp_1 null 0 8
   %vs2_1 = load %vsp_1 null 0 12
   %vs3_1 = load %vsp_1 null 0 16
   %vs8_1 = load %vsp_1 null 0 20
   %vs11_1 = load %vsp_1 null 0 24
   %vs9_1 = load %vsp_1 null 0 28
   %vs6_1 = load %vsp_1 null 0 32
   %vs10_1 = load %vsp_1 null 0 36
   %vs1_1 = load %vsp_1 null 0 40
   %vs4_1 = load %vsp_1 null 0 44
   ret %va0_1
}

define i64 @__init  {
__init_entry_1:
   store %vs4_1 %vsp_1 null 0 44
   store %vs1_1 %vsp_1 null 0 40
   store %vs10_1 %vsp_1 null 0 36
   store %vs6_1 %vsp_1 null 0 32
   store %vs9_1 %vsp_1 null 0 28
   store %vs11_1 %vsp_1 null 0 24
   store %vs8_1 %vsp_1 null 0 20
   store %vs3_1 %vsp_1 null 0 16
   store %vs2_1 %vsp_1 null 0 12
   store %vs5_1 %vsp_1 null 0 8
   store %vs7_1 %vsp_1 null 0 4
   store %ra %vsp_1 null 0 0
   %va0_1 = call main 
   %t_14 = move %va0_1
   %t_15 = move %t_14
   %va0_1 = move %t_15
   %ra = load %vsp_1 null 0 0
   %vs7_1 = load %vsp_1 null 0 4
   %vs5_1 = load %vsp_1 null 0 8
   %vs2_1 = load %vsp_1 null 0 12
   %vs3_1 = load %vsp_1 null 0 16
   %vs8_1 = load %vsp_1 null 0 20
   %vs11_1 = load %vsp_1 null 0 24
   %vs9_1 = load %vsp_1 null 0 28
   %vs6_1 = load %vsp_1 null 0 32
   %vs10_1 = load %vsp_1 null 0 36
   %vs1_1 = load %vsp_1 null 0 40
   %vs4_1 = load %vsp_1 null 0 44
   ret %va0_1
}

===================== Simplify =====================
========main Graph Info ========
alpha_1:
AdjList :  vzero_1 vsp_1
degree : 2
Alias :None
Color : null
Priority : 0
------
t_12:
AdjList :  vzero_1 vsp_1
degree : 2
Alias :None
Color : null
Priority : 0
------
spill_tmp_1:
AdjList :  vtp_1 vzero_1 vs7_1 vs0_1 vsp_1 vs5_1 vs2_1 vs3_1 vs8_1 vs11_1 va0_1 vgp_1 vs9_1 vs6_1 vs10_1 vs1_1 vs4_1
degree : 17
Alias :None
Color : null
Priority : 0
------
t_13:
AdjList :  vzero_1 vsp_1
degree : 2
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
va0_1 = move t_13
va0_1 = move alpha_1
t_13 = move t_12
t_12 = move va0_1
------
active moves:
========main Node List Info ========
simplify Nodes(low degree non move related):

------
freeze Nodes(low degree move related):
t_12(0) t_13(0) alpha_1(0) 
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
spill_tmp_1(0) 
------

===================== Coalesce =====================
========main Graph Info ========
alpha_1:
AdjList :  vzero_1 vsp_1
degree : 2
Alias :None
Color : null
Priority : 0
------
t_12:
AdjList :  vzero_1 vsp_1
degree : 2
Alias :None
Color : null
Priority : 0
------
spill_tmp_1:
AdjList :  vtp_1 vzero_1 vs7_1 vs0_1 vsp_1 vs5_1 vs2_1 vs3_1 vs8_1 vs11_1 va0_1 vgp_1 vs9_1 vs6_1 vs10_1 vs1_1 vs4_1
degree : 17
Alias :None
Color : null
Priority : 0
------
t_13:
AdjList :  vzero_1 vsp_1
degree : 2
Alias :va0_1
Color : null
Priority : 0
------
========main move List Info ========
coalesced moves:
va0_1 = move t_13
------
constrained moves:
------
fronzen moves:
------
workList moves:
va0_1 = move alpha_1
t_13 = move t_12
t_12 = move va0_1
------
active moves:
========main Node List Info ========
simplify Nodes(low degree non move related):

------
freeze Nodes(low degree move related):
t_12(0) alpha_1(0) 
------
spill Nodes(high degree):

------
spilled Nodes:

------
coalesced Nodes:
t_13(0) 
------
colored Nodes:

------
selected Stack:
spill_tmp_1(0) 
------

===================== Coalesce =====================
========main Graph Info ========
alpha_1:
AdjList :  vzero_1 vsp_1
degree : 2
Alias :va0_1
Color : null
Priority : 0
------
t_12:
AdjList :  vzero_1 vsp_1
degree : 2
Alias :None
Color : null
Priority : 0
------
spill_tmp_1:
AdjList :  vtp_1 vzero_1 vs7_1 vs0_1 vsp_1 vs5_1 vs2_1 vs3_1 vs8_1 vs11_1 va0_1 vgp_1 vs9_1 vs6_1 vs10_1 vs1_1 vs4_1
degree : 17
Alias :None
Color : null
Priority : 0
------
t_13:
AdjList :  vzero_1 vsp_1
degree : 2
Alias :va0_1
Color : null
Priority : 0
------
========main move List Info ========
coalesced moves:
va0_1 = move t_13
va0_1 = move alpha_1
------
constrained moves:
------
fronzen moves:
------
workList moves:
t_13 = move t_12
t_12 = move va0_1
------
active moves:
========main Node List Info ========
simplify Nodes(low degree non move related):

------
freeze Nodes(low degree move related):
t_12(0) 
------
spill Nodes(high degree):

------
spilled Nodes:

------
coalesced Nodes:
t_13(0) alpha_1(0) 
------
colored Nodes:

------
selected Stack:
spill_tmp_1(0) 
------

===================== Coalesce =====================
========main Graph Info ========
alpha_1:
AdjList :  vzero_1 vsp_1
degree : 2
Alias :va0_1
Color : null
Priority : 0
------
t_12:
AdjList :  vzero_1 vsp_1
degree : 2
Alias :va0_1
Color : null
Priority : 0
------
spill_tmp_1:
AdjList :  vtp_1 vzero_1 vs7_1 vs0_1 vsp_1 vs5_1 vs2_1 vs3_1 vs8_1 vs11_1 va0_1 vgp_1 vs9_1 vs6_1 vs10_1 vs1_1 vs4_1
degree : 17
Alias :None
Color : null
Priority : 0
------
t_13:
AdjList :  vzero_1 vsp_1
degree : 2
Alias :va0_1
Color : null
Priority : 0
------
========main move List Info ========
coalesced moves:
va0_1 = move t_13
va0_1 = move alpha_1
t_13 = move t_12
------
constrained moves:
------
fronzen moves:
------
workList moves:
t_12 = move va0_1
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
t_12(0) t_13(0) alpha_1(0) 
------
colored Nodes:

------
selected Stack:
spill_tmp_1(0) 
------

===================== Coalesce =====================
========main Graph Info ========
alpha_1:
AdjList :  vzero_1 vsp_1
degree : 2
Alias :va0_1
Color : null
Priority : 0
------
t_12:
AdjList :  vzero_1 vsp_1
degree : 2
Alias :va0_1
Color : null
Priority : 0
------
spill_tmp_1:
AdjList :  vtp_1 vzero_1 vs7_1 vs0_1 vsp_1 vs5_1 vs2_1 vs3_1 vs8_1 vs11_1 va0_1 vgp_1 vs9_1 vs6_1 vs10_1 vs1_1 vs4_1
degree : 17
Alias :None
Color : null
Priority : 0
------
t_13:
AdjList :  vzero_1 vsp_1
degree : 2
Alias :va0_1
Color : null
Priority : 0
------
========main move List Info ========
coalesced moves:
va0_1 = move t_13
va0_1 = move alpha_1
t_13 = move t_12
t_12 = move va0_1
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
t_12(0) t_13(0) alpha_1(0) 
------
colored Nodes:

------
selected Stack:
spill_tmp_1(0) 
------

===================== after ASSIGN =====================
========main Graph Info ========
alpha_1:
AdjList :  vzero_1 vsp_1
degree : 2
Alias :va0_1
Color : a0
Priority : 0
------
t_12:
AdjList :  vzero_1 vsp_1
degree : 2
Alias :va0_1
Color : a0
Priority : 0
------
spill_tmp_1:
AdjList :  vtp_1 vzero_1 vs7_1 vs0_1 vsp_1 vs5_1 vs2_1 vs3_1 vs8_1 vs11_1 va0_1 vgp_1 vs9_1 vs6_1 vs10_1 vs1_1 vs4_1
degree : 17
Alias :None
Color : t1
Priority : 0
------
t_13:
AdjList :  vzero_1 vsp_1
degree : 2
Alias :va0_1
Color : a0
Priority : 0
------
========main move List Info ========
coalesced moves:
va0_1 = move t_13
va0_1 = move alpha_1
t_13 = move t_12
t_12 = move va0_1
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
t_12(0) t_13(0) alpha_1(0) 
------
colored Nodes:
spill_tmp_1(0) 
------
selected Stack:

------

=====================__init Iteration 0=====================
========__init Graph Info ========
t_15:
AdjList :  vzero_1 vsp_1
degree : 2
Alias :None
Color : null
Priority : 0
------
t_14:
AdjList :  vzero_1 vsp_1
degree : 2
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
t_14 = move va0_1
t_15 = move t_14
va0_1 = move t_15
------
active moves:
========__init Node List Info ========
simplify Nodes(low degree non move related):

------
freeze Nodes(low degree move related):
t_14(0) t_15(0) 
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

define i64 @tmp_tmp %this_1 {
tmp_tmp_entry_1:
   store %vs4_1 %vsp_1 null 0 44
   store %vs1_1 %vsp_1 null 0 40
   store %vs10_1 %vsp_1 null 0 36
   store %vs6_1 %vsp_1 null 0 32
   store %vs9_1 %vsp_1 null 0 28
   store %vs11_1 %vsp_1 null 0 24
   store %vs8_1 %vsp_1 null 0 20
   store %vs3_1 %vsp_1 null 0 16
   store %vs2_1 %vsp_1 null 0 12
   store %vs5_1 %vsp_1 null 0 8
   store %vs7_1 %vsp_1 null 0 4
   store %ra %vsp_1 null 0 0
   %this_1 = move %va0_1
   %t_1 = add %this_1 0
   %t_2 = move 4
   store %t_2 %t_1
   %t_3 = add %this_1 4
   %t_4 = move 5
   store %t_4 %t_3
   %va0_1 = move 0
   %ra = load %vsp_1 null 0 0
   %vs7_1 = load %vsp_1 null 0 4
   %vs5_1 = load %vsp_1 null 0 8
   %vs2_1 = load %vsp_1 null 0 12
   %vs3_1 = load %vsp_1 null 0 16
   %vs8_1 = load %vsp_1 null 0 20
   %vs11_1 = load %vsp_1 null 0 24
   %vs9_1 = load %vsp_1 null 0 28
   %vs6_1 = load %vsp_1 null 0 32
   %vs10_1 = load %vsp_1 null 0 36
   %vs1_1 = load %vsp_1 null 0 40
   %vs4_1 = load %vsp_1 null 0 44
   ret %va0_1
}

define i64 @tmp_fuck %this_2 {
tmp_fuck_entry_1:
   store %vs4_1 %vsp_1 null 0 44
   store %vs1_1 %vsp_1 null 0 40
   store %vs10_1 %vsp_1 null 0 36
   store %vs6_1 %vsp_1 null 0 32
   store %vs9_1 %vsp_1 null 0 28
   store %vs11_1 %vsp_1 null 0 24
   store %vs8_1 %vsp_1 null 0 20
   store %vs3_1 %vsp_1 null 0 16
   store %vs2_1 %vsp_1 null 0 12
   store %vs5_1 %vsp_1 null 0 8
   store %vs7_1 %vsp_1 null 0 4
   store %ra %vsp_1 null 0 0
   %this_2 = move %va0_1
   %t_5 = add %this_2 0
   %t_6 = add %this_2 4
   %t_7 = load %t_5
   %t_8 = load %t_6
   %t_9 = add %t_7 %t_8
   %t_10 = move %t_9
   %va0_1 = move %t_10
   %ra = load %vsp_1 null 0 0
   %vs7_1 = load %vsp_1 null 0 4
   %vs5_1 = load %vsp_1 null 0 8
   %vs2_1 = load %vsp_1 null 0 12
   %vs3_1 = load %vsp_1 null 0 16
   %vs8_1 = load %vsp_1 null 0 20
   %vs11_1 = load %vsp_1 null 0 24
   %vs9_1 = load %vsp_1 null 0 28
   %vs6_1 = load %vsp_1 null 0 32
   %vs10_1 = load %vsp_1 null 0 36
   %vs1_1 = load %vsp_1 null 0 40
   %vs4_1 = load %vsp_1 null 0 44
   ret %va0_1
}

define i64 @main  {
main_entry_1:
   store %vs4_1 %vsp_1 null 0 44
   store %vs1_1 %vsp_1 null 0 40
   store %vs10_1 %vsp_1 null 0 36
   store %vs6_1 %vsp_1 null 0 32
   store %vs9_1 %vsp_1 null 0 28
   store %vs11_1 %vsp_1 null 0 24
   store %vs8_1 %vsp_1 null 0 20
   store %vs3_1 %vsp_1 null 0 16
   store %vs2_1 %vsp_1 null 0 12
   store %vs5_1 %vsp_1 null 0 8
   store %vs7_1 %vsp_1 null 0 4
   store %ra %vsp_1 null 0 0
   %va0_1 = move 8
   %spill_tmp_1 = alloc 8
   store %spill_tmp_1 %vsp_1 null 0 48
   store %va0_1 %vsp_1 null 0 48
   %va0_1 = load %vsp_1 null 0 48
   call tmp_tmp %va0_1 
   %alpha_1 = load %vsp_1 null 0 48
   %va0_1 = move %alpha_1
   %va0_1 = call tmp_fuck %va0_1 
   %t_12 = move %va0_1
   %t_13 = move %t_12
   %va0_1 = move %t_13
   %ra = load %vsp_1 null 0 0
   %vs7_1 = load %vsp_1 null 0 4
   %vs5_1 = load %vsp_1 null 0 8
   %vs2_1 = load %vsp_1 null 0 12
   %vs3_1 = load %vsp_1 null 0 16
   %vs8_1 = load %vsp_1 null 0 20
   %vs11_1 = load %vsp_1 null 0 24
   %vs9_1 = load %vsp_1 null 0 28
   %vs6_1 = load %vsp_1 null 0 32
   %vs10_1 = load %vsp_1 null 0 36
   %vs1_1 = load %vsp_1 null 0 40
   %vs4_1 = load %vsp_1 null 0 44
   ret %va0_1
}

define i64 @__init  {
__init_entry_1:
   store %vs4_1 %vsp_1 null 0 44
   store %vs1_1 %vsp_1 null 0 40
   store %vs10_1 %vsp_1 null 0 36
   store %vs6_1 %vsp_1 null 0 32
   store %vs9_1 %vsp_1 null 0 28
   store %vs11_1 %vsp_1 null 0 24
   store %vs8_1 %vsp_1 null 0 20
   store %vs3_1 %vsp_1 null 0 16
   store %vs2_1 %vsp_1 null 0 12
   store %vs5_1 %vsp_1 null 0 8
   store %vs7_1 %vsp_1 null 0 4
   store %ra %vsp_1 null 0 0
   %va0_1 = call main 
   %t_14 = move %va0_1
   %t_15 = move %t_14
   %va0_1 = move %t_15
   %ra = load %vsp_1 null 0 0
   %vs7_1 = load %vsp_1 null 0 4
   %vs5_1 = load %vsp_1 null 0 8
   %vs2_1 = load %vsp_1 null 0 12
   %vs3_1 = load %vsp_1 null 0 16
   %vs8_1 = load %vsp_1 null 0 20
   %vs11_1 = load %vsp_1 null 0 24
   %vs9_1 = load %vsp_1 null 0 28
   %vs6_1 = load %vsp_1 null 0 32
   %vs10_1 = load %vsp_1 null 0 36
   %vs1_1 = load %vsp_1 null 0 40
   %vs4_1 = load %vsp_1 null 0 44
   ret %va0_1
}

===================== Coalesce =====================
========__init Graph Info ========
t_15:
AdjList :  vzero_1 vsp_1
degree : 2
Alias :None
Color : null
Priority : 0
------
t_14:
AdjList :  vzero_1 vsp_1
degree : 2
Alias :va0_1
Color : null
Priority : 0
------
========__init move List Info ========
coalesced moves:
t_14 = move va0_1
------
constrained moves:
------
fronzen moves:
------
workList moves:
t_15 = move t_14
va0_1 = move t_15
------
active moves:
========__init Node List Info ========
simplify Nodes(low degree non move related):

------
freeze Nodes(low degree move related):
t_15(0) 
------
spill Nodes(high degree):

------
spilled Nodes:

------
coalesced Nodes:
t_14(0) 
------
colored Nodes:

------
selected Stack:

------

===================== Coalesce =====================
========__init Graph Info ========
t_15:
AdjList :  vzero_1 vsp_1
degree : 2
Alias :va0_1
Color : null
Priority : 0
------
t_14:
AdjList :  vzero_1 vsp_1
degree : 2
Alias :va0_1
Color : null
Priority : 0
------
========__init move List Info ========
coalesced moves:
t_14 = move va0_1
t_15 = move t_14
------
constrained moves:
------
fronzen moves:
------
workList moves:
va0_1 = move t_15
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
t_14(0) t_15(0) 
------
colored Nodes:

------
selected Stack:

------

===================== Coalesce =====================
========__init Graph Info ========
t_15:
AdjList :  vzero_1 vsp_1
degree : 2
Alias :va0_1
Color : null
Priority : 0
------
t_14:
AdjList :  vzero_1 vsp_1
degree : 2
Alias :va0_1
Color : null
Priority : 0
------
========__init move List Info ========
coalesced moves:
t_14 = move va0_1
t_15 = move t_14
va0_1 = move t_15
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
t_14(0) t_15(0) 
------
colored Nodes:

------
selected Stack:

------

===================== after ASSIGN =====================
========__init Graph Info ========
t_15:
AdjList :  vzero_1 vsp_1
degree : 2
Alias :va0_1
Color : a0
Priority : 0
------
t_14:
AdjList :  vzero_1 vsp_1
degree : 2
Alias :va0_1
Color : a0
Priority : 0
------
========__init move List Info ========
coalesced moves:
t_14 = move va0_1
t_15 = move t_14
va0_1 = move t_15
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
t_14(0) t_15(0) 
------
colored Nodes:

------
selected Stack:

------

