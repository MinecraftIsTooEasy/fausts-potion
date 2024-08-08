package huix.faustpotion.game_objects.material

import net.minecraft.EnumEquipmentMaterial
import net.minecraft.Material

class FPMetalMaterials(enum_crafting_material: EnumEquipmentMaterial) : Material(enum_crafting_material) {

     constructor(enum_crafting_material: EnumEquipmentMaterial, harvestLevel: Int) : this(enum_crafting_material) {
         this.setMinHarvestLevel(harvestLevel)
         this.setRequiresTool()
     }
}