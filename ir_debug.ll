define i64 @main  {
main_entry_1:
   %sum_1 = move 0
   %q_1 = move 1
   %bb_1 = move 2
   %t_1 = mul %q_1 %bb_1
   %t_2 = add %sum_1 %t_1
   %t_3 = move %t_2
   ret %t_3
}

define i64 @__init  {
__init_entry_1:
   %t_4 = call main 
   %t_5 = move %t_4
   ret %t_5
}

=====================main Iteration 0=====================
========main Graph Info ========
sum_1:
AdjList :  bb_1 q_1 t_1
degree : 3
Alias :None
Color : null
Priority : 2
------
========main move List Info ========
coalesced moves:
------
constrained moves:
------
fronzen moves:
------
workList moves:
t_3 = move t_2
------
active moves:
========main Node List Info ========
simplify Nodes(low degree non move related):
sum_1(2) 
------
freeze Nodes(low degree move related):

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
   %sum_1 = move 0
   %q_1 = move 1
   %bb_1 = move 2
   %t_1 = mul %q_1 %bb_1
   %t_2 = add %sum_1 %t_1
   %t_3 = move %t_2
   ret %t_3
}

define i64 @__init  {
__init_entry_1:
   %t_4 = call main 
   %t_5 = move %t_4
   ret %t_5
}

===================== Simplify =====================
========main Graph Info ========
sum_1:
AdjList :  bb_1 q_1 t_1
degree : 3
Alias :None
Color : null
Priority : 2
------
========main move List Info ========
coalesced moves:
------
constrained moves:
------
fronzen moves:
------
workList moves:
t_3 = move t_2
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

------
colored Nodes:

------
selected Stack:
sum_1(2) 
------

===================== Coalesce =====================
========main Graph Info ========
sum_1:
AdjList :  bb_1 q_1 t_1
degree : 3
Alias :None
Color : null
Priority : 2
------
========main move List Info ========
coalesced moves:
t_3 = move t_2
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
t_3(2) 
------
freeze Nodes(low degree move related):

------
spill Nodes(high degree):

------
spilled Nodes:

------
coalesced Nodes:
t_2(2) 
------
colored Nodes:

------
selected Stack:
sum_1(2) 
------

===================== Simplify =====================
========main Graph Info ========
sum_1:
AdjList :  bb_1 q_1 t_1
degree : 3
Alias :None
Color : null
Priority : 2
------
========main move List Info ========
coalesced moves:
t_3 = move t_2
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
t_2(2) 
------
colored Nodes:

------
selected Stack:
t_3(2) sum_1(2) 
------

===================== after ASSIGN =====================
========main Graph Info ========
sum_1:
AdjList :  bb_1 q_1 t_1
degree : 3
Alias :None
Color : r12
Priority : 2
------
========main move List Info ========
coalesced moves:
t_3 = move t_2
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
t_2(2) 
------
colored Nodes:
t_3(2) sum_1(2) 
------
selected Stack:

------

=====================__init Iteration 0=====================
========__init Graph Info ========
t_4:
AdjList :  vrdi_1 vr10_1 vrsi_1 vr11_1 vr9_1 vrcx_1 vrax_1 vr8_1 vrdx_1
degree : 9
Alias :None
Color : null
Priority : 2
------
========__init move List Info ========
coalesced moves:
------
constrained moves:
------
fronzen moves:
------
workList moves:
t_5 = move t_4
------
active moves:
========__init Node List Info ========
simplify Nodes(low degree non move related):

------
freeze Nodes(low degree move related):
t_4(2) 
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
   %sum_1 = move 0
   %q_1 = move 1
   %bb_1 = move 2
   %t_1 = mul %q_1 %bb_1
   %t_2 = add %sum_1 %t_1
   %t_3 = move %t_2
   ret %t_3
}

define i64 @__init  {
__init_entry_1:
   %t_4 = call main 
   %t_5 = move %t_4
   ret %t_5
}

===================== Coalesce =====================
========__init Graph Info ========
t_4:
AdjList :  vrdi_1 vr10_1 vrsi_1 vr11_1 vr9_1 vrcx_1 vrax_1 vr8_1 vrdx_1
degree : 9
Alias :t_5
Color : null
Priority : 2
------
========__init move List Info ========
coalesced moves:
t_5 = move t_4
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
t_5(2) 
------
freeze Nodes(low degree move related):

------
spill Nodes(high degree):

------
spilled Nodes:

------
coalesced Nodes:
t_4(2) 
------
colored Nodes:

------
selected Stack:

------

===================== Simplify =====================
========__init Graph Info ========
t_4:
AdjList :  vrdi_1 vr10_1 vrsi_1 vr11_1 vr9_1 vrcx_1 vrax_1 vr8_1 vrdx_1
degree : 9
Alias :t_5
Color : null
Priority : 2
------
========__init move List Info ========
coalesced moves:
t_5 = move t_4
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
t_4(2) 
------
colored Nodes:

------
selected Stack:
t_5(2) 
------

===================== after ASSIGN =====================
========__init Graph Info ========
t_4:
AdjList :  vrdi_1 vr10_1 vrsi_1 vr11_1 vr9_1 vrcx_1 vrax_1 vr8_1 vrdx_1
degree : 9
Alias :t_5
Color : r12
Priority : 2
------
========__init move List Info ========
coalesced moves:
t_5 = move t_4
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
t_4(2) 
------
colored Nodes:
t_5(2) 
------
selected Stack:

------

