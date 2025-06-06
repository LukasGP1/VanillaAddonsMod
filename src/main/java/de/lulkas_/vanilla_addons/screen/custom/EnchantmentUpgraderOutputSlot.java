package de.lulkas_.vanilla_addons.screen.custom;

import de.lulkas_.vanilla_addons.block.entity.custom.EnchantmentUpgraderBlockEntity;
import de.lulkas_.vanilla_addons.block.entity.util.EnchantmentUpgraderOutput;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.Inventory;
import net.minecraft.item.ItemStack;
import net.minecraft.screen.slot.Slot;
import net.minecraft.server.network.ServerPlayerEntity;

public class EnchantmentUpgraderOutputSlot extends Slot {
    private final PlayerEntity player;
    private final EnchantmentUpgraderBlockEntity blockEntity;

    public EnchantmentUpgraderOutputSlot(Inventory inventory, int index, int x, int y, PlayerEntity player, EnchantmentUpgraderBlockEntity blockEntity) {
        super(inventory, index, x, y);
        this.player = player;
        this.blockEntity = blockEntity;
    }

    @Override
    public boolean canInsert(ItemStack stack) {
        return false;
    }

    @Override
    public ItemStack takeStack(int amount) {
        if(this.player instanceof ServerPlayerEntity serverPlayer) {
            EnchantmentUpgraderOutput output = blockEntity.getScreenHandler().getOutput();
            if(player.isCreative()) {
                ItemStack toReturn = output.outputStack().copy();
                blockEntity.inventory.clear();
                return toReturn;
            } else if(output.requiredXPLevels() <= player.experienceLevel) {
                ItemStack toReturn = output.outputStack().copy();
                serverPlayer.addExperienceLevels(-output.requiredXPLevels());
                blockEntity.inventory.clear();
                return toReturn;
            }
        }
        return ItemStack.EMPTY;
    }
}
