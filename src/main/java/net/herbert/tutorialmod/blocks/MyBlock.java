package net.herbert.tutorialmod.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.RedstoneBlock;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.text.LiteralText;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class MyBlock extends RedstoneBlock {

    public static final BooleanProperty REDSTONE = BooleanProperty.of("redstone");

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> stateManager) {
        stateManager.add(REDSTONE);
    }

    public MyBlock(Settings settings) {
        super(settings);
        setDefaultState(getStateManager().getDefaultState().with(REDSTONE, false));
    }

    @Override
    public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit) {
        if (!world.isClient) {

            if(world.getBlockState(pos).get(REDSTONE) == false) {
                world.setBlockState(pos, state.with(REDSTONE, true));
                player.sendMessage(new LiteralText("off"), false);
            } else {
                world.setBlockState(pos, state.with(REDSTONE, false));
                player.sendMessage(new LiteralText("on"), false);
            }
            player.sendMessage(new LiteralText(String.valueOf(REDSTONE)), false);

        }

        return ActionResult.SUCCESS;
    }


    @Override
    public boolean emitsRedstonePower(BlockState state) {
        return state.get(REDSTONE);
    }


}
