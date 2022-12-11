package dev.turtywurty.tutorialmod.menus;

import dev.turtywurty.tutorialmod.blockentities.CrusherBlockEntity;
import dev.turtywurty.tutorialmod.init.BlockInit;
import dev.turtywurty.tutorialmod.init.MenuInit;
import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.*;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.ItemStackHandler;
import net.minecraftforge.items.SlotItemHandler;

public class CrusherMenu extends AbstractContainerMenu {
    private final ContainerLevelAccess levelAccess;
    private final ContainerData data;

    protected CrusherMenu(int id, Inventory playerInv, IItemHandler slots, BlockPos pos, ContainerData data) {
        super(MenuInit.CRUSHER.get(), id);
        this.levelAccess = ContainerLevelAccess.create(playerInv.player.getLevel(), pos);
        this.data = data;

        addSlot(new SlotItemHandler(slots, 0, 56, 35));
        addSlot(new SlotWithRestriction(slots, 1, 116, 35));

        final int slotSizePlus2 = 18;
        final int startX = 8;
        final int startY = 84;
        final int hotbarY = 142;

        for(int row = 0; row < 3; ++row) {
            for(int column = 0; column < 9; ++column) {
                addSlot(new Slot(playerInv, column + row * 9 + 9, startX + column * slotSizePlus2,
                        startY + row * slotSizePlus2));
            }
        }

        for(int column = 0; column < 9; ++column) {
            addSlot(new Slot(playerInv, column, startX + column * slotSizePlus2, hotbarY));
        }

        this.addDataSlots(this.data);
    }

    public static CrusherMenu getClientMenu(int id, Inventory playerInv) {
        return new CrusherMenu(id, playerInv, new ItemStackHandler(2), BlockPos.ZERO, new SimpleContainerData(2));
    }

    public static MenuConstructor getServerMenu(CrusherBlockEntity blockEntity, BlockPos pos) {
        return (id,playerInv, player) -> new CrusherMenu(id,  playerInv, blockEntity.getInventory(), pos,
                blockEntity.getContainerData());
    }

    @Override
    public ItemStack quickMoveStack(Player player, int index) {
        ItemStack itemstack = ItemStack.EMPTY;
        Slot slot = this.slots.get(index);
        if (slot.hasItem()) {
            ItemStack current = slot.getItem();
            itemstack = current.copy();
            if (index < 2) {
                if (!this.moveItemStackTo(current, 2, this.slots.size(), true)) {
                    return ItemStack.EMPTY;
                }
            } else if (!this.moveItemStackTo(current, 0, 2, false)) {
                return ItemStack.EMPTY;
            }

            if (current.isEmpty()) {
                slot.set(ItemStack.EMPTY);
            } else {
                slot.setChanged();
            }
        }

        return itemstack;
    }

    @Override
    public boolean stillValid(Player player) {
        return stillValid(this.levelAccess, player, BlockInit.CRUSHER.get());
    }

    public ContainerData getData() {
        return data;
    }
}
