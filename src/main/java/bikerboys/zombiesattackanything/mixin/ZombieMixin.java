package bikerboys.zombiesattackanything.mixin;

import bikerboys.zombiesattackanything.ZombiesAttackAnything;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.ai.goal.ActiveTargetGoal;
import net.minecraft.entity.mob.HostileEntity;
import net.minecraft.entity.mob.ZombieEntity;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(ZombieEntity.class)
public abstract class ZombieMixin extends HostileEntity {

	protected ZombieMixin(EntityType<? extends HostileEntity> entityType, World world) {
		super(entityType, world);
	}

	@Inject(method = "initCustomGoals", at = @At("HEAD"))
	private void addthing(CallbackInfo ci) {


		this.targetSelector.add(4, new ActiveTargetGoal<>(this, LivingEntity.class, 2, true, true,
				entity -> {
					if (!entity.getType().isIn(ZombiesAttackAnything.ZOMBIE_FRIENDLY)) {
						return true;

					}
					return false;
				}
		));
	}
}