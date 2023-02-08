/*
 * Copyright (c) 2023 - present | LuciferMorningstarDev <contact@lucifer-morningstar.dev>
 * Copyright (c) 2023 - present | upcraftmc.de <contact@surviv.fun>
 * Copyright (c) 2023 - present | upcraftmc.de team and contributors
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <https://www.gnu.org/licenses/>.
 */

package de.upcraftmc.dependencies;

import lombok.Getter;
import org.bukkit.plugin.java.JavaPlugin;

/**
 * UpDependencies; de.upcraftmc.dependencies:DependenciesPlugin
 *
 * @author <a href="https://github.com/LuciferMorningstarDev">LuciferMorningstarDev</a>
 * @since 08.02.2023
 */
public class DependenciesPlugin extends JavaPlugin {

    @Getter
    private static DependenciesPlugin instance;

    @Override
    public void onLoad() {
        // throw runtime exception to stop plugin
        if (instance != null) {
            throw new RuntimeException("This plugin can only be loaded once... Please restart the server.");
        }
        instance = this;
    }

    @Override
    public void onEnable() {
    }

    @Override
    public void onDisable() {
    }

}
