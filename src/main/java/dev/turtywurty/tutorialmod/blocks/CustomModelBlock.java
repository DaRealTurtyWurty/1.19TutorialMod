package dev.turtywurty.tutorialmod.blocks;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.shapes.BooleanOp;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;

public class CustomModelBlock extends Block {
    private static final VoxelShape SHAPE = makeShape();

    public CustomModelBlock(Properties properties) {
        super(properties);
    }

    @Override
    public VoxelShape getShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext ctx) {
        return SHAPE;
    }

    public static VoxelShape makeShape(){
        VoxelShape shape = Shapes.empty();
        shape = Shapes.join(shape, Shapes.box(0.0625, 0, 0.0625, 0.9375, 0.0625, 0.9375), BooleanOp.OR);
        shape = Shapes.join(shape, Shapes.box(0.0625, 0.0625, 0.0625, 0.125, 1, 0.4375), BooleanOp.OR);
        shape = Shapes.join(shape, Shapes.box(0.0625, 0.0625, 0.5625, 0.125, 1, 0.9375), BooleanOp.OR);
        shape = Shapes.join(shape, Shapes.box(0.875, 0.0625, 0.0625, 0.9375, 1, 0.4375), BooleanOp.OR);
        shape = Shapes.join(shape, Shapes.box(0.875, 0.0625, 0.5625, 0.9375, 1, 0.9375), BooleanOp.OR);
        shape = Shapes.join(shape, Shapes.box(0.125, 0.0625, 0.0625, 0.4375, 1, 0.125), BooleanOp.OR);
        shape = Shapes.join(shape, Shapes.box(0.5625, 0.0625, 0.0625, 0.875, 1, 0.125), BooleanOp.OR);
        shape = Shapes.join(shape, Shapes.box(0.125, 0.0625, 0.875, 0.4375, 1, 0.9375), BooleanOp.OR);
        shape = Shapes.join(shape, Shapes.box(0.5625, 0.0625, 0.875, 0.875, 1, 0.9375), BooleanOp.OR);
        shape = Shapes.join(shape, Shapes.box(0.375, 0.4375, 0.9375, 0.625, 0.625, 1), BooleanOp.OR);
        shape = Shapes.join(shape, Shapes.box(0.375, 0.4375, 0, 0.625, 0.625, 0.0625), BooleanOp.OR);
        shape = Shapes.join(shape, Shapes.box(0.9375, 0.4375, 0.375, 1, 0.625, 0.625), BooleanOp.OR);
        shape = Shapes.join(shape, Shapes.box(0, 0.4375, 0.375, 0.0625, 0.625, 0.625), BooleanOp.OR);
        shape = Shapes.join(shape, Shapes.box(0.125, 0.0625, 0.125, 0.875, 0.5625, 0.875), BooleanOp.OR);
        shape = Shapes.join(shape, Shapes.box(0.125, 0.5625, 0.5, 0.875, 0.6875, 0.875), BooleanOp.OR);
        shape = Shapes.join(shape, Shapes.box(0.125, 0.5625, 0.3125, 0.875, 0.625, 0.5), BooleanOp.OR);

        return shape;
    }
}
