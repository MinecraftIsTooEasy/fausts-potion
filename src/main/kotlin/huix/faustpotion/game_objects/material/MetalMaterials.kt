package huix.faustpotion.game_objects.material

import huix.faustpotion.game_objects.material.MaterialsKt.Companion.bronze
import huix.faustpotion.game_objects.material.MaterialsKt.Companion.steel
import net.minecraft.EnumEquipmentMaterial
import net.minecraft.Material

open class MetalMaterials(enum_crafting_material: EnumEquipmentMaterial) : Material(enum_crafting_material) {

     constructor(enum_crafting_material: EnumEquipmentMaterial, harvestLevel: Int) : this(enum_crafting_material) {
         this.setMinHarvestLevel(harvestLevel)
         this.setRequiresTool()
     }

    override fun getDamageVsEntity(): Float {
        return if (this == bronze) {
            3.0F
        } else if (this == steel) {
            5.0F
        } else {
            super.getDamageVsEntity()
        }
    }
}