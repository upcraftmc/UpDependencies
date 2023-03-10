/*
 * Copyright (c) 2023 - present | LuciferMorningstarDev <contact@lucifer-morningstar.dev>
 * Copyright (c) 2023 - present | upcraftmc.com <contact@upcraftmc.com>
 * Copyright (c) 2023 - present | upcraftmc.com team and contributors
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

import com.google.inject.Inject;
import com.velocitypowered.api.event.Subscribe;
import com.velocitypowered.api.event.proxy.ProxyInitializeEvent;
import com.velocitypowered.api.event.proxy.ProxyShutdownEvent;
import com.velocitypowered.api.plugin.Plugin;
import com.velocitypowered.api.plugin.annotation.DataDirectory;
import com.velocitypowered.api.proxy.ProxyServer;
import lombok.Getter;
import org.slf4j.Logger;

import java.io.File;
import java.nio.file.Path;

/**
 * UpDependencies; de.upcraftmc.dependencies:DependenciesPlugin
 *
 * @author <a href="https://github.com/LuciferMorningstarDev">LuciferMorningstarDev</a>
 * @since 08.02.2023
 */
@Plugin(id = "up-dependencies", name = "UpDependenciesPlugin", version = "1.0-SNAPSHOT", authors = {"LuciferMorningstarDev"}, url = "https://upcraftmc.de")
public class DependenciesPlugin {

    @Getter
    private static DependenciesPlugin instance;

    @Getter
    private ProxyServer server;
    @Getter
    private Logger logger;
    @Getter
    private @DataDirectory Path dataDir;
    @Getter
    private File dataFolder;

    @Inject
    public DependenciesPlugin(ProxyServer server, Logger logger, @DataDirectory Path dataDir) {
        this.server = server;
        this.logger = logger;
        this.dataFolder = dataDir.toFile();
        if (!this.dataFolder.exists()) {
            //this.dataFolder.mkdirs();
        }
        this.onLoad();
    }

    private void onLoad() {
        // throw runtime exception to stop plugin
        if (instance != null) {
            throw new RuntimeException("This plugin can only be loaded once... Please restart the server.");
        }
        instance = this;
    }

    @Subscribe
    public void initProxy(ProxyInitializeEvent event) {
    }

    @Subscribe
    public void onDisable(ProxyShutdownEvent event) {
    }

}
