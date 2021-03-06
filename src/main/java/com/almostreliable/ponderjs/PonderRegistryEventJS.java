package com.almostreliable.ponderjs;

import com.almostreliable.ponderjs.util.PonderPlatform;
import dev.latvian.mods.kubejs.event.EventJS;
import dev.latvian.mods.kubejs.item.ingredient.IngredientJS;
import dev.latvian.mods.kubejs.util.ConsoleJS;
import net.minecraft.core.particles.SimpleParticleType;

public class PonderRegistryEventJS extends EventJS {

    public PonderRegistryEventJS() {
        PonderJS.STORIES_MANAGER.clear();
    }

    public PonderBuilderJS create(IngredientJS ingredient) {
        if (ingredient.isEmpty()) {
            throw new IllegalArgumentException("Provided items must not be empty!");
        }
        return new PonderBuilderJS(ingredient.getVanillaItems());
    }

    public void printParticleNames() {
        StringBuilder sb = new StringBuilder();
        sb.append("\n").append("### Particles ###").append("\n");
        PonderPlatform.getParticleTypes()
                .filter(SimpleParticleType.class::isInstance)
                .map(PonderPlatform::getParticleTypeName)
                .sorted()
                .forEach(id -> sb.append(" - ").append(id).append("\n"));
        ConsoleJS.CLIENT.info(sb.toString());
    }
}
