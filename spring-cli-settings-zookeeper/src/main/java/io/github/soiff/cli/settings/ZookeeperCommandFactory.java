package io.github.soiff.cli.settings;

import org.springframework.boot.cli.command.Command;
import org.springframework.boot.cli.command.CommandFactory;

import java.util.Collection;
import java.util.Collections;

/**
 * Created by zhangh on 12/5/2016.
 *
 * @author : wittcnezh@foxmail.com
 * @version : 1.0.0
 * @since : 1.8
 */
public class ZookeeperCommandFactory implements CommandFactory {
    @Override
    public Collection<Command> getCommands() {
        return Collections.singletonList(new YmlTransferCommand());
    }
}
