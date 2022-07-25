package dev.turtywurty.tutorialmod.blocks;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.BonemealableBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;

public class AdvancedBlock extends Block {
    public AdvancedBlock(Properties properties) {
        super(properties);
    }

    @Override
    public InteractionResult use(BlockState state, Level level, BlockPos pos, Player player, InteractionHand hand, BlockHitResult hitResult) {
        if(!level.isClientSide()) {
            bonemealBlocks((ServerLevel) level, pos);
        }

        return InteractionResult.sidedSuccess(!level.isClientSide());
    }

    private static void bonemealBlocks(ServerLevel level, BlockPos pos) {
        int radius = 1;

        while(radius < 10) {
            for (Direction direction : Direction.values()) {
                BlockPos newPos = pos.relative(direction, radius);
                BlockState blockstate = level.getBlockState(newPos);
                if (blockstate.getBlock() instanceof BonemealableBlock bonemealable) {
                    for(int attempt = 0; attempt < 10; attempt++) {
                        bonemealable.performBonemeal(level, level.getRandom(), newPos, blockstate);
                        level.sendParticles(ParticleTypes.COMPOSTER, newPos.getX(), newPos.getY() + 1, newPos.getZ(), 1, 0, 0, 0, 0);
                    }
                }
            }

            ++radius;
        }
    }

    @Override
    public void randomTick(BlockState state, ServerLevel level, BlockPos pos, RandomSource random) {
        for(int i = 0; i < 1000; i++) {
            BlockPos particlePos = randomPointOnSphere(pos.above(20).offset(0.5, 0.5, 0.5), 10, random);
            level.sendParticles(ParticleTypes.COMPOSTER, particlePos.getX(), particlePos.getY(), particlePos.getZ(), 1, 0, 0, 0, 0);
        }
    }

    private static BlockPos randomPointOnSphere(BlockPos start, float radius, RandomSource random) {
        double u = random.nextDouble();
        double v = random.nextDouble();
        double theta = 2 * Math.PI * u;
        double phi = Math.acos(2 * v - 1);
        double x = radius * Math.sin(phi) * Math.cos(theta);
        double y = radius * Math.sin(phi) * Math.sin(theta);
        double z = radius * Math.cos(phi);
        return start.offset(x, y, z);
    }
}
