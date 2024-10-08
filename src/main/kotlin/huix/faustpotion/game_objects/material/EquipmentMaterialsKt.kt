package huix.faustpotion.game_objects.material

import com.chocohead.mm.api.ClassTinkerers
import net.minecraft.EnumEquipmentMaterial

class EquipmentMaterialsKt {
    companion object {
        val ZINC = ClassTinkerers.getEnum(EnumEquipmentMaterial::class.java, "ZINC")
        val ALUMINUM = ClassTinkerers.getEnum(EnumEquipmentMaterial::class.java, "ALUMINUM")
        val TIN = ClassTinkerers.getEnum(EnumEquipmentMaterial::class.java, "TIN")
        val NICKEL = ClassTinkerers.getEnum(EnumEquipmentMaterial::class.java, "NICKEL")
        val LEAD = ClassTinkerers.getEnum(EnumEquipmentMaterial::class.java, "LEAD")
        val PLATINUM = ClassTinkerers.getEnum(EnumEquipmentMaterial::class.java, "PLATINUM")
        val URANIUM = ClassTinkerers.getEnum(EnumEquipmentMaterial::class.java, "URANIUM")

        val BRONZE = ClassTinkerers.getEnum(EnumEquipmentMaterial::class.java, "BRONZE")
        val PIG_IRON = ClassTinkerers.getEnum(EnumEquipmentMaterial::class.java, "PIG_IRON")
        val STEEL = ClassTinkerers.getEnum(EnumEquipmentMaterial::class.java, "STEEL")

    }
}