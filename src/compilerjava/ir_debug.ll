define i64 @func  %a1_1 %a2_1 %a3_1 %a4_1 %a5_1 %a6_1 %a7_1 %a8_1 %a9_1 %a10_1 {
func_entry_1:
   store %vs11_1 %vsp_1 null 0 44
   store %vs8_1 %vsp_1 null 0 40
   store %vs7_1 %vsp_1 null 0 36
   store %vs10_1 %vsp_1 null 0 32
   store %vs3_1 %vsp_1 null 0 28
   store %vs1_1 %vsp_1 null 0 24
   store %vs9_1 %vsp_1 null 0 20
   store %vs5_1 %vsp_1 null 0 16
   store %vs6_1 %vsp_1 null 0 12
   store %vs4_1 %vsp_1 null 0 8
   store %vs2_1 %vsp_1 null 0 4
   store %ra %vsp_1 null 0 0
   %a10_1 = load %vsp_1 null 0 4
   %a9_1 = load %vsp_1 null 0 0
   %a8_1 = move %va7_1
   %a7_1 = move %va6_1
   %a6_1 = move %va5_1
   %a5_1 = move %va4_1
   %a4_1 = move %va3_1
   %a3_1 = move %va2_1
   %a2_1 = move %va1_1
   %a1_1 = move %va0_1
   %t_1 = add %a1_1 %a2_1
   %t_2 = add %t_1 %a3_1
   %t_3 = add %t_2 %a4_1
   %t_4 = add %t_3 %a5_1
   %t_5 = add %t_4 %a6_1
   %t_6 = add %t_5 %a7_1
   %t_7 = add %t_6 %a8_1
   %t_8 = add %t_7 %a9_1
   %t_9 = add %t_8 %a10_1
   %t_10 = move %t_9
   %a0 = move %t_10
   %ra = load %vsp_1 null 0 0
   %vs2_1 = load %vsp_1 null 0 4
   %vs4_1 = load %vsp_1 null 0 8
   %vs6_1 = load %vsp_1 null 0 12
   %vs5_1 = load %vsp_1 null 0 16
   %vs9_1 = load %vsp_1 null 0 20
   %vs1_1 = load %vsp_1 null 0 24
   %vs3_1 = load %vsp_1 null 0 28
   %vs10_1 = load %vsp_1 null 0 32
   %vs7_1 = load %vsp_1 null 0 36
   %vs8_1 = load %vsp_1 null 0 40
   %vs11_1 = load %vsp_1 null 0 44
   ret %a0
}

define i64 @main  {
main_entry_1:
   store %vs11_1 %vsp_1 null 0 52
   store %vs8_1 %vsp_1 null 0 48
   store %vs7_1 %vsp_1 null 0 44
   store %vs10_1 %vsp_1 null 0 40
   store %vs3_1 %vsp_1 null 0 36
   store %vs1_1 %vsp_1 null 0 32
   store %vs9_1 %vsp_1 null 0 28
   store %vs5_1 %vsp_1 null 0 24
   store %vs6_1 %vsp_1 null 0 20
   store %vs4_1 %vsp_1 null 0 16
   store %vs2_1 %vsp_1 null 0 12
   store %ra %vsp_1 null 0 8
   %a1_2 = move 2
   %a2_2 = move 3
   %a3_2 = move 4
   %a4_2 = move 5
   %a5_2 = move 6
   %a6_2 = move 7
   %a7_2 = move 8
   %a8_2 = move 9
   %a9_2 = move 10
   %a10_2 = move 11
   store %a9_2 %vsp_1 null 0 0
   store %a10_2 %vsp_1 null 0 4
   %va0_1 = move %a1_2
   %va1_1 = move %a2_2
   %va2_1 = move %a3_2
   %va3_1 = move %a4_2
   %va4_1 = move %a5_2
   %va5_1 = move %a6_2
   %va6_1 = move %a7_2
   %va7_1 = move %a8_2
   %t_11 = call func %va0_1 %va1_1 %va2_1 %va3_1 %va4_1 %va5_1 %va6_1 %va7_1 %a9_2 %a10_2 
   %t_12 = move %t_11
   %a0 = move %t_12
   %ra = load %vsp_1 null 0 8
   %vs2_1 = load %vsp_1 null 0 12
   %vs4_1 = load %vsp_1 null 0 16
   %vs6_1 = load %vsp_1 null 0 20
   %vs5_1 = load %vsp_1 null 0 24
   %vs9_1 = load %vsp_1 null 0 28
   %vs1_1 = load %vsp_1 null 0 32
   %vs3_1 = load %vsp_1 null 0 36
   %vs10_1 = load %vsp_1 null 0 40
   %vs7_1 = load %vsp_1 null 0 44
   %vs8_1 = load %vsp_1 null 0 48
   %vs11_1 = load %vsp_1 null 0 52
   ret %a0
}

define i64 @__init  {
__init_entry_1:
   store %vs11_1 %vsp_1 null 0 44
   store %vs8_1 %vsp_1 null 0 40
   store %vs7_1 %vsp_1 null 0 36
   store %vs10_1 %vsp_1 null 0 32
   store %vs3_1 %vsp_1 null 0 28
   store %vs1_1 %vsp_1 null 0 24
   store %vs9_1 %vsp_1 null 0 20
   store %vs5_1 %vsp_1 null 0 16
   store %vs6_1 %vsp_1 null 0 12
   store %vs4_1 %vsp_1 null 0 8
   store %vs2_1 %vsp_1 null 0 4
   store %ra %vsp_1 null 0 0
   %t_13 = call main 
   %t_14 = move %t_13
   %a0 = move %t_14
   %ra = load %vsp_1 null 0 0
   %vs2_1 = load %vsp_1 null 0 4
   %vs4_1 = load %vsp_1 null 0 8
   %vs6_1 = load %vsp_1 null 0 12
   %vs5_1 = load %vsp_1 null 0 16
   %vs9_1 = load %vsp_1 null 0 20
   %vs1_1 = load %vsp_1 null 0 24
   %vs3_1 = load %vsp_1 null 0 28
   %vs10_1 = load %vsp_1 null 0 32
   %vs7_1 = load %vsp_1 null 0 36
   %vs8_1 = load %vsp_1 null 0 40
   %vs11_1 = load %vsp_1 null 0 44
   ret %a0
}

=====================func Iteration 0=====================
========func Graph Info ========
t_8:
AdjList :  a10_1 vsp_1 vzero_1
degree : 3
Alias :None
Color : null
Priority : 0
------
t_1:
AdjList :  a9_1 a8_1 a6_1 a7_1 a5_1 a10_1 a4_1 a3_1 vsp_1 vzero_1
degree : 10
Alias :None
Color : null
Priority : 0
------
t_2:
AdjList :  a9_1 a8_1 a6_1 a7_1 a5_1 a10_1 a4_1 vsp_1 vzero_1
degree : 9
Alias :None
Color : null
Priority : 0
------
t_10:
AdjList :  vsp_1 vzero_1
degree : 2
Alias :None
Color : null
Priority : 0
------
a9_1:
AdjList :  t_1 t_2 va1_1 vzero_1 a7_1 va6_1 a3_1 va4_1 a6_1 va2_1 t_3 va3_1 a5_1 a10_1 va5_1 t_5 t_4 t_6 vsp_1 va0_1 a8_1 t_7 a2_1 a4_1 va7_1 a1_1
degree : 26
Alias :None
Color : null
Priority : 0
------
a7_1:
AdjList :  a6_1 va2_1 t_3 va3_1 t_1 a5_1 a10_1 t_2 va5_1 t_5 t_4 va1_1 vsp_1 vzero_1 va0_1 a9_1 a8_1 a2_1 a4_1 a3_1 va4_1 a1_1
degree : 22
Alias :None
Color : null
Priority : 0
------
a3_1:
AdjList :  a6_1 t_1 a5_1 a10_1 va1_1 vsp_1 vzero_1 va0_1 a9_1 a8_1 a7_1 a2_1 a4_1 a1_1
degree : 14
Alias :None
Color : null
Priority : 0
------
a6_1:
AdjList :  va2_1 t_3 va3_1 t_1 a5_1 a10_1 t_2 t_4 va1_1 vsp_1 vzero_1 va0_1 a9_1 a8_1 a7_1 a2_1 a4_1 a3_1 va4_1 a1_1
degree : 20
Alias :None
Color : null
Priority : 0
------
t_3:
AdjList :  a9_1 a8_1 a6_1 a7_1 a5_1 a10_1 vsp_1 vzero_1
degree : 8
Alias :None
Color : null
Priority : 0
------
a5_1:
AdjList :  a6_1 va2_1 t_3 va3_1 t_1 a10_1 t_2 va1_1 vsp_1 vzero_1 va0_1 a9_1 a8_1 a7_1 a2_1 a4_1 a3_1 a1_1
degree : 18
Alias :None
Color : null
Priority : 0
------
a10_1:
AdjList :  t_8 t_1 t_2 va1_1 vzero_1 a9_1 a7_1 va6_1 a3_1 va4_1 a6_1 va2_1 t_3 va3_1 a5_1 va5_1 t_5 t_4 t_6 vsp_1 va0_1 a8_1 t_7 a2_1 a4_1 va7_1 a1_1
degree : 27
Alias :None
Color : null
Priority : 0
------
t_5:
AdjList :  a9_1 a8_1 a7_1 a10_1 vsp_1 vzero_1
degree : 6
Alias :None
Color : null
Priority : 0
------
t_4:
AdjList :  a9_1 a8_1 a6_1 a7_1 a10_1 vsp_1 vzero_1
degree : 7
Alias :None
Color : null
Priority : 0
------
t_6:
AdjList :  a9_1 a8_1 a10_1 vsp_1 vzero_1
degree : 5
Alias :None
Color : null
Priority : 0
------
a8_1:
AdjList :  a6_1 va2_1 t_3 va3_1 t_1 a5_1 a10_1 t_2 va5_1 t_5 t_4 va1_1 t_6 vsp_1 vzero_1 va0_1 a9_1 a7_1 va6_1 a2_1 a4_1 a3_1 va4_1 a1_1
degree : 24
Alias :None
Color : null
Priority : 0
------
t_9:
AdjList :  vsp_1 vzero_1
degree : 2
Alias :None
Color : null
Priority : 0
------
t_7:
AdjList :  a9_1 a10_1 vsp_1 vzero_1
degree : 4
Alias :None
Color : null
Priority : 0
------
a2_1:
AdjList :  a9_1 a8_1 a6_1 a7_1 a5_1 a10_1 a4_1 a3_1 vsp_1 a1_1 vzero_1 va0_1
degree : 12
Alias :None
Color : null
Priority : 0
------
a4_1:
AdjList :  a6_1 va2_1 t_1 a5_1 a10_1 t_2 va1_1 vsp_1 vzero_1 va0_1 a9_1 a8_1 a7_1 a2_1 a3_1 a1_1
degree : 16
Alias :None
Color : null
Priority : 0
------
a1_1:
AdjList :  a9_1 a8_1 a6_1 a7_1 a5_1 a10_1 a2_1 a4_1 a3_1 vsp_1 vzero_1
degree : 11
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
a3_1 = move va2_1
a8_1 = move va7_1
a1_1 = move va0_1
a7_1 = move va6_1
t_10 = move t_9
a6_1 = move va5_1
a4_1 = move va3_1
a2_1 = move va1_1
a5_1 = move va4_1
------
active moves:
========func Node List Info ========
simplify Nodes(low degree non move related):
a9_1(0) t_8(0) t_3(0) t_1(0) t_7(0) a10_1(0) t_2(0) t_5(0) t_4(0) t_6(0) 
------
freeze Nodes(low degree move related):
a6_1(0) a8_1(0) a7_1(0) t_9(0) a5_1(0) a2_1(0) a4_1(0) a3_1(0) t_10(0) a1_1(0) 
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

define i64 @func  %a1_1 %a2_1 %a3_1 %a4_1 %a5_1 %a6_1 %a7_1 %a8_1 %a9_1 %a10_1 {
func_entry_1:
   store %vs11_1 %vsp_1 null 0 44
   store %vs8_1 %vsp_1 null 0 40
   store %vs7_1 %vsp_1 null 0 36
   store %vs10_1 %vsp_1 null 0 32
   store %vs3_1 %vsp_1 null 0 28
   store %vs1_1 %vsp_1 null 0 24
   store %vs9_1 %vsp_1 null 0 20
   store %vs5_1 %vsp_1 null 0 16
   store %vs6_1 %vsp_1 null 0 12
   store %vs4_1 %vsp_1 null 0 8
   store %vs2_1 %vsp_1 null 0 4
   store %ra %vsp_1 null 0 0
   %a10_1 = load %vsp_1 null 0 4
   %a9_1 = load %vsp_1 null 0 0
   %a8_1 = move %va7_1
   %a7_1 = move %va6_1
   %a6_1 = move %va5_1
   %a5_1 = move %va4_1
   %a4_1 = move %va3_1
   %a3_1 = move %va2_1
   %a2_1 = move %va1_1
   %a1_1 = move %va0_1
   %t_1 = add %a1_1 %a2_1
   %t_2 = add %t_1 %a3_1
   %t_3 = add %t_2 %a4_1
   %t_4 = add %t_3 %a5_1
   %t_5 = add %t_4 %a6_1
   %t_6 = add %t_5 %a7_1
   %t_7 = add %t_6 %a8_1
   %t_8 = add %t_7 %a9_1
   %t_9 = add %t_8 %a10_1
   %t_10 = move %t_9
   %a0 = move %t_10
   %ra = load %vsp_1 null 0 0
   %vs2_1 = load %vsp_1 null 0 4
   %vs4_1 = load %vsp_1 null 0 8
   %vs6_1 = load %vsp_1 null 0 12
   %vs5_1 = load %vsp_1 null 0 16
   %vs9_1 = load %vsp_1 null 0 20
   %vs1_1 = load %vsp_1 null 0 24
   %vs3_1 = load %vsp_1 null 0 28
   %vs10_1 = load %vsp_1 null 0 32
   %vs7_1 = load %vsp_1 null 0 36
   %vs8_1 = load %vsp_1 null 0 40
   %vs11_1 = load %vsp_1 null 0 44
   ret %a0
}

define i64 @main  {
main_entry_1:
   store %vs11_1 %vsp_1 null 0 52
   store %vs8_1 %vsp_1 null 0 48
   store %vs7_1 %vsp_1 null 0 44
   store %vs10_1 %vsp_1 null 0 40
   store %vs3_1 %vsp_1 null 0 36
   store %vs1_1 %vsp_1 null 0 32
   store %vs9_1 %vsp_1 null 0 28
   store %vs5_1 %vsp_1 null 0 24
   store %vs6_1 %vsp_1 null 0 20
   store %vs4_1 %vsp_1 null 0 16
   store %vs2_1 %vsp_1 null 0 12
   store %ra %vsp_1 null 0 8
   %a1_2 = move 2
   %a2_2 = move 3
   %a3_2 = move 4
   %a4_2 = move 5
   %a5_2 = move 6
   %a6_2 = move 7
   %a7_2 = move 8
   %a8_2 = move 9
   %a9_2 = move 10
   %a10_2 = move 11
   store %a9_2 %vsp_1 null 0 0
   store %a10_2 %vsp_1 null 0 4
   %va0_1 = move %a1_2
   %va1_1 = move %a2_2
   %va2_1 = move %a3_2
   %va3_1 = move %a4_2
   %va4_1 = move %a5_2
   %va5_1 = move %a6_2
   %va6_1 = move %a7_2
   %va7_1 = move %a8_2
   %t_11 = call func %va0_1 %va1_1 %va2_1 %va3_1 %va4_1 %va5_1 %va6_1 %va7_1 %a9_2 %a10_2 
   %t_12 = move %t_11
   %a0 = move %t_12
   %ra = load %vsp_1 null 0 8
   %vs2_1 = load %vsp_1 null 0 12
   %vs4_1 = load %vsp_1 null 0 16
   %vs6_1 = load %vsp_1 null 0 20
   %vs5_1 = load %vsp_1 null 0 24
   %vs9_1 = load %vsp_1 null 0 28
   %vs1_1 = load %vsp_1 null 0 32
   %vs3_1 = load %vsp_1 null 0 36
   %vs10_1 = load %vsp_1 null 0 40
   %vs7_1 = load %vsp_1 null 0 44
   %vs8_1 = load %vsp_1 null 0 48
   %vs11_1 = load %vsp_1 null 0 52
   ret %a0
}

define i64 @__init  {
__init_entry_1:
   store %vs11_1 %vsp_1 null 0 44
   store %vs8_1 %vsp_1 null 0 40
   store %vs7_1 %vsp_1 null 0 36
   store %vs10_1 %vsp_1 null 0 32
   store %vs3_1 %vsp_1 null 0 28
   store %vs1_1 %vsp_1 null 0 24
   store %vs9_1 %vsp_1 null 0 20
   store %vs5_1 %vsp_1 null 0 16
   store %vs6_1 %vsp_1 null 0 12
   store %vs4_1 %vsp_1 null 0 8
   store %vs2_1 %vsp_1 null 0 4
   store %ra %vsp_1 null 0 0
   %t_13 = call main 
   %t_14 = move %t_13
   %a0 = move %t_14
   %ra = load %vsp_1 null 0 0
   %vs2_1 = load %vsp_1 null 0 4
   %vs4_1 = load %vsp_1 null 0 8
   %vs6_1 = load %vsp_1 null 0 12
   %vs5_1 = load %vsp_1 null 0 16
   %vs9_1 = load %vsp_1 null 0 20
   %vs1_1 = load %vsp_1 null 0 24
   %vs3_1 = load %vsp_1 null 0 28
   %vs10_1 = load %vsp_1 null 0 32
   %vs7_1 = load %vsp_1 null 0 36
   %vs8_1 = load %vsp_1 null 0 40
   %vs11_1 = load %vsp_1 null 0 44
   ret %a0
}

===================== Simplify =====================
========func Graph Info ========
t_8:
AdjList :  a10_1 vsp_1 vzero_1
degree : 3
Alias :None
Color : null
Priority : 0
------
t_1:
AdjList :  a9_1 a8_1 a6_1 a7_1 a5_1 a10_1 a4_1 a3_1 vsp_1 vzero_1
degree : 9
Alias :None
Color : null
Priority : 0
------
t_2:
AdjList :  a9_1 a8_1 a6_1 a7_1 a5_1 a10_1 a4_1 vsp_1 vzero_1
degree : 8
Alias :None
Color : null
Priority : 0
------
t_10:
AdjList :  vsp_1 vzero_1
degree : 2
Alias :None
Color : null
Priority : 0
------
a9_1:
AdjList :  t_1 t_2 va1_1 vzero_1 a7_1 va6_1 a3_1 va4_1 a6_1 va2_1 t_3 va3_1 a5_1 a10_1 va5_1 t_5 t_4 t_6 vsp_1 va0_1 a8_1 t_7 a2_1 a4_1 va7_1 a1_1
degree : 26
Alias :None
Color : null
Priority : 0
------
a7_1:
AdjList :  a6_1 va2_1 t_3 va3_1 t_1 a5_1 a10_1 t_2 va5_1 t_5 t_4 va1_1 vsp_1 vzero_1 va0_1 a9_1 a8_1 a2_1 a4_1 a3_1 va4_1 a1_1
degree : 21
Alias :None
Color : null
Priority : 0
------
a3_1:
AdjList :  a6_1 t_1 a5_1 a10_1 va1_1 vsp_1 vzero_1 va0_1 a9_1 a8_1 a7_1 a2_1 a4_1 a1_1
degree : 13
Alias :None
Color : null
Priority : 0
------
a6_1:
AdjList :  va2_1 t_3 va3_1 t_1 a5_1 a10_1 t_2 t_4 va1_1 vsp_1 vzero_1 va0_1 a9_1 a8_1 a7_1 a2_1 a4_1 a3_1 va4_1 a1_1
degree : 19
Alias :None
Color : null
Priority : 0
------
t_3:
AdjList :  a9_1 a8_1 a6_1 a7_1 a5_1 a10_1 vsp_1 vzero_1
degree : 7
Alias :None
Color : null
Priority : 0
------
a5_1:
AdjList :  a6_1 va2_1 t_3 va3_1 t_1 a10_1 t_2 va1_1 vsp_1 vzero_1 va0_1 a9_1 a8_1 a7_1 a2_1 a4_1 a3_1 a1_1
degree : 17
Alias :None
Color : null
Priority : 0
------
a10_1:
AdjList :  t_8 t_1 t_2 va1_1 vzero_1 a9_1 a7_1 va6_1 a3_1 va4_1 a6_1 va2_1 t_3 va3_1 a5_1 va5_1 t_5 t_4 t_6 vsp_1 va0_1 a8_1 t_7 a2_1 a4_1 va7_1 a1_1
degree : 26
Alias :None
Color : null
Priority : 0
------
t_5:
AdjList :  a9_1 a8_1 a7_1 a10_1 vsp_1 vzero_1
degree : 5
Alias :None
Color : null
Priority : 0
------
t_4:
AdjList :  a9_1 a8_1 a6_1 a7_1 a10_1 vsp_1 vzero_1
degree : 6
Alias :None
Color : null
Priority : 0
------
t_6:
AdjList :  a9_1 a8_1 a10_1 vsp_1 vzero_1
degree : 4
Alias :None
Color : null
Priority : 0
------
a8_1:
AdjList :  a6_1 va2_1 t_3 va3_1 t_1 a5_1 a10_1 t_2 va5_1 t_5 t_4 va1_1 t_6 vsp_1 vzero_1 va0_1 a9_1 a7_1 va6_1 a2_1 a4_1 a3_1 va4_1 a1_1
degree : 23
Alias :None
Color : null
Priority : 0
------
t_9:
AdjList :  vsp_1 vzero_1
degree : 2
Alias :None
Color : null
Priority : 0
------
t_7:
AdjList :  a9_1 a10_1 vsp_1 vzero_1
degree : 3
Alias :None
Color : null
Priority : 0
------
a2_1:
AdjList :  a9_1 a8_1 a6_1 a7_1 a5_1 a10_1 a4_1 a3_1 vsp_1 a1_1 vzero_1 va0_1
degree : 11
Alias :None
Color : null
Priority : 0
------
a4_1:
AdjList :  a6_1 va2_1 t_1 a5_1 a10_1 t_2 va1_1 vsp_1 vzero_1 va0_1 a9_1 a8_1 a7_1 a2_1 a3_1 a1_1
degree : 15
Alias :None
Color : null
Priority : 0
------
a1_1:
AdjList :  a9_1 a8_1 a6_1 a7_1 a5_1 a10_1 a2_1 a4_1 a3_1 vsp_1 vzero_1
degree : 10
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
a3_1 = move va2_1
a8_1 = move va7_1
a1_1 = move va0_1
a7_1 = move va6_1
t_10 = move t_9
a6_1 = move va5_1
a4_1 = move va3_1
a2_1 = move va1_1
a5_1 = move va4_1
------
active moves:
========func Node List Info ========
simplify Nodes(low degree non move related):
t_8(0) t_3(0) t_1(0) t_7(0) a10_1(0) t_2(0) t_5(0) t_4(0) t_6(0) 
------
freeze Nodes(low degree move related):
a6_1(0) a8_1(0) a7_1(0) t_9(0) a5_1(0) a2_1(0) a4_1(0) a3_1(0) t_10(0) a1_1(0) 
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
a9_1(0) 
------

===================== Simplify =====================
========func Graph Info ========
t_8:
AdjList :  a10_1 vsp_1 vzero_1
degree : 3
Alias :None
Color : null
Priority : 0
------
t_1:
AdjList :  a9_1 a8_1 a6_1 a7_1 a5_1 a10_1 a4_1 a3_1 vsp_1 vzero_1
degree : 9
Alias :None
Color : null
Priority : 0
------
t_2:
AdjList :  a9_1 a8_1 a6_1 a7_1 a5_1 a10_1 a4_1 vsp_1 vzero_1
degree : 8
Alias :None
Color : null
Priority : 0
------
t_10:
AdjList :  vsp_1 vzero_1
degree : 2
Alias :None
Color : null
Priority : 0
------
a9_1:
AdjList :  t_1 t_2 va1_1 vzero_1 a7_1 va6_1 a3_1 va4_1 a6_1 va2_1 t_3 va3_1 a5_1 a10_1 va5_1 t_5 t_4 t_6 vsp_1 va0_1 a8_1 t_7 a2_1 a4_1 va7_1 a1_1
degree : 26
Alias :None
Color : null
Priority : 0
------
a7_1:
AdjList :  a6_1 va2_1 t_3 va3_1 t_1 a5_1 a10_1 t_2 va5_1 t_5 t_4 va1_1 vsp_1 vzero_1 va0_1 a9_1 a8_1 a2_1 a4_1 a3_1 va4_1 a1_1
degree : 21
Alias :None
Color : null
Priority : 0
------
a3_1:
AdjList :  a6_1 t_1 a5_1 a10_1 va1_1 vsp_1 vzero_1 va0_1 a9_1 a8_1 a7_1 a2_1 a4_1 a1_1
degree : 13
Alias :None
Color : null
Priority : 0
------
a6_1:
AdjList :  va2_1 t_3 va3_1 t_1 a5_1 a10_1 t_2 t_4 va1_1 vsp_1 vzero_1 va0_1 a9_1 a8_1 a7_1 a2_1 a4_1 a3_1 va4_1 a1_1
degree : 19
Alias :None
Color : null
Priority : 0
------
t_3:
AdjList :  a9_1 a8_1 a6_1 a7_1 a5_1 a10_1 vsp_1 vzero_1
degree : 7
Alias :None
Color : null
Priority : 0
------
a5_1:
AdjList :  a6_1 va2_1 t_3 va3_1 t_1 a10_1 t_2 va1_1 vsp_1 vzero_1 va0_1 a9_1 a8_1 a7_1 a2_1 a4_1 a3_1 a1_1
degree : 17
Alias :None
Color : null
Priority : 0
------
a10_1:
AdjList :  t_8 t_1 t_2 va1_1 vzero_1 a9_1 a7_1 va6_1 a3_1 va4_1 a6_1 va2_1 t_3 va3_1 a5_1 va5_1 t_5 t_4 t_6 vsp_1 va0_1 a8_1 t_7 a2_1 a4_1 va7_1 a1_1
degree : 25
Alias :None
Color : null
Priority : 0
------
t_5:
AdjList :  a9_1 a8_1 a7_1 a10_1 vsp_1 vzero_1
degree : 5
Alias :None
Color : null
Priority : 0
------
t_4:
AdjList :  a9_1 a8_1 a6_1 a7_1 a10_1 vsp_1 vzero_1
degree : 6
Alias :None
Color : null
Priority : 0
------
t_6:
AdjList :  a9_1 a8_1 a10_1 vsp_1 vzero_1
degree : 4
Alias :None
Color : null
Priority : 0
------
a8_1:
AdjList :  a6_1 va2_1 t_3 va3_1 t_1 a5_1 a10_1 t_2 va5_1 t_5 t_4 va1_1 t_6 vsp_1 vzero_1 va0_1 a9_1 a7_1 va6_1 a2_1 a4_1 a3_1 va4_1 a1_1
degree : 23
Alias :None
Color : null
Priority : 0
------
t_9:
AdjList :  vsp_1 vzero_1
degree : 2
Alias :None
Color : null
Priority : 0
------
t_7:
AdjList :  a9_1 a10_1 vsp_1 vzero_1
degree : 3
Alias :None
Color : null
Priority : 0
------
a2_1:
AdjList :  a9_1 a8_1 a6_1 a7_1 a5_1 a10_1 a4_1 a3_1 vsp_1 a1_1 vzero_1 va0_1
degree : 11
Alias :None
Color : null
Priority : 0
------
a4_1:
AdjList :  a6_1 va2_1 t_1 a5_1 a10_1 t_2 va1_1 vsp_1 vzero_1 va0_1 a9_1 a8_1 a7_1 a2_1 a3_1 a1_1
degree : 15
Alias :None
Color : null
Priority : 0
------
a1_1:
AdjList :  a9_1 a8_1 a6_1 a7_1 a5_1 a10_1 a2_1 a4_1 a3_1 vsp_1 vzero_1
degree : 10
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
a3_1 = move va2_1
a8_1 = move va7_1
a1_1 = move va0_1
a7_1 = move va6_1
t_10 = move t_9
a6_1 = move va5_1
a4_1 = move va3_1
a2_1 = move va1_1
a5_1 = move va4_1
------
active moves:
========func Node List Info ========
simplify Nodes(low degree non move related):
t_3(0) t_1(0) t_7(0) a10_1(0) t_2(0) t_5(0) t_4(0) t_6(0) 
------
freeze Nodes(low degree move related):
a6_1(0) a8_1(0) a7_1(0) t_9(0) a5_1(0) a2_1(0) a4_1(0) a3_1(0) t_10(0) a1_1(0) 
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
a9_1(0) t_8(0) 
------

===================== Simplify =====================
========func Graph Info ========
t_8:
AdjList :  a10_1 vsp_1 vzero_1
degree : 3
Alias :None
Color : null
Priority : 0
------
t_1:
AdjList :  a9_1 a8_1 a6_1 a7_1 a5_1 a10_1 a4_1 a3_1 vsp_1 vzero_1
degree : 9
Alias :None
Color : null
Priority : 0
------
t_2:
AdjList :  a9_1 a8_1 a6_1 a7_1 a5_1 a10_1 a4_1 vsp_1 vzero_1
degree : 8
Alias :None
Color : null
Priority : 0
------
t_10:
AdjList :  vsp_1 vzero_1
degree : 2
Alias :None
Color : null
Priority : 0
------
a9_1:
AdjList :  t_1 t_2 va1_1 vzero_1 a7_1 va6_1 a3_1 va4_1 a6_1 va2_1 t_3 va3_1 a5_1 a10_1 va5_1 t_5 t_4 t_6 vsp_1 va0_1 a8_1 t_7 a2_1 a4_1 va7_1 a1_1
degree : 26
Alias :None
Color : null
Priority : 0
------
a7_1:
AdjList :  a6_1 va2_1 t_3 va3_1 t_1 a5_1 a10_1 t_2 va5_1 t_5 t_4 va1_1 vsp_1 vzero_1 va0_1 a9_1 a8_1 a2_1 a4_1 a3_1 va4_1 a1_1
degree : 20
Alias :None
Color : null
Priority : 0
------
a3_1:
AdjList :  a6_1 t_1 a5_1 a10_1 va1_1 vsp_1 vzero_1 va0_1 a9_1 a8_1 a7_1 a2_1 a4_1 a1_1
degree : 13
Alias :None
Color : null
Priority : 0
------
a6_1:
AdjList :  va2_1 t_3 va3_1 t_1 a5_1 a10_1 t_2 t_4 va1_1 vsp_1 vzero_1 va0_1 a9_1 a8_1 a7_1 a2_1 a4_1 a3_1 va4_1 a1_1
degree : 18
Alias :None
Color : null
Priority : 0
------
t_3:
AdjList :  a9_1 a8_1 a6_1 a7_1 a5_1 a10_1 vsp_1 vzero_1
degree : 7
Alias :None
Color : null
Priority : 0
------
a5_1:
AdjList :  a6_1 va2_1 t_3 va3_1 t_1 a10_1 t_2 va1_1 vsp_1 vzero_1 va0_1 a9_1 a8_1 a7_1 a2_1 a4_1 a3_1 a1_1
degree : 16
Alias :None
Color : null
Priority : 0
------
a10_1:
AdjList :  t_8 t_1 t_2 va1_1 vzero_1 a9_1 a7_1 va6_1 a3_1 va4_1 a6_1 va2_1 t_3 va3_1 a5_1 va5_1 t_5 t_4 t_6 vsp_1 va0_1 a8_1 t_7 a2_1 a4_1 va7_1 a1_1
degree : 24
Alias :None
Color : null
Priority : 0
------
t_5:
AdjList :  a9_1 a8_1 a7_1 a10_1 vsp_1 vzero_1
degree : 5
Alias :None
Color : null
Priority : 0
------
t_4:
AdjList :  a9_1 a8_1 a6_1 a7_1 a10_1 vsp_1 vzero_1
degree : 6
Alias :None
Color : null
Priority : 0
------
t_6:
AdjList :  a9_1 a8_1 a10_1 vsp_1 vzero_1
degree : 4
Alias :None
Color : null
Priority : 0
------
a8_1:
AdjList :  a6_1 va2_1 t_3 va3_1 t_1 a5_1 a10_1 t_2 va5_1 t_5 t_4 va1_1 t_6 vsp_1 vzero_1 va0_1 a9_1 a7_1 va6_1 a2_1 a4_1 a3_1 va4_1 a1_1
degree : 22
Alias :None
Color : null
Priority : 0
------
t_9:
AdjList :  vsp_1 vzero_1
degree : 2
Alias :None
Color : null
Priority : 0
------
t_7:
AdjList :  a9_1 a10_1 vsp_1 vzero_1
degree : 3
Alias :None
Color : null
Priority : 0
------
a2_1:
AdjList :  a9_1 a8_1 a6_1 a7_1 a5_1 a10_1 a4_1 a3_1 vsp_1 a1_1 vzero_1 va0_1
degree : 11
Alias :None
Color : null
Priority : 0
------
a4_1:
AdjList :  a6_1 va2_1 t_1 a5_1 a10_1 t_2 va1_1 vsp_1 vzero_1 va0_1 a9_1 a8_1 a7_1 a2_1 a3_1 a1_1
degree : 15
Alias :None
Color : null
Priority : 0
------
a1_1:
AdjList :  a9_1 a8_1 a6_1 a7_1 a5_1 a10_1 a2_1 a4_1 a3_1 vsp_1 vzero_1
degree : 10
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
a3_1 = move va2_1
a8_1 = move va7_1
a1_1 = move va0_1
a7_1 = move va6_1
t_10 = move t_9
a6_1 = move va5_1
a4_1 = move va3_1
a2_1 = move va1_1
a5_1 = move va4_1
------
active moves:
========func Node List Info ========
simplify Nodes(low degree non move related):
t_1(0) t_7(0) a10_1(0) t_2(0) t_5(0) t_4(0) t_6(0) 
------
freeze Nodes(low degree move related):
a6_1(0) a8_1(0) a7_1(0) t_9(0) a5_1(0) a2_1(0) a4_1(0) a3_1(0) t_10(0) a1_1(0) 
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
a9_1(0) t_8(0) t_3(0) 
------

===================== Simplify =====================
========func Graph Info ========
t_8:
AdjList :  a10_1 vsp_1 vzero_1
degree : 3
Alias :None
Color : null
Priority : 0
------
t_1:
AdjList :  a9_1 a8_1 a6_1 a7_1 a5_1 a10_1 a4_1 a3_1 vsp_1 vzero_1
degree : 9
Alias :None
Color : null
Priority : 0
------
t_2:
AdjList :  a9_1 a8_1 a6_1 a7_1 a5_1 a10_1 a4_1 vsp_1 vzero_1
degree : 8
Alias :None
Color : null
Priority : 0
------
t_10:
AdjList :  vsp_1 vzero_1
degree : 2
Alias :None
Color : null
Priority : 0
------
a9_1:
AdjList :  t_1 t_2 va1_1 vzero_1 a7_1 va6_1 a3_1 va4_1 a6_1 va2_1 t_3 va3_1 a5_1 a10_1 va5_1 t_5 t_4 t_6 vsp_1 va0_1 a8_1 t_7 a2_1 a4_1 va7_1 a1_1
degree : 26
Alias :None
Color : null
Priority : 0
------
a7_1:
AdjList :  a6_1 va2_1 t_3 va3_1 t_1 a5_1 a10_1 t_2 va5_1 t_5 t_4 va1_1 vsp_1 vzero_1 va0_1 a9_1 a8_1 a2_1 a4_1 a3_1 va4_1 a1_1
degree : 19
Alias :None
Color : null
Priority : 0
------
a3_1:
AdjList :  a6_1 t_1 a5_1 a10_1 va1_1 vsp_1 vzero_1 va0_1 a9_1 a8_1 a7_1 a2_1 a4_1 a1_1
degree : 12
Alias :None
Color : null
Priority : 0
------
a6_1:
AdjList :  va2_1 t_3 va3_1 t_1 a5_1 a10_1 t_2 t_4 va1_1 vsp_1 vzero_1 va0_1 a9_1 a8_1 a7_1 a2_1 a4_1 a3_1 va4_1 a1_1
degree : 17
Alias :None
Color : null
Priority : 0
------
t_3:
AdjList :  a9_1 a8_1 a6_1 a7_1 a5_1 a10_1 vsp_1 vzero_1
degree : 7
Alias :None
Color : null
Priority : 0
------
a5_1:
AdjList :  a6_1 va2_1 t_3 va3_1 t_1 a10_1 t_2 va1_1 vsp_1 vzero_1 va0_1 a9_1 a8_1 a7_1 a2_1 a4_1 a3_1 a1_1
degree : 15
Alias :None
Color : null
Priority : 0
------
a10_1:
AdjList :  t_8 t_1 t_2 va1_1 vzero_1 a9_1 a7_1 va6_1 a3_1 va4_1 a6_1 va2_1 t_3 va3_1 a5_1 va5_1 t_5 t_4 t_6 vsp_1 va0_1 a8_1 t_7 a2_1 a4_1 va7_1 a1_1
degree : 23
Alias :None
Color : null
Priority : 0
------
t_5:
AdjList :  a9_1 a8_1 a7_1 a10_1 vsp_1 vzero_1
degree : 5
Alias :None
Color : null
Priority : 0
------
t_4:
AdjList :  a9_1 a8_1 a6_1 a7_1 a10_1 vsp_1 vzero_1
degree : 6
Alias :None
Color : null
Priority : 0
------
t_6:
AdjList :  a9_1 a8_1 a10_1 vsp_1 vzero_1
degree : 4
Alias :None
Color : null
Priority : 0
------
a8_1:
AdjList :  a6_1 va2_1 t_3 va3_1 t_1 a5_1 a10_1 t_2 va5_1 t_5 t_4 va1_1 t_6 vsp_1 vzero_1 va0_1 a9_1 a7_1 va6_1 a2_1 a4_1 a3_1 va4_1 a1_1
degree : 21
Alias :None
Color : null
Priority : 0
------
t_9:
AdjList :  vsp_1 vzero_1
degree : 2
Alias :None
Color : null
Priority : 0
------
t_7:
AdjList :  a9_1 a10_1 vsp_1 vzero_1
degree : 3
Alias :None
Color : null
Priority : 0
------
a2_1:
AdjList :  a9_1 a8_1 a6_1 a7_1 a5_1 a10_1 a4_1 a3_1 vsp_1 a1_1 vzero_1 va0_1
degree : 11
Alias :None
Color : null
Priority : 0
------
a4_1:
AdjList :  a6_1 va2_1 t_1 a5_1 a10_1 t_2 va1_1 vsp_1 vzero_1 va0_1 a9_1 a8_1 a7_1 a2_1 a3_1 a1_1
degree : 14
Alias :None
Color : null
Priority : 0
------
a1_1:
AdjList :  a9_1 a8_1 a6_1 a7_1 a5_1 a10_1 a2_1 a4_1 a3_1 vsp_1 vzero_1
degree : 10
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
a3_1 = move va2_1
a8_1 = move va7_1
a1_1 = move va0_1
a7_1 = move va6_1
t_10 = move t_9
a6_1 = move va5_1
a4_1 = move va3_1
a2_1 = move va1_1
a5_1 = move va4_1
------
active moves:
========func Node List Info ========
simplify Nodes(low degree non move related):
t_7(0) a10_1(0) t_2(0) t_5(0) t_4(0) t_6(0) 
------
freeze Nodes(low degree move related):
a6_1(0) a8_1(0) a7_1(0) t_9(0) a5_1(0) a2_1(0) a4_1(0) a3_1(0) t_10(0) a1_1(0) 
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
a9_1(0) t_8(0) t_3(0) t_1(0) 
------

===================== Simplify =====================
========func Graph Info ========
t_8:
AdjList :  a10_1 vsp_1 vzero_1
degree : 3
Alias :None
Color : null
Priority : 0
------
t_1:
AdjList :  a9_1 a8_1 a6_1 a7_1 a5_1 a10_1 a4_1 a3_1 vsp_1 vzero_1
degree : 9
Alias :None
Color : null
Priority : 0
------
t_2:
AdjList :  a9_1 a8_1 a6_1 a7_1 a5_1 a10_1 a4_1 vsp_1 vzero_1
degree : 8
Alias :None
Color : null
Priority : 0
------
t_10:
AdjList :  vsp_1 vzero_1
degree : 2
Alias :None
Color : null
Priority : 0
------
a9_1:
AdjList :  t_1 t_2 va1_1 vzero_1 a7_1 va6_1 a3_1 va4_1 a6_1 va2_1 t_3 va3_1 a5_1 a10_1 va5_1 t_5 t_4 t_6 vsp_1 va0_1 a8_1 t_7 a2_1 a4_1 va7_1 a1_1
degree : 26
Alias :None
Color : null
Priority : 0
------
a7_1:
AdjList :  a6_1 va2_1 t_3 va3_1 t_1 a5_1 a10_1 t_2 va5_1 t_5 t_4 va1_1 vsp_1 vzero_1 va0_1 a9_1 a8_1 a2_1 a4_1 a3_1 va4_1 a1_1
degree : 19
Alias :None
Color : null
Priority : 0
------
a3_1:
AdjList :  a6_1 t_1 a5_1 a10_1 va1_1 vsp_1 vzero_1 va0_1 a9_1 a8_1 a7_1 a2_1 a4_1 a1_1
degree : 12
Alias :None
Color : null
Priority : 0
------
a6_1:
AdjList :  va2_1 t_3 va3_1 t_1 a5_1 a10_1 t_2 t_4 va1_1 vsp_1 vzero_1 va0_1 a9_1 a8_1 a7_1 a2_1 a4_1 a3_1 va4_1 a1_1
degree : 17
Alias :None
Color : null
Priority : 0
------
t_3:
AdjList :  a9_1 a8_1 a6_1 a7_1 a5_1 a10_1 vsp_1 vzero_1
degree : 7
Alias :None
Color : null
Priority : 0
------
a5_1:
AdjList :  a6_1 va2_1 t_3 va3_1 t_1 a10_1 t_2 va1_1 vsp_1 vzero_1 va0_1 a9_1 a8_1 a7_1 a2_1 a4_1 a3_1 a1_1
degree : 15
Alias :None
Color : null
Priority : 0
------
a10_1:
AdjList :  t_8 t_1 t_2 va1_1 vzero_1 a9_1 a7_1 va6_1 a3_1 va4_1 a6_1 va2_1 t_3 va3_1 a5_1 va5_1 t_5 t_4 t_6 vsp_1 va0_1 a8_1 t_7 a2_1 a4_1 va7_1 a1_1
degree : 22
Alias :None
Color : null
Priority : 0
------
t_5:
AdjList :  a9_1 a8_1 a7_1 a10_1 vsp_1 vzero_1
degree : 5
Alias :None
Color : null
Priority : 0
------
t_4:
AdjList :  a9_1 a8_1 a6_1 a7_1 a10_1 vsp_1 vzero_1
degree : 6
Alias :None
Color : null
Priority : 0
------
t_6:
AdjList :  a9_1 a8_1 a10_1 vsp_1 vzero_1
degree : 4
Alias :None
Color : null
Priority : 0
------
a8_1:
AdjList :  a6_1 va2_1 t_3 va3_1 t_1 a5_1 a10_1 t_2 va5_1 t_5 t_4 va1_1 t_6 vsp_1 vzero_1 va0_1 a9_1 a7_1 va6_1 a2_1 a4_1 a3_1 va4_1 a1_1
degree : 21
Alias :None
Color : null
Priority : 0
------
t_9:
AdjList :  vsp_1 vzero_1
degree : 2
Alias :None
Color : null
Priority : 0
------
t_7:
AdjList :  a9_1 a10_1 vsp_1 vzero_1
degree : 3
Alias :None
Color : null
Priority : 0
------
a2_1:
AdjList :  a9_1 a8_1 a6_1 a7_1 a5_1 a10_1 a4_1 a3_1 vsp_1 a1_1 vzero_1 va0_1
degree : 11
Alias :None
Color : null
Priority : 0
------
a4_1:
AdjList :  a6_1 va2_1 t_1 a5_1 a10_1 t_2 va1_1 vsp_1 vzero_1 va0_1 a9_1 a8_1 a7_1 a2_1 a3_1 a1_1
degree : 14
Alias :None
Color : null
Priority : 0
------
a1_1:
AdjList :  a9_1 a8_1 a6_1 a7_1 a5_1 a10_1 a2_1 a4_1 a3_1 vsp_1 vzero_1
degree : 10
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
a3_1 = move va2_1
a8_1 = move va7_1
a1_1 = move va0_1
a7_1 = move va6_1
t_10 = move t_9
a6_1 = move va5_1
a4_1 = move va3_1
a2_1 = move va1_1
a5_1 = move va4_1
------
active moves:
========func Node List Info ========
simplify Nodes(low degree non move related):
a10_1(0) t_2(0) t_5(0) t_4(0) t_6(0) 
------
freeze Nodes(low degree move related):
a6_1(0) a8_1(0) a7_1(0) t_9(0) a5_1(0) a2_1(0) a4_1(0) a3_1(0) t_10(0) a1_1(0) 
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
a9_1(0) t_8(0) t_3(0) t_1(0) t_7(0) 
------

===================== Simplify =====================
========func Graph Info ========
t_8:
AdjList :  a10_1 vsp_1 vzero_1
degree : 3
Alias :None
Color : null
Priority : 0
------
t_1:
AdjList :  a9_1 a8_1 a6_1 a7_1 a5_1 a10_1 a4_1 a3_1 vsp_1 vzero_1
degree : 9
Alias :None
Color : null
Priority : 0
------
t_2:
AdjList :  a9_1 a8_1 a6_1 a7_1 a5_1 a10_1 a4_1 vsp_1 vzero_1
degree : 7
Alias :None
Color : null
Priority : 0
------
t_10:
AdjList :  vsp_1 vzero_1
degree : 2
Alias :None
Color : null
Priority : 0
------
a9_1:
AdjList :  t_1 t_2 va1_1 vzero_1 a7_1 va6_1 a3_1 va4_1 a6_1 va2_1 t_3 va3_1 a5_1 a10_1 va5_1 t_5 t_4 t_6 vsp_1 va0_1 a8_1 t_7 a2_1 a4_1 va7_1 a1_1
degree : 26
Alias :None
Color : null
Priority : 0
------
a7_1:
AdjList :  a6_1 va2_1 t_3 va3_1 t_1 a5_1 a10_1 t_2 va5_1 t_5 t_4 va1_1 vsp_1 vzero_1 va0_1 a9_1 a8_1 a2_1 a4_1 a3_1 va4_1 a1_1
degree : 18
Alias :None
Color : null
Priority : 0
------
a3_1:
AdjList :  a6_1 t_1 a5_1 a10_1 va1_1 vsp_1 vzero_1 va0_1 a9_1 a8_1 a7_1 a2_1 a4_1 a1_1
degree : 11
Alias :None
Color : null
Priority : 0
------
a6_1:
AdjList :  va2_1 t_3 va3_1 t_1 a5_1 a10_1 t_2 t_4 va1_1 vsp_1 vzero_1 va0_1 a9_1 a8_1 a7_1 a2_1 a4_1 a3_1 va4_1 a1_1
degree : 16
Alias :None
Color : null
Priority : 0
------
t_3:
AdjList :  a9_1 a8_1 a6_1 a7_1 a5_1 a10_1 vsp_1 vzero_1
degree : 7
Alias :None
Color : null
Priority : 0
------
a5_1:
AdjList :  a6_1 va2_1 t_3 va3_1 t_1 a10_1 t_2 va1_1 vsp_1 vzero_1 va0_1 a9_1 a8_1 a7_1 a2_1 a4_1 a3_1 a1_1
degree : 14
Alias :None
Color : null
Priority : 0
------
a10_1:
AdjList :  t_8 t_1 t_2 va1_1 vzero_1 a9_1 a7_1 va6_1 a3_1 va4_1 a6_1 va2_1 t_3 va3_1 a5_1 va5_1 t_5 t_4 t_6 vsp_1 va0_1 a8_1 t_7 a2_1 a4_1 va7_1 a1_1
degree : 22
Alias :None
Color : null
Priority : 0
------
t_5:
AdjList :  a9_1 a8_1 a7_1 a10_1 vsp_1 vzero_1
degree : 4
Alias :None
Color : null
Priority : 0
------
t_4:
AdjList :  a9_1 a8_1 a6_1 a7_1 a10_1 vsp_1 vzero_1
degree : 5
Alias :None
Color : null
Priority : 0
------
t_6:
AdjList :  a9_1 a8_1 a10_1 vsp_1 vzero_1
degree : 3
Alias :None
Color : null
Priority : 0
------
a8_1:
AdjList :  a6_1 va2_1 t_3 va3_1 t_1 a5_1 a10_1 t_2 va5_1 t_5 t_4 va1_1 t_6 vsp_1 vzero_1 va0_1 a9_1 a7_1 va6_1 a2_1 a4_1 a3_1 va4_1 a1_1
degree : 20
Alias :None
Color : null
Priority : 0
------
t_9:
AdjList :  vsp_1 vzero_1
degree : 2
Alias :None
Color : null
Priority : 0
------
t_7:
AdjList :  a9_1 a10_1 vsp_1 vzero_1
degree : 3
Alias :None
Color : null
Priority : 0
------
a2_1:
AdjList :  a9_1 a8_1 a6_1 a7_1 a5_1 a10_1 a4_1 a3_1 vsp_1 a1_1 vzero_1 va0_1
degree : 10
Alias :None
Color : null
Priority : 0
------
a4_1:
AdjList :  a6_1 va2_1 t_1 a5_1 a10_1 t_2 va1_1 vsp_1 vzero_1 va0_1 a9_1 a8_1 a7_1 a2_1 a3_1 a1_1
degree : 13
Alias :None
Color : null
Priority : 0
------
a1_1:
AdjList :  a9_1 a8_1 a6_1 a7_1 a5_1 a10_1 a2_1 a4_1 a3_1 vsp_1 vzero_1
degree : 9
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
a3_1 = move va2_1
a8_1 = move va7_1
a1_1 = move va0_1
a7_1 = move va6_1
t_10 = move t_9
a6_1 = move va5_1
a4_1 = move va3_1
a2_1 = move va1_1
a5_1 = move va4_1
------
active moves:
========func Node List Info ========
simplify Nodes(low degree non move related):
t_2(0) t_5(0) t_4(0) t_6(0) 
------
freeze Nodes(low degree move related):
a6_1(0) a8_1(0) a7_1(0) t_9(0) a5_1(0) a2_1(0) a4_1(0) a3_1(0) t_10(0) a1_1(0) 
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
a9_1(0) t_8(0) t_3(0) t_1(0) t_7(0) a10_1(0) 
------

===================== Simplify =====================
========func Graph Info ========
t_8:
AdjList :  a10_1 vsp_1 vzero_1
degree : 3
Alias :None
Color : null
Priority : 0
------
t_1:
AdjList :  a9_1 a8_1 a6_1 a7_1 a5_1 a10_1 a4_1 a3_1 vsp_1 vzero_1
degree : 9
Alias :None
Color : null
Priority : 0
------
t_2:
AdjList :  a9_1 a8_1 a6_1 a7_1 a5_1 a10_1 a4_1 vsp_1 vzero_1
degree : 7
Alias :None
Color : null
Priority : 0
------
t_10:
AdjList :  vsp_1 vzero_1
degree : 2
Alias :None
Color : null
Priority : 0
------
a9_1:
AdjList :  t_1 t_2 va1_1 vzero_1 a7_1 va6_1 a3_1 va4_1 a6_1 va2_1 t_3 va3_1 a5_1 a10_1 va5_1 t_5 t_4 t_6 vsp_1 va0_1 a8_1 t_7 a2_1 a4_1 va7_1 a1_1
degree : 26
Alias :None
Color : null
Priority : 0
------
a7_1:
AdjList :  a6_1 va2_1 t_3 va3_1 t_1 a5_1 a10_1 t_2 va5_1 t_5 t_4 va1_1 vsp_1 vzero_1 va0_1 a9_1 a8_1 a2_1 a4_1 a3_1 va4_1 a1_1
degree : 17
Alias :None
Color : null
Priority : 0
------
a3_1:
AdjList :  a6_1 t_1 a5_1 a10_1 va1_1 vsp_1 vzero_1 va0_1 a9_1 a8_1 a7_1 a2_1 a4_1 a1_1
degree : 11
Alias :None
Color : null
Priority : 0
------
a6_1:
AdjList :  va2_1 t_3 va3_1 t_1 a5_1 a10_1 t_2 t_4 va1_1 vsp_1 vzero_1 va0_1 a9_1 a8_1 a7_1 a2_1 a4_1 a3_1 va4_1 a1_1
degree : 15
Alias :None
Color : null
Priority : 0
------
t_3:
AdjList :  a9_1 a8_1 a6_1 a7_1 a5_1 a10_1 vsp_1 vzero_1
degree : 7
Alias :None
Color : null
Priority : 0
------
a5_1:
AdjList :  a6_1 va2_1 t_3 va3_1 t_1 a10_1 t_2 va1_1 vsp_1 vzero_1 va0_1 a9_1 a8_1 a7_1 a2_1 a4_1 a3_1 a1_1
degree : 13
Alias :None
Color : null
Priority : 0
------
a10_1:
AdjList :  t_8 t_1 t_2 va1_1 vzero_1 a9_1 a7_1 va6_1 a3_1 va4_1 a6_1 va2_1 t_3 va3_1 a5_1 va5_1 t_5 t_4 t_6 vsp_1 va0_1 a8_1 t_7 a2_1 a4_1 va7_1 a1_1
degree : 22
Alias :None
Color : null
Priority : 0
------
t_5:
AdjList :  a9_1 a8_1 a7_1 a10_1 vsp_1 vzero_1
degree : 4
Alias :None
Color : null
Priority : 0
------
t_4:
AdjList :  a9_1 a8_1 a6_1 a7_1 a10_1 vsp_1 vzero_1
degree : 5
Alias :None
Color : null
Priority : 0
------
t_6:
AdjList :  a9_1 a8_1 a10_1 vsp_1 vzero_1
degree : 3
Alias :None
Color : null
Priority : 0
------
a8_1:
AdjList :  a6_1 va2_1 t_3 va3_1 t_1 a5_1 a10_1 t_2 va5_1 t_5 t_4 va1_1 t_6 vsp_1 vzero_1 va0_1 a9_1 a7_1 va6_1 a2_1 a4_1 a3_1 va4_1 a1_1
degree : 19
Alias :None
Color : null
Priority : 0
------
t_9:
AdjList :  vsp_1 vzero_1
degree : 2
Alias :None
Color : null
Priority : 0
------
t_7:
AdjList :  a9_1 a10_1 vsp_1 vzero_1
degree : 3
Alias :None
Color : null
Priority : 0
------
a2_1:
AdjList :  a9_1 a8_1 a6_1 a7_1 a5_1 a10_1 a4_1 a3_1 vsp_1 a1_1 vzero_1 va0_1
degree : 10
Alias :None
Color : null
Priority : 0
------
a4_1:
AdjList :  a6_1 va2_1 t_1 a5_1 a10_1 t_2 va1_1 vsp_1 vzero_1 va0_1 a9_1 a8_1 a7_1 a2_1 a3_1 a1_1
degree : 12
Alias :None
Color : null
Priority : 0
------
a1_1:
AdjList :  a9_1 a8_1 a6_1 a7_1 a5_1 a10_1 a2_1 a4_1 a3_1 vsp_1 vzero_1
degree : 9
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
a3_1 = move va2_1
a8_1 = move va7_1
a1_1 = move va0_1
a7_1 = move va6_1
t_10 = move t_9
a6_1 = move va5_1
a4_1 = move va3_1
a2_1 = move va1_1
a5_1 = move va4_1
------
active moves:
========func Node List Info ========
simplify Nodes(low degree non move related):
t_5(0) t_4(0) t_6(0) 
------
freeze Nodes(low degree move related):
a6_1(0) a8_1(0) a7_1(0) t_9(0) a5_1(0) a2_1(0) a4_1(0) a3_1(0) t_10(0) a1_1(0) 
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
a9_1(0) t_8(0) t_3(0) t_1(0) t_7(0) a10_1(0) t_2(0) 
------

===================== Simplify =====================
========func Graph Info ========
t_8:
AdjList :  a10_1 vsp_1 vzero_1
degree : 3
Alias :None
Color : null
Priority : 0
------
t_1:
AdjList :  a9_1 a8_1 a6_1 a7_1 a5_1 a10_1 a4_1 a3_1 vsp_1 vzero_1
degree : 9
Alias :None
Color : null
Priority : 0
------
t_2:
AdjList :  a9_1 a8_1 a6_1 a7_1 a5_1 a10_1 a4_1 vsp_1 vzero_1
degree : 7
Alias :None
Color : null
Priority : 0
------
t_10:
AdjList :  vsp_1 vzero_1
degree : 2
Alias :None
Color : null
Priority : 0
------
a9_1:
AdjList :  t_1 t_2 va1_1 vzero_1 a7_1 va6_1 a3_1 va4_1 a6_1 va2_1 t_3 va3_1 a5_1 a10_1 va5_1 t_5 t_4 t_6 vsp_1 va0_1 a8_1 t_7 a2_1 a4_1 va7_1 a1_1
degree : 26
Alias :None
Color : null
Priority : 0
------
a7_1:
AdjList :  a6_1 va2_1 t_3 va3_1 t_1 a5_1 a10_1 t_2 va5_1 t_5 t_4 va1_1 vsp_1 vzero_1 va0_1 a9_1 a8_1 a2_1 a4_1 a3_1 va4_1 a1_1
degree : 16
Alias :None
Color : null
Priority : 0
------
a3_1:
AdjList :  a6_1 t_1 a5_1 a10_1 va1_1 vsp_1 vzero_1 va0_1 a9_1 a8_1 a7_1 a2_1 a4_1 a1_1
degree : 11
Alias :None
Color : null
Priority : 0
------
a6_1:
AdjList :  va2_1 t_3 va3_1 t_1 a5_1 a10_1 t_2 t_4 va1_1 vsp_1 vzero_1 va0_1 a9_1 a8_1 a7_1 a2_1 a4_1 a3_1 va4_1 a1_1
degree : 15
Alias :None
Color : null
Priority : 0
------
t_3:
AdjList :  a9_1 a8_1 a6_1 a7_1 a5_1 a10_1 vsp_1 vzero_1
degree : 7
Alias :None
Color : null
Priority : 0
------
a5_1:
AdjList :  a6_1 va2_1 t_3 va3_1 t_1 a10_1 t_2 va1_1 vsp_1 vzero_1 va0_1 a9_1 a8_1 a7_1 a2_1 a4_1 a3_1 a1_1
degree : 13
Alias :None
Color : null
Priority : 0
------
a10_1:
AdjList :  t_8 t_1 t_2 va1_1 vzero_1 a9_1 a7_1 va6_1 a3_1 va4_1 a6_1 va2_1 t_3 va3_1 a5_1 va5_1 t_5 t_4 t_6 vsp_1 va0_1 a8_1 t_7 a2_1 a4_1 va7_1 a1_1
degree : 22
Alias :None
Color : null
Priority : 0
------
t_5:
AdjList :  a9_1 a8_1 a7_1 a10_1 vsp_1 vzero_1
degree : 4
Alias :None
Color : null
Priority : 0
------
t_4:
AdjList :  a9_1 a8_1 a6_1 a7_1 a10_1 vsp_1 vzero_1
degree : 5
Alias :None
Color : null
Priority : 0
------
t_6:
AdjList :  a9_1 a8_1 a10_1 vsp_1 vzero_1
degree : 3
Alias :None
Color : null
Priority : 0
------
a8_1:
AdjList :  a6_1 va2_1 t_3 va3_1 t_1 a5_1 a10_1 t_2 va5_1 t_5 t_4 va1_1 t_6 vsp_1 vzero_1 va0_1 a9_1 a7_1 va6_1 a2_1 a4_1 a3_1 va4_1 a1_1
degree : 18
Alias :None
Color : null
Priority : 0
------
t_9:
AdjList :  vsp_1 vzero_1
degree : 2
Alias :None
Color : null
Priority : 0
------
t_7:
AdjList :  a9_1 a10_1 vsp_1 vzero_1
degree : 3
Alias :None
Color : null
Priority : 0
------
a2_1:
AdjList :  a9_1 a8_1 a6_1 a7_1 a5_1 a10_1 a4_1 a3_1 vsp_1 a1_1 vzero_1 va0_1
degree : 10
Alias :None
Color : null
Priority : 0
------
a4_1:
AdjList :  a6_1 va2_1 t_1 a5_1 a10_1 t_2 va1_1 vsp_1 vzero_1 va0_1 a9_1 a8_1 a7_1 a2_1 a3_1 a1_1
degree : 12
Alias :None
Color : null
Priority : 0
------
a1_1:
AdjList :  a9_1 a8_1 a6_1 a7_1 a5_1 a10_1 a2_1 a4_1 a3_1 vsp_1 vzero_1
degree : 9
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
a3_1 = move va2_1
a8_1 = move va7_1
a1_1 = move va0_1
a7_1 = move va6_1
t_10 = move t_9
a6_1 = move va5_1
a4_1 = move va3_1
a2_1 = move va1_1
a5_1 = move va4_1
------
active moves:
========func Node List Info ========
simplify Nodes(low degree non move related):
t_4(0) t_6(0) 
------
freeze Nodes(low degree move related):
a6_1(0) a8_1(0) a7_1(0) t_9(0) a5_1(0) a2_1(0) a4_1(0) a3_1(0) t_10(0) a1_1(0) 
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
a9_1(0) t_8(0) t_3(0) t_1(0) t_7(0) a10_1(0) t_2(0) t_5(0) 
------

===================== Simplify =====================
========func Graph Info ========
t_8:
AdjList :  a10_1 vsp_1 vzero_1
degree : 3
Alias :None
Color : null
Priority : 0
------
t_1:
AdjList :  a9_1 a8_1 a6_1 a7_1 a5_1 a10_1 a4_1 a3_1 vsp_1 vzero_1
degree : 9
Alias :None
Color : null
Priority : 0
------
t_2:
AdjList :  a9_1 a8_1 a6_1 a7_1 a5_1 a10_1 a4_1 vsp_1 vzero_1
degree : 7
Alias :None
Color : null
Priority : 0
------
t_10:
AdjList :  vsp_1 vzero_1
degree : 2
Alias :None
Color : null
Priority : 0
------
a9_1:
AdjList :  t_1 t_2 va1_1 vzero_1 a7_1 va6_1 a3_1 va4_1 a6_1 va2_1 t_3 va3_1 a5_1 a10_1 va5_1 t_5 t_4 t_6 vsp_1 va0_1 a8_1 t_7 a2_1 a4_1 va7_1 a1_1
degree : 26
Alias :None
Color : null
Priority : 0
------
a7_1:
AdjList :  a6_1 va2_1 t_3 va3_1 t_1 a5_1 a10_1 t_2 va5_1 t_5 t_4 va1_1 vsp_1 vzero_1 va0_1 a9_1 a8_1 a2_1 a4_1 a3_1 va4_1 a1_1
degree : 15
Alias :None
Color : null
Priority : 0
------
a3_1:
AdjList :  a6_1 t_1 a5_1 a10_1 va1_1 vsp_1 vzero_1 va0_1 a9_1 a8_1 a7_1 a2_1 a4_1 a1_1
degree : 11
Alias :None
Color : null
Priority : 0
------
a6_1:
AdjList :  va2_1 t_3 va3_1 t_1 a5_1 a10_1 t_2 t_4 va1_1 vsp_1 vzero_1 va0_1 a9_1 a8_1 a7_1 a2_1 a4_1 a3_1 va4_1 a1_1
degree : 14
Alias :None
Color : null
Priority : 0
------
t_3:
AdjList :  a9_1 a8_1 a6_1 a7_1 a5_1 a10_1 vsp_1 vzero_1
degree : 7
Alias :None
Color : null
Priority : 0
------
a5_1:
AdjList :  a6_1 va2_1 t_3 va3_1 t_1 a10_1 t_2 va1_1 vsp_1 vzero_1 va0_1 a9_1 a8_1 a7_1 a2_1 a4_1 a3_1 a1_1
degree : 13
Alias :None
Color : null
Priority : 0
------
a10_1:
AdjList :  t_8 t_1 t_2 va1_1 vzero_1 a9_1 a7_1 va6_1 a3_1 va4_1 a6_1 va2_1 t_3 va3_1 a5_1 va5_1 t_5 t_4 t_6 vsp_1 va0_1 a8_1 t_7 a2_1 a4_1 va7_1 a1_1
degree : 22
Alias :None
Color : null
Priority : 0
------
t_5:
AdjList :  a9_1 a8_1 a7_1 a10_1 vsp_1 vzero_1
degree : 4
Alias :None
Color : null
Priority : 0
------
t_4:
AdjList :  a9_1 a8_1 a6_1 a7_1 a10_1 vsp_1 vzero_1
degree : 5
Alias :None
Color : null
Priority : 0
------
t_6:
AdjList :  a9_1 a8_1 a10_1 vsp_1 vzero_1
degree : 3
Alias :None
Color : null
Priority : 0
------
a8_1:
AdjList :  a6_1 va2_1 t_3 va3_1 t_1 a5_1 a10_1 t_2 va5_1 t_5 t_4 va1_1 t_6 vsp_1 vzero_1 va0_1 a9_1 a7_1 va6_1 a2_1 a4_1 a3_1 va4_1 a1_1
degree : 17
Alias :None
Color : null
Priority : 0
------
t_9:
AdjList :  vsp_1 vzero_1
degree : 2
Alias :None
Color : null
Priority : 0
------
t_7:
AdjList :  a9_1 a10_1 vsp_1 vzero_1
degree : 3
Alias :None
Color : null
Priority : 0
------
a2_1:
AdjList :  a9_1 a8_1 a6_1 a7_1 a5_1 a10_1 a4_1 a3_1 vsp_1 a1_1 vzero_1 va0_1
degree : 10
Alias :None
Color : null
Priority : 0
------
a4_1:
AdjList :  a6_1 va2_1 t_1 a5_1 a10_1 t_2 va1_1 vsp_1 vzero_1 va0_1 a9_1 a8_1 a7_1 a2_1 a3_1 a1_1
degree : 12
Alias :None
Color : null
Priority : 0
------
a1_1:
AdjList :  a9_1 a8_1 a6_1 a7_1 a5_1 a10_1 a2_1 a4_1 a3_1 vsp_1 vzero_1
degree : 9
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
a3_1 = move va2_1
a8_1 = move va7_1
a1_1 = move va0_1
a7_1 = move va6_1
t_10 = move t_9
a6_1 = move va5_1
a4_1 = move va3_1
a2_1 = move va1_1
a5_1 = move va4_1
------
active moves:
========func Node List Info ========
simplify Nodes(low degree non move related):
t_6(0) 
------
freeze Nodes(low degree move related):
a6_1(0) a8_1(0) a7_1(0) t_9(0) a5_1(0) a2_1(0) a4_1(0) a3_1(0) t_10(0) a1_1(0) 
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
a9_1(0) t_8(0) t_3(0) t_1(0) t_7(0) a10_1(0) t_2(0) t_5(0) t_4(0) 
------

===================== Simplify =====================
========func Graph Info ========
t_8:
AdjList :  a10_1 vsp_1 vzero_1
degree : 3
Alias :None
Color : null
Priority : 0
------
t_1:
AdjList :  a9_1 a8_1 a6_1 a7_1 a5_1 a10_1 a4_1 a3_1 vsp_1 vzero_1
degree : 9
Alias :None
Color : null
Priority : 0
------
t_2:
AdjList :  a9_1 a8_1 a6_1 a7_1 a5_1 a10_1 a4_1 vsp_1 vzero_1
degree : 7
Alias :None
Color : null
Priority : 0
------
t_10:
AdjList :  vsp_1 vzero_1
degree : 2
Alias :None
Color : null
Priority : 0
------
a9_1:
AdjList :  t_1 t_2 va1_1 vzero_1 a7_1 va6_1 a3_1 va4_1 a6_1 va2_1 t_3 va3_1 a5_1 a10_1 va5_1 t_5 t_4 t_6 vsp_1 va0_1 a8_1 t_7 a2_1 a4_1 va7_1 a1_1
degree : 26
Alias :None
Color : null
Priority : 0
------
a7_1:
AdjList :  a6_1 va2_1 t_3 va3_1 t_1 a5_1 a10_1 t_2 va5_1 t_5 t_4 va1_1 vsp_1 vzero_1 va0_1 a9_1 a8_1 a2_1 a4_1 a3_1 va4_1 a1_1
degree : 15
Alias :None
Color : null
Priority : 0
------
a3_1:
AdjList :  a6_1 t_1 a5_1 a10_1 va1_1 vsp_1 vzero_1 va0_1 a9_1 a8_1 a7_1 a2_1 a4_1 a1_1
degree : 11
Alias :None
Color : null
Priority : 0
------
a6_1:
AdjList :  va2_1 t_3 va3_1 t_1 a5_1 a10_1 t_2 t_4 va1_1 vsp_1 vzero_1 va0_1 a9_1 a8_1 a7_1 a2_1 a4_1 a3_1 va4_1 a1_1
degree : 14
Alias :None
Color : null
Priority : 0
------
t_3:
AdjList :  a9_1 a8_1 a6_1 a7_1 a5_1 a10_1 vsp_1 vzero_1
degree : 7
Alias :None
Color : null
Priority : 0
------
a5_1:
AdjList :  a6_1 va2_1 t_3 va3_1 t_1 a10_1 t_2 va1_1 vsp_1 vzero_1 va0_1 a9_1 a8_1 a7_1 a2_1 a4_1 a3_1 a1_1
degree : 13
Alias :None
Color : null
Priority : 0
------
a10_1:
AdjList :  t_8 t_1 t_2 va1_1 vzero_1 a9_1 a7_1 va6_1 a3_1 va4_1 a6_1 va2_1 t_3 va3_1 a5_1 va5_1 t_5 t_4 t_6 vsp_1 va0_1 a8_1 t_7 a2_1 a4_1 va7_1 a1_1
degree : 22
Alias :None
Color : null
Priority : 0
------
t_5:
AdjList :  a9_1 a8_1 a7_1 a10_1 vsp_1 vzero_1
degree : 4
Alias :None
Color : null
Priority : 0
------
t_4:
AdjList :  a9_1 a8_1 a6_1 a7_1 a10_1 vsp_1 vzero_1
degree : 5
Alias :None
Color : null
Priority : 0
------
t_6:
AdjList :  a9_1 a8_1 a10_1 vsp_1 vzero_1
degree : 3
Alias :None
Color : null
Priority : 0
------
a8_1:
AdjList :  a6_1 va2_1 t_3 va3_1 t_1 a5_1 a10_1 t_2 va5_1 t_5 t_4 va1_1 t_6 vsp_1 vzero_1 va0_1 a9_1 a7_1 va6_1 a2_1 a4_1 a3_1 va4_1 a1_1
degree : 16
Alias :None
Color : null
Priority : 0
------
t_9:
AdjList :  vsp_1 vzero_1
degree : 2
Alias :None
Color : null
Priority : 0
------
t_7:
AdjList :  a9_1 a10_1 vsp_1 vzero_1
degree : 3
Alias :None
Color : null
Priority : 0
------
a2_1:
AdjList :  a9_1 a8_1 a6_1 a7_1 a5_1 a10_1 a4_1 a3_1 vsp_1 a1_1 vzero_1 va0_1
degree : 10
Alias :None
Color : null
Priority : 0
------
a4_1:
AdjList :  a6_1 va2_1 t_1 a5_1 a10_1 t_2 va1_1 vsp_1 vzero_1 va0_1 a9_1 a8_1 a7_1 a2_1 a3_1 a1_1
degree : 12
Alias :None
Color : null
Priority : 0
------
a1_1:
AdjList :  a9_1 a8_1 a6_1 a7_1 a5_1 a10_1 a2_1 a4_1 a3_1 vsp_1 vzero_1
degree : 9
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
a3_1 = move va2_1
a8_1 = move va7_1
a1_1 = move va0_1
a7_1 = move va6_1
t_10 = move t_9
a6_1 = move va5_1
a4_1 = move va3_1
a2_1 = move va1_1
a5_1 = move va4_1
------
active moves:
========func Node List Info ========
simplify Nodes(low degree non move related):

------
freeze Nodes(low degree move related):
a6_1(0) a8_1(0) a7_1(0) t_9(0) a5_1(0) a2_1(0) a4_1(0) a3_1(0) t_10(0) a1_1(0) 
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
a9_1(0) t_8(0) t_3(0) t_1(0) t_7(0) a10_1(0) t_2(0) t_5(0) t_4(0) t_6(0) 
------

===================== Coalesce =====================
========func Graph Info ========
t_8:
AdjList :  a10_1 vsp_1 vzero_1
degree : 3
Alias :None
Color : null
Priority : 0
------
t_1:
AdjList :  a9_1 a8_1 a6_1 a7_1 a5_1 a10_1 a4_1 a3_1 vsp_1 vzero_1
degree : 9
Alias :None
Color : null
Priority : 0
------
t_2:
AdjList :  a9_1 a8_1 a6_1 a7_1 a5_1 a10_1 a4_1 vsp_1 vzero_1
degree : 7
Alias :None
Color : null
Priority : 0
------
t_10:
AdjList :  vsp_1 vzero_1
degree : 2
Alias :None
Color : null
Priority : 0
------
a9_1:
AdjList :  t_1 t_2 va1_1 vzero_1 a7_1 va6_1 a3_1 va4_1 a6_1 va2_1 t_3 va3_1 a5_1 a10_1 va5_1 t_5 t_4 t_6 vsp_1 va0_1 a8_1 t_7 a2_1 a4_1 va7_1 a1_1
degree : 26
Alias :None
Color : null
Priority : 0
------
a7_1:
AdjList :  a6_1 va2_1 t_3 va3_1 t_1 a5_1 a10_1 t_2 va5_1 t_5 t_4 va1_1 vsp_1 vzero_1 va0_1 a9_1 a8_1 a2_1 a4_1 a3_1 va4_1 a1_1
degree : 14
Alias :None
Color : null
Priority : 0
------
a3_1:
AdjList :  a6_1 t_1 a5_1 a10_1 va1_1 vsp_1 vzero_1 va0_1 a9_1 a8_1 a7_1 a2_1 a4_1 a1_1
degree : 11
Alias :va2_1
Color : null
Priority : 0
------
a6_1:
AdjList :  va2_1 t_3 va3_1 t_1 a5_1 a10_1 t_2 t_4 va1_1 vsp_1 vzero_1 va0_1 a9_1 a8_1 a7_1 a2_1 a4_1 a3_1 va4_1 a1_1
degree : 13
Alias :None
Color : null
Priority : 0
------
t_3:
AdjList :  a9_1 a8_1 a6_1 a7_1 a5_1 a10_1 vsp_1 vzero_1
degree : 7
Alias :None
Color : null
Priority : 0
------
a5_1:
AdjList :  a6_1 va2_1 t_3 va3_1 t_1 a10_1 t_2 va1_1 vsp_1 vzero_1 va0_1 a9_1 a8_1 a7_1 a2_1 a4_1 a3_1 a1_1
degree : 12
Alias :None
Color : null
Priority : 0
------
a10_1:
AdjList :  t_8 t_1 t_2 va1_1 vzero_1 a9_1 a7_1 va6_1 a3_1 va4_1 a6_1 va2_1 t_3 va3_1 a5_1 va5_1 t_5 t_4 t_6 vsp_1 va0_1 a8_1 t_7 a2_1 a4_1 va7_1 a1_1
degree : 22
Alias :None
Color : null
Priority : 0
------
t_5:
AdjList :  a9_1 a8_1 a7_1 a10_1 vsp_1 vzero_1
degree : 4
Alias :None
Color : null
Priority : 0
------
t_4:
AdjList :  a9_1 a8_1 a6_1 a7_1 a10_1 vsp_1 vzero_1
degree : 5
Alias :None
Color : null
Priority : 0
------
t_6:
AdjList :  a9_1 a8_1 a10_1 vsp_1 vzero_1
degree : 3
Alias :None
Color : null
Priority : 0
------
a8_1:
AdjList :  a6_1 va2_1 t_3 va3_1 t_1 a5_1 a10_1 t_2 va5_1 t_5 t_4 va1_1 t_6 vsp_1 vzero_1 va0_1 a9_1 a7_1 va6_1 a2_1 a4_1 a3_1 va4_1 a1_1
degree : 15
Alias :None
Color : null
Priority : 0
------
t_9:
AdjList :  vsp_1 vzero_1
degree : 2
Alias :None
Color : null
Priority : 0
------
t_7:
AdjList :  a9_1 a10_1 vsp_1 vzero_1
degree : 3
Alias :None
Color : null
Priority : 0
------
a2_1:
AdjList :  a6_1 va2_1 a5_1 a10_1 vsp_1 vzero_1 va0_1 a9_1 a8_1 a7_1 a4_1 a3_1 a1_1
degree : 10
Alias :None
Color : null
Priority : 0
------
a4_1:
AdjList :  a6_1 va2_1 t_1 a5_1 a10_1 t_2 va1_1 vsp_1 vzero_1 va0_1 a9_1 a8_1 a7_1 a2_1 a3_1 a1_1
degree : 11
Alias :None
Color : null
Priority : 0
------
a1_1:
AdjList :  a9_1 a8_1 a6_1 va2_1 a7_1 a5_1 a10_1 a2_1 a4_1 a3_1 vsp_1 vzero_1
degree : 9
Alias :None
Color : null
Priority : 0
------
========func move List Info ========
coalesced moves:
a3_1 = move va2_1
------
constrained moves:
------
fronzen moves:
------
workList moves:
a8_1 = move va7_1
a1_1 = move va0_1
a7_1 = move va6_1
t_10 = move t_9
a6_1 = move va5_1
a4_1 = move va3_1
a2_1 = move va1_1
a5_1 = move va4_1
------
active moves:
========func Node List Info ========
simplify Nodes(low degree non move related):

------
freeze Nodes(low degree move related):
a6_1(0) a8_1(0) a7_1(0) t_9(0) a5_1(0) a2_1(0) a4_1(0) t_10(0) a1_1(0) 
------
spill Nodes(high degree):

------
spilled Nodes:

------
coalesced Nodes:
a3_1(0) 
------
colored Nodes:

------
selected Stack:
a9_1(0) t_8(0) t_3(0) t_1(0) t_7(0) a10_1(0) t_2(0) t_5(0) t_4(0) t_6(0) 
------

===================== Coalesce =====================
========func Graph Info ========
t_8:
AdjList :  a10_1 vsp_1 vzero_1
degree : 3
Alias :None
Color : null
Priority : 0
------
t_1:
AdjList :  a9_1 a8_1 a6_1 a7_1 a5_1 a10_1 a4_1 a3_1 vsp_1 vzero_1
degree : 9
Alias :None
Color : null
Priority : 0
------
t_2:
AdjList :  a9_1 a8_1 a6_1 a7_1 a5_1 a10_1 a4_1 vsp_1 vzero_1
degree : 7
Alias :None
Color : null
Priority : 0
------
t_10:
AdjList :  vsp_1 vzero_1
degree : 2
Alias :None
Color : null
Priority : 0
------
a9_1:
AdjList :  t_1 t_2 va1_1 vzero_1 a7_1 va6_1 a3_1 va4_1 a6_1 va2_1 t_3 va3_1 a5_1 a10_1 va5_1 t_5 t_4 t_6 vsp_1 va0_1 a8_1 t_7 a2_1 a4_1 va7_1 a1_1
degree : 26
Alias :None
Color : null
Priority : 0
------
a7_1:
AdjList :  a6_1 va2_1 t_3 va3_1 t_1 a5_1 a10_1 t_2 va5_1 t_5 t_4 va1_1 vsp_1 vzero_1 va0_1 a9_1 a8_1 a2_1 a4_1 va7_1 a3_1 va4_1 a1_1
degree : 14
Alias :None
Color : null
Priority : 0
------
a3_1:
AdjList :  a6_1 t_1 a5_1 a10_1 va1_1 vsp_1 vzero_1 va0_1 a9_1 a8_1 a7_1 a2_1 a4_1 a1_1
degree : 11
Alias :va2_1
Color : null
Priority : 0
------
a6_1:
AdjList :  va2_1 t_3 va3_1 t_1 a5_1 a10_1 t_2 t_4 va1_1 vsp_1 vzero_1 va0_1 a9_1 a8_1 a7_1 a2_1 a4_1 va7_1 a3_1 va4_1 a1_1
degree : 13
Alias :None
Color : null
Priority : 0
------
t_3:
AdjList :  a9_1 a8_1 a6_1 a7_1 a5_1 a10_1 vsp_1 vzero_1
degree : 7
Alias :None
Color : null
Priority : 0
------
a5_1:
AdjList :  a6_1 va2_1 t_3 va3_1 t_1 a10_1 t_2 va1_1 vsp_1 vzero_1 va0_1 a9_1 a8_1 a7_1 a2_1 a4_1 va7_1 a3_1 a1_1
degree : 12
Alias :None
Color : null
Priority : 0
------
a10_1:
AdjList :  t_8 t_1 t_2 va1_1 vzero_1 a9_1 a7_1 va6_1 a3_1 va4_1 a6_1 va2_1 t_3 va3_1 a5_1 va5_1 t_5 t_4 t_6 vsp_1 va0_1 a8_1 t_7 a2_1 a4_1 va7_1 a1_1
degree : 22
Alias :None
Color : null
Priority : 0
------
t_5:
AdjList :  a9_1 a8_1 a7_1 a10_1 vsp_1 vzero_1
degree : 4
Alias :None
Color : null
Priority : 0
------
t_4:
AdjList :  a9_1 a8_1 a6_1 a7_1 a10_1 vsp_1 vzero_1
degree : 5
Alias :None
Color : null
Priority : 0
------
t_6:
AdjList :  a9_1 a8_1 a10_1 vsp_1 vzero_1
degree : 3
Alias :None
Color : null
Priority : 0
------
a8_1:
AdjList :  a6_1 va2_1 t_3 va3_1 t_1 a5_1 a10_1 t_2 va5_1 t_5 t_4 va1_1 t_6 vsp_1 vzero_1 va0_1 a9_1 a7_1 va6_1 a2_1 a4_1 a3_1 va4_1 a1_1
degree : 15
Alias :va7_1
Color : null
Priority : 0
------
t_9:
AdjList :  vsp_1 vzero_1
degree : 2
Alias :None
Color : null
Priority : 0
------
t_7:
AdjList :  a9_1 a10_1 vsp_1 vzero_1
degree : 3
Alias :None
Color : null
Priority : 0
------
a2_1:
AdjList :  a6_1 va2_1 a5_1 a10_1 vsp_1 vzero_1 va0_1 a9_1 a8_1 a7_1 a4_1 va7_1 a3_1 a1_1
degree : 10
Alias :None
Color : null
Priority : 0
------
a4_1:
AdjList :  a6_1 va2_1 t_1 a5_1 a10_1 t_2 va1_1 vsp_1 vzero_1 va0_1 a9_1 a8_1 a7_1 a2_1 va7_1 a3_1 a1_1
degree : 11
Alias :None
Color : null
Priority : 0
------
a1_1:
AdjList :  a6_1 va2_1 a5_1 a10_1 vsp_1 vzero_1 a9_1 a8_1 a7_1 a2_1 a4_1 va7_1 a3_1
degree : 9
Alias :None
Color : null
Priority : 0
------
========func move List Info ========
coalesced moves:
a3_1 = move va2_1
a8_1 = move va7_1
------
constrained moves:
------
fronzen moves:
------
workList moves:
a1_1 = move va0_1
a7_1 = move va6_1
t_10 = move t_9
a6_1 = move va5_1
a4_1 = move va3_1
a2_1 = move va1_1
a5_1 = move va4_1
------
active moves:
========func Node List Info ========
simplify Nodes(low degree non move related):

------
freeze Nodes(low degree move related):
a6_1(0) a7_1(0) t_9(0) a5_1(0) a2_1(0) a4_1(0) t_10(0) a1_1(0) 
------
spill Nodes(high degree):

------
spilled Nodes:

------
coalesced Nodes:
a8_1(0) a3_1(0) 
------
colored Nodes:

------
selected Stack:
a9_1(0) t_8(0) t_3(0) t_1(0) t_7(0) a10_1(0) t_2(0) t_5(0) t_4(0) t_6(0) 
------

===================== Coalesce =====================
========func Graph Info ========
t_8:
AdjList :  a10_1 vsp_1 vzero_1
degree : 3
Alias :None
Color : null
Priority : 0
------
t_1:
AdjList :  a9_1 a8_1 a6_1 a7_1 a5_1 a10_1 a4_1 a3_1 vsp_1 vzero_1
degree : 9
Alias :None
Color : null
Priority : 0
------
t_2:
AdjList :  a9_1 a8_1 a6_1 a7_1 a5_1 a10_1 a4_1 vsp_1 vzero_1
degree : 7
Alias :None
Color : null
Priority : 0
------
t_10:
AdjList :  vsp_1 vzero_1
degree : 2
Alias :None
Color : null
Priority : 0
------
a9_1:
AdjList :  t_1 t_2 va1_1 vzero_1 a7_1 va6_1 a3_1 va4_1 a6_1 va2_1 t_3 va3_1 a5_1 a10_1 va5_1 t_5 t_4 t_6 vsp_1 va0_1 a8_1 t_7 a2_1 a4_1 va7_1 a1_1
degree : 26
Alias :None
Color : null
Priority : 0
------
a7_1:
AdjList :  a6_1 va2_1 t_3 va3_1 t_1 a5_1 a10_1 t_2 va5_1 t_5 t_4 va1_1 vsp_1 vzero_1 va0_1 a9_1 a8_1 a2_1 a4_1 va7_1 a3_1 va4_1 a1_1
degree : 13
Alias :None
Color : null
Priority : 0
------
a3_1:
AdjList :  a6_1 t_1 a5_1 a10_1 va1_1 vsp_1 vzero_1 va0_1 a9_1 a8_1 a7_1 a2_1 a4_1 a1_1
degree : 11
Alias :va2_1
Color : null
Priority : 0
------
a6_1:
AdjList :  va2_1 t_3 va3_1 t_1 a5_1 a10_1 t_2 t_4 va1_1 vsp_1 vzero_1 va0_1 a9_1 a8_1 a7_1 a2_1 a4_1 va7_1 a3_1 va4_1 a1_1
degree : 12
Alias :None
Color : null
Priority : 0
------
t_3:
AdjList :  a9_1 a8_1 a6_1 a7_1 a5_1 a10_1 vsp_1 vzero_1
degree : 7
Alias :None
Color : null
Priority : 0
------
a5_1:
AdjList :  a6_1 va2_1 t_3 va3_1 t_1 a10_1 t_2 va1_1 vsp_1 vzero_1 va0_1 a9_1 a8_1 a7_1 a2_1 a4_1 va7_1 a3_1 a1_1
degree : 11
Alias :None
Color : null
Priority : 0
------
a10_1:
AdjList :  t_8 t_1 t_2 va1_1 vzero_1 a9_1 a7_1 va6_1 a3_1 va4_1 a6_1 va2_1 t_3 va3_1 a5_1 va5_1 t_5 t_4 t_6 vsp_1 va0_1 a8_1 t_7 a2_1 a4_1 va7_1 a1_1
degree : 22
Alias :None
Color : null
Priority : 0
------
t_5:
AdjList :  a9_1 a8_1 a7_1 a10_1 vsp_1 vzero_1
degree : 4
Alias :None
Color : null
Priority : 0
------
t_4:
AdjList :  a9_1 a8_1 a6_1 a7_1 a10_1 vsp_1 vzero_1
degree : 5
Alias :None
Color : null
Priority : 0
------
t_6:
AdjList :  a9_1 a8_1 a10_1 vsp_1 vzero_1
degree : 3
Alias :None
Color : null
Priority : 0
------
a8_1:
AdjList :  a6_1 va2_1 t_3 va3_1 t_1 a5_1 a10_1 t_2 va5_1 t_5 t_4 va1_1 t_6 vsp_1 vzero_1 va0_1 a9_1 a7_1 va6_1 a2_1 a4_1 a3_1 va4_1 a1_1
degree : 15
Alias :va7_1
Color : null
Priority : 0
------
t_9:
AdjList :  vsp_1 vzero_1
degree : 2
Alias :None
Color : null
Priority : 0
------
t_7:
AdjList :  a9_1 a10_1 vsp_1 vzero_1
degree : 3
Alias :None
Color : null
Priority : 0
------
a2_1:
AdjList :  a6_1 va2_1 a5_1 a10_1 vsp_1 vzero_1 va0_1 a9_1 a8_1 a7_1 a4_1 va7_1 a3_1 a1_1
degree : 9
Alias :None
Color : null
Priority : 0
------
a4_1:
AdjList :  a6_1 va2_1 t_1 a5_1 a10_1 t_2 va1_1 vsp_1 vzero_1 va0_1 a9_1 a8_1 a7_1 a2_1 va7_1 a3_1 a1_1
degree : 10
Alias :None
Color : null
Priority : 0
------
a1_1:
AdjList :  a6_1 va2_1 a5_1 a10_1 vsp_1 vzero_1 a9_1 a8_1 a7_1 a2_1 a4_1 va7_1 a3_1
degree : 9
Alias :va0_1
Color : null
Priority : 0
------
========func move List Info ========
coalesced moves:
a3_1 = move va2_1
a8_1 = move va7_1
a1_1 = move va0_1
------
constrained moves:
------
fronzen moves:
------
workList moves:
a7_1 = move va6_1
t_10 = move t_9
a6_1 = move va5_1
a4_1 = move va3_1
a2_1 = move va1_1
a5_1 = move va4_1
------
active moves:
========func Node List Info ========
simplify Nodes(low degree non move related):

------
freeze Nodes(low degree move related):
a6_1(0) a7_1(0) t_9(0) a5_1(0) a2_1(0) a4_1(0) t_10(0) 
------
spill Nodes(high degree):

------
spilled Nodes:

------
coalesced Nodes:
a8_1(0) a3_1(0) a1_1(0) 
------
colored Nodes:

------
selected Stack:
a9_1(0) t_8(0) t_3(0) t_1(0) t_7(0) a10_1(0) t_2(0) t_5(0) t_4(0) t_6(0) 
------

===================== Coalesce =====================
========func Graph Info ========
t_8:
AdjList :  a10_1 vsp_1 vzero_1
degree : 3
Alias :None
Color : null
Priority : 0
------
t_1:
AdjList :  a9_1 a8_1 a6_1 a7_1 a5_1 a10_1 a4_1 a3_1 vsp_1 vzero_1
degree : 9
Alias :None
Color : null
Priority : 0
------
t_2:
AdjList :  a9_1 a8_1 a6_1 a7_1 a5_1 a10_1 a4_1 vsp_1 vzero_1
degree : 7
Alias :None
Color : null
Priority : 0
------
t_10:
AdjList :  vsp_1 vzero_1
degree : 2
Alias :None
Color : null
Priority : 0
------
a9_1:
AdjList :  t_1 t_2 va1_1 vzero_1 a7_1 va6_1 a3_1 va4_1 a6_1 va2_1 t_3 va3_1 a5_1 a10_1 va5_1 t_5 t_4 t_6 vsp_1 va0_1 a8_1 t_7 a2_1 a4_1 va7_1 a1_1
degree : 26
Alias :None
Color : null
Priority : 0
------
a7_1:
AdjList :  a6_1 va2_1 t_3 va3_1 t_1 a5_1 a10_1 t_2 va5_1 t_5 t_4 va1_1 vsp_1 vzero_1 va0_1 a9_1 a8_1 a2_1 a4_1 va7_1 a3_1 va4_1 a1_1
degree : 13
Alias :va6_1
Color : null
Priority : 0
------
a3_1:
AdjList :  a6_1 t_1 a5_1 a10_1 va1_1 vsp_1 vzero_1 va0_1 a9_1 a8_1 a7_1 a2_1 a4_1 a1_1
degree : 11
Alias :va2_1
Color : null
Priority : 0
------
a6_1:
AdjList :  va2_1 t_3 va3_1 t_1 a5_1 a10_1 t_2 t_4 va1_1 vsp_1 vzero_1 va0_1 a9_1 a8_1 a7_1 va6_1 a2_1 a4_1 va7_1 a3_1 va4_1 a1_1
degree : 12
Alias :None
Color : null
Priority : 0
------
t_3:
AdjList :  a9_1 a8_1 a6_1 a7_1 a5_1 a10_1 vsp_1 vzero_1
degree : 7
Alias :None
Color : null
Priority : 0
------
a5_1:
AdjList :  a6_1 va2_1 t_3 va3_1 t_1 a10_1 t_2 va1_1 vsp_1 vzero_1 va0_1 a9_1 a8_1 a7_1 va6_1 a2_1 a4_1 va7_1 a3_1 a1_1
degree : 11
Alias :None
Color : null
Priority : 0
------
a10_1:
AdjList :  t_8 t_1 t_2 va1_1 vzero_1 a9_1 a7_1 va6_1 a3_1 va4_1 a6_1 va2_1 t_3 va3_1 a5_1 va5_1 t_5 t_4 t_6 vsp_1 va0_1 a8_1 t_7 a2_1 a4_1 va7_1 a1_1
degree : 22
Alias :None
Color : null
Priority : 0
------
t_5:
AdjList :  a9_1 a8_1 a7_1 a10_1 vsp_1 vzero_1
degree : 4
Alias :None
Color : null
Priority : 0
------
t_4:
AdjList :  a9_1 a8_1 a6_1 a7_1 a10_1 vsp_1 vzero_1
degree : 5
Alias :None
Color : null
Priority : 0
------
t_6:
AdjList :  a9_1 a8_1 a10_1 vsp_1 vzero_1
degree : 3
Alias :None
Color : null
Priority : 0
------
a8_1:
AdjList :  a6_1 va2_1 t_3 va3_1 t_1 a5_1 a10_1 t_2 va5_1 t_5 t_4 va1_1 t_6 vsp_1 vzero_1 va0_1 a9_1 a7_1 va6_1 a2_1 a4_1 a3_1 va4_1 a1_1
degree : 15
Alias :va7_1
Color : null
Priority : 0
------
t_9:
AdjList :  vsp_1 vzero_1
degree : 2
Alias :None
Color : null
Priority : 0
------
t_7:
AdjList :  a9_1 a10_1 vsp_1 vzero_1
degree : 3
Alias :None
Color : null
Priority : 0
------
a2_1:
AdjList :  a6_1 va2_1 a5_1 a10_1 vsp_1 vzero_1 va0_1 a9_1 a8_1 a7_1 va6_1 a4_1 va7_1 a3_1 a1_1
degree : 9
Alias :None
Color : null
Priority : 0
------
a4_1:
AdjList :  a6_1 va2_1 t_1 a5_1 a10_1 t_2 va1_1 vsp_1 vzero_1 va0_1 a9_1 a8_1 a7_1 va6_1 a2_1 va7_1 a3_1 a1_1
degree : 10
Alias :None
Color : null
Priority : 0
------
a1_1:
AdjList :  a6_1 va2_1 a5_1 a10_1 vsp_1 vzero_1 a9_1 a8_1 a7_1 a2_1 a4_1 va7_1 a3_1
degree : 9
Alias :va0_1
Color : null
Priority : 0
------
========func move List Info ========
coalesced moves:
a3_1 = move va2_1
a8_1 = move va7_1
a1_1 = move va0_1
a7_1 = move va6_1
------
constrained moves:
------
fronzen moves:
------
workList moves:
t_10 = move t_9
a6_1 = move va5_1
a4_1 = move va3_1
a2_1 = move va1_1
a5_1 = move va4_1
------
active moves:
========func Node List Info ========
simplify Nodes(low degree non move related):

------
freeze Nodes(low degree move related):
a6_1(0) t_9(0) a5_1(0) a2_1(0) a4_1(0) t_10(0) 
------
spill Nodes(high degree):

------
spilled Nodes:

------
coalesced Nodes:
a8_1(0) a7_1(0) a3_1(0) a1_1(0) 
------
colored Nodes:

------
selected Stack:
a9_1(0) t_8(0) t_3(0) t_1(0) t_7(0) a10_1(0) t_2(0) t_5(0) t_4(0) t_6(0) 
------

===================== Coalesce =====================
========func Graph Info ========
t_8:
AdjList :  a10_1 vsp_1 vzero_1
degree : 3
Alias :None
Color : null
Priority : 0
------
t_1:
AdjList :  a9_1 a8_1 a6_1 a7_1 a5_1 a10_1 a4_1 a3_1 vsp_1 vzero_1
degree : 9
Alias :None
Color : null
Priority : 0
------
t_2:
AdjList :  a9_1 a8_1 a6_1 a7_1 a5_1 a10_1 a4_1 vsp_1 vzero_1
degree : 7
Alias :None
Color : null
Priority : 0
------
t_10:
AdjList :  vsp_1 vzero_1
degree : 2
Alias :None
Color : null
Priority : 0
------
a9_1:
AdjList :  t_1 t_2 va1_1 vzero_1 a7_1 va6_1 a3_1 va4_1 a6_1 va2_1 t_3 va3_1 a5_1 a10_1 va5_1 t_5 t_4 t_6 vsp_1 va0_1 a8_1 t_7 a2_1 a4_1 va7_1 a1_1
degree : 26
Alias :None
Color : null
Priority : 0
------
a7_1:
AdjList :  a6_1 va2_1 t_3 va3_1 t_1 a5_1 a10_1 t_2 va5_1 t_5 t_4 va1_1 vsp_1 vzero_1 va0_1 a9_1 a8_1 a2_1 a4_1 va7_1 a3_1 va4_1 a1_1
degree : 13
Alias :va6_1
Color : null
Priority : 0
------
a3_1:
AdjList :  a6_1 t_1 a5_1 a10_1 va1_1 vsp_1 vzero_1 va0_1 a9_1 a8_1 a7_1 a2_1 a4_1 a1_1
degree : 11
Alias :va2_1
Color : null
Priority : 0
------
a6_1:
AdjList :  va2_1 t_3 va3_1 t_1 a5_1 a10_1 t_2 t_4 va1_1 vsp_1 vzero_1 va0_1 a9_1 a8_1 a7_1 va6_1 a2_1 a4_1 va7_1 a3_1 va4_1 a1_1
degree : 12
Alias :None
Color : null
Priority : 0
------
t_3:
AdjList :  a9_1 a8_1 a6_1 a7_1 a5_1 a10_1 vsp_1 vzero_1
degree : 7
Alias :None
Color : null
Priority : 0
------
a5_1:
AdjList :  a6_1 va2_1 t_3 va3_1 t_1 a10_1 t_2 va1_1 vsp_1 vzero_1 va0_1 a9_1 a8_1 a7_1 va6_1 a2_1 a4_1 va7_1 a3_1 a1_1
degree : 11
Alias :None
Color : null
Priority : 0
------
a10_1:
AdjList :  t_8 t_1 t_2 va1_1 vzero_1 a9_1 a7_1 va6_1 a3_1 va4_1 a6_1 va2_1 t_3 va3_1 a5_1 va5_1 t_5 t_4 t_6 vsp_1 va0_1 a8_1 t_7 a2_1 a4_1 va7_1 a1_1
degree : 22
Alias :None
Color : null
Priority : 0
------
t_5:
AdjList :  a9_1 a8_1 a7_1 a10_1 vsp_1 vzero_1
degree : 4
Alias :None
Color : null
Priority : 0
------
t_4:
AdjList :  a9_1 a8_1 a6_1 a7_1 a10_1 vsp_1 vzero_1
degree : 5
Alias :None
Color : null
Priority : 0
------
t_6:
AdjList :  a9_1 a8_1 a10_1 vsp_1 vzero_1
degree : 3
Alias :None
Color : null
Priority : 0
------
a8_1:
AdjList :  a6_1 va2_1 t_3 va3_1 t_1 a5_1 a10_1 t_2 va5_1 t_5 t_4 va1_1 t_6 vsp_1 vzero_1 va0_1 a9_1 a7_1 va6_1 a2_1 a4_1 a3_1 va4_1 a1_1
degree : 15
Alias :va7_1
Color : null
Priority : 0
------
t_9:
AdjList :  vsp_1 vzero_1
degree : 2
Alias :t_10
Color : null
Priority : 0
------
t_7:
AdjList :  a9_1 a10_1 vsp_1 vzero_1
degree : 3
Alias :None
Color : null
Priority : 0
------
a2_1:
AdjList :  a6_1 va2_1 a5_1 a10_1 vsp_1 vzero_1 va0_1 a9_1 a8_1 a7_1 va6_1 a4_1 va7_1 a3_1 a1_1
degree : 9
Alias :None
Color : null
Priority : 0
------
a4_1:
AdjList :  a6_1 va2_1 t_1 a5_1 a10_1 t_2 va1_1 vsp_1 vzero_1 va0_1 a9_1 a8_1 a7_1 va6_1 a2_1 va7_1 a3_1 a1_1
degree : 10
Alias :None
Color : null
Priority : 0
------
a1_1:
AdjList :  a6_1 va2_1 a5_1 a10_1 vsp_1 vzero_1 a9_1 a8_1 a7_1 a2_1 a4_1 va7_1 a3_1
degree : 9
Alias :va0_1
Color : null
Priority : 0
------
========func move List Info ========
coalesced moves:
a3_1 = move va2_1
a8_1 = move va7_1
a1_1 = move va0_1
a7_1 = move va6_1
t_10 = move t_9
------
constrained moves:
------
fronzen moves:
------
workList moves:
a6_1 = move va5_1
a4_1 = move va3_1
a2_1 = move va1_1
a5_1 = move va4_1
------
active moves:
========func Node List Info ========
simplify Nodes(low degree non move related):
t_10(0) 
------
freeze Nodes(low degree move related):
a6_1(0) a5_1(0) a2_1(0) a4_1(0) 
------
spill Nodes(high degree):

------
spilled Nodes:

------
coalesced Nodes:
a8_1(0) a7_1(0) t_9(0) a3_1(0) a1_1(0) 
------
colored Nodes:

------
selected Stack:
a9_1(0) t_8(0) t_3(0) t_1(0) t_7(0) a10_1(0) t_2(0) t_5(0) t_4(0) t_6(0) 
------

===================== Simplify =====================
========func Graph Info ========
t_8:
AdjList :  a10_1 vsp_1 vzero_1
degree : 3
Alias :None
Color : null
Priority : 0
------
t_1:
AdjList :  a9_1 a8_1 a6_1 a7_1 a5_1 a10_1 a4_1 a3_1 vsp_1 vzero_1
degree : 9
Alias :None
Color : null
Priority : 0
------
t_2:
AdjList :  a9_1 a8_1 a6_1 a7_1 a5_1 a10_1 a4_1 vsp_1 vzero_1
degree : 7
Alias :None
Color : null
Priority : 0
------
t_10:
AdjList :  vsp_1 vzero_1
degree : 2
Alias :None
Color : null
Priority : 0
------
a9_1:
AdjList :  t_1 t_2 va1_1 vzero_1 a7_1 va6_1 a3_1 va4_1 a6_1 va2_1 t_3 va3_1 a5_1 a10_1 va5_1 t_5 t_4 t_6 vsp_1 va0_1 a8_1 t_7 a2_1 a4_1 va7_1 a1_1
degree : 26
Alias :None
Color : null
Priority : 0
------
a7_1:
AdjList :  a6_1 va2_1 t_3 va3_1 t_1 a5_1 a10_1 t_2 va5_1 t_5 t_4 va1_1 vsp_1 vzero_1 va0_1 a9_1 a8_1 a2_1 a4_1 va7_1 a3_1 va4_1 a1_1
degree : 13
Alias :va6_1
Color : null
Priority : 0
------
a3_1:
AdjList :  a6_1 t_1 a5_1 a10_1 va1_1 vsp_1 vzero_1 va0_1 a9_1 a8_1 a7_1 a2_1 a4_1 a1_1
degree : 11
Alias :va2_1
Color : null
Priority : 0
------
a6_1:
AdjList :  va2_1 t_3 va3_1 t_1 a5_1 a10_1 t_2 t_4 va1_1 vsp_1 vzero_1 va0_1 a9_1 a8_1 a7_1 va6_1 a2_1 a4_1 va7_1 a3_1 va4_1 a1_1
degree : 12
Alias :None
Color : null
Priority : 0
------
t_3:
AdjList :  a9_1 a8_1 a6_1 a7_1 a5_1 a10_1 vsp_1 vzero_1
degree : 7
Alias :None
Color : null
Priority : 0
------
a5_1:
AdjList :  a6_1 va2_1 t_3 va3_1 t_1 a10_1 t_2 va1_1 vsp_1 vzero_1 va0_1 a9_1 a8_1 a7_1 va6_1 a2_1 a4_1 va7_1 a3_1 a1_1
degree : 11
Alias :None
Color : null
Priority : 0
------
a10_1:
AdjList :  t_8 t_1 t_2 va1_1 vzero_1 a9_1 a7_1 va6_1 a3_1 va4_1 a6_1 va2_1 t_3 va3_1 a5_1 va5_1 t_5 t_4 t_6 vsp_1 va0_1 a8_1 t_7 a2_1 a4_1 va7_1 a1_1
degree : 22
Alias :None
Color : null
Priority : 0
------
t_5:
AdjList :  a9_1 a8_1 a7_1 a10_1 vsp_1 vzero_1
degree : 4
Alias :None
Color : null
Priority : 0
------
t_4:
AdjList :  a9_1 a8_1 a6_1 a7_1 a10_1 vsp_1 vzero_1
degree : 5
Alias :None
Color : null
Priority : 0
------
t_6:
AdjList :  a9_1 a8_1 a10_1 vsp_1 vzero_1
degree : 3
Alias :None
Color : null
Priority : 0
------
a8_1:
AdjList :  a6_1 va2_1 t_3 va3_1 t_1 a5_1 a10_1 t_2 va5_1 t_5 t_4 va1_1 t_6 vsp_1 vzero_1 va0_1 a9_1 a7_1 va6_1 a2_1 a4_1 a3_1 va4_1 a1_1
degree : 15
Alias :va7_1
Color : null
Priority : 0
------
t_9:
AdjList :  vsp_1 vzero_1
degree : 2
Alias :t_10
Color : null
Priority : 0
------
t_7:
AdjList :  a9_1 a10_1 vsp_1 vzero_1
degree : 3
Alias :None
Color : null
Priority : 0
------
a2_1:
AdjList :  a6_1 va2_1 a5_1 a10_1 vsp_1 vzero_1 va0_1 a9_1 a8_1 a7_1 va6_1 a4_1 va7_1 a3_1 a1_1
degree : 9
Alias :None
Color : null
Priority : 0
------
a4_1:
AdjList :  a6_1 va2_1 t_1 a5_1 a10_1 t_2 va1_1 vsp_1 vzero_1 va0_1 a9_1 a8_1 a7_1 va6_1 a2_1 va7_1 a3_1 a1_1
degree : 10
Alias :None
Color : null
Priority : 0
------
a1_1:
AdjList :  a6_1 va2_1 a5_1 a10_1 vsp_1 vzero_1 a9_1 a8_1 a7_1 a2_1 a4_1 va7_1 a3_1
degree : 9
Alias :va0_1
Color : null
Priority : 0
------
========func move List Info ========
coalesced moves:
a3_1 = move va2_1
a8_1 = move va7_1
a1_1 = move va0_1
a7_1 = move va6_1
t_10 = move t_9
------
constrained moves:
------
fronzen moves:
------
workList moves:
a6_1 = move va5_1
a4_1 = move va3_1
a2_1 = move va1_1
a5_1 = move va4_1
------
active moves:
========func Node List Info ========
simplify Nodes(low degree non move related):

------
freeze Nodes(low degree move related):
a6_1(0) a5_1(0) a2_1(0) a4_1(0) 
------
spill Nodes(high degree):

------
spilled Nodes:

------
coalesced Nodes:
a8_1(0) a7_1(0) t_9(0) a3_1(0) a1_1(0) 
------
colored Nodes:

------
selected Stack:
a9_1(0) t_8(0) t_3(0) t_1(0) t_7(0) a10_1(0) t_2(0) t_5(0) t_4(0) t_6(0) t_10(0) 
------

===================== Coalesce =====================
========func Graph Info ========
t_8:
AdjList :  a10_1 vsp_1 vzero_1
degree : 3
Alias :None
Color : null
Priority : 0
------
t_1:
AdjList :  a9_1 a8_1 a6_1 a7_1 a5_1 a10_1 a4_1 a3_1 vsp_1 vzero_1
degree : 9
Alias :None
Color : null
Priority : 0
------
t_2:
AdjList :  a9_1 a8_1 a6_1 a7_1 a5_1 a10_1 a4_1 vsp_1 vzero_1
degree : 7
Alias :None
Color : null
Priority : 0
------
t_10:
AdjList :  vsp_1 vzero_1
degree : 2
Alias :None
Color : null
Priority : 0
------
a9_1:
AdjList :  t_1 t_2 va1_1 vzero_1 a7_1 va6_1 a3_1 va4_1 a6_1 va2_1 t_3 va3_1 a5_1 a10_1 va5_1 t_5 t_4 t_6 vsp_1 va0_1 a8_1 t_7 a2_1 a4_1 va7_1 a1_1
degree : 26
Alias :None
Color : null
Priority : 0
------
a7_1:
AdjList :  a6_1 va2_1 t_3 va3_1 t_1 a5_1 a10_1 t_2 va5_1 t_5 t_4 va1_1 vsp_1 vzero_1 va0_1 a9_1 a8_1 a2_1 a4_1 va7_1 a3_1 va4_1 a1_1
degree : 13
Alias :va6_1
Color : null
Priority : 0
------
a3_1:
AdjList :  a6_1 t_1 a5_1 a10_1 va1_1 vsp_1 vzero_1 va0_1 a9_1 a8_1 a7_1 a2_1 a4_1 a1_1
degree : 11
Alias :va2_1
Color : null
Priority : 0
------
a6_1:
AdjList :  va2_1 t_3 va3_1 t_1 a5_1 a10_1 t_2 t_4 va1_1 vsp_1 vzero_1 va0_1 a9_1 a8_1 a7_1 va6_1 a2_1 a4_1 va7_1 a3_1 va4_1 a1_1
degree : 12
Alias :va5_1
Color : null
Priority : 0
------
t_3:
AdjList :  a9_1 a8_1 a6_1 a7_1 a5_1 a10_1 vsp_1 vzero_1
degree : 7
Alias :None
Color : null
Priority : 0
------
a5_1:
AdjList :  a6_1 va2_1 t_3 va3_1 t_1 a10_1 t_2 va5_1 va1_1 vsp_1 vzero_1 va0_1 a9_1 a8_1 a7_1 va6_1 a2_1 a4_1 va7_1 a3_1 a1_1
degree : 11
Alias :None
Color : null
Priority : 0
------
a10_1:
AdjList :  t_8 t_1 t_2 va1_1 vzero_1 a9_1 a7_1 va6_1 a3_1 va4_1 a6_1 va2_1 t_3 va3_1 a5_1 va5_1 t_5 t_4 t_6 vsp_1 va0_1 a8_1 t_7 a2_1 a4_1 va7_1 a1_1
degree : 22
Alias :None
Color : null
Priority : 0
------
t_5:
AdjList :  a9_1 a8_1 a7_1 a10_1 vsp_1 vzero_1
degree : 4
Alias :None
Color : null
Priority : 0
------
t_4:
AdjList :  a9_1 a8_1 a6_1 a7_1 a10_1 vsp_1 vzero_1
degree : 5
Alias :None
Color : null
Priority : 0
------
t_6:
AdjList :  a9_1 a8_1 a10_1 vsp_1 vzero_1
degree : 3
Alias :None
Color : null
Priority : 0
------
a8_1:
AdjList :  a6_1 va2_1 t_3 va3_1 t_1 a5_1 a10_1 t_2 va5_1 t_5 t_4 va1_1 t_6 vsp_1 vzero_1 va0_1 a9_1 a7_1 va6_1 a2_1 a4_1 a3_1 va4_1 a1_1
degree : 15
Alias :va7_1
Color : null
Priority : 0
------
t_9:
AdjList :  vsp_1 vzero_1
degree : 2
Alias :t_10
Color : null
Priority : 0
------
t_7:
AdjList :  a9_1 a10_1 vsp_1 vzero_1
degree : 3
Alias :None
Color : null
Priority : 0
------
a2_1:
AdjList :  a6_1 va2_1 a5_1 a10_1 va5_1 vsp_1 vzero_1 va0_1 a9_1 a8_1 a7_1 va6_1 a4_1 va7_1 a3_1 a1_1
degree : 9
Alias :None
Color : null
Priority : 0
------
a4_1:
AdjList :  a6_1 va2_1 t_1 a5_1 a10_1 t_2 va5_1 va1_1 vsp_1 vzero_1 va0_1 a9_1 a8_1 a7_1 va6_1 a2_1 va7_1 a3_1 a1_1
degree : 10
Alias :None
Color : null
Priority : 0
------
a1_1:
AdjList :  a6_1 va2_1 a5_1 a10_1 vsp_1 vzero_1 a9_1 a8_1 a7_1 a2_1 a4_1 va7_1 a3_1
degree : 9
Alias :va0_1
Color : null
Priority : 0
------
========func move List Info ========
coalesced moves:
a3_1 = move va2_1
a8_1 = move va7_1
a1_1 = move va0_1
a7_1 = move va6_1
t_10 = move t_9
a6_1 = move va5_1
------
constrained moves:
------
fronzen moves:
------
workList moves:
a4_1 = move va3_1
a2_1 = move va1_1
a5_1 = move va4_1
------
active moves:
========func Node List Info ========
simplify Nodes(low degree non move related):

------
freeze Nodes(low degree move related):
a5_1(0) a2_1(0) a4_1(0) 
------
spill Nodes(high degree):

------
spilled Nodes:

------
coalesced Nodes:
a8_1(0) a6_1(0) a7_1(0) t_9(0) a3_1(0) a1_1(0) 
------
colored Nodes:

------
selected Stack:
a9_1(0) t_8(0) t_3(0) t_1(0) t_7(0) a10_1(0) t_2(0) t_5(0) t_4(0) t_6(0) t_10(0) 
------

===================== Coalesce =====================
========func Graph Info ========
t_8:
AdjList :  a10_1 vsp_1 vzero_1
degree : 3
Alias :None
Color : null
Priority : 0
------
t_1:
AdjList :  a9_1 a8_1 a6_1 a7_1 a5_1 a10_1 a4_1 a3_1 vsp_1 vzero_1
degree : 9
Alias :None
Color : null
Priority : 0
------
t_2:
AdjList :  a9_1 a8_1 a6_1 a7_1 a5_1 a10_1 a4_1 vsp_1 vzero_1
degree : 7
Alias :None
Color : null
Priority : 0
------
t_10:
AdjList :  vsp_1 vzero_1
degree : 2
Alias :None
Color : null
Priority : 0
------
a9_1:
AdjList :  t_1 t_2 va1_1 vzero_1 a7_1 va6_1 a3_1 va4_1 a6_1 va2_1 t_3 va3_1 a5_1 a10_1 va5_1 t_5 t_4 t_6 vsp_1 va0_1 a8_1 t_7 a2_1 a4_1 va7_1 a1_1
degree : 26
Alias :None
Color : null
Priority : 0
------
a7_1:
AdjList :  a6_1 va2_1 t_3 va3_1 t_1 a5_1 a10_1 t_2 va5_1 t_5 t_4 va1_1 vsp_1 vzero_1 va0_1 a9_1 a8_1 a2_1 a4_1 va7_1 a3_1 va4_1 a1_1
degree : 13
Alias :va6_1
Color : null
Priority : 0
------
a3_1:
AdjList :  a6_1 t_1 a5_1 a10_1 va1_1 vsp_1 vzero_1 va0_1 a9_1 a8_1 a7_1 a2_1 a4_1 a1_1
degree : 11
Alias :va2_1
Color : null
Priority : 0
------
a6_1:
AdjList :  va2_1 t_3 va3_1 t_1 a5_1 a10_1 t_2 t_4 va1_1 vsp_1 vzero_1 va0_1 a9_1 a8_1 a7_1 va6_1 a2_1 a4_1 va7_1 a3_1 va4_1 a1_1
degree : 12
Alias :va5_1
Color : null
Priority : 0
------
t_3:
AdjList :  a9_1 a8_1 a6_1 a7_1 a5_1 a10_1 vsp_1 vzero_1
degree : 7
Alias :None
Color : null
Priority : 0
------
a5_1:
AdjList :  a6_1 va2_1 t_3 va3_1 t_1 a10_1 t_2 va5_1 va1_1 vsp_1 vzero_1 va0_1 a9_1 a8_1 a7_1 va6_1 a2_1 a4_1 va7_1 a3_1 a1_1
degree : 10
Alias :None
Color : null
Priority : 0
------
a10_1:
AdjList :  t_8 t_1 t_2 va1_1 vzero_1 a9_1 a7_1 va6_1 a3_1 va4_1 a6_1 va2_1 t_3 va3_1 a5_1 va5_1 t_5 t_4 t_6 vsp_1 va0_1 a8_1 t_7 a2_1 a4_1 va7_1 a1_1
degree : 22
Alias :None
Color : null
Priority : 0
------
t_5:
AdjList :  a9_1 a8_1 a7_1 a10_1 vsp_1 vzero_1
degree : 4
Alias :None
Color : null
Priority : 0
------
t_4:
AdjList :  a9_1 a8_1 a6_1 a7_1 a10_1 vsp_1 vzero_1
degree : 5
Alias :None
Color : null
Priority : 0
------
t_6:
AdjList :  a9_1 a8_1 a10_1 vsp_1 vzero_1
degree : 3
Alias :None
Color : null
Priority : 0
------
a8_1:
AdjList :  a6_1 va2_1 t_3 va3_1 t_1 a5_1 a10_1 t_2 va5_1 t_5 t_4 va1_1 t_6 vsp_1 vzero_1 va0_1 a9_1 a7_1 va6_1 a2_1 a4_1 a3_1 va4_1 a1_1
degree : 15
Alias :va7_1
Color : null
Priority : 0
------
t_9:
AdjList :  vsp_1 vzero_1
degree : 2
Alias :t_10
Color : null
Priority : 0
------
t_7:
AdjList :  a9_1 a10_1 vsp_1 vzero_1
degree : 3
Alias :None
Color : null
Priority : 0
------
a2_1:
AdjList :  a6_1 va2_1 va3_1 a5_1 a10_1 va5_1 vsp_1 vzero_1 va0_1 a9_1 a8_1 a7_1 va6_1 a4_1 va7_1 a3_1 a1_1
degree : 9
Alias :None
Color : null
Priority : 0
------
a4_1:
AdjList :  a6_1 va2_1 t_1 a5_1 a10_1 t_2 va5_1 va1_1 vsp_1 vzero_1 va0_1 a9_1 a8_1 a7_1 va6_1 a2_1 va7_1 a3_1 a1_1
degree : 10
Alias :va3_1
Color : null
Priority : 0
------
a1_1:
AdjList :  a6_1 va2_1 a5_1 a10_1 vsp_1 vzero_1 a9_1 a8_1 a7_1 a2_1 a4_1 va7_1 a3_1
degree : 9
Alias :va0_1
Color : null
Priority : 0
------
========func move List Info ========
coalesced moves:
a3_1 = move va2_1
a8_1 = move va7_1
a1_1 = move va0_1
a7_1 = move va6_1
t_10 = move t_9
a6_1 = move va5_1
a4_1 = move va3_1
------
constrained moves:
------
fronzen moves:
------
workList moves:
a2_1 = move va1_1
a5_1 = move va4_1
------
active moves:
========func Node List Info ========
simplify Nodes(low degree non move related):

------
freeze Nodes(low degree move related):
a5_1(0) a2_1(0) 
------
spill Nodes(high degree):

------
spilled Nodes:

------
coalesced Nodes:
a8_1(0) a6_1(0) a7_1(0) t_9(0) a4_1(0) a3_1(0) a1_1(0) 
------
colored Nodes:

------
selected Stack:
a9_1(0) t_8(0) t_3(0) t_1(0) t_7(0) a10_1(0) t_2(0) t_5(0) t_4(0) t_6(0) t_10(0) 
------

===================== Coalesce =====================
========func Graph Info ========
t_8:
AdjList :  a10_1 vsp_1 vzero_1
degree : 3
Alias :None
Color : null
Priority : 0
------
t_1:
AdjList :  a9_1 a8_1 a6_1 a7_1 a5_1 a10_1 a4_1 a3_1 vsp_1 vzero_1
degree : 9
Alias :None
Color : null
Priority : 0
------
t_2:
AdjList :  a9_1 a8_1 a6_1 a7_1 a5_1 a10_1 a4_1 vsp_1 vzero_1
degree : 7
Alias :None
Color : null
Priority : 0
------
t_10:
AdjList :  vsp_1 vzero_1
degree : 2
Alias :None
Color : null
Priority : 0
------
a9_1:
AdjList :  t_1 t_2 va1_1 vzero_1 a7_1 va6_1 a3_1 va4_1 a6_1 va2_1 t_3 va3_1 a5_1 a10_1 va5_1 t_5 t_4 t_6 vsp_1 va0_1 a8_1 t_7 a2_1 a4_1 va7_1 a1_1
degree : 26
Alias :None
Color : null
Priority : 0
------
a7_1:
AdjList :  a6_1 va2_1 t_3 va3_1 t_1 a5_1 a10_1 t_2 va5_1 t_5 t_4 va1_1 vsp_1 vzero_1 va0_1 a9_1 a8_1 a2_1 a4_1 va7_1 a3_1 va4_1 a1_1
degree : 13
Alias :va6_1
Color : null
Priority : 0
------
a3_1:
AdjList :  a6_1 t_1 a5_1 a10_1 va1_1 vsp_1 vzero_1 va0_1 a9_1 a8_1 a7_1 a2_1 a4_1 a1_1
degree : 11
Alias :va2_1
Color : null
Priority : 0
------
a6_1:
AdjList :  va2_1 t_3 va3_1 t_1 a5_1 a10_1 t_2 t_4 va1_1 vsp_1 vzero_1 va0_1 a9_1 a8_1 a7_1 va6_1 a2_1 a4_1 va7_1 a3_1 va4_1 a1_1
degree : 12
Alias :va5_1
Color : null
Priority : 0
------
t_3:
AdjList :  a9_1 a8_1 a6_1 a7_1 a5_1 a10_1 vsp_1 vzero_1
degree : 7
Alias :None
Color : null
Priority : 0
------
a5_1:
AdjList :  a6_1 va2_1 t_3 va3_1 t_1 a10_1 t_2 va5_1 va1_1 vsp_1 vzero_1 va0_1 a9_1 a8_1 a7_1 va6_1 a2_1 a4_1 va7_1 a3_1 a1_1
degree : 9
Alias :None
Color : null
Priority : 0
------
a10_1:
AdjList :  t_8 t_1 t_2 va1_1 vzero_1 a9_1 a7_1 va6_1 a3_1 va4_1 a6_1 va2_1 t_3 va3_1 a5_1 va5_1 t_5 t_4 t_6 vsp_1 va0_1 a8_1 t_7 a2_1 a4_1 va7_1 a1_1
degree : 22
Alias :None
Color : null
Priority : 0
------
t_5:
AdjList :  a9_1 a8_1 a7_1 a10_1 vsp_1 vzero_1
degree : 4
Alias :None
Color : null
Priority : 0
------
t_4:
AdjList :  a9_1 a8_1 a6_1 a7_1 a10_1 vsp_1 vzero_1
degree : 5
Alias :None
Color : null
Priority : 0
------
t_6:
AdjList :  a9_1 a8_1 a10_1 vsp_1 vzero_1
degree : 3
Alias :None
Color : null
Priority : 0
------
a8_1:
AdjList :  a6_1 va2_1 t_3 va3_1 t_1 a5_1 a10_1 t_2 va5_1 t_5 t_4 va1_1 t_6 vsp_1 vzero_1 va0_1 a9_1 a7_1 va6_1 a2_1 a4_1 a3_1 va4_1 a1_1
degree : 15
Alias :va7_1
Color : null
Priority : 0
------
t_9:
AdjList :  vsp_1 vzero_1
degree : 2
Alias :t_10
Color : null
Priority : 0
------
t_7:
AdjList :  a9_1 a10_1 vsp_1 vzero_1
degree : 3
Alias :None
Color : null
Priority : 0
------
a2_1:
AdjList :  a6_1 va2_1 va3_1 a5_1 a10_1 va5_1 vsp_1 vzero_1 va0_1 a9_1 a8_1 a7_1 va6_1 a4_1 va7_1 a3_1 a1_1
degree : 9
Alias :va1_1
Color : null
Priority : 0
------
a4_1:
AdjList :  a6_1 va2_1 t_1 a5_1 a10_1 t_2 va5_1 va1_1 vsp_1 vzero_1 va0_1 a9_1 a8_1 a7_1 va6_1 a2_1 va7_1 a3_1 a1_1
degree : 10
Alias :va3_1
Color : null
Priority : 0
------
a1_1:
AdjList :  a6_1 va2_1 a5_1 a10_1 vsp_1 vzero_1 a9_1 a8_1 a7_1 a2_1 a4_1 va7_1 a3_1
degree : 9
Alias :va0_1
Color : null
Priority : 0
------
========func move List Info ========
coalesced moves:
a3_1 = move va2_1
a8_1 = move va7_1
a1_1 = move va0_1
a7_1 = move va6_1
t_10 = move t_9
a6_1 = move va5_1
a4_1 = move va3_1
a2_1 = move va1_1
------
constrained moves:
------
fronzen moves:
------
workList moves:
a5_1 = move va4_1
------
active moves:
========func Node List Info ========
simplify Nodes(low degree non move related):

------
freeze Nodes(low degree move related):
a5_1(0) 
------
spill Nodes(high degree):

------
spilled Nodes:

------
coalesced Nodes:
a8_1(0) a6_1(0) a7_1(0) t_9(0) a2_1(0) a4_1(0) a3_1(0) a1_1(0) 
------
colored Nodes:

------
selected Stack:
a9_1(0) t_8(0) t_3(0) t_1(0) t_7(0) a10_1(0) t_2(0) t_5(0) t_4(0) t_6(0) t_10(0) 
------

===================== Coalesce =====================
========func Graph Info ========
t_8:
AdjList :  a10_1 vsp_1 vzero_1
degree : 3
Alias :None
Color : null
Priority : 0
------
t_1:
AdjList :  a9_1 a8_1 a6_1 a7_1 a5_1 a10_1 a4_1 a3_1 vsp_1 vzero_1
degree : 9
Alias :None
Color : null
Priority : 0
------
t_2:
AdjList :  a9_1 a8_1 a6_1 a7_1 a5_1 a10_1 a4_1 vsp_1 vzero_1
degree : 7
Alias :None
Color : null
Priority : 0
------
t_10:
AdjList :  vsp_1 vzero_1
degree : 2
Alias :None
Color : null
Priority : 0
------
a9_1:
AdjList :  t_1 t_2 va1_1 vzero_1 a7_1 va6_1 a3_1 va4_1 a6_1 va2_1 t_3 va3_1 a5_1 a10_1 va5_1 t_5 t_4 t_6 vsp_1 va0_1 a8_1 t_7 a2_1 a4_1 va7_1 a1_1
degree : 26
Alias :None
Color : null
Priority : 0
------
a7_1:
AdjList :  a6_1 va2_1 t_3 va3_1 t_1 a5_1 a10_1 t_2 va5_1 t_5 t_4 va1_1 vsp_1 vzero_1 va0_1 a9_1 a8_1 a2_1 a4_1 va7_1 a3_1 va4_1 a1_1
degree : 13
Alias :va6_1
Color : null
Priority : 0
------
a3_1:
AdjList :  a6_1 t_1 a5_1 a10_1 va1_1 vsp_1 vzero_1 va0_1 a9_1 a8_1 a7_1 a2_1 a4_1 a1_1
degree : 11
Alias :va2_1
Color : null
Priority : 0
------
a6_1:
AdjList :  va2_1 t_3 va3_1 t_1 a5_1 a10_1 t_2 t_4 va1_1 vsp_1 vzero_1 va0_1 a9_1 a8_1 a7_1 va6_1 a2_1 a4_1 va7_1 a3_1 va4_1 a1_1
degree : 12
Alias :va5_1
Color : null
Priority : 0
------
t_3:
AdjList :  a9_1 a8_1 a6_1 a7_1 a5_1 a10_1 vsp_1 vzero_1
degree : 7
Alias :None
Color : null
Priority : 0
------
a5_1:
AdjList :  a6_1 va2_1 t_3 va3_1 t_1 a10_1 t_2 va5_1 va1_1 vsp_1 vzero_1 va0_1 a9_1 a8_1 a7_1 va6_1 a2_1 a4_1 va7_1 a3_1 a1_1
degree : 9
Alias :va4_1
Color : null
Priority : 0
------
a10_1:
AdjList :  t_8 t_1 t_2 va1_1 vzero_1 a9_1 a7_1 va6_1 a3_1 va4_1 a6_1 va2_1 t_3 va3_1 a5_1 va5_1 t_5 t_4 t_6 vsp_1 va0_1 a8_1 t_7 a2_1 a4_1 va7_1 a1_1
degree : 22
Alias :None
Color : null
Priority : 0
------
t_5:
AdjList :  a9_1 a8_1 a7_1 a10_1 vsp_1 vzero_1
degree : 4
Alias :None
Color : null
Priority : 0
------
t_4:
AdjList :  a9_1 a8_1 a6_1 a7_1 a10_1 vsp_1 vzero_1
degree : 5
Alias :None
Color : null
Priority : 0
------
t_6:
AdjList :  a9_1 a8_1 a10_1 vsp_1 vzero_1
degree : 3
Alias :None
Color : null
Priority : 0
------
a8_1:
AdjList :  a6_1 va2_1 t_3 va3_1 t_1 a5_1 a10_1 t_2 va5_1 t_5 t_4 va1_1 t_6 vsp_1 vzero_1 va0_1 a9_1 a7_1 va6_1 a2_1 a4_1 a3_1 va4_1 a1_1
degree : 15
Alias :va7_1
Color : null
Priority : 0
------
t_9:
AdjList :  vsp_1 vzero_1
degree : 2
Alias :t_10
Color : null
Priority : 0
------
t_7:
AdjList :  a9_1 a10_1 vsp_1 vzero_1
degree : 3
Alias :None
Color : null
Priority : 0
------
a2_1:
AdjList :  a6_1 va2_1 va3_1 a5_1 a10_1 va5_1 vsp_1 vzero_1 va0_1 a9_1 a8_1 a7_1 va6_1 a4_1 va7_1 a3_1 a1_1
degree : 9
Alias :va1_1
Color : null
Priority : 0
------
a4_1:
AdjList :  a6_1 va2_1 t_1 a5_1 a10_1 t_2 va5_1 va1_1 vsp_1 vzero_1 va0_1 a9_1 a8_1 a7_1 va6_1 a2_1 va7_1 a3_1 a1_1
degree : 10
Alias :va3_1
Color : null
Priority : 0
------
a1_1:
AdjList :  a6_1 va2_1 a5_1 a10_1 vsp_1 vzero_1 a9_1 a8_1 a7_1 a2_1 a4_1 va7_1 a3_1
degree : 9
Alias :va0_1
Color : null
Priority : 0
------
========func move List Info ========
coalesced moves:
a3_1 = move va2_1
a8_1 = move va7_1
a1_1 = move va0_1
a7_1 = move va6_1
t_10 = move t_9
a6_1 = move va5_1
a4_1 = move va3_1
a2_1 = move va1_1
a5_1 = move va4_1
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
a8_1(0) a6_1(0) a7_1(0) t_9(0) a5_1(0) a2_1(0) a4_1(0) a3_1(0) a1_1(0) 
------
colored Nodes:

------
selected Stack:
a9_1(0) t_8(0) t_3(0) t_1(0) t_7(0) a10_1(0) t_2(0) t_5(0) t_4(0) t_6(0) t_10(0) 
------

===================== after ASSIGN =====================
========func Graph Info ========
t_8:
AdjList :  a10_1 vsp_1 vzero_1
degree : 3
Alias :None
Color : s6
Priority : 0
------
t_1:
AdjList :  a9_1 a8_1 a6_1 a7_1 a5_1 a10_1 a4_1 a3_1 vsp_1 vzero_1
degree : 9
Alias :None
Color : s6
Priority : 0
------
t_2:
AdjList :  a9_1 a8_1 a6_1 a7_1 a5_1 a10_1 a4_1 vsp_1 vzero_1
degree : 7
Alias :None
Color : s6
Priority : 0
------
t_10:
AdjList :  vsp_1 vzero_1
degree : 2
Alias :None
Color : s6
Priority : 0
------
a9_1:
AdjList :  t_1 t_2 va1_1 vzero_1 a7_1 va6_1 a3_1 va4_1 a6_1 va2_1 t_3 va3_1 a5_1 a10_1 va5_1 t_5 t_4 t_6 vsp_1 va0_1 a8_1 t_7 a2_1 a4_1 va7_1 a1_1
degree : 26
Alias :None
Color : s1
Priority : 0
------
a7_1:
AdjList :  a6_1 va2_1 t_3 va3_1 t_1 a5_1 a10_1 t_2 va5_1 t_5 t_4 va1_1 vsp_1 vzero_1 va0_1 a9_1 a8_1 a2_1 a4_1 va7_1 a3_1 va4_1 a1_1
degree : 13
Alias :va6_1
Color : a6
Priority : 0
------
a3_1:
AdjList :  a6_1 t_1 a5_1 a10_1 va1_1 vsp_1 vzero_1 va0_1 a9_1 a8_1 a7_1 a2_1 a4_1 a1_1
degree : 11
Alias :va2_1
Color : a2
Priority : 0
------
a6_1:
AdjList :  va2_1 t_3 va3_1 t_1 a5_1 a10_1 t_2 t_4 va1_1 vsp_1 vzero_1 va0_1 a9_1 a8_1 a7_1 va6_1 a2_1 a4_1 va7_1 a3_1 va4_1 a1_1
degree : 12
Alias :va5_1
Color : a5
Priority : 0
------
t_3:
AdjList :  a9_1 a8_1 a6_1 a7_1 a5_1 a10_1 vsp_1 vzero_1
degree : 7
Alias :None
Color : s6
Priority : 0
------
a5_1:
AdjList :  a6_1 va2_1 t_3 va3_1 t_1 a10_1 t_2 va5_1 va1_1 vsp_1 vzero_1 va0_1 a9_1 a8_1 a7_1 va6_1 a2_1 a4_1 va7_1 a3_1 a1_1
degree : 9
Alias :va4_1
Color : a4
Priority : 0
------
a10_1:
AdjList :  t_8 t_1 t_2 va1_1 vzero_1 a9_1 a7_1 va6_1 a3_1 va4_1 a6_1 va2_1 t_3 va3_1 a5_1 va5_1 t_5 t_4 t_6 vsp_1 va0_1 a8_1 t_7 a2_1 a4_1 va7_1 a1_1
degree : 22
Alias :None
Color : s2
Priority : 0
------
t_5:
AdjList :  a9_1 a8_1 a7_1 a10_1 vsp_1 vzero_1
degree : 4
Alias :None
Color : s6
Priority : 0
------
t_4:
AdjList :  a9_1 a8_1 a6_1 a7_1 a10_1 vsp_1 vzero_1
degree : 5
Alias :None
Color : s6
Priority : 0
------
t_6:
AdjList :  a9_1 a8_1 a10_1 vsp_1 vzero_1
degree : 3
Alias :None
Color : s6
Priority : 0
------
a8_1:
AdjList :  a6_1 va2_1 t_3 va3_1 t_1 a5_1 a10_1 t_2 va5_1 t_5 t_4 va1_1 t_6 vsp_1 vzero_1 va0_1 a9_1 a7_1 va6_1 a2_1 a4_1 a3_1 va4_1 a1_1
degree : 15
Alias :va7_1
Color : a7
Priority : 0
------
t_9:
AdjList :  vsp_1 vzero_1
degree : 2
Alias :t_10
Color : s6
Priority : 0
------
t_7:
AdjList :  a9_1 a10_1 vsp_1 vzero_1
degree : 3
Alias :None
Color : s6
Priority : 0
------
a2_1:
AdjList :  a6_1 va2_1 va3_1 a5_1 a10_1 va5_1 vsp_1 vzero_1 va0_1 a9_1 a8_1 a7_1 va6_1 a4_1 va7_1 a3_1 a1_1
degree : 9
Alias :va1_1
Color : a1
Priority : 0
------
a4_1:
AdjList :  a6_1 va2_1 t_1 a5_1 a10_1 t_2 va5_1 va1_1 vsp_1 vzero_1 va0_1 a9_1 a8_1 a7_1 va6_1 a2_1 va7_1 a3_1 a1_1
degree : 10
Alias :va3_1
Color : a3
Priority : 0
------
a1_1:
AdjList :  a6_1 va2_1 a5_1 a10_1 vsp_1 vzero_1 a9_1 a8_1 a7_1 a2_1 a4_1 va7_1 a3_1
degree : 9
Alias :va0_1
Color : a0
Priority : 0
------
========func move List Info ========
coalesced moves:
a3_1 = move va2_1
a8_1 = move va7_1
a1_1 = move va0_1
a7_1 = move va6_1
t_10 = move t_9
a6_1 = move va5_1
a4_1 = move va3_1
a2_1 = move va1_1
a5_1 = move va4_1
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
a8_1(0) a6_1(0) a7_1(0) t_9(0) a5_1(0) a2_1(0) a4_1(0) a3_1(0) a1_1(0) 
------
colored Nodes:
a9_1(0) t_3(0) t_8(0) t_7(0) t_1(0) a10_1(0) t_2(0) t_5(0) t_4(0) t_10(0) t_6(0) 
------
selected Stack:

------

=====================main Iteration 0=====================
========main Graph Info ========
a2_2:
AdjList :  a8_2 a5_2 a7_2 a6_2 a4_2 a3_2 a10_2 a9_2 a1_2 vsp_1 va0_1 vzero_1
degree : 12
Alias :None
Color : null
Priority : 0
------
a1_2:
AdjList :  a8_2 a5_2 a2_2 a7_2 a6_2 a4_2 a3_2 a10_2 a9_2 vsp_1 vzero_1
degree : 11
Alias :None
Color : null
Priority : 0
------
a10_2:
AdjList :  va2_1 a5_2 a2_2 a6_2 va3_1 a4_2 va5_1 va1_1 a9_2 a1_2 vsp_1 va0_1 vzero_1 a8_2 a7_2 va6_1 a3_2 va7_1 va4_1
degree : 19
Alias :None
Color : null
Priority : 0
------
a7_2:
AdjList :  va2_1 a5_2 a2_2 a6_2 va3_1 a4_2 va5_1 va1_1 a10_2 a9_2 a1_2 vsp_1 va0_1 vzero_1 a8_2 a3_2 va4_1
degree : 17
Alias :None
Color : null
Priority : 0
------
a3_2:
AdjList :  a5_2 a2_2 a6_2 a4_2 va1_1 a10_2 a9_2 a1_2 vsp_1 va0_1 vzero_1 a8_2 a7_2
degree : 13
Alias :None
Color : null
Priority : 0
------
t_11:
AdjList :  va2_1 va3_1 vt2_1 va5_1 vt5_1 va1_1 vsp_1 va0_1 vzero_1 vra_1 va6_1 vt0_1 vt6_1 va7_1 va4_1 vt1_1 vt3_1 vt4_1
degree : 18
Alias :None
Color : null
Priority : 0
------
t_12:
AdjList :  vsp_1 vzero_1
degree : 2
Alias :None
Color : null
Priority : 0
------
a5_2:
AdjList :  va2_1 a2_2 a6_2 va3_1 a4_2 va1_1 a10_2 a9_2 a1_2 vsp_1 va0_1 vzero_1 a8_2 a7_2 a3_2
degree : 15
Alias :None
Color : null
Priority : 0
------
a6_2:
AdjList :  va2_1 a5_2 a2_2 va3_1 a4_2 va1_1 a10_2 a9_2 a1_2 vsp_1 va0_1 vzero_1 a8_2 a7_2 a3_2 va4_1
degree : 16
Alias :None
Color : null
Priority : 0
------
a4_2:
AdjList :  va2_1 a5_2 a2_2 a6_2 va1_1 a10_2 a9_2 a1_2 vsp_1 va0_1 vzero_1 a8_2 a7_2 a3_2
degree : 14
Alias :None
Color : null
Priority : 0
------
a9_2:
AdjList :  va2_1 a5_2 a2_2 a6_2 va3_1 a4_2 va5_1 va1_1 a10_2 a1_2 vsp_1 va0_1 vzero_1 a8_2 a7_2 va6_1 a3_2 va7_1 va4_1
degree : 19
Alias :None
Color : null
Priority : 0
------
a8_2:
AdjList :  va2_1 a5_2 a2_2 a6_2 va3_1 a4_2 va5_1 va1_1 a10_2 a9_2 a1_2 vsp_1 va0_1 vzero_1 a7_2 va6_1 a3_2 va4_1
degree : 18
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
va4_1 = move a5_2
va3_1 = move a4_2
va0_1 = move a1_2
va6_1 = move a7_2
t_12 = move t_11
va7_1 = move a8_2
va2_1 = move a3_2
va1_1 = move a2_2
va5_1 = move a6_2
------
active moves:
========main Node List Info ========
simplify Nodes(low degree non move related):
a10_2(0) a9_2(0) 
------
freeze Nodes(low degree move related):
a5_2(0) a8_2(0) a2_2(0) a7_2(0) a6_2(0) a4_2(0) a3_2(0) t_11(0) t_12(0) a1_2(0) 
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

define i64 @func  %a1_1 %a2_1 %a3_1 %a4_1 %a5_1 %a6_1 %a7_1 %a8_1 %a9_1 %a10_1 {
func_entry_1:
   store %vs11_1 %vsp_1 null 0 44
   store %vs8_1 %vsp_1 null 0 40
   store %vs7_1 %vsp_1 null 0 36
   store %vs10_1 %vsp_1 null 0 32
   store %vs3_1 %vsp_1 null 0 28
   store %vs1_1 %vsp_1 null 0 24
   store %vs9_1 %vsp_1 null 0 20
   store %vs5_1 %vsp_1 null 0 16
   store %vs6_1 %vsp_1 null 0 12
   store %vs4_1 %vsp_1 null 0 8
   store %vs2_1 %vsp_1 null 0 4
   store %ra %vsp_1 null 0 0
   %a10_1 = load %vsp_1 null 0 4
   %a9_1 = load %vsp_1 null 0 0
   %a8_1 = move %va7_1
   %a7_1 = move %va6_1
   %a6_1 = move %va5_1
   %a5_1 = move %va4_1
   %a4_1 = move %va3_1
   %a3_1 = move %va2_1
   %a2_1 = move %va1_1
   %a1_1 = move %va0_1
   %t_1 = add %a1_1 %a2_1
   %t_2 = add %t_1 %a3_1
   %t_3 = add %t_2 %a4_1
   %t_4 = add %t_3 %a5_1
   %t_5 = add %t_4 %a6_1
   %t_6 = add %t_5 %a7_1
   %t_7 = add %t_6 %a8_1
   %t_8 = add %t_7 %a9_1
   %t_9 = add %t_8 %a10_1
   %t_10 = move %t_9
   %a0 = move %t_10
   %ra = load %vsp_1 null 0 0
   %vs2_1 = load %vsp_1 null 0 4
   %vs4_1 = load %vsp_1 null 0 8
   %vs6_1 = load %vsp_1 null 0 12
   %vs5_1 = load %vsp_1 null 0 16
   %vs9_1 = load %vsp_1 null 0 20
   %vs1_1 = load %vsp_1 null 0 24
   %vs3_1 = load %vsp_1 null 0 28
   %vs10_1 = load %vsp_1 null 0 32
   %vs7_1 = load %vsp_1 null 0 36
   %vs8_1 = load %vsp_1 null 0 40
   %vs11_1 = load %vsp_1 null 0 44
   ret %a0
}

define i64 @main  {
main_entry_1:
   store %vs11_1 %vsp_1 null 0 52
   store %vs8_1 %vsp_1 null 0 48
   store %vs7_1 %vsp_1 null 0 44
   store %vs10_1 %vsp_1 null 0 40
   store %vs3_1 %vsp_1 null 0 36
   store %vs1_1 %vsp_1 null 0 32
   store %vs9_1 %vsp_1 null 0 28
   store %vs5_1 %vsp_1 null 0 24
   store %vs6_1 %vsp_1 null 0 20
   store %vs4_1 %vsp_1 null 0 16
   store %vs2_1 %vsp_1 null 0 12
   store %ra %vsp_1 null 0 8
   %a1_2 = move 2
   %a2_2 = move 3
   %a3_2 = move 4
   %a4_2 = move 5
   %a5_2 = move 6
   %a6_2 = move 7
   %a7_2 = move 8
   %a8_2 = move 9
   %a9_2 = move 10
   %a10_2 = move 11
   store %a9_2 %vsp_1 null 0 0
   store %a10_2 %vsp_1 null 0 4
   %va0_1 = move %a1_2
   %va1_1 = move %a2_2
   %va2_1 = move %a3_2
   %va3_1 = move %a4_2
   %va4_1 = move %a5_2
   %va5_1 = move %a6_2
   %va6_1 = move %a7_2
   %va7_1 = move %a8_2
   %t_11 = call func %va0_1 %va1_1 %va2_1 %va3_1 %va4_1 %va5_1 %va6_1 %va7_1 %a9_2 %a10_2 
   %t_12 = move %t_11
   %a0 = move %t_12
   %ra = load %vsp_1 null 0 8
   %vs2_1 = load %vsp_1 null 0 12
   %vs4_1 = load %vsp_1 null 0 16
   %vs6_1 = load %vsp_1 null 0 20
   %vs5_1 = load %vsp_1 null 0 24
   %vs9_1 = load %vsp_1 null 0 28
   %vs1_1 = load %vsp_1 null 0 32
   %vs3_1 = load %vsp_1 null 0 36
   %vs10_1 = load %vsp_1 null 0 40
   %vs7_1 = load %vsp_1 null 0 44
   %vs8_1 = load %vsp_1 null 0 48
   %vs11_1 = load %vsp_1 null 0 52
   ret %a0
}

define i64 @__init  {
__init_entry_1:
   store %vs11_1 %vsp_1 null 0 44
   store %vs8_1 %vsp_1 null 0 40
   store %vs7_1 %vsp_1 null 0 36
   store %vs10_1 %vsp_1 null 0 32
   store %vs3_1 %vsp_1 null 0 28
   store %vs1_1 %vsp_1 null 0 24
   store %vs9_1 %vsp_1 null 0 20
   store %vs5_1 %vsp_1 null 0 16
   store %vs6_1 %vsp_1 null 0 12
   store %vs4_1 %vsp_1 null 0 8
   store %vs2_1 %vsp_1 null 0 4
   store %ra %vsp_1 null 0 0
   %t_13 = call main 
   %t_14 = move %t_13
   %a0 = move %t_14
   %ra = load %vsp_1 null 0 0
   %vs2_1 = load %vsp_1 null 0 4
   %vs4_1 = load %vsp_1 null 0 8
   %vs6_1 = load %vsp_1 null 0 12
   %vs5_1 = load %vsp_1 null 0 16
   %vs9_1 = load %vsp_1 null 0 20
   %vs1_1 = load %vsp_1 null 0 24
   %vs3_1 = load %vsp_1 null 0 28
   %vs10_1 = load %vsp_1 null 0 32
   %vs7_1 = load %vsp_1 null 0 36
   %vs8_1 = load %vsp_1 null 0 40
   %vs11_1 = load %vsp_1 null 0 44
   ret %a0
}

===================== Simplify =====================
========main Graph Info ========
a2_2:
AdjList :  a8_2 a5_2 a7_2 a6_2 a4_2 a3_2 a10_2 a9_2 a1_2 vsp_1 va0_1 vzero_1
degree : 11
Alias :None
Color : null
Priority : 0
------
a1_2:
AdjList :  a8_2 a5_2 a2_2 a7_2 a6_2 a4_2 a3_2 a10_2 a9_2 vsp_1 vzero_1
degree : 10
Alias :None
Color : null
Priority : 0
------
a10_2:
AdjList :  va2_1 a5_2 a2_2 a6_2 va3_1 a4_2 va5_1 va1_1 a9_2 a1_2 vsp_1 va0_1 vzero_1 a8_2 a7_2 va6_1 a3_2 va7_1 va4_1
degree : 19
Alias :None
Color : null
Priority : 0
------
a7_2:
AdjList :  va2_1 a5_2 a2_2 a6_2 va3_1 a4_2 va5_1 va1_1 a10_2 a9_2 a1_2 vsp_1 va0_1 vzero_1 a8_2 a3_2 va4_1
degree : 16
Alias :None
Color : null
Priority : 0
------
a3_2:
AdjList :  a5_2 a2_2 a6_2 a4_2 va1_1 a10_2 a9_2 a1_2 vsp_1 va0_1 vzero_1 a8_2 a7_2
degree : 12
Alias :None
Color : null
Priority : 0
------
t_11:
AdjList :  va2_1 va3_1 vt2_1 va5_1 vt5_1 va1_1 vsp_1 va0_1 vzero_1 vra_1 va6_1 vt0_1 vt6_1 va7_1 va4_1 vt1_1 vt3_1 vt4_1
degree : 18
Alias :None
Color : null
Priority : 0
------
t_12:
AdjList :  vsp_1 vzero_1
degree : 2
Alias :None
Color : null
Priority : 0
------
a5_2:
AdjList :  va2_1 a2_2 a6_2 va3_1 a4_2 va1_1 a10_2 a9_2 a1_2 vsp_1 va0_1 vzero_1 a8_2 a7_2 a3_2
degree : 14
Alias :None
Color : null
Priority : 0
------
a6_2:
AdjList :  va2_1 a5_2 a2_2 va3_1 a4_2 va1_1 a10_2 a9_2 a1_2 vsp_1 va0_1 vzero_1 a8_2 a7_2 a3_2 va4_1
degree : 15
Alias :None
Color : null
Priority : 0
------
a4_2:
AdjList :  va2_1 a5_2 a2_2 a6_2 va1_1 a10_2 a9_2 a1_2 vsp_1 va0_1 vzero_1 a8_2 a7_2 a3_2
degree : 13
Alias :None
Color : null
Priority : 0
------
a9_2:
AdjList :  va2_1 a5_2 a2_2 a6_2 va3_1 a4_2 va5_1 va1_1 a10_2 a1_2 vsp_1 va0_1 vzero_1 a8_2 a7_2 va6_1 a3_2 va7_1 va4_1
degree : 18
Alias :None
Color : null
Priority : 0
------
a8_2:
AdjList :  va2_1 a5_2 a2_2 a6_2 va3_1 a4_2 va5_1 va1_1 a10_2 a9_2 a1_2 vsp_1 va0_1 vzero_1 a7_2 va6_1 a3_2 va4_1
degree : 17
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
va4_1 = move a5_2
va3_1 = move a4_2
va0_1 = move a1_2
va6_1 = move a7_2
t_12 = move t_11
va7_1 = move a8_2
va2_1 = move a3_2
va1_1 = move a2_2
va5_1 = move a6_2
------
active moves:
========main Node List Info ========
simplify Nodes(low degree non move related):
a9_2(0) 
------
freeze Nodes(low degree move related):
a5_2(0) a8_2(0) a2_2(0) a7_2(0) a6_2(0) a4_2(0) a3_2(0) t_11(0) t_12(0) a1_2(0) 
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
a10_2(0) 
------

===================== Simplify =====================
========main Graph Info ========
a2_2:
AdjList :  a8_2 a5_2 a7_2 a6_2 a4_2 a3_2 a10_2 a9_2 a1_2 vsp_1 va0_1 vzero_1
degree : 10
Alias :None
Color : null
Priority : 0
------
a1_2:
AdjList :  a8_2 a5_2 a2_2 a7_2 a6_2 a4_2 a3_2 a10_2 a9_2 vsp_1 vzero_1
degree : 9
Alias :None
Color : null
Priority : 0
------
a10_2:
AdjList :  va2_1 a5_2 a2_2 a6_2 va3_1 a4_2 va5_1 va1_1 a9_2 a1_2 vsp_1 va0_1 vzero_1 a8_2 a7_2 va6_1 a3_2 va7_1 va4_1
degree : 19
Alias :None
Color : null
Priority : 0
------
a7_2:
AdjList :  va2_1 a5_2 a2_2 a6_2 va3_1 a4_2 va5_1 va1_1 a10_2 a9_2 a1_2 vsp_1 va0_1 vzero_1 a8_2 a3_2 va4_1
degree : 15
Alias :None
Color : null
Priority : 0
------
a3_2:
AdjList :  a5_2 a2_2 a6_2 a4_2 va1_1 a10_2 a9_2 a1_2 vsp_1 va0_1 vzero_1 a8_2 a7_2
degree : 11
Alias :None
Color : null
Priority : 0
------
t_11:
AdjList :  va2_1 va3_1 vt2_1 va5_1 vt5_1 va1_1 vsp_1 va0_1 vzero_1 vra_1 va6_1 vt0_1 vt6_1 va7_1 va4_1 vt1_1 vt3_1 vt4_1
degree : 18
Alias :None
Color : null
Priority : 0
------
t_12:
AdjList :  vsp_1 vzero_1
degree : 2
Alias :None
Color : null
Priority : 0
------
a5_2:
AdjList :  va2_1 a2_2 a6_2 va3_1 a4_2 va1_1 a10_2 a9_2 a1_2 vsp_1 va0_1 vzero_1 a8_2 a7_2 a3_2
degree : 13
Alias :None
Color : null
Priority : 0
------
a6_2:
AdjList :  va2_1 a5_2 a2_2 va3_1 a4_2 va1_1 a10_2 a9_2 a1_2 vsp_1 va0_1 vzero_1 a8_2 a7_2 a3_2 va4_1
degree : 14
Alias :None
Color : null
Priority : 0
------
a4_2:
AdjList :  va2_1 a5_2 a2_2 a6_2 va1_1 a10_2 a9_2 a1_2 vsp_1 va0_1 vzero_1 a8_2 a7_2 a3_2
degree : 12
Alias :None
Color : null
Priority : 0
------
a9_2:
AdjList :  va2_1 a5_2 a2_2 a6_2 va3_1 a4_2 va5_1 va1_1 a10_2 a1_2 vsp_1 va0_1 vzero_1 a8_2 a7_2 va6_1 a3_2 va7_1 va4_1
degree : 18
Alias :None
Color : null
Priority : 0
------
a8_2:
AdjList :  va2_1 a5_2 a2_2 a6_2 va3_1 a4_2 va5_1 va1_1 a10_2 a9_2 a1_2 vsp_1 va0_1 vzero_1 a7_2 va6_1 a3_2 va4_1
degree : 16
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
va4_1 = move a5_2
va3_1 = move a4_2
va0_1 = move a1_2
va6_1 = move a7_2
t_12 = move t_11
va7_1 = move a8_2
va2_1 = move a3_2
va1_1 = move a2_2
va5_1 = move a6_2
------
active moves:
========main Node List Info ========
simplify Nodes(low degree non move related):

------
freeze Nodes(low degree move related):
a5_2(0) a8_2(0) a2_2(0) a7_2(0) a6_2(0) a4_2(0) a3_2(0) t_11(0) t_12(0) a1_2(0) 
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
a10_2(0) a9_2(0) 
------

===================== Coalesce =====================
========main Graph Info ========
a2_2:
AdjList :  a5_2 a6_2 a4_2 a10_2 a9_2 a1_2 vsp_1 va0_1 vzero_1 a8_2 a7_2 a3_2 va4_1
degree : 10
Alias :None
Color : null
Priority : 0
------
a1_2:
AdjList :  a8_2 a5_2 a2_2 a7_2 a6_2 a4_2 a3_2 a10_2 a9_2 va4_1 vsp_1 vzero_1
degree : 9
Alias :None
Color : null
Priority : 0
------
a10_2:
AdjList :  va2_1 a5_2 a2_2 a6_2 va3_1 a4_2 va5_1 va1_1 a9_2 a1_2 vsp_1 va0_1 vzero_1 a8_2 a7_2 va6_1 a3_2 va7_1 va4_1
degree : 19
Alias :None
Color : null
Priority : 0
------
a7_2:
AdjList :  va2_1 a5_2 a2_2 a6_2 va3_1 a4_2 va5_1 va1_1 a10_2 a9_2 a1_2 vsp_1 va0_1 vzero_1 a8_2 a3_2 va4_1
degree : 14
Alias :None
Color : null
Priority : 0
------
a3_2:
AdjList :  a5_2 a2_2 a6_2 a4_2 va1_1 a10_2 a9_2 a1_2 vsp_1 va0_1 vzero_1 a8_2 a7_2 va4_1
degree : 11
Alias :None
Color : null
Priority : 0
------
t_11:
AdjList :  va2_1 va3_1 vt2_1 va5_1 vt5_1 va1_1 vsp_1 va0_1 vzero_1 vra_1 va6_1 vt0_1 vt6_1 va7_1 va4_1 vt1_1 vt3_1 vt4_1
degree : 18
Alias :None
Color : null
Priority : 0
------
t_12:
AdjList :  vsp_1 vzero_1
degree : 2
Alias :None
Color : null
Priority : 0
------
a5_2:
AdjList :  va2_1 a2_2 a6_2 va3_1 a4_2 va1_1 a10_2 a9_2 a1_2 vsp_1 va0_1 vzero_1 a8_2 a7_2 a3_2
degree : 13
Alias :va4_1
Color : null
Priority : 0
------
a6_2:
AdjList :  va2_1 a5_2 a2_2 va3_1 a4_2 va1_1 a10_2 a9_2 a1_2 vsp_1 va0_1 vzero_1 a8_2 a7_2 a3_2 va4_1
degree : 13
Alias :None
Color : null
Priority : 0
------
a4_2:
AdjList :  va2_1 a5_2 a2_2 a6_2 va1_1 a10_2 a9_2 a1_2 vsp_1 va0_1 vzero_1 a8_2 a7_2 a3_2 va4_1
degree : 12
Alias :None
Color : null
Priority : 0
------
a9_2:
AdjList :  va2_1 a5_2 a2_2 a6_2 va3_1 a4_2 va5_1 va1_1 a10_2 a1_2 vsp_1 va0_1 vzero_1 a8_2 a7_2 va6_1 a3_2 va7_1 va4_1
degree : 18
Alias :None
Color : null
Priority : 0
------
a8_2:
AdjList :  va2_1 a5_2 a2_2 a6_2 va3_1 a4_2 va5_1 va1_1 a10_2 a9_2 a1_2 vsp_1 va0_1 vzero_1 a7_2 va6_1 a3_2 va4_1
degree : 15
Alias :None
Color : null
Priority : 0
------
========main move List Info ========
coalesced moves:
va4_1 = move a5_2
------
constrained moves:
------
fronzen moves:
------
workList moves:
va3_1 = move a4_2
va0_1 = move a1_2
va6_1 = move a7_2
t_12 = move t_11
va7_1 = move a8_2
va2_1 = move a3_2
va1_1 = move a2_2
va5_1 = move a6_2
------
active moves:
========main Node List Info ========
simplify Nodes(low degree non move related):

------
freeze Nodes(low degree move related):
a8_2(0) a2_2(0) a7_2(0) a6_2(0) a4_2(0) a3_2(0) t_11(0) t_12(0) a1_2(0) 
------
spill Nodes(high degree):

------
spilled Nodes:

------
coalesced Nodes:
a5_2(0) 
------
colored Nodes:

------
selected Stack:
a10_2(0) a9_2(0) 
------

===================== Coalesce =====================
========main Graph Info ========
a2_2:
AdjList :  a5_2 a6_2 va3_1 a4_2 a10_2 a9_2 a1_2 vsp_1 va0_1 vzero_1 a8_2 a7_2 a3_2 va4_1
degree : 10
Alias :None
Color : null
Priority : 0
------
a1_2:
AdjList :  a5_2 a2_2 a6_2 va3_1 a4_2 a10_2 a9_2 vsp_1 vzero_1 a8_2 a7_2 a3_2 va4_1
degree : 9
Alias :None
Color : null
Priority : 0
------
a10_2:
AdjList :  va2_1 a5_2 a2_2 a6_2 va3_1 a4_2 va5_1 va1_1 a9_2 a1_2 vsp_1 va0_1 vzero_1 a8_2 a7_2 va6_1 a3_2 va7_1 va4_1
degree : 19
Alias :None
Color : null
Priority : 0
------
a7_2:
AdjList :  va2_1 a5_2 a2_2 a6_2 va3_1 a4_2 va5_1 va1_1 a10_2 a9_2 a1_2 vsp_1 va0_1 vzero_1 a8_2 a3_2 va4_1
degree : 13
Alias :None
Color : null
Priority : 0
------
a3_2:
AdjList :  a5_2 a2_2 a6_2 va3_1 a4_2 va1_1 a10_2 a9_2 a1_2 vsp_1 va0_1 vzero_1 a8_2 a7_2 va4_1
degree : 11
Alias :None
Color : null
Priority : 0
------
t_11:
AdjList :  va2_1 va3_1 vt2_1 va5_1 vt5_1 va1_1 vsp_1 va0_1 vzero_1 vra_1 va6_1 vt0_1 vt6_1 va7_1 va4_1 vt1_1 vt3_1 vt4_1
degree : 18
Alias :None
Color : null
Priority : 0
------
t_12:
AdjList :  vsp_1 vzero_1
degree : 2
Alias :None
Color : null
Priority : 0
------
a5_2:
AdjList :  va2_1 a2_2 a6_2 va3_1 a4_2 va1_1 a10_2 a9_2 a1_2 vsp_1 va0_1 vzero_1 a8_2 a7_2 a3_2
degree : 13
Alias :va4_1
Color : null
Priority : 0
------
a6_2:
AdjList :  va2_1 a5_2 a2_2 va3_1 a4_2 va1_1 a10_2 a9_2 a1_2 vsp_1 va0_1 vzero_1 a8_2 a7_2 a3_2 va4_1
degree : 12
Alias :None
Color : null
Priority : 0
------
a4_2:
AdjList :  va2_1 a5_2 a2_2 a6_2 va1_1 a10_2 a9_2 a1_2 vsp_1 va0_1 vzero_1 a8_2 a7_2 a3_2 va4_1
degree : 12
Alias :va3_1
Color : null
Priority : 0
------
a9_2:
AdjList :  va2_1 a5_2 a2_2 a6_2 va3_1 a4_2 va5_1 va1_1 a10_2 a1_2 vsp_1 va0_1 vzero_1 a8_2 a7_2 va6_1 a3_2 va7_1 va4_1
degree : 18
Alias :None
Color : null
Priority : 0
------
a8_2:
AdjList :  va2_1 a5_2 a2_2 a6_2 va3_1 a4_2 va5_1 va1_1 a10_2 a9_2 a1_2 vsp_1 va0_1 vzero_1 a7_2 va6_1 a3_2 va4_1
degree : 14
Alias :None
Color : null
Priority : 0
------
========main move List Info ========
coalesced moves:
va4_1 = move a5_2
va3_1 = move a4_2
------
constrained moves:
------
fronzen moves:
------
workList moves:
va0_1 = move a1_2
va6_1 = move a7_2
t_12 = move t_11
va7_1 = move a8_2
va2_1 = move a3_2
va1_1 = move a2_2
va5_1 = move a6_2
------
active moves:
========main Node List Info ========
simplify Nodes(low degree non move related):

------
freeze Nodes(low degree move related):
a8_2(0) a2_2(0) a7_2(0) a6_2(0) a3_2(0) t_11(0) t_12(0) a1_2(0) 
------
spill Nodes(high degree):

------
spilled Nodes:

------
coalesced Nodes:
a5_2(0) a4_2(0) 
------
colored Nodes:

------
selected Stack:
a10_2(0) a9_2(0) 
------

===================== Coalesce =====================
========main Graph Info ========
a2_2:
AdjList :  a5_2 a6_2 va3_1 a4_2 a10_2 a9_2 a1_2 vsp_1 va0_1 vzero_1 a8_2 a7_2 a3_2 va4_1
degree : 9
Alias :None
Color : null
Priority : 0
------
a1_2:
AdjList :  a5_2 a2_2 a6_2 va3_1 a4_2 a10_2 a9_2 vsp_1 vzero_1 a8_2 a7_2 a3_2 va4_1
degree : 9
Alias :va0_1
Color : null
Priority : 0
------
a10_2:
AdjList :  va2_1 a5_2 a2_2 a6_2 va3_1 a4_2 va5_1 va1_1 a9_2 a1_2 vsp_1 va0_1 vzero_1 a8_2 a7_2 va6_1 a3_2 va7_1 va4_1
degree : 19
Alias :None
Color : null
Priority : 0
------
a7_2:
AdjList :  va2_1 a5_2 a2_2 a6_2 va3_1 a4_2 va5_1 va1_1 a10_2 a9_2 a1_2 vsp_1 va0_1 vzero_1 a8_2 a3_2 va4_1
degree : 12
Alias :None
Color : null
Priority : 0
------
a3_2:
AdjList :  a5_2 a2_2 a6_2 va3_1 a4_2 va1_1 a10_2 a9_2 a1_2 vsp_1 va0_1 vzero_1 a8_2 a7_2 va4_1
degree : 10
Alias :None
Color : null
Priority : 0
------
t_11:
AdjList :  va2_1 va3_1 vt2_1 va5_1 vt5_1 va1_1 vsp_1 va0_1 vzero_1 vra_1 va6_1 vt0_1 vt6_1 va7_1 va4_1 vt1_1 vt3_1 vt4_1
degree : 18
Alias :None
Color : null
Priority : 0
------
t_12:
AdjList :  vsp_1 vzero_1
degree : 2
Alias :None
Color : null
Priority : 0
------
a5_2:
AdjList :  va2_1 a2_2 a6_2 va3_1 a4_2 va1_1 a10_2 a9_2 a1_2 vsp_1 va0_1 vzero_1 a8_2 a7_2 a3_2
degree : 13
Alias :va4_1
Color : null
Priority : 0
------
a6_2:
AdjList :  va2_1 a5_2 a2_2 va3_1 a4_2 va1_1 a10_2 a9_2 a1_2 vsp_1 va0_1 vzero_1 a8_2 a7_2 a3_2 va4_1
degree : 11
Alias :None
Color : null
Priority : 0
------
a4_2:
AdjList :  va2_1 a5_2 a2_2 a6_2 va1_1 a10_2 a9_2 a1_2 vsp_1 va0_1 vzero_1 a8_2 a7_2 a3_2 va4_1
degree : 12
Alias :va3_1
Color : null
Priority : 0
------
a9_2:
AdjList :  va2_1 a5_2 a2_2 a6_2 va3_1 a4_2 va5_1 va1_1 a10_2 a1_2 vsp_1 va0_1 vzero_1 a8_2 a7_2 va6_1 a3_2 va7_1 va4_1
degree : 18
Alias :None
Color : null
Priority : 0
------
a8_2:
AdjList :  va2_1 a5_2 a2_2 a6_2 va3_1 a4_2 va5_1 va1_1 a10_2 a9_2 a1_2 vsp_1 va0_1 vzero_1 a7_2 va6_1 a3_2 va4_1
degree : 13
Alias :None
Color : null
Priority : 0
------
========main move List Info ========
coalesced moves:
va4_1 = move a5_2
va3_1 = move a4_2
va0_1 = move a1_2
------
constrained moves:
------
fronzen moves:
------
workList moves:
va6_1 = move a7_2
t_12 = move t_11
va7_1 = move a8_2
va2_1 = move a3_2
va1_1 = move a2_2
va5_1 = move a6_2
------
active moves:
========main Node List Info ========
simplify Nodes(low degree non move related):

------
freeze Nodes(low degree move related):
a8_2(0) a2_2(0) a7_2(0) a6_2(0) a3_2(0) t_11(0) t_12(0) 
------
spill Nodes(high degree):

------
spilled Nodes:

------
coalesced Nodes:
a5_2(0) a4_2(0) a1_2(0) 
------
colored Nodes:

------
selected Stack:
a10_2(0) a9_2(0) 
------

===================== Coalesce =====================
========main Graph Info ========
a2_2:
AdjList :  a5_2 a6_2 va3_1 a4_2 a10_2 a9_2 a1_2 vsp_1 va0_1 vzero_1 a8_2 a7_2 va6_1 a3_2 va4_1
degree : 9
Alias :None
Color : null
Priority : 0
------
a1_2:
AdjList :  a5_2 a2_2 a6_2 va3_1 a4_2 a10_2 a9_2 vsp_1 vzero_1 a8_2 a7_2 a3_2 va4_1
degree : 9
Alias :va0_1
Color : null
Priority : 0
------
a10_2:
AdjList :  va2_1 a5_2 a2_2 a6_2 va3_1 a4_2 va5_1 va1_1 a9_2 a1_2 vsp_1 va0_1 vzero_1 a8_2 a7_2 va6_1 a3_2 va7_1 va4_1
degree : 19
Alias :None
Color : null
Priority : 0
------
a7_2:
AdjList :  va2_1 a5_2 a2_2 a6_2 va3_1 a4_2 va5_1 va1_1 a10_2 a9_2 a1_2 vsp_1 va0_1 vzero_1 a8_2 a3_2 va4_1
degree : 12
Alias :va6_1
Color : null
Priority : 0
------
a3_2:
AdjList :  a5_2 a2_2 a6_2 va3_1 a4_2 va1_1 a10_2 a9_2 a1_2 vsp_1 va0_1 vzero_1 a8_2 a7_2 va6_1 va4_1
degree : 10
Alias :None
Color : null
Priority : 0
------
t_11:
AdjList :  va2_1 va3_1 vt2_1 va5_1 vt5_1 va1_1 vsp_1 va0_1 vzero_1 vra_1 va6_1 vt0_1 vt6_1 va7_1 va4_1 vt1_1 vt3_1 vt4_1
degree : 18
Alias :None
Color : null
Priority : 0
------
t_12:
AdjList :  vsp_1 vzero_1
degree : 2
Alias :None
Color : null
Priority : 0
------
a5_2:
AdjList :  va2_1 a2_2 a6_2 va3_1 a4_2 va1_1 a10_2 a9_2 a1_2 vsp_1 va0_1 vzero_1 a8_2 a7_2 a3_2
degree : 13
Alias :va4_1
Color : null
Priority : 0
------
a6_2:
AdjList :  va2_1 a5_2 a2_2 va3_1 a4_2 va1_1 a10_2 a9_2 a1_2 vsp_1 va0_1 vzero_1 a8_2 a7_2 va6_1 a3_2 va4_1
degree : 11
Alias :None
Color : null
Priority : 0
------
a4_2:
AdjList :  va2_1 a5_2 a2_2 a6_2 va1_1 a10_2 a9_2 a1_2 vsp_1 va0_1 vzero_1 a8_2 a7_2 a3_2 va4_1
degree : 12
Alias :va3_1
Color : null
Priority : 0
------
a9_2:
AdjList :  va2_1 a5_2 a2_2 a6_2 va3_1 a4_2 va5_1 va1_1 a10_2 a1_2 vsp_1 va0_1 vzero_1 a8_2 a7_2 va6_1 a3_2 va7_1 va4_1
degree : 18
Alias :None
Color : null
Priority : 0
------
a8_2:
AdjList :  va2_1 a5_2 a2_2 a6_2 va3_1 a4_2 va5_1 va1_1 a10_2 a9_2 a1_2 vsp_1 va0_1 vzero_1 a7_2 va6_1 a3_2 va4_1
degree : 12
Alias :None
Color : null
Priority : 0
------
========main move List Info ========
coalesced moves:
va4_1 = move a5_2
va3_1 = move a4_2
va0_1 = move a1_2
va6_1 = move a7_2
------
constrained moves:
------
fronzen moves:
------
workList moves:
t_12 = move t_11
va7_1 = move a8_2
va2_1 = move a3_2
va1_1 = move a2_2
va5_1 = move a6_2
------
active moves:
========main Node List Info ========
simplify Nodes(low degree non move related):

------
freeze Nodes(low degree move related):
a8_2(0) a2_2(0) a6_2(0) a3_2(0) t_11(0) t_12(0) 
------
spill Nodes(high degree):

------
spilled Nodes:

------
coalesced Nodes:
a5_2(0) a7_2(0) a4_2(0) a1_2(0) 
------
colored Nodes:

------
selected Stack:
a10_2(0) a9_2(0) 
------

===================== Coalesce =====================
========main Graph Info ========
a2_2:
AdjList :  a5_2 a6_2 va3_1 a4_2 a10_2 a9_2 a1_2 vsp_1 va0_1 vzero_1 a8_2 a7_2 va6_1 a3_2 va4_1
degree : 9
Alias :None
Color : null
Priority : 0
------
a1_2:
AdjList :  a5_2 a2_2 a6_2 va3_1 a4_2 a10_2 a9_2 vsp_1 vzero_1 a8_2 a7_2 a3_2 va4_1
degree : 9
Alias :va0_1
Color : null
Priority : 0
------
a10_2:
AdjList :  va2_1 a5_2 a2_2 a6_2 va3_1 a4_2 va5_1 va1_1 a9_2 a1_2 vsp_1 va0_1 vzero_1 a8_2 a7_2 va6_1 a3_2 va7_1 va4_1
degree : 19
Alias :None
Color : null
Priority : 0
------
a7_2:
AdjList :  va2_1 a5_2 a2_2 a6_2 va3_1 a4_2 va5_1 va1_1 a10_2 a9_2 a1_2 vsp_1 va0_1 vzero_1 a8_2 a3_2 va4_1
degree : 12
Alias :va6_1
Color : null
Priority : 0
------
a3_2:
AdjList :  a5_2 a2_2 a6_2 va3_1 a4_2 va1_1 a10_2 a9_2 a1_2 vsp_1 va0_1 vzero_1 a8_2 a7_2 va6_1 va4_1
degree : 10
Alias :None
Color : null
Priority : 0
------
t_11:
AdjList :  va2_1 va3_1 vt2_1 va5_1 vt5_1 va1_1 vsp_1 va0_1 vzero_1 vra_1 va6_1 vt0_1 vt6_1 va7_1 va4_1 vt1_1 vt3_1 vt4_1
degree : 18
Alias :t_12
Color : null
Priority : 0
------
t_12:
AdjList :  va2_1 va3_1 vt2_1 va5_1 vt5_1 va1_1 vsp_1 vzero_1 va0_1 vra_1 va6_1 vt0_1 vt6_1 va7_1 va4_1 vt1_1 vt3_1 vt4_1
degree : 18
Alias :None
Color : null
Priority : 0
------
a5_2:
AdjList :  va2_1 a2_2 a6_2 va3_1 a4_2 va1_1 a10_2 a9_2 a1_2 vsp_1 va0_1 vzero_1 a8_2 a7_2 a3_2
degree : 13
Alias :va4_1
Color : null
Priority : 0
------
a6_2:
AdjList :  va2_1 a5_2 a2_2 va3_1 a4_2 va1_1 a10_2 a9_2 a1_2 vsp_1 va0_1 vzero_1 a8_2 a7_2 va6_1 a3_2 va4_1
degree : 11
Alias :None
Color : null
Priority : 0
------
a4_2:
AdjList :  va2_1 a5_2 a2_2 a6_2 va1_1 a10_2 a9_2 a1_2 vsp_1 va0_1 vzero_1 a8_2 a7_2 a3_2 va4_1
degree : 12
Alias :va3_1
Color : null
Priority : 0
------
a9_2:
AdjList :  va2_1 a5_2 a2_2 a6_2 va3_1 a4_2 va5_1 va1_1 a10_2 a1_2 vsp_1 va0_1 vzero_1 a8_2 a7_2 va6_1 a3_2 va7_1 va4_1
degree : 18
Alias :None
Color : null
Priority : 0
------
a8_2:
AdjList :  va2_1 a5_2 a2_2 a6_2 va3_1 a4_2 va5_1 va1_1 a10_2 a9_2 a1_2 vsp_1 va0_1 vzero_1 a7_2 va6_1 a3_2 va4_1
degree : 12
Alias :None
Color : null
Priority : 0
------
========main move List Info ========
coalesced moves:
va4_1 = move a5_2
va3_1 = move a4_2
va0_1 = move a1_2
va6_1 = move a7_2
t_12 = move t_11
------
constrained moves:
------
fronzen moves:
------
workList moves:
va7_1 = move a8_2
va2_1 = move a3_2
va1_1 = move a2_2
va5_1 = move a6_2
------
active moves:
========main Node List Info ========
simplify Nodes(low degree non move related):
t_12(0) 
------
freeze Nodes(low degree move related):
a8_2(0) a2_2(0) a6_2(0) a3_2(0) 
------
spill Nodes(high degree):

------
spilled Nodes:

------
coalesced Nodes:
a5_2(0) a7_2(0) a4_2(0) t_11(0) a1_2(0) 
------
colored Nodes:

------
selected Stack:
a10_2(0) a9_2(0) 
------

===================== Simplify =====================
========main Graph Info ========
a2_2:
AdjList :  a5_2 a6_2 va3_1 a4_2 a10_2 a9_2 a1_2 vsp_1 va0_1 vzero_1 a8_2 a7_2 va6_1 a3_2 va4_1
degree : 9
Alias :None
Color : null
Priority : 0
------
a1_2:
AdjList :  a5_2 a2_2 a6_2 va3_1 a4_2 a10_2 a9_2 vsp_1 vzero_1 a8_2 a7_2 a3_2 va4_1
degree : 9
Alias :va0_1
Color : null
Priority : 0
------
a10_2:
AdjList :  va2_1 a5_2 a2_2 a6_2 va3_1 a4_2 va5_1 va1_1 a9_2 a1_2 vsp_1 va0_1 vzero_1 a8_2 a7_2 va6_1 a3_2 va7_1 va4_1
degree : 19
Alias :None
Color : null
Priority : 0
------
a7_2:
AdjList :  va2_1 a5_2 a2_2 a6_2 va3_1 a4_2 va5_1 va1_1 a10_2 a9_2 a1_2 vsp_1 va0_1 vzero_1 a8_2 a3_2 va4_1
degree : 12
Alias :va6_1
Color : null
Priority : 0
------
a3_2:
AdjList :  a5_2 a2_2 a6_2 va3_1 a4_2 va1_1 a10_2 a9_2 a1_2 vsp_1 va0_1 vzero_1 a8_2 a7_2 va6_1 va4_1
degree : 10
Alias :None
Color : null
Priority : 0
------
t_11:
AdjList :  va2_1 va3_1 vt2_1 va5_1 vt5_1 va1_1 vsp_1 va0_1 vzero_1 vra_1 va6_1 vt0_1 vt6_1 va7_1 va4_1 vt1_1 vt3_1 vt4_1
degree : 18
Alias :t_12
Color : null
Priority : 0
------
t_12:
AdjList :  va2_1 va3_1 vt2_1 va5_1 vt5_1 va1_1 vsp_1 vzero_1 va0_1 vra_1 va6_1 vt0_1 vt6_1 va7_1 va4_1 vt1_1 vt3_1 vt4_1
degree : 18
Alias :None
Color : null
Priority : 0
------
a5_2:
AdjList :  va2_1 a2_2 a6_2 va3_1 a4_2 va1_1 a10_2 a9_2 a1_2 vsp_1 va0_1 vzero_1 a8_2 a7_2 a3_2
degree : 13
Alias :va4_1
Color : null
Priority : 0
------
a6_2:
AdjList :  va2_1 a5_2 a2_2 va3_1 a4_2 va1_1 a10_2 a9_2 a1_2 vsp_1 va0_1 vzero_1 a8_2 a7_2 va6_1 a3_2 va4_1
degree : 11
Alias :None
Color : null
Priority : 0
------
a4_2:
AdjList :  va2_1 a5_2 a2_2 a6_2 va1_1 a10_2 a9_2 a1_2 vsp_1 va0_1 vzero_1 a8_2 a7_2 a3_2 va4_1
degree : 12
Alias :va3_1
Color : null
Priority : 0
------
a9_2:
AdjList :  va2_1 a5_2 a2_2 a6_2 va3_1 a4_2 va5_1 va1_1 a10_2 a1_2 vsp_1 va0_1 vzero_1 a8_2 a7_2 va6_1 a3_2 va7_1 va4_1
degree : 18
Alias :None
Color : null
Priority : 0
------
a8_2:
AdjList :  va2_1 a5_2 a2_2 a6_2 va3_1 a4_2 va5_1 va1_1 a10_2 a9_2 a1_2 vsp_1 va0_1 vzero_1 a7_2 va6_1 a3_2 va4_1
degree : 12
Alias :None
Color : null
Priority : 0
------
========main move List Info ========
coalesced moves:
va4_1 = move a5_2
va3_1 = move a4_2
va0_1 = move a1_2
va6_1 = move a7_2
t_12 = move t_11
------
constrained moves:
------
fronzen moves:
------
workList moves:
va7_1 = move a8_2
va2_1 = move a3_2
va1_1 = move a2_2
va5_1 = move a6_2
------
active moves:
========main Node List Info ========
simplify Nodes(low degree non move related):

------
freeze Nodes(low degree move related):
a8_2(0) a2_2(0) a6_2(0) a3_2(0) 
------
spill Nodes(high degree):

------
spilled Nodes:

------
coalesced Nodes:
a5_2(0) a7_2(0) a4_2(0) t_11(0) a1_2(0) 
------
colored Nodes:

------
selected Stack:
t_12(0) a10_2(0) a9_2(0) 
------

===================== Coalesce =====================
========main Graph Info ========
a2_2:
AdjList :  a5_2 a6_2 va3_1 a4_2 a10_2 a9_2 a1_2 vsp_1 va0_1 vzero_1 a8_2 a7_2 va6_1 a3_2 va7_1 va4_1
degree : 9
Alias :None
Color : null
Priority : 0
------
a1_2:
AdjList :  a5_2 a2_2 a6_2 va3_1 a4_2 a10_2 a9_2 vsp_1 vzero_1 a8_2 a7_2 a3_2 va4_1
degree : 9
Alias :va0_1
Color : null
Priority : 0
------
a10_2:
AdjList :  va2_1 a5_2 a2_2 a6_2 va3_1 a4_2 va5_1 va1_1 a9_2 a1_2 vsp_1 va0_1 vzero_1 a8_2 a7_2 va6_1 a3_2 va7_1 va4_1
degree : 19
Alias :None
Color : null
Priority : 0
------
a7_2:
AdjList :  va2_1 a5_2 a2_2 a6_2 va3_1 a4_2 va5_1 va1_1 a10_2 a9_2 a1_2 vsp_1 va0_1 vzero_1 a8_2 a3_2 va4_1
degree : 12
Alias :va6_1
Color : null
Priority : 0
------
a3_2:
AdjList :  a5_2 a2_2 a6_2 va3_1 a4_2 va1_1 a10_2 a9_2 a1_2 vsp_1 va0_1 vzero_1 a8_2 a7_2 va6_1 va7_1 va4_1
degree : 10
Alias :None
Color : null
Priority : 0
------
t_11:
AdjList :  va2_1 va3_1 vt2_1 va5_1 vt5_1 va1_1 vsp_1 va0_1 vzero_1 vra_1 va6_1 vt0_1 vt6_1 va7_1 va4_1 vt1_1 vt3_1 vt4_1
degree : 18
Alias :t_12
Color : null
Priority : 0
------
t_12:
AdjList :  va2_1 va3_1 vt2_1 va5_1 vt5_1 va1_1 vsp_1 vzero_1 va0_1 vra_1 va6_1 vt0_1 vt6_1 va7_1 va4_1 vt1_1 vt3_1 vt4_1
degree : 18
Alias :None
Color : null
Priority : 0
------
a5_2:
AdjList :  va2_1 a2_2 a6_2 va3_1 a4_2 va1_1 a10_2 a9_2 a1_2 vsp_1 va0_1 vzero_1 a8_2 a7_2 a3_2
degree : 13
Alias :va4_1
Color : null
Priority : 0
------
a6_2:
AdjList :  va2_1 a5_2 a2_2 va3_1 a4_2 va1_1 a10_2 a9_2 a1_2 vsp_1 va0_1 vzero_1 a8_2 a7_2 va6_1 a3_2 va7_1 va4_1
degree : 11
Alias :None
Color : null
Priority : 0
------
a4_2:
AdjList :  va2_1 a5_2 a2_2 a6_2 va1_1 a10_2 a9_2 a1_2 vsp_1 va0_1 vzero_1 a8_2 a7_2 a3_2 va4_1
degree : 12
Alias :va3_1
Color : null
Priority : 0
------
a9_2:
AdjList :  va2_1 a5_2 a2_2 a6_2 va3_1 a4_2 va5_1 va1_1 a10_2 a1_2 vsp_1 va0_1 vzero_1 a8_2 a7_2 va6_1 a3_2 va7_1 va4_1
degree : 18
Alias :None
Color : null
Priority : 0
------
a8_2:
AdjList :  va2_1 a5_2 a2_2 a6_2 va3_1 a4_2 va5_1 va1_1 a10_2 a9_2 a1_2 vsp_1 va0_1 vzero_1 a7_2 va6_1 a3_2 va4_1
degree : 12
Alias :va7_1
Color : null
Priority : 0
------
========main move List Info ========
coalesced moves:
va4_1 = move a5_2
va3_1 = move a4_2
va0_1 = move a1_2
va6_1 = move a7_2
t_12 = move t_11
va7_1 = move a8_2
------
constrained moves:
------
fronzen moves:
------
workList moves:
va2_1 = move a3_2
va1_1 = move a2_2
va5_1 = move a6_2
------
active moves:
========main Node List Info ========
simplify Nodes(low degree non move related):

------
freeze Nodes(low degree move related):
a2_2(0) a6_2(0) a3_2(0) 
------
spill Nodes(high degree):

------
spilled Nodes:

------
coalesced Nodes:
a5_2(0) a8_2(0) a7_2(0) a4_2(0) t_11(0) a1_2(0) 
------
colored Nodes:

------
selected Stack:
t_12(0) a10_2(0) a9_2(0) 
------

===================== Coalesce =====================
========main Graph Info ========
a2_2:
AdjList :  va2_1 a5_2 a6_2 va3_1 a4_2 a10_2 a9_2 a1_2 vsp_1 va0_1 vzero_1 a8_2 a7_2 va6_1 a3_2 va7_1 va4_1
degree : 9
Alias :None
Color : null
Priority : 0
------
a1_2:
AdjList :  a5_2 a2_2 a6_2 va3_1 a4_2 a10_2 a9_2 vsp_1 vzero_1 a8_2 a7_2 a3_2 va4_1
degree : 9
Alias :va0_1
Color : null
Priority : 0
------
a10_2:
AdjList :  va2_1 a5_2 a2_2 a6_2 va3_1 a4_2 va5_1 va1_1 a9_2 a1_2 vsp_1 va0_1 vzero_1 a8_2 a7_2 va6_1 a3_2 va7_1 va4_1
degree : 19
Alias :None
Color : null
Priority : 0
------
a7_2:
AdjList :  va2_1 a5_2 a2_2 a6_2 va3_1 a4_2 va5_1 va1_1 a10_2 a9_2 a1_2 vsp_1 va0_1 vzero_1 a8_2 a3_2 va4_1
degree : 12
Alias :va6_1
Color : null
Priority : 0
------
a3_2:
AdjList :  a5_2 a2_2 a6_2 va3_1 a4_2 va1_1 a10_2 a9_2 a1_2 vsp_1 va0_1 vzero_1 a8_2 a7_2 va6_1 va7_1 va4_1
degree : 10
Alias :va2_1
Color : null
Priority : 0
------
t_11:
AdjList :  va2_1 va3_1 vt2_1 va5_1 vt5_1 va1_1 vsp_1 va0_1 vzero_1 vra_1 va6_1 vt0_1 vt6_1 va7_1 va4_1 vt1_1 vt3_1 vt4_1
degree : 18
Alias :t_12
Color : null
Priority : 0
------
t_12:
AdjList :  va2_1 va3_1 vt2_1 va5_1 vt5_1 va1_1 vsp_1 vzero_1 va0_1 vra_1 va6_1 vt0_1 vt6_1 va7_1 va4_1 vt1_1 vt3_1 vt4_1
degree : 18
Alias :None
Color : null
Priority : 0
------
a5_2:
AdjList :  va2_1 a2_2 a6_2 va3_1 a4_2 va1_1 a10_2 a9_2 a1_2 vsp_1 va0_1 vzero_1 a8_2 a7_2 a3_2
degree : 13
Alias :va4_1
Color : null
Priority : 0
------
a6_2:
AdjList :  va2_1 a5_2 a2_2 va3_1 a4_2 va1_1 a10_2 a9_2 a1_2 vsp_1 va0_1 vzero_1 a8_2 a7_2 va6_1 a3_2 va7_1 va4_1
degree : 10
Alias :None
Color : null
Priority : 0
------
a4_2:
AdjList :  va2_1 a5_2 a2_2 a6_2 va1_1 a10_2 a9_2 a1_2 vsp_1 va0_1 vzero_1 a8_2 a7_2 a3_2 va4_1
degree : 12
Alias :va3_1
Color : null
Priority : 0
------
a9_2:
AdjList :  va2_1 a5_2 a2_2 a6_2 va3_1 a4_2 va5_1 va1_1 a10_2 a1_2 vsp_1 va0_1 vzero_1 a8_2 a7_2 va6_1 a3_2 va7_1 va4_1
degree : 18
Alias :None
Color : null
Priority : 0
------
a8_2:
AdjList :  va2_1 a5_2 a2_2 a6_2 va3_1 a4_2 va5_1 va1_1 a10_2 a9_2 a1_2 vsp_1 va0_1 vzero_1 a7_2 va6_1 a3_2 va4_1
degree : 12
Alias :va7_1
Color : null
Priority : 0
------
========main move List Info ========
coalesced moves:
va4_1 = move a5_2
va3_1 = move a4_2
va0_1 = move a1_2
va6_1 = move a7_2
t_12 = move t_11
va7_1 = move a8_2
va2_1 = move a3_2
------
constrained moves:
------
fronzen moves:
------
workList moves:
va1_1 = move a2_2
va5_1 = move a6_2
------
active moves:
========main Node List Info ========
simplify Nodes(low degree non move related):

------
freeze Nodes(low degree move related):
a2_2(0) a6_2(0) 
------
spill Nodes(high degree):

------
spilled Nodes:

------
coalesced Nodes:
a5_2(0) a8_2(0) a7_2(0) a4_2(0) t_11(0) a3_2(0) a1_2(0) 
------
colored Nodes:

------
selected Stack:
t_12(0) a10_2(0) a9_2(0) 
------

===================== Coalesce =====================
========main Graph Info ========
a2_2:
AdjList :  va2_1 a5_2 a6_2 va3_1 a4_2 a10_2 a9_2 a1_2 vsp_1 va0_1 vzero_1 a8_2 a7_2 va6_1 a3_2 va7_1 va4_1
degree : 9
Alias :va1_1
Color : null
Priority : 0
------
a1_2:
AdjList :  a5_2 a2_2 a6_2 va3_1 a4_2 a10_2 a9_2 vsp_1 vzero_1 a8_2 a7_2 a3_2 va4_1
degree : 9
Alias :va0_1
Color : null
Priority : 0
------
a10_2:
AdjList :  va2_1 a5_2 a2_2 a6_2 va3_1 a4_2 va5_1 va1_1 a9_2 a1_2 vsp_1 va0_1 vzero_1 a8_2 a7_2 va6_1 a3_2 va7_1 va4_1
degree : 19
Alias :None
Color : null
Priority : 0
------
a7_2:
AdjList :  va2_1 a5_2 a2_2 a6_2 va3_1 a4_2 va5_1 va1_1 a10_2 a9_2 a1_2 vsp_1 va0_1 vzero_1 a8_2 a3_2 va4_1
degree : 12
Alias :va6_1
Color : null
Priority : 0
------
a3_2:
AdjList :  a5_2 a2_2 a6_2 va3_1 a4_2 va1_1 a10_2 a9_2 a1_2 vsp_1 va0_1 vzero_1 a8_2 a7_2 va6_1 va7_1 va4_1
degree : 10
Alias :va2_1
Color : null
Priority : 0
------
t_11:
AdjList :  va2_1 va3_1 vt2_1 va5_1 vt5_1 va1_1 vsp_1 va0_1 vzero_1 vra_1 va6_1 vt0_1 vt6_1 va7_1 va4_1 vt1_1 vt3_1 vt4_1
degree : 18
Alias :t_12
Color : null
Priority : 0
------
t_12:
AdjList :  va2_1 va3_1 vt2_1 va5_1 vt5_1 va1_1 vsp_1 vzero_1 va0_1 vra_1 va6_1 vt0_1 vt6_1 va7_1 va4_1 vt1_1 vt3_1 vt4_1
degree : 18
Alias :None
Color : null
Priority : 0
------
a5_2:
AdjList :  va2_1 a2_2 a6_2 va3_1 a4_2 va1_1 a10_2 a9_2 a1_2 vsp_1 va0_1 vzero_1 a8_2 a7_2 a3_2
degree : 13
Alias :va4_1
Color : null
Priority : 0
------
a6_2:
AdjList :  va2_1 a5_2 a2_2 va3_1 a4_2 va1_1 a10_2 a9_2 a1_2 vsp_1 va0_1 vzero_1 a8_2 a7_2 va6_1 a3_2 va7_1 va4_1
degree : 9
Alias :None
Color : null
Priority : 0
------
a4_2:
AdjList :  va2_1 a5_2 a2_2 a6_2 va1_1 a10_2 a9_2 a1_2 vsp_1 va0_1 vzero_1 a8_2 a7_2 a3_2 va4_1
degree : 12
Alias :va3_1
Color : null
Priority : 0
------
a9_2:
AdjList :  va2_1 a5_2 a2_2 a6_2 va3_1 a4_2 va5_1 va1_1 a10_2 a1_2 vsp_1 va0_1 vzero_1 a8_2 a7_2 va6_1 a3_2 va7_1 va4_1
degree : 18
Alias :None
Color : null
Priority : 0
------
a8_2:
AdjList :  va2_1 a5_2 a2_2 a6_2 va3_1 a4_2 va5_1 va1_1 a10_2 a9_2 a1_2 vsp_1 va0_1 vzero_1 a7_2 va6_1 a3_2 va4_1
degree : 12
Alias :va7_1
Color : null
Priority : 0
------
========main move List Info ========
coalesced moves:
va4_1 = move a5_2
va3_1 = move a4_2
va0_1 = move a1_2
va6_1 = move a7_2
t_12 = move t_11
va7_1 = move a8_2
va2_1 = move a3_2
va1_1 = move a2_2
------
constrained moves:
------
fronzen moves:
------
workList moves:
va5_1 = move a6_2
------
active moves:
========main Node List Info ========
simplify Nodes(low degree non move related):

------
freeze Nodes(low degree move related):
a6_2(0) 
------
spill Nodes(high degree):

------
spilled Nodes:

------
coalesced Nodes:
a5_2(0) a8_2(0) a2_2(0) a7_2(0) a4_2(0) t_11(0) a3_2(0) a1_2(0) 
------
colored Nodes:

------
selected Stack:
t_12(0) a10_2(0) a9_2(0) 
------

===================== Coalesce =====================
========main Graph Info ========
a2_2:
AdjList :  va2_1 a5_2 a6_2 va3_1 a4_2 a10_2 a9_2 a1_2 vsp_1 va0_1 vzero_1 a8_2 a7_2 va6_1 a3_2 va7_1 va4_1
degree : 9
Alias :va1_1
Color : null
Priority : 0
------
a1_2:
AdjList :  a5_2 a2_2 a6_2 va3_1 a4_2 a10_2 a9_2 vsp_1 vzero_1 a8_2 a7_2 a3_2 va4_1
degree : 9
Alias :va0_1
Color : null
Priority : 0
------
a10_2:
AdjList :  va2_1 a5_2 a2_2 a6_2 va3_1 a4_2 va5_1 va1_1 a9_2 a1_2 vsp_1 va0_1 vzero_1 a8_2 a7_2 va6_1 a3_2 va7_1 va4_1
degree : 19
Alias :None
Color : null
Priority : 0
------
a7_2:
AdjList :  va2_1 a5_2 a2_2 a6_2 va3_1 a4_2 va5_1 va1_1 a10_2 a9_2 a1_2 vsp_1 va0_1 vzero_1 a8_2 a3_2 va4_1
degree : 12
Alias :va6_1
Color : null
Priority : 0
------
a3_2:
AdjList :  a5_2 a2_2 a6_2 va3_1 a4_2 va1_1 a10_2 a9_2 a1_2 vsp_1 va0_1 vzero_1 a8_2 a7_2 va6_1 va7_1 va4_1
degree : 10
Alias :va2_1
Color : null
Priority : 0
------
t_11:
AdjList :  va2_1 va3_1 vt2_1 va5_1 vt5_1 va1_1 vsp_1 va0_1 vzero_1 vra_1 va6_1 vt0_1 vt6_1 va7_1 va4_1 vt1_1 vt3_1 vt4_1
degree : 18
Alias :t_12
Color : null
Priority : 0
------
t_12:
AdjList :  va2_1 va3_1 vt2_1 va5_1 vt5_1 va1_1 vsp_1 vzero_1 va0_1 vra_1 va6_1 vt0_1 vt6_1 va7_1 va4_1 vt1_1 vt3_1 vt4_1
degree : 18
Alias :None
Color : null
Priority : 0
------
a5_2:
AdjList :  va2_1 a2_2 a6_2 va3_1 a4_2 va1_1 a10_2 a9_2 a1_2 vsp_1 va0_1 vzero_1 a8_2 a7_2 a3_2
degree : 13
Alias :va4_1
Color : null
Priority : 0
------
a6_2:
AdjList :  va2_1 a5_2 a2_2 va3_1 a4_2 va1_1 a10_2 a9_2 a1_2 vsp_1 va0_1 vzero_1 a8_2 a7_2 va6_1 a3_2 va7_1 va4_1
degree : 9
Alias :va5_1
Color : null
Priority : 0
------
a4_2:
AdjList :  va2_1 a5_2 a2_2 a6_2 va1_1 a10_2 a9_2 a1_2 vsp_1 va0_1 vzero_1 a8_2 a7_2 a3_2 va4_1
degree : 12
Alias :va3_1
Color : null
Priority : 0
------
a9_2:
AdjList :  va2_1 a5_2 a2_2 a6_2 va3_1 a4_2 va5_1 va1_1 a10_2 a1_2 vsp_1 va0_1 vzero_1 a8_2 a7_2 va6_1 a3_2 va7_1 va4_1
degree : 18
Alias :None
Color : null
Priority : 0
------
a8_2:
AdjList :  va2_1 a5_2 a2_2 a6_2 va3_1 a4_2 va5_1 va1_1 a10_2 a9_2 a1_2 vsp_1 va0_1 vzero_1 a7_2 va6_1 a3_2 va4_1
degree : 12
Alias :va7_1
Color : null
Priority : 0
------
========main move List Info ========
coalesced moves:
va4_1 = move a5_2
va3_1 = move a4_2
va0_1 = move a1_2
va6_1 = move a7_2
t_12 = move t_11
va7_1 = move a8_2
va2_1 = move a3_2
va1_1 = move a2_2
va5_1 = move a6_2
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
a5_2(0) a8_2(0) a2_2(0) a7_2(0) a6_2(0) a4_2(0) t_11(0) a3_2(0) a1_2(0) 
------
colored Nodes:

------
selected Stack:
t_12(0) a10_2(0) a9_2(0) 
------

===================== after ASSIGN =====================
========main Graph Info ========
a2_2:
AdjList :  va2_1 a5_2 a6_2 va3_1 a4_2 a10_2 a9_2 a1_2 vsp_1 va0_1 vzero_1 a8_2 a7_2 va6_1 a3_2 va7_1 va4_1
degree : 9
Alias :va1_1
Color : a1
Priority : 0
------
a1_2:
AdjList :  a5_2 a2_2 a6_2 va3_1 a4_2 a10_2 a9_2 vsp_1 vzero_1 a8_2 a7_2 a3_2 va4_1
degree : 9
Alias :va0_1
Color : a0
Priority : 0
------
a10_2:
AdjList :  va2_1 a5_2 a2_2 a6_2 va3_1 a4_2 va5_1 va1_1 a9_2 a1_2 vsp_1 va0_1 vzero_1 a8_2 a7_2 va6_1 a3_2 va7_1 va4_1
degree : 19
Alias :None
Color : s2
Priority : 0
------
a7_2:
AdjList :  va2_1 a5_2 a2_2 a6_2 va3_1 a4_2 va5_1 va1_1 a10_2 a9_2 a1_2 vsp_1 va0_1 vzero_1 a8_2 a3_2 va4_1
degree : 12
Alias :va6_1
Color : a6
Priority : 0
------
a3_2:
AdjList :  a5_2 a2_2 a6_2 va3_1 a4_2 va1_1 a10_2 a9_2 a1_2 vsp_1 va0_1 vzero_1 a8_2 a7_2 va6_1 va7_1 va4_1
degree : 10
Alias :va2_1
Color : a2
Priority : 0
------
t_11:
AdjList :  va2_1 va3_1 vt2_1 va5_1 vt5_1 va1_1 vsp_1 va0_1 vzero_1 vra_1 va6_1 vt0_1 vt6_1 va7_1 va4_1 vt1_1 vt3_1 vt4_1
degree : 18
Alias :t_12
Color : s6
Priority : 0
------
t_12:
AdjList :  va2_1 va3_1 vt2_1 va5_1 vt5_1 va1_1 vsp_1 vzero_1 va0_1 vra_1 va6_1 vt0_1 vt6_1 va7_1 va4_1 vt1_1 vt3_1 vt4_1
degree : 18
Alias :None
Color : s6
Priority : 0
------
a5_2:
AdjList :  va2_1 a2_2 a6_2 va3_1 a4_2 va1_1 a10_2 a9_2 a1_2 vsp_1 va0_1 vzero_1 a8_2 a7_2 a3_2
degree : 13
Alias :va4_1
Color : a4
Priority : 0
------
a6_2:
AdjList :  va2_1 a5_2 a2_2 va3_1 a4_2 va1_1 a10_2 a9_2 a1_2 vsp_1 va0_1 vzero_1 a8_2 a7_2 va6_1 a3_2 va7_1 va4_1
degree : 9
Alias :va5_1
Color : a5
Priority : 0
------
a4_2:
AdjList :  va2_1 a5_2 a2_2 a6_2 va1_1 a10_2 a9_2 a1_2 vsp_1 va0_1 vzero_1 a8_2 a7_2 a3_2 va4_1
degree : 12
Alias :va3_1
Color : a3
Priority : 0
------
a9_2:
AdjList :  va2_1 a5_2 a2_2 a6_2 va3_1 a4_2 va5_1 va1_1 a10_2 a1_2 vsp_1 va0_1 vzero_1 a8_2 a7_2 va6_1 a3_2 va7_1 va4_1
degree : 18
Alias :None
Color : s6
Priority : 0
------
a8_2:
AdjList :  va2_1 a5_2 a2_2 a6_2 va3_1 a4_2 va5_1 va1_1 a10_2 a9_2 a1_2 vsp_1 va0_1 vzero_1 a7_2 va6_1 a3_2 va4_1
degree : 12
Alias :va7_1
Color : a7
Priority : 0
------
========main move List Info ========
coalesced moves:
va4_1 = move a5_2
va3_1 = move a4_2
va0_1 = move a1_2
va6_1 = move a7_2
t_12 = move t_11
va7_1 = move a8_2
va2_1 = move a3_2
va1_1 = move a2_2
va5_1 = move a6_2
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
a5_2(0) a8_2(0) a2_2(0) a7_2(0) a6_2(0) a4_2(0) t_11(0) a3_2(0) a1_2(0) 
------
colored Nodes:
t_12(0) a9_2(0) a10_2(0) 
------
selected Stack:

------

=====================__init Iteration 0=====================
========__init Graph Info ========
t_13:
AdjList :  va2_1 va3_1 vt2_1 va5_1 vt5_1 va1_1 vsp_1 va0_1 vzero_1 vra_1 va6_1 vt0_1 vt6_1 va7_1 va4_1 vt1_1 vt3_1 vt4_1
degree : 18
Alias :None
Color : null
Priority : 0
------
t_14:
AdjList :  vsp_1 vzero_1
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
t_14 = move t_13
------
active moves:
========__init Node List Info ========
simplify Nodes(low degree non move related):

------
freeze Nodes(low degree move related):
t_14(0) t_13(0) 
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

define i64 @func  %a1_1 %a2_1 %a3_1 %a4_1 %a5_1 %a6_1 %a7_1 %a8_1 %a9_1 %a10_1 {
func_entry_1:
   store %vs11_1 %vsp_1 null 0 44
   store %vs8_1 %vsp_1 null 0 40
   store %vs7_1 %vsp_1 null 0 36
   store %vs10_1 %vsp_1 null 0 32
   store %vs3_1 %vsp_1 null 0 28
   store %vs1_1 %vsp_1 null 0 24
   store %vs9_1 %vsp_1 null 0 20
   store %vs5_1 %vsp_1 null 0 16
   store %vs6_1 %vsp_1 null 0 12
   store %vs4_1 %vsp_1 null 0 8
   store %vs2_1 %vsp_1 null 0 4
   store %ra %vsp_1 null 0 0
   %a10_1 = load %vsp_1 null 0 4
   %a9_1 = load %vsp_1 null 0 0
   %a8_1 = move %va7_1
   %a7_1 = move %va6_1
   %a6_1 = move %va5_1
   %a5_1 = move %va4_1
   %a4_1 = move %va3_1
   %a3_1 = move %va2_1
   %a2_1 = move %va1_1
   %a1_1 = move %va0_1
   %t_1 = add %a1_1 %a2_1
   %t_2 = add %t_1 %a3_1
   %t_3 = add %t_2 %a4_1
   %t_4 = add %t_3 %a5_1
   %t_5 = add %t_4 %a6_1
   %t_6 = add %t_5 %a7_1
   %t_7 = add %t_6 %a8_1
   %t_8 = add %t_7 %a9_1
   %t_9 = add %t_8 %a10_1
   %t_10 = move %t_9
   %a0 = move %t_10
   %ra = load %vsp_1 null 0 0
   %vs2_1 = load %vsp_1 null 0 4
   %vs4_1 = load %vsp_1 null 0 8
   %vs6_1 = load %vsp_1 null 0 12
   %vs5_1 = load %vsp_1 null 0 16
   %vs9_1 = load %vsp_1 null 0 20
   %vs1_1 = load %vsp_1 null 0 24
   %vs3_1 = load %vsp_1 null 0 28
   %vs10_1 = load %vsp_1 null 0 32
   %vs7_1 = load %vsp_1 null 0 36
   %vs8_1 = load %vsp_1 null 0 40
   %vs11_1 = load %vsp_1 null 0 44
   ret %a0
}

define i64 @main  {
main_entry_1:
   store %vs11_1 %vsp_1 null 0 52
   store %vs8_1 %vsp_1 null 0 48
   store %vs7_1 %vsp_1 null 0 44
   store %vs10_1 %vsp_1 null 0 40
   store %vs3_1 %vsp_1 null 0 36
   store %vs1_1 %vsp_1 null 0 32
   store %vs9_1 %vsp_1 null 0 28
   store %vs5_1 %vsp_1 null 0 24
   store %vs6_1 %vsp_1 null 0 20
   store %vs4_1 %vsp_1 null 0 16
   store %vs2_1 %vsp_1 null 0 12
   store %ra %vsp_1 null 0 8
   %a1_2 = move 2
   %a2_2 = move 3
   %a3_2 = move 4
   %a4_2 = move 5
   %a5_2 = move 6
   %a6_2 = move 7
   %a7_2 = move 8
   %a8_2 = move 9
   %a9_2 = move 10
   %a10_2 = move 11
   store %a9_2 %vsp_1 null 0 0
   store %a10_2 %vsp_1 null 0 4
   %va0_1 = move %a1_2
   %va1_1 = move %a2_2
   %va2_1 = move %a3_2
   %va3_1 = move %a4_2
   %va4_1 = move %a5_2
   %va5_1 = move %a6_2
   %va6_1 = move %a7_2
   %va7_1 = move %a8_2
   %t_11 = call func %va0_1 %va1_1 %va2_1 %va3_1 %va4_1 %va5_1 %va6_1 %va7_1 %a9_2 %a10_2 
   %t_12 = move %t_11
   %a0 = move %t_12
   %ra = load %vsp_1 null 0 8
   %vs2_1 = load %vsp_1 null 0 12
   %vs4_1 = load %vsp_1 null 0 16
   %vs6_1 = load %vsp_1 null 0 20
   %vs5_1 = load %vsp_1 null 0 24
   %vs9_1 = load %vsp_1 null 0 28
   %vs1_1 = load %vsp_1 null 0 32
   %vs3_1 = load %vsp_1 null 0 36
   %vs10_1 = load %vsp_1 null 0 40
   %vs7_1 = load %vsp_1 null 0 44
   %vs8_1 = load %vsp_1 null 0 48
   %vs11_1 = load %vsp_1 null 0 52
   ret %a0
}

define i64 @__init  {
__init_entry_1:
   store %vs11_1 %vsp_1 null 0 44
   store %vs8_1 %vsp_1 null 0 40
   store %vs7_1 %vsp_1 null 0 36
   store %vs10_1 %vsp_1 null 0 32
   store %vs3_1 %vsp_1 null 0 28
   store %vs1_1 %vsp_1 null 0 24
   store %vs9_1 %vsp_1 null 0 20
   store %vs5_1 %vsp_1 null 0 16
   store %vs6_1 %vsp_1 null 0 12
   store %vs4_1 %vsp_1 null 0 8
   store %vs2_1 %vsp_1 null 0 4
   store %ra %vsp_1 null 0 0
   %t_13 = call main 
   %t_14 = move %t_13
   %a0 = move %t_14
   %ra = load %vsp_1 null 0 0
   %vs2_1 = load %vsp_1 null 0 4
   %vs4_1 = load %vsp_1 null 0 8
   %vs6_1 = load %vsp_1 null 0 12
   %vs5_1 = load %vsp_1 null 0 16
   %vs9_1 = load %vsp_1 null 0 20
   %vs1_1 = load %vsp_1 null 0 24
   %vs3_1 = load %vsp_1 null 0 28
   %vs10_1 = load %vsp_1 null 0 32
   %vs7_1 = load %vsp_1 null 0 36
   %vs8_1 = load %vsp_1 null 0 40
   %vs11_1 = load %vsp_1 null 0 44
   ret %a0
}

===================== Coalesce =====================
========__init Graph Info ========
t_13:
AdjList :  va2_1 va3_1 vt2_1 va5_1 vt5_1 va1_1 vsp_1 va0_1 vzero_1 vra_1 va6_1 vt0_1 vt6_1 va7_1 va4_1 vt1_1 vt3_1 vt4_1
degree : 18
Alias :t_14
Color : null
Priority : 0
------
t_14:
AdjList :  va2_1 va3_1 vt2_1 va5_1 vt5_1 va1_1 vsp_1 vzero_1 va0_1 vra_1 va6_1 vt0_1 vt6_1 va7_1 va4_1 vt1_1 vt3_1 vt4_1
degree : 18
Alias :None
Color : null
Priority : 0
------
========__init move List Info ========
coalesced moves:
t_14 = move t_13
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
t_14(0) 
------
freeze Nodes(low degree move related):

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

------

===================== Simplify =====================
========__init Graph Info ========
t_13:
AdjList :  va2_1 va3_1 vt2_1 va5_1 vt5_1 va1_1 vsp_1 va0_1 vzero_1 vra_1 va6_1 vt0_1 vt6_1 va7_1 va4_1 vt1_1 vt3_1 vt4_1
degree : 18
Alias :t_14
Color : null
Priority : 0
------
t_14:
AdjList :  va2_1 va3_1 vt2_1 va5_1 vt5_1 va1_1 vsp_1 vzero_1 va0_1 vra_1 va6_1 vt0_1 vt6_1 va7_1 va4_1 vt1_1 vt3_1 vt4_1
degree : 18
Alias :None
Color : null
Priority : 0
------
========__init move List Info ========
coalesced moves:
t_14 = move t_13
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
t_13(0) 
------
colored Nodes:

------
selected Stack:
t_14(0) 
------

===================== after ASSIGN =====================
========__init Graph Info ========
t_13:
AdjList :  va2_1 va3_1 vt2_1 va5_1 vt5_1 va1_1 vsp_1 va0_1 vzero_1 vra_1 va6_1 vt0_1 vt6_1 va7_1 va4_1 vt1_1 vt3_1 vt4_1
degree : 18
Alias :t_14
Color : s6
Priority : 0
------
t_14:
AdjList :  va2_1 va3_1 vt2_1 va5_1 vt5_1 va1_1 vsp_1 vzero_1 va0_1 vra_1 va6_1 vt0_1 vt6_1 va7_1 va4_1 vt1_1 vt3_1 vt4_1
degree : 18
Alias :None
Color : s6
Priority : 0
------
========__init move List Info ========
coalesced moves:
t_14 = move t_13
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
t_13(0) 
------
colored Nodes:
t_14(0) 
------
selected Stack:

------

