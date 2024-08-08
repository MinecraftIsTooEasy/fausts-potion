package huix.faustpotion.start


import net.fabricmc.loader.api.entrypoint.PreLaunchEntrypoint
import net.minecraft.EnumQuality
import net.xiaoyu233.fml.util.EnumExtends

class EntrypointKt : PreLaunchEntrypoint {

    override fun onPreLaunch() {
        EnumExtends.EQUIPMENT_MATERIAL.addEnum("ZINC") {
            arrayOf<Any>(3.5F, 90, EnumQuality.fine, "zinc") }
        EnumExtends.EQUIPMENT_MATERIAL.addEnum("ALUMINUM") {
            arrayOf<Any>(3.75F, 70, EnumQuality.average, "aluminum") }
        EnumExtends.EQUIPMENT_MATERIAL.addEnum("TIN") {
            arrayOf<Any>(16F, 40, EnumQuality.fine, "tin") }
        EnumExtends.EQUIPMENT_MATERIAL.addEnum("NICKEL") {
            arrayOf<Any>(8.0F, 30, EnumQuality.average, "nickel") }
        EnumExtends.EQUIPMENT_MATERIAL.addEnum("LEAD") {
            arrayOf<Any>(5.0F, 60, EnumQuality.average, "lead") }
        EnumExtends.EQUIPMENT_MATERIAL.addEnum("PLATINUM") {
            arrayOf<Any>(3.0F, 20, EnumQuality.average, "platinum") }
        EnumExtends.EQUIPMENT_MATERIAL.addEnum("URANIUM") {
            arrayOf<Any>(9.0F, 80, EnumQuality.fine, "uranium") }
    }
}