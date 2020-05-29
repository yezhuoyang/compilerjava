	.text

	.globl	main					 # -- Begin function main
	.p2align	2
	.type	main,@function
main:
#entry_0:
	addi	sp, sp, -48
	sw	s0,0(sp)
	sw	s1,4(sp)
	sw	s2,8(sp)
	sw	s5,12(sp)
	sw	s6,16(sp)
	sw	s8,20(sp)
	sw	s9,24(sp)
	sw	ra,28(sp)
	li	s0, 40
	mv	a0, s0
	call	malloc
	li	s9, 8
	sw	s9,0(a0)
	addi	s8, a0, 8
	lui	t4, %hi(row)
	sw	s8,%lo(row)(t4)
	mv	a0, s0
	call	malloc
	sw	s9,0(a0)
	addi	s0, a0, 8
	lui	t4, %hi(col)
	sw	s0,%lo(col)(t4)
	li	a0, 16
	call	malloc
	li	s6, 2
	sw	s6,0(a0)
	addi	s1, a0, 8
	lui	t4, %hi(d)
	sw	s1,%lo(d)(t4)
	li	s2, 68
	li	s5, 15
#critEdge_1:
	mv	t4, zero
	j	for_cond_2
for_loop_3:
	slli	t5, t4, 2
	add	t5, t5, s8
	sw	zero,0(t5)
	slli	t5, t4, 2
	add	t5, t5, s0
	sw	zero,0(t5)
	addi	t4, t4, 1
#critEdge.1_5:
for_cond_2:
	blt	t4, s9, for_loop_3
#critEdge.3_4:
	mv	s0, zero
	j	for_cond.1_6
for_loop.1_7:
	mv	a0, s2
	call	malloc
	sw	s5,0(a0)
	addi	t5, a0, 8
	slli	t4, s0, 2
	add	t4, t4, s1
	sw	t5,0(t4)
#critEdge.4_9:
	mv	t4, zero
	j	for_cond.2_10
for_loop.2_11:
	slli	t6, t4, 2
	add	t6, t6, t5
	sw	zero,0(t6)
	addi	t4, t4, 1
#critEdge.5_13:
for_cond.2_10:
	blt	t4, s5, for_loop.2_11
#for_step.2_12:
	addi	s0, s0, 1
#critEdge.2_14:
for_cond.1_6:
	blt	s0, s6, for_loop.1_7
#for_afterLoop.2_8:
	mv	a0, zero
	call	search
	mv	a0, zero
	lw	s0, 0(sp)
	lw	s5, 12(sp)
	lw	s2, 8(sp)
	lw	s8, 20(sp)
	lw	s1, 4(sp)
	lw	s6, 16(sp)
	lw	s9, 24(sp)
	lw	ra, 28(sp)
	addi	sp, sp, 48
	ret
						 # -- End function
	.globl	search					 # -- Begin function search
	.p2align	2
	.type	search,@function
search:
#entry_15:
	addi	sp, sp, -48
	sw	s0,0(sp)
	sw	s1,4(sp)
	sw	s2,8(sp)
	sw	s3,12(sp)
	sw	s4,16(sp)
	sw	s5,20(sp)
	sw	s6,24(sp)
	sw	s7,28(sp)
	sw	s8,32(sp)
	sw	s9,36(sp)
	sw	ra,40(sp)
	mv	s0, a0
	lw	s6, N
	li	s4, 1
	beq	s0, s6, entry.1_16
#preHeader_17:
	lw	s7, row
	lw	t4, d
	lw	s8, 0(t4)
	lw	s9, 4(t4)
	lw	t5, col
	slli	t4, s0, 2
	add	s2, t4, t5
	addi	s5, s0, 1
#critEdge.1_32:
	mv	s1, zero
	j	for_cond_18
for_loop_19:
	slli	t4, s1, 2
	add	s3, t4, s7
	lw	t4, 0(s3)
	xori	t4, t4, 0
	seqz	t4, t4
	bne	t4, zero, land.true_21
#critEdge.2_22:
	j	land.merge_24
land.true_21:
	add	t4, s1, s0
	slli	t4, t4, 2
	add	t4, t4, s8
	lw	t4, 0(t4)
	xori	t4, t4, 0
	seqz	t4, t4
#critEdge.3_23:
land.merge_24:
	bne	t4, zero, land.true.1_25
#critEdge.4_26:
	j	land.merge.1_28
land.true.1_25:
	add	t4, s1, s6
	addi	t4, t4, -1
	sub	t4, t4, s0
	slli	t4, t4, 2
	add	t4, t4, s9
	lw	t4, 0(t4)
	xori	t4, t4, 0
	seqz	t4, t4
#critEdge.5_27:
land.merge.1_28:
	bne	t4, zero, if_then.1_29
	j	for_step_30
if_then.1_29:
	add	t4, s1, s6
	addi	t4, t4, -1
	sub	t4, t4, s0
	slli	t4, t4, 2
	add	t4, t4, s9
	sw	s4,0(t4)
	add	t4, s1, s0
	slli	t4, t4, 2
	add	t4, t4, s8
	sw	s4,0(t4)
	sw	s4,0(s3)
	sw	s1,0(s2)
	mv	a0, s5
	call	search
	sw	zero,0(s3)
	add	t4, s1, s0
	slli	t4, t4, 2
	add	t4, t4, s8
	sw	zero,0(t4)
	add	t4, s1, s6
	addi	t4, t4, -1
	sub	t4, t4, s0
	slli	t4, t4, 2
	add	t4, t4, s9
	sw	zero,0(t4)
for_step_30:
	addi	s1, s1, 1
#critEdge_31:
for_cond_18:
	blt	s1, s6, for_loop_19
return_20:
	lw	s4, 16(sp)
	lw	s3, 12(sp)
	lw	s0, 0(sp)
	lw	s5, 20(sp)
	lw	s7, 28(sp)
	lw	s2, 8(sp)
	lw	s8, 32(sp)
	lw	s1, 4(sp)
	lw	s6, 24(sp)
	lw	s9, 36(sp)
	lw	ra, 40(sp)
	addi	sp, sp, 48
	ret
entry.1_16:
	lw	s5, col
	la	s4, .str
	la	s2, .str.1
	la	s1, .str.2
#critEdge.6_33:
	mv	s3, zero
	j	for_cond.1_34
for_loop.1_38:
	beq	s7, s0, if_then.2_40
#if_else.2_41:
	mv	a0, s2
	call	print
for_step.1_42:
	addi	s0, s0, 1
#critEdge.8_43:
for_cond.1.1_37:
	blt	s0, s6, for_loop.1_38
#for_afterLoop.1_39:
	mv	a0, s1
	call	println
	addi	s3, s3, 1
#critEdge.7_44:
for_cond.1_34:
	blt	s3, s6, preHeader.1_35
#for_afterLoop.1.1_36:
	mv	a0, s1
	call	println
	j	return_20
if_then.2_40:
	mv	a0, s4
	call	print
	j	for_step.1_42
preHeader.1_35:
	slli	t4, s3, 2
	add	t4, t4, s5
	lw	s7, 0(t4)
#critEdge.9_45:
	mv	s0, zero
	j	for_cond.1.1_37
						 # -- End function
	.section	.sdata,"aw",@progbits
	.globl	N					#@N
	.p2align	2
N:
	.word	8
	.globl	row					#@row
	.p2align	2
row:
	.word	0
	.globl	col					#@col
	.p2align	2
col:
	.word	0
	.globl	d					#@d
	.p2align	2
d:
	.word	0
	.globl	.str					#@.str
.str:
	.asciz	" O"
	.globl	.str.1					#@.str.1
.str.1:
	.asciz	" ."
	.globl	.str.2					#@.str.2
.str.2:
	.asciz	""
