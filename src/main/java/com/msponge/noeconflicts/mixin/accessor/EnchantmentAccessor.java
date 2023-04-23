package com.msponge.noeconflicts.mixin.accessor;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentTarget;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;


@Mixin(Enchantment.class)
public interface EnchantmentAccessor {
    @Accessor("type")
    void setType(EnchantmentTarget type);
}
