package com.msponge.noeconflicts.mixin;

import com.msponge.noeconflicts.config.Config;
import net.minecraft.enchantment.EnchantmentTarget;
import net.minecraft.item.Item;
import net.minecraft.item.SwordItem;
import net.minecraft.item.TridentItem;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(EnchantmentTarget.class)
public class EnchantmentTargetMixin {;
    @Inject(method = "isAcceptableItem", at = @At(value = "RETURN", target = "Lnet/minecraft/enchantment/EnchantmentTarget$6;isAcceptableItem(Lnet/minecraft/item/Item;)Z"), cancellable = true)
    public void isAcceptableItem(Item item, CallbackInfoReturnable<Boolean> cir) {
        if(!Config.INSTANCE.TridentAsWeapon) return;
        cir.setReturnValue(item instanceof SwordItem || item instanceof TridentItem);
    }

}
