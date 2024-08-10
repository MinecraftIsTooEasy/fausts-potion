package huix.faustpotion.game_objects.material

import net.minecraft.Material

class FPMaterialsKt {

    companion object {
        val gravel = Material("gravel")

        val zinc = FPMetalMaterials(FPEquipmentMaterialsKt.ZINC, 2)
        val aluminum = FPMetalMaterials(FPEquipmentMaterialsKt.ALUMINUM, 2)
        val tin = FPMetalMaterials(FPEquipmentMaterialsKt.TIN, 2)
        val nickel = FPMetalMaterials(FPEquipmentMaterialsKt.NICKEL, 2)
        val lead = FPMetalMaterials(FPEquipmentMaterialsKt.LEAD, 2)
        val platinum = FPMetalMaterials(FPEquipmentMaterialsKt.PLATINUM, 2)
        val uranium = FPMetalMaterials(FPEquipmentMaterialsKt.URANIUM, 4)

    }
}