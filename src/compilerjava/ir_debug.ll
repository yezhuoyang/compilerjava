define i64 @main  {
main_entry_1:
   %t_1 = mul 10 8
   %t_1 = add %t_1 8
   %vrdi_1 = move %t_1
   %vrax_1 = alloc %vrdi_1
   %t_2 = move %vrax_1
   store 10 %t_2
   %t_3 = add %t_2 8
   %t_4 = add %t_2 %t_1
   jump main_for_cond_1
main_for_cond_1:
   %t_5 = slt %t_3 %t_4
   br %t_5 main_for_body_1 main_for_merge_1
main_for_body_1:
   %t_6 = mul 10 8
   %t_6 = add %t_6 8
   %vrdi_1 = move %t_6
   %vrax_1 = alloc %vrdi_1
   %t_7 = move %vrax_1
   store 10 %t_7
   store %t_7 %t_3
   %t_8 = add %t_7 8
   %t_9 = add %t_7 %t_6
   jump main_for_cond_2
main_for_cond_2:
   %t_10 = slt %t_8 %t_9
   br %t_10 main_for_body_2 main_for_merge_2
main_for_body_2:
   %t_11 = mul 10 8
   %t_11 = add %t_11 8
   %vrdi_1 = move %t_11
   %vrax_1 = alloc %vrdi_1
   %t_12 = move %vrax_1
   store 10 %t_12
   store %t_12 %t_8
   jump main_for_step_1
main_for_step_1:
   %t_13 = add %t_8 8
   %t_8 = move %t_13
   jump main_for_cond_2
main_for_merge_2:
   jump main_for_step_2
main_for_step_2:
   %t_14 = add %t_3 8
   %t_3 = move %t_14
   jump main_for_cond_1
main_for_merge_1:
   %a_1 = move %t_2
   %vrax_1 = move 0
   ret %vrax_1
}

define i64 @__init  {
__init_entry_1:
   %vrax_1 = call main 
   %t_15 = move %vrax_1
   %t_16 = move %t_15
   %vrax_1 = move %t_16
   ret %vrax_1
}

=====================main Iteration 0=====================
========main Graph Info ========
t_12:
AdjList :  t_3 t_4 t_2 t_8 t_9
degree : 5
Alias :None
Color : null
Priority : 0
------
t_11:
AdjList :  t_3 t_4 t_2 t_8 t_9
degree : 5
Alias :None
Color : null
Priority : 0
------
t_2:
AdjList :  vr13_1 t_12 t_11 vr15_1 t_13 t_5 t_14 t_9 vrdi_1 vr14_1 t_3 t_4 t_1 t_10 vrax_1 vrbx_1 vr12_1 t_6 t_8 t_7
degree : 20
Alias :None
Color : null
Priority : 0
------
t_13:
AdjList :  t_3 t_4 t_2 t_9
degree : 4
Alias :None
Color : null
Priority : 0
------
t_5:
AdjList :  t_3 t_4 t_2
degree : 3
Alias :None
Color : null
Priority : 0
------
t_14:
AdjList :  t_4 t_2
degree : 2
Alias :None
Color : null
Priority : 0
------
a_1:
AdjList : 
degree : 0
Alias :None
Color : null
Priority : 0
------
t_9:
AdjList :  t_12 vr13_1 t_11 t_2 vr15_1 t_13 vrdi_1 vr14_1 t_3 t_4 t_10 vrax_1 vrbx_1 vr12_1 t_8
degree : 15
Alias :None
Color : null
Priority : 0
------
t_3:
AdjList :  vr13_1 t_12 t_11 t_2 vr15_1 t_13 t_5 t_9 vrdi_1 vr14_1 t_4 t_1 t_10 vrax_1 vrbx_1 vr12_1 t_6 t_8 t_7
degree : 19
Alias :None
Color : null
Priority : 0
------
t_4:
AdjList :  vr13_1 t_12 t_11 t_2 vr15_1 t_13 t_5 t_14 t_9 vrdi_1 vr14_1 t_3 t_10 vrax_1 vrbx_1 vr12_1 t_6 t_8 t_7
degree : 19
Alias :None
Color : null
Priority : 0
------
t_1:
AdjList :  vr14_1 t_3 vr13_1 t_2 vrax_1 vr15_1 vrbx_1 vr12_1
degree : 8
Alias :None
Color : null
Priority : 0
------
t_10:
AdjList :  t_3 t_4 t_2 t_8 t_9
degree : 5
Alias :None
Color : null
Priority : 0
------
t_6:
AdjList :  vr14_1 vr13_1 t_3 t_4 t_2 vrax_1 vr15_1 vrbx_1 vr12_1 t_8 t_7
degree : 11
Alias :None
Color : null
Priority : 0
------
t_8:
AdjList :  t_12 vr13_1 t_11 t_2 vr15_1 t_9 vrdi_1 vr14_1 t_3 t_4 t_10 vrax_1 vrbx_1 t_6 vr12_1 t_7
degree : 16
Alias :None
Color : null
Priority : 0
------
t_7:
AdjList :  t_3 t_4 t_2 t_6 t_8
degree : 5
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
vrdi_1 = move t_1
t_7 = move vrax_1
vrdi_1 = move t_11
vrdi_1 = move t_6
t_2 = move vrax_1
t_8 = move t_13
t_12 = move vrax_1
t_3 = move t_14
------
active moves:
========main Node List Info ========
simplify Nodes(low degree non move related):
t_10(0) t_5(0) a_1(0) 
------
freeze Nodes(low degree move related):
t_12(0) t_11(0) t_1(0) t_13(0) t_14(0) t_6(0) t_7(0) 
------
spill Nodes(high degree):
t_3(0) t_4(0) t_2(0) t_9(0) t_8(0) 
------
spilled Nodes:

------
coalesced Nodes:

------
colored Nodes:

------
selected Stack:

------

define i64 @main  {
main_entry_1:
   %t_1 = mul 10 8
   %t_1 = add %t_1 8
   %vrdi_1 = move %t_1
   %vrax_1 = alloc %vrdi_1
   %t_2 = move %vrax_1
   store 10 %t_2
   %t_3 = add %t_2 8
   %t_4 = add %t_2 %t_1
   jump main_for_cond_1
main_for_cond_1:
   %t_5 = slt %t_3 %t_4
   br %t_5 main_for_body_1 main_for_merge_1
main_for_body_1:
   %t_6 = mul 10 8
   %t_6 = add %t_6 8
   %vrdi_1 = move %t_6
   %vrax_1 = alloc %vrdi_1
   %t_7 = move %vrax_1
   store 10 %t_7
   store %t_7 %t_3
   %t_8 = add %t_7 8
   %t_9 = add %t_7 %t_6
   jump main_for_cond_2
main_for_cond_2:
   %t_10 = slt %t_8 %t_9
   br %t_10 main_for_body_2 main_for_merge_2
main_for_body_2:
   %t_11 = mul 10 8
   %t_11 = add %t_11 8
   %vrdi_1 = move %t_11
   %vrax_1 = alloc %vrdi_1
   %t_12 = move %vrax_1
   store 10 %t_12
   store %t_12 %t_8
   jump main_for_step_1
main_for_step_1:
   %t_13 = add %t_8 8
   %t_8 = move %t_13
   jump main_for_cond_2
main_for_merge_2:
   jump main_for_step_2
main_for_step_2:
   %t_14 = add %t_3 8
   %t_3 = move %t_14
   jump main_for_cond_1
main_for_merge_1:
   %vrax_1 = move 0
   ret %vrax_1
}

define i64 @__init  {
__init_entry_1:
   %vrax_1 = call main 
   %t_15 = move %vrax_1
   %t_16 = move %t_15
   %vrax_1 = move %t_16
   ret %vrax_1
}

===================== Simplify =====================
========main Graph Info ========
t_12:
AdjList :  t_3 t_4 t_2 t_8 t_9
degree : 5
Alias :None
Color : null
Priority : 0
------
t_11:
AdjList :  t_3 t_4 t_2 t_8 t_9
degree : 5
Alias :None
Color : null
Priority : 0
------
t_2:
AdjList :  vr13_1 t_12 t_11 vr15_1 t_13 t_5 t_14 t_9 vrdi_1 vr14_1 t_3 t_4 t_1 t_10 vrax_1 vrbx_1 vr12_1 t_6 t_8 t_7
degree : 19
Alias :None
Color : null
Priority : 0
------
t_13:
AdjList :  t_3 t_4 t_2 t_9
degree : 4
Alias :None
Color : null
Priority : 0
------
t_5:
AdjList :  t_3 t_4 t_2
degree : 3
Alias :None
Color : null
Priority : 0
------
t_14:
AdjList :  t_4 t_2
degree : 2
Alias :None
Color : null
Priority : 0
------
a_1:
AdjList : 
degree : 0
Alias :None
Color : null
Priority : 0
------
t_9:
AdjList :  t_12 vr13_1 t_11 t_2 vr15_1 t_13 vrdi_1 vr14_1 t_3 t_4 t_10 vrax_1 vrbx_1 vr12_1 t_8
degree : 14
Alias :None
Color : null
Priority : 0
------
t_3:
AdjList :  vr13_1 t_12 t_11 t_2 vr15_1 t_13 t_5 t_9 vrdi_1 vr14_1 t_4 t_1 t_10 vrax_1 vrbx_1 vr12_1 t_6 t_8 t_7
degree : 18
Alias :None
Color : null
Priority : 0
------
t_4:
AdjList :  vr13_1 t_12 t_11 t_2 vr15_1 t_13 t_5 t_14 t_9 vrdi_1 vr14_1 t_3 t_10 vrax_1 vrbx_1 vr12_1 t_6 t_8 t_7
degree : 18
Alias :None
Color : null
Priority : 0
------
t_1:
AdjList :  vr14_1 t_3 vr13_1 t_2 vrax_1 vr15_1 vrbx_1 vr12_1
degree : 8
Alias :None
Color : null
Priority : 0
------
t_10:
AdjList :  t_3 t_4 t_2 t_8 t_9
degree : 5
Alias :None
Color : null
Priority : 0
------
t_6:
AdjList :  vr14_1 vr13_1 t_3 t_4 t_2 vrax_1 vr15_1 vrbx_1 vr12_1 t_8 t_7
degree : 11
Alias :None
Color : null
Priority : 0
------
t_8:
AdjList :  t_12 vr13_1 t_11 t_2 vr15_1 t_9 vrdi_1 vr14_1 t_3 t_4 t_10 vrax_1 vrbx_1 t_6 vr12_1 t_7
degree : 15
Alias :None
Color : null
Priority : 0
------
t_7:
AdjList :  t_3 t_4 t_2 t_6 t_8
degree : 5
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
vrdi_1 = move t_1
t_7 = move vrax_1
vrdi_1 = move t_11
vrdi_1 = move t_6
t_2 = move vrax_1
t_8 = move t_13
t_12 = move vrax_1
t_3 = move t_14
------
active moves:
========main Node List Info ========
simplify Nodes(low degree non move related):
t_5(0) a_1(0) 
------
freeze Nodes(low degree move related):
t_12(0) t_11(0) t_1(0) t_13(0) t_14(0) t_6(0) t_7(0) 
------
spill Nodes(high degree):
t_3(0) t_4(0) t_2(0) t_9(0) t_8(0) 
------
spilled Nodes:

------
coalesced Nodes:

------
colored Nodes:

------
selected Stack:
t_10(0) 
------

===================== Simplify =====================
========main Graph Info ========
t_12:
AdjList :  t_3 t_4 t_2 t_8 t_9
degree : 5
Alias :None
Color : null
Priority : 0
------
t_11:
AdjList :  t_3 t_4 t_2 t_8 t_9
degree : 5
Alias :None
Color : null
Priority : 0
------
t_2:
AdjList :  vr13_1 t_12 t_11 vr15_1 t_13 t_5 t_14 t_9 vrdi_1 vr14_1 t_3 t_4 t_1 t_10 vrax_1 vrbx_1 vr12_1 t_6 t_8 t_7
degree : 18
Alias :None
Color : null
Priority : 0
------
t_13:
AdjList :  t_3 t_4 t_2 t_9
degree : 4
Alias :None
Color : null
Priority : 0
------
t_5:
AdjList :  t_3 t_4 t_2
degree : 3
Alias :None
Color : null
Priority : 0
------
t_14:
AdjList :  t_4 t_2
degree : 2
Alias :None
Color : null
Priority : 0
------
a_1:
AdjList : 
degree : 0
Alias :None
Color : null
Priority : 0
------
t_9:
AdjList :  t_12 vr13_1 t_11 t_2 vr15_1 t_13 vrdi_1 vr14_1 t_3 t_4 t_10 vrax_1 vrbx_1 vr12_1 t_8
degree : 14
Alias :None
Color : null
Priority : 0
------
t_3:
AdjList :  vr13_1 t_12 t_11 t_2 vr15_1 t_13 t_5 t_9 vrdi_1 vr14_1 t_4 t_1 t_10 vrax_1 vrbx_1 vr12_1 t_6 t_8 t_7
degree : 17
Alias :None
Color : null
Priority : 0
------
t_4:
AdjList :  vr13_1 t_12 t_11 t_2 vr15_1 t_13 t_5 t_14 t_9 vrdi_1 vr14_1 t_3 t_10 vrax_1 vrbx_1 vr12_1 t_6 t_8 t_7
degree : 17
Alias :None
Color : null
Priority : 0
------
t_1:
AdjList :  vr14_1 t_3 vr13_1 t_2 vrax_1 vr15_1 vrbx_1 vr12_1
degree : 8
Alias :None
Color : null
Priority : 0
------
t_10:
AdjList :  t_3 t_4 t_2 t_8 t_9
degree : 5
Alias :None
Color : null
Priority : 0
------
t_6:
AdjList :  vr14_1 vr13_1 t_3 t_4 t_2 vrax_1 vr15_1 vrbx_1 vr12_1 t_8 t_7
degree : 11
Alias :None
Color : null
Priority : 0
------
t_8:
AdjList :  t_12 vr13_1 t_11 t_2 vr15_1 t_9 vrdi_1 vr14_1 t_3 t_4 t_10 vrax_1 vrbx_1 t_6 vr12_1 t_7
degree : 15
Alias :None
Color : null
Priority : 0
------
t_7:
AdjList :  t_3 t_4 t_2 t_6 t_8
degree : 5
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
vrdi_1 = move t_1
t_7 = move vrax_1
vrdi_1 = move t_11
vrdi_1 = move t_6
t_2 = move vrax_1
t_8 = move t_13
t_12 = move vrax_1
t_3 = move t_14
------
active moves:
========main Node List Info ========
simplify Nodes(low degree non move related):
a_1(0) 
------
freeze Nodes(low degree move related):
t_12(0) t_11(0) t_1(0) t_13(0) t_14(0) t_6(0) t_7(0) 
------
spill Nodes(high degree):
t_3(0) t_4(0) t_2(0) t_9(0) t_8(0) 
------
spilled Nodes:

------
coalesced Nodes:

------
colored Nodes:

------
selected Stack:
t_10(0) t_5(0) 
------

===================== Simplify =====================
========main Graph Info ========
t_12:
AdjList :  t_3 t_4 t_2 t_8 t_9
degree : 5
Alias :None
Color : null
Priority : 0
------
t_11:
AdjList :  t_3 t_4 t_2 t_8 t_9
degree : 5
Alias :None
Color : null
Priority : 0
------
t_2:
AdjList :  vr13_1 t_12 t_11 vr15_1 t_13 t_5 t_14 t_9 vrdi_1 vr14_1 t_3 t_4 t_1 t_10 vrax_1 vrbx_1 vr12_1 t_6 t_8 t_7
degree : 18
Alias :None
Color : null
Priority : 0
------
t_13:
AdjList :  t_3 t_4 t_2 t_9
degree : 4
Alias :None
Color : null
Priority : 0
------
t_5:
AdjList :  t_3 t_4 t_2
degree : 3
Alias :None
Color : null
Priority : 0
------
t_14:
AdjList :  t_4 t_2
degree : 2
Alias :None
Color : null
Priority : 0
------
a_1:
AdjList : 
degree : 0
Alias :None
Color : null
Priority : 0
------
t_9:
AdjList :  t_12 vr13_1 t_11 t_2 vr15_1 t_13 vrdi_1 vr14_1 t_3 t_4 t_10 vrax_1 vrbx_1 vr12_1 t_8
degree : 14
Alias :None
Color : null
Priority : 0
------
t_3:
AdjList :  vr13_1 t_12 t_11 t_2 vr15_1 t_13 t_5 t_9 vrdi_1 vr14_1 t_4 t_1 t_10 vrax_1 vrbx_1 vr12_1 t_6 t_8 t_7
degree : 17
Alias :None
Color : null
Priority : 0
------
t_4:
AdjList :  vr13_1 t_12 t_11 t_2 vr15_1 t_13 t_5 t_14 t_9 vrdi_1 vr14_1 t_3 t_10 vrax_1 vrbx_1 vr12_1 t_6 t_8 t_7
degree : 17
Alias :None
Color : null
Priority : 0
------
t_1:
AdjList :  vr14_1 t_3 vr13_1 t_2 vrax_1 vr15_1 vrbx_1 vr12_1
degree : 8
Alias :None
Color : null
Priority : 0
------
t_10:
AdjList :  t_3 t_4 t_2 t_8 t_9
degree : 5
Alias :None
Color : null
Priority : 0
------
t_6:
AdjList :  vr14_1 vr13_1 t_3 t_4 t_2 vrax_1 vr15_1 vrbx_1 vr12_1 t_8 t_7
degree : 11
Alias :None
Color : null
Priority : 0
------
t_8:
AdjList :  t_12 vr13_1 t_11 t_2 vr15_1 t_9 vrdi_1 vr14_1 t_3 t_4 t_10 vrax_1 vrbx_1 t_6 vr12_1 t_7
degree : 15
Alias :None
Color : null
Priority : 0
------
t_7:
AdjList :  t_3 t_4 t_2 t_6 t_8
degree : 5
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
vrdi_1 = move t_1
t_7 = move vrax_1
vrdi_1 = move t_11
vrdi_1 = move t_6
t_2 = move vrax_1
t_8 = move t_13
t_12 = move vrax_1
t_3 = move t_14
------
active moves:
========main Node List Info ========
simplify Nodes(low degree non move related):

------
freeze Nodes(low degree move related):
t_12(0) t_11(0) t_1(0) t_13(0) t_14(0) t_6(0) t_7(0) 
------
spill Nodes(high degree):
t_3(0) t_4(0) t_2(0) t_9(0) t_8(0) 
------
spilled Nodes:

------
coalesced Nodes:

------
colored Nodes:

------
selected Stack:
t_10(0) t_5(0) a_1(0) 
------

===================== Coalesce =====================
========main Graph Info ========
t_12:
AdjList :  t_3 t_4 t_2 t_8 t_9
degree : 5
Alias :None
Color : null
Priority : 0
------
t_11:
AdjList :  t_3 t_4 t_2 t_8 t_9
degree : 5
Alias :None
Color : null
Priority : 0
------
t_2:
AdjList :  vr13_1 t_12 t_11 vr15_1 t_13 t_5 t_14 t_9 vrdi_1 vr14_1 t_3 t_4 t_1 t_10 vrax_1 vrbx_1 vr12_1 t_6 t_8 t_7
degree : 17
Alias :None
Color : null
Priority : 0
------
t_13:
AdjList :  t_3 t_4 t_2 t_9
degree : 4
Alias :None
Color : null
Priority : 0
------
t_5:
AdjList :  t_3 t_4 t_2
degree : 3
Alias :None
Color : null
Priority : 0
------
t_14:
AdjList :  t_4 t_2
degree : 2
Alias :None
Color : null
Priority : 0
------
a_1:
AdjList : 
degree : 0
Alias :None
Color : null
Priority : 0
------
t_9:
AdjList :  t_12 vr13_1 t_11 t_2 vr15_1 t_13 vrdi_1 vr14_1 t_3 t_4 t_10 vrax_1 vrbx_1 vr12_1 t_8
degree : 14
Alias :None
Color : null
Priority : 0
------
t_3:
AdjList :  vr13_1 t_12 t_11 t_2 vr15_1 t_13 t_5 t_9 vrdi_1 vr14_1 t_4 t_1 t_10 vrax_1 vrbx_1 vr12_1 t_6 t_8 t_7
degree : 16
Alias :None
Color : null
Priority : 0
------
t_4:
AdjList :  vr13_1 t_12 t_11 t_2 vr15_1 t_13 t_5 t_14 t_9 vrdi_1 vr14_1 t_3 t_10 vrax_1 vrbx_1 vr12_1 t_6 t_8 t_7
degree : 17
Alias :None
Color : null
Priority : 0
------
t_1:
AdjList :  vr14_1 t_3 vr13_1 t_2 vrax_1 vr15_1 vrbx_1 vr12_1
degree : 8
Alias :vrdi_1
Color : null
Priority : 0
------
t_10:
AdjList :  t_3 t_4 t_2 t_8 t_9
degree : 5
Alias :None
Color : null
Priority : 0
------
t_6:
AdjList :  vr14_1 vr13_1 t_3 t_4 t_2 vrax_1 vr15_1 vrbx_1 vr12_1 t_8 t_7
degree : 11
Alias :None
Color : null
Priority : 0
------
t_8:
AdjList :  t_12 vr13_1 t_11 t_2 vr15_1 t_9 vrdi_1 vr14_1 t_3 t_4 t_10 vrax_1 vrbx_1 t_6 vr12_1 t_7
degree : 15
Alias :None
Color : null
Priority : 0
------
t_7:
AdjList :  t_3 t_4 t_2 t_6 t_8
degree : 5
Alias :None
Color : null
Priority : 0
------
========main move List Info ========
coalesced moves:
vrdi_1 = move t_1
------
constrained moves:
------
fronzen moves:
------
workList moves:
t_7 = move vrax_1
vrdi_1 = move t_11
vrdi_1 = move t_6
t_2 = move vrax_1
t_8 = move t_13
t_12 = move vrax_1
t_3 = move t_14
------
active moves:
========main Node List Info ========
simplify Nodes(low degree non move related):

------
freeze Nodes(low degree move related):
t_12(0) t_11(0) t_13(0) t_14(0) t_6(0) t_7(0) 
------
spill Nodes(high degree):
t_3(0) t_4(0) t_2(0) t_9(0) t_8(0) 
------
spilled Nodes:

------
coalesced Nodes:
t_1(0) 
------
colored Nodes:

------
selected Stack:
t_10(0) t_5(0) a_1(0) 
------

===================== Coalesce =====================
========main Graph Info ========
t_12:
AdjList :  t_3 t_4 t_2 t_8 t_9
degree : 5
Alias :None
Color : null
Priority : 0
------
t_11:
AdjList :  t_3 t_4 t_2 t_8 t_9
degree : 5
Alias :None
Color : null
Priority : 0
------
t_2:
AdjList :  vr13_1 t_12 t_11 vr15_1 t_13 t_5 t_14 t_9 vrdi_1 vr14_1 t_3 t_4 t_1 t_10 vrax_1 vrbx_1 vr12_1 t_6 t_8 t_7
degree : 16
Alias :None
Color : null
Priority : 0
------
t_13:
AdjList :  t_3 t_4 t_2 t_9
degree : 4
Alias :None
Color : null
Priority : 0
------
t_5:
AdjList :  t_3 t_4 t_2
degree : 3
Alias :None
Color : null
Priority : 0
------
t_14:
AdjList :  t_4 t_2
degree : 2
Alias :None
Color : null
Priority : 0
------
a_1:
AdjList : 
degree : 0
Alias :None
Color : null
Priority : 0
------
t_9:
AdjList :  t_12 vr13_1 t_11 t_2 vr15_1 t_13 vrdi_1 vr14_1 t_3 t_4 t_10 vrax_1 vrbx_1 vr12_1 t_8
degree : 14
Alias :None
Color : null
Priority : 0
------
t_3:
AdjList :  vr13_1 t_12 t_11 t_2 vr15_1 t_13 t_5 t_9 vrdi_1 vr14_1 t_4 t_1 t_10 vrax_1 vrbx_1 vr12_1 t_6 t_8 t_7
degree : 15
Alias :None
Color : null
Priority : 0
------
t_4:
AdjList :  vr13_1 t_12 t_11 t_2 vr15_1 t_13 t_5 t_14 t_9 vrdi_1 vr14_1 t_3 t_10 vrax_1 vrbx_1 vr12_1 t_6 t_8 t_7
degree : 16
Alias :None
Color : null
Priority : 0
------
t_1:
AdjList :  vr14_1 t_3 vr13_1 t_2 vrax_1 vr15_1 vrbx_1 vr12_1
degree : 8
Alias :vrdi_1
Color : null
Priority : 0
------
t_10:
AdjList :  t_3 t_4 t_2 t_8 t_9
degree : 5
Alias :None
Color : null
Priority : 0
------
t_6:
AdjList :  vr14_1 vr13_1 t_3 t_4 t_2 vrax_1 vr15_1 vrbx_1 vr12_1 t_8 t_7
degree : 10
Alias :None
Color : null
Priority : 0
------
t_8:
AdjList :  t_12 vr13_1 t_11 t_2 vr15_1 t_9 vrdi_1 vr14_1 t_3 t_4 t_10 vrax_1 vrbx_1 t_6 vr12_1 t_7
degree : 14
Alias :None
Color : null
Priority : 0
------
t_7:
AdjList :  t_3 t_4 t_2 t_6 t_8
degree : 5
Alias :vrax_1
Color : null
Priority : 0
------
========main move List Info ========
coalesced moves:
vrdi_1 = move t_1
t_7 = move vrax_1
------
constrained moves:
------
fronzen moves:
------
workList moves:
vrdi_1 = move t_11
vrdi_1 = move t_6
t_2 = move vrax_1
t_8 = move t_13
t_12 = move vrax_1
t_3 = move t_14
------
active moves:
========main Node List Info ========
simplify Nodes(low degree non move related):

------
freeze Nodes(low degree move related):
t_12(0) t_11(0) t_13(0) t_14(0) t_6(0) 
------
spill Nodes(high degree):
t_3(0) t_4(0) t_2(0) t_9(0) t_8(0) 
------
spilled Nodes:

------
coalesced Nodes:
t_1(0) t_7(0) 
------
colored Nodes:

------
selected Stack:
t_10(0) t_5(0) a_1(0) 
------

===================== Coalesce =====================
========main Graph Info ========
t_12:
AdjList :  t_3 t_4 t_2 t_8 t_9
degree : 5
Alias :None
Color : null
Priority : 0
------
t_11:
AdjList :  t_3 t_4 t_2 t_8 t_9
degree : 5
Alias :vrdi_1
Color : null
Priority : 0
------
t_2:
AdjList :  vr13_1 t_12 t_11 vr15_1 t_13 t_5 t_14 t_9 vrdi_1 vr14_1 t_3 t_4 t_1 t_10 vrax_1 vrbx_1 vr12_1 t_6 t_8 t_7
degree : 15
Alias :None
Color : null
Priority : 0
------
t_13:
AdjList :  t_3 t_4 t_2 t_9
degree : 4
Alias :None
Color : null
Priority : 0
------
t_5:
AdjList :  t_3 t_4 t_2
degree : 3
Alias :None
Color : null
Priority : 0
------
t_14:
AdjList :  t_4 t_2
degree : 2
Alias :None
Color : null
Priority : 0
------
a_1:
AdjList : 
degree : 0
Alias :None
Color : null
Priority : 0
------
t_9:
AdjList :  t_12 vr13_1 t_11 t_2 vr15_1 t_13 vrdi_1 vr14_1 t_3 t_4 t_10 vrax_1 vrbx_1 vr12_1 t_8
degree : 13
Alias :None
Color : null
Priority : 0
------
t_3:
AdjList :  vr13_1 t_12 t_11 t_2 vr15_1 t_13 t_5 t_9 vrdi_1 vr14_1 t_4 t_1 t_10 vrax_1 vrbx_1 vr12_1 t_6 t_8 t_7
degree : 14
Alias :None
Color : null
Priority : 0
------
t_4:
AdjList :  vr13_1 t_12 t_11 t_2 vr15_1 t_13 t_5 t_14 t_9 vrdi_1 vr14_1 t_3 t_10 vrax_1 vrbx_1 vr12_1 t_6 t_8 t_7
degree : 15
Alias :None
Color : null
Priority : 0
------
t_1:
AdjList :  vr14_1 t_3 vr13_1 t_2 vrax_1 vr15_1 vrbx_1 vr12_1
degree : 8
Alias :vrdi_1
Color : null
Priority : 0
------
t_10:
AdjList :  t_3 t_4 t_2 t_8 t_9
degree : 5
Alias :None
Color : null
Priority : 0
------
t_6:
AdjList :  vr14_1 vr13_1 t_3 t_4 t_2 vrax_1 vr15_1 vrbx_1 vr12_1 t_8 t_7
degree : 10
Alias :None
Color : null
Priority : 0
------
t_8:
AdjList :  t_12 vr13_1 t_11 t_2 vr15_1 t_9 vrdi_1 vr14_1 t_3 t_4 t_10 vrax_1 vrbx_1 t_6 vr12_1 t_7
degree : 13
Alias :None
Color : null
Priority : 0
------
t_7:
AdjList :  t_3 t_4 t_2 t_6 t_8
degree : 5
Alias :vrax_1
Color : null
Priority : 0
------
========main move List Info ========
coalesced moves:
vrdi_1 = move t_1
t_7 = move vrax_1
vrdi_1 = move t_11
------
constrained moves:
------
fronzen moves:
------
workList moves:
vrdi_1 = move t_6
t_2 = move vrax_1
t_8 = move t_13
t_12 = move vrax_1
t_3 = move t_14
------
active moves:
========main Node List Info ========
simplify Nodes(low degree non move related):
t_9(0) 
------
freeze Nodes(low degree move related):
t_12(0) t_13(0) t_14(0) t_6(0) t_8(0) 
------
spill Nodes(high degree):
t_3(0) t_4(0) t_2(0) 
------
spilled Nodes:

------
coalesced Nodes:
t_11(0) t_1(0) t_7(0) 
------
colored Nodes:

------
selected Stack:
t_10(0) t_5(0) a_1(0) 
------

===================== Simplify =====================
========main Graph Info ========
t_12:
AdjList :  t_3 t_4 t_2 t_8 t_9
degree : 4
Alias :None
Color : null
Priority : 0
------
t_11:
AdjList :  t_3 t_4 t_2 t_8 t_9
degree : 5
Alias :vrdi_1
Color : null
Priority : 0
------
t_2:
AdjList :  vr13_1 t_12 t_11 vr15_1 t_13 t_5 t_14 t_9 vrdi_1 vr14_1 t_3 t_4 t_1 t_10 vrax_1 vrbx_1 vr12_1 t_6 t_8 t_7
degree : 14
Alias :None
Color : null
Priority : 0
------
t_13:
AdjList :  t_3 t_4 t_2 t_9
degree : 3
Alias :None
Color : null
Priority : 0
------
t_5:
AdjList :  t_3 t_4 t_2
degree : 3
Alias :None
Color : null
Priority : 0
------
t_14:
AdjList :  t_4 t_2
degree : 2
Alias :None
Color : null
Priority : 0
------
a_1:
AdjList : 
degree : 0
Alias :None
Color : null
Priority : 0
------
t_9:
AdjList :  t_12 vr13_1 t_11 t_2 vr15_1 t_13 vrdi_1 vr14_1 t_3 t_4 t_10 vrax_1 vrbx_1 vr12_1 t_8
degree : 13
Alias :None
Color : null
Priority : 0
------
t_3:
AdjList :  vr13_1 t_12 t_11 t_2 vr15_1 t_13 t_5 t_9 vrdi_1 vr14_1 t_4 t_1 t_10 vrax_1 vrbx_1 vr12_1 t_6 t_8 t_7
degree : 13
Alias :None
Color : null
Priority : 0
------
t_4:
AdjList :  vr13_1 t_12 t_11 t_2 vr15_1 t_13 t_5 t_14 t_9 vrdi_1 vr14_1 t_3 t_10 vrax_1 vrbx_1 vr12_1 t_6 t_8 t_7
degree : 14
Alias :None
Color : null
Priority : 0
------
t_1:
AdjList :  vr14_1 t_3 vr13_1 t_2 vrax_1 vr15_1 vrbx_1 vr12_1
degree : 8
Alias :vrdi_1
Color : null
Priority : 0
------
t_10:
AdjList :  t_3 t_4 t_2 t_8 t_9
degree : 5
Alias :None
Color : null
Priority : 0
------
t_6:
AdjList :  vr14_1 vr13_1 t_3 t_4 t_2 vrax_1 vr15_1 vrbx_1 vr12_1 t_8 t_7
degree : 10
Alias :None
Color : null
Priority : 0
------
t_8:
AdjList :  t_12 vr13_1 t_11 t_2 vr15_1 t_9 vrdi_1 vr14_1 t_3 t_4 t_10 vrax_1 vrbx_1 t_6 vr12_1 t_7
degree : 12
Alias :None
Color : null
Priority : 0
------
t_7:
AdjList :  t_3 t_4 t_2 t_6 t_8
degree : 5
Alias :vrax_1
Color : null
Priority : 0
------
========main move List Info ========
coalesced moves:
vrdi_1 = move t_1
t_7 = move vrax_1
vrdi_1 = move t_11
------
constrained moves:
------
fronzen moves:
------
workList moves:
vrdi_1 = move t_6
t_2 = move vrax_1
t_8 = move t_13
t_12 = move vrax_1
t_3 = move t_14
------
active moves:
========main Node List Info ========
simplify Nodes(low degree non move related):

------
freeze Nodes(low degree move related):
t_12(0) t_3(0) t_13(0) t_14(0) t_6(0) t_8(0) 
------
spill Nodes(high degree):
t_4(0) t_2(0) 
------
spilled Nodes:

------
coalesced Nodes:
t_11(0) t_1(0) t_7(0) 
------
colored Nodes:

------
selected Stack:
t_10(0) t_5(0) a_1(0) t_9(0) 
------

===================== Coalesce =====================
========main Graph Info ========
t_12:
AdjList :  t_3 t_4 t_2 t_8 t_9
degree : 4
Alias :None
Color : null
Priority : 0
------
t_11:
AdjList :  t_3 t_4 t_2 t_8 t_9
degree : 5
Alias :vrdi_1
Color : null
Priority : 0
------
t_2:
AdjList :  vr13_1 t_12 t_11 vr15_1 t_13 t_5 t_14 t_9 vrdi_1 vr14_1 t_3 t_4 t_1 t_10 vrax_1 vrbx_1 vr12_1 t_6 t_8 t_7
degree : 13
Alias :None
Color : null
Priority : 0
------
t_13:
AdjList :  t_3 t_4 t_2 t_9
degree : 3
Alias :None
Color : null
Priority : 0
------
t_5:
AdjList :  t_3 t_4 t_2
degree : 3
Alias :None
Color : null
Priority : 0
------
t_14:
AdjList :  t_4 t_2
degree : 2
Alias :None
Color : null
Priority : 0
------
a_1:
AdjList : 
degree : 0
Alias :None
Color : null
Priority : 0
------
t_9:
AdjList :  t_12 vr13_1 t_11 t_2 vr15_1 t_13 vrdi_1 vr14_1 t_3 t_4 t_10 vrax_1 vrbx_1 vr12_1 t_8
degree : 13
Alias :None
Color : null
Priority : 0
------
t_3:
AdjList :  vr13_1 t_12 t_11 t_2 vr15_1 t_13 t_5 t_9 vrdi_1 vr14_1 t_4 t_1 t_10 vrax_1 vrbx_1 vr12_1 t_6 t_8 t_7
degree : 12
Alias :None
Color : null
Priority : 0
------
t_4:
AdjList :  vr13_1 t_12 t_11 t_2 vr15_1 t_13 t_5 t_14 t_9 vrdi_1 vr14_1 t_3 t_10 vrax_1 vrbx_1 vr12_1 t_6 t_8 t_7
degree : 13
Alias :None
Color : null
Priority : 0
------
t_1:
AdjList :  vr14_1 t_3 vr13_1 t_2 vrax_1 vr15_1 vrbx_1 vr12_1
degree : 8
Alias :vrdi_1
Color : null
Priority : 0
------
t_10:
AdjList :  t_3 t_4 t_2 t_8 t_9
degree : 5
Alias :None
Color : null
Priority : 0
------
t_6:
AdjList :  vr14_1 vr13_1 t_3 t_4 t_2 vrax_1 vr15_1 vrbx_1 vr12_1 t_8 t_7
degree : 10
Alias :vrdi_1
Color : null
Priority : 0
------
t_8:
AdjList :  t_12 vr13_1 t_11 t_2 vr15_1 t_9 vrdi_1 vr14_1 t_3 t_4 t_10 vrax_1 vrbx_1 t_6 vr12_1 t_7
degree : 11
Alias :None
Color : null
Priority : 0
------
t_7:
AdjList :  t_3 t_4 t_2 t_6 t_8
degree : 5
Alias :vrax_1
Color : null
Priority : 0
------
========main move List Info ========
coalesced moves:
vrdi_1 = move t_1
t_7 = move vrax_1
vrdi_1 = move t_11
vrdi_1 = move t_6
------
constrained moves:
------
fronzen moves:
------
workList moves:
t_2 = move vrax_1
t_8 = move t_13
t_12 = move vrax_1
t_3 = move t_14
------
active moves:
========main Node List Info ========
simplify Nodes(low degree non move related):
t_4(0) 
------
freeze Nodes(low degree move related):
t_12(0) t_3(0) t_2(0) t_13(0) t_14(0) t_8(0) 
------
spill Nodes(high degree):

------
spilled Nodes:

------
coalesced Nodes:
t_11(0) t_1(0) t_6(0) t_7(0) 
------
colored Nodes:

------
selected Stack:
t_10(0) t_5(0) a_1(0) t_9(0) 
------

===================== Simplify =====================
========main Graph Info ========
t_12:
AdjList :  t_3 t_4 t_2 t_8 t_9
degree : 3
Alias :None
Color : null
Priority : 0
------
t_11:
AdjList :  t_3 t_4 t_2 t_8 t_9
degree : 5
Alias :vrdi_1
Color : null
Priority : 0
------
t_2:
AdjList :  vr13_1 t_12 t_11 vr15_1 t_13 t_5 t_14 t_9 vrdi_1 vr14_1 t_3 t_4 t_1 t_10 vrax_1 vrbx_1 vr12_1 t_6 t_8 t_7
degree : 12
Alias :None
Color : null
Priority : 0
------
t_13:
AdjList :  t_3 t_4 t_2 t_9
degree : 2
Alias :None
Color : null
Priority : 0
------
t_5:
AdjList :  t_3 t_4 t_2
degree : 3
Alias :None
Color : null
Priority : 0
------
t_14:
AdjList :  t_4 t_2
degree : 1
Alias :None
Color : null
Priority : 0
------
a_1:
AdjList : 
degree : 0
Alias :None
Color : null
Priority : 0
------
t_9:
AdjList :  t_12 vr13_1 t_11 t_2 vr15_1 t_13 vrdi_1 vr14_1 t_3 t_4 t_10 vrax_1 vrbx_1 vr12_1 t_8
degree : 13
Alias :None
Color : null
Priority : 0
------
t_3:
AdjList :  vr13_1 t_12 t_11 t_2 vr15_1 t_13 t_5 t_9 vrdi_1 vr14_1 t_4 t_1 t_10 vrax_1 vrbx_1 vr12_1 t_6 t_8 t_7
degree : 11
Alias :None
Color : null
Priority : 0
------
t_4:
AdjList :  vr13_1 t_12 t_11 t_2 vr15_1 t_13 t_5 t_14 t_9 vrdi_1 vr14_1 t_3 t_10 vrax_1 vrbx_1 vr12_1 t_6 t_8 t_7
degree : 13
Alias :None
Color : null
Priority : 0
------
t_1:
AdjList :  vr14_1 t_3 vr13_1 t_2 vrax_1 vr15_1 vrbx_1 vr12_1
degree : 8
Alias :vrdi_1
Color : null
Priority : 0
------
t_10:
AdjList :  t_3 t_4 t_2 t_8 t_9
degree : 5
Alias :None
Color : null
Priority : 0
------
t_6:
AdjList :  vr14_1 vr13_1 t_3 t_4 t_2 vrax_1 vr15_1 vrbx_1 vr12_1 t_8 t_7
degree : 10
Alias :vrdi_1
Color : null
Priority : 0
------
t_8:
AdjList :  t_12 vr13_1 t_11 t_2 vr15_1 t_9 vrdi_1 vr14_1 t_3 t_4 t_10 vrax_1 vrbx_1 t_6 vr12_1 t_7
degree : 10
Alias :None
Color : null
Priority : 0
------
t_7:
AdjList :  t_3 t_4 t_2 t_6 t_8
degree : 5
Alias :vrax_1
Color : null
Priority : 0
------
========main move List Info ========
coalesced moves:
vrdi_1 = move t_1
t_7 = move vrax_1
vrdi_1 = move t_11
vrdi_1 = move t_6
------
constrained moves:
------
fronzen moves:
------
workList moves:
t_2 = move vrax_1
t_8 = move t_13
t_12 = move vrax_1
t_3 = move t_14
------
active moves:
========main Node List Info ========
simplify Nodes(low degree non move related):

------
freeze Nodes(low degree move related):
t_12(0) t_3(0) t_2(0) t_13(0) t_14(0) t_8(0) 
------
spill Nodes(high degree):

------
spilled Nodes:

------
coalesced Nodes:
t_11(0) t_1(0) t_6(0) t_7(0) 
------
colored Nodes:

------
selected Stack:
t_4(0) t_10(0) t_5(0) a_1(0) t_9(0) 
------

===================== Coalesce =====================
========main Graph Info ========
t_12:
AdjList :  t_3 t_4 t_2 t_8 t_9
degree : 3
Alias :None
Color : null
Priority : 0
------
t_11:
AdjList :  t_3 t_4 t_2 t_8 t_9
degree : 5
Alias :vrdi_1
Color : null
Priority : 0
------
t_2:
AdjList :  vr13_1 t_12 t_11 vr15_1 t_13 t_5 t_14 t_9 vrdi_1 vr14_1 t_3 t_4 t_1 t_10 vrax_1 vrbx_1 vr12_1 t_6 t_8 t_7
degree : 12
Alias :None
Color : null
Priority : 0
------
t_13:
AdjList :  t_3 t_4 t_2 t_9
degree : 2
Alias :None
Color : null
Priority : 0
------
t_5:
AdjList :  t_3 t_4 t_2
degree : 3
Alias :None
Color : null
Priority : 0
------
t_14:
AdjList :  t_4 t_2
degree : 1
Alias :None
Color : null
Priority : 0
------
a_1:
AdjList : 
degree : 0
Alias :None
Color : null
Priority : 0
------
t_9:
AdjList :  t_12 vr13_1 t_11 t_2 vr15_1 t_13 vrdi_1 vr14_1 t_3 t_4 t_10 vrax_1 vrbx_1 vr12_1 t_8
degree : 13
Alias :None
Color : null
Priority : 0
------
t_3:
AdjList :  vr13_1 t_12 t_11 t_2 vr15_1 t_13 t_5 t_9 vrdi_1 vr14_1 t_4 t_1 t_10 vrax_1 vrbx_1 vr12_1 t_6 t_8 t_7
degree : 11
Alias :None
Color : null
Priority : 0
------
t_4:
AdjList :  vr13_1 t_12 t_11 t_2 vr15_1 t_13 t_5 t_14 t_9 vrdi_1 vr14_1 t_3 t_10 vrax_1 vrbx_1 vr12_1 t_6 t_8 t_7
degree : 13
Alias :None
Color : null
Priority : 0
------
t_1:
AdjList :  vr14_1 t_3 vr13_1 t_2 vrax_1 vr15_1 vrbx_1 vr12_1
degree : 8
Alias :vrdi_1
Color : null
Priority : 0
------
t_10:
AdjList :  t_3 t_4 t_2 t_8 t_9
degree : 5
Alias :None
Color : null
Priority : 0
------
t_6:
AdjList :  vr14_1 vr13_1 t_3 t_4 t_2 vrax_1 vr15_1 vrbx_1 vr12_1 t_8 t_7
degree : 10
Alias :vrdi_1
Color : null
Priority : 0
------
t_8:
AdjList :  t_12 vr13_1 t_11 t_2 vr15_1 t_9 vrdi_1 vr14_1 t_3 t_4 t_10 vrax_1 vrbx_1 t_6 vr12_1 t_7
degree : 10
Alias :None
Color : null
Priority : 0
------
t_7:
AdjList :  t_3 t_4 t_2 t_6 t_8
degree : 5
Alias :vrax_1
Color : null
Priority : 0
------
========main move List Info ========
coalesced moves:
vrdi_1 = move t_1
t_7 = move vrax_1
vrdi_1 = move t_11
vrdi_1 = move t_6
------
constrained moves:
t_2 = move vrax_1
------
fronzen moves:
------
workList moves:
t_8 = move t_13
t_12 = move vrax_1
t_3 = move t_14
------
active moves:
========main Node List Info ========
simplify Nodes(low degree non move related):
t_2(0) 
------
freeze Nodes(low degree move related):
t_12(0) t_3(0) t_13(0) t_14(0) t_8(0) 
------
spill Nodes(high degree):

------
spilled Nodes:

------
coalesced Nodes:
t_11(0) t_1(0) t_6(0) t_7(0) 
------
colored Nodes:

------
selected Stack:
t_4(0) t_10(0) t_5(0) a_1(0) t_9(0) 
------

===================== Simplify =====================
========main Graph Info ========
t_12:
AdjList :  t_3 t_4 t_2 t_8 t_9
degree : 2
Alias :None
Color : null
Priority : 0
------
t_11:
AdjList :  t_3 t_4 t_2 t_8 t_9
degree : 5
Alias :vrdi_1
Color : null
Priority : 0
------
t_2:
AdjList :  vr13_1 t_12 t_11 vr15_1 t_13 t_5 t_14 t_9 vrdi_1 vr14_1 t_3 t_4 t_1 t_10 vrax_1 vrbx_1 vr12_1 t_6 t_8 t_7
degree : 12
Alias :None
Color : null
Priority : 0
------
t_13:
AdjList :  t_3 t_4 t_2 t_9
degree : 1
Alias :None
Color : null
Priority : 0
------
t_5:
AdjList :  t_3 t_4 t_2
degree : 3
Alias :None
Color : null
Priority : 0
------
t_14:
AdjList :  t_4 t_2
degree : 0
Alias :None
Color : null
Priority : 0
------
a_1:
AdjList : 
degree : 0
Alias :None
Color : null
Priority : 0
------
t_9:
AdjList :  t_12 vr13_1 t_11 t_2 vr15_1 t_13 vrdi_1 vr14_1 t_3 t_4 t_10 vrax_1 vrbx_1 vr12_1 t_8
degree : 13
Alias :None
Color : null
Priority : 0
------
t_3:
AdjList :  vr13_1 t_12 t_11 t_2 vr15_1 t_13 t_5 t_9 vrdi_1 vr14_1 t_4 t_1 t_10 vrax_1 vrbx_1 vr12_1 t_6 t_8 t_7
degree : 10
Alias :None
Color : null
Priority : 0
------
t_4:
AdjList :  vr13_1 t_12 t_11 t_2 vr15_1 t_13 t_5 t_14 t_9 vrdi_1 vr14_1 t_3 t_10 vrax_1 vrbx_1 vr12_1 t_6 t_8 t_7
degree : 13
Alias :None
Color : null
Priority : 0
------
t_1:
AdjList :  vr14_1 t_3 vr13_1 t_2 vrax_1 vr15_1 vrbx_1 vr12_1
degree : 8
Alias :vrdi_1
Color : null
Priority : 0
------
t_10:
AdjList :  t_3 t_4 t_2 t_8 t_9
degree : 5
Alias :None
Color : null
Priority : 0
------
t_6:
AdjList :  vr14_1 vr13_1 t_3 t_4 t_2 vrax_1 vr15_1 vrbx_1 vr12_1 t_8 t_7
degree : 10
Alias :vrdi_1
Color : null
Priority : 0
------
t_8:
AdjList :  t_12 vr13_1 t_11 t_2 vr15_1 t_9 vrdi_1 vr14_1 t_3 t_4 t_10 vrax_1 vrbx_1 t_6 vr12_1 t_7
degree : 9
Alias :None
Color : null
Priority : 0
------
t_7:
AdjList :  t_3 t_4 t_2 t_6 t_8
degree : 5
Alias :vrax_1
Color : null
Priority : 0
------
========main move List Info ========
coalesced moves:
vrdi_1 = move t_1
t_7 = move vrax_1
vrdi_1 = move t_11
vrdi_1 = move t_6
------
constrained moves:
t_2 = move vrax_1
------
fronzen moves:
------
workList moves:
t_8 = move t_13
t_12 = move vrax_1
t_3 = move t_14
------
active moves:
========main Node List Info ========
simplify Nodes(low degree non move related):

------
freeze Nodes(low degree move related):
t_12(0) t_3(0) t_13(0) t_14(0) t_8(0) 
------
spill Nodes(high degree):

------
spilled Nodes:

------
coalesced Nodes:
t_11(0) t_1(0) t_6(0) t_7(0) 
------
colored Nodes:

------
selected Stack:
t_4(0) t_10(0) t_2(0) t_5(0) a_1(0) t_9(0) 
------

===================== Coalesce =====================
========main Graph Info ========
t_12:
AdjList :  t_3 t_4 t_2 t_8 t_9
degree : 2
Alias :None
Color : null
Priority : 0
------
t_11:
AdjList :  t_3 t_4 t_2 t_8 t_9
degree : 5
Alias :vrdi_1
Color : null
Priority : 0
------
t_2:
AdjList :  vr13_1 t_12 t_11 vr15_1 t_13 t_5 t_14 t_9 vrdi_1 vr14_1 t_3 t_4 t_1 t_10 vrax_1 vrbx_1 vr12_1 t_6 t_8 t_7
degree : 12
Alias :None
Color : null
Priority : 0
------
t_13:
AdjList :  t_3 t_4 t_2 t_9
degree : 1
Alias :t_8
Color : null
Priority : 0
------
t_5:
AdjList :  t_3 t_4 t_2
degree : 3
Alias :None
Color : null
Priority : 0
------
t_14:
AdjList :  t_4 t_2
degree : 0
Alias :None
Color : null
Priority : 0
------
a_1:
AdjList : 
degree : 0
Alias :None
Color : null
Priority : 0
------
t_9:
AdjList :  t_12 vr13_1 t_11 t_2 vr15_1 t_13 vrdi_1 vr14_1 t_3 t_4 t_10 vrax_1 vrbx_1 vr12_1 t_8
degree : 13
Alias :None
Color : null
Priority : 0
------
t_3:
AdjList :  vr13_1 t_12 t_11 t_2 vr15_1 t_13 t_5 t_9 vrdi_1 vr14_1 t_4 t_1 t_10 vrax_1 vrbx_1 vr12_1 t_6 t_8 t_7
degree : 9
Alias :None
Color : null
Priority : 0
------
t_4:
AdjList :  vr13_1 t_12 t_11 t_2 vr15_1 t_13 t_5 t_14 t_9 vrdi_1 vr14_1 t_3 t_10 vrax_1 vrbx_1 vr12_1 t_6 t_8 t_7
degree : 13
Alias :None
Color : null
Priority : 0
------
t_1:
AdjList :  vr14_1 t_3 vr13_1 t_2 vrax_1 vr15_1 vrbx_1 vr12_1
degree : 8
Alias :vrdi_1
Color : null
Priority : 0
------
t_10:
AdjList :  t_3 t_4 t_2 t_8 t_9
degree : 5
Alias :None
Color : null
Priority : 0
------
t_6:
AdjList :  vr14_1 vr13_1 t_3 t_4 t_2 vrax_1 vr15_1 vrbx_1 vr12_1 t_8 t_7
degree : 10
Alias :vrdi_1
Color : null
Priority : 0
------
t_8:
AdjList :  t_12 vr13_1 t_11 t_2 vr15_1 t_9 vrdi_1 vr14_1 t_3 t_4 t_10 vrax_1 vrbx_1 t_6 vr12_1 t_7
degree : 9
Alias :None
Color : null
Priority : 0
------
t_7:
AdjList :  t_3 t_4 t_2 t_6 t_8
degree : 5
Alias :vrax_1
Color : null
Priority : 0
------
========main move List Info ========
coalesced moves:
vrdi_1 = move t_1
t_7 = move vrax_1
vrdi_1 = move t_11
vrdi_1 = move t_6
t_8 = move t_13
------
constrained moves:
t_2 = move vrax_1
------
fronzen moves:
------
workList moves:
t_12 = move vrax_1
t_3 = move t_14
------
active moves:
========main Node List Info ========
simplify Nodes(low degree non move related):
t_8(0) 
------
freeze Nodes(low degree move related):
t_12(0) t_3(0) t_14(0) 
------
spill Nodes(high degree):

------
spilled Nodes:

------
coalesced Nodes:
t_11(0) t_1(0) t_13(0) t_6(0) t_7(0) 
------
colored Nodes:

------
selected Stack:
t_4(0) t_10(0) t_2(0) t_5(0) a_1(0) t_9(0) 
------

===================== Simplify =====================
========main Graph Info ========
t_12:
AdjList :  t_3 t_4 t_2 t_8 t_9
degree : 1
Alias :None
Color : null
Priority : 0
------
t_11:
AdjList :  t_3 t_4 t_2 t_8 t_9
degree : 5
Alias :vrdi_1
Color : null
Priority : 0
------
t_2:
AdjList :  vr13_1 t_12 t_11 vr15_1 t_13 t_5 t_14 t_9 vrdi_1 vr14_1 t_3 t_4 t_1 t_10 vrax_1 vrbx_1 vr12_1 t_6 t_8 t_7
degree : 12
Alias :None
Color : null
Priority : 0
------
t_13:
AdjList :  t_3 t_4 t_2 t_9
degree : 1
Alias :t_8
Color : null
Priority : 0
------
t_5:
AdjList :  t_3 t_4 t_2
degree : 3
Alias :None
Color : null
Priority : 0
------
t_14:
AdjList :  t_4 t_2
degree : 0
Alias :None
Color : null
Priority : 0
------
a_1:
AdjList : 
degree : 0
Alias :None
Color : null
Priority : 0
------
t_9:
AdjList :  t_12 vr13_1 t_11 t_2 vr15_1 t_13 vrdi_1 vr14_1 t_3 t_4 t_10 vrax_1 vrbx_1 vr12_1 t_8
degree : 13
Alias :None
Color : null
Priority : 0
------
t_3:
AdjList :  vr13_1 t_12 t_11 t_2 vr15_1 t_13 t_5 t_9 vrdi_1 vr14_1 t_4 t_1 t_10 vrax_1 vrbx_1 vr12_1 t_6 t_8 t_7
degree : 8
Alias :None
Color : null
Priority : 0
------
t_4:
AdjList :  vr13_1 t_12 t_11 t_2 vr15_1 t_13 t_5 t_14 t_9 vrdi_1 vr14_1 t_3 t_10 vrax_1 vrbx_1 vr12_1 t_6 t_8 t_7
degree : 13
Alias :None
Color : null
Priority : 0
------
t_1:
AdjList :  vr14_1 t_3 vr13_1 t_2 vrax_1 vr15_1 vrbx_1 vr12_1
degree : 8
Alias :vrdi_1
Color : null
Priority : 0
------
t_10:
AdjList :  t_3 t_4 t_2 t_8 t_9
degree : 5
Alias :None
Color : null
Priority : 0
------
t_6:
AdjList :  vr14_1 vr13_1 t_3 t_4 t_2 vrax_1 vr15_1 vrbx_1 vr12_1 t_8 t_7
degree : 10
Alias :vrdi_1
Color : null
Priority : 0
------
t_8:
AdjList :  t_12 vr13_1 t_11 t_2 vr15_1 t_9 vrdi_1 vr14_1 t_3 t_4 t_10 vrax_1 vrbx_1 t_6 vr12_1 t_7
degree : 9
Alias :None
Color : null
Priority : 0
------
t_7:
AdjList :  t_3 t_4 t_2 t_6 t_8
degree : 5
Alias :vrax_1
Color : null
Priority : 0
------
========main move List Info ========
coalesced moves:
vrdi_1 = move t_1
t_7 = move vrax_1
vrdi_1 = move t_11
vrdi_1 = move t_6
t_8 = move t_13
------
constrained moves:
t_2 = move vrax_1
------
fronzen moves:
------
workList moves:
t_12 = move vrax_1
t_3 = move t_14
------
active moves:
========main Node List Info ========
simplify Nodes(low degree non move related):

------
freeze Nodes(low degree move related):
t_12(0) t_3(0) t_14(0) 
------
spill Nodes(high degree):

------
spilled Nodes:

------
coalesced Nodes:
t_11(0) t_1(0) t_13(0) t_6(0) t_7(0) 
------
colored Nodes:

------
selected Stack:
t_4(0) t_10(0) t_2(0) t_5(0) a_1(0) t_9(0) t_8(0) 
------

===================== Coalesce =====================
========main Graph Info ========
t_12:
AdjList :  t_3 t_4 t_2 t_8 t_9
degree : 1
Alias :vrax_1
Color : null
Priority : 0
------
t_11:
AdjList :  t_3 t_4 t_2 t_8 t_9
degree : 5
Alias :vrdi_1
Color : null
Priority : 0
------
t_2:
AdjList :  vr13_1 t_12 t_11 vr15_1 t_13 t_5 t_14 t_9 vrdi_1 vr14_1 t_3 t_4 t_1 t_10 vrax_1 vrbx_1 vr12_1 t_6 t_8 t_7
degree : 12
Alias :None
Color : null
Priority : 0
------
t_13:
AdjList :  t_3 t_4 t_2 t_9
degree : 1
Alias :t_8
Color : null
Priority : 0
------
t_5:
AdjList :  t_3 t_4 t_2
degree : 3
Alias :None
Color : null
Priority : 0
------
t_14:
AdjList :  t_4 t_2
degree : 0
Alias :None
Color : null
Priority : 0
------
a_1:
AdjList : 
degree : 0
Alias :None
Color : null
Priority : 0
------
t_9:
AdjList :  t_12 vr13_1 t_11 t_2 vr15_1 t_13 vrdi_1 vr14_1 t_3 t_4 t_10 vrax_1 vrbx_1 vr12_1 t_8
degree : 13
Alias :None
Color : null
Priority : 0
------
t_3:
AdjList :  vr13_1 t_12 t_11 t_2 vr15_1 t_13 t_5 t_9 vrdi_1 vr14_1 t_4 t_1 t_10 vrax_1 vrbx_1 vr12_1 t_6 t_8 t_7
degree : 7
Alias :None
Color : null
Priority : 0
------
t_4:
AdjList :  vr13_1 t_12 t_11 t_2 vr15_1 t_13 t_5 t_14 t_9 vrdi_1 vr14_1 t_3 t_10 vrax_1 vrbx_1 vr12_1 t_6 t_8 t_7
degree : 13
Alias :None
Color : null
Priority : 0
------
t_1:
AdjList :  vr14_1 t_3 vr13_1 t_2 vrax_1 vr15_1 vrbx_1 vr12_1
degree : 8
Alias :vrdi_1
Color : null
Priority : 0
------
t_10:
AdjList :  t_3 t_4 t_2 t_8 t_9
degree : 5
Alias :None
Color : null
Priority : 0
------
t_6:
AdjList :  vr14_1 vr13_1 t_3 t_4 t_2 vrax_1 vr15_1 vrbx_1 vr12_1 t_8 t_7
degree : 10
Alias :vrdi_1
Color : null
Priority : 0
------
t_8:
AdjList :  t_12 vr13_1 t_11 t_2 vr15_1 t_9 vrdi_1 vr14_1 t_3 t_4 t_10 vrax_1 vrbx_1 t_6 vr12_1 t_7
degree : 9
Alias :None
Color : null
Priority : 0
------
t_7:
AdjList :  t_3 t_4 t_2 t_6 t_8
degree : 5
Alias :vrax_1
Color : null
Priority : 0
------
========main move List Info ========
coalesced moves:
vrdi_1 = move t_1
t_7 = move vrax_1
vrdi_1 = move t_11
vrdi_1 = move t_6
t_8 = move t_13
t_12 = move vrax_1
------
constrained moves:
t_2 = move vrax_1
------
fronzen moves:
------
workList moves:
t_3 = move t_14
------
active moves:
========main Node List Info ========
simplify Nodes(low degree non move related):

------
freeze Nodes(low degree move related):
t_3(0) t_14(0) 
------
spill Nodes(high degree):

------
spilled Nodes:

------
coalesced Nodes:
t_12(0) t_11(0) t_1(0) t_13(0) t_6(0) t_7(0) 
------
colored Nodes:

------
selected Stack:
t_4(0) t_10(0) t_2(0) t_5(0) a_1(0) t_9(0) t_8(0) 
------

===================== Coalesce =====================
========main Graph Info ========
t_12:
AdjList :  t_3 t_4 t_2 t_8 t_9
degree : 1
Alias :vrax_1
Color : null
Priority : 0
------
t_11:
AdjList :  t_3 t_4 t_2 t_8 t_9
degree : 5
Alias :vrdi_1
Color : null
Priority : 0
------
t_2:
AdjList :  vr13_1 t_12 t_11 vr15_1 t_13 t_5 t_14 t_9 vrdi_1 vr14_1 t_3 t_4 t_1 t_10 vrax_1 vrbx_1 vr12_1 t_6 t_8 t_7
degree : 12
Alias :None
Color : null
Priority : 0
------
t_13:
AdjList :  t_3 t_4 t_2 t_9
degree : 1
Alias :t_8
Color : null
Priority : 0
------
t_5:
AdjList :  t_3 t_4 t_2
degree : 3
Alias :None
Color : null
Priority : 0
------
t_14:
AdjList :  t_4 t_2
degree : 0
Alias :t_3
Color : null
Priority : 0
------
a_1:
AdjList : 
degree : 0
Alias :None
Color : null
Priority : 0
------
t_9:
AdjList :  t_12 vr13_1 t_11 t_2 vr15_1 t_13 vrdi_1 vr14_1 t_3 t_4 t_10 vrax_1 vrbx_1 vr12_1 t_8
degree : 13
Alias :None
Color : null
Priority : 0
------
t_3:
AdjList :  vr13_1 t_12 t_11 t_2 vr15_1 t_13 t_5 t_9 vrdi_1 vr14_1 t_4 t_1 t_10 vrax_1 vrbx_1 vr12_1 t_6 t_8 t_7
degree : 7
Alias :None
Color : null
Priority : 0
------
t_4:
AdjList :  vr13_1 t_12 t_11 t_2 vr15_1 t_13 t_5 t_14 t_9 vrdi_1 vr14_1 t_3 t_10 vrax_1 vrbx_1 vr12_1 t_6 t_8 t_7
degree : 13
Alias :None
Color : null
Priority : 0
------
t_1:
AdjList :  vr14_1 t_3 vr13_1 t_2 vrax_1 vr15_1 vrbx_1 vr12_1
degree : 8
Alias :vrdi_1
Color : null
Priority : 0
------
t_10:
AdjList :  t_3 t_4 t_2 t_8 t_9
degree : 5
Alias :None
Color : null
Priority : 0
------
t_6:
AdjList :  vr14_1 vr13_1 t_3 t_4 t_2 vrax_1 vr15_1 vrbx_1 vr12_1 t_8 t_7
degree : 10
Alias :vrdi_1
Color : null
Priority : 0
------
t_8:
AdjList :  t_12 vr13_1 t_11 t_2 vr15_1 t_9 vrdi_1 vr14_1 t_3 t_4 t_10 vrax_1 vrbx_1 t_6 vr12_1 t_7
degree : 9
Alias :None
Color : null
Priority : 0
------
t_7:
AdjList :  t_3 t_4 t_2 t_6 t_8
degree : 5
Alias :vrax_1
Color : null
Priority : 0
------
========main move List Info ========
coalesced moves:
vrdi_1 = move t_1
t_7 = move vrax_1
vrdi_1 = move t_11
vrdi_1 = move t_6
t_8 = move t_13
t_12 = move vrax_1
t_3 = move t_14
------
constrained moves:
t_2 = move vrax_1
------
fronzen moves:
------
workList moves:
------
active moves:
========main Node List Info ========
simplify Nodes(low degree non move related):
t_3(0) 
------
freeze Nodes(low degree move related):

------
spill Nodes(high degree):

------
spilled Nodes:

------
coalesced Nodes:
t_12(0) t_11(0) t_1(0) t_13(0) t_14(0) t_6(0) t_7(0) 
------
colored Nodes:

------
selected Stack:
t_4(0) t_10(0) t_2(0) t_5(0) a_1(0) t_9(0) t_8(0) 
------

===================== Simplify =====================
========main Graph Info ========
t_12:
AdjList :  t_3 t_4 t_2 t_8 t_9
degree : 1
Alias :vrax_1
Color : null
Priority : 0
------
t_11:
AdjList :  t_3 t_4 t_2 t_8 t_9
degree : 5
Alias :vrdi_1
Color : null
Priority : 0
------
t_2:
AdjList :  vr13_1 t_12 t_11 vr15_1 t_13 t_5 t_14 t_9 vrdi_1 vr14_1 t_3 t_4 t_1 t_10 vrax_1 vrbx_1 vr12_1 t_6 t_8 t_7
degree : 12
Alias :None
Color : null
Priority : 0
------
t_13:
AdjList :  t_3 t_4 t_2 t_9
degree : 1
Alias :t_8
Color : null
Priority : 0
------
t_5:
AdjList :  t_3 t_4 t_2
degree : 3
Alias :None
Color : null
Priority : 0
------
t_14:
AdjList :  t_4 t_2
degree : 0
Alias :t_3
Color : null
Priority : 0
------
a_1:
AdjList : 
degree : 0
Alias :None
Color : null
Priority : 0
------
t_9:
AdjList :  t_12 vr13_1 t_11 t_2 vr15_1 t_13 vrdi_1 vr14_1 t_3 t_4 t_10 vrax_1 vrbx_1 vr12_1 t_8
degree : 13
Alias :None
Color : null
Priority : 0
------
t_3:
AdjList :  vr13_1 t_12 t_11 t_2 vr15_1 t_13 t_5 t_9 vrdi_1 vr14_1 t_4 t_1 t_10 vrax_1 vrbx_1 vr12_1 t_6 t_8 t_7
degree : 7
Alias :None
Color : null
Priority : 0
------
t_4:
AdjList :  vr13_1 t_12 t_11 t_2 vr15_1 t_13 t_5 t_14 t_9 vrdi_1 vr14_1 t_3 t_10 vrax_1 vrbx_1 vr12_1 t_6 t_8 t_7
degree : 13
Alias :None
Color : null
Priority : 0
------
t_1:
AdjList :  vr14_1 t_3 vr13_1 t_2 vrax_1 vr15_1 vrbx_1 vr12_1
degree : 8
Alias :vrdi_1
Color : null
Priority : 0
------
t_10:
AdjList :  t_3 t_4 t_2 t_8 t_9
degree : 5
Alias :None
Color : null
Priority : 0
------
t_6:
AdjList :  vr14_1 vr13_1 t_3 t_4 t_2 vrax_1 vr15_1 vrbx_1 vr12_1 t_8 t_7
degree : 10
Alias :vrdi_1
Color : null
Priority : 0
------
t_8:
AdjList :  t_12 vr13_1 t_11 t_2 vr15_1 t_9 vrdi_1 vr14_1 t_3 t_4 t_10 vrax_1 vrbx_1 t_6 vr12_1 t_7
degree : 9
Alias :None
Color : null
Priority : 0
------
t_7:
AdjList :  t_3 t_4 t_2 t_6 t_8
degree : 5
Alias :vrax_1
Color : null
Priority : 0
------
========main move List Info ========
coalesced moves:
vrdi_1 = move t_1
t_7 = move vrax_1
vrdi_1 = move t_11
vrdi_1 = move t_6
t_8 = move t_13
t_12 = move vrax_1
t_3 = move t_14
------
constrained moves:
t_2 = move vrax_1
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
t_12(0) t_11(0) t_1(0) t_13(0) t_14(0) t_6(0) t_7(0) 
------
colored Nodes:

------
selected Stack:
t_3(0) t_4(0) t_10(0) t_2(0) t_5(0) a_1(0) t_9(0) t_8(0) 
------

===================== after ASSIGN =====================
========main Graph Info ========
t_12:
AdjList :  t_3 t_4 t_2 t_8 t_9
degree : 1
Alias :vrax_1
Color : rax
Priority : 0
------
t_11:
AdjList :  t_3 t_4 t_2 t_8 t_9
degree : 5
Alias :vrdi_1
Color : rdi
Priority : 0
------
t_2:
AdjList :  vr13_1 t_12 t_11 vr15_1 t_13 t_5 t_14 t_9 vrdi_1 vr14_1 t_3 t_4 t_1 t_10 vrax_1 vrbx_1 vr12_1 t_6 t_8 t_7
degree : 12
Alias :None
Color : rdx
Priority : 0
------
t_13:
AdjList :  t_3 t_4 t_2 t_9
degree : 1
Alias :t_8
Color : rsi
Priority : 0
------
t_5:
AdjList :  t_3 t_4 t_2
degree : 3
Alias :None
Color : r13
Priority : 0
------
t_14:
AdjList :  t_4 t_2
degree : 0
Alias :t_3
Color : r10
Priority : 0
------
a_1:
AdjList : 
degree : 0
Alias :None
Color : r13
Priority : 0
------
t_9:
AdjList :  t_12 vr13_1 t_11 t_2 vr15_1 t_13 vrdi_1 vr14_1 t_3 t_4 t_10 vrax_1 vrbx_1 vr12_1 t_8
degree : 13
Alias :None
Color : r11
Priority : 0
------
t_3:
AdjList :  vr13_1 t_12 t_11 t_2 vr15_1 t_13 t_5 t_9 vrdi_1 vr14_1 t_4 t_1 t_10 vrax_1 vrbx_1 vr12_1 t_6 t_8 t_7
degree : 7
Alias :None
Color : r10
Priority : 0
------
t_4:
AdjList :  vr13_1 t_12 t_11 t_2 vr15_1 t_13 t_5 t_14 t_9 vrdi_1 vr14_1 t_3 t_10 vrax_1 vrbx_1 vr12_1 t_6 t_8 t_7
degree : 13
Alias :None
Color : r8
Priority : 0
------
t_1:
AdjList :  vr14_1 t_3 vr13_1 t_2 vrax_1 vr15_1 vrbx_1 vr12_1
degree : 8
Alias :vrdi_1
Color : rdi
Priority : 0
------
t_10:
AdjList :  t_3 t_4 t_2 t_8 t_9
degree : 5
Alias :None
Color : r13
Priority : 0
------
t_6:
AdjList :  vr14_1 vr13_1 t_3 t_4 t_2 vrax_1 vr15_1 vrbx_1 vr12_1 t_8 t_7
degree : 10
Alias :vrdi_1
Color : rdi
Priority : 0
------
t_8:
AdjList :  t_12 vr13_1 t_11 t_2 vr15_1 t_9 vrdi_1 vr14_1 t_3 t_4 t_10 vrax_1 vrbx_1 t_6 vr12_1 t_7
degree : 9
Alias :None
Color : rsi
Priority : 0
------
t_7:
AdjList :  t_3 t_4 t_2 t_6 t_8
degree : 5
Alias :vrax_1
Color : rax
Priority : 0
------
========main move List Info ========
coalesced moves:
vrdi_1 = move t_1
t_7 = move vrax_1
vrdi_1 = move t_11
vrdi_1 = move t_6
t_8 = move t_13
t_12 = move vrax_1
t_3 = move t_14
------
constrained moves:
t_2 = move vrax_1
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
t_12(0) t_11(0) t_1(0) t_13(0) t_14(0) t_6(0) t_7(0) 
------
colored Nodes:
t_3(0) t_4(0) t_2(0) t_10(0) t_5(0) a_1(0) t_8(0) t_9(0) 
------
selected Stack:

------

=====================__init Iteration 0=====================
========__init Graph Info ========
t_16:
AdjList : 
degree : 0
Alias :None
Color : null
Priority : 0
------
t_15:
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
t_16 = move t_15
vrax_1 = move t_16
t_15 = move vrax_1
------
active moves:
========__init Node List Info ========
simplify Nodes(low degree non move related):

------
freeze Nodes(low degree move related):
t_15(0) t_16(0) 
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

define i64 @main  {
main_entry_1:
   %t_1 = mul 10 8
   %t_1 = add %t_1 8
   %vrdi_1 = move %t_1
   %vrax_1 = alloc %vrdi_1
   %t_2 = move %vrax_1
   store 10 %t_2
   %t_3 = add %t_2 8
   %t_4 = add %t_2 %t_1
   jump main_for_cond_1
main_for_cond_1:
   %t_5 = slt %t_3 %t_4
   br %t_5 main_for_body_1 main_for_merge_1
main_for_body_1:
   %t_6 = mul 10 8
   %t_6 = add %t_6 8
   %vrdi_1 = move %t_6
   %vrax_1 = alloc %vrdi_1
   %t_7 = move %vrax_1
   store 10 %t_7
   store %t_7 %t_3
   %t_8 = add %t_7 8
   %t_9 = add %t_7 %t_6
   jump main_for_cond_2
main_for_cond_2:
   %t_10 = slt %t_8 %t_9
   br %t_10 main_for_body_2 main_for_merge_2
main_for_body_2:
   %t_11 = mul 10 8
   %t_11 = add %t_11 8
   %vrdi_1 = move %t_11
   %vrax_1 = alloc %vrdi_1
   %t_12 = move %vrax_1
   store 10 %t_12
   store %t_12 %t_8
   jump main_for_step_1
main_for_step_1:
   %t_13 = add %t_8 8
   %t_8 = move %t_13
   jump main_for_cond_2
main_for_merge_2:
   jump main_for_step_2
main_for_step_2:
   %t_14 = add %t_3 8
   %t_3 = move %t_14
   jump main_for_cond_1
main_for_merge_1:
   %vrax_1 = move 0
   ret %vrax_1
}

define i64 @__init  {
__init_entry_1:
   %vrax_1 = call main 
   %t_15 = move %vrax_1
   %t_16 = move %t_15
   %vrax_1 = move %t_16
   ret %vrax_1
}

===================== Coalesce =====================
========__init Graph Info ========
t_16:
AdjList : 
degree : 0
Alias :None
Color : null
Priority : 0
------
t_15:
AdjList : 
degree : 0
Alias :t_16
Color : null
Priority : 0
------
========__init move List Info ========
coalesced moves:
t_16 = move t_15
------
constrained moves:
------
fronzen moves:
------
workList moves:
vrax_1 = move t_16
t_15 = move vrax_1
------
active moves:
========__init Node List Info ========
simplify Nodes(low degree non move related):

------
freeze Nodes(low degree move related):
t_16(0) 
------
spill Nodes(high degree):

------
spilled Nodes:

------
coalesced Nodes:
t_15(0) 
------
colored Nodes:

------
selected Stack:

------

===================== Coalesce =====================
========__init Graph Info ========
t_16:
AdjList : 
degree : 0
Alias :vrax_1
Color : null
Priority : 0
------
t_15:
AdjList : 
degree : 0
Alias :t_16
Color : null
Priority : 0
------
========__init move List Info ========
coalesced moves:
t_16 = move t_15
vrax_1 = move t_16
------
constrained moves:
------
fronzen moves:
------
workList moves:
t_15 = move vrax_1
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
t_15(0) t_16(0) 
------
colored Nodes:

------
selected Stack:

------

===================== Coalesce =====================
========__init Graph Info ========
t_16:
AdjList : 
degree : 0
Alias :vrax_1
Color : null
Priority : 0
------
t_15:
AdjList : 
degree : 0
Alias :vrax_1
Color : null
Priority : 0
------
========__init move List Info ========
coalesced moves:
t_16 = move t_15
vrax_1 = move t_16
t_15 = move vrax_1
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
t_15(0) t_16(0) 
------
colored Nodes:

------
selected Stack:

------

===================== after ASSIGN =====================
========__init Graph Info ========
t_16:
AdjList : 
degree : 0
Alias :vrax_1
Color : rax
Priority : 0
------
t_15:
AdjList : 
degree : 0
Alias :vrax_1
Color : rax
Priority : 0
------
========__init move List Info ========
coalesced moves:
t_16 = move t_15
vrax_1 = move t_16
t_15 = move vrax_1
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
t_15(0) t_16(0) 
------
colored Nodes:

------
selected Stack:

------

