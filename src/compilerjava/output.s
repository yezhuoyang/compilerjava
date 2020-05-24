       .text

       .globl	tmp_tmp_entry_1					 # -- Begin function tmp_tmp_entry_1
       .p2align	2
       .type	tmp_tmp_entry_1,@function
tmp_tmp_entry_1:
       addi	sp, sp, -64
       sw	s4, 44(sp)
       sw	s1, 40(sp)
       sw	s10, 36(sp)
       sw	s6, 32(sp)
       sw	s9, 28(sp)
       sw	s11, 24(sp)
       sw	s8, 20(sp)
       sw	s3, 16(sp)
       sw	s2, 12(sp)
       sw	s5, 8(sp)
       sw	s7, 4(sp)
       sw	ra, 0(sp)
       addi	s5, a0, 0
       li	s2, 4
       sw	s2, 0(s5)
       addi	s2, a0, 4
       li	s5, 5
       sw	s5, 0(s2)
       li	a0, 0
       lw	ra, 0(sp)
       lw	s7, 4(sp)
       lw	s5, 8(sp)
       lw	s2, 12(sp)
       lw	s3, 16(sp)
       lw	s8, 20(sp)
       lw	s11, 24(sp)
       lw	s9, 28(sp)
       lw	s6, 32(sp)
       lw	s10, 36(sp)
       lw	s1, 40(sp)
       lw	s4, 44(sp)
       addi	sp, sp, 64
       ret
						 # -- End function
       .globl	tmp_fuck_entry_1					 # -- Begin function tmp_fuck_entry_1
       .p2align	2
       .type	tmp_fuck_entry_1,@function
tmp_fuck_entry_1:
       addi	sp, sp, -64
       sw	s4, 44(sp)
       sw	s1, 40(sp)
       sw	s10, 36(sp)
       sw	s6, 32(sp)
       sw	s9, 28(sp)
       sw	s11, 24(sp)
       sw	s8, 20(sp)
       sw	s3, 16(sp)
       sw	s2, 12(sp)
       sw	s5, 8(sp)
       sw	s7, 4(sp)
       sw	ra, 0(sp)
       addi	s2, a0, 0
       addi	s5, a0, 4
       lw	s2, 0(s2)
       lw	s5, 0(s5)
       add	a0, s2, s5
       lw	ra, 0(sp)
       lw	s7, 4(sp)
       lw	s5, 8(sp)
       lw	s2, 12(sp)
       lw	s3, 16(sp)
       lw	s8, 20(sp)
       lw	s11, 24(sp)
       lw	s9, 28(sp)
       lw	s6, 32(sp)
       lw	s10, 36(sp)
       lw	s1, 40(sp)
       lw	s4, 44(sp)
       addi	sp, sp, 64
       ret
						 # -- End function
       .globl	main_entry_1					 # -- Begin function main_entry_1
       .p2align	2
       .type	main_entry_1,@function
main_entry_1:
       addi	sp, sp, -64
       sw	s4, 44(sp)
       sw	s1, 40(sp)
       sw	s10, 36(sp)
       sw	s6, 32(sp)
       sw	s9, 28(sp)
       sw	s11, 24(sp)
       sw	s8, 20(sp)
       sw	s3, 16(sp)
       sw	s2, 12(sp)
       sw	s5, 8(sp)
       sw	s7, 4(sp)
       sw	ra, 0(sp)
       li	a0, 8
       call	malloc
       sw	t1, 48(sp)
       sw	a0, 48(sp)
       lw	a0, 48(sp)
       call	tmp_tmp_entry_1
       lw	a0, 48(sp)
       call	tmp_fuck_entry_1
       lw	ra, 0(sp)
       lw	s7, 4(sp)
       lw	s5, 8(sp)
       lw	s2, 12(sp)
       lw	s3, 16(sp)
       lw	s8, 20(sp)
       lw	s11, 24(sp)
       lw	s9, 28(sp)
       lw	s6, 32(sp)
       lw	s10, 36(sp)
       lw	s1, 40(sp)
       lw	s4, 44(sp)
       addi	sp, sp, 64
       ret
						 # -- End function
       .globl	main					 # -- Begin function main
       .p2align	2
       .type	main,@function
main:
       addi	sp, sp, -64
       sw	s4, 44(sp)
       sw	s1, 40(sp)
       sw	s10, 36(sp)
       sw	s6, 32(sp)
       sw	s9, 28(sp)
       sw	s11, 24(sp)
       sw	s8, 20(sp)
       sw	s3, 16(sp)
       sw	s2, 12(sp)
       sw	s5, 8(sp)
       sw	s7, 4(sp)
       sw	ra, 0(sp)
       call	main_entry_1
       lw	ra, 0(sp)
       lw	s7, 4(sp)
       lw	s5, 8(sp)
       lw	s2, 12(sp)
       lw	s3, 16(sp)
       lw	s8, 20(sp)
       lw	s11, 24(sp)
       lw	s9, 28(sp)
       lw	s6, 32(sp)
       lw	s10, 36(sp)
       lw	s1, 40(sp)
       lw	s4, 44(sp)
       addi	sp, sp, 64
       ret
						 # -- End function
       .section	.sdata,"aw",@progbits
