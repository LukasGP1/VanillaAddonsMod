package de.lulkas_.vanilla_addons.screen.custom;

import de.lulkas_.vanilla_addons.block.entity.custom.EnchantmentUpgraderBlockEntity;
import de.lulkas_.vanilla_addons.block.entity.util.EnchantmentUpgraderOutput;
import de.lulkas_.vanilla_addons.block.entity.util.EnchantmentUpgraderOutputGeneration;
import de.lulkas_.vanilla_addons.screen.ModScreenHandlers;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.Inventory;
import net.minecraft.item.ItemStack;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.screen.slot.Slot;
import net.minecraft.util.math.BlockPos;

import static de.lulkas_.vanilla_addons.block.entity.custom.EnchantmentUpgraderBlockEntity.INPUT_SLOT;
import static de.lulkas_.vanilla_addons.block.entity.custom.EnchantmentUpgraderBlockEntity.OUTPUT_SLOT;

public class EnchantmentUpgraderScreenHandler extends ScreenHandler {
    private final Inventory inventory;
    private final EnchantmentUpgraderBlockEntity blockEntity;
    private EnchantmentUpgraderOutput output = new EnchantmentUpgraderOutput(ItemStack.EMPTY, 0);

    public EnchantmentUpgraderScreenHandler(int syncId, PlayerInventory playerInventory, BlockPos pos) {
        this(syncId, playerInventory, playerInventory.player.getWorld().getBlockEntity(pos));
    }

    public EnchantmentUpgraderScreenHandler(int syncId, PlayerInventory playerInventory, BlockEntity blockEntity) {
        super(ModScreenHandlers.ENCHANTMENT_UPGRADER_SCREEN_HANDLER, syncId);
        this.inventory = ((Inventory) blockEntity);

        this.addSlot(new Slot(inventory, 0, 42, 35));
        if(blockEntity instanceof EnchantmentUpgraderBlockEntity enchantmentUpgraderBlockEntity) {
            this.blockEntity = enchantmentUpgraderBlockEntity;
            this.addSlot(new EnchantmentUpgraderOutputSlot(inventory, 1, 105, 36, playerInventory.player, enchantmentUpgraderBlockEntity));
        } else {
            this.blockEntity = null;
        }
        addPlayerInventory(playerInventory);
        addPlayerHotbar(playerInventory);

        if(this.blockEntity != null) {
            this.blockEntity.setScreenHandler(this);
        }
    }

    public void tick(EnchantmentUpgraderBlockEntity blockEntity) {
        EnchantmentUpgraderOutput output = EnchantmentUpgraderOutputGeneration.getOutput(blockEntity.inventory.get(INPUT_SLOT));
        this.output = output;
        blockEntity.inventory.set(OUTPUT_SLOT, output.outputStack());
    }

    @Override
    public void onClosed(PlayerEntity player) {
        super.onClosed(player);
        if(this.blockEntity != null) {
            this.blockEntity.resetScreenHandler();
        }
    }

    @Override
    public ItemStack quickMove(PlayerEntity player, int invSlot) {
        ItemStack newStack = ItemStack.EMPTY;
        Slot slot = this.slots.get(invSlot);
        if (slot != null && slot.hasStack()) {
            ItemStack originalStack = slot.getStack();
            newStack = originalStack.copy();
            if (invSlot < this.inventory.size()) {
                if (!this.insertItem(originalStack, this.inventory.size(), this.slots.size(), true)) {
                    return ItemStack.EMPTY;
                }
            } else if (!this.insertItem(originalStack, 0, this.inventory.size(), false)) {
                return ItemStack.EMPTY;
            }

            if (originalStack.isEmpty()) {
                slot.setStack(ItemStack.EMPTY);
            } else {
                slot.markDirty();
            }
        }
        return newStack;
    }

    @Override
    public boolean canUse(PlayerEntity player) {
        return this.inventory.canPlayerUse(player);
    }

    private void addPlayerInventory(PlayerInventory playerInventory) {
        for(int i = 0; i < 3; i++) {
            for(int l = 0; l < 9; l++) {
                this.addSlot(new Slot(playerInventory, l + i * 9 + 9, 8 + l * 18, 84 + i * 18));
            }
        }
    }

    private void addPlayerHotbar(PlayerInventory playerInventory) {
        for(int l = 0; l < 9; l++) {
            this.addSlot(new Slot(playerInventory, l, 8 + l * 18, 142));
        }
    }

    public EnchantmentUpgraderOutput getOutput() {
        return output;
    }
}
