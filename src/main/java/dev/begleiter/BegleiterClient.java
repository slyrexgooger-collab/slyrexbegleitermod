package dev.begleiter;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper;
import net.fabricmc.fabric.api.client.networking.v1.ClientPlayConnectionEvents;
import net.minecraft.client.option.KeyBinding;
import net.minecraft.client.util.InputUtil;
import net.minecraft.util.Identifier;
import org.lwjgl.glfw.GLFW;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BegleiterClient implements ClientModInitializer {
    public static final String MOD_ID = "begleiter";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

    public static KeyBinding menuKey;
    public static KeyBinding talkKey;

    @Override
    public void onInitializeClient() {
        Config.load();

        KeyBinding.Category category = KeyBinding.Category.create(Identifier.of(MOD_ID, "main"));

        menuKey = KeyBindingHelper.registerKeyBinding(new KeyBinding(
                "key.begleiter.menu", InputUtil.Type.KEYSYM, GLFW.GLFW_KEY_K, category));
        talkKey = KeyBindingHelper.registerKeyBinding(new KeyBinding(
                "key.begleiter.talk", InputUtil.Type.KEYSYM, GLFW.GLFW_KEY_G, category));

        ClientTickEvents.END_CLIENT_TICK.register(CompanionManager::tick);
        ClientPlayConnectionEvents.DISCONNECT.register((handler, client) -> CompanionManager.forget());

        String skin = Config.get().skinName;
        if (skin != null && !skin.isBlank()) {
            SkinManager.load(skin);
        }
    }
}
