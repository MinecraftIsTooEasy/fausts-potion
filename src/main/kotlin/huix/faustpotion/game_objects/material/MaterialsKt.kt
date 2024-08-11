package huix.faustpotion.game_objects.material

import net.minecraft.EnumEquipmentMaterial
import net.minecraft.Material
import net.xiaoyu233.fml.util.ReflectHelper

class MaterialsKt(){

    companion object {
        val gravel = Material("gravel")

        val zinc = MetalMaterials(EquipmentMaterialsKt.ZINC, 2)
        val aluminum = MetalMaterials(EquipmentMaterialsKt.ALUMINUM, 2)
        val tin = MetalMaterials(EquipmentMaterialsKt.TIN, 2)
        val nickel = MetalMaterials(EquipmentMaterialsKt.NICKEL, 2)
        val lead = MetalMaterials(EquipmentMaterialsKt.LEAD, 2)
        val platinum = MetalMaterials(EquipmentMaterialsKt.PLATINUM, 2)
        val uranium = MetalMaterials(EquipmentMaterialsKt.URANIUM, 4)

        val bronze = MetalMaterials(EquipmentMaterialsKt.BRONZE, 3)
        val pig_iron = MetalMaterials(EquipmentMaterialsKt.PIG_IRON, 3)
        val steel = MetalMaterials(EquipmentMaterialsKt.STEEL, 3)
    }
}