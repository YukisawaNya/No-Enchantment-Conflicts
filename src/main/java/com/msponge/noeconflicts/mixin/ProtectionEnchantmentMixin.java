package com.msponge.noeconflicts.mixin;

import com.msponge.noeconflicts.mixin.accessor.EnchantmentAccessor;
import org.spongepowered.asm.mixin.Mixin;
import net.minecraft.enchantment.ProtectionEnchantment;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentTarget;
import net.minecraft.entity.EquipmentSlot;

import com.msponge.noeconflicts.config.Config;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(ProtectionEnchantment.class)
public abstract class ProtectionEnchantmentMixin extends Enchantment implements EnchantmentAccessor {
    public ProtectionEnchantmentMixin(Rarity weight, EquipmentSlot... slotTypes) {
		super(weight, EnchantmentTarget.ARMOR, slotTypes);
	}

    @Inject(method = "<init>", at = @At("RETURN"))
    public void init(Rarity weight, ProtectionEnchantment.Type protectionType, EquipmentSlot[] slotTypes, CallbackInfo ci) {
        if(protectionType == ProtectionEnchantment.Type.FALL) {
            this.setType(EnchantmentTarget.ARMOR);
        }
    }

    @Override
    public boolean canAccept(Enchantment other) {
        if (!Config.INSTANCE.ProtectionEnchantments) {
            if (other instanceof ProtectionEnchantment) {
                return false;
            }
        }
        return super.canAccept(other);
    }
}
