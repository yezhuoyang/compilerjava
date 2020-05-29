       .text

       .globl	printBoard_entry_1					 # -- Begin function printBoard_entry_1
       .p2align	2
       .type	printBoard_entry_1,@function
printBoard_entry_1:
       addi	sp, sp, -64
       sw	s4, 44(sp)
       sw	s9, 40(sp)
       sw	s5, 36(sp)
       sw	s6, 32(sp)
       sw	s2, 28(sp)
       sw	s1, 24(sp)
       sw	s3, 20(sp)
       sw	s8, 16(sp)
       sw	s11, 12(sp)
       sw	s10, 8(sp)
       sw	s7, 4(sp)
       sw	ra, 0(sp)
       lw	s8, col_1
       lw	s7, N_1
       li	s9, 0
       j	printBoard_for_cond_1
printBoard_for_cond_1:
       blt	s9, s7 printBoard_for_body_1
printBoard_for_merge_1:
       la	a0, _str_const_1
       call	println
       lw	ra, 0(sp)
       lw	s7, 4(sp)
       lw	s10, 8(sp)
       lw	s11, 12(sp)
       lw	s8, 16(sp)
       lw	s3, 20(sp)
       lw	s1, 24(sp)
       lw	s2, 28(sp)
       lw	s6, 32(sp)
       lw	s5, 36(sp)
       lw	s9, 40(sp)
       lw	s4, 44(sp)
       addi	sp, sp, 64
       ret
printBoard_for_body_1:
       li	s1, 0
       j	printBoard_for_cond_2
printBoard_for_cond_2:
       blt	s1, s7 printBoard_for_body_2
printBoard_for_merge_2:
       la	a0, _str_const_2
       call	println
       j	printBoard_for_step_1
printBoard_for_step_1:
       addi	s9, s9, 1
       j	printBoard_for_cond_1
printBoard_for_body_2:
       li	s3, 4
       mul	s3, s9, s3
       addi	s3, s3, 4
       add	s3, s8, s3
       lw	s3, 0(s3)
       beq	s3, s1 printBoard_if_then_1
printBoard_if_else_1:
       la	a0, _str_const_3
       call	print
       j	printBoard_if_merge_1
printBoard_if_then_1:
       la	a0, _str_const_4
       call	print
       j	printBoard_if_merge_1
printBoard_if_merge_1:
       j	printBoard_for_step_2
printBoard_for_step_2:
       addi	s1, s1, 1
       j	printBoard_for_cond_2
						 # -- End function
       .globl	main_entry_1					 # -- Begin function main_entry_1
       .p2align	2
       .type	main_entry_1,@function
main_entry_1:
       addi	sp, sp, -64
       sw	s4, 44(sp)
       sw	s9, 40(sp)
       sw	s5, 36(sp)
       sw	s6, 32(sp)
       sw	s2, 28(sp)
       sw	s1, 24(sp)
       sw	s3, 20(sp)
       sw	s8, 16(sp)
       sw	s11, 12(sp)
       sw	s10, 8(sp)
       sw	s7, 4(sp)
       sw	ra, 0(sp)
       lw	s8, col_1
       lw	s7, row_1
       li	s1, 0
       j	main_for_cond_1
main_for_cond_1:
       li	s3, 8
       blt	s1, s3 main_for_body_1
main_for_merge_1:
       call	printBoard_entry_1
       call	printBoard_entry_1
       li	a0, 0
       lw	ra, 0(sp)
       lw	s7, 4(sp)
       lw	s10, 8(sp)
       lw	s11, 12(sp)
       lw	s8, 16(sp)
       lw	s3, 20(sp)
       lw	s1, 24(sp)
       lw	s2, 28(sp)
       lw	s6, 32(sp)
       lw	s5, 36(sp)
       lw	s9, 40(sp)
       lw	s4, 44(sp)
       addi	sp, sp, 64
       ret
main_for_body_1:
       li	s3, 4
       mul	s3, s1, s3
       addi	s3, s3, 4
       add	s3, s7, s3
       li	s9, 0
       sw	s9, 0(s3)
       li	s3, 4
       mul	s3, s1, s3
       addi	s3, s3, 4
       add	s3, s8, s3
       li	s9, 0
       sw	s9, 0(s3)
       j	main_for_step_1
main_for_step_1:
       addi	s1, s1, 1
       j	main_for_cond_1
						 # -- End function
       .globl	main					 # -- Begin function main
       .p2align	2
       .type	main,@function
main:
       addi	sp, sp, -64
       sw	s4, 44(sp)
       sw	s9, 40(sp)
       sw	s5, 36(sp)
       sw	s6, 32(sp)
       sw	s2, 28(sp)
       sw	s1, 24(sp)
       sw	s3, 20(sp)
       sw	s8, 16(sp)
       sw	s11, 12(sp)
       sw	s10, 8(sp)
       sw	s7, 4(sp)
       sw	ra, 0(sp)
       lw	a0, col_1
       lw	s9, N_1
       lw	s3, row_1
       li	s9, 8
       li	a0, 32
       addi	a0, a0, 4
       call	malloc
       mv	s3, a0
       li	s8, 8
       sw	s8, 0(s3)
       li	a0, 32
       addi	a0, a0, 4
       call	malloc
       li	s8, 8
       sw	s8, 0(a0)
       lui	s8, %hi(row_1)
       sw	s3, %lo(row_1)(s8)
       lui	s3, %hi(N_1)
       sw	s9, %lo(N_1)(s3)
       lui	s3, %hi(col_1)
       sw	a0, %lo(col_1)(s3)
       call	main_entry_1
       lw	ra, 0(sp)
       lw	s7, 4(sp)
       lw	s10, 8(sp)
       lw	s11, 12(sp)
       lw	s8, 16(sp)
       lw	s3, 20(sp)
       lw	s1, 24(sp)
       lw	s2, 28(sp)
       lw	s6, 32(sp)
       lw	s5, 36(sp)
       lw	s9, 40(sp)
       lw	s4, 44(sp)
       addi	sp, sp, 64
       ret
						 # -- End function
       .section	.sdata,"aw",@progbits
       .globl	N_1						#@N_1
       .p2align	2
N_1:
       .word	0
       .globl	row_1						#@row_1
       .p2align	2
row_1:
       .word	0
       .globl	col_1						#@col_1
       .p2align	2
col_1:
       .word	0
       .globl	_str_const_4						#@_str_const_4
_str_const_4:
       .asciz	" O"
       .globl	_str_const_3						#@_str_const_3
_str_const_3:
       .asciz	" ."
       .globl	_str_const_2						#@_str_const_2
_str_const_2:
       .asciz	""
       .globl	_str_const_1						#@_str_const_1
_str_const_1:
       .asciz	""
