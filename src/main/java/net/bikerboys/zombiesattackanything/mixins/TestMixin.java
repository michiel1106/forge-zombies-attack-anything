package net.bikerboys.zombiesattackanything.mixins;


import net.bikerboys.zombiesattackanything.ExampleMod;
import net.bikerboys.zombiesattackanything.util.ModTags;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.monster.Zombie;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraftforge.fml.common.Mod;
import org.checkerframework.checker.units.qual.A;
import org.openjdk.nashorn.internal.ir.annotations.Ignore;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;


@Mixin(Zombie.class)
public abstract class TestMixin extends Mob {

    public TestMixin(EntityType<? extends Zombie> p_34271_, Level p_34272_) {
        super(p_34271_, p_34272_);
    }

    @Inject(method = "addBehaviourGoals", at = @At("HEAD"))
    private void addthing(CallbackInfo ci) {
        System.out.println("Entity is whatever: " + ModTags.EntityTypes.ZOMBIE_FRIENDLY_TYPE);

        this.targetSelector.addGoal(4, new NearestAttackableTargetGoal<>(this, LivingEntity.class, 2, true, true,
                entity -> {
                    if (!entity.getType().is(ModTags.EntityTypes.ZOMBIE_FRIENDLY_TYPE)) {
                        return true;

                    }
                    return false;
                }
        ));
    }
}
