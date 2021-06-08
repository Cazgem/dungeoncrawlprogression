package com.cazgem.dungeoncrawlprogression.config;
import com.electronwill.nightconfig.core.file.CommentedFileConfig;
import com.electronwill.nightconfig.core.io.WritingMode;
import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.common.ForgeConfigSpec.BooleanValue;
//import net.minecraftforge.common.ForgeConfigSpec.DoubleValue;
//import net.minecraftforge.common.ForgeConfigSpec.IntValue;
import java.nio.file.Path;
public class Config {
    public static final String GENERAL = "general";
    public static final String MODS = "mods";

    public static final ForgeConfigSpec.Builder BUILDER = new ForgeConfigSpec.Builder();

    public static final ForgeConfigSpec CONFIG;

    public static final BooleanValue  ENABLE_TOOLS, ASTRAL_SORCERY, BLOOD_MAGIC, APPLIED_ENERGISTICS, BOTANIA;

    static {
        BUILDER.comment("General Settings").push(GENERAL);

        ENABLE_TOOLS = BUILDER.comment("Enables the dungeon crawl progression developer tools.").define("enable_tools", false);

        BUILDER.pop();
        BUILDER.comment("Mod Settings").push(GENERAL);
        BUILDER.comment("Enable/Disable Mod-Specific Loot. DO NOT ENABLE FOR MODS NOT IN ACTIVE USE IN YOUR MODPACK! HERE BE DARGONS!").push(GENERAL);
        ASTRAL_SORCERY = BUILDER.define("astral_sorcery", false);
        BLOOD_MAGIC = BUILDER.define("blood_magic", false);
        BOTANIA = BUILDER.define("botania", false);
        APPLIED_ENERGISTICS = BUILDER.define("applied_energistics", false);

        BUILDER.pop();

        CONFIG = BUILDER.build();
    }

    public static void load(Path path) {
        final CommentedFileConfig config = CommentedFileConfig.builder(path).sync().autosave()
                .writingMode(WritingMode.REPLACE).build();
        config.load();
        CONFIG.setConfig(config);
    }
}
